//I'm doing some wild stuff
//Create an array that has a bunch of passages, and use a random number generator that chooses a number in that array MOSTLY DONE
//Use do while loop. It will quit if a quit passage plays (break or system.exit) DONE
//add some method or whatever that takes user to location depending on action taken 
//implement some type of enemy encounter DONE
import javax.swing.JOptionPane;
import java.util.Random;
import java.util.ArrayList;
//LET THE GAME BEGIN HEHE
public class RPGame {
//V A R I A B L E S	
//all the arrays and other variables and stuff. Its a lot of stuff :eyes: hehehe
	private static String inputName, inputDirection, inputDirection2, inputDirection3, inputDirection4, inputDirection5, inputDirection6, inputDirection7,
		inputDirection8, cont, approach, fullName;
//These arrays be thicc
	private static String actionArray[] = {"You walk down a dirt path.","You wander on the dark path ahead of you.", "You see a large tree.", "Above you, the sun"
			+ " shines the path ahead of you.","A sudden fog washes over you","You begin to feel hungry.","You think about home.", "You look behind you. There is nothing.", 
			"You can hear running water.","It's beggining to rain.","You sprint to the next location.","You find yourself at " ,"You see the castle in the distance!", "You start to feel" +
			"weary and tired...", "You come across a "}, //15 elements, subtract 3 because the last 3 or special
	enemyArray[] = {"Giant Spider", "Small Spider", "Bat Creature", "Plant Monster", "Baby worm", "Zombie", "Skeleton", "Whisp", "Slime", "Goblin", "Ghoul", "Goomba", 
			"Vine Pincer", "Gelatinous Cube","Consumer of Blank","Devourer of Nightmares"}, //16 elements,but the last 2 are meant to be unbeatable lol
	locationArray[] = {"Dark Forest","Blue Sky River","Whack Lands","Drowned Flats","Cave of Mystic","Mountain of Chaos","Castle of Dreams"}, //6 elements 
	winningPathArray[] = {"up","up","down","down","left","right","left","right"}, deathPathArray[] = {"down", "down", "up", "up", "right", "left","right","left"};
	private static ArrayList<String> directionArrList = new ArrayList<String>(8);
	
//random numbers ;)
	static Random ranAction = new Random();static Random ranAction2 = new Random(); static Random ranEnemy = new Random(); static Random ranLocation = new Random();
	static Random ranWinRate = new Random(); static Random ranEncounterRate = new Random();//i will us this to choose a random element in an array ;) 
	
    //does this count as cheating cuz i got this thing online somewhere wowo
	public static int compareArrayAndArrayListElements(String[] array, ArrayList<String> arraylist) {
    	int count = 0;
        for (String s : array) {
            if (arraylist.contains(s)) {
                count++;
            }
        }
        return count;
    }
	
//this is the main method or whatever, dont forget it ;)	
	public static void main(String[] args) {		
		Name();//lol this didn't even need to be it's own method but whatever, looks cool
		JOptionPane.showMessageDialog(null, fullName + ", You have been chosen to go on this quest. \n    Your goal is to find the Castle of Dreams.");
		
		beginJourney();
		
	}
//asks the user to name their adventurer,,,,Im adding more to it haha
	public static void Name() {
		Random ranTitle = new Random();
		int titleNum = ranTitle.nextInt(16);
		
		inputName = JOptionPane.showInputDialog(null, "Hello. adventurer! Today is the day you will\n           begin your journey! What is \n               your adventurers name?");
		String titles[] = {" the Brave", " the Mighty", " the Village Hero", " protector of the Meek", " the Faithful", " the Scourge", " the Hidden", " the Shadow Lurker",
				" the Healer", " the Supporter", " the Calm", " the Brash", " the Agile", " the Blade Dancer", " the Legendary", " the Great", " the Enlightened"}; //17 elements
		fullName = inputName + titles[titleNum];
	}
//this method calls the path methods. it loops as long as you wanna continue
	public static void beginJourney(){
		//This code loops if you wanna continue the journey :)
		do{ JOptionPane.showMessageDialog(null, fullName + ", this is the start of your journey!");
			inputDirection = JOptionPane.showInputDialog("What direction do you go?"); path1(inputDirection); System.out.println (inputDirection); //This is just so that i can test
			inputDirection2 = JOptionPane.showInputDialog("What direction do you go?"); path2(inputDirection2); System.out.println (inputDirection2); //if the array and arraylist
			inputDirection3 = JOptionPane.showInputDialog("What direction do you go?"); path3(inputDirection3); System.out.println (inputDirection3); //comparison works. between the
			inputDirection4 = JOptionPane.showInputDialog("What direction do you go?"); path4(inputDirection4); System.out.println (inputDirection4); //dying and the action sentences,
			inputDirection5 = JOptionPane.showInputDialog("What direction do you go?"); path5(inputDirection5); System.out.println (inputDirection5); //i often forget what direction i
			inputDirection6 = JOptionPane.showInputDialog("What direction do you go?"); path6(inputDirection6); System.out.println (inputDirection6); //typed in ;)
			inputDirection7 = JOptionPane.showInputDialog("What direction do you go?"); path7(inputDirection7); System.out.println (inputDirection7);
			inputDirection8 = JOptionPane.showInputDialog("What direction do you go?"); path8(inputDirection8); System.out.println (inputDirection8);  
			System.out.println("This is a new loop"); //This is just a reminder that the loop started over 
		} while(cont.equalsIgnoreCase("yes"));
		
		if (cont.equalsIgnoreCase("no")) {
			JOptionPane.showMessageDialog(null, "Your journey ends here. Have a good day :)");
			System.exit(0);
			} else {
				JOptionPane.showMessageDialog(null, "That is not correct input");
			}
	}
//I was originally gonna copy this block of code 8 times but then i realized how dumb that was lol	
	public static void Adventure(){
		
		int actionNum = ranAction.nextInt(10), enemyNum = ranEnemy.nextInt(13), locationNum = ranLocation.nextInt(5), encounterRateName = ranEncounterRate.nextInt(20);
		
		JOptionPane.showMessageDialog(null, actionArray[actionNum]);
		
		approach = JOptionPane.showInputDialog(null, "You think you see a " + enemyArray[enemyNum] + ". \nDo you approach it?");
		if (approach.equalsIgnoreCase("yes")){
			if(enemyNum==14) {
				JOptionPane.showMessageDialog(null, "You were slain immediately");
				System.exit(0);
			} else if(enemyNum==15) {
				JOptionPane.showMessageDialog(null, "You were slain immediately");
				System.exit(0);
			}
			
			enemyEncounter EC = new enemyEncounter(encounterRateName); 
		} 
		
		int actionNum2 = ranAction2.nextInt(11);
		JOptionPane.showMessageDialog(null, actionArray[actionNum2]);

		JOptionPane.showMessageDialog(null,"You see a sign.\n You arrive at the " + locationArray[locationNum]);
	}
//first path
	//@param takes the input of what direction the user chooses to go
	//@return, the location is being returned?
	public static String path1(String dirInput) {
		
		JOptionPane.showMessageDialog(null, "You went " + dirInput + ".");
		directionArrList.add(dirInput);
		
		Adventure();
		
		return dirInput;
	}
//second path	
	//@param takes the input of what direction the user chooses to go
	//@return, the locations is being returned
	public static String path2(String dirInput) {
		
		JOptionPane.showMessageDialog(null, "You went " + dirInput +".");
		directionArrList.add(dirInput);
		
		Adventure();
		
		return dirInput;
	}
//third path	
	//@param takes the input of what direction the user chooses to go
	//@return location
	public static String path3(String dirInput) {
		
		JOptionPane.showMessageDialog(null, "You went " + dirInput + ".");
		directionArrList.add(dirInput);
		
		Adventure();
		
		return dirInput;
		}
//fourth path	
	//@param takes the input of what direction the user chooses to go
	//@return, location
	public static String path4(String dirInput) {
		
		JOptionPane.showMessageDialog(null, "You went " + dirInput +".");
		directionArrList.add(dirInput);
		
		Adventure();
		
		return dirInput;
	}
//fifth path	
	//@param takes the input of what direction the user chooses to go
	//@return, location
	public static String path5(String dirInput) {
		
		JOptionPane.showMessageDialog(null, "You went " + dirInput + ".");
		directionArrList.add(dirInput);
		
		Adventure();
	
		return dirInput;
	}
//sixth path	
	//@param takes the input of what direction the user chooses to go
	//@return, location
	public static String path6(String dirInput) {
		
		JOptionPane.showMessageDialog(null, "You went " + dirInput + ".");
		directionArrList.add(dirInput);
		
		Adventure();
	
		return dirInput;
	}
//seventh path
	//@param takes the input of what direction the user chooses to go
	//@return, location
	public static String path7(String dirInput) {
		
		JOptionPane.showMessageDialog(null, "You went " + dirInput + ".");
		directionArrList.add(dirInput);
		
		Adventure();
		
		return dirInput;
	}
//eighth path	
	//@param takes the input of what direction the user chooses to go
	//@return, location
	public static String path8(String dirInput) {
		
		JOptionPane.showMessageDialog(null, "You went " + dirInput + ".");
		directionArrList.add(dirInput);
		
		Adventure();
//end of the journey here		W O R K O N T H I S B L O C K there is an obcious problem here
		JOptionPane.showMessageDialog(null, "This is the end of your journey.");
		if (compareArrayAndArrayListElements(winningPathArray, directionArrList) < 8) {
			cont = JOptionPane.showInputDialog(null, "Would you like to start over?\n      Type yes or no.");
	} else {
		winComparison(true);
	}
		return dirInput; 
	}
//compares user input of directions to the path that leads to the castle ;
	public static boolean winComparison(boolean t) {
		if (compareArrayAndArrayListElements(winningPathArray, directionArrList) == 8) {
			winningPath();		
	} else if (compareArrayAndArrayListElements(deathPathArray, directionArrList) == 8) {
		losingPath();
	}
		return t; //the t stands for true
	}
//This method should only be called if the inputDirections equal the winningPathArray ;). working out the issues,,,
	public static void winningPath() {
		//insert message dialog boxes about how the game is over and the user won
		JOptionPane.showMessageDialog(null, actionArray[12]);
		
		JOptionPane.showMessageDialog(null, "You found the castle!\n      You win!\n  This is it chief.");
		System.exit(0);
	}
//this is bad	
	public static void losingPath() {
		JOptionPane.showMessageDialog(null, actionArray[13]);
		
		JOptionPane.showMessageDialog(null, "Wandering down this path leads you \nsomewhere you can never come back from.\n GAME OVER");
		System.exit(0);
	}
}
//for the enemy encounter object
class enemyEncounter{
	Random enemyEncounter = new Random();
	int enemyEncounterNum = enemyEncounter.nextInt(20), r = 8; //r equals to winrate
	private int encounter;
//Im gonna assume that when the constructor is called, it compares the encounter with the winrate	
	enemyEncounter(int enc){
		encounter = enc;
		JOptionPane.showMessageDialog(null, "The two of you engage in battle!");
		if (encounter == 20) {
			JOptionPane.showMessageDialog(null, "You critted the enemy! \n You continue on your journey \nwith confidence");
		}
		else if(encounter < r) {
			JOptionPane.showMessageDialog(null, "You were slain.\n GAME OVER");
			String cont = JOptionPane.showInputDialog(null, "Would you like to start over?\n      Type yes or no.");
			
			if(cont.equalsIgnoreCase("yes")) {
				RPGame.beginJourney(); System.out.println("This is a new loop"); //This is just a reminder that the loop started over
			} else if (cont.equalsIgnoreCase("no")) {
				System.exit(0);
			} else {
					JOptionPane.showMessageDialog(null, "That is not correct input");
				} 
		} else if (encounter > r) {
			JOptionPane.showMessageDialog(null, "You defeated the enemy!");
		}
	}
}