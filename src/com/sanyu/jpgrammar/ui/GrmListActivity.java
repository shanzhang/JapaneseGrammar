package com.sanyu.jpgrammar.ui;

import com.sanyu.jpgrammar.R;
import com.sanyu.jpgrammar.ui.fragment.GrmListFragment;
import com.sanyu.jpgrammar.util.StatusClass;

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
			break;
		case R.id.page_back:
			StatusClass.getInstance().previousPage();
			((GrmListFragment) grmList).refresh();
			break;
		case R.id.page_forward:
			StatusClass.getInstance().nextPage();
			((GrmListFragment) grmList).refresh();
			break;
		}
	}

}
