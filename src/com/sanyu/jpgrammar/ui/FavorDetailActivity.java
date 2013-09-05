package com.sanyu.jpgrammar.ui;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

import com.sanyu.jpgrammar.R;
import com.sanyu.jpgrammar.domain.GrammarDetail;
import com.sanyu.jpgrammar.domain.GrammarTitle;
import com.sanyu.jpgrammar.service.GrammarService;
import com.sanyu.jpgrammar.service.impl.GrammarServiceImpl;
import com.sanyu.jpgrammar.ui.fragment.GrmDetailFragment;
import com.sanyu.jpgrammar.util.SqlConstants;
import com.sanyu.jpgrammar.util.StatusClass;

public class FavorDetailActivity extends BaseActivity {

	public Fragment favDetail;

	public GrammarService grammarService;

	public SQLiteDatabase db;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		favDetail = new GrmDetailFragment(this);
		grammarService = new GrammarServiceImpl();
		db = openOrCreateDatabase(SqlConstants.DATABASE_NAME, Context.MODE_PRIVATE, null);

		setContentView(R.layout.frame_fav_detail);
		getSupportFragmentManager().beginTransaction().replace(R.id.frame_fav_detail, favDetail).commit();
	}

	public void tabClickGrmDetail(View v) {
		switch (v.getId()) {
		case R.id.btn_grm_detail:
			GrammarTitle grammarTitle = new GrammarTitle();
			grammarTitle.setGramSeq(StatusClass.getInstance().getGramSeq().toString());
			GrammarDetail grammarDetail = new GrammarDetail();
			grammarDetail = grammarService.getGrammarDetail(db, grammarTitle);
			grammarService.addFavorites(db, grammarDetail);
			Toast.makeText(FavorDetailActivity.this, " ’≤ÿ≥…π¶", Toast.LENGTH_SHORT).show();
			break;
		case R.id.word_back:
			StatusClass.getInstance().previousWord();
			((GrmDetailFragment) favDetail).refresh();
			break;
		case R.id.word_forward:
			StatusClass.getInstance().nextWord();
			((GrmDetailFragment) favDetail).refresh();
			break;
		}
	}

}
