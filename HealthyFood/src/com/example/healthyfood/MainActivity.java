package com.example.healthyfood;

import java.io.IOException;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	
	static Search parser = new Search();
	static List<Food> tours;
	
	private void getAllFoodItems(){
		try {
			tours = parser.parseXML(this);
				//testChar("       CALORIES: "+ tours.get(i).Calories + System.getProperty("line.separator"));
				//testChar("       PORTIONS: "+ tours.get(i).Portion_Amount + System.getProperty("line.separator"));
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		getAllFoodItems();
		

	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void transitionToAdd(View view) {
		Intent intent = new Intent(MainActivity.this, AddActivity.class);
	    MainActivity.this.startActivity(intent);

	}
	public void transitionToFavorites(View view) {
		Intent intent = new Intent(MainActivity.this, FavorActivity.class);
		MainActivity.this.startActivity(intent);
	}
	public void transitionToMenu(View view) {
		Intent intent = new Intent(MainActivity.this, MainActivity.class);
		MainActivity.this.startActivity(intent);
	}
	public void transitionToProgress(View view) {
		Intent intent = new Intent(MainActivity.this, ProgressActivity.class);
		MainActivity.this.startActivity(intent);
	}
	public void transitionToSearch(View view) {
		Intent intent = new Intent(MainActivity.this, SearchActivity.class);
		MainActivity.this.startActivity(intent);
	}

	public static List<Food> getTours() {
		// TODO Auto-generated method stub
		return tours;
	}

}
