package com.skimmy.androidutillibrary.time;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateAndTimeHelper {

	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss.SSS", Locale.US);

	public static String getCurrentUTCTimestampString() {
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		String gmtTime = simpleDateFormat.format(new Date());
		return gmtTime;
	}
}
