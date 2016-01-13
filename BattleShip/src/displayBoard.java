import java.awt.Color;

import javax.swing.JOptionPane;
//this class is meant to edit the existing board for the user to see. It holds the godemode method and destroyed and missed ship methods
public class displayBoard {

	public static void godMode() {//this method will change the boards color to represent either a mine or ship
		for (int y = 0; y < 10; y++) {//parse through a 10 by 10 array 
			for (int x = 0; x < 10; x++) {
				if (MainGame.getShips()[y][x] == true) {//if there is a ship at this location in the the board
					intializeBoard.changeColor(x, y, Color.GREEN);//change the color by calling this method and passing these parameters if it is a ship
				}
				if (MainGame.getMines()[y][x] == true) {
					intializeBoard.changeColor(x, y, Color.RED);//change the color by calling this method and passing these parameters if it is a mine
				}
			}
		}
		JOptionPane.showMessageDialog(MainGame.getFrame(),
				"In Radar Mode (aka Cheat mode), the player can see the mines and ships in the battlefield. This feature was meant to be a debug mode for the deveolper,\n but I have a soul and do no not want the grader to pull out their hair trying to play this game. (Once activated, it will not turn off. You can save and load \nthe game to get back to normal mode if you wish)"
						+ "\n\nGreen==Ship\n\nRed==Mine");//prompts the user of what this mode does and how to get out of it
	}

	public static void destroyedShip(int x, int y) {//when this method is called, it will change the color of the board and prompt the user
		intializeBoard.changeColor(x, y, Color.BLACK);//change the color of the board that the user sees 
		MainGame.getBoardColor()[y][x] = Color.BLACK;//behind the scenes color change of the 2d array color board
		JOptionPane.showMessageDialog(MainGame.getFrame(), "Ship Destroyed");//prompts the user of a destroyed ship
	}

	public static void missedShip(int x, int y) {//when this method is called, the user missed the ships and it will change the color of the button
		intializeBoard.changeColor(x, y, Color.PINK);//changes the visible board 
		MainGame.getBoardColor()[y][x] = Color.PINK;//changes the behind the scene board
		JOptionPane.showMessageDialog(MainGame.getFrame(), "You Missed");//prompts the user of their miss
	}
}
