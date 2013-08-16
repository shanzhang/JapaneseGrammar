package com.sanyu.japanesegrammar.service.impl;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.sanyu.japanesegrammar.service.DbInitService;
import com.sanyu.japanesegrammar.util.SqlConstants;

public class DbInitServiceImpl implements DbInitService {

	@Override
	public void initDatabase(SQLiteDatabase db) {
		db.execSQL(SqlConstants.createGrammarTable);
		db.execSQL(SqlConstants.createFavoriteTable);
		if (checkHasData(db)) {
			db.execSQL(SqlConstants.insertGrammar);
		}
	}

	private boolean checkHasData(SQLiteDatabase db) {
		Cursor cursor = db.rawQuery(SqlConstants.fetchGrammarNo, null);
		cursor.moveToNext();
		int no = cursor.getInt(cursor.getColumnIndex("count"));
		return no > 0 ? false : true;
	}

}
