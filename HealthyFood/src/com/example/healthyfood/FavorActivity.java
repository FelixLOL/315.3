package com.example.healthyfood;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class FavorActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_favor);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.favor, menu);
		return true;
	}
	public void transitionToFavorites(View view) {
		Intent intent = new Intent(FavorActivity.this, FavorActivity.class);
		FavorActivity.this.startActivity(intent);
	}
	public void transitionToAdd(View view) {
		Intent intent = new Intent(FavorActivity.this, AddActivity.class);
		FavorActivity.this.startActivity(intent);
	}
	public void transitionToMenu(View view) {
		Intent intent = new Intent(FavorActivity.this, MainActivity.class);
		FavorActivity.this.startActivity(intent);
	}
	public void transitionToProgress(View view) {
		Intent intent = new Intent(FavorActivity.this, ProgressActivity.class);
		FavorActivity.this.startActivity(intent);
	}
	public void transitionToSearch(View view) {
		Intent intent = new Intent(FavorActivity.this, SearchActivity.class);
		FavorActivity.this.startActivity(intent);
	}

}
