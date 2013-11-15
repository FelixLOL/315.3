package com.example.healthyfood;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class ProgressActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.progress);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.progress, menu);
		return true;
	}
	public void transitionToFavorites(View view) {
		Intent intent = new Intent(ProgressActivity.this, FavorActivity.class);
		ProgressActivity.this.startActivity(intent);
	}
	public void transitionToAdd(View view) {
		Intent intent = new Intent(ProgressActivity.this, AddActivity.class);
		ProgressActivity.this.startActivity(intent);
	}
	public void transitionToMenu(View view) {
		Intent intent = new Intent(ProgressActivity.this, MainActivity.class);
		ProgressActivity.this.startActivity(intent);
	}
	public void transitionToProgress(View view) {
		Intent intent = new Intent(ProgressActivity.this, ProgressActivity.class);
		ProgressActivity.this.startActivity(intent);
	}
	public void transitionToSearch(View view) {
		Intent intent = new Intent(ProgressActivity.this, SearchActivity.class);
		ProgressActivity.this.startActivity(intent);
	}

}
