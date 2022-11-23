import java.util.Date;

class User {
	
	private String first_name; 
	private String last_name;
	private String user_name;
	private String password;
	private String email;
	private String student_number;
	private Date date_of_birth;
	private String study_department;
	private Date signUpDate;
	
	String getFirst_name() {
		return first_name;
	}
	void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	String getLast_name() {
		return last_name;
	}
	void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	String getUser_name() {
		return user_name;
	}
	void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	String getPassword() {
		return password;
	}
	void setPassword(String password) {
		this.password = password;
	}
	String getEmail() {
		return email;
	}
	void setEmail(String email) {
		this.email = email;
	}
	String getStudent_number() {
		return student_number;
	}
	void setStudent_number(String student_number) {
		this.student_number = student_number;
	}
	Date getDate_of_birth() {
		return date_of_birth;
	}
	void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	String getStudy_department() {
		return study_department;
	}
	void setStudy_department(String study_department) {
		this.study_department = study_department;
	}
	
	boolean verify(String username, String password) {
		if ((username == this.user_name) && (password == this.password)) {
			return true;
		} else {
			return false;
		}
	}
	User(String first_name, String last_name, String user_name, String password, String email, String student_number,
			Date date_of_birth, String study_department) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.user_name = user_name;
		this.password = password;
		this.email = email;
		this.student_number = student_number;
		this.date_of_birth = date_of_birth;
		this.study_department = study_department;
		this.signUpDate = new Date();
	}
	
	User() {
		
	}
}
