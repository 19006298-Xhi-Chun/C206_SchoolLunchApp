
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19018952, 23 Aug 2020 5:39:57 pm
 */

public class Account {
	private String name;
	private String studentId;
	private String contactNumber;
	private String role;
	
	public Account(String name,String studentId, String contactNumber,String role) {
		this.name = name;
		this.studentId = studentId;
		this.contactNumber = contactNumber;
		this.role = role;
}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
