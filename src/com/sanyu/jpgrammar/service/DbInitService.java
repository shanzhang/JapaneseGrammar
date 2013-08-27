package com.sanyu.jpgrammar.service;

import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;

public interface DbInitService {

	public void initDatabase(SQLiteDatabase db, AssetManager assetManager);

}
