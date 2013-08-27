package com.sanyu.jpgrammar.ui.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.sanyu.jpgrammar.R;
import com.sanyu.jpgrammar.ui.BaseFragment;
import com.sanyu.jpgrammar.ui.GrmListActivity;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

@SuppressLint({ "HandlerLeak", "ValidFragment" })
public class HomeFragment extends BaseFragment implements OnItemClickListener {

	private PullToRefreshListView refresh;

	private ListView listView;

	// private MainMenuLvAdapter adapter;

	public HomeFragment(Context context) {
		super(context);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_home, null);
		setTitle(view, "日语文法控");
		refresh = (PullToRefreshListView) view.findViewById(R.id.pull_refresh_list);
		refresh.setShowIndicator(false);
		refresh.setMode(Mode.BOTH);
		listView = refresh.getRefreshableView();

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>(4);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("menu_icon", R.drawable.n1);
		map.put("menu", "JLPT N1文法");
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("menu_icon", R.drawable.n2);
		map1.put("menu", "JLPT N1考核");
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("menu_icon", R.drawable.n1);
		map2.put("menu", "JLPT N2文法");
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("menu_icon", R.drawable.n2);
		map3.put("menu", "JLPT N2考核");
		list.add(map);
		list.add(map1);
		list.add(map2);
		list.add(map3);

		listView.setAdapter(new SimpleAdapter(getActivity(), list, R.layout.main_menu_item,
				new String[] {"menu_icon" ,"menu" }, new int[] {R.id.menu_icon, R.id.menu_name }));

		listView.setDivider(null);
		// adapter = new MainMenuLvAdapter(getActivity());
		// listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
		refresh.setRefreshing(false);
		return view;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		switch (position) {
		case 1:
			Intent i = new Intent(getActivity(), GrmListActivity.class);
			startActivity(i);
			break;

		default:
			Intent i1 = new Intent(getActivity(), GrmListActivity.class);
			startActivity(i1);
			break;
		}
	}
}
