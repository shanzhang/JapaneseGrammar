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
import com.sanyu.jpgrammar.ui.ExamActivity;
import com.sanyu.jpgrammar.ui.GrmListActivity;
import com.sanyu.jpgrammar.util.StatusClass;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

@SuppressLint({ "HandlerLeak", "ValidFragment" })
public class HomeFragment extends BaseFragment implements OnItemClickListener {

	private PullToRefreshListView refresh;

	private ListView listView;

	public HomeFragment(Context context) {
		super(context);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_home, null);
		setTitle(view, "�����ķ���");
		refresh = (PullToRefreshListView) view.findViewById(R.id.pull_refresh_list);
		refresh.setMode(Mode.BOTH);
		listView = refresh.getRefreshableView();

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>(4);
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("menu_icon", R.drawable.n1);
		map1.put("menu", "JLPT N1�ķ�");
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("menu_icon", R.drawable.n2);
		map2.put("menu", "JLPT N1����");
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("menu_icon", R.drawable.n1);
		map3.put("menu", "JLPT N2�ķ�");
		Map<String, Object> map4 = new HashMap<String, Object>();
		map4.put("menu_icon", R.drawable.n2);
		map4.put("menu", "JLPT N2����");
		list.add(map1);
		list.add(map2);
		list.add(map3);
		list.add(map4);
		listView.setAdapter(new SimpleAdapter(getActivity(), list, R.layout.fragment_menu_item, new String[] {
				"menu_icon", "menu" }, new int[] { R.id.menu_icon, R.id.menu_name }));

		listView.setDivider(null);
		listView.setOnItemClickListener(this);
		return view;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		switch (position) {
		case 1:
			StatusClass.getInstance().setLevel("1");
			Intent i0 = new Intent(this.getActivity(), GrmListActivity.class);
			startActivity(i0);
			break;
		case 2:
			StatusClass.getInstance().setLevel("1");
			Intent i1 = new Intent(this.getActivity(), ExamActivity.class);
			startActivity(i1);
			break;
		case 3:
			StatusClass.getInstance().setLevel("2");
			Intent i2 = new Intent(getActivity(), GrmListActivity.class);
			startActivity(i2);
			break;
		case 4:
			StatusClass.getInstance().setLevel("2");
			Intent i3 = new Intent(getActivity(), ExamActivity.class);
			startActivity(i3);
			break;
		default:
			break;
		}
	}

}
