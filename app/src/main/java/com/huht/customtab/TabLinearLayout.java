package com.huht.customtab;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class TabLinearLayout extends LinearLayout {

	private Context mContext;

	private List<Integer> childLefts = new ArrayList<Integer>();
	
	private int slideWidth = 0;
	
	private int slideHeight = 20;
	
	private int slideColor = Color.CYAN;
	
	private int slideLeft = 0;

	public TabLinearLayout(Context context) {
		this(context, null, 0);
		// TODO Auto-generated constructor stub
	}

	public TabLinearLayout(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
		// TODO Auto-generated constructor stub
	}

	public TabLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
		this.mContext = context;
		setWillNotDraw(false);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		

		
	}
	
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		// TODO Auto-generated method stub
		super.onLayout(changed, l, t, r, b);
		if (getChildCount()>0) {
			View child = getChildAt(0);
			slideWidth = child.getMeasuredWidth();
			slideLeft = child.getLeft();
			for (int i=0 ;i<getChildCount();i++) {
				childLefts.add(getChildAt(i).getLeft());
			}
		}
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		Paint paint = new Paint();
		Log.i("TabLinearLayout","OnDraw");
		paint.setColor(slideColor);
		paint.setAntiAlias(true);
		canvas.drawRect(slideLeft, getBottom() - slideHeight, slideLeft + slideWidth, getBottom(), paint);
	}
	
	public void moveSlide(int position, float positionOffset){
		Log.i("TabLinearLayout","position = "+position+",positionOffset = "+positionOffset);
		int left = childLefts.get(position);
		int leftOffset = (int) (slideWidth * positionOffset);
		Log.i("TabLinearLayout","left = "+left+",leftOffset = "+leftOffset);
		slideLeft = left + leftOffset;
		this.invalidate();
	}

}
