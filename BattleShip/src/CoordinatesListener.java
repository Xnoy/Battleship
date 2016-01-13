import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//this method is used for return the coordinates of the button the user clicked. it implements the ActionListener and passes the varibles to the check hit method in the maingame class
public class CoordinatesListener implements ActionListener {
	private int x;// variable only accessable in the instance of this class
	private int y;// variable only accessable in the instance of this class

	public CoordinatesListener(int _x, int _y) {
		x = _x;// sets the x coordinate to the x passed in from the
				// intialization
		y = _y;// sets the y coordinate to the x passed in from the
				// intialization
	}

	public void actionPerformed(ActionEvent e) {
		MainGame.checkHit(x, y);// calls the method in the main game class to
								// pass variables of the button the user chose
								// and check if it was a hit.
	}
}
