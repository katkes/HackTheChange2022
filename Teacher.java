
public class Teacher {

	String name; 
	int ID;
	String[] questions; //This is to be added on when the students asks questions

	public Teacher(String TeacherName, int TeacherID) {
		name = TeacherName;
		ID = TeacherID;
	}
	
	public int GetID() {
		return ID;
	}
	
	public String GetName() { 
		return name;
	}
	
	public String SayHi() {
		return "hi";
	}
}
