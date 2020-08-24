import java.util.ArrayList;

public class C206_CaseStudy
{
	public static void main(String[] args)
	{
		ArrayList<Menu> monthlyMenu = new ArrayList<Menu>();
		ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
		ArrayList<Bill> billList = new ArrayList<Bill>();
		int option = 0;
		
		while (option != 6)
		{
			optionMenu();
			option = Helper.readInt("Which action do you want perform? > ");
			if (option == 1)
			{

			}
			else if (option == 2)
			{
				menu();
				int num = Helper.readInt("Which action do you want perform? > ");
				Helper.line(80, "-");
				if (num == 1)
				{
					inputAddMenuItem(menuItemList);
				}
				else if (num == 2)
				{
					viewAllMenuItem(menuItemList);
				}
				else if (num == 3)
				{
					inputDeleteMenuItem(menuItemList);
				}
				else
				{
					System.out.println("Invalid option.");
				}
			}
			else if (option == 3)
			{

			}
			else if (option == 4)
			{
				menu();
				int num = Helper.readInt("Which action do you want perform? > ");
				
				if(num ==1) {
					createBill(billList);
				}
				else if (num ==2) {
					viewBill(billList);
				}
				else if (num ==3) {
					deleteBill(billList);
				}
				else {
					System.out.println("Invalid option.");
				}

			} 
			else if (option == 5)
			{
				menu();
				int num = Helper.readInt("Which action do you want perform? > ");
				if (num == 1) {
					createMenu(monthlyMenu);
				} else if (num == 2) {
					viewAllMenu(monthlyMenu);
				} else if (num == 3) {
					deleteMenu(monthlyMenu);
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

	}

	//----------------------------Option 2----------------------------
	
	public static void inputAddMenuItem(ArrayList<MenuItem> menuItemList)
	{
		//Done by Wen Ning
		
		boolean isAdded = false;
		
		String name = Helper.readString("Enter name of item to add > ").trim();
		String category = Helper.readString("Enter category of item > ").trim();
		double price = Helper.readDouble("Enter price of item > $");
		String choice =  Helper.readString("Is this menu item healthy? (Y/N) > ").trim();
		boolean healthyChoice = false;
		
		if(choice.equalsIgnoreCase("Y"))
		{
			healthyChoice = true;
		}
		else if(choice.equalsIgnoreCase("N"))
		{
			healthyChoice = false;
		}
		else
		{
			System.out.println("Invalid choice!");
		}
		
		String confirm = Helper.readString("Are you sure? (Y/N) > ").trim();
		if(confirm.equalsIgnoreCase("Y"))
		{
			MenuItem mi = new MenuItem(category, name, healthyChoice, price);
			isAdded = addMenuItem(menuItemList, mi);
		}
		else if(confirm.equalsIgnoreCase("N"))
		{
			System.out.println("Cancelled creation of item!");
		}
		else
		{
			System.out.println("Invalid choice!");
		}
		
		if(isAdded)
		{
			System.out.println("Item added!");
		}
		else
		{
			System.out.println("Item not added!");
		}
	}
	
	public static boolean addMenuItem(ArrayList<MenuItem> menuItemList, MenuItem mi)
	{
		//Done by Wen Ning
		
		if(mi.getName().length() > 20)
		{
			System.out.println("Name is too long!");
			return false;
		}
			
		for(int i = 0; i < menuItemList.size(); i++)
		{
			if(menuItemList.get(i).getName().equalsIgnoreCase(mi.getName()))
			{
				System.out.println("Duplicate item!");
				return false;
			}
		}
		menuItemList.add(mi);
		return true;
	}
	
	public static void inputDeleteMenuItem(ArrayList<MenuItem> menuItemList)
	{
		//Done by Wen Ning
		
		boolean isDeleted = false;
		
		String name = Helper.readString("Enter name of item to delete > ").trim();
		while(name == null)
		{
			name = Helper.readString("Please enter an item name! > ").trim();
		}
		
		MenuItem mi = new MenuItem("", name, false, 0);
		isDeleted = deleteMenuItem(menuItemList, mi);
		
		if(isDeleted)
		{
			System.out.println("Item removed!");
		}
		else
		{
			System.out.println("Item not found!");
		}
	}
	
	public static boolean deleteMenuItem(ArrayList<MenuItem> menuItemList, MenuItem mi)
	{
		//Done by Wen Ning
		
		for(int i = 0; i < menuItemList.size(); i++)
		{
			if(menuItemList.get(i).getName().equalsIgnoreCase(mi.getName()))
			{
				menuItemList.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public static void viewAllMenuItem(ArrayList<MenuItem> menuItemList)
	{
		//Done by Wen Ning
		
		String output = "";
		output = retrieveAllMenuItem(menuItemList);
		
		if(!output.equals(""))
		{
			System.out.println(String.format("%-20s %-20s %-10s %s\n", "Name", "Category", "Price", "Healthy Choice"));
			Helper.line(80, "-");
			System.out.println(output);
		}
		else
		{
			System.out.println("There are no menu items!");
		}
	}
	
	public static String retrieveAllMenuItem(ArrayList<MenuItem> menuItemList)
	{
		//Done by Wen Ning
		
		String output = "";
		
		for(int i = 0; i < menuItemList.size(); i++)
		{
			String name = menuItemList.get(i).getName();
			String category = menuItemList.get(i).getCategory();
			String price = String.valueOf(menuItemList.get(i).getPrice());
			String healthyChoice = menuItemList.get(i).isHealthyChoice()? "true" : "false";
			output += String.format("%-20s %-20s %-10s %s\n", name, category, price, healthyChoice);
		}
		return output;
	}
	
	//----------------------------Option 5----------------------------
	
	public static void createMenu(ArrayList<Menu> monthlyMenu) {
		
		String displayName = Helper.readString("Enter the display name of menu > ");
		int month = Helper.readInt("Enter the month of menu > ");
		int numOfItems = Helper.readInt("Enter the number of items > ");
		
		for (int i = 0; i < monthlyMenu.size(); i++) {
			if(monthlyMenu.get(i).getDisplayName().equalsIgnoreCase(displayName)) {
				System.out.println("Cannot have duplicate name of menu!");
			}else {
				monthlyMenu.add(new Menu(displayName, month, numOfItems,monthlyMenu.get(i).getItems()));
				System.out.println("Menu has successfully created.");
			}
		}
	}

	public static void viewAllMenu(ArrayList<Menu> monthlyMenu) {
		String output = String.format("%-20s %-10s %-15s %-15s %-10s %-10s -10s\n", "Menu Name","Month","No. of Items","Category","Name","Healthy","Price");
		for (int i = 0; i < monthlyMenu.size(); i++) {
			
			output += String.format("%-47s %-15s %-10s %-10s -10s\n", monthlyMenu.get(i).toString(),monthlyMenu.get(i).getItems());
		}
		System.out.println(output);
	}

	public static void deleteMenu(ArrayList<Menu> monthlyMenu) {
		String delete = Helper.readString("Enter the name of menu which you want to delete > ");
		for (int i = 0; i < monthlyMenu.size(); i++) {
			if(monthlyMenu.get(i).getDisplayName().equalsIgnoreCase(delete)) {
				monthlyMenu.remove(i);
				System.out.println("Menu has successfully deleted.");
			}else {
				System.out.println("No existing menu.");
			}
		}
	}
	
	//----------------------------Option 4----------------------------
	
	//Bill Methods Starts here
	//Done by verzon
	
	public static void createBill(ArrayList <Bill> billList) {
		String payee = Helper.readString("Enter the name of payee > ");
		Double totalAmount = Helper.readDouble("Enter the total amount > ");
		String dueDate = Helper.readString("Enter the due date > ");
		
		Bill bill = new Bill(payee,totalAmount,dueDate);
		billList.add(bill);
	}
	
	public static void deleteBill(ArrayList <Bill> billList) {
		System.out.println("=====Displaying bill items, select the S/N to delete=====");
		viewBill(billList);
		int num = Helper.readInt("Which S/N of the item you wish to delete? > ");
		
		billList.remove(num-1);
	}
	
	public static void viewBill(ArrayList <Bill> billList) {
		int serialNumber = 1;
		System.out.println(String.format("%-5s %-20s %-20s %-20s", "S/N", "Payee", "TotalAmount", "DueDate"));
		for (Bill x :billList) {
		
			String output = String.format("%-5s", Integer.toString(serialNumber) );
			 output = output + x.toString();
			System.out.println(output);
			serialNumber++;
		}
	}
}