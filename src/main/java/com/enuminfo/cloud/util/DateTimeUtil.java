package com.enuminfo.cloud.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateTimeUtil {
	private static final DateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd");
	private static final DateTimeUtil instance = new DateTimeUtil();

	private DateTimeUtil() {
	}

	public static DateTimeUtil getInstance() {
		return instance;
	}

	public java.sql.Timestamp convertUtilDate2Timestamp() {
		return new Timestamp(new java.util.Date().getTime());
	}

	public java.sql.Timestamp convertUtilDate2Timestamp(java.util.Date utilDate) {
		return new Timestamp(utilDate.getTime());
	}

	public List<String> getFinancialYearStartNEndDates() {
		List<String> dates = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		int financialMonth = 3;
		calendar.setTime(new Date());
		int financialYear = calendar.get(Calendar.YEAR);
		calendar.set(Calendar.DATE, 1);
		calendar.set(Calendar.MONTH, financialMonth);
		calendar.set(Calendar.YEAR, financialYear);
		dates.add(FORMATTER.format(calendar.getTime()));
		calendar.set(Calendar.DATE, 31);
		calendar.set(Calendar.MONTH, (financialMonth - 1));
		calendar.set(Calendar.YEAR, (financialYear + 1));
		dates.add(FORMATTER.format(calendar.getTime()));
		return dates;
	}
}
