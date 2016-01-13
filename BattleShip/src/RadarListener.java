import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//if this button is pushed, activate a method in the displayboard class.
public class RadarListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
		displayBoard.godMode();//calls the method in this class if the button is pushed to activate this event
	}
}
