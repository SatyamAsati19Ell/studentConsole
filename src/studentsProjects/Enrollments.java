package studentsProjects;

//The class is used to set all the  enrollments in the enrollment database through its constructor 
public class Enrollments {
	private String studentName;
	private String enrolledCourseId;
	private String enrolledCourseName;
	private String enrolledCourseLevel;
	private int enrolledcourseDuration;
	private int timeSpent;
	private double completion;
	private String currentDate;
	
//the argument Enrollment constructor initializes the variables 
	public Enrollments(String userName,String enrolledCourseId,String enrolledCourseName,String enrolledCourseLevel,
			int enrolledcourseDuration,String date,int timeSpent,double completion)
	{
		this.studentName=userName;
		this.enrolledCourseId=enrolledCourseId;
		this.enrolledCourseName=enrolledCourseName;
		this.enrolledCourseLevel=enrolledCourseLevel;
		this.enrolledcourseDuration=enrolledcourseDuration;
		this.timeSpent=timeSpent;
		this.completion=completion;
		currentDate=date;
		
	}
	
	//Method is used to access Student Name 
	public String getStudentName() {
		return studentName;
	}
	
	//Method is used to access Student enrolled course id
	public String getEnrolledCourseId() {
		return enrolledCourseId;
	}
	
	//Method is used to access Student enrolled course name  
	public String getEnrolledCourseName() {
		return enrolledCourseName;
	}
	
	//Method is used to access Student course level 
	public String getEnrolledCourseLevel() {
		return enrolledCourseLevel;
	}
	
	//Method is used to access Student course duration 
	public int getEnrolledcourseDuration() {
		return enrolledcourseDuration;
	}
	
	//Method is used to access Student course enrollment date  
	public String getCurrentDate() {
		return currentDate;
	}
	//Method is used to access Student time spent on courses 
	public int getTimeSpent() {
		return timeSpent;
	}
	//Method is used to set the time spent by student on perticular course 
	public void setTimeSpent(int timeSpent) {
		this.timeSpent = timeSpent;
	}

	//Method is used to access Student's completion status 
	public double getCompletion() {
		return completion;
	}

	//Method is used to set the completion for perticular course of student 
	public void setCompletion(float completion) {
		this.completion = completion;
	}

}
