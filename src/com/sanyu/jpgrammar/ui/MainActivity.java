package com.sanyu.jpgrammar.ui;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.sanyu.jpgrammar.R;
import com.sanyu.jpgrammar.ui.fragment.HomeFragment;
import com.sanyu.jpgrammar.ui.fragment.SlidingLeftFragment;
import com.sanyu.jpgrammar.ui.fragment.SlidingRightFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {

	public Fragment mContent;

	public Fragment home;

	private static Boolean isExit = false;

	private static Boolean hasTask = false;

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

	Timer tExit = new Timer();

	TimerTask task = new TimerTask() {
		@Override
		public void run() {
			isExit = false;
			hasTask = true;
		}
	};

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		System.out.println("TabHost_Index.java onKeyDown");
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (isExit == false) {
				isExit = true;
				Toast.makeText(this, "�ٰ�һ�κ��˼��˳�Ӧ�ó���", Toast.LENGTH_SHORT).show();
				if (!hasTask) {
					tExit.schedule(task, 2000);
				}
			} else {
				MainActivity.this.finish();
				System.exit(0);
			}
		}
		return false;
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
			if (!to.isAdded()) { // ���ж��Ƿ�add��
				// ���ص�ǰ��fragment��add��һ����fragment��
				transaction.hide(from).add(R.id.frame_home, to).commit();
			} else {
				// ���ص�ǰ��fragment����ʾ��һ��
				transaction.hide(from).show(to).commit();
			}
		}
	}

}
