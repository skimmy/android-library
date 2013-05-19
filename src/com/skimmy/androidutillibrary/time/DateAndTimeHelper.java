package com.skimmy.androidutillibrary.time;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 
 * This class contains utility methods to manage date and time objects,
 * converting to and from strings and performing other common operations.
 * 
 * @author Michele Schimd
 * 
 */
public class DateAndTimeHelper {

	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss.SSS", Locale.US);

	/**
	 * This method returns the current timestamp of the UTC timezone. The returned
	 * string has the form 'YYYY-MM-DD HH:mm:ss.SSS' 
	 * 
	 * @return a string representing the current UTC timestamp
	 */
	public static String getCurrentUTCTimestampString() {
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		String gmtTime = simpleDateFormat.format(new Date());
		return gmtTime;
	}
}
