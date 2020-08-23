import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest 
{
	private MenuItem mi1;
	private MenuItem mi2;
	
	private ArrayList<MenuItem> menuItemList;
	
	public C206_CaseStudyTest()
	{
		super();
	}

	@Before
	public void setUp() throws Exception 
	{
		mi1 = new MenuItem("Western", "Fries", false, 3.0);
		mi2 = new MenuItem("Vegetarian", "Cabbage", true, 1.5);
		
		menuItemList = new ArrayList<MenuItem>();
	}

	@After
	public void tearDown() throws Exception 
	{
		mi1 = null;
		mi2 = null;
		
		menuItemList = null;
	}

	@Test
	public void testAddMenuItem() 
	{
		//Done by Wen Ning
		
		//Given an empty list, after adding 1 item, item should be the same as first item of the list -normal
		C206_CaseStudy.addMenuItem(menuItemList, mi1);
		assertSame("Check that item is added", mi1, menuItemList.get(0));
		
		//test if duplicate item is added -error
		boolean ok;
		
		ok = C206_CaseStudy.addMenuItem(menuItemList, mi1);
		assertFalse("Test if duplicate item is NOT ok to add", ok);
		
		//test if name exceeding size of 20 is added -boundary
		String testName = "";
		for(int i = 0; i < 20; i++)
		{
			testName += "A";
		}
		MenuItem miTest = new MenuItem("", testName, false, 0);
		ok = C206_CaseStudy.addMenuItem(menuItemList, miTest);
		assertFalse("Test if name longer than 20 is not added", ok);
	}

	@Test
	public void testViewAllMenuItem() 
	{
		//Done by Wen Ning
		
		//test if item list is empty, not null -boundary
		assertNotNull("Test is there is a valid menuItemList to retrieve from", menuItemList);
		
		//test if empty string is retrieved when item list is empty -error
		String testOutput = C206_CaseStudy.retrieveAllMenuItem(menuItemList);
		assertSame("Test if output string is empty when item list is empty", testOutput, "");
		
		//test if the expected output string is the same as MenuItemList retrieved from Case Study -normal
		C206_CaseStudy.addMenuItem(menuItemList, mi1);
		C206_CaseStudy.addMenuItem(menuItemList, mi2);
		String allMenuItem = C206_CaseStudy.retrieveAllMenuItem(menuItemList);

		testOutput = String.format("%-30s %-20s %-10s %s", "Fries", "Western", "3.0", "false");
		testOutput += String.format("%-30s %-20s %-10s %s", "Cabbage", "Vegetarian", "1.5", "true");
		
		assertEquals("Test that ViewAllMenuItem works", testOutput, allMenuItem);
	}
	
	@Test
	public void testDeleteMenuItem() 
	{
		//Done by Wen Ning
		
		//test if item can be deleted after being added -normal
		boolean ok;
		
		C206_CaseStudy.addMenuItem(menuItemList, mi1);
		ok = C206_CaseStudy.deleteMenuItem(menuItemList, mi1);
		assertTrue("Test if an existing item can be deleted", ok);
		
		//test if a non-existing item can not be deleted -error
		ok = C206_CaseStudy.deleteMenuItem(menuItemList, mi2);
		assertFalse("Test if a non-existing item is NOT ok to delete", ok);
		
		//test if an empty item can not be deleted -error
		MenuItem miTest = new MenuItem("", "", false, 0);
		ok = C206_CaseStudy.addMenuItem(menuItemList, miTest);
		assertFalse("Test if an item is NOT ok to delete", ok);
	}
}
