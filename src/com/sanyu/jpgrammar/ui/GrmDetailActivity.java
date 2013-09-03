package com.sanyu.jpgrammar.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.sanyu.jpgrammar.R;
import com.sanyu.jpgrammar.ui.fragment.GrmDetailFragment;
import com.sanyu.jpgrammar.util.StatusClass;

public class GrmDetailActivity extends BaseActivity {

	public Fragment grmDetail;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		grmDetail = new GrmDetailFragment(this);

		setContentView(R.layout.frame_grm_detail);
		getSupportFragmentManager().beginTransaction().replace(R.id.frame_grm_detail, grmDetail).commit();
	}

	public void tabClickGrmDetail(View v) {
		switch (v.getId()) {
		case R.id.btn_grm_detail:
			break;
		case R.id.word_back:
			StatusClass.getInstance().previousWord();
			((GrmDetailFragment) grmDetail).refresh();
			break;
		case R.id.word_forward:
			StatusClass.getInstance().nextWord();
			((GrmDetailFragment) grmDetail).refresh();
			break;
		}
	}

}
