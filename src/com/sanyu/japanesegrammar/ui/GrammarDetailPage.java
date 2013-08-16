package com.sanyu.japanesegrammar.ui;

import java.util.ArrayList;
import java.util.List;

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
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.FrameLayout.LayoutParams;

public class GrammarDetailPage extends Activity {

	private GrammarService grammarService;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Integer grammarSeq = Integer.parseInt(getIntent().getStringExtra(OtherConstants.listSeq)) + 1;

		GrammarTitle grammarTitle = new GrammarTitle();
		grammarTitle.setGrammarSeq(grammarSeq.toString());

		setContentView(R.layout.grammarlist);
		grammarService = new GrammarServiceImpl();

		SQLiteDatabase db = openOrCreateDatabase(SqlConstants.DATABASE_NAME, Context.MODE_PRIVATE, null);

		FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
				FrameLayout.LayoutParams.WRAP_CONTENT);

		generateDetailList(params, db, grammarTitle);
		db.close();

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
