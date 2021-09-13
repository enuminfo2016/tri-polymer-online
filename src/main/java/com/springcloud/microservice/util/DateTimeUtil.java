/**
 * 
 */
package com.springcloud.microservice.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

/**
 * @author SIVA KUMAR
 */
public class DateTimeUtil {

	private static final DateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd");
	private static final DateTimeUtil instance = new DateTimeUtil();
	private DateTimeUtil() {}
	
	public static DateTimeUtil getInstance() {
		return instance;
	}

	public String convertTimestamp2Date(Timestamp timestamp) {
		String dateStr = null;
		if (timestamp != null) {
			Date date = new Date(timestamp.getTime());
			DateFormat formatter = new SimpleDateFormat(Constants.MM_DD_YYYY_DATE_FORMAT);
		    dateStr = formatter.format(date);
		}
		return dateStr;
	}
	
	public java.sql.Date convertString2SqlDate(String strDate) {
		DateFormat formatter = new SimpleDateFormat(Constants.YYYY_MM_DD_DATE_FORMAT);
        java.sql.Date convertedDate = null;
		try {
			convertedDate = (java.sql.Date) formatter.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        return convertedDate;
	}
	
	public java.util.Date convertString2UtilDate(String strDate) {
		DateFormat formatter = new SimpleDateFormat(Constants.YYYY_MM_DD_DATE_FORMAT);
        java.util.Date convertedDate = null;
		try {
			convertedDate = formatter.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        return convertedDate;
	}
	
	public java.sql.Time convertString2Time(String strTime) {
		DateFormat formatter = new SimpleDateFormat(Constants.HH_MM_TIME_FORMAT);
		java.sql.Time convertedTime = null;
		try {
			convertedTime = new java.sql.Time(formatter.parse(strTime).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return convertedTime;
	}
	
	public java.sql.Timestamp convertUtilDate2Timestamp() {
		java.util.Date utilDate = new java.util.Date(); 
		Timestamp timestamp = new Timestamp(utilDate.getTime());
		return timestamp;
	}
	
	public java.sql.Timestamp convertUtilDate2Timestamp(java.util.Date utilDate) {
		Timestamp timestamp = new Timestamp(utilDate.getTime());
		return timestamp;
	}
	
	public Date convertGMT2ISTDateTime(String datetime) {
		Date date = null;
		DateTimeFormatter parser = ISODateTimeFormat.dateTime();
        DateTime dTime = parser.parseDateTime(datetime);
        DateTimeFormatter formatter = DateTimeFormat.mediumDateTime();
        String strDate = formatter.print(dTime);
        DateFormat dateFormat = new SimpleDateFormat(Constants.DATE_TIME_FORMAT);
        try {
			date = dateFormat.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        return date;
	}
	
	public Date convertGMT2ISTDate(String datetime) {
		Date date = null;
		DateTimeFormatter parser = ISODateTimeFormat.dateTime();
        DateTime dTime = parser.parseDateTime(datetime);
        DateTimeFormatter formatter = DateTimeFormat.mediumDateTime();
        String strDate = formatter.print(dTime);
        DateFormat dateFormat = new SimpleDateFormat(Constants.DD_MMM_YYYY_DATE_FORMAT);
        try {
			date = dateFormat.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        return date;
	}
	
	public Date convertGMTTime2ISTDate(String datetime) {
		Date date = null;
		DateTimeFormatter parser = ISODateTimeFormat.dateTime();
        DateTime dTime = parser.parseDateTime(datetime);
        DateTimeFormatter formatter = DateTimeFormat.mediumDateTime();
        String strDate = formatter.print(dTime);
        DateFormat dateFormat = new SimpleDateFormat(Constants.ISO_DATE_TIME_FORMAT);
        try {
			date = dateFormat.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        return date;
	}
	
	public String convertGMT2ISTDateTimestamp(String datetime) {
		DateTimeFormatter parser = ISODateTimeFormat.dateTime();
        DateTime dTime = parser.parseDateTime(datetime);
        return dTime.toString();
	}
	
	public String convertSqlDate2String(String sqlDate) {
		String strDate = null;
		try {
			Date date = new SimpleDateFormat(Constants.YYYY_MM_DD_DATE_FORMAT).parse(sqlDate);
			strDate = new SimpleDateFormat(Constants.MM_DD_YYYY_DATE_FORMAT).format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return strDate;
	}
	
	public Date convertSqlDate2UtilDate(String sqlDate) {
		String covertedDate = convertSqlDate2String(sqlDate);
		Date resDate = new Date();
		if (covertedDate != null) {
			String[] strDate = covertedDate.split(Constants.SLASH);
			Calendar calendar = Calendar.getInstance();
			calendar.set(Integer.parseInt(strDate[2]), Integer.parseInt(strDate[0])-1, Integer.parseInt(strDate[1]));
			calendar.add(Calendar.DATE, 1);
			resDate = calendar.getTime();
		}
		return resDate;
	}
	
	public List<Date> getWeekStartNEndDates() {
		List<Date> dates = new ArrayList<>();
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - calendar.getFirstDayOfWeek();
		calendar.add(Calendar.DAY_OF_MONTH, -dayOfWeek);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		calendar.set(Calendar.MILLISECOND,0);
		dates.add(calendar.getTime());
		calendar.add(Calendar.DAY_OF_MONTH, 6); 
		dates.add(calendar.getTime());
		return dates;		
	}
	
	public List<Date> getMonthStartNEndDates() {
		List<Date> dates = new ArrayList<>();
		LocalDate today = LocalDate.now();
		dates.add(Date.from(today.withDayOfMonth(1).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		dates.add(Date.from(today.withDayOfMonth(today.lengthOfMonth()).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		return dates;		
	}
	
	public String getUtilDateToSpecifiedStringFormat(Date date) {
		DateFormat formatter = new SimpleDateFormat(Constants.DEFAULT_DATE_TIME_FORMAT);
		return formatter.format(date);
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
