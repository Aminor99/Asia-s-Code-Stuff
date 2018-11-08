import javax.swing.JOptionPane;
import java.util.Random;

public class DogRaceV2{
	private static String askNumOfDogs, askDogSpeed, ready;
	private static int numOfDogs, i;
	static int dogspeed[] = new int[numOfDogs];
	static String dogsname[] = new String[numOfDogs];
   //This is the main method
	public static void main(String [] args) {
		
		String name = JOptionPane.showInputDialog(null, "What is your name?");
		Name(name);
		
		askNumOfDogs = JOptionPane.showInputDialog("How many dogs are you entering into the race?");
		numOfDogs = Integer.parseInt(askNumOfDogs);
		
		Race();
		
		System.exit(0);		
	}
   //This method will take your name and welcome you to the race
	//@param String variable holding the users name
	//@return the value of the users name is passed
	public static String Name(String yourName) {
		JOptionPane.showMessageDialog(null, "Hello, " + yourName + " welcome to the dog race! DOGS ONLY! \n You will be asked to choose the number of dogs\n you want to " +
				"enter into the race, name them, and give them an integer speed.");
				
		return yourName;
	}
   //This method does more than i originally wanted it to	
	public static void Race() {
		
		String dogsname[] = new String[numOfDogs];
		int dogspeed[] = new int[numOfDogs];
		
		for(i=0; i<numOfDogs; i++){
	         dogsname[i] = JOptionPane.showInputDialog(null, "What's this dog's name?");
	         
	         askDogSpeed = JOptionPane.showInputDialog(null, "How fast is this dog? Instert a positive integer less than 100.");
	         dogspeed[i] = Integer.parseInt(askDogSpeed);
	         
	      }
		
		//displays a message for all the dogs in the race. Shows name and speed.
		for(i=0; i<numOfDogs; i++) {
			JOptionPane.showMessageDialog(null, dogsname[i] + " is in the race! \nTheir speed is " + dogspeed[i]);
		}
	
		int firstPlace = 0;
		int winner = 0;
		
		Random win = new Random(); //This is the random number
		int winCondition = win.nextInt(150); //The speed cap is at 150
		
		for(i=0; i<dogspeed.length - 1; i++) {
			 if (firstPlace < dogspeed[i]) {
		            firstPlace = dogspeed[i]; 
		            if (firstPlace > winCondition) {
		            	winner = firstPlace;
		            	JOptionPane.showMessageDialog(null, dogsname[i] + " won!!!"); 
		            } 
		      }	
		} 			
	}	
}