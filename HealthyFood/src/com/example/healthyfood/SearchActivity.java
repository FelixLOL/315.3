package com.example.healthyfood;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class SearchActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search, menu);
		return true;
	}
	public void transitionToFavorites(View view) {
		Intent intent = new Intent(SearchActivity.this, FavorActivity.class);
		SearchActivity.this.startActivity(intent);
	}
	public void transitionToAdd(View view) {
		Intent intent = new Intent(SearchActivity.this, AddActivity.class);
		SearchActivity.this.startActivity(intent);
	}
	public void transitionToMenu(View view) {
		Intent intent = new Intent(SearchActivity.this, MainActivity.class);
		SearchActivity.this.startActivity(intent);
	}
	public void transitionToProgress(View view) {
		Intent intent = new Intent(SearchActivity.this, ProgressActivity.class);
		SearchActivity.this.startActivity(intent);
	}
	public void transitionToSearch(View view) {
		Intent intent = new Intent(SearchActivity.this, SearchActivity.class);
		SearchActivity.this.startActivity(intent);
	}

}
