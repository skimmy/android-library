package com.skimmy.androidutillibrary.filesystem;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesHelper {
	public static void saveFlaot(String key, float value, String pName,
			Context context) {
		SharedPreferences sPref = context.getSharedPreferences(pName,
				Context.MODE_PRIVATE);
		SharedPreferences.Editor pEditor = sPref.edit();
		pEditor.putFloat(key, value);
		pEditor.commit();
	}
	
	public static float getFloat(String key, String pName, Context context) {
		SharedPreferences sPref = context.getSharedPreferences(pName,
				Context.MODE_PRIVATE);
		return sPref.getFloat(key, 0);
	}
}
