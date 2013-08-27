package com.sanyu.jpgrammar.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sanyu.jpgrammar.R;
import com.sanyu.jpgrammar.domain.GrammarDetail;
import com.sanyu.jpgrammar.domain.GrammarTitle;
import com.sanyu.jpgrammar.service.GrammarService;
import com.sanyu.jpgrammar.service.impl.GrammarServiceImpl;
import com.sanyu.jpgrammar.util.OtherConstants;
import com.sanyu.jpgrammar.util.SqlConstants;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.FrameLayout.LayoutParams;
import android.widget.SimpleAdapter;

public class GrmDetailActivity extends Activity {

	private GrammarService grammarService;

	private SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActionBar().hide();
		Integer grammarSeq = Integer.parseInt(getIntent().getStringExtra(OtherConstants.listSeq)) + 1;

		GrammarTitle grammarTitle = new GrammarTitle();
		grammarTitle.setGramSeq(grammarSeq.toString());

		setContentView(R.layout.grammar_detail);
		grammarService = new GrammarServiceImpl();

		db = openOrCreateDatabase(SqlConstants.DATABASE_NAME, Context.MODE_PRIVATE, null);

		FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
				FrameLayout.LayoutParams.WRAP_CONTENT);

		generateDetailList(params, db, grammarTitle);
		db.close();

	}

	private void generateDetailList(LayoutParams params, SQLiteDatabase db, GrammarTitle grammarTitle) {
		ListView listView = new ListView(this);
		listView.setCacheColorHint(0);
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		GrammarDetail grammarDetail = grammarService.getGrammarDetail(db, grammarTitle);
		Map<String, String> map = new HashMap<String, String>();
		map.put("detail_title", grammarDetail.getTitle());
		map.put("detail_text", grammarDetail.getText());
		list.add(map);
		listView.setAdapter(new SimpleAdapter(this, list, R.layout.textview_dtl_grammar, new String[] { "detail_title",
				"detail_text" }, new int[] { R.id.detail_title, R.id.detail_text }));
		addContentView(listView, params);
	}
}
