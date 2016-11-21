package com.huht.customtab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TestChildView extends RelativeLayout{

	private View view;
	private TextView tv;
	
	public TestChildView(Context context,String str) {
		super(context);
		// TODO Auto-generated constructor stub
		view = LayoutInflater.from(context).inflate(R.layout.pager_item, this);
		tv = (TextView) view.findViewById(R.id.id_text_msg);
		tv.setText(str);
	}

}
