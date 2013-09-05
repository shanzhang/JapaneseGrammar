package com.sanyu.jpgrammar.ui;

import com.sanyu.jpgrammar.service.impl.DbInitServiceImpl;
import com.sanyu.jpgrammar.util.SqlConstants;
import com.sanyu.jpgrammar.service.DbInitService;
import com.sanyu.jpgrammar.R;
import com.sanyu.jpgrammar.util.SharedPreUtil;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

public class WelcomeActivity extends BaseActivity implements AnimationListener {

	private Animation mAlphaAnimation;

	private DbInitService dbInitService;

	private SQLiteDatabase db;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		mAlphaAnimation = new AlphaAnimation(1.0f, 1.0f);
		mAlphaAnimation.setAnimationListener(this);
		mAlphaAnimation.setDuration(500);
		findViewById(R.id.welcome).setAnimation(mAlphaAnimation);
	}

	@Override
	public void onAnimationStart(Animation animation) {
		dbInitService = new DbInitServiceImpl();
		db = openOrCreateDatabase(SqlConstants.DATABASE_NAME, Context.MODE_PRIVATE, null);
		AssetManager assetManager = getAssets();
		dbInitService.initDatabase(db, assetManager);
		db.close();
	}

	@Override
	public void onAnimationEnd(Animation animation) {
		SharedPreUtil.getSharedPreference(this);
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
		finish();
	}

	@Override
	public void onAnimationRepeat(Animation animation) {
	}
}
