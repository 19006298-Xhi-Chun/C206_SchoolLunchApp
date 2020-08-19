import java.util.ArrayList;

/**
 * I declare that this code was written by me. I will not copy or allow others
 * to copy my code. I understand that copying code is considered as plagiarism.
 *
 * 19034766, Aug 19, 2020 2:08:26 PM
 */

public class Menu {
	private String displayName;
	private int month;
	private int numberOfItems;
	private ArrayList<MenuItem> items;

	/**
	 * @param displayName
	 * @param month
	 * @param numberOfItems
	 * @param items
	 */
	public Menu(String displayName, int month, int numberOfItems, ArrayList<MenuItem> items) {
		this.displayName = displayName;
		this.month = month;
		this.numberOfItems = numberOfItems;
		this.items = items;
	}
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public int getMonth() {
		return month;
	}

	void setMonth(int month) {
		this.month = month;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	public ArrayList<MenuItem> getItems() {
		return items;
	}

	public void setItems(ArrayList<MenuItem> items) {
		this.items = items;
	}
	public String toString() {
		
	}

}
