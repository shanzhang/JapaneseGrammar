package com.sanyu.jpgrammar.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.annotation.SuppressLint;

@SuppressLint("SimpleDateFormat")
public class TextUtil {

	public static String formatWBTime(String created) {
		String s = "";
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy",
					Locale.UK);
			SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = dateFormat.parse(created);
			Long l = date.getTime();
			Long now = System.currentTimeMillis();
			if ((now - l) < (1000 * 60)) {
				if (((now - l) / 60) > 0)
					s = (now - l) / 60 + "·ÖÖÓÇ°";
				else
					s = ((now - l) % 60) + "ÃëÇ°";
			} else {
				s = dateFormat2.format(date);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return s;
	}

	public static String formateSource(String str) {
		String s = "";
		String[] ss = str.split(">");
		s = ss[1].split("<")[0];

		return s;
	}
}
