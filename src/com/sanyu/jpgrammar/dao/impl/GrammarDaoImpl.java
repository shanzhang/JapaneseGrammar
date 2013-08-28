package com.sanyu.jpgrammar.dao.impl;

import java.util.ArrayList;
import com.sanyu.jpgrammar.dao.GrammarDao;
import com.sanyu.jpgrammar.domain.GrammarDetail;
import com.sanyu.jpgrammar.domain.GrammarTitle;
import com.sanyu.jpgrammar.util.SqlConstants;
import com.sanyu.jpgrammar.util.StatusClass;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class GrammarDaoImpl implements GrammarDao {
	
	private Integer nLevel;
	
	public GrammarDaoImpl(){
		nLevel = Integer.parseInt(StatusClass.getStatusClass().getLevel());
	}

	public ArrayList<GrammarTitle> getTotalGrammar(SQLiteDatabase db) {
		ArrayList<GrammarTitle> gTitles = new ArrayList<GrammarTitle>();
		Cursor cursor = null;
		if (nLevel.equals(1)) {
			cursor = db.rawQuery(SqlConstants.getN1GramTitle, null);
		}
		if (nLevel.equals(2)) {
			cursor = db.rawQuery(SqlConstants.getN2GramTitle, null);
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
	public ArrayList<GrammarTitle> getTotalFavorites(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		return null;
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
		return grammarDetail;
	}

	@Override
	public void addFavorites(SQLiteDatabase db, GrammarDetail grammarDetail) {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancelFavorites(SQLiteDatabase db, GrammarDetail grammarDetail) {
		// TODO Auto-generated method stub

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
		Cursor cursor = db.rawQuery(SqlConstants.getFavGramNo, null);
		cursor.moveToNext();
		Integer no = cursor.getInt(cursor.getColumnIndex("count"));
		cursor.close();
		return no;
	}

}
