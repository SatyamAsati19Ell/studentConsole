package studentsProjects;

import java.util.Scanner;
public class Console {


	//The class is used as console to Display the results for the action taken by user....
		private Boolean usrAuthenticated;
		private StudentDatabase studentDatabase;
		private String currentUser;
		private CourseDatabase courseDatabase;
		private Scanner scanner;
		
		
		//This are the constants 
		private static final String DISPLAY_COURSES="a";
		private static final String VIEW_ENROLL_COURSE="b";
		private static final String ENROLL_IN_COURSE="c";
		private static final String CLOCK_IN_TIME="d";
		private static final String VIEW_SUMMARY="e";
		private static final String EXIT="f";
		
		// no-argument Console constructor initializes instance variables
		public Console() {
			usrAuthenticated=false;
			studentDatabase=new StudentDatabase();
			courseDatabase= new CourseDatabase();
			currentUser="";
			scanner=new Scanner(System.in);
		}
		
		//The main methods from here the execution starts (Console Starts)
		public void run()
		{
			// welcome and authenticate user; perform transactions
			while(true) 
			{
				// loop while user is not yet authenticated
				while(!usrAuthenticated) {
					System.out.println("\nWelcome !");
					
					//The method authenticate the user 
					autenticatedUser();
				}
				// The method performs all the choices entered by user
				perform();
				usrAuthenticated=false;
				currentUser="";
				System.out.println("\n thank you !");
			
			}
			
		}
		
		//The method authenticates the user  and set the current name  if the user is authenticated 
		private void autenticatedUser()
		{   
			System.out.println("enter your username !");
			String urName=scanner.nextLine();
			System.out.println("\nEnter your pin !");
			String pin=scanner.nextLine();	
			
			usrAuthenticated=studentDatabase.StudentAuthenticate(urName, pin);
			if(usrAuthenticated) {
				currentUser=urName;
			}
			else {
				System.out.println("\nYou've entered wrong Credentials,Please try again !");
			}
		}
		
		//The method performs the choices entered by user..
		private void perform() {
			EnrollmentDatabase execute=new EnrollmentDatabase(currentUser);
			Boolean userExited=false;
			while(! userExited) {
				//show the main menu and get user choice
				String mainMenuSelect=DisplayMenu();
				
				//user choice is used here
				switch(mainMenuSelect) 
				{
				case DISPLAY_COURSES:
					courseDatabase.DisplayCourses();
					break;
				case VIEW_ENROLL_COURSE:
					execute.viewEnrolled();
					break;
				 case ENROLL_IN_COURSE:
					 execute.enroll();;
					break; 
				 case CLOCK_IN_TIME:
					 execute.clockIn();
				   break;
				 case VIEW_SUMMARY:
					 execute.summary();
					 break;
				 case EXIT:
					 userExited=true;
					 
				}
			}
		}
		
		//The method shows the main menu as well as it ask user to enter his choice..
		private String DisplayMenu()
		{
			System.out.println("\nMain Menu :");
			System.out.println("a - Display all courses");
			System.out.println("b - View enrolled courses");
			System.out.println("c - Enroll in a new course");
			System.out.println("d - Clock-in time");
			System.out.println("e - View Summary");
			System.out.println("f - Exit");
			System.out.println("return your choice");
			return scanner.nextLine();
		}
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			Console cs=new Console();
			cs.run();
			

		}

	}



