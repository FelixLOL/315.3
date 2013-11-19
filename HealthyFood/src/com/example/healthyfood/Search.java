/*package com.example.healthyfood;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class Search extends Activity{
	
	

	private void parseXML(XmlPullParser parser) throws XmlPullParserException,IOException
	{
		ArrayList<product> products = null;
        int eventType = parser.getEventType();
        Product currentProduct = null;

        while (eventType != XmlPullParser.END_DOCUMENT){
            String name = null;
            switch (eventType){
                case XmlPullParser.START_DOCUMENT:
                	products = new ArrayList();
                    break;
                case XmlPullParser.START_TAG:
                    name = parser.getName();
                    if (name == "product"){
                        currentProduct = new Product();
                    } else if (currentProduct != null){
                        if (name == "productname"){
                            currentProduct.name = parser.nextText();
                        } else if (name == "productcolor"){
                        	currentProduct.color = parser.nextText();
                        } else if (name == "productquantity"){
                            currentProduct.quantity= parser.nextText();
                        }  
                    }
                    break;
                case XmlPullParser.END_TAG:
                    name = parser.getName();
                    if (name.equalsIgnoreCase("product") && currentProduct != null){
                    	products.add(currentProduct);
                    } 
            }
            eventType = parser.next();
        }

        printProducts(products);
	}

	private void printProducts(ArrayList</product><product> products)
	{
		String content = "";
		Iterator</product><product> it = products.iterator();
		while(it.hasNext())
		{
			Product currProduct  = it.next();
			content = content + "nnnProduct :" +  currProduct.name + "n";
			content = content + "Quantity :" +  currProduct.quantity + "n";
			content = content + "Color :" +  currProduct.color + "n";

		}

		TextView display = (TextView)findViewById(R.id.info);
		display.setText(content);
	}

	

}

*/