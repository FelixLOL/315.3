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
import android.widget.TextView;


public class AddActivity extends Activity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adding);
		Intent i = getIntent();
        String k = i.getStringExtra("selected");
		int cal = 0;
        
        if ((k != null) && (k.length()>0)){
            //cal = getFoodCalories(k);
        	//if(cal>0){
        		
        		print (k);
        	//}
            
        }
        else{
        	k = "";
        	
        }

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
		
		List<Food> foodList = MainActivity.getTours();
		
		
		String[] textArray = new String[]{foodList.get(0).Display_Name};
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
		
		
		
		
		/*
		for (int i=0;i<foods.size();i++){
			foodArray[i] = foods.get(i).Display_Name;
		}*/
		Intent listIntent = new Intent(AddActivity.this, ListviewActivity.class);
        listIntent.putExtra("search", array);
        startActivity(listIntent);
			
        
        
        
	}

	
	private int getFoodCalories(String content)
	{
		List<Food> foodList = MainActivity.getTours();
		Food food =null;
		
		for (int i=0; i<foodList.size();i++){
			if(foodList.get(i).Display_Name.matches(content)){
				food = foodList.get(i);
			}
		}
		int calories  = Integer.valueOf(food.getCalories());		
				
		return calories;

	}
	
	
	
	private void print(String content){
		TextView display = (TextView)findViewById(R.id.textView1);
		//String temp = (String) display.getText();
		//System.getProperty("line.separator");
		
		String text = System.getProperty("line.separator") +System.getProperty("line.separator") 
				+"NAME: "+content+System.getProperty("line.separator") + "CALORIES: " + //cal +
				System.getProperty("line.separator") ; 
		
		
		display.setText(text);
	}
	

}
