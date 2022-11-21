package studentsProjects;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class CourseDatabase
{
	// course information is stored in this map
	private static Map<String,Courses> courseMap=new TreeMap<>();
	
	
	public CourseDatabase() {
		courseMap.put("C1", new Courses("Java Basic","Low",3));
		courseMap.put("C2", new Courses("Advance Java Tutorial","Medium",4));
		courseMap.put("C3", new Courses("SQL Developer Course","Medium",4));
		courseMap.put("C4", new Courses("DevOps Tutorial","High",5));

		
	}
	
	//getter  method is created to access the map outside the class
	public Map<String, Courses> getCourseMap()
	{
		return courseMap;
	}
	
	// this method is used to display all available courses
	public void DisplayCourses() 
	{
		System.out.println("--------------------------------------------------------------------------------");
		System.out.printf("%-18s%-30s%-20s%-2s","Course Id", "Name", "Difficulty Level", "Duration");
		System.out.println();
		System.out.println("--------------------------------------------------------------------------------");
		for(Entry<String, Courses> g: courseMap.entrySet()) 
		{
			System.out.printf("%-18s%-30s%-20s%-2s", g.getKey(),g.getValue().getCourseName() , g.getValue().getCourseLevel(), g.getValue().getCourseDuration(),"");
			System.out.println();
			
	    }
		System.out.println("---------------------------------------------------------------------------------");
	}

}
