//we will need an arraylist for List of names in a class and deletion
//using the .remove method
import java.util.ArrayList;
import java.io.*;

//We will use array list for the list of name of students
public class course implements Serializable {
	protected String Course_Name;
	protected String Course_ID;
	protected int Max_Students;
	protected int Current_Students;
	protected ArrayList<String> List_Names = new ArrayList<String>();
	protected String Instructor;
	protected int Course_Section;
	protected String Course_Location;
	
	
	public course(){
		
	}
	public course(String C_N, String C_ID, int Max_S, int Current_S, String Instructor, int Course_S, String Course_L){
		this.Course_Name = C_N;
		this.Course_ID = C_ID;
		this.Max_Students = Max_S;
		this.Current_Students = Current_S;
		//All courses must be empty when they are first created.
		//this.List_Names = List_Names;
		this.Instructor = Instructor;
		this.Course_Section = Course_S;
		this.Course_Location = Course_L;
		
	}
	public String getCourse_Name() {
		return Course_Name;
	}
	
	public void setCourse_Name(String course_Name) {
		Course_Name = course_Name;
	}
	
	public String getCourse_ID() {
		return Course_ID;
	}
	
	public void setCourse_ID(String course_ID) {
		Course_ID = course_ID;
	}
	
	public int getMax_Students() {
		return Max_Students;
	}
	
	public void setMax_Students(int max_Students) {
		Max_Students = max_Students;
	}
	
	public int getCurrent_Students() {
		return Current_Students;
	}
	
	public void setCurrent_Students(int current_Students) {
		Current_Students = current_Students;
	}
	public ArrayList<String> getList_Names() {
		return List_Names;
	}
	
	public void setList_Names(ArrayList<String> list_Names) {
		List_Names = list_Names;
	}
	
	public String getInstructor() {
		return Instructor;
	}
	
	public void setInstructor(String instructor) {
		Instructor = instructor;
	}
	
	public int getCourse_Section() {
		return Course_Section;
	}
	
	public void setCourse_Section(int course_Section) {
		Course_Section = course_Section;
	}
	
	public String getCourse_Location() {
		return Course_Location;
	}
	
	public void setCourse_Location(String course_Location) {
		Course_Location = course_Location;
	}
	//For students
	public void PrintCourseInfo_Basic() {
		System.out.println(Course_Name);
		System.out.println(Course_ID);
		System.out.println(Instructor);
		System.out.println("Course Section Number " + Course_Section);
		System.out.println(Course_Location);
	}
	
	//For admin
	public void PrintCourseInfo() {
		System.out.println(Course_Name);
		System.out.println(Course_ID);
		System.out.println("Max number of Students "+ Max_Students);
		System.out.println("Current number of students " + Current_Students);
		for(int i = 0; i < List_Names.size(); i++) {
			System.out.print(List_Names.get(i) + " ");
		}
		//Using a for loop to print out all 
		System.out.println(Instructor);
		System.out.println("Course Section Number " + Course_Section);
		System.out.println(Course_Location);
	}
	
}
