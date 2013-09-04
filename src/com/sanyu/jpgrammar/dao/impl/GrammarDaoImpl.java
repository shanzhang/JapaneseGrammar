package com.sanyu.jpgrammar.dao.impl;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sanyu.jpgrammar.dao.GrammarDao;
import com.sanyu.jpgrammar.domain.GrammarDetail;
import com.sanyu.jpgrammar.domain.GrammarTitle;
import com.sanyu.jpgrammar.util.SqlConstants;
import com.sanyu.jpgrammar.util.StatusClass;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class GrammarDaoImpl implements GrammarDao {

	private Integer nLevel;

	public GrammarDaoImpl() {
		nLevel = Integer.parseInt(StatusClass.getInstance().getLevel());
	}

	public ArrayList<GrammarTitle> getTotalGrammar(SQLiteDatabase db, String offset) {
		ArrayList<GrammarTitle> gTitles = new ArrayList<GrammarTitle>();
		Cursor cursor = null;
		if (nLevel.equals(1)) {
			cursor = db.rawQuery(SqlConstants.getN1GramTitlePrepend + offset + SqlConstants.getN1GramTitleTail, null);
		}
		if (nLevel.equals(2)) {
			cursor = db.rawQuery(SqlConstants.getN2GramTitlePrepend + offset + SqlConstants.getN2GramTitleTail, null);
		}
		if (cursor == null) {
			return null;
		}
		while (cursor.moveToNext()) {
			GrammarTitle temp = new GrammarTitle();
			temp.setGramSeq(cursor.getString(cursor.getColumnIndex("GRAM_SEQ")));
			temp.setTitle(cursor.getString(cursor.getColumnIndex("TITLE")));
			gTitles.add(temp);
		}
		cursor.close();
		return gTitles;
	}

	@Override
	public ArrayList<GrammarTitle> getTotalFavorites(SQLiteDatabase db, String offset) {
		ArrayList<GrammarTitle> gTitles = new ArrayList<GrammarTitle>();
		Cursor cursor = null;
		if (nLevel.equals(1)) {
			try {
				cursor = db.rawQuery(SqlConstants.getN1FavGramTitlePrepend + offset
						+ SqlConstants.getN1FavGramTitleTail, null);
			} catch (Exception e) {
				Log.e("sql", e.toString());
			}

		}
		if (nLevel.equals(2)) {
			cursor = db.rawQuery(SqlConstants.getN2FavGramTitlePrepend + offset + SqlConstants.getN2FavGramTitleTail,
					null);
		}
		if (cursor == null) {
			return null;
		}
		while (cursor.moveToNext()) {
			GrammarTitle temp = new GrammarTitle();
			temp.setGramSeq(cursor.getString(cursor.getColumnIndex("GRAM_SEQ")));
			temp.setTitle(cursor.getString(cursor.getColumnIndex("TITLE")));
			gTitles.add(temp);
		}
		cursor.close();
		return gTitles;
	}

	@Override
	public GrammarDetail getGrammarDetail(SQLiteDatabase db, GrammarTitle grammarTitle) {
		Cursor cursor = null;
		if (nLevel.equals(1)) {
			cursor = db.rawQuery(SqlConstants.getN1GramDetail, new String[] { grammarTitle.getGramSeq() });
		}
		if (nLevel.equals(2)) {
			cursor = db.rawQuery(SqlConstants.getN2GramDetail, new String[] { grammarTitle.getGramSeq() });
		}
		if (cursor == null) {
			return null;
		}
		cursor.moveToNext();
		GrammarDetail grammarDetail = new GrammarDetail();
		grammarDetail.setGramSeq(cursor.getString(cursor.getColumnIndex("GRAM_SEQ")));
		grammarDetail.setTitle(cursor.getString(cursor.getColumnIndex("TITLE")));
		grammarDetail.setText(cursor.getString(cursor.getColumnIndex("TEXT")));
		cursor.close();
		return grammarDetail;
	}

	@Override
	public void addFavorites(SQLiteDatabase db, GrammarDetail grammarDetail) {
		Pattern pattern = Pattern.compile("\r|\n");
		String col1 = grammarDetail.getGramSeq();
		String col2 = grammarDetail.getTitle();
		Matcher m1 = pattern.matcher(col1);
		Matcher m2 = pattern.matcher(col2);
		col1 = m1.replaceAll("");
		col2 = m2.replaceAll("");
		if (nLevel.equals(1)) {
			db.execSQL(SqlConstants.addFavorite, new Object[] { col1, col2, 1 });
		}
		if (nLevel.equals(2)) {
			db.execSQL(SqlConstants.addFavorite, new Object[] { col1, col2, 2 });
		}
	}

	@Override
	public void cancelFavorites(SQLiteDatabase db, GrammarDetail grammarDetail) {
		
	}

	@Override
	public Integer getTotalGrammarNo(SQLiteDatabase db) {
		Cursor cursor = null;
		if (nLevel.equals(1)) {
			cursor = db.rawQuery(SqlConstants.getN1GramNo, null);
		}
		if (nLevel.equals(2)) {
			cursor = db.rawQuery(SqlConstants.getN2GramNo, null);
		}
		if (cursor == null) {
			return null;
		}
		cursor.moveToNext();
		Integer no = cursor.getInt(cursor.getColumnIndex("count"));
		cursor.close();
		return no;
	}

	@Override
	public Integer getTotalFavoritesNo(SQLiteDatabase db) {
		Cursor cursor = null;
		if (nLevel.equals(1)) {
			cursor = db.rawQuery(SqlConstants.getN1FavGramNo, null);
		}
		if (nLevel.equals(2)) {
			cursor = db.rawQuery(SqlConstants.getN2FavGramNo, null);
		}
		if (cursor == null) {
			return null;
		}
		cursor.moveToNext();
		Integer no = cursor.getInt(cursor.getColumnIndex("count"));
		cursor.close();
		return no;
	}

}
