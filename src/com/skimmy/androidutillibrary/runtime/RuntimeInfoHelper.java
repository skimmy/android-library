package com.skimmy.androidutillibrary.runtime;


import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;

public class RuntimeInfoHelper {
	
	public static boolean isServiceRunning(Context ctx, String serviceClassName) {
		ActivityManager manager = (ActivityManager) ctx.getSystemService(Context.ACTIVITY_SERVICE);
		for (RunningServiceInfo serviceInfo : manager.getRunningServices(Integer.MAX_VALUE)) {
			if (serviceClassName.equals(serviceInfo.service.getClassName())) {
				return true;
			}
		}
		return false;
		
	}
}
