package com.sanyu.jpgrammar.ui;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.sanyu.jpgrammar.R;

public class BaseActivity extends SherlockFragmentActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getSupportActionBar().hide();
	}

	public void setTitle(View v, String s) {
		AssetManager mgr = this.getAssets();
		Typeface tf = Typeface.createFromAsset(mgr, "fonts/Roboto-Light.ttf");
		TextView text = (TextView) v.findViewById(R.id.title);
		text.setTypeface(tf);
		text.setText(s);
	}
}
