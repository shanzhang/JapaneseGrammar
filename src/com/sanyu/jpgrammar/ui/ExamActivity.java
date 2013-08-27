package com.sanyu.jpgrammar.ui;

import com.sanyu.jpgrammar.R;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

@SuppressLint("HandlerLeak")
public class ExamActivity extends BaseActivity {
	private EditText editText;

	Handler handler = new Handler() {

		public void handleMessage(android.os.Message msg) {
			Toast.makeText(ExamActivity.this, "成功", Toast.LENGTH_SHORT).show();
		};
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exam);
		setTitle(findViewById(R.id.title), "文法考核");
		editText = (EditText) findViewById(R.id.edit);
	}

	public void send(View v) {
		String s = editText.getText().toString();
		if (!TextUtils.isEmpty(s)){
			
		}
	}
}
