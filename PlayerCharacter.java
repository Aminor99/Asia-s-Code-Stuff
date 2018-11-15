//made player character a thing? hopefully to fix up that nasty code

import javax.swing.JOptionPane;

public class PlayerCharacter {
	
	private static String playerName;
	private static int playerLevel, playerHP, playerAttack;
	
	//@param pN, the name that the user wants to name the character
	//@param pL, the level of the character
	//@param pHP, the amount of health points the character has
	//@param pA, the amount of damage the character does

	public PlayerCharacter(String pN, int pL, int pHP, int pA) {
		playerName = pN;
		playerLevel = pL;
		playerHP = pHP;
		playerAttack = pA;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String pN) {
		playerName = pN;
	}
	public int getPlayerLevel() {
		return playerLevel;
	}
	public void setPlayerLevel(int pL) {
		playerLevel = pL;
	}
	public int getPlayerHP() {
		return playerHP;
	}
	public void setPlayerHP(int pHP) {
		playerHP = pHP;
	}
	public int getPlayerAttack() {
		return playerAttack;
	}
	public void setPlayerAttack(int pA) {
		playerAttack = pA;
	}
	public static PlayerCharacter displayUserStats(PlayerCharacter userStats) {
		JOptionPane.showMessageDialog(null, "Name: " + playerName + "\nLevel: " + playerLevel + "\nHP: " + playerHP + "\nAttack: " + playerAttack);
		return userStats;
	}

}
