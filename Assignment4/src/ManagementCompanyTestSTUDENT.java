import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	
	ManagementCompany m ;
	
	@Before
	public void setUp() throws Exception {
		//create a management company
		m = new ManagementCompany("DC Realty", "4117", 11.1);
		
		// add three properties, with plots, to mgmt co
		m.addProperty("The Rittenhouse", "Washington, D.C.", 1478.44, "Aaron Jones", 1, 1, 2, 2);
		m.addProperty("Dahlia Apartments", "Washington,D.C.", 1553.21, "Marissa Sanchez", 3, 3, 2, 1);
		m.addProperty("Longfellow Apartments", "Washington,D.C.", 1765.03, "Amina Amaquandoh", 0, 5, 1, 3);
	}

	@After
	public void tearDown() {
		//student set mgmt co to null 
		m = null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		//student should add property with 4 args & default plot (0,0,1,1)
		assertEquals(m.addProperty("Lighthouse", "Beltsville", 1250, "Erica Woods"),3,0);
		//student should add property with 8 args
		assertEquals(m.addProperty("Emory Circle", "Kensington", 1100, "Ed McDonald",1,4,2,2),4,0); 
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1	
		assertEquals(m.addProperty("Monterey", "Rockville", 2700, "Jose Ruez",3,6,2,2),-1,0);
	}
	
	@Test
	public void testAddPropertyWithPlot() {
 		//should create properties with 8 args
		assertEquals(m.addProperty("Madisson", "Washington, D.C.", 3000, "Alan Curry",1,4,2,2),3,0); 
		assertEquals(m.addProperty("Riverside", "Silver Spring", 1600.0, "Henry Bond",3,4,2,2),4,0); 
		assertEquals(m.addProperty("Riverside", "Silver Spring", 1600.0, "Henry Bond",3,4,2,2),-1,0);   //exceeds the size of the array and can not be added, add property should return -1	
	}
	
	@Test
	public void testMaxPropertyRent() {
		//student should test if maxPropertyRent contains the maximum rent of properties
		String propInfo = m.maxRentPropInfo();
		assertTrue(propInfo.contains("1765.03"));
		assertTrue(propInfo.contains("Longfellow Apartments"));
		assertTrue(propInfo.contains("Washington,D.C."));
		assertTrue(propInfo.contains("Amina Amaquandoh")); 
	}
	
	@Test
	public void testtoString() {
				
		assertTrue(m.toString().contains("Property Name: The Rittenhouse"));
		assertTrue(m.toString().contains("Located in Washington"));
		assertTrue(m.toString().contains("Belonging to: Aaron Jones"));
		assertTrue(m.toString().contains("Rent Amount: 1478.44")); 
		assertTrue(m.toString().contains("Property Name: Dahlia Apartments"));
		assertTrue(m.toString().contains("Located in Washington, D.C."));
		assertTrue(m.toString().contains("Belonging to: Marissa Sanchez"));
		assertTrue(m.toString().contains("Rent Amount: 1553.21"));
		assertTrue(m.toString().contains("total management Fee: 532.431"));
		
 
	}

	@Test
	public void testTotalRent() {
		//student should test if totalRent returns the total rent of properties
		assertEquals(m.totalRent(), 4796.68, 0);
	}

 }
