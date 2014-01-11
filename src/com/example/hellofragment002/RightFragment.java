package com.example.hellofragment002;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class RightFragment extends Fragment {
	public static RightFragment newInstance(String url){
		RightFragment fragment = new RightFragment();
		
		Bundle args = new Bundle();
		args.putString("url", url);
		fragment.setArguments(args);
		
		return fragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			 Bundle savedInstanceState){
		
		View v = inflater.inflate(R.layout.right_fragment, container, false);
		
		if(getArguments() != null){
			String url = getArguments().getString("url");
			WebView web = (WebView) v.findViewById(R.id.webView1);
			web.loadUrl(url);
		}
		return v;
	}
}