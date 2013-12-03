package com.example.healthyfood;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ListviewActivity extends ListActivity { 
	

    /** Called when the activity is first created. */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        Intent i = getIntent();
        String[] searchString = i.getStringArrayExtra("search");
        
        	setListAdapter(new ArrayAdapter < String > (this,
                    android.R.layout.simple_list_item_1, searchString));
        getListView().setTextFilterEnabled(true);
    }
	
	
	@Override
    protected void onListItemClick(final ListView l, final View v, final int position, final long id) {
        super.onListItemClick(l, v, position, id);
        new AlertDialog.Builder(this)
            .setTitle("Add Food Item")
            .setMessage("NAME: " + getListView().getItemAtPosition(position))
            .setPositiveButton("ADD",
            new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                	String selectedFromList = (String) (l.getItemAtPosition(position));
                	Intent intent = new Intent(ListviewActivity.this, AddActivity.class);
                	intent.putExtra("selected", selectedFromList);
            		ListviewActivity.this.startActivity(intent);
              }
          })
            .show();
    }
    
  
}