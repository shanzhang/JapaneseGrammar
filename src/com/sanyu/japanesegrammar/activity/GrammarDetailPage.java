package com.sanyu.japanesegrammar.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sanyu.japanesegrammar.R;
import com.sanyu.japanesegrammar.domain.GrammarDetail;
import com.sanyu.japanesegrammar.domain.GrammarTitle;
import com.sanyu.japanesegrammar.service.GrammarService;
import com.sanyu.japanesegrammar.service.impl.GrammarServiceImpl;
import com.sanyu.japanesegrammar.util.OtherConstants;
import com.sanyu.japanesegrammar.util.SqlConstants;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.FrameLayout.LayoutParams;
import android.widget.SimpleAdapter;

public class GrammarDetailPage extends Activity {

	private GrammarService grammarService;

	private SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			GrammarDetailPage.this.finish();
			break;
		}
		return super.onOptionsItemSelected(item);
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
