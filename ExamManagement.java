import java.util.*;
public class ExamManagement {

Scanner sc = new Scanner(System.in);
HashMap<String,Integer> details = new HashMap<String,Integer>();

	public void userlogin() {
		details.put("praneeth",1234);
		System.out.println("\n\n ---------------------------- WELCOME TO ONLINE EXAM PORTAL ----------------------------");
		String username;
		int password;
		System.out.print("Enter The username : ");
		username = sc.next();
		System.out.print("Enter password : ");
		password = sc.nextInt();
		if(details.containsKey(username)) {
			if(details.get(username)==password){
				System.out.println("\nWelcome Back User");
				option_menu();
			}
			else {
				System.out.println("Enter valid Password for user "+username);
				userlogin();
			}
        }
		else{
			System.out.println("Please Enter valid User Name");
		}
    
	}
	public void option_menu() {
		int choice;
		System.out.println("....User Menu....");
		System.out.println("1.Update The Profile\n2.Write the Exam\n3.Exit ");
		System.out.println("Enter The Choice: ");
		choice = sc.nextInt();
		switch(choice) {
		case 1:
			details=updateDetails();
			option_menu();
			break;
		case 2:
			exam();
			option_menu();
			break;
		case 3:
            System.out.println("Thanks For Using!!!!!!!!!!");
			System.exit(0);
			break;
		default:
			System.out.println("Please Enter Number in User Menu Only");
		}
	}
	public HashMap<String,Integer> updateDetails(){
		String uname;
		int upwd;
		System.out.println("updateDetails Profile");
		System.out.println("Enter The Username: ");
		uname = sc.next();
		if(details.containsKey(uname)) {
		System.out.println("Enter New Password for your Account");
		upwd = sc.nextInt();
		details.replace(uname, upwd);
        System.out.println("Details Updated Successfully.");
		}
		else {
			System.out.println("Enter Correct User Name");
		}
		return details;
	}
public void exam() {
    Calendar c = Calendar.getInstance();
	long startTime=System.currentTimeMillis();
	long finishTime=startTime+30;
	int answeredQuestions=0;
	int userAnswer,scoreSecured;
	System.out.println("Please Start Your Exam");
	System.out.println("Instructions: ");
	System.out.println("You Have Answer 5 Questions to Answer in 30 Seconds");
	System.out.println("Each Question carries 10 marks and -5 for wrong answer");
	HashMap<String,ArrayList<String>> questions=new HashMap<String,ArrayList<String>>();
	ArrayList<String> a1=new ArrayList<String>();
	a1.add("James Gosling");
	a1.add("Bjarne Stroustrup");
	a1.add("Brendan Eich");
	a1.add("Guido van Rossum");
	a1.add("1");
	questions.put("Who is the Father of Java?",a1);
	ArrayList<String> a2=new ArrayList<String>();
	a2.add("Dynamic");
	a2.add("Architecture Neutral");
	a2.add("Use of pointers");
	a2.add("Object-oriented");
	a2.add("3");
	questions.put("Which of the following is not a Java features?",a2);
	ArrayList<String> a3=new ArrayList<String>();
	a3.add("JVM");
	a3.add("JRE");
	a3.add("JDK");
	a3.add("JDB");
	a3.add("4");
	questions.put(" ___ is used to find and fix bugs in the Java programs.",a3);
	ArrayList<String> a4=new ArrayList<String>();
	a4.add("A final method cannot be overridden in its subclasses.");
	a4.add("A final class cannot be extended.");
	a4.add("A final class cannot extend other classes.");
	a4.add("A final method can be inherited.");
	a4.add("3");
	questions.put("Which option is false about the final keyword?",a4);
    ArrayList<String> a5=new ArrayList<String>();
	a5.add("Stack");
	a5.add("Heap memory");
	a5.add("String memory");
	a5.add("Random storage space");
	a5.add("2");
	questions.put("In which memory a String is stored, when we create a string using new operator?",a5);
	int sn=0;
    Set<String> set=questions.keySet(); 
    ArrayList<String> a6=new ArrayList<>(set);
    int x=a6.size();
	while(System.currentTimeMillis()<finishTime || sn<x) {
        String i=a6.get(sn);
		System.out.println("\n\nQ."+(sn+1)+") "+i);
		System.out.println("\n(1) "+questions.get(i).get(0)+"\t"+"(2) "+questions.get(i).get(1)+"\t"+"(3) "+questions.get(i).get(2)+"\t"+"(4) "+questions.get(i).get(3)+" ");
		System.out.println("Enter Your Option");
		userAnswer=sc.nextInt();
		System.out.println("Answer is Submited...");
		if(userAnswer==Integer.parseInt(questions.get(i).get(4))) {
			answeredQuestions++;
		}
        sn++;
	}
	System.out.println("You Have Completed the Exam");
	scoreSecured=answeredQuestions*10-((5-answeredQuestions)*5); 
	System.out.println("Your score is..."+" "+scoreSecured+"/50");	
}

public static void main (String[] args)
{
	ExamManagement log =new ExamManagement();
		log.userlogin(); 
}
}
