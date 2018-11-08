/*Name: Asia Minor
 *Date: November 1, 2018
 *Purpose: The purpose of this code is to create a program that will accept the "answers" of a test and compare
 *         those values to the correct answers and display whether the student passed or not 
 *Assumption: I'm going to assume the user input will be String values like i asked for. 
 */
import javax.swing.JOptionPane;
import java.util.Scanner;

public class DriverExam {
	//private static String "A","B","C","D";
	private static String arrayOfCorrectAnswers[] = {"B","D","A","A","C","A","B","A","C","D","B","C","D","A","D","C","C","B","D","A"};
	private static String arrayOfInputAnswers[] = new String[20];
	private static int c=0, ic=0, e=0;
	
//This is the main method	
	public static void main(String[] args) {
		String name=JOptionPane.showInputDialog("Please eneter your name!");
		JOptionPane.showMessageDialog(null, "Hello " + name + " You are going to take a test! \nYou will be asked"
				+ " to input the letters A-D. If you \nget 15 correct, you pass!");
		
		arrayComparison();
		passed(true);
		totalCorrect(c);
		totalIncorrect(ic);
		questionsMissed(e);
	}
//This method asks for input into the array and compares it to the array with the correct answers	
	public static void arrayComparison() {
		 Scanner keyboard = new Scanner(System.in);
		 System.out.println("Input letters A-D!");
		for(int i=0; i<arrayOfInputAnswers.length; i++){
			arrayOfInputAnswers[i] =  keyboard.nextLine();
			//System.out.println(arrayOfInputAnswers[i]);
	       if (arrayOfInputAnswers[i].equalsIgnoreCase("A"+"a"+"B"+"b"+"C"+"c"+"D"+"d")) {
	        	System.out.println("That is correct input.");
	        
	        	while(arrayOfInputAnswers[i] == arrayOfCorrectAnswers[i]){
	        		c++; //The c stands for correct
	        		break;
	        	}
	        	while(arrayOfInputAnswers[i]!=arrayOfCorrectAnswers[i]) {
	        		ic++; //the ic stands for incorrect
	        		break;
	        	}
	        	while(arrayOfInputAnswers[i]==" ") {
	        		e++; //The e stands for empty, since the questions is missed
	        		break;
	        	}
	        } else {
	        	System.out.println("That is not correct input.");
	        	break;
	        }
		}
		System.out.println(c+" "+ic+" "+e);//This was to check if the correct, incorrect, and empty counter was working
		keyboard.close();
    }
//Reveals true if the student passed or not
	public static boolean passed(boolean t) {
		if(c>=15) {
			System.out.println("You passed the exam!");
		} 
	//I was going to return the variable true but that's a keyword so i'm returning 't'
		return t;
	}
//This method will display how many numbers out of the total the user got correct	
	public static int totalCorrect(int total) {
		System.out.println("You got " + c + " correct! :)");
		return total;
	}
//This method will display how many numbers out of the total the user got incorrect	
	public static int totalIncorrect(int total) {
		System.out.println("You got " + ic + " incorrect. :(");
		return total;
	}
//This method will display how the questions that were missed
	public static int questionsMissed(int total) {
		System.out.println("You missed " + e + " questions.");
		return total;
	}
}
