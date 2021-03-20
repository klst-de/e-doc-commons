package com.klst.edoc.api;

import java.sql.Timestamp;

import com.klst.edoc.untdid.DateTimeFormats;

public interface IPeriodFactory {

	public IPeriod createPeriod(Timestamp start, Timestamp end);

	default IPeriod createPeriod(String ymdStart, String ymdEnd) {
		return createPeriod(DateTimeFormats.ymdToTs(ymdStart), DateTimeFormats.ymdToTs(ymdEnd));
	}

}
