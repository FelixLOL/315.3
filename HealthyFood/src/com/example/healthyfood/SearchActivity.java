package com.example.healthyfood;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.healthyfood.Food;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.app.Activity;
import android.widget.TextView;

public class SearchActivity extends Activity {

	Boolean runTests = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);
		
		if(runTests) {
			// run tests here
		    if(testXMLLookup()) {
		    	Log.w("test","XML Lookup passed");
		    }
		    else {
		    	Log.w("test","XML Lookup failed");
		    }
		}
	}

    private Boolean testXMLLookup() {
    	
    	return false;
    }

	
	private void setListAdapter(ArrayAdapter<Food> adapter) {
		// TODO Auto-generated method stub
		
	}

	private void printItem(String s){
		Search parser = new Search();
		List<Food> tours;
		try {
			tours = parser.parseXML(this);
			
			for (int i=0; i<tours.size();i++){
				if(tours.get(i).Display_Name.contains(s))
				testChar(
						"NAME: "+tours.get(i).Display_Name+System.getProperty("line.separator") 
						+"CALORIES: "+tours.get(i).Calories+System.getProperty("line.separator")
						+"PORTION AMOUNT: "+tours.get(i).Portion_Amount+ System.getProperty("line.separator")
						+ System.getProperty("line.separator")
								
				);
				//testChar("       CALORIES: "+ tours.get(i).Calories + System.getProperty("line.separator"));
				//testChar("       PORTIONS: "+ tours.get(i).Portion_Amount + System.getProperty("line.separator"));

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	private void testString(String content)
	{
		
		TextView display = (TextView)findViewById(R.id.textView1);
		String temp = (String) display.getText();
		temp += content;
		display.setText(temp);

	}
	
	private void clearChar(){
		TextView display = (TextView)findViewById(R.id.textView1);
		display.setText("");
		
	}
	
	private void testChar(String s){
		
		TextView display = (TextView)findViewById(R.id.textView1);
		CharSequence temp1 = display.getText();
		s += (String) temp1;
		display.setText(s);
		
	}
	
	
	private void printFoods(ArrayList<Food> products)
	{
		String content = "Array Contains Food items";
		//Iterator<Food> it = products.iterator();
		
		if (products.isEmpty()){
			content = "Array is Empty";
		}
		/*
		Food currProduct  = products.get(0);
		content = content + "nName :" +  currProduct.Display_Name + "n";
		*/
		
		/*while(it.hasNext())
		{
			Food currProduct  = it.next();
			content = content + "nName :" +  currProduct.Display_Name + "n";

		}*/
		
		

		TextView display = (TextView)findViewById(R.id.textView1);
		display.setText(content);
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
	public void searchbyenter(View view) {
        EditText edit = (EditText) findViewById(R.id.editText1);
        String text = edit.getText().toString();
        clearChar();
        printItem(text);
        
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








