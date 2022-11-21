package studentsProjects;

public class StudentAccounts {
	
	private String studentId;
	private String password;
	
	public StudentAccounts(String studentId,String password)
	{
		this.studentId=studentId;
		this.password=password;
	}

	//getter method is used to access the student id
	public String getStudentId() {
		return studentId;
	}
	
	//getter method is used to access the password of student 
	public String getPassword() {
		return password;
	}
	

	
	

}
