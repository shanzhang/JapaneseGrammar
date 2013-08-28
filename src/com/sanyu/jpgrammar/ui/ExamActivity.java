package com.sanyu.jpgrammar.ui;

import com.sanyu.jpgrammar.R;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

@SuppressLint("HandlerLeak")
public class ExamActivity extends BaseActivity {

	private EditText editText;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exam);
		setTitle(findViewById(R.id.title), "ÎÄ·¨¿¼ºË");
		editText = (EditText) findViewById(R.id.answer);
	}

	public void sumbit(View v) {
		String s = editText.getText().toString();
		if (!TextUtils.isEmpty(s)) {

		}
	}
}
