//Some stupid inventory system thing

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Random;

public class InventoryTest {

//private static String inputSwordName;
//private static ArrayList<Sword> inventory = new ArrayList();

	//MAIN METHOD OF INVENTORYTEST CLASS
	public static void main(String[] args) {
		String cont;
		do {
		Sword.nameSword(); 
		
		Sword.openSwordInventory(); 
		
		cont = JOptionPane.showInputDialog(null, "Wanna keep naming swords?");
		
		} while (cont.equalsIgnoreCase("yes"));
		
		if (cont.equalsIgnoreCase("no")) {
			JOptionPane.showMessageDialog(null, "Thanks for hanging around");
			System.exit(0);
	  } 
	}

}
//the class that has all the sword stuff
//move the adding of items to the inventory somewhere else
class Sword{
	private static ArrayList<Sword> inventory = new ArrayList();
	private static String name, rarity;
	private static int strength;
	private static Sword s1;
	//constructor for sword
	Sword(String n, int str, String rar){
		name = n;
		strength = str;
		rarity = rar;
	}
	public static void addToInventory() {
		inventory.add(s1);
	}
	public static void removeFromInventory() {
		inventory.remove(s1);
	}
//allows user to name their sword. rarity and strength will be randomly generated in the future	
	public static void nameSword() {
	    String inputSwordName;
		inputSwordName = JOptionPane.showInputDialog(null, "Name this sword.");
		Sword s1 = new Sword(inputSwordName, 10, "rare");
		
		String keep = JOptionPane.showInputDialog(null, "Do you wanna keep this sword?");
		if (keep.equalsIgnoreCase("yes")) {
			addToInventory();
		} else if (keep.equalsIgnoreCase("no")) {
			removeFromInventory();
		}
	}
//this should display the swords attributes?
	//@param accepts value of type sword @return value of type sword >:U
	public static Sword displayAttributes(Sword s) {
		JOptionPane.showMessageDialog(null, "This sword's attributes are: \n Name: " + name +"\n Strength: " + strength + "\n Rarity: " + rarity);
		return s;
	}
//This should ask the user if they wanna open the darn inventory or not	
	public static void openSwordInventory() {
		String O = JOptionPane.showInputDialog(null, "Open your inventory? ");
		if (O.equalsIgnoreCase("yes")) {
			for(int i = 0; i<inventory.size(); ++i) {
			String whatSword = JOptionPane.showInputDialog(null, "Which sword do you wanna pick?\n" + inventory.get(i).name);
			//for(int i = 0; i<inventory.size() ;++i) {
				if(whatSword.equalsIgnoreCase(Sword.name)) {
					displayAttributes(inventory.get(i));
				}
			}
		}
		if(O.equalsIgnoreCase("no")) {
			JOptionPane.showMessageDialog(null, "Thanks for hanging around ;)");
			System.exit(0);
	  } 
	}
}
