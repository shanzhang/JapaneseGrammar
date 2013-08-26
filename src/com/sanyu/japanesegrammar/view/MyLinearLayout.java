package com.sanyu.japanesegrammar.view;

import com.sanyu.japanesegrammar.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Scroller;

/**
 * Title: MyLinearLayout.java<br>
 * Version:v1.0
 */
public class MyLinearLayout extends LinearLayout {
	ImageView iv1, iv2;
	int left, top;
	float startX, startY;
	float currentX, currentY;

	int rootW, rootH;

	int iv1H;
	Scroller scroller;
	TouchTool tool;

	// 鏈�ぇ绉诲姩璺濈,瀹為檯鎯呭喌鍙互鍙樺寲
	static final int LEN = 200;

	public MyLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	protected void onFinishInflate() {
		super.onFinishInflate();
		iv1 = (ImageView) findViewById(R.id.iv1);
		iv2 = (ImageView) findViewById(R.id.iv);
		setLongClickable(true);
		scroller = new Scroller(getContext(), new AccelerateDecelerateInterpolator());
	}

	public boolean onTouchEvent(MotionEvent event) {
		int action = event.getAction();
		if (!scroller.isFinished()) {
			return super.onTouchEvent(event);
		}
		currentX = event.getX();
		currentY = event.getY();
		switch (action) {
		case MotionEvent.ACTION_DOWN:
			left = iv2.getLeft();
			top = iv2.getTop();

			rootW = getWidth();
			rootH = getHeight();

			iv1H = iv1.getHeight();

			startX = currentX;
			startY = currentY;
			// TouchTool 鏄粦鍔ㄥ伐鍏凤紝鏄笅闈㈢殑imageview绉诲姩鐨勬椂鍊欙紝璁＄畻鑳藉绉诲姩鐨勮窛绂�
			tool = new TouchTool(iv2.getLeft(), iv2.getTop(), iv2.getLeft(), iv2.getTop() + LEN);
			break;
		case MotionEvent.ACTION_MOVE:
			// int l = (int) (left + currentX - startX);
			// int t = (int) (top + currentY - startY);
			if (tool != null) {

				int l = tool.getScrollX(currentX - startX);
				int t = tool.getScrollY(currentY - startY);
				if (t >= top && t <= iv2.getTop() + LEN) {
					// 婊戝姩鏃跺�锛岄噸鏂板畾浣嶄笂闈㈢殑甯冨眬鍜屼笅闈㈢殑甯冨眬
					iv2.layout(left, t, left + iv2.getWidth(), t + iv2.getHeight());
					iv1.layout(0, 0, iv1.getWidth(), t);
				}
			}
			break;
		case MotionEvent.ACTION_UP:
			// iv2.layout(left, top, left + iv2.getWidth(), top +
			// iv2.getHeight());
			// iv1.layout(0, 0, iv1.getWidth(), iv1H);
			System.out.printf("left1:%s left2:%s\n", iv2.getLeft(), 0);
			System.out.printf("top1:%s top2:%s\n", iv2.getTop(), iv1H);
			// 鎶捣鎵嬬殑鏃跺�锛屾參鎱㈢殑鎹㈠埌鍘熷厛浣嶇疆
			scroller.startScroll(iv2.getLeft(), iv2.getTop(), 0 - iv2.getLeft(), iv1H - iv2.getTop(), 200);
			invalidate();
			break;
		}
		return super.onTouchEvent(event);
	}

	public void computeScroll() {
		if (scroller.computeScrollOffset()) {
			int x = scroller.getCurrX();
			int y = scroller.getCurrY();
			System.out.println("x=" + x);
			System.out.println("y=" + y);
			iv1.layout(0, 0, x + iv1.getWidth(), y);
			iv2.layout(x, y, x + iv2.getWidth(), y + iv2.getHeight());
			invalidate();
		}
	}
}
