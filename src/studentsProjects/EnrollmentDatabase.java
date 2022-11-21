package studentsProjects;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EnrollmentDatabase
{
	//the List stores  all the enrolledments 
	private static  List<Enrollments>enrollmentList=new ArrayList<>();
	
	// the List  stores the all the values of enrollments first and then updates if time is spent by student 
	private static List<Enrollments> clockInList=new ArrayList<>();

	
	
	
	private String studentName;
	private CourseDatabase courseDatabse;
	private int timespent;

	private StudentDatabase studentDatabase;
	private String studentId;
	private int totalTimeSpent=0;
	private double completion=0.00d;

	private Scanner scanner;

	// Enrollment constructor takes one parameter (student name ) and  initializes instance variables
	public EnrollmentDatabase(String userName)
	{
		studentName=userName;
		 scanner=new Scanner(System.in);
		 studentDatabase= new StudentDatabase();
		studentId=studentDatabase.getStudentsId(studentName);
		 
		 
	}
	
	//getter menthod is created to access the Enrollment List
		public static List<Enrollments> getEnrollmentList()
		{
			return enrollmentList;
		}
	
		
		//The method is used to enroll available courses
	public void enroll()
	
	{
		//current date is set using  Local Date class
		DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd MMM yyyy ");  
        LocalDateTime now = LocalDateTime.now();  
        String currentDate=dateTimeFormat.format(now);
        
		courseDatabse=new CourseDatabase();	
		
		//The user is 
		try {
		System.out.println("\nPlease enter course ID");
		String courseID=scanner.nextLine();
		
		//getting all the course related data of same course ID
		String courseName=courseDatabse.getCourseMap().get(courseID).getCourseName();
		String courseLevel=courseDatabse.getCourseMap().get(courseID).getCourseLevel();
		int courseDuration=courseDatabse.getCourseMap().get(courseID).getCourseDuration();
	
		//the courseID is first checked if the course is present or not 
		if(courseDatabse.getCourseMap().containsKey(courseID)) {
			
			//printing message successfully enrolled in course	
			System.out.println("\nYou've successfully enrolled in "+courseName+" !");
			
			//enrolled course is stored in Enrollment List	
			enrollmentList.add(new Enrollments(studentName,courseID,courseName,courseLevel,courseDuration,currentDate,timespent,completion));
		}
		else {
			System.out.println("\nThe ID choosen is not in Courses !");
			
		}
		}catch(Exception e) {
			System.out.println("\nThe course you entered is not availabe !");
		}
	}
	
	
	//The method Displays all the courses enrolled by the student 
	public void viewEnrolled() 
	{
		System.out.println("Student Name : "+studentName);
		System.out.println("Student ID : "+studentId);
		System.out.println("\n--------------------------------------------------------------------------------");
		System.out.printf("%-18s%-30s%-20s","Course Id", "Course Name", "Enrollment Date");
		System.out.println("\n--------------------------------------------------------------------------------");
		
		//if the the enrollment List is empty  it will ask to enroll any course first  else it will show the the enrolled list !
			for(Enrollments enrolllist:enrollmentList)
			{
				if(enrolllist.getStudentName().equals(studentName))
				{
					System.out.printf("%-18s%-30s%-20s",enrolllist.getEnrolledCourseId(),enrolllist.getEnrolledCourseName(),
							enrolllist.getCurrentDate());
					System.out.println();
					
				}			
			}
	}
		
	
	
	//The list is used to clockIn....
	public void clockIn()
	{
		//The list is assigned to new list and the clock in time and comletion is updated here
		clockInList=enrollmentList;
		
		try { Scanner intScanner= new Scanner(System.in);
		 System.out.println("\nEnter the Course id ");
		 String courseid=scanner.nextLine();
		 System.out.println("\nPlease enter the hours Spent !");
		 int timeSpent=intScanner.nextInt();
		
		for(int i=0;i<clockInList.size();i++)
		{
			//if the name and the courseid is matched then the clock in time is updated for that course
			if(clockInList.get(i).getStudentName().equals(studentName) && clockInList.get(i).getEnrolledCourseId().equals(courseid))
			{
				 totalTimeSpent=clockInList.get(i).getTimeSpent()+timeSpent;
				 if(totalTimeSpent<=clockInList.get(i).getEnrolledcourseDuration()) {
					 
				
				 completion=(totalTimeSpent*100)/clockInList.get(i).getEnrolledcourseDuration();				
					clockInList.set(i, new Enrollments(studentName,clockInList.get(i).getEnrolledCourseId(),
					clockInList.get(i).getEnrolledCourseName(),clockInList.get(i).getEnrolledCourseLevel(),
					clockInList.get(i).getEnrolledcourseDuration(), clockInList.get(i).getCurrentDate(),totalTimeSpent,completion));
					System.out.println("\nYou have successfully clocked-in "+timeSpent +" hrs to "+clockInList.get(i).getEnrolledCourseName()+" !\r\n");
				 }else {
					 System.out.println("\nTime Spent Exceeded duration of course ,Can't add !");
				 }
	         }
		}
		}catch(Exception e) {
			System.out.println("\n Please provide with correct Hrs !");
		}
	
	}
	
	
	
	//The method shows the summary for the perticular student 
	public void summary()
	{
		//Here if the user has enrolled to course but not clocked in for that course then all the data will be shown  with the enrolled List 
		if(clockInList.isEmpty()) {
			System.out.println("Student Name : "+studentName);
			System.out.println("Student ID : "+studentId);
			System.out.println("--------------------------------------------------------------------------------------");
			System.out.printf("%-18s%-25s%-12s%-13s%-10s","Course Id","Course Name","Duration","Time Spent","Completion");
			System.out.println();
			System.out.println("----------------------------------------------------------------------------------------");
			for(int i=0;i<enrollmentList.size();i++)
			{
				//Student name is matched and summary related to him is shown
				if(enrollmentList.get(i).getStudentName().equals(studentName))
				{
				System.out.printf("\n%-18s%-27s%-13d%-12s%-5s",enrollmentList.get(i).getEnrolledCourseId(),enrollmentList.get(i).getEnrolledCourseName(),
				                  enrollmentList.get(i).getEnrolledcourseDuration(),enrollmentList.get(i).getTimeSpent(),enrollmentList.get(i).getCompletion());
				System.out.println();
				}
			}
			System.out.println("----------------------------------------------------------------------------------------------");
			
		}
		 //Else the data will be shown from the clock in list and everytime the clock is called updated data will be shown
		else
	  {
			
		System.out.println("Student Name :"+studentName);
		System.out.println("Student Id :"+studentId);
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.printf("%-18s%-25s%-12s%-13s%-10s","Course Id","Course Name","Duration","Time Spent","Completion");
		System.out.println();
		System.out.println("\n----------------------------------------------------------------------------------------");
		for(int i=0;i<clockInList.size();i++) 
		 {
			//Student name is matched and summary related to him is shown
			if(clockInList.get(i).getStudentName().equals(studentName))
			{
				
			System.out.printf("\n%-18s%-27s%-13d%-12s%-5s",clockInList.get(i).getEnrolledCourseId(),clockInList.get(i).getEnrolledCourseName(),
			clockInList.get(i).getEnrolledcourseDuration(),clockInList.get(i).getTimeSpent(),clockInList.get(i).getCompletion());
			System.out.println();
			}
		  }
		System.out.println("----------------------------------------------------------------------------------------------");
			
	   }
			
	}
	
}
