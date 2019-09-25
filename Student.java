import java.util.*;
import java.io.*;

//Import all utilities here as well
public class Student extends User implements Student_IF, Serializable {
	
	public ArrayList<course> Student_CourseList= new ArrayList<course>();
	Course_Directory Directory = new Course_Directory();
	
	public ArrayList<course> getStudent_CourseList() {
		return Student_CourseList;
	}

	public void setStudent_CourseList(ArrayList<course> student_CourseList) {
		Student_CourseList = student_CourseList;
	}
	//THIS IS VERY IMPORTANT
	//DO NOT DELETE
	public Student() {
		super();	
	}
	
	//Constructor for creating more student objects
	public Student(String FN, String LN, String UN, String Pass) {
		super(FN, LN, UN, Pass);
	}
	
	
		
	//View all Courses
	public void ViewAll() {		
		for(int i = 0; i < Course_Directory.Course_List.size(); i++) {
			Course_Directory.Course_List.get(i).PrintCourseInfo_Basic();			
		}
	}

	//View all my classes that are not full
	public void ViewAll_Notfull() {
		for(int i = 0; i< Course_Directory.Course_List.size(); i++) {
			if(Course_Directory.Course_List.get(i).getCurrent_Students() != Course_Directory.Course_List.get(i).getMax_Students()){
				Course_Directory.Course_List.get(i).PrintCourseInfo_Basic();
				
			}
		}
	}

	public void Register() {
		course temp = new course();
		Scanner inp3 = new Scanner(System.in);
		System.out.println("Please enter the course you'd like to register in");
		String c = inp3.nextLine();
		System.out.println("Enter the course section");
		int section = inp3.nextInt();
		System.out.println("Please enter your first and last name");
		String Fname = inp3.next();
		String Lname = inp3.next();
		for(int j = 0; j <Course_Directory.Course_List.size(); j++) {
			
			if(c.equals(Course_Directory.Course_List.get(j).getCourse_Name()) && section == Course_Directory.Course_List.get(j).getCourse_Section() && Course_Directory.Course_List.get(j).getCurrent_Students() != Course_Directory.Course_List.get(j).getMax_Students()){
				temp = Course_Directory.Course_List.get(j);
				
				for(int i = 0; i < Course_Directory.Student_List.size(); i++) {
					
					if(Fname.equals(Course_Directory.Student_List.get(i).getFirstName()) && Lname.equals(Course_Directory.Student_List.get(i).getLastName())) {
						Course_Directory.Student_List.get(i).Student_CourseList.add(temp);
						Course_Directory.Course_List.get(j).setCurrent_Students(Course_Directory.Course_List.get(j).getCurrent_Students()+1);
					}
					//we are adding this break statement so we dont go  through any unnecessary repetitions
					break;
				}
			} 
		}
	}

	@Override
	public void Withdraw() {
		course temp = new course();
		Scanner inp4 = new Scanner(System.in);
		System.out.println("Please enter the course you'd like to register in");
		String c = inp4.nextLine();
		System.out.println("Enter the course section");
		int section = inp4.nextInt();
		System.out.println("Please enter your first and last name");
		String Fname = inp4.next();
		String Lname = inp4.next();
		for(int i = 0; i <Student_CourseList.size(); i++) {
			
			if(c.equals(Course_Directory.Course_List.get(i).getCourse_Name()) && section == Course_Directory.Course_List.get(i).getCourse_Section()){
				temp = Course_Directory.Course_List.get(i);
				
				for(int k = 0; k < Course_Directory.Student_List.size(); k++) {
					
					if(Fname.equals(Course_Directory.Student_List.get(k).getFirstName()) && Lname.equals(Course_Directory.Student_List.get(k).getLastName())) {
						Student_CourseList.remove(temp);
						Course_Directory.Course_List.get(i).setCurrent_Students(Course_Directory.Course_List.get(i).getCurrent_Students()-1);
					}
				}
			}
		}		
	}

	public void View_RegisteredCourses() {
		for(int i = 0; i < Student_CourseList.size(); i++) {
			System.out.println(Student_CourseList.get(i).getCourse_Name());
		}	
	}



public void Course_Student_Menu() {
	// TODO Auto-generated method stub
	System.out.println("1. View All Courses");
	System.out.println("2. View All courses that are not full");
	System.out.println("3. Register in a course");
	System.out.println("4. Withdraw from a course");
	System.out.println("5. View all current courses that current student is registered in");
	System.out.println("6. Exit");
	
	}
}
