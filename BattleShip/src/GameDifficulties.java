import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//this class is meant to be used when the buttons on the main screen class/frame are pushed. This will set the number of ships and mines in the game board. 
public class GameDifficulties implements ActionListener {
	private int gameDiff;// in class instance of a variable

	public GameDifficulties(int diff) {// this method gets the game difficulty
		gameDiff = diff;// and sets the in class instance to that variable
	}

	// with the button chosen, this is what will happen when the button is
	// clicked
	public void actionPerformed(ActionEvent e) {
		switch (gameDiff) {// a switch to find the right difficulty
		case 1:

			MainScreen.getFrame().dispose();// close the frame of the mainScreen
			MainGame.startNewGame(20, 5);// sets the variables of the game room
			break;// breaks the switch
		case 2:

			MainScreen.getFrame().dispose();// close the frame of the mainScreen
			MainGame.startNewGame(10, 10);// sets the variables of the game room
			break;// breaks the switch

		case 3:

			MainScreen.getFrame().dispose();// close the frame of the mainScreen
			MainGame.startNewGame(5, 20);// sets the variables of the game room
			break;// breaks the switch
		default:// sets the game to easy
			MainScreen.getFrame().dispose();// close the frame of the mainScreen
			MainGame.startNewGame(20, 5);// sets the variables of the game room
			break;// breaks the switch
		}
	}

}
