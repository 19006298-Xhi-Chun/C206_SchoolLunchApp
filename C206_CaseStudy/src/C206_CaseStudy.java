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
			} else if (option == 2) {
				menu();
				int num = Helper.readInt("Which action do you want perform? > ");
				Helper.line(80, "-");
				if (num == 1) {
					if (loginAdmin(AccountList)) {
						inputAddMenuItem(menuItemList);
					}
				} else if (num == 2) {
					viewAllMenuItem(menuItemList);
				} else if (num == 3) {
					if (loginAdmin(AccountList)) {
						inputDeleteMenuItem(menuItemList);
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

	// ----------------------------Option 2----------------------------

	public static void inputAddMenuItem(ArrayList<MenuItem> menuItemList) {
		// Done by Wen Ning

		boolean isAdded = false;

		String name = Helper.readString("Enter name of item to add > ").trim();
		String category = Helper.readString("Enter category of item > ").trim();
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

		boolean isDeleted = false;

		String name = Helper.readString("Enter name of item to delete > ").trim();

		while (name == null) {
			name = Helper.readString("Please enter an item name! > ").trim();
		}
		MenuItem mi = new MenuItem("", name, false, 0);
		isDeleted = deleteMenuItem(menuItemList, mi);

		if (isDeleted) {
			System.out.println("Item removed!");
		} else {
			System.out.println("Item not found!");
		}
	}

	public static boolean deleteMenuItem(ArrayList<MenuItem> menuItemList, MenuItem mi) {
		// Done by Wen Ning

		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getName().equalsIgnoreCase(mi.getName())) {
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
			System.out.println(String.format("%-20s %-20s %-10s %s\n", "Name", "Category", "Price", "Healthy Choice"));
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
			String name = menuItemList.get(i).getName();
			String category = menuItemList.get(i).getCategory();
			String price = String.valueOf(menuItemList.get(i).getPrice());
			String healthyChoice = menuItemList.get(i).isHealthyChoice() ? "true" : "false";
			output += String.format("%-20s %-20s %-10s %s\n", name, category, price, healthyChoice);
		}
		return output;
	}

	// ----------------------------Option 5----------------------------

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
			//refactoring
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

	public static void updateMenu(ArrayList<Menu> monthlyMenu) {
		String displayName = Helper.readString("Enter the display name of menu > ");
		for (int i = 0; i < monthlyMenu.size(); i++) {
			String menuDisplayName = monthlyMenu.get(i).getDisplayName();
			
			if (menuDisplayName.equalsIgnoreCase(displayName)) {
				monthlyMenu.get(i).getItems();
				String newDisplayName = Helper.readString("Enter the new display name of menu > ");
				int newMonth = Helper.readInt("Enter the new month of menu > ");
				while (newMonth < 1 || newMonth > 12) {
					System.out.println("Invalid month");
					newMonth = Helper.readInt("Enter the new month of menu > ");
				}
				//refactoring
				int numberOfItems = monthlyMenu.get(i).getNumberOfItems();
				ArrayList<MenuItem> items = monthlyMenu.get(i).getItems();
				
				Menu mm = new Menu(newDisplayName, newMonth, numberOfItems,
						items);
				monthlyMenu.set(i, mm);
				System.out.println("Menu successfully updated.");

			} else {
				System.out.println("This menu is not existing.");
			}
		}

	}

	public static String retrieveAllMonthlyMenu(ArrayList<Menu> monthlyMenu) {
		String output = "";
		for (int i = 0; i < monthlyMenu.size(); i++) {
			//refactoring
			String category = monthlyMenu.get(i).getItems().get(i).getCategory();
			String name = monthlyMenu.get(i).getItems().get(i).getName();
			boolean healthyChoice = monthlyMenu.get(i).getItems().get(i).isHealthyChoice();
			double price = monthlyMenu.get(i).getItems().get(i).getPrice();
			
			output += String.format("%-47s %-15s %-10s %-10b %-10.2f\n", monthlyMenu.get(i).toString(),
					category, name, healthyChoice, price);
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
		if (isDeleted) {
			System.out.println("Menu removed!");
		} else {
			System.out.println("Menu not found!");
		}
	}

	public static boolean deleteMenu(ArrayList<Menu> monthlyMenu, Menu mm) {
		for (int i = 0; i < monthlyMenu.size(); i++) {
			//refactoring
			String displayName = mm.getDisplayName();
			String menuDisplayName = monthlyMenu.get(i).getDisplayName();
			if (menuDisplayName.equalsIgnoreCase(displayName)) {
				monthlyMenu.remove(i);
				return true;
			}
		}
		return false;
	}

	// ----------------------------Option 4----------------------------

	// Bill Methods Starts here
	// Done by verzon

	public static void createBill(ArrayList<Bill> billList) {
		String payee = Helper.readString("Enter the name of payee > ");
		Double totalAmount = Helper.readDouble("Enter the total amount > ");
		String dueDate = Helper.readString("Enter the due date > ");

		Bill bill = new Bill(payee, totalAmount, dueDate);
		billList.add(bill);
	}

	public static void deleteBill(ArrayList<Bill> billList) {
		System.out.println("=====Displaying bill items, select the S/N to delete=====");
		viewBill(billList);
		int num = Helper.readInt("Which S/N of the item you wish to delete? > ");

		billList.remove(num - 1);
	}

	public static void viewBill(ArrayList<Bill> billList) {
		int serialNumber = 1;
		System.out.println(String.format("%-5s %-20s %-20s %-20s", "S/N", "Payee", "TotalAmount", "DueDate"));
		for (Bill x : billList) {

			String output = String.format("%-5s", Integer.toString(serialNumber));
			output = output + x.toString();
			System.out.println(output);
			serialNumber++;
		}
	}

}