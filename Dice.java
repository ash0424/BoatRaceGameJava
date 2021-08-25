package boatgame;

import java.util.Random;
import java.util.Scanner;

public class Dice {

	private int diceNum;
	private String roll;
	
	Scanner input = new Scanner(System.in);
	
	public Dice () {
		diceNum = 0;
	}
	
	public Dice(String r) {
		roll = r;
	}
	
	public void throwDice() {
		
		System.out.print("Enter '0' to roll the dice: ");
		roll = input.nextLine();
	
			if (roll.equals("0")) {
				diceNum = 1 + new Random().nextInt(6);
				setDiceNum(diceNum);
			}

			else {
				System.out.println("\nInvalid input!"); 
				System.out.println("\nEnter '0' to roll the dice again:");
				roll = input.nextLine();
				
				if (roll.equals("0")) {
					diceNum = 1 + new Random().nextInt(6);
					setDiceNum(diceNum);
				}
			}
			
		}

	public int getDiceNum() {
		return diceNum;
	}

	public void setDiceNum(int diceNum) {
		this.diceNum = diceNum;
	}
	
}
