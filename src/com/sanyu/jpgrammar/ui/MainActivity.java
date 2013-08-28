package com.sanyu.jpgrammar.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;

import com.sanyu.jpgrammar.R;
import com.sanyu.jpgrammar.ui.fragment.HomeFragment;
import com.sanyu.jpgrammar.ui.fragment.SlidingLeftFragment;
import com.sanyu.jpgrammar.ui.fragment.SlidingRightFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {

	public Fragment mContent;
	
	public Fragment home;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		SlidingMenu sm = getSlidingMenu();
		sm.setShadowWidthRes(R.dimen.shadow_width);
		sm.setShadowDrawable(R.drawable.shadow);
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setFadeDegree(0.50f);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
		getActionBar().hide();

		home = new HomeFragment(this);
		mContent = home;

		setContentView(R.layout.frame_home);
		getSupportFragmentManager().beginTransaction().replace(R.id.frame_home, home).commit();

		setBehindContentView(R.layout.frame_menu_left);
		getSupportFragmentManager().beginTransaction().replace(R.id.frame_menu_left, new SlidingLeftFragment())
				.commit();

		sm.setMode(SlidingMenu.LEFT_RIGHT);
		sm.setSecondaryMenu(R.layout.frame_menu_right);
		sm.setSecondaryShadowDrawable(R.drawable.shadowright);
		getSupportFragmentManager().beginTransaction().replace(R.id.frame_menu_right, new SlidingRightFragment())
				.commit();
		
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if(mContent == home)
				android.os.Process.killProcess(android.os.Process.myPid());
			return true;
		} else
			return super.onKeyDown(keyCode, event);
	}

	public void tabclick(View v) {
		switch (v.getId()) {
		case R.id.btn_home:
			switchContent(mContent, home);
			break;
		}
	}

	public void switchContent(Fragment from, Fragment to) {
		if (from != to) {
			mContent = to;
			FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
			if (!to.isAdded()) { // 先判断是否被add过
				// 隐藏当前的fragment，add下一个到fragment中
				transaction.hide(from).add(R.id.frame_home, to).commit();
			} else {
				// 隐藏当前的fragment，显示下一个
				transaction.hide(from).show(to).commit();
			}
		}
	}

}
