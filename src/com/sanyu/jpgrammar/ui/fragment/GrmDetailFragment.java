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
import android.widget.Toast;

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
public class GrmDetailFragment extends BaseFragment implements OnItemClickListener {

	private PullToRefreshListView refresh;

	private ListView listView;

	private GrammarService grammarService;

	private GrammarTitle grammarTitle;

	private SQLiteDatabase db;

	private Integer grammarSeq;

	private Integer nLevel;

	private int count;

	private MyAdapter myAdapter;

	private GrammarDetail grammarDetail;

	private List<Map<String, String>> list;

	public GrmDetailFragment(Context context) {
		super(context);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		count = 0;
		View view = inflater.inflate(R.layout.fragment_grm_detail, null);
		nLevel = Integer.parseInt(StatusClass.getInstance().getLevel());
		if (nLevel.equals(1)) {
			setTitle(view, "N1文法");
		}
		if (nLevel.equals(2)) {
			setTitle(view, "N2文法");
		}
		refresh = (PullToRefreshListView) view.findViewById(R.id.pull_refresh_grm_detail);
		refresh.setMode(Mode.BOTH);
		listView = refresh.getRefreshableView();

		grammarSeq = StatusClass.getInstance().getGramSeq();

		grammarTitle = new GrammarTitle();
		grammarTitle.setGramSeq(grammarSeq.toString());
		grammarService = new GrammarServiceImpl();
		db = getActivity().openOrCreateDatabase(SqlConstants.DATABASE_NAME, Context.MODE_PRIVATE, null);

		list = new ArrayList<Map<String, String>>();
		grammarDetail = grammarService.getGrammarDetail(db, grammarTitle);
		Map<String, String> map = new HashMap<String, String>();
		map.put("detail_title", grammarDetail.getTitle());
		map.put("detail_text", grammarDetail.getText());
		list.add(map);
		myAdapter = new MyAdapter(getActivity(), list, R.layout.grm_dtl_item, new String[] { "detail_title",
				"detail_text" }, new int[] { R.id.detail_title, R.id.detail_text });
		listView.setAdapter(myAdapter);

		listView.setOnItemClickListener(this);
		listView.setDivider(null);
		db.close();
		return view;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		if (count == 0) {
			Toast.makeText(getActivity(), "再按一次收藏该文法", Toast.LENGTH_SHORT).show();
			count = 1;
		} else if (count == 1) {
			grammarService.addFavorites(db, grammarDetail);
			Toast.makeText(getActivity(), "收藏成功", Toast.LENGTH_SHORT).show();
			count = 0;
		}

	}

	public void refresh() {
		list.clear();
		grammarSeq = StatusClass.getInstance().getGramSeq();
		grammarTitle = new GrammarTitle();
		grammarTitle.setGramSeq(grammarSeq.toString());
		db = getActivity().openOrCreateDatabase(SqlConstants.DATABASE_NAME, Context.MODE_PRIVATE, null);
		GrammarDetail grammarDetail = grammarService.getGrammarDetail(db, grammarTitle);
		Map<String, String> map = new HashMap<String, String>();
		map.put("detail_title", grammarDetail.getTitle());
		map.put("detail_text", grammarDetail.getText());
		list.add(map);
		db.close();
		myAdapter.notifyDataSetChanged();
	}

	class MyAdapter extends SimpleAdapter {

		public MyAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
			super(context, data, resource, from, to);
		}

	}
}
