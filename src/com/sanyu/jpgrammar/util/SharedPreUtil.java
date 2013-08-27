package com.sanyu.jpgrammar.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreUtil {
	private static SharedPreferences setting;

	public static SharedPreferences getSharedPreference(Context con) {
		if (setting == null)
			setting = con.getSharedPreferences(con.getPackageName() + "_preferences", 0);
		return setting;
	}

	public static String getString(String key) {
		return setting.getString(key, "");
	}

	public static boolean getBoolean(String key) {
		return setting.getBoolean(key, false);
	}

	public static void setString(String key, String value) {
		setting.edit().putString(key, value).commit();
	}

	public static void setBoolean(String key, boolean value) {
		setting.edit().putBoolean(key, value).commit();
	}

	public static void setInt(String key, int value) {
		setting.edit().putInt(key, value).commit();
	}

	public static int getInt(String key) {
		return setting.getInt(key, -1);
	}
}
