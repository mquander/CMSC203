import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilitySTUDENTTest {
	//create several (more than 2) data sets for testing. These data sets must be different
	//then the data sets in TwoDimRaggedArrayUtilityTest
	private double[][] dataSet1 = {{2,4,6},{3,7},{1,3,5}};
	private double[][] dataSet2 = {{4,5,7,6},{7},{2,7,1},{8,4,6,1}};
	private double[][] dataSet3 = {{3.4,1.7,-7.8},{4.3},{-1.4,2.7,3.9},{14.7,-2.4,5.5,6.8}};

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		//set your data sets to null
		dataSet1 = dataSet2 = dataSet3 = null;
	}

	/**
	 * Test getTotal method
	 * Returns the total of all the elements in the two dimensional array
	 */
	@Test
	public void testGetTotalSTUDENT() {
		//Test for all your data sets
		assertEquals(31, TwoDimRaggedArrayUtility.getTotal(dataSet1), .001);
		assertEquals(58, TwoDimRaggedArrayUtility.getTotal(dataSet2), .001);
		assertEquals(31.4, TwoDimRaggedArrayUtility.getTotal(dataSet3), .001);
		//fail("Not yet implemented");
	}

	/**
	 * Test getAverage method
	 * Returns the average of all the elements in the two dimensional array
	 */
	@Test
	public void testGetAverageSTUDENT() {
		//Test for all your data sets
		assertEquals(3.875, TwoDimRaggedArrayUtility.getAverage(dataSet1), .001);
		assertEquals(4.833, TwoDimRaggedArrayUtility.getAverage(dataSet2), .001);
		assertEquals(2.855, TwoDimRaggedArrayUtility.getAverage(dataSet3), .001);
		//fail("Not yet implemented");
	}

	
	/**
	 * Test getRowTotal method
	 * Returns the total of all the elements of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotalSTUDENT() {
		//Test for at least 2 rows within each data set
		assertEquals(12.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 0), .001);
		assertEquals(10.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet2, 2), .001);
		assertEquals(24.6, TwoDimRaggedArrayUtility.getRowTotal(dataSet3, 3), .001);
		//fail("Not yet implemented");
	}
	

	/**
	 * Test getColumnTotal method
	 * Returns the total of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetColumnTotalSTUDENT() {
		//Test for at least 2 columns in each data set
		assertEquals(6.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 0), .001);
		assertEquals(21.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet2, 0), .001);
		assertEquals(21.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet3, 0), .001);
		//fail("Not yet implemented");
	}
	

	/**
	 * Test getHighestInRow method
	 * Returns the largest of all the elements in the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetHighestInRowSTUDENT() {
		//Test for at least 2 rows within each data set
		assertEquals(6.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 0), .001);
		assertEquals(7.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSet2, 2), .001);
		assertEquals(14.7, TwoDimRaggedArrayUtility.getHighestInRow(dataSet3, 3), .001);
		//fail("Not yet implemented");
	}

	/**
	 * Test getHighestInRowIndex method
	 * Returns the index of the largest of all the elements in the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetHighestInRowIndexSTUDENT() {
		//Test for at least 2 rows within each data set
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1, 2));
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet2, 0));
		assertEquals(0, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet3, 3));
		//fail("Not yet implemented");
	}
	
	
	/**
	 * Test getLowestInColumn method
	 * Returns the smallest of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */

	@Test
	public void testGetLowestInColumnSTUDENT() {
		//Test for at least 2 columns in each data set
		assertEquals(5.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 2), .001);
		assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet2, 2), .001);
		assertEquals(-2.4, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet3, 1), .001);
		//fail("Not yet implemented");
	}

	/**
	 * Test getLowestInColumnIndex method
	 * Returns the index of the smallest of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */

	@Test
	public void testGetLowestInColumnIndexSTUDENT() {
		//Test for at least 2 columns in each data set
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 0));
		assertEquals(2, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet2, 2));
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet3, 3));
		//fail("Not yet implemented");
	}
	

	/**
	 * Test getLowestInArray method
	 * Returns the smallest of all the elements in the two dimensional array.
	 */
	@Test
	public void testGetLowestInArraySTUDENT() {
		//Test for each data set
		assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInArray(dataSet1), .001);
		assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInArray(dataSet2), .001);
		assertEquals(-7.8, TwoDimRaggedArrayUtility.getLowestInArray(dataSet3), .001);
		//fail("Not yet implemented");
	}
	
	
	
}
