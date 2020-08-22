import java.util.ArrayList;

public class C206_CaseStudy
{
	ArrayList<Menu> monthlyMenu = new ArrayList<Menu>();

	public static void main(String[] args)
	{
		ArrayList<Menu> monthlyMenu = new ArrayList<Menu>();
		ArrayList<MenuItem> menuItem = new ArrayList<MenuItem>();
		ArrayList<Bill> billList = new ArrayList<Bill>();
		int option = 0;
		
		while (option != 6)
		{
			optionMenu();
			option = Helper.readInt("enter option");
			if (option == 1)
			{

			}
			else if (option == 2)
			{
				menu();
				int num = Helper.readInt("Which action do you want perform? > ");
				if (num == 1)
				{
					addMenuItem(menuItem);
				}
				else if (num == 2)
				{
					viewAllMenuItem(menuItem);
				}
				else if (num == 3)
				{
					deleteMenuItem(menuItem);
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

	public static void addMenuItem(ArrayList<MenuItem> menuItem)
	{
		//Done by Wen Ning
		
		String name = Helper.readString("Enter name of item to add > ").trim();
		
		if(name.length() > 30)
		{
			System.out.println("Name is too long!");
			return;
		}
		
		for(int i = 0; i < menuItem.size(); i++)
		{
			if(menuItem.get(i).getName().equalsIgnoreCase(name))
			{
				System.out.println("Duplicate item!");
				return;
			}
		}
		
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
			return;
		}
		
		String confirm = Helper.readString("Are you sure? (Y/N)").trim();
		if(confirm.equalsIgnoreCase("Y"))
		{
			menuItem.add(new MenuItem(category, name, healthyChoice, price));
			System.out.println("Item added!");
		}
		else if(confirm.equalsIgnoreCase("N"))
		{
			System.out.println("Item not added!");
		}
		else
		{
			System.out.println("Invalid choice!");
		}
	}
	
	public static void deleteMenuItem(ArrayList<MenuItem> menuItem)
	{
		//Done by Wen Ning
		
		String name = Helper.readString("Enter name of item to delete > ").trim();
		while(name == null)
		{
			name = Helper.readString("Please enter an item name! > ").trim();
		}
		
		for(int i = 0; i < menuItem.size(); i++)
		{
			if(menuItem.get(i).getName().equalsIgnoreCase(name))
			{
				menuItem.remove(i);
				System.out.println("Item removed!");
				return;
			}
		}
		System.out.println("Item not found!");
	}
	
	public static void viewAllMenuItem(ArrayList<MenuItem> menuItem)
	{
		//Done by Wen Ning
		
		System.out.println("1. View all items");
		System.out.println("2. View individual item");
		int num = Helper.readInt("Enter choice > ");
		
		if(num == 1)
		{
			if(menuItem.size() > 0)
			{
				System.out.println(String.format("%-30s %-20s %-10s %s", "Name", "Category", "Price", "HealthyChoice"));
				Helper.line(100, "=");
				for(int i = 0; i < menuItem.size(); i++)
				{
					String name = menuItem.get(i).getName();
					String category = menuItem.get(i).getCategory();
					String price = String.valueOf(menuItem.get(i).getPrice());
					String healthyChoice = menuItem.get(i).isHealthyChoice()? "true" : "false";
					System.out.println(String.format("%-30s %-20s %-10s %s", name, category, price, healthyChoice));
				}
			}
			else
			{
				System.out.println("There are no menu items!");
			}
		}
		else if(num == 2)
		{
			String name = Helper.readString("Enter name of item to view > ").trim();
			while(name == null)
			{
				name = Helper.readString("Please enter an item name! > ").trim();
			}
			
			for(int i = 0; i < menuItem.size(); i++)
			{
				if(menuItem.get(i).getName().equalsIgnoreCase(name))
				{
					System.out.println(String.format("%-30s %-20s %-10s %s", "Name", "Category", "Price", "HealthyChoice"));
					Helper.line(100, "=");
					
					name = menuItem.get(i).getName();
					String category = menuItem.get(i).getCategory();
					String price = String.valueOf(menuItem.get(i).getPrice());
					String healthyChoice = menuItem.get(i).isHealthyChoice()? "true" : "false";
					System.out.println(String.format("%-30s %-20s %-10s %s", name, category, price, healthyChoice));
					return;
				}
			}
			System.out.println("Item not found!");
		}
		else
		{
			System.out.println("Invalid choice!");
		}
	}
	
	public static void createMenu(ArrayList<Menu> monthlyMenu) {
		String displayName = Helper.readString("Enter the display name of menu > ");
		int month = Helper.readInt("Enter the month of menu > ");
		int numOfItems = Helper.readInt("Enter the number of item > ");
		for (int i = 0; i < monthlyMenu.size(); i++) {
			if(monthlyMenu.get(i).getDisplayName().equalsIgnoreCase(displayName)) {
				System.out.println("Cannot have duplicate name of menu!");
			}else {
				// monthlyMenu.addAll(displayName, month, numOfItems);
				System.out.println("Menu has successfully created.");
			}
		}
	}

	public static void viewAllMenu(ArrayList<Menu> monthlyMenu) {
		String output = String.format("%-20s %-10s %-15s %-15s %-10s %-10s -10s\n", "Menu Name","Month","No. of Items","Category","Name","Healthy","Price");
		for (int i = 0; i < monthlyMenu.size(); i++) {
			output += String.format("%-96s\n", monthlyMenu.get(i).toString());
		}
		System.out.println(output);
	}

	public static void deleteMenu(ArrayList<Menu> monthlyMenu) {
		String delete = Helper.readString("Enter the name of menu which you want to delete > ");
		for (int i = 0; i < monthlyMenu.size(); i++) {
			if(monthlyMenu.get(i).getDisplayName().equalsIgnoreCase(delete)) {
				monthlyMenu.remove(i);
				System.out.println("Menu has successfully deleted.");
			}
		}
	}
	
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