package com.klst.edoc.untdid;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * date time format conversion used in edoc
 * 
 * @see https://service.unece.org/trade/untdid/d96b/uncl/uncl2379.htm
 *
 */
public class DateTimeFormats {

	// UNTDID 2379 Date/time/period format qualifier , see https://service.unece.org/trade/untdid/d96b/uncl/uncl2379.htm
	public static final String CCYYMMDD_QUALIFIER = "102";
	public static final String CCYYMMDD = "yyyyMMdd";

	public static final String CCYYMMDDHHMM_QUALIFIER = "203";
	public static final String CCYYMMDDHHMM = "yyyyMMddHHmm";

	public static Timestamp xmlGregorianCalendarToTs(XMLGregorianCalendar cal) {
		long timeInMillis = cal.toGregorianCalendar().getTimeInMillis();
		return new Timestamp(timeInMillis);
	}
	
	// UNTDID 2379 Format "102" : CCYYMMDD = "yyyyMMdd"
	public static Timestamp yyyyMMddToTs(String ymd) {
		Timestamp ts = null;
		try {
			DateFormat df = new SimpleDateFormat(CCYYMMDD);
			ts = new Timestamp(((java.util.Date)df.parse(ymd)).getTime());
		} catch (ParseException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return ts;	
	}
	
	// UNTDID 2379 Format "203" : CCYYMMDDHHMM = "yyyyMMddHHmm"
	public static Timestamp yyyyMMddhhmmToTs(String ymd) {
		Timestamp ts = null;
		try {
			DateFormat df = new SimpleDateFormat(CCYYMMDDHHMM);
			ts = new Timestamp(((java.util.Date)df.parse(ymd)).getTime());
		} catch (ParseException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return ts;	
	}
	public static Timestamp ymdToTs(String ymd, String format) {
		if(format.equals(CCYYMMDD_QUALIFIER)) {
			return yyyyMMddToTs(ymd);
		}
		if(format.equals(CCYYMMDDHHMM_QUALIFIER)) {
			return yyyyMMddhhmmToTs(ymd);
		}
		return ymdToTs(ymd);
	}
	
	public static Timestamp ymdToTs(String ymd) {
		Timestamp ts = null;
		if(ymd!=null) try {
			//Timestamp.valueOf("yyyy-[m]m-[d]d hh:mm:ss[.f...]"); // JDBC timestamp escape format
			ts = Timestamp.valueOf(ymd);
		} catch (IllegalArgumentException e) {
			try {
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date date = df.parse(ymd);
				return new Timestamp(date.getTime());
			} catch (ParseException ex) {
				// try UNTDID 2379 Format "102" : yyyyMMddToTs
			}
			ts = yyyyMMddToTs(ymd);
		}
		return ts;
	}
	
	public static XMLGregorianCalendar tsToXMLGregorianCalendar(Timestamp ts) {
        LocalDateTime ldt = ts.toLocalDateTime();
        XMLGregorianCalendar cal = null;
		try {
			cal = DatatypeFactory.newInstance().newXMLGregorianCalendar();
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        cal.setYear(ldt.getYear());
        cal.setMonth(ldt.getMonthValue());
        cal.setDay(ldt.getDayOfMonth());
        cal.setHour(ldt.getHour());
        cal.setMinute(ldt.getMinute());
        cal.setSecond(ldt.getSecond());
		return cal;
	}

	public static String tsToCCYYMMDD(Timestamp ts) {
		return new SimpleDateFormat(CCYYMMDD).format(ts);
	}

	public static String tsToCCYYMMDDHHMM(Timestamp ts) {
		return new SimpleDateFormat(CCYYMMDDHHMM).format(ts);
	}

	// opentrans dtDATETIME: example <ORDER_DATE>2009-05-13T06:20:00+01:00</ORDER_DATE>
	public static final String dtDATETIME = "yyyy-MM-dd'T'HH:mm:ssXXX";
	public static String tsTodtDATETIME(Timestamp ts) {
		return new SimpleDateFormat(dtDATETIME).format(ts);
	}
	public static Timestamp dtDATETIMEToTs(String dtDateTime) {
		Timestamp ts = null;
		if(dtDateTime!=null) try {
			//Timestamp.valueOf("yyyy-[m]m-[d]d hh:mm:ss[.f...]"); // JDBC timestamp escape format
			ts = Timestamp.valueOf(dtDateTime);
		} catch (IllegalArgumentException e) {
			try {
				DateFormat df = new SimpleDateFormat(dtDATETIME);
				java.util.Date date = df.parse(dtDateTime);
				return new Timestamp(date.getTime());
			} catch (ParseException ex) {
				// try UNTDID 2379 Format "102" : yyyyMMddToTs
			}
			ts = ymdToTs(dtDateTime);
		}
		return ts;
	}

}
