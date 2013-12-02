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
	
	
	

	public List<Food> parseXML(Context context) throws IOException {

		//InputStream stream = context.getApplicationContext().getAssets().open("Food_Display_Table.xml");
		InputStream stream = context.getResources().openRawResource(R.raw.food_table);
		SAXBuilder builder = new SAXBuilder();
		List<Food> foodList = new ArrayList<Food>();

		try {

			Document document = (Document) builder.build(stream);
			org.jdom2.Element rootNode = document.getRootElement();
			List<org.jdom2.Element> list = rootNode.getChildren(FOOD_TAG);

			for (Element node : list) {
				Food food = new Food();
				food.setFood_Code(node.getChildText(FOOD_FOOD_CODE));
				food.setDisplay_Name(node.getChildText(FOOD_DISPLAY_NAME));
				food.setCalories(node.getChildText(FOOD_CALORIES));
				food.setPortion_Default(node.getChildText(FOOD_PORTION_DEFAULT));
				food.setPortion_Amount(node.getChildText(FOOD_PORTION_AMOUNT));
				food.setPortion_Display_Name(node.getChildText(FOOD_PORTION_DISPLAY_NAME));
				food.setFactor(node.getChildText(FOOD_FACTOR));
				food.setIncrement(node.getChildText(FOOD_INCREMENT));
				food.setMultiplier(node.getChildText(FOOD_MULTIPLIER));
				food.setFood_Code(node.getChildText(FOOD_FOOD_CODE));
				food.setGrains(node.getChildText(FOOD_GRAINS));
				food.setWhole_Grains(node.getChildText(FOOD_WHOLE_GRAINS));
				food.setVegetables(node.getChildText(FOOD_VEGETABLES));
				food.setOrange_Vegetables(node.getChildText(FOOD_ORANGE_VEGETABLES));
				food.setDrkgreen_Vegetables(node.getChildText(FOOD_DRKGREEN_VEGETABLES));
				food.setStarchy_vegetables(node.getChildText(FOOD_STARCHY_VEGETABLES));
				food.setOther_Vegetables(node.getChildText(FOOD_OTHER_VEGETABLES));
				food.setFruits(node.getChildText(FOOD_FRUITS));
				food.setMilk(node.getChildText(FOOD_MILK));
				food.setMeats(node.getChildText(FOOD_MEATS));
				food.setSoy(node.getChildText(FOOD_SOY));
				food.setDrybeans_Peas(node.getChildText(FOOD_DRYBEANS_PEAS));
				food.setOils(node.getChildText(FOOD_OILS));
				food.setSolid_Fats(node.getChildText(FOOD_SOLID_FATS));
				food.setAdded_Sugars(node.getChildText(FOOD_ADDED_SUGARS));
				food.setSolid_Fats(node.getChildText(FOOD_SOLID_FATS));
				food.setAlcohol(node.getChildText(FOOD_ALCOHOL));
				food.setCalories(node.getChildText(FOOD_CALORIES));
				food.setSaturated_Fats(node.getChildText(FOOD_SATURATED_FATS));
				foodList.add(food);
			}

		} catch (IOException e) {
			Log.i(LOGTAG, e.getMessage());
		} catch (JDOMException e) {
			Log.i(LOGTAG, e.getMessage());
		}
		return foodList;
	}

}