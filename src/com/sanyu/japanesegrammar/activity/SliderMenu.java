package com.sanyu.japanesegrammar.activity;

import java.util.ArrayList;
import java.util.HashMap;

import com.sanyu.japanesegrammar.util.OtherConstants;
import com.sanyu.japanesegrammar.view.HomeCenterLayout;
import com.sanyu.japanesegrammar.view.MyLinearLayout;
import com.sanyu.japanesegrammar.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class SliderMenu extends Activity {
	private com.sanyu.japanesegrammar.view.HomeCenterLayout centerLayout;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		LinearLayout leftLayout = (LinearLayout) findViewById(R.id.homeLeft);
		MyLinearLayout rightLayout = (MyLinearLayout) findViewById(R.id.homeRight);
		centerLayout = (HomeCenterLayout) findViewById(R.id.homeCenter);

		leftLayout.setVisibility(View.GONE);
		rightLayout.setVisibility(View.GONE);
		centerLayout.setBrotherLayout(leftLayout, rightLayout);
		ImageButton leftBtn = (ImageButton) findViewById(R.id.ivTitleBtnLeft);
		ImageButton rightBtn = (ImageButton) findViewById(R.id.ivTitleBtnRigh);
		leftBtn.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (centerLayout.getPage() == HomeCenterLayout.MIDDLE)
					centerLayout.setPage(HomeCenterLayout.LEFT);
				else
					centerLayout.setPage(HomeCenterLayout.MIDDLE);
			}
		});

		rightBtn.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (centerLayout.getPage() == HomeCenterLayout.MIDDLE)
					centerLayout.setPage(HomeCenterLayout.RIGHT);
				else
					centerLayout.setPage(HomeCenterLayout.MIDDLE);
			}
		});

		GridView gridview = (GridView) findViewById(R.id.gridView1);
		ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < 6; i++) {
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
				map.put("ItemImage", R.drawable.n1test);
				map.put("ItemText", OtherConstants.n1test);
			}
			if (i == 3) {
				map.put("ItemImage", R.drawable.n2test);
				map.put("ItemText", OtherConstants.n2test);
			}
			if (i == 4) {
				map.put("ItemImage", R.drawable.settings);
				map.put("ItemText", OtherConstants.settings);
			}
			if (i == 5) {
				map.put("ItemImage", R.drawable.exit);
				map.put("ItemText", OtherConstants.exitString);
			}
			lstImageItem.add(map);
		}
		SimpleAdapter saImageItems = new SimpleAdapter(this, lstImageItem, R.layout.menu_grid,
				new String[] { "ItemImage" }, new int[] { R.id.ItemImage });
		gridview.setAdapter(saImageItems);
		gridview.setOnItemClickListener(new ItemClickListener());
	}

	@Override
	public void onBackPressed() {
		if (centerLayout.getPage() != HomeCenterLayout.MIDDLE)
			centerLayout.setPage(HomeCenterLayout.MIDDLE);
		else
			super.onBackPressed();
	}

	class ItemClickListener implements OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
			switch (arg2) {
			case OtherConstants.n1Button:

				break;
			case OtherConstants.n2Button:
				Intent i = new Intent(SliderMenu.this, GrammarList.class);
				startActivity(i);
				break;
			case OtherConstants.n1TestButton:

				break;
			case OtherConstants.n2TestButton:

				break;
			case OtherConstants.settingsButton:

				break;
			case OtherConstants.exitButton:
				SliderMenu.this.finish();
				break;
			default:
				break;
			}
		}
	}
}