import java.util.*;
import java.io.*;
//all the utilities

public class Admin extends User implements Admin_IF, Serializable {
	//COURSE MANAGEMENTS
	private String AdminUser = "Admin";
	private String AdminPass = "Admin001"	;	
	public Admin() {
		super();
	}
	public Admin(String UN, String Pass) {
		super(UN, Pass);
	}
	
	public String getAdminUser() {
		return AdminUser;
	}
	public String getAdminPass() {
		return AdminPass;
	}
	//making this static so that there is only one instance
	Course_Directory Directory = new Course_Directory();
	static Admin Admin1 = new Admin("Admin", "Admin001");
	
	public void Create_Course() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the name of the new course");
		String cn = input.nextLine();
		System.out.println("Enter the course ID");
		String id = input.next();
		System.out.println("What is the maximum number of students?");
		int mx = input.nextInt();
		//current number of students must be 0 and arraylist will be set to null
		//
		System.out.println("Please enter name of Instructor");
		//for simplicity sake, first name only
		String instruct = input.next();
		System.out.println("Please enter course section number");
		int cor_sec = input.nextInt();
		System.out.println("Please enter the course locations");
		String loc = input.nextLine();
		course newCourse = new course(cn, id, mx, 0, instruct, cor_sec, loc );
		Course_Directory.Course_List.add(newCourse);		
	}

	public void Delete_Course(String id) {
		for(int i = 0; i < Course_Directory.Course_List.size(); i++ ) {
			if(id.equals(Course_Directory.Course_List.get(i).getCourse_ID())) {
				Course_Directory.Course_List.remove(i);
			}
		}
		
		// TODO Auto-generated method stub
		
	}
	//For edit/ simplicity sake, we are just doing instructor name 
	public void Edit_Course(String id) {
		Scanner inp1 = new Scanner(System.in);
		for(int i = 0; i < Course_Directory.Course_List.size(); i++ ) {
			if(id.equals(Course_Directory.Course_List.get(i).getCourse_ID())) {
				System.out.println("Please enter new instructor name");
				Course_Directory.Course_List.get(i).setInstructor(inp1.next());
			}
		}
		
	}

	@Override
	public void Display_Info(String id) {
		for(int i = 0; i < Course_Directory.Course_List.size(); i++ ) {
			if(id.equals(Course_Directory.Course_List.get(i).getCourse_ID())) {
				Course_Directory.Course_List.get(i).PrintCourseInfo();
				
			}
		}
		
	}

	//Registering a student
	public void Register() {
		Scanner inp2 = new Scanner(System.in);
		System.out.println("What is the students first name");
		String Fname = inp2.next();
		System.out.println("Enter the students Last Name");
		String Lname = inp2.next();
		System.out.println("Please enter a UserName for student");
		String Uname = inp2.next();
		System.out.println("Please enter a password for Student");
		String pw = inp2.next();
		Student temp = new Student(Fname, Lname, Uname, pw);
		Course_Directory.Student_List.add(temp);
		//figure out how to register a student

		
	}

//REPORTS SECTIONS DOWN BELOW	
	
	
	@Override
	public void View_All() {
		for(int i = 0; i < Course_Directory.Course_List.size(); i++) {
			Course_Directory.Course_List.get(i).PrintCourseInfo();
		}	
	}

	@Override
	public void View_All_Full() {
		for(int i = 0; i < Course_Directory.Course_List.size(); i++) {
			if(Course_Directory.Course_List.get(i).getCurrent_Students() == Course_Directory.Course_List.get(i).getMax_Students()) {
				Course_Directory.Course_List.get(i).PrintCourseInfo();
			}
		}
	}
	//USE FILE IO TO DO THIS ONE
	//Writing to a seperate text file, all courses that are full
	public void Write_Full() {
		Scanner scan = new Scanner(System.in);
		File newfile1 = new File("Full_Courses.txt");
		try {
			FileWriter fw = new FileWriter(newfile1);
			BufferedWriter bw = new BufferedWriter(fw);
			String text = scan.nextLine();
			for(int i = 0; i < Course_Directory.Course_List.size(); i++) {
				if(Course_Directory.Course_List.get(i).getCurrent_Students() == Course_Directory.Course_List.get(i).getMax_Students()) {
					//I think you can use either '.write' or the '.append' function here
					bw.write(Course_Directory.Course_List.get(i).Course_Name);
					bw.newLine();
					//fw.append(Course_Directory.Course_List.get(i).Course_Name);
					fw.close();
				}
			}
			
		} catch (IOException e) {
			System.out.println( "Error writing file '" + newfile1 + "'");
			e.printStackTrace();
		}
		
		
	}

	public void View_Students_SpecificCourse(String id) {
		for(int i = 0; i < Course_Directory.Course_List.size(); i++) {
			if(id.equals(Course_Directory.Course_List.get(i).getCourse_ID())) {
				Course_Directory.Course_List.get(i).getList_Names();
			}
		}	
	}

	public void View_Course_GivenStudent(String F, String L) {
		for(int i = 0; i < Course_Directory.Student_List.size(); i++) {
			if(F.equals(Course_Directory.Student_List.get(i).getFirstName()) && L.equals(Course_Directory.Student_List.get(i).getLastName())){
				//Need to fill in that method in order to use it
				//We can use method from student class becuase obc within student list
				//is a 'student' type 
				Course_Directory.Student_List.get(i).View_RegisteredCourses();
			}
		}
	}
	//Good ol Reliable bubble sort comes to my rescue, not sure if we were allowed to use sorting imports
	//This is a very slow sorting algorithm, however our dataset is small and it shouldnt matter to much
	public void Sort() {
		for(int i = 0; i<Course_Directory.Course_List.size(); i++) {
			for(int j = 0; j< Course_Directory.Course_List.size() - i -1; j++) {
				
				if(Course_Directory.Course_List.get(j).getCurrent_Students() > Course_Directory.Course_List.get(j+1).getCurrent_Students()) {
					
					course temp = Course_Directory.Course_List.get(i+1);
					Course_Directory.Course_List.set(j+1, Course_Directory.Course_List.get(j));
					Course_Directory.Course_List.set(j, temp);
				}
				
			}
		}
		
	}
	//This method is to export the LIST's so that I dont have two seperate lists running at the same time
	// No longer theese this method, as we made all of our lists static.
	public Course_Directory ExportCD(){
		return Directory;
		
	}
	public void Option() {
		System.out.println("1. Course Management");
		System.out.println("2. Reports Menu");
		System.out.println("3. Exit");
		
	}

	@Override
	public void Course_Management_Menu() {

		System.out.println("1. Create a new course");
		System.out.println("2. Delete a Course");
		System.out.println("3. Edit a course");
		System.out.println("4. Display Information for a given course");
		System.out.println("5. Register a Student");
		System.out.println("6. Exit");
		
	}

	@Override
	public void Reports_Menu() { 
		System.out.println("1. View All Courses");
		System.out.println("2. View all courses that are full");
		System.out.println("3. Write to a file, the list of courses that are full");
		System.out.println("4. View the names of a students registered in a specific course");
		System.out.println("5. View the list of courses a given student has registered in");
		System.out.println("6. Sort Courses based on number of students registered");
		System.out.println("7. Exit");

		
	}

}
