package com.sanyu.japanesegrammar.activity;

import java.util.ArrayList;
import java.util.HashMap;

import com.sanyu.japanesegrammar.R;
import com.sanyu.japanesegrammar.util.OtherConstants;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;

public class Index extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.index);
		ActionBar actionBar = this.getActionBar();

		GridView gridview = (GridView) findViewById(R.id.gridView1);
		ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < 4; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			if (i == 0) {
				map.put("ItemImage", R.drawable.n1);
				map.put("ItemText", OtherConstants.n1String);
			}
			if (i == 1) {
				map.put("ItemImage", R.drawable.n2);
				map.put("ItemText", OtherConstants.n2String);
			}
			if (i == 2) {
				map.put("ItemImage", R.drawable.favor);
				map.put("ItemText", OtherConstants.favString);
			}
			if (i == 3) {
				map.put("ItemImage", R.drawable.exit);
				map.put("ItemText", OtherConstants.exitString);
			}
			lstImageItem.add(map);
		}
		SimpleAdapter saImageItems = new SimpleAdapter(this, lstImageItem, R.layout.menugrid, new String[] {
				"ItemImage", "ItemText" }, new int[] { R.id.ItemImage, R.id.ItemText });
		gridview.setAdapter(saImageItems);
		gridview.setOnItemClickListener(new ItemClickListener());
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
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	class ItemClickListener implements OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
			// HashMap<String, Object> item = (HashMap<String, Object>)
			// arg0.getItemAtPosition(arg2);
			// setTitle((String) item.get("ItemText"));
			switch (arg2) {
			case OtherConstants.n1Button:

				break;
			case OtherConstants.n2Button:
				Intent i = new Intent(Index.this, GrammarList.class);
				startActivity(i);
				break;
			case OtherConstants.favButton:

				break;
			case OtherConstants.exitButton:
				Index.this.finish();
				break;
			default:
				break;
			}
		}
	}

}
