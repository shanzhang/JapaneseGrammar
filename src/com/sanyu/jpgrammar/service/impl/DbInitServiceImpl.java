package com.sanyu.jpgrammar.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.content.res.AssetManager;
//import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

import com.sanyu.jpgrammar.service.DbInitService;
//import com.sanyu.jpgrammar.util.SqlConstants;

public class DbInitServiceImpl implements DbInitService {

	@Override
	public void initDatabase(SQLiteDatabase db, AssetManager assetManager) {
		try {
			InputStream in = assetManager.open("init.sql");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
			String sqlReader = "";
			String sql = "";
			while ((sqlReader = bufferedReader.readLine()) != null) {
				sql = sql + "\n\r\n\r" + sqlReader;
				if (sqlReader.indexOf(';') > -1) {
					if (!TextUtils.isEmpty(sqlReader)) {
						db.execSQL(sql);
						sql = "";
					}
				}
			}
			bufferedReader.close();
			in.close();
		} catch (SQLException e) {
		} catch (IOException e) {
		}
	}

//	private boolean checkHasData(SQLiteDatabase db) {
//		Cursor cursor = db.rawQuery(SqlConstants.getN2GramNo, null);
//		cursor.moveToNext();
//		int no = cursor.getInt(cursor.getColumnIndex("count"));
//		return no > 0 ? true : false;
//	}

}
