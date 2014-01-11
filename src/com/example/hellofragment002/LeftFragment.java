package com.example.hellofragment002;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LeftFragment extends ListFragment {
	private String[] list = new String[]{ "Google", "Yahoo", "Bing", "MSN",
			 "goo" };
	
	private String[] url = new String[]{ "http://www.google.co.jp/",
			"http://www.yahoo.co.jp/", "http://www.bing.com/",
			"http://jp.msn.com/", "http://www.goo.ne.jp/" };
	
	public interface OnSearchEngineSelectedListener {
		public void onSearchEngineSelected(String url);
	}
	
	private OnSearchEngineSelectedListener listener;
	
	@Override
	public void onAttach(Activity activity){
		super.onAttach(activity);
		listener = (OnSearchEngineSelectedListener) activity;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
				 android.R.layout.simple_list_item_1, list);
		setListAdapter(adapter);
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id){
		listener.onSearchEngineSelected(url[position]);
	}

}
