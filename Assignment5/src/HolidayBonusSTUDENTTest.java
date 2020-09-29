import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HolidayBonusSTUDENTTest {
	//create several (more than 2) data sets for testing. These data sets must be different
		//then the data sets in HolidayBonusTest
	private double[][] dataSet1 = {{45,12,1},{7,88},{5,10,15}};
	private double[][] dataSet2 = {{21,6,27,12},{15},{24,3,9},{33,18,21,6}};
	private double[][] dataSet3 = {{5.1,3.6,8.7,1.2},{11.1},{9.9,7.8,4.4},{1.1,2.2,7.7,5.0}};
	private double[][] dataSet4 = {{-1.0,-4.2,7.9},{-5.5,6.3},{9.1,-1.9},{-3.7,8.4,-1.4,-10.3}};
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
		/**
		 * Test calculateHolidayBonus method with a high of 5000, low of 1000 and 2000 as other
		 */

		@Test
		public void testCalculateHolidayBonusSTUDENTA() {
			//test for each of your data sets
			try{
			double[] result = HolidayBonus.calculateHolidayBonus(dataSet1,5000,1000,2000);
			assertEquals(8000.0,result[0],.001);
			assertEquals(7000.0,result[1],.001);
			assertEquals(7000.0,result[2],.001);
			
			result = HolidayBonus.calculateHolidayBonus(dataSet2,5000,1000,2000);
			assertEquals(14000.0,result[0],.001);
			assertEquals(1000.0,result[1],.001);
			assertEquals(4000.0,result[2],.001);
			assertEquals(13000.0,result[3],.001);
			
			result = HolidayBonus.calculateHolidayBonus(dataSet3,5000,1000,2000);
			assertEquals(10000.0,result[0],.001);
			assertEquals(5000.0,result[1],.001);
			assertEquals(8000.0,result[2],.001);
			assertEquals(9000.0,result[3],.001);
			
			result = HolidayBonus.calculateHolidayBonus(dataSet4,5000,1000,2000);
			assertEquals(5000.0,result[0],.001);
			assertEquals(2000.0,result[1],.001);
			assertEquals(5000.0,result[2],.001);
			assertEquals(5000.0,result[3],.001);
			}
			catch(Exception e) {
				fail("This method not yet implemented");
			}
		}
		

		/**
		 * Test calculateHolidayBonus method with a high of 1000, low of 250 and 500 as other
		 */

		@Test
		public void testCalculateHolidayBonusSTUDENTB() {
			//test for each of your data sets
			try{
				double[] result = HolidayBonus.calculateHolidayBonus(dataSet1,1000,250,500);
				assertEquals(1750.0,result[0],.001);
				assertEquals(1500.0,result[1],.001);
				assertEquals(1500.0,result[2],.001);
				
				result = HolidayBonus.calculateHolidayBonus(dataSet2,1000,250,500);
				assertEquals(3000.0,result[0],.001);
				assertEquals(250.0,result[1],.001);
				assertEquals(1000.0,result[2],.001);
				assertEquals(2750.0,result[3],.001);
				
				result = HolidayBonus.calculateHolidayBonus(dataSet3,1000,250,500);
				assertEquals(2250.0,result[0],.001);
				assertEquals(1000.0,result[1],.001);
				assertEquals(1750.0,result[2],.001);
				assertEquals(2000.0,result[3],.001);
				
				result = HolidayBonus.calculateHolidayBonus(dataSet4,1000,250,500);
				assertEquals(1000.0,result[0],.001);
				assertEquals(500.0,result[1],.001);
				assertEquals(1000.0,result[2],.001);
				assertEquals(1000.0,result[3],.001);
				}
			catch (Exception e) {
			fail("This method not yet implemented");
			}
		}

		/**
		 * Test calculateTotalHolidayBonus method with a high of 5000, low of 1000 and 2000 as other
		 */
	@Test
	public void testCalculateTotalHolidayBonusA() {
		//test for each of your data sets
		assertEquals(22000.0,HolidayBonus.calculateTotalHolidayBonus(dataSet1, 5000, 1000, 2000),.001);
		assertEquals(32000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet2, 5000, 1000, 2000), .001);
		assertEquals(32000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet3, 5000, 1000, 2000), .001);
		assertEquals(17000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet4, 5000, 1000, 2000), .001);
		//fail("This method not yet implemented");

	}
	
	/** 
	 * Test calculateTotalHolidayBonus method with a high of 1000, low of 250 and 500 as other
	 */
	@Test
	public void testCalculateTotalHolidayBonusB() {
		//test for each of your data sets
		assertEquals(4750.0, HolidayBonus.calculateTotalHolidayBonus(dataSet1, 1000, 250, 500), .001);
		assertEquals(7000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet2, 1000, 250, 500), .001);
		assertEquals(7000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet3, 1000, 250, 500), .001);
		assertEquals(3500.0, HolidayBonus.calculateTotalHolidayBonus(dataSet4, 1000, 250, 500), .001);
		//fail("This method not yet implemented");
	}

}
