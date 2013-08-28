package com.sanyu.jpgrammar.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.sanyu.jpgrammar.R;

public class SearchGrmActivity extends BaseActivity {

	private EditText editText;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		setTitle(findViewById(R.id.title), "ËÑË÷ÎÄ·¨");
		editText = (EditText) findViewById(R.id.query);
	}

	public void sumbit(View v) {
		String s = editText.getText().toString();
		if (!TextUtils.isEmpty(s)) {

		}
	}
}
