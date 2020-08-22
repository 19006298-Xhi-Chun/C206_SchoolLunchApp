/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19032188, Aug 23, 2020 12:27:53 AM
 */

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19032188, Aug 23, 2020 12:27:53 AM
 */

public class Bill {
	private String payee;
	private double totalAmount;
	private String dueDate;
	private boolean paid;
	
	public Bill(String payee, double totalAmount, String dueDate) {
		this.payee = payee;
		this.totalAmount = totalAmount;
		this.dueDate = dueDate;
	}
	public String getPayee() {
		return payee;
	}
	public void setPayee(String payee) {
		this.payee = payee;
	}
	
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	
	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	
	public String toString() {
		String convert = Double.toString(totalAmount);
		String output = String.format("%-20s %-20s %-20s", payee, convert, dueDate);
		return output;
	}
	
	
	
	

}
