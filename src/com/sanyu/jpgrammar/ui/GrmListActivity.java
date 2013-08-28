package com.sanyu.jpgrammar.ui;

import com.sanyu.jpgrammar.R;
import com.sanyu.jpgrammar.ui.fragment.GrmListFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

public class GrmListActivity extends BaseActivity {
	
	public Fragment grmList;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		grmList = new GrmListFragment(this);

		setContentView(R.layout.frame_grm_list);
		getSupportFragmentManager().beginTransaction().replace(R.id.frame_grm_list, grmList).commit();
	}
	
	public void tabClickGrmList(View v) {
		switch (v.getId()) {
		case R.id.btn_grm_list:
			Intent intent = new Intent(GrmListActivity.this, MainActivity.class);
			startActivity(intent);
			GrmListActivity.this.finish();
			break;
		}
	}

}
