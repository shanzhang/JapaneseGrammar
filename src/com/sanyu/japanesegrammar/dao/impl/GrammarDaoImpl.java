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
		Cursor cursor = db.rawQuery(SqlConstants.fetchGrammarTitle, null);
		while (cursor.moveToNext()) {
			GrammarTitle temp = new GrammarTitle();
			temp.setGrammarSeq(cursor.getString(cursor.getColumnIndex("GRAMMAR_SEQ")));
			temp.setTitle(cursor.getString(cursor.getColumnIndex("GRAMMAR_TITLE")));
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
		Cursor cursor = db.rawQuery(SqlConstants.fetchGrammarDetail, new String[] { grammarTitle.getGrammarSeq() });
		cursor.moveToNext();
		GrammarDetail grammarDetail = new GrammarDetail();
		grammarDetail.setGrammarSeq(cursor.getString(cursor.getColumnIndex("GRAMMAR_SEQ")));
		grammarDetail.setTitle(cursor.getString(cursor.getColumnIndex("GRAMMAR_TITLE")));
		grammarDetail.setConjunctionMethod(cursor.getString(cursor.getColumnIndex("CONJUNCTION")));
		ArrayList<String> usage = new ArrayList<String>();
		usage.add(cursor.getString(cursor.getColumnIndex("USAGE1")));
		ArrayList<String> translation = new ArrayList<String>();
		translation.add(cursor.getString(cursor.getColumnIndex("TRANSLATION1")));
		ArrayList<String> example = new ArrayList<String>();
		example.add(cursor.getString(cursor.getColumnIndex("EXAMPLE1")));
		ArrayList<String> exTranslation = new ArrayList<String>();
		exTranslation.add(cursor.getString(cursor.getColumnIndex("EX_TRANS1")));
		grammarDetail.setUsage(usage);
		grammarDetail.setTranslation(translation);
		grammarDetail.setExample(example);
		grammarDetail.setExTranslation(exTranslation);
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
		Cursor cursor = db.rawQuery(SqlConstants.fetchGrammarNo, null);
		cursor.moveToNext();
		Integer no = cursor.getInt(cursor.getColumnIndex("count"));
		cursor.close();
		return no;
	}

	@Override
	public Integer getTotalFavoritesNo(SQLiteDatabase db) {
		Cursor cursor = db.rawQuery(SqlConstants.fetchGrammarFavoritesNo, null);
		cursor.moveToNext();
		Integer no = cursor.getInt(cursor.getColumnIndex("count"));
		cursor.close();
		return no;
	}

}
