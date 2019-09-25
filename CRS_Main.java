import java.io.Serializable;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class CRS_Main implements Serializable{
	public static void main(String[] args) throws IOException{
		int Course_option;
		int Admin_option;
		int Student_Option;
		int count = 0;

		
		//First we need to read the .csv file
		//Args[0] is just my .csv file
		File CSVFile = new File(args[0]);
		//using buffered reader to append to my list
		BufferedReader BR = new BufferedReader(new FileReader(CSVFile));
		String line = null;
		BR.readLine();
		while((line = BR.readLine()) != null){
			String[] coursedetails = line.split(",");
			
			if(coursedetails.length > 0) {
				course newCourse = new course(coursedetails[0], coursedetails[1], Integer.parseInt(coursedetails[2]), Integer.parseInt(coursedetails[3]), coursedetails[5], Integer.parseInt(coursedetails[6]), coursedetails[7]);
				Course_Directory.Course_List.add(newCourse);
			}
		}
		
		try{
			  //FileInputSystem recieves bytes from a file
		      FileInputStream fis = new FileInputStream("CourseRegistration.ser");
		      
		      //ObjectInputStream does the deserialization-- it reconstructs the data into an object
		      ObjectInputStream ois = new ObjectInputStream(fis);
		      
		      //Cast as Employee. readObject will take the object from ObjectInputStream
		      Course_Directory.Course_List = (ArrayList<course>)ois.readObject();
		      Course_Directory.Student_List = (ArrayList<Student>)ois.readObject();
		      ois.close();
		      fis.close();
		    }
		    catch(IOException ioe) {
		       //ioe.printStackTrace();
		       //return;
		    }
		 catch(ClassNotFoundException cnfe) {
		       //cnfe.printStackTrace();
		       //return;
		     }

		
//Serialization and CSV reading into ArrayLists		
		Scanner input =  new Scanner(System.in);

		
		System.out.println("Please enter your username");
		String un = input.next();
		System.out.println("Please enter your password");
		String ps = input.next();
		
		
		if(un.equals(Admin.Admin1.getAdminUser()) && ps.equals(Admin.Admin1.getAdminPass())) {
			System.out.println("Admin login successful");
			do {
				System.out.println("What would you like to do as an Admin?");
				Admin.Admin1.Option();
				Admin_option = input.nextInt();
				if(Admin_option == 1) {
					do {
						//Admin1 is static because we only want one admin, it is a global instance
						Admin.Admin1.Course_Management_Menu();
						Course_option = input.nextInt();
						switch(Course_option) {
							case 1:
								Admin.Admin1.Create_Course();
								break;
							case 2:
								System.out.println("Enter the CourseID of which course you would like to delete");
								Admin.Admin1.Delete_Course(input.next());
								break;
							case 3:
								System.out.println("Enter the CourseID of which course you would like to edit");
								Admin.Admin1.Edit_Course(input.next());
								break;
							case 4:
								System.out.println("Enter the CourseID of which course you would like to Display");
								Admin.Admin1.Display_Info(input.next());
								break;
							case 5:
								Admin.Admin1.Register();
								break;
							default:
								break;
						}
					}
					while(Course_option != 6);				
				}
				else if(Admin_option == 2) {
					do {
						Admin.Admin1.Reports_Menu();
						System.out.println("Please enter option");
						Course_option = input.nextInt();
						switch(Course_option) {
							case 1:
								Admin.Admin1.View_All();
								break;
							case 2:
								Admin.Admin1.View_All_Full();
								break;
							case 3:
								Admin.Admin1.Write_Full();
								break;
							case 4:
								System.out.println("Please enter course ID");
								Admin.Admin1.View_Students_SpecificCourse(input.next());
							case 5:
								System.out.println("Please enter first and last name of student");
								Admin.Admin1.View_Course_GivenStudent(input.next(), input.next());
								break;
							case 6:
								Admin.Admin1.Sort();
							default:
								break;
									
						}
					}
					while(Course_option!=7);
				}
				else {
					break;
				}
			}
			while(Admin_option != 3);
		}
		else if(Course_Directory.Student_List.size() > 0) {
			for(int i =0; i < Course_Directory.Student_List.size(); i++) {
				System.out.println(Course_Directory.Student_List.get(i).getUserName() + " " + Course_Directory.Student_List.get(i).getPassword());
				if(un.equals(Course_Directory.Student_List.get(i).getUserName()) && ps.equals(Course_Directory.Student_List.get(i).getPassword())){
					do {
						Course_Directory.Student_List.get(i).Course_Student_Menu();
						System.out.println("Please enter option: ");
						Student_Option = input.nextInt();
						switch(Student_Option) {
							case 1:
								Course_Directory.Student_List.get(i).ViewAll();
								break;
							case 2:
								Course_Directory.Student_List.get(i).ViewAll_Notfull();
								break;
							case 3:
								Course_Directory.Student_List.get(i).Register();
								break;
							case 4:
								Course_Directory.Student_List.get(i).Withdraw();
								break;
							case 5:
								Course_Directory.Student_List.get(i).View_RegisteredCourses();
								break;
							default:
								break;
						}
					}
					while(Student_Option != 6);
				}
			}
		}
		else {
			System.out.println("User does not exist, password or username is wrong");
			System.out.println("Please try again");
			
		}
		
		//The begginning of serialization
				try
		        {
		            FileOutputStream fos = new FileOutputStream("CourseRegistration.ser");
		            ObjectOutputStream oos = new ObjectOutputStream(fos);
		            oos.writeObject(Course_Directory.Course_List);
		            
		            //fos = new FileOutputStream("CourseRegistration.ser");
		            //oos = new ObjectOutputStream(fos);
		            oos.writeObject(Course_Directory.Student_List);
		            
		            oos.close();
		            fos.close();
		        }
		        catch (IOException ioe)
		        {
		            ioe.printStackTrace();
		        }
				//Now all data that has been aquired has been serialized
				
				
			//Deserialization
	

	
	}
}

