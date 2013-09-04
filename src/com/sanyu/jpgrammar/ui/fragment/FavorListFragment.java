package com.sanyu.jpgrammar.ui.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.sanyu.jpgrammar.R;
import com.sanyu.jpgrammar.domain.GrammarTitle;
import com.sanyu.jpgrammar.service.GrammarService;
import com.sanyu.jpgrammar.service.impl.GrammarServiceImpl;
import com.sanyu.jpgrammar.ui.GrmDetailActivity;
import com.sanyu.jpgrammar.util.SqlConstants;
import com.sanyu.jpgrammar.util.StatusClass;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class FavorListFragment extends BaseFragment implements OnItemClickListener {

	private PullToRefreshListView refresh;

	private ListView listView;

	private GrammarService grammarService;

	private SQLiteDatabase db;

	private MyAdapter myAdapter;

	private Integer nLevel;

	private List<Map<String, String>> list;

	private ArrayList<GrammarTitle> favList;

	public FavorListFragment(Context context) {
		super(context);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_fav_list, null);
		nLevel = Integer.parseInt(StatusClass.getInstance().getLevel());
		if (nLevel.equals(1)) {
			setTitle(view, "N1文法");
		}
		if (nLevel.equals(2)) {
			setTitle(view, "N2文法");
		}
		refresh = (PullToRefreshListView) view.findViewById(R.id.pull_refresh_fav_list);
		refresh.setMode(Mode.BOTH);
		listView = refresh.getRefreshableView();
		grammarService = new GrammarServiceImpl();
		db = getActivity().openOrCreateDatabase(SqlConstants.DATABASE_NAME, Context.MODE_PRIVATE, null);

		list = new ArrayList<Map<String, String>>(64);
		favList = grammarService.getTotalFavorites(db, StatusClass.getInstance().getFavPage().toString());
		for (int i = 0; i < favList.size(); i++) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("title", "文法" + favList.get(i).getGramSeq());
			map.put("info", favList.get(i).getTitle());
			list.add(map);
		}
		if (favList.size() == 0) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("title", "无记录");
			map.put("info", "您未曾收藏任何文法");
			list.add(map);
		}
		myAdapter = new MyAdapter(getActivity(), list, R.layout.grm_item, new String[] { "title", "info" }, new int[] {
				R.id.title, R.id.info });
		listView.setAdapter(myAdapter);

		listView.setDivider(null);
		listView.setOnItemClickListener(this);
		db.close();
		return view;
	}

	public void refresh() {
		db = getActivity().openOrCreateDatabase(SqlConstants.DATABASE_NAME, Context.MODE_PRIVATE, null);
		list.clear();
		favList = grammarService.getTotalFavorites(db, StatusClass.getInstance().getFavPage().toString());
		for (int i = 0; i < favList.size(); i++) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("title", "文法" + favList.get(i).getGramSeq());
			map.put("info", favList.get(i).getTitle());
			list.add(map);
		}
		db.close();
		myAdapter.notifyDataSetChanged();
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		if (favList.size() > 0) {
			Intent i = new Intent(getActivity(), GrmDetailActivity.class);
			StatusClass.getInstance().setGramSeq(Integer.parseInt(favList.get(position).getGramSeq()));
			startActivity(i);
		}
	}

	class MyAdapter extends SimpleAdapter {

		public MyAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
			super(context, data, resource, from, to);
		}

	}

}
