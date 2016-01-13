import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//this class is to set up the main screen for the player that has the difficulty and title page. It has the instructions for the game as well as goals.
public class MainScreen {
	public static JFrame startFrame;
	private JPanel mainPanel, TitlePanel;
	private JLabel title;
	private JButton easyBt, medBt, hardBt, loadBt;
	private ImageIcon image;
	private JLabel label;

	public MainScreen() {//constructor to start main game
		startScreen();
	}

	private void startScreen() {
		startFrame = new JFrame("The Hunt for Battleships");// create the
															// JFrame, the
															// window.

		startFrame.setSize(600, 400);// set the size of the Window
		startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Allows the
																	// window to
		// close
		titleSetUp();//sets up the title jlabel
		buttonSetUp();//sets up the difficulty buttons
		imageSetUp();//sets up the image
		mainPanel = new JPanel();// create a instance of the frame that
		// objects be put
		mainPanel.setBackground(Color.LIGHT_GRAY);//colors the panel
		JLabel word = new JLabel("Difficulty: ");//creates a new label
		word.setFont(new Font("Serif", Font.PLAIN, 20));//sets the label's font and and size
		mainPanel.add(word);//adds the word to the panel
		mainPanel.add(easyBt);//adds the buttons to the panel 
		mainPanel.add(medBt);
		mainPanel.add(hardBt);
		mainPanel.add(loadBt);
		
		startFrame.add(label, BorderLayout.SOUTH);//Set the location of the picture to the bottom
		startFrame.add(mainPanel, BorderLayout.CENTER);//puts the main panel in the middle 
		startFrame.add(TitlePanel, BorderLayout.NORTH);//puts the title panel in the bottom

		startFrame.setVisible(true);//make the frame visible
		JOptionPane.showMessageDialog(MainGame.getFrame(),
				"Welcome to The Hunt for the BattleShips.\n This game is a cross between the two player board game Battleship and the computer game Minesweeper. As you can imagine, your goal is too destroy all \nthe battleships on the field and avoid the mines scattered across the field. If you hit a mine, game over. If you destroy all the ships, you win. The harder \nthe game mode, the more mines and less ships there are. Please not that there is a save game button and Radar mode(cheat mode) for your convience. \nHave Fun....");
				//prompts the user of the game and the goals
	}

	private void imageSetUp() {//this method sets up the image 
		image = new ImageIcon("src/resources/sinkShip.png");//makes and gets a icon
		label = new JLabel("", image, JLabel.CENTER);//make the jlabel into an image

	}

	private void buttonSetUp() {//this method sets up the buttons 
		easyBt = new JButton("Easy");// the easy button
		medBt = new JButton("Medium");//the medium
		hardBt = new JButton("Hard");// the hard button 
		loadBt = new JButton("Load Game");
		loadBt.addActionListener(new GameLoader());//adds an action listener to the load button which calls the class 
		
		easyBt.addActionListener(new GameDifficulties(1));//adds a listener to each button with a difficulty mode
		medBt.addActionListener(new GameDifficulties(2));
		hardBt.addActionListener(new GameDifficulties(3));
	}

	private void titleSetUp() {//this method sets up the title 
		title = new JLabel("The Hunt For the Battleships");// jlabel with a title
		Font titleFont = new Font("Serif", Font.BOLD, 40);//sets the font, size, and how it looks
		title.setFont(titleFont);//set the font to the label
		title.setForeground(Color.WHITE);//set the color of the label 

		TitlePanel = new JPanel();// create a instance of the frame that
		// objects be put
		TitlePanel.setBackground(Color.DARK_GRAY);//makes the back of the panel dark grey 
		TitlePanel.add(title);//adds the title to the panel
	}

	public static JFrame getFrame() {//mean to get the fram for other classes to access 
		return startFrame;//returns the frame.
	}

}
