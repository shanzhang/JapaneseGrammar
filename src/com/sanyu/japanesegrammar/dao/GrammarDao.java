package com.sanyu.japanesegrammar.dao;

import java.util.ArrayList;

import android.database.sqlite.SQLiteDatabase;

import com.sanyu.japanesegrammar.domain.GrammarDetail;
import com.sanyu.japanesegrammar.domain.GrammarTitle;

public interface GrammarDao {

	public ArrayList<GrammarTitle> getTotalGrammar(SQLiteDatabase db);

	public ArrayList<GrammarTitle> getTotalFavorites(SQLiteDatabase db);

	public Integer getTotalGrammarNo(SQLiteDatabase db);

	public Integer getTotalFavoritesNo(SQLiteDatabase db);

	public GrammarDetail getGrammarDetail(SQLiteDatabase db, GrammarTitle grammarTitle);

	public void addFavorites(SQLiteDatabase db, GrammarDetail grammarDetail);

	public void cancelFavorites(SQLiteDatabase db, GrammarDetail grammarDetail);

}
