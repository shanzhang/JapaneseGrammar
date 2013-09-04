package com.sanyu.jpgrammar.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.sanyu.jpgrammar.R;
import com.sanyu.jpgrammar.ui.fragment.FavorListFragment;
import com.sanyu.jpgrammar.util.StatusClass;

public class FavorActivity extends BaseActivity {

	public Fragment favfFragment;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		favfFragment = new FavorListFragment(this);

		setContentView(R.layout.frame_fav_list);
		getSupportFragmentManager().beginTransaction().replace(R.id.frame_fav_list, favfFragment).commit();
	}

	public void tabClickFav(View v) {
		switch (v.getId()) {
		case R.id.btn_fav_list:
			break;
		case R.id.fav_page_back:
			StatusClass.getInstance().previousFavPage();
			((FavorListFragment) favfFragment).refresh();
			break;
		case R.id.fav_page_forward:
			StatusClass.getInstance().nextFavPage();
			((FavorListFragment) favfFragment).refresh();
			break;
		}
	}
}
