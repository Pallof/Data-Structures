
public interface Admin_IF {
	public void Option();
	//COURSE MANAGEMENT
	public void Course_Management_Menu();
	public void Create_Course();
	//Search Everything by course ID
	public void Delete_Course(String id);
	public void Edit_Course(String id);
	public void Display_Info(String id);
	public void Register();
	
	
	//Reports
	public void Reports_Menu();
	public void View_All();
	public void View_All_Full();
	//This one doesnt make any sense
	public void Write_Full();
	public void View_Students_SpecificCourse(String id);
	public void View_Course_GivenStudent(String F, String L);
	public void Sort();
	
	
}
