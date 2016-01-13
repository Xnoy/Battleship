
//Cameron Padua
//CSS 161
//December 13 2015
//FInal Project
//THis class is meant to be the initializer for the other classes used. It also has methods built in for other classes to access variables in this class. 
//Assumptions:User is not trying to break game
//Notes: 2 player BattleShip seemed hard, so I built a cross between battleship and minesweeper. Now it is a one player bundle of fun.
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainGame {// this method is what starts the main screen which will
						// activate other parts of the game
	private static boolean[][] ships = new boolean[10][10];// declaring two
															// different 2d
															// arrays of
															// booleans to
															// represent ships
															// or mines
	private static boolean[][] mines = new boolean[10][10];
	private static Color[][] colorOfBoard = new Color[10][10];// 2d arrat of the
																// colors of the
																// board. for if
																// the player
																// loads the
																// game and I
																// need to reset
																// the board
	private static JFrame gameFrame;// Declare JFRame
	private static JPanel battlePanel;// Declare battle ships panel to be put in
										// frame
	private static JPanel panel;// another panel to be put in frame
	private static JButton bt,btSave;// declare a button for godmode/radar mode
	private static JButton[][] buttons = new JButton[10][10];// declaring a 2d
																// array of
																// buttons to
																// represent the
																// board

	public static void main(String[] args) {
		new MainScreen();// creates an instance of the main screen/title screen

	}

	public static JFrame getFrame() {// instead of MainGame.gameFrame, the
										// classes have to ask for the frame
		return gameFrame;// returns the game frame
	}

	public static JButton[][] getBoard() {// instead of the classes accessing
											// the board/buttons directly, they
											// have to as for it
		return buttons;// returns the board/buttons
	}

	public static Color[][] getBoardColor() {// instead of the classes accessing
												// the colors array directly,
												// they have to as for it
		return colorOfBoard;// return the colors array
	}

	public static boolean[][] getShips() {// returns the ship location boolean
											// array when called
		return ships;// returns ships
	}

	public static boolean[][] getMines() {// returns mine location array when
											// called
		return mines;// returns mines
	}

	public static void checkHit(int x, int y) {// this method check if the user
												// hit a ship, mine, or nothing
												// using data from buttons
		if (ships[y][x] == true) {// if there is a ship at these coordinates
			ships[y][x] = false;// set the boolean to false(so getships and
								// getarea is accurate)
			if (getShipsAlive() == false) {// if there is no ships
				JOptionPane.showMessageDialog(MainGame.getFrame(), "You win. Congrats");// they
																						// win
				System.exit(0);// exit the game
			}
			displayBoard.destroyedShip(x, y);// else call this method to change
												// board and prompt
			getArea(y, x);// get hints for the player

		} else if (mines[y][x] == true) {// if there is a mine
			JOptionPane.showMessageDialog(MainGame.getFrame(), "You hit A Mine");// prompts
																					// them
																					// of
																					// a
																					// mine
			JOptionPane.showMessageDialog(MainGame.getFrame(), "Game Over");// prompts
																			// them
																			// the
																			// game
																			// is
																			// over
			System.exit(0);// exit the game
		} else {// if there is no mine or ship...they missed
			displayBoard.missedShip(x, y);// call this method to change board
											// and prompt
			getArea(y, x);// get hints for player
		}
	}

	public static void startNewGame(int numShips, int numMines) {// this method is
																// used to start
																// a new game
		new intializeBoard(gameFrame, battlePanel, panel, bt, btSave, buttons, numShips, numMines);// pass
																							// in
																							// all
																							// necessary
																							// variables
																							// into
																							// class
																							// to
																							// start
	}
	public static void startOldGame() {//this moethod uses a different constructor in the intializeboard method. It requires to less parameters
		new intializeBoard(gameFrame, battlePanel, panel, bt, btSave, buttons);
	}

	private static void getArea(int row, int col) {// this method will prompt
													// the user if there is any
													// ships of mines in the
													// column or rows they are
													// in
		JOptionPane.showMessageDialog(MainGame.getFrame(),
				"There is/are " + getShipRow(row) + " ship(s) in that row and " + getShipCol(col)
						+ " ship(s) in that column. Also there is/are " + getMineRow(row) + " mine(s) in that row and "
						+ getMineCol(col) + " mine(s) in that column.)");// the
																			// prompt
																			// from
																			// a
																			// bad
																			// place
	}

	private static int getShipRow(int row) {// this method will return the
											// number of ships in the row given
		int count = 0;// count starts at zero
		for (int y = 0; y < ships.length; y++) {// y represents the place in the
												// row and ends at the end of
												// the row
			if (ships[row][y] == true) {// if there is a ship
				count++;// increase count
			}
		}

		return count;// return count
	}

	private static int getShipCol(int col) {// this will return the number of
											// ships in the given column
		int count = 0;// count starts at zero
		for (int y = 0; y < ships.length; y++) {// y represents the column
												// location and ends at the end
												// of the column
			if (ships[y][col] == true) {// if there is a ship in the column
				count++;// increase count
			}
		}

		return count;// returns the count
	}

	private static int getMineRow(int row) {// this method will return the mines
											// in the row given
		int count = 0;// count is started at zero
		for (int y = 0; y < mines.length; y++) {// y represents the place in the
												// row
			if (mines[row][y] == true) {// if there is a mine in the row
				count++;// increase count
			}
		}

		return count;// retrun count
	}

	private static int getMineCol(int col) {// this will return the mine count
											// in the given column
		int count = 0;// intialize and decalre count at zero
		for (int y = 0; y < mines.length; y++) {// y represents the column
												// location
			if (mines[y][col] == true) {// if there is a mine in the column
				count++;// increase count
			}
		}

		return count;// returns the count
	}

	public static boolean getShipsAlive() {// this method will return if there
											// is ships alive
		for (int y = 0; y < 10; y++) {// parse the columns
			for (int x = 0; x < 10; x++) {// parse the rows
				if (ships[y][x] == true) {// if there is a ship
					return true;// return true to say there is a ship alive
				}
			}
		}
		return false;// else all ships are destroyed
	}
	public static void LoadGame(){//this method will load the variables stored int the text files and set the 2d arrays to them
		try {//try catch to prevent file not found issues and game crashing
			Scanner colorLoad = new Scanner(new File("src/SaveGame/Color.txt"));//a scanner for each file that needs to be loaded
			Scanner shipsLoad = new Scanner(new File("src/SaveGame/Ships.txt"));
			Scanner minesLoad = new Scanner(new File("src/SaveGame/Mines.txt"));
			for (int y = 0; y < 10; y++) {//two for loops/nested loops to go through each 2d array
				for (int x = 0; x < 10; x++) {
					MainGame.getBoardColor()[y][x] = getColor(colorLoad.nextInt());//and set the variables found in the text files to the 2d array spots
					MainGame.getShips()[y][x] = shipsLoad.nextBoolean();
					MainGame.getMines()[y][x] =  minesLoad.nextBoolean();
				}
				
			}
			colorLoad.close();//close the scanner to save memory
			shipsLoad.close();
			minesLoad.close();
			JOptionPane.showMessageDialog(MainGame.getFrame(), "Game Loaded");//prompt user that the game was loaded
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch bloc
			e.printStackTrace();
		}

	}
	private static Color getColor(int in){//this method is a helper method to the load method. it is meant to take the integer color of a button and return the color
		switch(in){//using a switch statement check the integers and return the corresponding color
			case -16776961:
				return Color.BLUE;
			case -20561:
				return Color.PINK;
			case -16777216:
				return Color.BLACK;
			default://to avoid godmode colors, I will set anything that is not above to blue
				return Color.BLUE;
		}
		
	}

	}

