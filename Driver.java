import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		int ID, LENGTH;
		String name, action;
		String[] questions = new String[1];
		String[] hold;
		Scanner key = new Scanner(System.in);
		
		
		System.out.println("Welcome to the program! Please state whether you're a student or a teacher: ");
		
		String person = ((key.next()).trim()).strip();
		 
		if (person.equalsIgnoreCase("student")) {
			
			do {
			System.out.println("Please enter your name: ");
			name = key.next();
			System.out.println("Please enter your student ID: ");
			ID = key.nextInt();
			Student stu = new Student(name,ID);
			
			System.out.println("Welcome " + stu.GetName() + " to the teacher/student help desk!");
			
			System.out.println("***************************************************");
			System.out.println("  | Code >> Description                           |");
			System.out.println("***************************************************");
			System.out.println("  | 1    >> Ask a question                        |");
			System.out.println("  | 2    >> See your questions                    |");
			System.out.println("  | 3    >> See all questions                     |");
			System.out.println("  | 4    >> See where your question(s) ranks      |");
			System.out.println("  | 5    >> Switch users                          |");		
			System.out.println("  | 0    >> End program                           |");
			System.out.println("***************************************************");
			
			do {
				System.out.println("Please enter what you would like to do: ");
				action = key.next();
				
				switch (action) {
				
				case "1":
					System.out.print("Please enter your question: ");
					String garbage = key.nextLine();
					String q = key.nextLine();
					stu.AskQuestion(q);
					
					if (questions[0] == null) {
						questions[0] = q;
					}
						
					else {
					LENGTH = questions.length + 1; 
					String[] qlist = new String[LENGTH]; 
					for (int i = 0; i < questions.length; i++) {
						qlist[i] = questions[i];
					}
					qlist[questions.length] = q;
					questions = qlist.clone();
					
					}
					
					
					
					break;
				
				case "2":
					
					stu.GetQuestions();
					break;
					
				case "3":
					
					for (int i=0; i < questions.length; i++) {
						System.out.println(questions[i]);
					}
					break;
					
				case "4":
					
					hold = stu.QuestionsList();
					
					for (int i = 0; i < questions.length; i++) {
						int count = 1;
						for (int j = 0; j< hold.length; j++) {
							int a = j;
							if (questions[i] == hold[j]) {
								System.out.println("Question "  + (i + 1) + " ranks " + (i + 1) + " out of " + questions.length + " questions");
							}
							else {
								count++;
							}
						}
					}
					
					
					break;
					
				case "5":
					action = "change";
					
					break;
				
				case "0":			
					
					System.exit(0);
				
					}
				
				
			}
			while (action != "change");
			
			} while (action != "0");
			
			
			
			

		
		if (person.equalsIgnoreCase("teacher")) {
			System.out.println("Please enter your name: ");
			name = key.next();
			System.out.println("Please enter your teacher ID: ");
			ID = key.nextInt();
			Teacher prof = new Teacher(name , ID);
			
			System.out.println("Welcome " + prof.GetName() + "to the teacher/student help desk!");
			
			System.out.println("***************************************************");
			System.out.println("  | Code >> Description                           |");
			System.out.println("***************************************************");
			System.out.println("  | 1    >> See questions                         |");
			System.out.println("  | 2    >> Answer a question                     |");
			System.out.println("  | 3    >> See who asked the most questions      |");
			System.out.println("  | 0    >> End program                           |");
			System.out.println("***************************************************");
			System.out.println("");			
			
			do {
				System.out.println("Please enter what you would like to do: ");
				action = key.next();
				
				switch (action) {
				
				case "1":
					
					for (int i = 0; i < questions.length; i++) {
						System.out.println(questions[i]);
					}
					
					break;
				
				case "2":
					
					for (int i = 0; i < questions.length; i++) {
						System.out.println(questions[i]);
					}
					System.out.println("Please pick a question to answer (number in order): ");
					int order = key.nextInt() - 1;
					
					System.out.println(questions[order]);
					
					System.out.print("Please enter your answer: ");
					
					String garbage2 = key.nextLine();
					
					String answer = key.nextLine();
					
					System.out.println("The answer to the question " + "\"" + questions[order] + "\"" + " is " + answer);
					
					hold = questions.clone();
					
					String[] newlist = new String[(questions.length) - 1];
					
					int count = 0;
					for (int i = 0; i < questions.length; i++) {
						
						if (questions[i] == questions[order]) {
							continue;
						}
						
						else {
							newlist[count] = questions [i];
							count++;
						}
					}
					
					questions = newlist.clone();
					
					for (int i = 0; i < questions.length; i++) {
						System.out.println(questions[i]);
					}
					
					break;
					
				case "3":
					
					break;
				
				}
				
				
			}
			while (action != "0");			
		}
		

		
		
			
		key.close();
	}

}
	
}