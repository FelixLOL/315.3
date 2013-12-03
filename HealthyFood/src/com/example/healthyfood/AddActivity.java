package com.example.healthyfood;

import java.util.List;
import java.util.Vector;

import com.example.healthyfood.Food;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class AddActivity extends Activity {
	static Food food;
	static String text;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adding);
		Intent i = getIntent();
        String searchString = i.getStringExtra("selected");
		String calorie = "";
        
        if ((searchString != null) && (searchString.length()>0)){
            calorie = getFoodCalories(searchString);
        		print (searchString, calorie);       
        }
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
	
	public void searchbyenter(View view) {
       
		EditText edit = (EditText) findViewById(R.id.addingEditText);
	    String text = edit.getText().toString(); 
	    List<Food> foodList = MainActivity.getTours();
		
		
		Vector<String> vec = new Vector<String>();
		int counter = 0;
		for (int i=0; i<foodList.size();i++){
			if(foodList.get(i).Display_Name.contains(text)){
				counter++;
				vec.add(foodList.get(i).Display_Name);
			}
		}
		
		String[] array = new String[counter];
		for (int i=0; i<counter;i++){
			array[i]=vec.elementAt(i);
		}
		
		Intent listIntent = new Intent(AddActivity.this, ListviewActivity.class);
        listIntent.putExtra("search", array);
        startActivity(listIntent);
	}

	
	private String getFoodCalories(String content)
	{
		List<Food> foodList = MainActivity.getTours();
		for (int i=0; i<foodList.size();i++){
			if(foodList.get(i).Display_Name.contentEquals(content)){
				food = foodList.get(i);
			}
		}
		return food.getCalories();
	}
	
	
	
	private void print(String content, String cal){
		TextView display = (TextView)findViewById(R.id.textView1);
				
		text += 							System.getProperty("line.separator") 	+
				"NAME: "	+	content	+	System.getProperty("line.separator") 	+ 
				"CALORIES: " +	cal 	+	System.getProperty("line.separator") ; 
		
		display.setText(text);
	}
}
