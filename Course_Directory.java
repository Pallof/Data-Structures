import java.io.Serializable;
import java.util.*;

public class Course_Directory implements Serializable {
	//This class is just to keep track of my two arraylists
	//for both students and courses. We are assuming there is only one admin
	
	//Set them to static so there is only one instance of the object
	public static ArrayList<course> Course_List = new ArrayList<course>();
	public static ArrayList<Student> Student_List = new ArrayList<Student>();
	
}