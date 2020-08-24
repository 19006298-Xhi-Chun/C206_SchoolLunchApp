
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19018952, 23 Aug 2020 5:46:22 pm
 */
import java.util.ArrayList;
public class AccountCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Account> AccountList = new ArrayList<Account>();
		System.out.println("1.Create new account");
		System.out.println("2.Edit current Account");
		System.out.println("3.Delete current Account");
		System.out.println("4.Quit");
		int user_input = Helper.readInt("Enter your option:");
		while (user_input != 4) {
			if (user_input == 1) {
				String newName = Helper.readString("Enter new Account username:");
				String newStudentId = Helper.readString("Enter new Student ID:");
				String newContactNumber = Helper.readString("Enter your contact number:");
				String newRole = Helper.readString("Enter user role:");
				createUserAccount(AccountList,newName,newStudentId,newContactNumber,newRole);
				user_input = Helper.readInt("Enter your option:");
				for(int i=0;i<AccountList.size();i++) {
					System.out.println(AccountList.get(i).getName());
				}
			}
			if(user_input == 2) {
				System.out.println("1.Edit name");
				System.out.println("2.Edit student ID");
				System.out.println("3.Edit contact number");
				System.out.println("4.Edit role");
				int user_edit = Helper.readInt("What do you want to edit?");
				String oldName = Helper.readString("Enter old name you want to edit:");
				String oldStudentId = Helper.readString("Enter old password you want to edit:");
				editUserAccount(AccountList,user_edit,oldName,oldStudentId);
				user_input = Helper.readInt("Enter your option:");
				for(int i=0;i<AccountList.size();i++) {
					System.out.println(AccountList.get(i).getName());
				}
			}
			if(user_input == 3) {
				String oldName1 = Helper.readString("Enter name of deleting account :");
				String oldStudentID1 = Helper.readString("Enter Student ID of deleting Account :");
				deleteUserAccount(AccountList,oldName1,oldStudentID1);
				user_input = Helper.readInt("Enter your option:");
				for(int i=0;i<AccountList.size();i++) {
					System.out.println(AccountList.get(i).getName());
				}
			}
		}
	}
	public static void createUserAccount(ArrayList<Account> AccountList,String newName,String newStudentId,String newContactNumber,String newRole) {		
		Account newAccount = new Account(newName,newStudentId,newContactNumber,newRole);
		AccountList.add(newAccount);
		System.out.println("Account has been successfully added!");
	}
	public static void editUserAccount(ArrayList<Account> AccountList,int user_edit,String oldName,String oldStudentID) {
		for(int i=0;i<AccountList.size();i++) {
			if(AccountList.get(i).getName().equalsIgnoreCase(oldName) && AccountList.get(i).getStudentId().equalsIgnoreCase(oldStudentID)) {
				if(user_edit == 1) {
					String modName = Helper.readString("Enter new edited name: ");
					AccountList.get(i).setName(modName);
					System.out.println("Name has been modified!");
					break;
				}
				if(user_edit == 2) {
					String modID = Helper.readString("Enter new edited StudentId: ");
					AccountList.get(i).setStudentId(modID);
					System.out.println("Student ID  has been modified!");
					break;
			}
				if(user_edit == 3) {
					String modContact = Helper.readString("Enter new Contact Number: ");
					AccountList.get(i).setContactNumber(modContact);
					System.out.println("Contact Number has been modified!");
					break;
		}
				if(user_edit == 4) {
					String modRole = Helper.readString("Enter new edited role: ");
					AccountList.get(i).setRole(modRole);
					System.out.println("Role has been modified!");
					break;
				}
	}
			}

	
}
	
	public static void deleteUserAccount(ArrayList<Account> AccountList,String oldName1, String oldStudentID1) {
		for(int i=0; i < AccountList.size();i++) {
			if(AccountList.get(i).getName().equalsIgnoreCase(oldName1) && AccountList.get(i).getStudentId().equalsIgnoreCase(oldStudentID1)) {
				AccountList.remove(i);
				System.out.println("Account has been successfully deleted!");
				break;
			}
		}
}
}
