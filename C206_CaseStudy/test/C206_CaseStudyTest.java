import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private MenuItem mi1;
	private MenuItem mi2;
	private Menu mm1;
	private Menu mm2;
	private Bill b1;
	private ArrayList<Bill> billList;
	private ArrayList<MenuItem> menuItemList;
	private ArrayList<Menu> monthlyMenu;

	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		billList = new ArrayList<Bill>();
		menuItemList = new ArrayList<MenuItem>();
		monthlyMenu = new ArrayList<Menu>();

		mi1 = new MenuItem("western", "Fries", false, 3.0);
		mi2 = new MenuItem("vegetarian", "Cabbage", true, 1.5);

		mm1 = new Menu("July Menu", 7, 1, menuItemList);
		mm2 = new Menu("August Menu", 8, 2, menuItemList);
		
		monthlyMenu.add(mm1);
		monthlyMenu.add(mm2);
		b1 = new Bill("Verzon", 123.0, "20201231");
	}

	@Test
	public void testAddMenuItem() {
		// Done by Wen Ning
		
		boolean ok;

		// Given an empty list, after adding 1 item, item should be the same as first
		// item of the list -normal
		C206_CaseStudy.addMenuItem(menuItemList, mi1);
		assertSame("Check that item is added", mi1, menuItemList.get(0));

		// test if duplicate item is added -error
		ok = C206_CaseStudy.addMenuItem(menuItemList, mi1);
		assertFalse("Test if duplicate item is NOT ok to add", ok);

		// test if name exceeding size of 20 is added -boundary
		String testName = "";
		for (int i = 0; i < 21; i++) {
			testName += "A";
		}
		MenuItem miTest = new MenuItem("", testName, false, 0);
		ok = C206_CaseStudy.addMenuItem(menuItemList, miTest);
		assertFalse("Test if name longer than 20 is not added", ok);
		
		// test if item price is more than 0 -boundary
		ok = C206_CaseStudy.addMenuItem(menuItemList, miTest);
		assertFalse("Test if item price is less than or equal to 0 is not added", ok);
	}

	@Test
	public void testViewMenuItem() {
		// Done by Wen Ning
		
		boolean ok = false;

		// test if item list is empty, not null -boundary
		assertNotNull("Test is there is a valid menuItemList to retrieve from", menuItemList);

		// test if empty string is retrieved when item list is empty -error
		String testOutput = C206_CaseStudy.retrieveAllMenuItem(menuItemList);
		assertEquals("Test if output string is empty when item list is empty", testOutput, "");

		// test if the expected output string is the same as MenuItemList retrieved from
		// Case Study -normal
		C206_CaseStudy.addMenuItem(menuItemList, mi1);
		C206_CaseStudy.addMenuItem(menuItemList, mi2);
		String allMenuItem = C206_CaseStudy.retrieveAllMenuItem(menuItemList);

		testOutput = String.format("%-20s %-20s %-10s %s\n", "Cabbage", "vegetarian", "1.5", "true");
		testOutput += String.format("%-20s %-20s %-10s %s\n", "Fries", "western", "3.0", "false");

		assertEquals("Test that ViewAllMenuItem works", testOutput, allMenuItem);
		
		// test if empty category is skipped -normal
		ok = allMenuItem.contains("asian");
		assertFalse("Test if asian category is now shown", ok);
		
		// test if a non-existing item can not be searched -error
		ok = C206_CaseStudy.searchMenuItem(menuItemList, "Watermelon");
		assertFalse("Test if a non-existing item is NOT ok to search", ok);
	}

	@Test
	public void testDeleteMenuItem() {
		// Done by Wen Ning

		boolean ok;
		
		// test if item can be deleted after being added -normal
		C206_CaseStudy.addMenuItem(menuItemList, mi1);
		ok = C206_CaseStudy.deleteMenuItem(menuItemList, mi1.getName());
		assertTrue("Test if an existing item can be deleted", ok);

		// test if a non-existing item can not be deleted -error
		ok = C206_CaseStudy.deleteMenuItem(menuItemList, mi2.getName());
		assertFalse("Test if a non-existing item is NOT ok to delete", ok);

		// test if an empty item name can not be deleted -error
		MenuItem miTest = new MenuItem("", "", false, 0);
		ok = C206_CaseStudy.deleteMenuItem(menuItemList, miTest.getName());
		assertFalse("Test if an empty item name is NOT ok to delete", ok);
	}
	
	@Test
	public void testUpdateMenuItem()
	{
		//Done by Wen Ning
		
		boolean ok = false;
		
		// test if item can be updated after being added -normal
		C206_CaseStudy.addMenuItem(menuItemList, mi1);
		MenuItem miTest = new MenuItem("western", "Fries", false, 4.0);
		ok = C206_CaseStudy.updateMenuItem(menuItemList, miTest, "Burger");
		assertTrue("Test if an existing item can be updated", ok);
		
		// test if a non-existing item can not be updated -error
		ok = C206_CaseStudy.updateMenuItem(menuItemList, mi2, "Burger");
		assertFalse("Test if a non-existing item is NOT ok to update", ok);
		
		// test if an empty item name can not be updated -error
		MenuItem miTest2 = new MenuItem("", "", false, 0);
		ok = C206_CaseStudy.updateMenuItem(menuItemList, miTest2, "Burger");
		assertFalse("Test if an empty item name is NOT ok to update", ok);
	}

	// monthly menu
	// done by Pei Wen
		@Test
		public void testCreateMenu() {
			// check the menu is created. -normal
			C206_CaseStudy.createMenu(monthlyMenu, mm1);
			assertSame("Check that menu is create", mm1, monthlyMenu.get(0));

			// check duplicate - error
			boolean duplicate;
			duplicate = C206_CaseStudy.createMenu(monthlyMenu, mm1);
			assertFalse("Test if duplicate menu cannot to create", duplicate);

			// Test that the month is valid -boundary
			C206_CaseStudy.updateMenu(monthlyMenu);
			int month = monthlyMenu.get(0).getMonth();
			assertTrue(month >= 1 && month <= 12);

		}

		@Test
		public void testViewMenu() {
			String output = "";
			// check the list is not null -error
			assertNotNull("Test is there is a valid monthlyMenu to retrieve from", monthlyMenu);

			// test the monthly menu are correct - normal

			String allMonthlyMenu = C206_CaseStudy.retrieveAllMonthlyMenu(monthlyMenu);
			
			output += String.format("%-20s %-10s %-15s %-15s %-10s %-10b %-10.2f\n", "July Menu", "7", "1", "Western", "Fries",
					false, 3.0);
			
			output += String.format("%-20s %-10s %-15s %-15s %-10s %-10b %-10.2f\n", "August Menu", "8", "2", "Vegetarian",
					"Cabbage", true, 1.5);

			assertEquals("Test that ViewAllMenuItem works", output, allMonthlyMenu);
		}

		@Test
		public void testDeleteMenu() {
			// test that the system can delete the existing menu -normal
			boolean canDelete;

			C206_CaseStudy.createMenu(monthlyMenu, mm1); // only create mm1
			canDelete = C206_CaseStudy.deleteMenu(monthlyMenu, mm1);
			canDelete = true;
			assertTrue("Test if an existing menu can be deleted", canDelete);

			// test if a non-existing item can not be deleted -error
			canDelete = C206_CaseStudy.deleteMenu(monthlyMenu, mm2);
			canDelete = false;
			assertFalse("Test if a non-existing menu cannot be deleted", canDelete);

			// test if an existing can not be deleted -error
			Menu mmTest = new Menu("June Menu", 6, 1, menuItemList);
			canDelete = C206_CaseStudy.deleteMenu(monthlyMenu, mmTest);
			canDelete = false;
			assertFalse("Test if an item cannot be deleted", canDelete);
		}
		@Test
		public void testUpdateMenu() {
			boolean canUpdate = false;
			// test if menu can be updated -normal
			C206_CaseStudy.createMenu(monthlyMenu, mm1);
			Menu mmTest = new Menu("July Menu", 7, 1, menuItemList);
			canUpdate = C206_CaseStudy.updateMonthlyMenu(monthlyMenu,"August Menu",mmTest);
			assertTrue("Test if an existing menu can be updated", canUpdate);

			// Test that display name has been updated
			C206_CaseStudy.updateMenu(monthlyMenu);
			assertEquals("Check that display name has been updated", monthlyMenu.get(0).getDisplayName(), "August Menu");

			// Test that the month is valid -boundary
			C206_CaseStudy.updateMenu(monthlyMenu);
			int month = monthlyMenu.get(0).getMonth();
			assertTrue(month >= 1 && month <= 12);

			// Test that month has been updated
			C206_CaseStudy.updateMenu(monthlyMenu);
			assertEquals("Check that month has been updated", monthlyMenu.get(0).getMonth(), 8);
		}


	// Verzon
	@Test
	public void testCreateBill() {
		// check the menu is able to be created
		C206_CaseStudy.createBill(billList);
		assertSame("Check that menu is create", b1, billList.get(0));
	}

	@Test
	public void testViewBill() {
		C206_CaseStudy.createBill(billList);
		String allMonthlyMenu = C206_CaseStudy.viewBill(bill);
	}

	@Test
	public void testDeleteBill() {
		// test that the system can delete the existing menu
		boolean deleteBill;

		C206_CaseStudy.createBill(billList);
		deleteBill = C206_CaseStudy.deleteBill(bill);
		assertTrue("Test if an existing menu can be deleted", deleteBill);
	}
	@Test
	public void testUpdateBill() {
		// test that the system can update the existing menu


		C206_CaseStudy.createBill(billList);
		updateBill = C206_CaseStudy.deleteBill(bill);
		assertTrue("Test if an existing menu can be deleted", updateBill);
	}

	@After
	public void tearDown() throws Exception {
		mi1 = null;
		mi2 = null;

		menuItemList = null;
	}
}
