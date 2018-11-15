//well this was successful :eyes:

import javax.swing.JOptionPane;
import java.util.Random;

public class PlayerCharacterTest {
	
	private static String characterName = JOptionPane.showInputDialog(null, "Name your character!"); //Im not sure why this needed to be here? I had it in main originally,,,

	static Random ranDamage = new Random();
	static int min = 7, max = 19, attackStat = ranDamage.nextInt(max) + min; //actual damage
	static int medianDamage = (max + min) / 2; //a fixed number for the value, but damage will be randomly generated around this number
	
	static PlayerCharacter user = new PlayerCharacter(characterName, 1, 750, medianDamage);
//main method	
	public static void main(String [] args) {
		
		display();
		
	}
//asks user if they wanna display there stats	
	public static void display() {
		String displayStats = JOptionPane.showInputDialog(null, "Do you want to see your stats?");
		if (displayStats.equalsIgnoreCase("yes")){
			PlayerCharacter.displayUserStats(user); //Takes the values declared here and calls the displayUserStats method from the PlayerCharacter class
		} 
	}
	
}
