import java.util.ArrayList;

public class C206_CaseStudy {
	ArrayList<Menu> monthlyMenu = new ArrayList<Menu>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Menu> monthlyMenu = new ArrayList<Menu>();
		int option = 0;
		while (option != 6)
		{
			if (option == 1)
			{

			}
			else if (option == 2)
			{
				menu();
				int num = Helper.readInt("Which action you want perform > ");
				if (num == 1)
				{
					
				}
			}
			else if (option == 3)
			{

			}
			else if (option == 4)
			{

			} 
			else if (option == 5)
			{
				menu();
				int num = Helper.readInt("Which action you want perform > ");
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

}
