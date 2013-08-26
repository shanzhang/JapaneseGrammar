package com.sanyu.japanesegrammar.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

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

		setContentView(R.layout.grammar_list);

		dbInitService = new DbInitServiceImpl();
		grammarService = new GrammarServiceImpl();

		SQLiteDatabase db = openOrCreateDatabase(SqlConstants.DATABASE_NAME, Context.MODE_PRIVATE, null);
		AssetManager assetManager = getAssets();
		dbInitService.initDatabase(db, assetManager);

		FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
				FrameLayout.LayoutParams.WRAP_CONTENT);

		generateList(params, db);
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
			GrammarList.this.finish();
			break;
		}
		return super.onOptionsItemSelected(item);
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
//		listView.setSelector(android.R.drawable.alert_light_frame);
		List<Map<String, String>> list = new ArrayList<Map<String, String>>(count);
		for (int i = 0; i < count; i++) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("title", "ÎÄ·¨" + grammarService.getTotalGrammar(db).get(i).getGramSeq());
			map.put("info", grammarService.getTotalGrammar(db).get(i).getTitle());
			list.add(map);
		}
		listView.setAdapter(new SimpleAdapter(this, list, R.layout.textview_grammar, new String[] { "title", "info" },
				new int[] { R.id.title, R.id.info }));

		listView.setOnItemClickListener(listViewOnClickListener);
		addContentView(listView, params);
	}

}
