package com.sanyu.jpgrammar.ui.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.content.Context;
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
import com.sanyu.jpgrammar.domain.GrammarDetail;
import com.sanyu.jpgrammar.domain.GrammarTitle;
import com.sanyu.jpgrammar.service.GrammarService;
import com.sanyu.jpgrammar.service.impl.GrammarServiceImpl;
import com.sanyu.jpgrammar.util.SqlConstants;
import com.sanyu.jpgrammar.util.StatusClass;

@SuppressLint({ "HandlerLeak", "ValidFragment" })
public class FavorDetailFragment extends BaseFragment implements OnItemClickListener {

	private PullToRefreshListView refresh;

	private ListView listView;

	private GrammarService grammarService;

	private GrammarTitle grammarTitle;

	private SQLiteDatabase db;

	private Integer grammarSeq;

	private Integer nLevel;

	private MyAdapter myAdapter;

	private GrammarDetail grammarDetail;

	private List<Map<String, String>> list;

	public FavorDetailFragment(Context context) {
		super(context);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_fav_detail, null);
		nLevel = Integer.parseInt(StatusClass.getInstance().getLevel());
		if (nLevel.equals(1)) {
			setTitle(view, "N1文法");
		}
		if (nLevel.equals(2)) {
			setTitle(view, "N2文法");
		}
		refresh = (PullToRefreshListView) view.findViewById(R.id.pull_refresh_fav_detail);
		refresh.setMode(Mode.DISABLED);
		listView = refresh.getRefreshableView();

		grammarSeq = StatusClass.getInstance().getGramSeq();

		grammarTitle = new GrammarTitle();
		grammarTitle.setGramSeq(grammarSeq.toString());
		grammarService = new GrammarServiceImpl();
		db = getActivity().openOrCreateDatabase(SqlConstants.DATABASE_NAME, Context.MODE_PRIVATE, null);

		list = new ArrayList<Map<String, String>>();
		grammarDetail = grammarService.getGrammarDetail(db, grammarTitle);
		Map<String, String> map = new HashMap<String, String>();
		map.put("fav_detail_title", grammarDetail.getTitle());
		map.put("fav_detail_text", grammarDetail.getText());
		list.add(map);
		myAdapter = new MyAdapter(getActivity(), list, R.layout.fav_dtl_item, new String[] { "fav_detail_title",
				"fav_detail_text" }, new int[] { R.id.fav_detail_title, R.id.fav_detail_text });
		listView.setAdapter(myAdapter);
		listView.setDivider(null);
		// db.close();
		return view;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	}

	public void refresh() {
		list.clear();
		grammarSeq = StatusClass.getInstance().getGramSeq();
		grammarTitle = new GrammarTitle();
		grammarTitle.setGramSeq(grammarSeq.toString());
		db = getActivity().openOrCreateDatabase(SqlConstants.DATABASE_NAME, Context.MODE_PRIVATE, null);
		GrammarDetail grammarDetail = grammarService.getGrammarDetail(db, grammarTitle);
		Map<String, String> map = new HashMap<String, String>();
		map.put("fav_detail_title", grammarDetail.getTitle());
		map.put("fav_detail_text", grammarDetail.getText());
		list.add(map);
		// db.close();
		myAdapter.notifyDataSetChanged();
	}

	class MyAdapter extends SimpleAdapter {

		public MyAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
			super(context, data, resource, from, to);
		}

	}
}
