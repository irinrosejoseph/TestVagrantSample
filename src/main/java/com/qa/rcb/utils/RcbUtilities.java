package com.qa.rcb.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.qa.rcb.base.RcbBase;

public class RcbUtilities extends RcbBase{
	
	//This method parse the json data file and returns as Json object
	public static JSONObject parseJsonData()
	{
		JSONObject jObj = null;
		String filePath = System.getProperty("user.dir")+prop.getProperty("JSON_DATA_PATH");
		JSONParser jParser = new JSONParser();
		try {
				Object obj = jParser.parse(new FileReader(filePath));
				jObj = (JSONObject)obj;
		
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		return jObj;
		
	}

}
