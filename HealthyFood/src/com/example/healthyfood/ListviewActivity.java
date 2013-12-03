package com.example.healthyfood;

import java.io.IOException;
import java.util.List;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class ListviewActivity extends ListActivity { 
	

    /** Called when the activity is first created. */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        /*
        EditText edit = (EditText) findViewById(R.id.editText); //get the editText id
        String s = AddActivity.getSearchString(edit);			//get the search word
        if (s.isEmpty()){
        	testString("EMPTY");
        }
        else {testString(s);}    
        String[] foodNameArray =  searchFoodNames(s);			//get the results for the search in an array
        
        */
        Intent i = getIntent();
        String[] k = i.getStringArrayExtra("search");
        /*if(k!=null && k.length>0){
        	setListAdapter(new ArrayAdapter < String > (this,
                    android.R.layout.simple_list_item_1, k));
        *///}else{
        	setListAdapter(new ArrayAdapter < String > (this,
                    android.R.layout.simple_list_item_1, k));
        //}
        getListView().setTextFilterEnabled(true);
    }
	
	
	private void clearView(){
		TextView display = (TextView)findViewById(R.id.textView1);
		display.setText("");
		
	}
	
	

    @Override
    protected void onListItemClick(final ListView l, final View v, final int position, final long id) {
        // TODO Auto-generated method stub
        super.onListItemClick(l, v, position, id);

        //AddActivity.tours.
        
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
/*
        Toast.makeText(ListviewActivity.this,
            "ListView: " + l.toString() + "\n" +
            "View: " + v.toString() + "\n" +
            "position: " + String.valueOf(position) + "\n" +
            "id: " + String.valueOf(id),
            Toast.LENGTH_LONG).show();*/
    }
    
  
}