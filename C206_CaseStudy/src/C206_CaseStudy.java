import java.util.ArrayList;
import java.util.Random;

public class C206_CaseStudy {
	private static ArrayList<Account> AccountList = new ArrayList<Account>();
	private static ArrayList<Menu> monthlyMenu = new ArrayList<Menu>();
	private static ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
	private static ArrayList<Bill> billList = new ArrayList<Bill>();
	

	public static void main(String[] args) {

		int option = 0;

		while (option != 6) {
			optionMenu();
			option = Helper.readInt("Which action do you want perform? > ");

			if (option == 1) {
				menu();
				int num = Helper.readInt("Which action do you want to perform? > ");
				Helper.line(80, "-");
				if (num == 1) {
					String newName = Helper.readString("Enter new Account username:");
					String newStudentId = Helper.readString("Enter new Student ID:");
					String newContactNumber = Helper.readString("Enter your contact number:");
					String newRole = Helper.readString("Enter user role:");
					createUserAccount(AccountList, newName, newStudentId, newContactNumber, newRole);
				}
				if (num == 2) {
					viewUserAccount(AccountList);
				}
				if (num == 3) {
					String oldName1 = Helper.readString("Enter name of deleting account :");
					String oldStudentID1 = Helper.readString("Enter Student ID of deleting Account :");
					deleteUserAccount(AccountList, oldName1, oldStudentID1);
				}
				if (num == 4) {
					System.out.println("1.Edit name");
					System.out.println("2.Edit student ID");
					System.out.println("3.Edit both");
					int user_edit = Helper.readInt("What do you want to edit?");
					String oldName = Helper.readString("Enter old name you want to edit:");
					String oldStudentId = Helper.readString("Enter old StudentID you want to edit:");
					updateUserAccount(AccountList, user_edit, oldName, oldStudentId);
				}
				if (num == 5) {
					searchUserAccount(AccountList);
				}
			} else if (option == 2) {
				menu();
				int num = Helper.readInt("Which action do you want to perform? > ");
				Helper.line(80, "-");
				if (num == 1) {
					if (loginAdmin(AccountList)) {
						inputAddMenuItem(menuItemList);
					}
				} else if (num == 2) {
					System.out.println("1. View All");
					System.out.println("2. Search");
					int j = Helper.readInt("Which action do you want to perform? > ");
					if (j == 1) {
						viewAllMenuItem(menuItemList);
					} else if (j == 2) {
						inputSearchMenuItem(menuItemList);
					} else {
						System.out.println("Invalid option.");
					}
				} else if (num == 3) {
					if (loginAdmin(AccountList)) {
						inputDeleteMenuItem(menuItemList);
					}
				} else if (num == 4) {
					if (loginAdmin(AccountList)) {
						inputUpdateMenuItem(menuItemList);
					}
				} else {
					System.out.println("Invalid option.");
				}
			} else if (option == 3) {

			} else if (option == 4) {
				menu();
				int num = Helper.readInt("Which action do you want perform? > ");

				if (num == 1) {
					createBill(billList);
				} else if (num == 2) {
					viewBill(billList);
				} else if (num == 3) {
					deleteBill(billList);
				} else if (num == 4) {
					updateBill(billList);
				} else {
					System.out.println("Invalid option.");
				}

			} else if (option == 5) {
				menu();
				int num = Helper.readInt("Which action do you want perform? > ");
				if (num == 1) {
					inputCreateMenu(monthlyMenu);
				} else if (num == 2) {
					viewAllMenu(monthlyMenu);
				} else if (num == 3) {
					inputDeleteMenu(monthlyMenu);
				} else if (num == 4) {
					updateMenu(monthlyMenu);
				} else {
					System.out.println("Invalid option.");
				}
			} else if (option == 6) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option.");
			}
		}
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	public static void userTypeMenu() {
		C206_CaseStudy.setHeader("User Type:");
		System.out.println("1. Parent");
		System.out.println("2. Student");
		System.out.println("3. Admin");
	}

	public static void optionMenu() {
		C206_CaseStudy.setHeader("Menu Type:");
		System.out.println("1. User Account");
		System.out.println("2. Menu Item");
		System.out.println("3. Order");
		System.out.println("4. Bill");
		System.out.println("5. Monthly Menu");
	}

	public static void menu() {
		System.out.println("1. Create");
		System.out.println("2. View");
		System.out.println("3. Delete");
		System.out.println("4. Update");
	}

	public static boolean loginAdmin(ArrayList<Account> AccountList) {
		String name = Helper.readString("Enter account username > ");
		for (int i = 0; i < AccountList.size(); i++) {
			if (name.equals(AccountList.get(i).getName()) && AccountList.get(i).getRole().equalsIgnoreCase("admin")) {
				System.out.println("Log in successful");
				return true;
			}
		}
		System.out.println("No such username or not admin!");
		return false;
	}

	// ----------------------------Option 1----------------------------
	// Done by Aravind
	public static void createUserAccount(ArrayList<Account> AccountList, String newName, String newStudentId,
			String newContactNumber, String newRole) {
		Account newAccount = new Account(newName, newStudentId, newContactNumber, newRole);
		AccountList.add(newAccount);
		System.out.println("Account has been successfully added!");
	}

	public static void viewUserAccount(ArrayList<Account> AccountList) {
		String header = String.format("%s %20s %20s %10s", "USERNAME", "STUDENT ID", "CONTACT", "ROLE");
		System.out.println(header);
		Helper.line(80, "-");
		for (int i = 0; i < AccountList.size(); i++) {
			String userName = AccountList.get(i).getName();
			String stID = AccountList.get(i).getStudentId();
			String conNum = AccountList.get(i).getContactNumber();
			String rle = AccountList.get(i).getRole();
			String format = String.format("%s %20s %20s %20s", userName, stID, conNum, rle);
			System.out.println(format);
		}
	}

	public static void deleteUserAccount(ArrayList<Account> AccountList, String oldName1, String oldStudentID1) {
		for (int i = 0; i < AccountList.size(); i++) {
			if (AccountList.get(i).getName().equalsIgnoreCase(oldName1)
					&& AccountList.get(i).getStudentId().equalsIgnoreCase(oldStudentID1)) {
				AccountList.remove(i);
				System.out.println("Account has been successfully deleted!");
				break;
			}
		}
	}

	public static void updateUserAccount(ArrayList<Account> AccountList, int user_edit, String oldName,
			String oldStudentID) {
		for (int i = 0; i < AccountList.size(); i++) {
			if (AccountList.get(i).getName().equalsIgnoreCase(oldName)
					&& AccountList.get(i).getStudentId().equalsIgnoreCase(oldStudentID)) {
				if (user_edit == 1) {
					String modName = Helper.readString("Enter new edited name: ");
					if (sameUserName(AccountList, modName) == true) {
						System.out.println("Username already exists in the database. Please try again.");
						modName = Helper.readString("Enter new edited name: ");
						AccountList.get(i).setName(modName);
					} else {
						AccountList.get(i).setName(modName);
					}
					System.out.println("Name has been modified!");
					break;
				}
				if (user_edit == 2) {
					String modID = Helper.readString("Enter new edited StudentId: ");
					AccountList.get(i).setStudentId(modID);
					System.out.println("Student ID  has been modified!");
					break;
				}
				if (user_edit == 3) {
					String modName = Helper.readString("Enter new edited name: ");
					String modID = Helper.readString("Enter new edited StudentId: ");
					if (sameUserName(AccountList, modName) == true) {
						System.out.println("Username already exists in the database. Please try again.");
						modName = Helper.readString("Enter new edited name: ");
						AccountList.get(i).setName(modName);
					} else {
						AccountList.get(i).setName(modName);
					}
					AccountList.get(i).setStudentId(modID);
					System.out.println("Student ID and Name has been modified!");
					break;

				}
			}
		}

	}

	public static boolean sameUserName(ArrayList<Account> AccountList, String checkName) {
		String testName = "";
		for (int i = 0; i < AccountList.size(); i++) {
			if (AccountList.get(i).getName().equalsIgnoreCase(checkName)) {
				testName = AccountList.get(i).getName();
			}
		}
		if (testName.equalsIgnoreCase(checkName)) {
			return true;
		} else {
			return false;
		}
	}

	public static void searchUserAccount(ArrayList<Account> AccountList) {
		String searchID = Helper.readString("Enter Student ID:");
		String header = String.format("%s %20s %20s %10s", "USERNAME", "STUDENT ID", "CONTACT", "ROLE");
		System.out.println(header);
		Helper.line(80, "-");
		for (int i = 0; i < AccountList.size(); i++) {
			if (AccountList.get(i).getStudentId().equalsIgnoreCase(searchID)) {
				String userName = AccountList.get(i).getName();
				String stID = AccountList.get(i).getStudentId();
				String conNum = AccountList.get(i).getContactNumber();
				String rle = AccountList.get(i).getRole();
				String format = String.format("%s %20s %20s %20s", userName, stID, conNum, rle);
				System.out.println(format);
				break;
			}

		}
	}

	// ----------------------------Option 2----------------------------

	public static void inputAddMenuItem(ArrayList<MenuItem> menuItemList) {
		// Done by Wen Ning

		boolean isAdded = false;

		String name = Helper.readString("Enter name of item to add > ").trim();
		String category = Helper.readString("Enter category of item > ").trim().toLowerCase();
		double price = Helper.readDouble("Enter price of item > $");
		String choice = Helper.readString("Is this menu item healthy? (Y/N) > ").trim();
		boolean healthyChoice = false;

		if (choice.equalsIgnoreCase("Y")) {
			healthyChoice = true;
		} else if (choice.equalsIgnoreCase("N")) {
			healthyChoice = false;
		} else {
			System.out.println("Invalid choice!");
		}

		String confirm = Helper.readString("Are you sure? (Y/N) > ").trim();
		if (confirm.equalsIgnoreCase("Y")) {
			MenuItem mi = new MenuItem(category, name, healthyChoice, price);
			isAdded = addMenuItem(menuItemList, mi);
		} else if (confirm.equalsIgnoreCase("N")) {
			System.out.println("Cancelled creation of item!");
		} else {
			System.out.println("Invalid choice!");
		}

		if (isAdded) {
			System.out.println("Item added!");
		} else {
			System.out.println("Item not added!");
		}
	}

	public static boolean addMenuItem(ArrayList<MenuItem> menuItemList, MenuItem mi) {
		// Done by Wen Ning

		if (mi.getName().length() > 20) {
			System.out.println("Name is too long!");
			return false;
		}

		if (mi.getName().equals("")) {
			System.out.println("Name of item cannot be empty!");
			return false;
		}

		if (mi.getPrice() <= 0) {
			System.out.println("Invalid price!");
			return false;
		}

		if (!(mi.getCategory().equals("asian") || mi.getCategory().equals("vegetarian")
				|| mi.getCategory().equals("western"))) {
			System.out.println("Invalid category!");
			return false;
		}

		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getName().equalsIgnoreCase(mi.getName())) {
				System.out.println("Duplicate item!");
				return false;
			}
		}
		menuItemList.add(mi);
		return true;
	}

	public static void inputDeleteMenuItem(ArrayList<MenuItem> menuItemList) {
		// Done by Wen Ning

		String name = Helper.readString("Enter name of item to delete > ").trim();

		boolean isDeleted = deleteMenuItem(menuItemList, name);
		if (isDeleted) {
			System.out.println("Item removed!");
		} else {
			System.out.println("Item not found!");
		}
	}

	public static boolean deleteMenuItem(ArrayList<MenuItem> menuItemList, String name) {
		// Done by Wen Ning

		if (name.equals("")) {
			System.out.println("Name of item can not be empty!");
			return false;
		}

		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getName().equalsIgnoreCase(name)) {
				menuItemList.remove(i);
				return true;
			}
		}
		return false;
	}

	public static void viewAllMenuItem(ArrayList<MenuItem> menuItemList) {
		// Done by Wen Ning

		String output = "";
		output = retrieveAllMenuItem(menuItemList);

		if (!output.equals("")) {
			System.out.println(String.format("%-20s %-20s %-10s %s", "Name", "Category", "Price", "Healthy Choice"));
			Helper.line(80, "-");
			System.out.println(output);
		} else {
			System.out.println("There are no menu items!");
		}
	}

	public static String retrieveAllMenuItem(ArrayList<MenuItem> menuItemList) {
		// Done by Wen Ning

		String output = "";

		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getCategory().equals("asian")) {
				output += menuItemList.get(i).toString();
			}
		}

		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getCategory().equals("vegetarian")) {
				output += menuItemList.get(i).toString();
			}
		}

		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getCategory().equals("western")) {
				output += menuItemList.get(i).toString();
			}
		}
		return output;
	}

	public static void inputSearchMenuItem(ArrayList<MenuItem> menuItemList) {
		// Done by Wen Ning

		String name = Helper.readString("Enter item name to search > ").trim();

		boolean isFound = searchMenuItem(menuItemList, name);
		if (!isFound) {
			System.out.println("Item not found!");
		}
	}

	public static boolean searchMenuItem(ArrayList<MenuItem> menuItemList, String name) {
		// Done by Wen Ning

		if (name.equals("")) {
			System.out.println("Name of item cannot be empty!");
		}

		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getName().equalsIgnoreCase(name)) {
				System.out.println(
						String.format("%-20s %-20s %-10s %s\n", "Name", "Category", "Price", "Healthy Choice"));
				menuItemList.get(i).toString();
				return true;
			}
		}
		return false;
	}

	public static void inputUpdateMenuItem(ArrayList<MenuItem> menuItemList) {
		// Done by Wen Ning

		boolean isUpdated = false;

		String name = Helper.readString("Enter name of item to update > ").trim().toLowerCase();
		String newName = Helper.readString("Enter updated name of item > ").trim().toLowerCase();
		double price = Helper.readDouble("Update price of item > $");

		String confirm = Helper.readString("Are you sure? (Y/N) > ").trim();
		if (confirm.equalsIgnoreCase("Y")) {
			MenuItem mi = new MenuItem("asian", name, true, price);
			isUpdated = updateMenuItem(menuItemList, mi, newName);
		} else if (confirm.equalsIgnoreCase("N")) {
			System.out.println("Cancelled creation of item!");
		} else {
			System.out.println("Invalid choice!");
		}

		if (isUpdated) {
			System.out.println("Item updated!");
		} else {
			System.out.println("Item not updated!");
		}
	}

	public static boolean updateMenuItem(ArrayList<MenuItem> menuItemList, MenuItem mi, String newName) {
		// Done by Wen Ning

		if (mi.getName().length() > 20) {
			System.out.println("Name is too long!");
			return false;
		}

		if (mi.getName().equals("")) {
			System.out.println("Name of item cannot be empty!");
			return false;
		}

		if (mi.getPrice() <= 0) {
			System.out.println("Invalid price!");
			return false;
		}

		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getName().equalsIgnoreCase(mi.getName())) {
				mi.setName(newName);
				mi.setCategory(menuItemList.get(i).getCategory());
				mi.setHealthyChoice(menuItemList.get(i).isHealthyChoice());
				menuItemList.remove(i);
				menuItemList.add(mi);
				return true;
			}
		}
		System.out.println("Item not found!");
		return false;
	}

	// ----------------------------Option 5----------------------------
	//done by Pei Wen
	public static void inputCreateMenu(ArrayList<Menu> monthlyMenu) {
		boolean isCreate = false;

		String displayName = Helper.readString("Enter the display name of menu > ");
		int month = Helper.readInt("Enter the month of menu > ");
		while (month < 1 || month > 12) {
			System.out.println("Invalid month");
			month = Helper.readInt("Enter the month of menu > ");
		}
		int numOfItems = Helper.readInt("Enter the number of items > ");

		String listItem = String.format("%-20s %-20s %-10s %s\n", "Western", "Fries", "false", "3.0");
		listItem += String.format("%-20s %-20s %-10s %s\n", "Vegetarian", "Cabbage", "true", "1.5");
		listItem += String.format("%-20s %-20s %-10s %s\n", "Asian", "Curry Noodles", "false", "3.5");
		System.out.println(listItem);
		menuItemList.add(new MenuItem("Western", "Fries", false, 3.0));
		menuItemList.add(new MenuItem("Vegetarian", "Cabbage", true, 1.5));
		menuItemList.add(new MenuItem("Asian", "Curry Noodles", false, 3.5));

		if (numOfItems <= menuItemList.size()) {
			while (monthlyMenu.size() <= numOfItems) {
				Random num = new Random();
				int numItems = num.nextInt(menuItemList.size());
				// refactoring
				String name = menuItemList.get(numItems).getName();
				String category = menuItemList.get(numItems).getCategory();
				boolean healthyChoice = menuItemList.get(numItems).isHealthyChoice();
				double price = menuItemList.get(numItems).getPrice();

				ArrayList<MenuItem> items = new ArrayList<MenuItem>();
				items.add(new MenuItem(name, category, healthyChoice, price));
				Menu mm = new Menu(displayName, month, numOfItems, items);
				monthlyMenu.add(mm);
				isCreate = true;
				break;
			}
		} else {
			System.out.println("The menu is full");
		}
		if (isCreate == true) {
			System.out.println("Menu created!");
		} else {
			System.out.println("Menu not created!");
		}

	}

	public static boolean createMenu(ArrayList<Menu> monthlyMenu, Menu mm) {

		for (int i = 0; i < monthlyMenu.get(i).getNumberOfItems(); i++) {
			// refactoring
			String displayName = mm.getDisplayName();
			String menuDisplayName = monthlyMenu.get(i).getDisplayName();

			if (menuDisplayName.equalsIgnoreCase(displayName)) {
				System.out.println("Cannot have duplicate name of menu!");
				return false;
			}
		}
		monthlyMenu.add(mm);
		return true;
	}

	public static void viewAllMenu(ArrayList<Menu> monthlyMenu) {
		String output = "";
		output = retrieveAllMonthlyMenu(monthlyMenu);

		if (!output.equals("")) {
			System.out.println(String.format("%-20s %-10s %-15s %-15s %-10s %-10s %-10s", "Menu Name", "Month",
					"No. of Items", "Category", "Name", "Healthy", "Price"));
			System.out.println(output);
		} else {
			System.out.println("There are no monthly menu!");
		}

	}

	public static String retrieveAllMonthlyMenu(ArrayList<Menu> monthlyMenu) {
		String output = "";
		for (int i = 0; i < monthlyMenu.size(); i++) {
			// refactoring
			String category = monthlyMenu.get(i).getItems().get(i).getCategory();
			String name = monthlyMenu.get(i).getItems().get(i).getName();
			boolean healthyChoice = monthlyMenu.get(i).getItems().get(i).isHealthyChoice();
			double price = monthlyMenu.get(i).getItems().get(i).getPrice();

			output += String.format("%-47s %-15s %-10s %-10b %-10.2f\n", monthlyMenu.get(i).toString(), category, name,
					healthyChoice, price);
		}
		return output;
	}

	public static void inputDeleteMenu(ArrayList<Menu> monthlyMenu) {
		boolean isDeleted = false;
		for (int i = 0; i < monthlyMenu.size(); i++) {
			String delete = Helper.readString("Enter the name of menu which you want to delete > ");
			if (delete == null) {
				delete = Helper.readString("Please enter an item name! > ");
			} else if (delete.equalsIgnoreCase(monthlyMenu.get(i).getDisplayName())) {
				Menu mm = null;
				monthlyMenu.add(mm);
				isDeleted = true;
				break;
			} else {
				System.out.println("The menu is not existing.");
			}
		}
		if (isDeleted == true) {
			System.out.println("Menu removed!");
		} else {
			System.out.println("Menu not found!");
		}
	}

	public static boolean deleteMenu(ArrayList<Menu> monthlyMenu, Menu mm) {
		for (int i = 0; i < monthlyMenu.size(); i++) {
			// refactoring
			String displayName = mm.getDisplayName();
			String menuDisplayName = monthlyMenu.get(i).getDisplayName();
			if (menuDisplayName.equalsIgnoreCase(displayName)) {
				monthlyMenu.remove(i);
				return true;
			}
		}
		return false;
	}

	public static void updateMenu(ArrayList<Menu> monthlyMenu) {
		boolean isUpdated = false;
		String displayName = Helper.readString("Enter the display name of menu > ");
		String newDisplayName = Helper.readString("Enter the new display name of menu > ");
		int newMonth = Helper.readInt("Enter the new month of menu > ");
		for (int i = 0; i < monthlyMenu.size(); i++) {
			String menuDisplayName = monthlyMenu.get(i).getDisplayName();

			if (menuDisplayName.equalsIgnoreCase(displayName)) {
				monthlyMenu.get(i).getItems();
				// refactoring
				int numberOfItems = monthlyMenu.get(i).getNumberOfItems();
				ArrayList<MenuItem> items = monthlyMenu.get(i).getItems();

				Menu mm = new Menu(newDisplayName, newMonth, numberOfItems, items);
				monthlyMenu.set(i, mm);
				System.out.println("Menu successfully updated.");
				isUpdated = true;
			} 
		}
		if (isUpdated == true) {
			System.out.println("Menu updated!");
		} else {
			System.out.println("Menu not found!");
		}

	}

	public static boolean updateMonthlyMenu(ArrayList<Menu> monthlyMenu, String newName, Menu mm) {

		if (mm.getDisplayName().equals("")) {
			System.out.println("Name of menu cannot be empty!");
			return false;
		}
		int newMonth = Helper.readInt("Enter the new month of menu > ");
		if (newMonth < 1 || newMonth > 12) {
			System.out.println("Invalid month");
			return false;
		}

		for (int i = 0; i < monthlyMenu.size(); i++) {
			if (monthlyMenu.get(i).getDisplayName().equalsIgnoreCase(mm.getDisplayName())) {
				mm.setDisplayName(newName);
				mm.setMonth(newMonth);
				monthlyMenu.remove(i);
				monthlyMenu.add(mm);
				return true;
			}
		}
		System.out.println("Menu not found!");
		return false;
	}
	// ----------------------------Option 4----------------------------

	// Bill Methods Starts here
	// Done by verzon

	public static void createBill(ArrayList<Bill> billList) {

		String payee = Helper.readString("Enter the name of payee > ");
		String dueDate = Helper.readString("Enter the due date > ");

		Double totalAmount = 0.0;

		while (totalAmount <= 0) {
			totalAmount = Helper.readDouble("Enter the total amount > ");
			if (totalAmount > 0) {
				break;
			}

			System.out.println("Please enter a valid amount that is greater than 0");
		}
		Bill bill = new Bill(payee, totalAmount, dueDate);
		bill.setPaid(false);
		billList.add(bill);
	}

	public static void deleteBill(ArrayList<Bill> billList) {
		System.out.println("=====Displaying bill items, select the S/N to delete=====");

		// displaying of the bill

		int serialNumber = 1;
		System.out.println(
				String.format("%-5s %-20s %-20s %-20s %-10s", "S/N", "Payee", "TotalAmount", "DueDate", "Paid flag"));
		for (Bill x : billList) {

			String output = String.format("%-5s ", Integer.toString(serialNumber));
			output = output + x.toString();
			System.out.println(output);
			serialNumber++;
		}

		int num = Helper.readInt("Which S/N of the item you wish to delete? > ");

		billList.remove(num - 1);
	}

	public static void viewBill(ArrayList<Bill> billList) {
		int serialNumber = 1;
		System.out.println(
				String.format("%-5s %-20s %-20s %-20s %-10s", "S/N", "Payee", "TotalAmount", "DueDate", "Paid flag"));
		for (Bill x : billList) {

			String output = String.format("%-5s ", Integer.toString(serialNumber));
			output = output + x.toString();
			System.out.println(output);
			serialNumber++;
		}

		// If list is too long we enable user to search by payee
		System.out.println("If you wish to search for a payee by name, please enter his name. To quit press 2.");

		String choice = "0";
		while (!(choice.equals("2"))) {

			choice = Helper.readString("Please Enter Name of payee");

			// To check if payee was found
			int count = 0;
			for (Bill x : billList) {

				if (choice.equalsIgnoreCase(x.getPayee())) {
					System.out.println(
							String.format("%-20s %-20s %-20s %-10s", "Payee", "TotalAmount", "DueDate", "paid flag"));
					String output = x.toString();
					System.out.println(output);
					count = 1;

				}

			}
			if (count == 0) {
				System.out.println("Payee not found. Please try again. ");
			}
		}

	}

	public static void updateBill(ArrayList<Bill> billList) {
		// Prompt user to determine whether partial payment or full payment is intended.
		System.out.println("For payment of full amount press 1");
		System.out.println("For partial payment press 2");

		int payment_choice = Helper.readInt("Please enter your choice > ");

		// prompt user for input
		String search = Helper.readString("Please enter the name of the payee > ");

		// set a variable to see if the payee was found
		int found = 0;

		int index_Of_Payee = 0;

		// First for loop: iterate through all bills
		for (int i = 0; i < billList.size(); i++) {
			// Identify the payee within the bill List
			if (billList.get(i).getPayee().equalsIgnoreCase(search)) {
				// If this code is run, means payee was found. Assume no repeat in name.
				found = 1;
				index_Of_Payee = i;
				break;
			}

		}

		if (found == 1) {
			if (payment_choice == 1) {
				billList.get(index_Of_Payee).updateBill(0.00, true);
			}

			else if (payment_choice == 2) {
				double totalAmount = Helper.readDouble("Enter the total amount > ");

				while (totalAmount <= 0) {
					System.out.println("Invalid amount. Please ensure amount is greater than 0.");
					totalAmount = Helper.readDouble("Please enter the new amount> ");
				}

				boolean flag = Helper.readBoolean("Please enter paid flag (true/false)");

				// Updating of bill
				billList.get(index_Of_Payee).updateBill(totalAmount, flag);
				System.out.println("Update successful");
			}
		} else {
			System.out.println("Payee not found");
		}

	}

}