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
public class GrmDetailFragment extends BaseFragment implements OnItemClickListener {

	private PullToRefreshListView refresh;

	private ListView listView;

	private GrammarService grammarService;

	private GrammarTitle grammarTitle;

	private SQLiteDatabase db;

	private Integer grammarSeq;

	private Integer nLevel;

	public GrmDetailFragment(Context context) {
		super(context);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_grm_detail, null);
		nLevel = Integer.parseInt(StatusClass.getStatusClass().getLevel());
		if (nLevel.equals(1)) {
			setTitle(view, "N1文法");
		}
		if (nLevel.equals(2)) {
			setTitle(view, "N2文法");
		}
		refresh = (PullToRefreshListView) view.findViewById(R.id.pull_refresh_grm_detail);
		refresh.setMode(Mode.BOTH);
		listView = refresh.getRefreshableView();
		grammarSeq = Integer.parseInt(getActivity().getIntent().getStringExtra("GRM_SEQ"));
		grammarTitle = new GrammarTitle();
		grammarTitle.setGramSeq(grammarSeq.toString());
		grammarService = new GrammarServiceImpl();
		db = getActivity().openOrCreateDatabase(SqlConstants.DATABASE_NAME, Context.MODE_PRIVATE, null);

		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		GrammarDetail grammarDetail = grammarService.getGrammarDetail(db, grammarTitle);
		Map<String, String> map = new HashMap<String, String>();
		map.put("detail_text", grammarDetail.getText());
		setTitle(view, grammarDetail.getTitle());
		list.add(map);
		listView.setAdapter(new SimpleAdapter(getActivity(), list, R.layout.grm_dtl_item,
				new String[] { "detail_text" }, new int[] { R.id.detail_text }));

		listView.setOnItemClickListener(this);
		listView.setDivider(null);
		db.close();
		return view;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	}
}
