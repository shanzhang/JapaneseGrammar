package com.sanyu.jpgrammar.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.sanyu.jpgrammar.R;

@SuppressLint("ValidFragment")
public class BaseFragment extends Fragment {
	private Context context;

	public BaseFragment(Context context) {
		this.context = context;
	}

	public void setTitle(View v, String s) {
		AssetManager mgr = context.getAssets();
		Typeface tf = Typeface.createFromAsset(mgr, "fonts/Roboto-Light.ttf");
		TextView text = (TextView) v.findViewById(R.id.title);
		text.setTypeface(tf);
		text.setText(s);
	}
}
