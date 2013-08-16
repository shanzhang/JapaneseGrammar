package com.sanyu.japanesegrammar.ui;

import java.util.ArrayList;
import java.util.List;

import com.sanyu.japanesegrammar.R;
import com.sanyu.japanesegrammar.service.DbInitService;
import com.sanyu.japanesegrammar.service.GrammarService;
import com.sanyu.japanesegrammar.service.impl.DbInitServiceImpl;
import com.sanyu.japanesegrammar.service.impl.GrammarServiceImpl;
import com.sanyu.japanesegrammar.util.OtherConstants;
import com.sanyu.japanesegrammar.util.SqlConstants;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class GrammarList extends Activity {

	private DbInitService dbInitService;

	private GrammarService grammarService;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.grammarlist);
		dbInitService = new DbInitServiceImpl();
		grammarService = new GrammarServiceImpl();

		SQLiteDatabase db = openOrCreateDatabase(SqlConstants.DATABASE_NAME, Context.MODE_PRIVATE, null);
		dbInitService.initDatabase(db);

		FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
				FrameLayout.LayoutParams.WRAP_CONTENT);

		generateList(params, db);
		db.close();

	}

	OnItemClickListener listViewOnClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
			Intent i = new Intent(GrammarList.this, GrammarDetailPage.class);
			i.putExtra(OtherConstants.listSeq, arg2 + "");
			startActivity(i);
		}

	};

	private void generateList(FrameLayout.LayoutParams params, SQLiteDatabase db) {
		int count = grammarService.getTotalGrammarNo(db);
		ListView listView = new ListView(this);
		List<String> list = new ArrayList<String>(count);
		for (int i = 0; i < count; i++) {
			list.add(listAligner(grammarService.getTotalGrammar(db).get(i).getGrammarSeq()) + ". "
					+ grammarService.getTotalGrammar(db).get(i).getTitle());
		}
		listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, list));

		listView.setOnItemClickListener(listViewOnClickListener);
		addContentView(listView, params);
	}

	private String listAligner(String str) {
		if (str.length() == 1) {
			return OtherConstants.textAlignStr + OtherConstants.textAlignStr + str;
		} else if (str.length() == 2) {
			return OtherConstants.textAlignStr + str;
		}
		return str;
	}
}
