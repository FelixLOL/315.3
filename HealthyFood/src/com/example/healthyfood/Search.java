package com.example.healthyfood;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import android.content.Context;
import android.util.Log;
import com.example.healthyfood.Food;



public class Search {

	private static final String LOGTAG = "Saturated_Fats";
	private static final String FOOD_TAG = "Food_Display_Row";
	private static final String FOOD_FOOD_CODE = "Food_Code";
	private static final String FOOD_DISPLAY_NAME = "Display_Name";
	private static final String FOOD_PORTION_DEFAULT = "Portion_Display";
	private static final String FOOD_PORTION_AMOUNT = "Portion_Amount";
	private static final String FOOD_PORTION_DISPLAY_NAME = "Portion_Display_Name";
	private static final String FOOD_FACTOR = "Factor";
	private static final String FOOD_INCREMENT = "Increment";
	private static final String FOOD_MULTIPLIER = "Multiplier";
	private static final String FOOD_GRAINS = "Grains";
	private static final String FOOD_WHOLE_GRAINS = "Whole_Grains";
	private static final String FOOD_VEGETABLES = "Vegetables";
	private static final String FOOD_ORANGE_VEGETABLES = "Orange_Vegetables";
	private static final String FOOD_DRKGREEN_VEGETABLES = "Drkgreen_Vegetables";
	private static final String FOOD_STARCHY_VEGETABLES = "Starchy_vegetables";
	private static final String FOOD_OTHER_VEGETABLES = "Other_Vegetables";
	private static final String FOOD_FRUITS = "Fruits";
	private static final String FOOD_MILK = "Milk";
	private static final String FOOD_MEATS = "Meats";
	private static final String FOOD_SOY = "Soy";
	private static final String FOOD_DRYBEANS_PEAS = "Drybeans_Peas";
	private static final String FOOD_OILS = "Oils";
	private static final String FOOD_SOLID_FATS = "Solid_Fats";
	private static final String FOOD_ADDED_SUGARS = "Added_Sugars";
	private static final String FOOD_ALCOHOL = "Alcohol";
	private static final String FOOD_CALORIES = "Calories";
	private static final String FOOD_SATURATED_FATS = "Saturated_Fats";
	
	
	
	/*
	private static final String TOUR_TAG = "tour";
	private static final String TOUR_ID = "tourId";
	private static final String TOUR_TITLE = "tourTitle";
	private static final String TOUR_DESC = "description";
	private static final String TOUR_PRICE = "price";
	private static final String TOUR_IMAGE = "image";
	*/
	
	

	public List<Food> parseXML(Context context) throws IOException {

		//InputStream stream = context.getApplicationContext().getAssets().open("Food_Display_Table.xml");
		InputStream stream = context.getResources().openRawResource(R.raw.food_table);
		SAXBuilder builder = new SAXBuilder();
		List<Food> tours = new ArrayList<Food>();

		try {

			Document document = (Document) builder.build(stream);
			org.jdom2.Element rootNode = document.getRootElement();
			List<org.jdom2.Element> list = rootNode.getChildren(FOOD_TAG);

			for (Element node : list) {
				Food tour = new Food();
				tour.setFood_Code(node.getChildText(FOOD_FOOD_CODE));
				tour.setDisplay_Name(node.getChildText(FOOD_DISPLAY_NAME));
				tour.setCalories(node.getChildText(FOOD_CALORIES));
				tours.add(tour);
			}

		} catch (IOException e) {
			Log.i(LOGTAG, e.getMessage());
		} catch (JDOMException e) {
			Log.i(LOGTAG, e.getMessage());
		}
		return tours;
	}

}