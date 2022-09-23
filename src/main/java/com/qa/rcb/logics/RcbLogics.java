package com.qa.rcb.logics;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.qa.rcb.utils.RcbUtilities;

public class RcbLogics {
	
	
	//Logic for getting the total count of foreign players.
	public static int getForeignPlayersCount()
	{
		JSONObject jObj = RcbUtilities.parseJsonData();
		//initialize a counter to monitor the foreign player count
		int foreignPlayerCount =0;
		/*
		 * 
		 * In the json data players details are availble as array of json objects.
		 * Get the array and manipulate each json object that is available inside the array. 
		 */
		JSONArray jArr = (JSONArray)jObj.get("player");
		
		//iterate through the list to get each json object
		Iterator<JSONObject> ite = jArr.iterator();
		while(ite.hasNext())
		{
			JSONObject obj = ite.next();
			String country = obj.get("country").toString();
			if(!"india".equalsIgnoreCase(country))
			{
				foreignPlayerCount++;
			}
		}
		System.out.println("Total number of foreign players: "+foreignPlayerCount);
		return foreignPlayerCount;
		
	}

	
	
}
