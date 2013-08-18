package com.sanyu.japanesegrammar.activity;

import java.util.ArrayList;
import java.util.List;

import com.sanyu.japanesegrammar.R;
import com.sanyu.japanesegrammar.domain.GrammarDetail;
import com.sanyu.japanesegrammar.domain.GrammarTitle;
import com.sanyu.japanesegrammar.service.GrammarService;
import com.sanyu.japanesegrammar.service.impl.GrammarServiceImpl;
import com.sanyu.japanesegrammar.util.OtherConstants;
import com.sanyu.japanesegrammar.util.SqlConstants;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.FrameLayout.LayoutParams;

public class GrammarDetailPage extends Activity {

	private GrammarService grammarService;
	
	private SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ActionBar actionBar = this.getActionBar();
		actionBar.setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP, ActionBar.DISPLAY_HOME_AS_UP);

		Integer grammarSeq = Integer.parseInt(getIntent().getStringExtra(OtherConstants.listSeq)) + 1;

		GrammarTitle grammarTitle = new GrammarTitle();
		grammarTitle.setGrammarSeq(grammarSeq.toString());

		setContentView(R.layout.grammardetail);
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
		List<String> list = new ArrayList<String>();
		GrammarDetail grammarDetail = grammarService.getGrammarDetail(db, grammarTitle);
		list.add(OtherConstants.detailTitle + grammarDetail.getTitle());
		list.add(OtherConstants.detailConjunction + grammarDetail.getConjunctionMethod());
		list.add(OtherConstants.detailUsage + grammarDetail.getUsage().get(0));
		list.add(OtherConstants.detailTranslation + grammarDetail.getTranslation().get(0));
		list.add(OtherConstants.detailExample + grammarDetail.getExample().get(0));
		list.add(OtherConstants.detailExTranslation + grammarDetail.getExTranslation().get(0));
		listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, list));
		addContentView(listView, params);
	}

}
