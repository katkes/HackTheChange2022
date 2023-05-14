
public class Student {
	
	public String name; 
	public int ID, LENGTH, ranking;
	public String[] questions = new String[1]; //This is to be added on when the students asks questions

	public Student(String StuName, int StudentID) {
		name = StuName;
		ID = StudentID;
	}
	
	private int GetID() {
		return ID;
	}
	
	public String GetName() { 
		return name;
	}
	
	public String SayHi() {
		return "hi";
	}
	
	public String[] AskQuestion(String question) {
		
		if (questions[0] == null) {
			questions[0] = question;
		}
			
		else {
		LENGTH = questions.length + 1; 
		String[] qlist = new String[LENGTH]; 
		for (int i = 0; i < questions.length; i++) {
			qlist[i] = questions[i];
		}
		qlist[questions.length] = question;
		questions = qlist.clone();
		
		}
		
		return questions;
	}
	
	public void GetQuestions() {
		
		for (int i = 0; i < questions.length; i++) {
			System.out.println(questions[i]);
		}
	}
	
	public String[] QuestionsList() {
		return questions;
	}
	
	



}
