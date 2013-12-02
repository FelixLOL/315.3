package com.example.healthyfood;

import java.io.IOException;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class AddActivity extends Activity {


    static final String[] arrayList = new String[] {

        "Afghanistan", "Albania", "Algeria", "American Samoa",
            "Andorra", "Angola", "Anguilla", "Antarctica",
            "Antigua and Barbuda", "Argentina", "Armenia", "Aruba",
            "Australia", "Austria", "Azerbaijan", "Bahrain",
            "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize",
            "Benin", "Bermuda", "Bhutan", "Bolivia",
            "Bosnia and Herzegovina", "Botswana", "Bouvet Island",
            "Brazil", "British Indian Ocean Territory"
    };
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adding);
		

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
        //String[] searchArray = searchFoodNames(text);
        String[] textArray = new String[]{text};
        
        
        Intent listIntent = new Intent(AddActivity.this, ListviewActivity.class);
        listIntent.putExtra("search", textArray);
        startActivity(listIntent);
        
	}
	
	

	private String[] searchFoodNames(String s){
		Search parser = new Search();
		List<Food> tours;
		
		String[] foodArray = null;
		try {
			tours = parser.parseXML(this);
			
			for (int i=0; i<tours.size();i++){
				if(tours.get(i).Display_Name.contains(s))
				
					foodArray[i] = tours.get(i).Display_Name;
								
				
				//testChar("       CALORIES: "+ tours.get(i).Calories + System.getProperty("line.separator"));
				//testChar("       PORTIONS: "+ tours.get(i).Portion_Amount + System.getProperty("line.separator"));

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foodArray;
				
	}
	
	
	
	
	

}
