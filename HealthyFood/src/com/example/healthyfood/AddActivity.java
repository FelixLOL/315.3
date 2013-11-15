package com.example.healthyfood;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class AddActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adding);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add, menu);
		return true;
	}
	
	public void transitionToFavorites(View view) {
		Intent intent = new Intent(AddActivity.this, FavorActivity.class);
	    AddActivity.this.startActivity(intent);
	}
	public void transitionToAdd(View view) {
		Intent intent = new Intent(AddActivity.this, AddActivity.class);
		AddActivity.this.startActivity(intent);
	}
	public void transitionToMenu(View view) {
		Intent intent = new Intent(AddActivity.this, MainActivity.class);
		AddActivity.this.startActivity(intent);
	}
	public void transitionToProgress(View view) {
		Intent intent = new Intent(AddActivity.this, ProgressActivity.class);
		AddActivity.this.startActivity(intent);
	}
	public void transitionToSearch(View view) {
		Intent intent = new Intent(AddActivity.this, SearchActivity.class);
		AddActivity.this.startActivity(intent);
	}

}
