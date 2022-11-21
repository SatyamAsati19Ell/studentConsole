package studentsProjects;

public class Courses {
	private String courseName;
	private String courseLevel;
	private int courseDuration;
	
	
	public Courses(String courseName,String courseLevel,int courseDuration) {
		this.courseName=courseName;
		this.courseLevel=courseLevel;
		this.courseDuration=courseDuration;
	}

	//getter method is used to access the course name
	public String getCourseName() {
		return courseName;
	}

	//getter method is used to access the course level
	public String getCourseLevel() {
		return courseLevel;
	}

	//getter method is used to access the course duration
	public int getCourseDuration() {
		return courseDuration;
	}

}



