package com.huht.customtab;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

	private TabLinearLayout tabLl;
	private ViewPager mViewPager;
	private PagerAdapter mAdapter;  
    private List<View> mViews;  

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tabLl = (TabLinearLayout) findViewById(R.id.tab_ll);
		mViewPager = (ViewPager) findViewById(R.id.mviewpager);
		addView();

		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrolled(int position, float positionOffset, int arg2) {
				// TODO Auto-generated method stub
				tabLl.moveSlide(position, positionOffset);
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	private void addView(){
		mViews = new ArrayList<View>();  
        View first = new TestChildView(this,"View " + 1);
        View second = new TestChildView(this,"View " + 2);
        View third = new TestChildView(this,"View " + 3); 
        mViews.add(first);  
        mViews.add(second);  
        mViews.add(third);    
  
        mAdapter = new PagerAdapter()  
        {  
            @Override  
            public void destroyItem(ViewGroup container, int position, Object object)  
            {  
                container.removeView(mViews.get(position));  
            }  
  
            @Override  
            public Object instantiateItem(ViewGroup container, int position)  
            {  
                View view = mViews.get(position);  
                container.addView(view);  
                return view;  
            }  
  
            @Override  
            public boolean isViewFromObject(View arg0, Object arg1)  
            {  
                return arg0 == arg1;  
            }  
  
            @Override  
            public int getCount()  
            {  
                return mViews.size();  
            }  
        };
        mViewPager.setAdapter(mAdapter);
	}

}
