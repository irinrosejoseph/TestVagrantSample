package com.qa.rcb.testCases;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.rcb.base.RcbBase;
import com.qa.rcb.logics.RcbLogics;
import com.qa.rcb.utils.RcbUtilities;

public class RcbLogicsTest extends RcbBase{

	/*call the super constructor as properties file needed to 
	 * be loaded to read property values
	 * 
	 */
	public RcbLogicsTest()
	{
		super();
	}
	JSONObject jObj = null;
	JSONArray jArr = new JSONArray();
	@BeforeTest
	public void setUp()
	{
		/*
		 * 
		 * In the json data players details are availble as array of json objects.
		 * Get the array and manipulate each json object that is available inside the array. 
		 */
		jObj = RcbUtilities.parseJsonData();
		if(jObj != null)
		{
			jArr = (JSONArray)jObj.get("player");
		}
		else
		{
			Assert.assertTrue(false,"JSON data not available");
		}
	}

	//Test to assert the number of foreign players in the team
	@Test(priority = 1)
	public void foreignPlayersLogicTest()
	{
		if(jArr != null)
		{
			int fCount = RcbLogics.getForeignPlayersCount(jArr);
			//get the master count of foreign players configured in the properties file.
			int masterCount = Integer.parseInt(prop.getProperty("MAX_FOREIGN_CNT"));

			Assert.assertTrue(fCount<=masterCount, "The test failed as Total number of foreign players ("+fCount+") exceeded "+masterCount);
		}
		else
		{
			Assert.assertTrue(false,"Player details not available to check foreign players");
		}
	}

	//Test to assert atleast one wicket keeper in team
	@Test(priority =2)
	public void wicketKeeperLogicTest()
	{
		if(jArr != null)
		{
			int wCount = RcbLogics.getKeeperCount(jArr);
			//get the master count of wicket keepers configured in the properties file.
			int masterCount = Integer.parseInt(prop.getProperty("MIN_KEEPER_CNT"));

			Assert.assertTrue(wCount>=masterCount,"The test failed as atleast "+masterCount+" wicket keeper should be in the team. Actual number of wicket keepers is "+wCount);
		}
		else
		{
			Assert.assertTrue(false,"Player details not available to check wicket keepers");
		}
	}

}
