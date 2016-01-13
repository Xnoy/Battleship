import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//this class is where the magic happens, it uses the latest technology and sets up the board. Coming with two constructors, this class can start a new board or use data from an old board and recreate it.
public class intializeBoard {
	private static int numOfShips, numOfMines;// global ints in this class

	public intializeBoard(JFrame f, JPanel battlePanel, JPanel panel, JButton bt, JButton btSave, JButton[][] buttons,
			int numShips, int numMines) {// contructor number one is meant to
											// start a brand new game. it has an
											// additional two parameters and
											// three extra method calls to
											// create the board
		numOfShips = numShips;// sets the global vairbles to the passed in
								// variables from the difficulity setting class
		numOfMines = numMines;
		initShips();// creates random boolean placement for the ships on the
					// board
		initMines();// creates random boolean placement for the mines on the
					// board
		initColor();// color the buttons/board for the user to see
		startGame(f, battlePanel, panel, bt, btSave, buttons);// starts the main
																// method for
																// the board
																// creation
	}

	public intializeBoard(JFrame f, JPanel battlePanel, JPanel panel, JButton bt, JButton btSave, JButton[][] buttons) {
		// this constructor is meant to be called when the color, ships, and mines data is already in existence. SO essentially when they
		// load the game.
		startGame(f, battlePanel, panel, bt, btSave, buttons);// starts the same
																// main method
																// to display
																// the board
	}

	private void startGame(JFrame f, JPanel battlePanel, JPanel panel, JButton bt, JButton btSave,
			JButton[][] buttons) {// this method is meant to set up the visible
									// board for the user
		f = new JFrame("BattleShip");// create the JFrame, the window.

		f.setSize(600, 400);// set the size of the Window
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Allows the window to
															// close

		battlePanel = new JPanel();// create a instance of the frame that
									// objects be put
		// on
		panel = new JPanel();// creates a panel for the buttons to be on

		battlePanel.setBackground(Color.WHITE);// set the color of the frame

		bt = new JButton("Radar Mode");// Creates the radar button with text
		RadarListener godmode = new RadarListener();// creates an instance of
													// the radar listenr
		bt.addActionListener(godmode);// adds the instance to the button

		btSave = new JButton("Save Game");// Create a button for the save button
		SaveGameListener SaveGame = new SaveGameListener();// creates a listner
															// for the save game
															// button
		btSave.addActionListener(SaveGame);// adds it to the button

		battlePanel.setLayout(new GridLayout(10, 10));// sets the layout of the
														// battlePanel for the
														// buttons

		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 10; x++) {
				buttons[y][x] = new JButton();
				buttons[y][x].addActionListener(new CoordinatesListener(x, y));
				battlePanel.add(buttons[y][x]);
				buttons[y][x].setBackground(MainGame.getBoardColor()[y][x]);

			}
		}

		panel.add(bt);
		panel.add(btSave);

		f.add(panel, BorderLayout.NORTH);
		f.add(battlePanel, BorderLayout.CENTER);// add the frame to the window

		f.setVisible(true);// set the window to visible

	}

	public static void changeColor(int x, int y, Color color) {//gets the x and y coordinates when called along with a color
		if (MainGame.getBoard()[y][x].getBackground() == Color.BLUE
				|| MainGame.getBoard()[y][x].getBackground() == Color.GREEN) {//if the button has not been pressed, 
			MainGame.getBoard()[y][x].setBackground(color);//change the color to the user decided color
		}
	}

	public static void initShips() {
		Random random = new Random();//a random generator of numbers

		for (int ship = 0; ship < numOfShips; ship++) {//based on the difficulty, the number of times this will loop to add a ship
			int y = random.nextInt(10);//gets a random coordinate from 1-10
			int x = random.nextInt(10);//gets a random coordinate from 1-10
			while (MainGame.getShips()[y][x] == true) {//if there is a ship there already
				y = random.nextInt(10);//get new coordinates
				x = random.nextInt(10);
			}
			MainGame.getShips()[y][x] = true;//set the location based on the coordinates to true to represent the location of the ship

		}
	}

	public static void initColor() {//this sets the entire board to blue buttons
		for (int y = 0; y < 10; y++) {//go through the entire board
			for (int x = 0; x < 10; x++) {
				MainGame.getBoardColor()[y][x] = Color.BLUE;//get the color 2d array and sets it to blue 
			}
		}
	}

	public static void initMines() {
		Random random = new Random();//similar to the ships initializer

		for (int mine = 0; mine < numOfMines; mine++) {//based on the difficulty, the number of times this will loop to add a mine
			int y = random.nextInt(10);//gets a random coordinate from 1-10
			int x = random.nextInt(10);//gets a random coordinate from 1-10
			while (MainGame.getShips()[y][x] == true || MainGame.getMines()[y][x] == true) {//if there is a ship or mine already there
				y = random.nextInt(10);//get new coordinates
				x = random.nextInt(10);
			}
			MainGame.getMines()[y][x] = true;//set the location based on the coordinates to true to represent the location of the mine

		}

		
	}

}
