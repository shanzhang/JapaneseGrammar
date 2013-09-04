package com.sanyu.jpgrammar.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.sanyu.jpgrammar.R;
import com.sanyu.jpgrammar.ui.FavorActivity;
import com.sanyu.jpgrammar.ui.RecommendActivity;
import com.sanyu.jpgrammar.ui.SearchGrmActivity;
import com.sanyu.jpgrammar.util.StatusClass;

public class SlidingLeftFragment extends Fragment implements OnClickListener {

	private Button favorites1;

	private Button favorites2;

	private Button searchGrm;

	private Button rcmApp;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_menu_left, null);
		favorites1 = (Button) view.findViewById(R.id.favorites1);
		favorites1.setOnClickListener(this);
		favorites2 = (Button) view.findViewById(R.id.favorites2);
		favorites2.setOnClickListener(this);
		searchGrm = (Button) view.findViewById(R.id.search_grammar);
		searchGrm.setOnClickListener(this);
		rcmApp = (Button) view.findViewById(R.id.rcm_app);
		rcmApp.setOnClickListener(this);
		return view;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.favorites1:
			StatusClass.getInstance().setLevel("1");
			Intent intent0 = new Intent(this.getActivity(), FavorActivity.class);
			this.getActivity().startActivity(intent0);
			break;
		case R.id.favorites2:
			StatusClass.getInstance().setLevel("2");
			Intent intent1 = new Intent(this.getActivity(), FavorActivity.class);
			this.getActivity().startActivity(intent1);
			break;
		case R.id.search_grammar:
			Intent intent3 = new Intent(this.getActivity(), SearchGrmActivity.class);
			this.getActivity().startActivity(intent3);
			break;
		case R.id.rcm_app:
			Intent intent4 = new Intent(this.getActivity(), RecommendActivity.class);
			this.getActivity().startActivity(intent4);
			break;

		default:
			break;
		}
	}

}
