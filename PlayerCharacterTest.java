//well this was successful :eyes:

import javax.swing.JOptionPane;
import java.util.Random; //the random class is dumb

public class PlayerCharacterTest {
	
	private static String characterName = JOptionPane.showInputDialog(null, "Name your character!"); //Im not sure why this needed to be here? I had it in main originally,,,

	Random ranDamage = new Random();
	//static int min = 7, max = 19, attackStat = ranDamage.nextInt(max) + min; //actual damage
	//static int medianDamage = (max + min) / 2; //a fixed number for the value, but damage will be randomly generated around this number
	static int medianDamage = 13;  
	
	public static void setAttack(int mD) {
		medianDamage = mD;
		min = (medianDamage - 6);
		max = (medianDamage + 6);
	}
	
	static int min = (medianDamage - 6), max = (medianDamage + 6);    //minimum and maximum amount of damage done to enemy
	int attackStat = ranDamage.nextInt(max) + min; //actual damage, like the damage done to enemies

	
	static PlayerCharacter user = new PlayerCharacter(characterName, 1, 750, medianDamage, 0); //try changing the way attack stat works
	
//main method	
	public static void main(String [] args) {
		
		display();
		for(int i = 0; i < 3; ++i) {
			System.out.println(attackStat);
		} //to see if the random num generator works
		
		int newlevel = user.getPlayerLevel(); System.out.println("level 1\n" + min + " " + max);

		LVL(newlevel);
		
		user.setPlayerLevel(2); System.out.println(min + " " + max);
					
		display();	
		for(int i = 0; i < 3; ++i) {
			System.out.println(attackStat);
		} //to see if the random num generator works
		
		equipWeapon(user.getPlayerAttack());
		equipArmor(user.getPlayerHP());
		
		display(); System.out.println("weapon and armor equipped \n" + min + " " + max);
		for(int i = 0; i < 3; ++i) {
			System.out.println(attackStat);
		} //to see if the random num generator works
		
	}
//asks user if they wanna display their stats	
	public static void display() {
		String displayStats = JOptionPane.showInputDialog(null, "Do you want to see your stats?");
		if (displayStats.equalsIgnoreCase("yes")){
			PlayerCharacter.displayUserStats(user); //Takes the values declared here and calls the displayUserStats method from the PlayerCharacter class
		} 
	}
//levels up the character and changes the character's stats
//@param lvl, takes the users level and adds one, buffing the stats of the user
	public static int LVL(int lvl) {
		System.out.println("You were level " + lvl + ".");
		lvl++;
		JOptionPane.showMessageDialog(null, "You are now a level " + lvl + "."); System.out.println("You are now level " + lvl + ".");
		medianDamage = 18;
		//user.setPlayerAttack(medianDamage); redundant?
		setAttack(medianDamage); 
		user.setPlayerHP(user.getPlayerHP() + 150);

		return lvl;
	}
//i added this method to see if "equipping" a sword could affect the attack stat	
//@param buff, takes the users attack stat and returns a buff	
	public static int equipWeapon(int buff) {
		boolean equipped = true, weapon = true;
		int addedAttack = 4;
		if(weapon = equipped) {
			user.setPlayerAttack(user.getPlayerAttack() + addedAttack); //changes the median attack stat. redundant? test later
	
			medianDamage = (user.getPlayerAttack() + addedAttack); //thinkingemoji
			setAttack(medianDamage); //affects the min and max attack stat
			user.setPlayerAttack(medianDamage);
		}
		return buff;
	}
//i added this method for the same reason i added the equip weapon method
//@param buff, takes the users hp stat and returns a buff	
	public static int equipArmor(int buff) {
		boolean equipped = true, armor = true;
		int addedHP = 75;
		if(armor = equipped) {
			user.setPlayerHP(user.getPlayerHP() + addedHP);
		}
		return buff;
	}
}
