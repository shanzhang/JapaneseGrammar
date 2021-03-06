package com.sanyu.jpgrammar.service;

import java.util.ArrayList;

import android.database.sqlite.SQLiteDatabase;

import com.sanyu.jpgrammar.domain.GrammarDetail;
import com.sanyu.jpgrammar.domain.GrammarTitle;

public interface GrammarService {

	public ArrayList<GrammarTitle> getTotalGrammar(SQLiteDatabase db, String offset);

	public ArrayList<GrammarTitle> getTotalFavorites(SQLiteDatabase db, String offset);

	public Integer getTotalGrammarNo(SQLiteDatabase db);

	public Integer getTotalFavoritesNo(SQLiteDatabase db);

	public GrammarDetail getGrammarDetail(SQLiteDatabase db, GrammarTitle grammarTitle);

	public void addFavorites(SQLiteDatabase db, GrammarDetail grammarDetail);

	public void cancelFavorites(SQLiteDatabase db, GrammarDetail grammarDetail);

}
