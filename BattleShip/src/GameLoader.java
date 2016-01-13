
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//this class is a helper class to the actionlistener buttons in the game

public class GameLoader implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {//this method activates when this button is clicked to activate this class.
		MainScreen.getFrame().dispose();// close the frame of the mainScreen
		MainGame.LoadGame();//calls method in MainGame to set the board conditions of the save Game
		MainGame.startOldGame();//a custom initializer for an old save game
	}
}