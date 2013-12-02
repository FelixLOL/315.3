package com.example.healthyfood;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adding);
		

		
		Button b = (Button) findViewById(R.id.button4);
        b.setOnClickListener(new OnClickListener() {

                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    Intent sam = new Intent(AddActivity.this, ListviewActivity.class);
                    startActivity(sam);

                }
            });
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
        EditText edit = (EditText) findViewById(R.id.editText);
        String text = edit.getText().toString();
        
	}
	
	

}
