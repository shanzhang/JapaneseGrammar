package com.sanyu.japanesegrammar.service;

import java.util.ArrayList;

import android.database.sqlite.SQLiteDatabase;

import com.sanyu.japanesegrammar.domain.GrammarDetail;
import com.sanyu.japanesegrammar.domain.GrammarTitle;

public interface GrammarService {

	public ArrayList<GrammarTitle> getTotalGrammar(SQLiteDatabase db);

	public ArrayList<GrammarTitle> getTotalFavorites(SQLiteDatabase db);
	
	public Integer getTotalGrammarNo(SQLiteDatabase db);
	
	public Integer getTotalFavoritesNo(SQLiteDatabase db);

	public GrammarDetail getGrammarDetail(SQLiteDatabase db, GrammarTitle grammarTitle);

	public void addFavorites(SQLiteDatabase db, GrammarDetail grammarDetail);

	public void cancelFavorites(SQLiteDatabase db, GrammarDetail grammarDetail);

}
