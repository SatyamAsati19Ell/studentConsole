package studentsProjects;

import java.util.HashMap;
import java.util.Map;

//class stores the data of student
public class StudentDatabase {
	//The map stores all the data related to the student where student name is the key....
	private Map<String,StudentAccounts>studentsMap=new HashMap<>();
	
	// no-argument StudentDatabase constructor initializes student account constructor and stores value
	public StudentDatabase() { 
		studentsMap.put("John",new StudentAccounts("S101","abcd"));
		studentsMap.put("Daniel",new StudentAccounts("S102","mnop"));	
	}
	
	//The method authenticate the login of student and returns true if matched
	public Boolean StudentAuthenticate(String userName,String userPassword) {
		if(studentsMap.containsKey(userName)) {
			if(studentsMap.get(userName).getPassword().equals(userPassword)) {
				return true;
			}
		}
		return false;	
	}
	
	//The method return the student id,takes student name as parameter 
	public String getStudentsId(String userName)
	{
		return studentsMap.get(userName).getStudentId();
	}

}

