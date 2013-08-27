package com.sanyu.jpgrammar.service.impl;

import java.util.ArrayList;

import android.database.sqlite.SQLiteDatabase;

import com.sanyu.jpgrammar.dao.GrammarDao;
import com.sanyu.jpgrammar.dao.impl.GrammarDaoImpl;
import com.sanyu.jpgrammar.domain.GrammarDetail;
import com.sanyu.jpgrammar.domain.GrammarTitle;
import com.sanyu.jpgrammar.service.GrammarService;

public class GrammarServiceImpl implements GrammarService {

	private GrammarDao grammarDao;

	public GrammarServiceImpl() {
		grammarDao = new GrammarDaoImpl();
	}

	@Override
	public ArrayList<GrammarTitle> getTotalGrammar(SQLiteDatabase db) {
		return grammarDao.getTotalGrammar(db);
	}

	@Override
	public ArrayList<GrammarTitle> getTotalFavorites(SQLiteDatabase db) {
		return grammarDao.getTotalFavorites(db);
	}

	@Override
	public GrammarDetail getGrammarDetail(SQLiteDatabase db, GrammarTitle grammarTitle) {
		return grammarDao.getGrammarDetail(db, grammarTitle);
	}

	@Override
	public void addFavorites(SQLiteDatabase db, GrammarDetail grammarDetail) {
		grammarDao.addFavorites(db, grammarDetail);
	}

	@Override
	public void cancelFavorites(SQLiteDatabase db, GrammarDetail grammarDetail) {
		grammarDao.cancelFavorites(db, grammarDetail);
	}

	@Override
	public Integer getTotalGrammarNo(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		return grammarDao.getTotalGrammarNo(db);
	}

	@Override
	public Integer getTotalFavoritesNo(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		return grammarDao.getTotalFavoritesNo(db);
	}

}
