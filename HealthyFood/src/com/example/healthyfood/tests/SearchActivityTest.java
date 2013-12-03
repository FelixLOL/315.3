package com.example.healthyfood.tests;

import com.example.healthyfood.R;
import com.example.healthyfood.SearchActivity;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

public class SearchActivityTest extends ActivityInstrumentationTestCase2<SearchActivity> {

	private TextView searchTitleText;
	private SearchActivity searchActivity;
	
	public SearchActivityTest() {
		super(SearchActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
	    super.setUp();
	    searchActivity = getActivity();
	    searchTitleText = (TextView) searchActivity.findViewById(R.id.textView);
	}

	public void testPreconditions() {
		//
	}
	
	public void testSearchTitle() {
		final String expected = "Search";
		final String actual = searchTitleText.getText().toString();
	    assertEquals(expected,actual);
	}
		

}
