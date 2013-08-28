package com.sanyu.jpgrammar.ui.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.sanyu.jpgrammar.R;
import com.sanyu.jpgrammar.service.GrammarService;
import com.sanyu.jpgrammar.service.impl.GrammarServiceImpl;
import com.sanyu.jpgrammar.ui.GrmDetailActivity;
import com.sanyu.jpgrammar.util.SqlConstants;
import com.sanyu.jpgrammar.util.StatusClass;

@SuppressLint({ "HandlerLeak", "ValidFragment" })
public class GrmListFragment extends BaseFragment implements
		OnItemClickListener {

	private PullToRefreshListView refresh;

	private ListView listView;
	
	private GrammarService grammarService;
	
	private SQLiteDatabase db;
	
	private Integer nLevel;

	public GrmListFragment(Context context) {
		super(context);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_grm_list, null);
		nLevel = Integer.parseInt(StatusClass.getStatusClass().getLevel());
		if (nLevel.equals(1)) {
			setTitle(view, "N1文法");
		}
		if (nLevel.equals(2)) {
			setTitle(view, "N2文法");
		}
		refresh = (PullToRefreshListView) view.findViewById(R.id.pull_refresh_grm_list);
		refresh.setMode(Mode.BOTH);
		listView = refresh.getRefreshableView();
		grammarService = new GrammarServiceImpl();
		db = getActivity().openOrCreateDatabase(SqlConstants.DATABASE_NAME, Context.MODE_PRIVATE, null);

		int count = grammarService.getTotalGrammarNo(db);
		List<Map<String, String>> list = new ArrayList<Map<String, String>>(count);
		for (int i = 0; i < count; i++) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("title", "文法" + grammarService.getTotalGrammar(db).get(i).getGramSeq());
			map.put("info", grammarService.getTotalGrammar(db).get(i).getTitle());
			list.add(map);
		}
		listView.setAdapter(new SimpleAdapter(getActivity(), list, R.layout.grm_item, new String[] { "title", "info" },
				new int[] { R.id.title, R.id.info }));

		listView.setDivider(null);
		listView.setOnItemClickListener(this);
		db.close();
		return view;
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Intent i = new Intent(getActivity(), GrmDetailActivity.class);
		i.putExtra("GRM_SEQ", position + "");
		startActivity(i);
	}
}
