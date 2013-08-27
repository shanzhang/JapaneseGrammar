package com.sanyu.jpgrammar.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sanyu.jpgrammar.R;

public class MainMenuLvAdapter extends BaseAdapter {
	
	private Context context;
	
	private ViewHolder holder;

	public MainMenuLvAdapter(Context context) {
		this.context = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(R.layout.main_menu_item, null);
			holder = new ViewHolder();
			holder.user_img = (ImageView) convertView.findViewById(R.id.user_img);
			holder.user_name = (TextView) convertView.findViewById(R.id.user_name);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		return convertView;
	}

	class ViewHolder {
		ImageView user_img;
		TextView user_name;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
