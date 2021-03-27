package com.klst.edoc.api;

import java.sql.Timestamp;

/**
 * Period with Start and End Date
 * <p>
 * subclassed in e-invoice, e-order by
 * BG-14 PERIOD
 * and 
 * BG-26 LINE PERIOD
 */
public interface IPeriod extends IPeriodFactory {
	
	// factory: createPeriod(Timestamp start, Timestamp end);
	
//	public void setStartDate(Timestamp ts); // use factory
	public Timestamp getStartDateAsTimestamp();
	
//	public void setEndDate(Timestamp ts);   // use factory
	public Timestamp getEndDateAsTimestamp();
	
}
