package com.qa.rcb.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.rcb.base.RcbBase;
import com.qa.rcb.logics.RcbLogics;

public class RcbLogicsTest extends RcbBase{
	
	/*call the super constructor as properties file needed to 
	 * be loaded to read property values
	 * 
	 */
	public RcbLogicsTest()
	{
		super();
	}
	
	//Test to assert the number of foreign players in the team
	@Test(priority = 1)
	public static void foreignPlayersLogicTest()
	{
		int fCount = RcbLogics.getForeignPlayersCount();
		//get the master count of foreign players configured in the properties file.
		int masterCount = Integer.parseInt(prop.getProperty("MAX_FOREIGN_CNT"));
		
		Assert.assertTrue(fCount<=masterCount, "The test failed as Total no of foreign players ("+fCount+") exceeded "+masterCount);
	}
	
	//Test to assert atleast one wicket keeper in team
	@Test(priority =2)
	public static void wicketKeeperLogicTest()
	{
		int wCount = RcbLogics.getKeeperCount();
		//get the master count of wicket keepers configured in the properties file.
		int masterCount = Integer.parseInt(prop.getProperty("MIN_KEEPER_CNT"));
		
		Assert.assertTrue(wCount>=masterCount,"The test failed as atleast "+masterCount+" wicket keeper should be in the team. Actual number of wicket keepers is "+wCount);
		
	}

}
