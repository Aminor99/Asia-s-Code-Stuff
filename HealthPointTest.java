//Im hoping to do some cool stuff with hp
//make attacks randomly generated DONE
//make enemy attacks randomly generated
//use loop  to go through the potions KINDA DONE?
//implement exp system later, it will increase your attack and your hp or something
//might make the users fighter an object,,, i should right? would that make things easier?
//This code is a mess,,,, i need to clean this up somehow??? I REALLY GOTTA CLEAN THIS MESS UP
//All the system.out.println's are to keep a log og all the actions going on

import javax.swing.JOptionPane;
import java.util.Random;

public class HealthPointTest {
	
	public static int userHP, userEXP, userLVL;
	private static String fullName, inputName;
	
	//so i can get the variable userHP and change it whenever called, i never used a setter before? ope this works
		//static public int setUserHP(int UserHP) {
			//return userHP;
		//}
		static public int getUserExp() {
			return userEXP;
		}
		static public int setUserEXP(int UserEXP) {
			return userEXP;
		}

//THIS IS THE M A I N M E T H O D
	public static void main(String [] args) {
		
		Name();
		
		String ready = JOptionPane.showInputDialog(null, "you are about to fight some random enemies, is that cool?");
		if (ready.equalsIgnoreCase("yes")) {
			letTheFightBegin();
		} else if (ready.equalsIgnoreCase("no")) {
			JOptionPane.showMessageDialog(null, "'Aww, What a bummer. See ya later!");
			System.exit(0);
		}
		
	}
//allows user to name their fighter. initializes fighters hp	
	public static void Name() {
			Random ranTitle = new Random();
			int titleNum = ranTitle.nextInt(16);
			
			inputName = JOptionPane.showInputDialog(null, "Hello, fighter! Today is the day you will\n  begin your fighting journey! What is \n              your fighter's name?");
			String titles[] = {" the Brave", " the Mighty", " the Village Hero", " protector of the Meek", " the Faithful", " the Scourge", " the Hidden", " the Shadow Lurker",
					" the Healer", " the Supporter", " the Calm", " the Brash", " the Agile", " the Blade Dancer", " the Legendary", " the Great", " the Enlightened"}; //17 elements
			fullName = inputName + titles[titleNum];
			JOptionPane.showMessageDialog(null, fullName + ", this is the start of your fight!");
			
			userHP = 750;
			userEXP = 0;
			userLVL = 1;
	}
//calls the random enemy generator from the enemy class	if the user says they're ready
	public static void letTheFightBegin() {
		
		String accept = JOptionPane.showInputDialog(null, "          The fight will begin!\n       Are you ready?");
		
		if (accept.equalsIgnoreCase("yes")) {
			Enemy.randomEnemyGenerator();
		} else if (accept.equalsIgnoreCase("no")) {
			JOptionPane.showMessageDialog(null, "alright coward >:U");
			System.exit(0);
		}
		do {
			userHP = Enemy.attack(userHP); //This needs to be looped,,, the enemy attacking the user
			Enemy.userAttack(); //The user attacking the enemy
		} while (userHP > 0);// && chosenEnemy.HP >= 0);  
		
		//if (chosenEnemy.HP == 0) {// && chosenEnemy.HP < 0) {
			//JOptionPane.showMessageDialog(null, "You defeated the enemy!");
		
		JOptionPane.showMessageDialog(null,"You now have " + userHP + " health!");
	}
//this method is just to get the userHP	and to change it to the new hp after the user takes a potion
	public static void getPotion() {
		userHP = Potions.drinkPotion(userHP);
	}
//calls exp from enemy class
	public static void getEXP() {
		userEXP = Enemy.EXP(userEXP);
	}
//levels up the user	
	public static void levelUP() {
		if(userEXP <= 10) {
			getLevel();
		} else if (userEXP <= 25) {
			getLevel();
		} else if (userEXP <= 50) {
			getLevel();
		} else if (userEXP <= 100) {
			getLevel();
		} else if (userEXP <= 150) {
			getLevel();
		} else if (userEXP <= 200) {
			getLevel();
		} else if (userEXP <= 250) {
			getLevel();
		} else if (userEXP <= 300) {
			getLevel();
		} else if (userEXP <= 350) {
			getLevel();
		} 

	}
//calls level from enemy class and adds when user gets enough exp	
	public static void getLevel() {
		userLVL = Enemy.LVL(userLVL);
	}

}

class Enemy{
	
	private int HP; //I had problems when i made them static ? I think its because i was the attributes were being used elsewhere?
	private String name;
	private int attack;
	private int exp;
	
	private static Enemy chosenEnemy;
	private static int uexp = HealthPointTest.getUserExp();  //uexp means user exp 
	
	//static int ehp = Enemy.getUserHP();
	//static int uhp = HealthPointTest.getUserHP(); //taking the userHP variable from the HealthPointTest class,,, i was trying something
	
	Enemy(int h, String n, int a, int e){
		HP = h;
		name = n;
		attack = a;
		exp = e;
	}
	//idk, im making some enemies with some attributes :O ,,,, i should move these somewhere else
	static Enemy Goblin = new Enemy(20, "Goblin", 23, 5);
	static Enemy Goomba = new Enemy(20, "Goomba", 27, 5);
	static Enemy Saber_Tooth_Tiger = new Enemy(50, "Saber Tooth Tiger", 45, 15);
	static Enemy Dragon = new Enemy(200, "Dragon", 175, 50);
	static Enemy Slime = new Enemy(10, "Slime", 5, 2);
	static Enemy Skeleton = new Enemy(15, "Skeleton", 20, 5);
	static Enemy Ogre = new Enemy(150,"Ogre",125, 35);
	static Enemy Werewolf = new Enemy(75, "Werewolf", 100, 20);
	static Enemy Zombie = new Enemy (35, "Zombie", 26, 10);
	static Enemy Siren = new Enemy(50, "Siren", 43, 20);
	static Enemy Yeti = new Enemy(165,"Yeti", 78, 25);
	static Enemy Bear = new Enemy(60,"Bear", 56, 20);
	static Enemy Giant_Spider = new Enemy(65, "Giant Spider", 67, 20);
	static Enemy Puzzlux = new Enemy(65,"Puzzlux", 66, 20);
	static Enemy Lockjaw = new Enemy(110,"Lockjaw", 155, 35);
	static Enemy Rockner = new Enemy(300, "Rockner", 180, 80);
	
	public static void randomEnemyGenerator() {
		
			Random ranEnemy = new Random();
			int randomEnemyNum = ranEnemy.nextInt(15);
		
			Enemy enemyArray[] = {Goblin, Goomba, Saber_Tooth_Tiger, Dragon, Slime, Skeleton, Ogre, Werewolf, Zombie, Siren, Yeti, Bear, Giant_Spider, Puzzlux, Lockjaw, Rockner};
		
			chosenEnemy = enemyArray[randomEnemyNum];
			
			JOptionPane.showMessageDialog(null, "You will be fighting a " + chosenEnemy.name + "."); System.out.println("The enemy has " + chosenEnemy.HP + " hp.");
		
			if (chosenEnemy.HP == 0 || chosenEnemy.HP < 0) {
				JOptionPane.showMessageDialog(null, "You defeated the enemy!");
			}
		
		}
//@param accepts the users health at a given time and returns it	
	public static int attack(int hp) {
			System.out.println("You had " + hp + " hp");//to see hp at the start of the fight
		int at = chosenEnemy.attack; //at stands for attack
		JOptionPane.showMessageDialog(null, "You took " + at + " damage!"); 
		hp = hp - at;
			System.out.println("You now have " + hp + " hp");
			
		if(hp == 0 || hp < 0) {
			JOptionPane.showMessageDialog(null,"You were slain!  \n GAME OVER");
			System.exit(0);
		}
		return hp;
	}
//I wanted this method to be somewhere else,,,,
//this method allows the user to deal a random amount of damage to the enemy
	public static void userAttack(){
		
		Random ranDamage = new Random();
		int damageDealt = ranDamage.nextInt(19) + 7; 
		JOptionPane.showMessageDialog(null, "You dealt " + damageDealt + " damage!");
		
		chosenEnemy.HP = chosenEnemy.HP - damageDealt; System.out.println("The enemy now has " + chosenEnemy.HP + " hp.");
		
		if (chosenEnemy.HP == 0 || chosenEnemy.HP < 0) {
			JOptionPane.showMessageDialog(null, "The enemy was defeated!");
			HealthPointTest.getEXP();
			HealthPointTest.levelUP();
			String takePotion = JOptionPane.showInputDialog(null, "Do you want to take a potion?");
				if (takePotion.equalsIgnoreCase("yes")) {
					HealthPointTest.getPotion();
				}
				
			String continueFighting = JOptionPane.showInputDialog(null, "Do you wanna keep fighting?");
			if (continueFighting.equalsIgnoreCase("yes")) {
				HealthPointTest.letTheFightBegin();
			} else if (continueFighting.equalsIgnoreCase("no")) {
				JOptionPane.showMessageDialog(null,  "The fight ends here. \nThanks for playing!");
				System.exit(0);
			}
		}
	}
	///EXO THING NEEDS TO BE FIXED
	public static int EXP(int xp) {
		
		int eexp = chosenEnemy.exp; //eexp means enemy exp
		JOptionPane.showMessageDialog(null, "You gained " + eexp + " exp!"); System.out.println("You got " + eexp + " exp.");
		int totalEXP = eexp + xp; 
	
		JOptionPane.showMessageDialog(null, "You now have " + totalEXP + " exp!"); System.out.println("You now have " + totalEXP + " exp.");
		xp = totalEXP;
		
		return xp;
	}
	//eh i dont remember why i put this down here?
	public static int LVL(int lvl) {
		System.out.println("You were level " + lvl + ".");
		lvl++;
		JOptionPane.showMessageDialog(null, "You are now a level " + lvl + "."); System.out.println("You are now level " + lvl + ".");
		return lvl;
	}
			
}

//increases user hp when called,,,
class Potions{
	
	private String potionName;
	private int healthRestored;
	
	Potions(String pN, int hR){
		potionName = pN;
		healthRestored = hR;
	}
	//different types of potions
	static Potions Half_Drank_Potion = new Potions("Half Drank Potion", 20);
	static Potions Potion = new Potions("Potion", 75);
	static Potions Great_Potion = new Potions("Great Potion", 175);
	static Potions Greater_Potion = new Potions("Greater Potion", 400);
	static Potions Panacea = new Potions("Panacea", 1000);
	
	//@param, takes the amount of hp the has. hopefully? @return the new amount of hp the user has
	public static int drinkPotion(int hp) {
		
		Random ranPotion = new Random();
		int randomPotionNum = ranPotion.nextInt(4);
		
		Potions potionArray[] = {Half_Drank_Potion, Potion, Great_Potion, Greater_Potion, Panacea};
		
		Potions chosenPotion = potionArray[randomPotionNum];
		
		int rh = chosenPotion.healthRestored; //rh stands for restored health
		hp = hp+rh;
		
		JOptionPane.showMessageDialog(null, "You used a " + chosenPotion.potionName + ".\nYou know have " + hp + " hp!"); System.out.println("You gained " + chosenPotion.healthRestored);
		
		return hp;
	}
}
