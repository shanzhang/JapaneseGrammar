package com.sanyu.japanesegrammar.dao.impl;

import java.util.ArrayList;
import com.sanyu.japanesegrammar.dao.GrammarDao;
import com.sanyu.japanesegrammar.domain.GrammarDetail;
import com.sanyu.japanesegrammar.domain.GrammarTitle;
import com.sanyu.japanesegrammar.util.SqlConstants;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class GrammarDaoImpl implements GrammarDao {

	public ArrayList<GrammarTitle> getTotalGrammar(SQLiteDatabase db) {
		ArrayList<GrammarTitle> gTitles = new ArrayList<GrammarTitle>();
		Cursor cursor = db.rawQuery(SqlConstants.getN2GramTitle, null);
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
		Cursor cursor = db.rawQuery(SqlConstants.getGramDetail, new String[] { grammarTitle.getGramSeq() });
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
		Cursor cursor = db.rawQuery(SqlConstants.getN2GramNo, null);
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
