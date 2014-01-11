package com.example.hellofragment002;

import android.os.Build;
import android.os.Bundle;
import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.example.hellofragment002.LeftFragment.OnSearchEngineSelectedListener;

public class MainActivity extends FragmentActivity implements
         OnSearchEngineSelectedListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		if(isHoneycombTablet(this)){
			setContentView(R.layout.activity_main_tab);
		}else{
			setContentView(R.layout.activity_main_sp);
		}
	}

	public static boolean isHoneycomb(){
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
	}
	
	public static boolean isTablet(Context context){
		return (context.getResources().getConfiguration().screenLayout &
				 Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
	}
	
	public static boolean isHoneycombTablet(Context context){
		return isHoneycomb() && isTablet(context);
	}
	
	@Override
	public void onSearchEngineSelected(String url){
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		
		if(isHoneycombTablet(this)){
			ft.replace(R.id.fragment2tab, RightFragment.newInstance(url));
		} else {
			ft.replace(R.id.fragment1sp, RightFragment.newInstance(url));
		}
		ft.addToBackStack(null);
		ft.commit();
	}

}
