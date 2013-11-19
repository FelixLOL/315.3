package com.example.healthyfood;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.util.Xml;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class SearchActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);
		
		XmlPullParserFactory pullParserFactory;
		try {
			pullParserFactory = XmlPullParserFactory.newInstance();
			XmlPullParser parser = pullParserFactory.newPullParser();

			    InputStream in_s = getApplicationContext().getAssets().open("Food_Display_Table.xml");
		        parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
	            parser.setInput(in_s, null);

	            parseXML(parser);

		} catch (XmlPullParserException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	private void parseXML(XmlPullParser parser) throws XmlPullParserException,IOException
	{
		ArrayList<Food> foodArray = null;
        int eventType = parser.getEventType();
        Food currentProduct = null;

        while (eventType != XmlPullParser.END_DOCUMENT){
            String name = null;
            switch (eventType){
                case XmlPullParser.START_DOCUMENT:
                	foodArray = new ArrayList();
                    break;
                case XmlPullParser.START_TAG:
                    name = parser.getName();
                    testChar(name);
                    if (name == "Food_Display_Row"){
                        currentProduct = new Food();
                    } else if (currentProduct != null){
                        /*if (name == "Food_Code"){
                            currentProduct.Food_Code = parser.nextText();
                        } */if (name == "Display_Name"){
                        	currentProduct.Display_Name = parser.nextText();
                        	testChar(name);
                        } 
                        
                        /*
                        else if (name == "Portion_Default"){
                            currentProduct.Portion_Default= parser.nextText();
                        } else if (name == "Portion_Amount"){
                            currentProduct.Portion_Amount= parser.nextText();
                        } else if (name == "Portion_Display_Name"){
                            currentProduct.Portion_Display_Name= parser.nextText();
                        }  else if (name == "Factor"){
                            currentProduct.Factor= parser.nextText();
                        } else if (name == "Increment"){
                            currentProduct.Increment= parser.nextText();
                        } else if (name == "Multiplier"){
                            currentProduct.Multiplier= parser.nextText();
                        } else if (name == "Grains"){
                            currentProduct.Grains= parser.nextText();
                        } else if (name == "Whole_Grains"){
                            currentProduct.Whole_Grains= parser.nextText();
                        } else if (name == "Vegetables"){
                            currentProduct.Vegetables= parser.nextText();
                        } else if (name == "Orange_Vegetables"){
                            currentProduct.Orange_Vegetables= parser.nextText();
                        } else if (name == "Drkgreen_Vegetables"){
                            currentProduct.Drkgreen_Vegetables= parser.nextText();
                        } else if (name == "Starchy_vegetables"){
                            currentProduct.Starchy_vegetables= parser.nextText();
                        } else if (name == "Other_Vegetables"){
                            currentProduct.Other_Vegetables= parser.nextText();
                        } else if (name == "Fruits"){
                            currentProduct.Fruits= parser.nextText();
                        } else if (name == "Milk"){
                            currentProduct.Milk= parser.nextText();
                        } else if (name == "Meats"){
                            currentProduct.Meats= parser.nextText();
                        } else if (name == "Soy"){
                            currentProduct.Soy= parser.nextText();
                        } else if (name == "Drybeans_Peas"){
                            currentProduct.Drybeans_Peas= parser.nextText();
                        } else if (name == "Oils"){
                            currentProduct.Oils= parser.nextText();
                        } else if (name == "Solid_Fats"){
                            currentProduct.Solid_Fats= parser.nextText();
                        } else if (name == "Added_Sugars"){
                            currentProduct.Added_Sugars= parser.nextText();
                        } else if (name == "Alcohol"){
                            currentProduct.Alcohol= parser.nextText();
                        } else if (name == "Calories"){
                            currentProduct.Calories= parser.nextText();
                        } else if (name == "Saturated_Fats"){
                            currentProduct.Saturated_Fats= parser.nextText();
                        }*/
                    }
                    break;
                case XmlPullParser.END_TAG:
                    name = parser.getName();
                    if (name.equalsIgnoreCase("Food_Display_Row") && currentProduct != null){
                    	foodArray.add(currentProduct);
                    } 
            }
            eventType = parser.next();
        }

        //printFoods(foodArray);
        
	}
	
	private void testFirstElement(String content)
	{
		
		TextView display = (TextView)findViewById(R.id.textView1);
		String temp = (String) display.getText();
		//temp += content;
		//display.setText(temp1);

	}
	
	private void testChar(String s){
		
		TextView display = (TextView)findViewById(R.id.textView1);

		CharSequence temp1 = display.getText();
		s += (String) temp1;
		display.setText(s);
		
	}
	
	
	private void printFoods(ArrayList<Food> products)
	{
		String content = "test jajaja";
		//Iterator<Food> it = products.iterator();
		
		if (products.isEmpty()){
			content = "super empty";
			
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
	public void transitionToMenu(View view) {
		Intent intent = new Intent(SearchActivity.this, MainActivity.class);
		SearchActivity.this.startActivity(intent);
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

class Food
{
	public String Food_Code;
	public String Display_Name;
	public String Portion_Default;
	public String Portion_Amount;
	public String Portion_Display_Name;
	public String Factor;
	public String Increment;
	public String Multiplier;
	public String Grains;
	public String Whole_Grains;
	public String Vegetables;
	public String Orange_Vegetables;
	public String Drkgreen_Vegetables;
	public String Starchy_vegetables;
	public String Other_Vegetables;
	public String Fruits;
	public String Milk;
	public String Meats;
	public String Soy;
	public String Drybeans_Peas;
	public String Oils;
	public String Solid_Fats;
	public String Added_Sugars;
	public String Alcohol;
	public String Calories;
	public String Saturated_Fats;
}







