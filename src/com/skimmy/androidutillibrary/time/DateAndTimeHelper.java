package com.skimmy.androidutillibrary.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import android.util.Log;

/**
 * 
 * This class contains utility methods to manage date and time objects,
 * converting to and from strings and performing other common operations.
 * 
 * @author Michele Schimd
 * 
 */
public class DateAndTimeHelper {

	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";

	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
			DATE_TIME_FORMAT, Locale.US);

	/**
	 * This method returns the current timestamp of the UTC timezone. The
	 * returned string has the form 'YYYY-MM-DD HH:mm:ss.SSS' defined in
	 * {@link #DATE_TIME_FORMAT}
	 * 
	 * @return a string representing the current UTC timestamp
	 */
	public static String getCurrentUTCTimestampString() {
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		String gmtTime = simpleDateFormat.format(new Date());
		return gmtTime;
	}

	/**
	 * This method parses a String object and returns the corresponding Date
	 * object. If <code>date</code> does not conform to the format define by
	 * {@link #DATE_TIME_FORMAT} the method returns <code>null</code> and prints
	 * the corresponding error message into the system log.
	 * 
	 * @param date
	 *            A {@link String} representing a UTC date and timestamp
	 * @return A {@link Date} object obtained from the input parameter or null
	 *         if it does not conform to the defined format
	 */
	public Date getUTCDateFromString(String date) {
		try {
			return simpleDateFormat.parse(date);
		} catch (ParseException e) {
			Log.e(DateAndTimeHelper.class.getName(), e.getMessage());
			Log.v(DateAndTimeHelper.class.getName(), e.getStackTrace()
					.toString());
		}
		return null;
	}
}
