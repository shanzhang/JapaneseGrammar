package com.sanyu.jpgrammar.ui.fragment;

import com.sanyu.jpgrammar.R;
import com.sanyu.jpgrammar.ui.SettingsActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;

public class SlidingRightFragment extends Fragment implements OnClickListener {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_menu_right, null);
		return view;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.settings:
			Intent intent = new Intent(getActivity(), SettingsActivity.class);
			this.getActivity().startActivity(intent);
			break;
		case R.id.exit:
			getActivity().finish();
			break;
		default:
			break;
		}
	}
}
