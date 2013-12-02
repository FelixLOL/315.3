package com.example.healthyfood;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.example.healthyfood.Food;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;


public class AddActivity extends Activity {
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
		setContentView(R.layout.activity_adding);
		getAllFoodItems();
		

		/*
		Button b = (Button) findViewById(R.id.button4);
        b.setOnClickListener(new OnClickListener() {

                public void onClick(View v) {
                    // TODO Auto-generated method stub
                	
                	
                    Intent sam = new Intent(AddActivity.this, ListviewActivity.class);
                    startActivity(sam);

                }
            });*/
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
	    
	    String[] foodArray = null;
		List<Food> foods = null;
		
		
		
		String[] textArray = new String[]{tours.get(0).Display_Name};
		Vector<String> vec = new Vector<String>();
		int counter = 0;
		for (int i=0; i<tours.size();i++){
			if(tours.get(i).Display_Name.contains(text)){
				counter++;
				vec.add(tours.get(i).Display_Name);
			}
		}
		String[] array = new String[counter];
		for (int i=0; i<counter;i++){
			array[i]=vec.elementAt(i);
		}
		
		
		/*
		for (int i=0;i<foods.size();i++){
			foodArray[i] = foods.get(i).Display_Name;
		}*/
		Intent listIntent = new Intent(AddActivity.this, ListviewActivity.class);
        listIntent.putExtra("search", array);
        startActivity(listIntent);
			
        
        
        
        
	}
	private void setListAdapter(ArrayAdapter<Food> adapter) {
		// TODO Auto-generated method stub
		
	}
	
	/*

	public String[] searchFoodNames(String s){
		Search parser = new Search();
		
		
		String[] foodArray1 = null;
		
		try {
			List<Food> foods = null;
			String[] foodArray2 = null;
			
			
			List<Food> tours = parser.parseXML(this);
			
			
			for (int i=0; i<tours.size();i++){
				if(tours.get(i).Display_Name.contains(s)){
					
					foods.add(tours.get(i));
					
				}

				//testChar("       CALORIES: "+ tours.get(i).Calories + System.getProperty("line.separator"));
				//testChar("       PORTIONS: "+ tours.get(i).Portion_Amount + System.getProperty("line.separator"));

			}
			
			for (int i=0;i<foods.size();i++){
				foodArray2[i] = foods.get(i).Display_Name;
			}
			
			foodArray1 = foodArray2;
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foodArray1;
		
				
	}
	*/
	
	
	
	

}
