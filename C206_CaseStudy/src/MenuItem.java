
/**
 * I declare that this code was written by me. I will not copy or allow others
 * to copy my code. I understand that copying code is considered as plagiarism.
 *
 * 19015254, Aug 22, 2020 4:36:36 PM
 */

public class MenuItem
{
	private String category;
	private String name;
	private boolean healthyChoice;
	private double price;
	
	public MenuItem(String category, String name, boolean healthyChoice, double price)
	{
		this.category = category;
		this.name = name;
		this.healthyChoice = healthyChoice;
		this.price = price;
	}

	public String getCategory()
	{
		return category;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}

	public boolean isHealthyChoice()
	{
		return healthyChoice;
	}

	public void setHealthyChoice(boolean healthyChoice)
	{
		this.healthyChoice = healthyChoice;
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}
	
	public String toString()
	{
		String output = String.format("%-20s %-20s %-10s %s\n", name, category, price, healthyChoice);
		return output;
	}
}