package com.skimmy.androidutillibrary.filesystem;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * This class defines static methods to access {@link SharedPreferences} in
 * write and read mode. Methods allow to perform store and retrieve operations
 * passing all needed parameters without the caller needing to setup structures
 * for shared preferences management (<em>e.g.</em>
 * {@link SharedPreferences.Editor}). This class may not be suitable for bulk
 * store since it performs a <em>commit</em> for each retrieved value.
 * 
 * @author Michele Schimd
 * 
 */
public class SharedPreferencesHelper {

	public static boolean saveInt(String key, int value, String pName,
			Context context) {
		SharedPreferences sPref = context.getSharedPreferences(pName,
				Context.MODE_PRIVATE);
		SharedPreferences.Editor pEditor = sPref.edit();
		pEditor.putInt(key, value);
		return pEditor.commit();
	}

	public static boolean saveFlaot(String key, float value, String pName,
			Context context) {
		SharedPreferences sPref = context.getSharedPreferences(pName,
				Context.MODE_PRIVATE);
		SharedPreferences.Editor pEditor = sPref.edit();
		pEditor.putFloat(key, value);
		return pEditor.commit();
	}

	public static boolean saveString(String key, String value, String pName,
			Context context) {
		SharedPreferences sPref = context.getSharedPreferences(pName,
				Context.MODE_PRIVATE);
		SharedPreferences.Editor pEditor = sPref.edit();
		pEditor.putString(key, value);
		return pEditor.commit();
	}

	public static float getFloat(String key, String pName, Context context) {
		SharedPreferences sPref = context.getSharedPreferences(pName,
				Context.MODE_PRIVATE);
		return sPref.getFloat(key, 0.0f);
	}

	public static int getInt(String key, String pName, Context context) {
		SharedPreferences sPref = context.getSharedPreferences(pName,
				Context.MODE_PRIVATE);
		return sPref.getInt(key, 0);
	}

	public static String getString(String key, String pName, Context context) {
		SharedPreferences sPref = context.getSharedPreferences(pName,
				Context.MODE_PRIVATE);
		return sPref.getString(key, null);
	}
}
