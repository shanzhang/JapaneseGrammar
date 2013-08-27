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
import com.sanyu.jpgrammar.ui.ExamActivity;

public class SlidingLeftFragment extends Fragment implements OnClickListener {
	
	private Button favorites;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_menu_left, null);
		favorites = (Button) view.findViewById(R.id.favorites);
		favorites.setOnClickListener(this);
		return view;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.favorites:
			Intent intent = new Intent(this.getActivity(), ExamActivity.class);
			this.getActivity().startActivity(intent);
			break;

		default:
			break;
		}
	}

}
