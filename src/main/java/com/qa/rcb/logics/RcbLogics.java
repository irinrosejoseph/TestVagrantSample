package com.qa.rcb.logics;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;

import com.qa.rcb.utils.RcbUtilities;

public class RcbLogics {


	//Logic for getting the total count of foreign players.
	public static int getForeignPlayersCount(JSONArray jArr)
	{
		//initialize a counter to monitor the foreign player count
		int foreignPlayerCount =0;

		//iterate through the list to get each json object
		Iterator<JSONObject> ite = jArr.iterator();
		while(ite.hasNext())
		{
			JSONObject obj = ite.next();
			Object countryObj = obj.get("country");
			if(countryObj!=null)
			{
				String country = countryObj.toString();
				if(!country.equalsIgnoreCase("india"))
				{
					foreignPlayerCount++;
				}
			}
			else
			{
				Assert.assertTrue(false,"Country details are mandatory for each player.");
			}
		}
		System.out.println("Total number of foreign players: "+foreignPlayerCount);
		return foreignPlayerCount;

	}

	//Logic for getting the total count of wicket keepers.
	public static int getKeeperCount(JSONArray jArr)
	{
		//JSONObject jObj = RcbUtilities.parseJsonData();
		//initialize a counter to monitor the wicket-keeper count
		int keeperCount =0;

		//iterate through the list to get each json object
		Iterator<JSONObject> ite = jArr.iterator();
		while(ite.hasNext())
		{
			JSONObject obj = ite.next();
			Object roleObj = obj.get("role");
			if(roleObj!=null)
			{
				String role =roleObj.toString();
				if(role.equalsIgnoreCase("Wicket-keeper"))
				{
					keeperCount++;
				}
			}
			else
			{
				Assert.assertTrue(false,"Role are mandatory for each player.");
			}
		}
		System.out.println("Total number of wicket-keepers : "+keeperCount);
		return keeperCount;
	}



}
