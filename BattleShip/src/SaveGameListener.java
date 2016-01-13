import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class SaveGameListener implements ActionListener {
	// this method/class activated when the save button is clicked and will
	// create files to be saved for the next game
	public void actionPerformed(ActionEvent e) {
		try {//trys to open files or catches the error otherwise
			PrintWriter outColor = new PrintWriter(new FileOutputStream("src/SaveGame/Color.txt"));// these
																									// printwriter
																									// will
																									// create
																									// the
																									// file
																									// if
																									// not
																									// found
																									// and
																									// store
																									// the
																									// respected
																									// varaibles
																									// needed
																									// to
																									// load
																									// the
																									// game
																									// next
																									// time
			PrintWriter outShips = new PrintWriter(new FileOutputStream("src/SaveGame/Ships.txt"));
			PrintWriter outMines = new PrintWriter(new FileOutputStream("src/SaveGame/Mines.txt"));

			for (int y = 0; y < 10; y++) {//parse through a 2d array of a 10 by 10 size
				for (int x = 0; x < 10; x++) {
					outColor.println(String.valueOf(MainGame.getBoardColor()[y][x].getRGB()));//stores the color in a file
					outShips.println(MainGame.getShips()[y][x]);//stores the boolean value of ships in a file
					outMines.println(MainGame.getMines()[y][x]);//store the boolean values of mines in a file
				}
			}
			outColor.close();//close all the files
			outShips.close();
			outMines.close();
			JOptionPane.showMessageDialog(MainGame.getFrame(), "Game Saved");//prompt the user if the game was saved.
			System.exit(0);//exits the game
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
