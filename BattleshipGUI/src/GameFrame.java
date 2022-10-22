import java.awt.*;
import javax.swing.*;

/**
 * 
 * Represents the game screen
 *
 */
public class GameFrame extends JFrame {

	private JTextArea nameTxt;
	private JTextArea oppNameTxt;
	private JButton userBtns[];
	private JButton userStatBtns[];
	private GridBagConstraints gbc;
	private JFrame gameScreen;
	private PlayerBoard pBoard;

	public GameFrame(JFrame currScreen, String name) {
		
		gameScreen = currScreen;
		gameScreen.setTitle("Game");
		gameScreen.setSize(800, 900);
		gameScreen.getContentPane().setBackground(new Color(47, 69, 105));
		
		// display player grid
		pBoard = new PlayerBoard(gameScreen);
				
		// display player name
		displayPlayerName(name);
	}

	public void displayPlayerName(String pName) {
		JLabel name = new JLabel(pName);
		name.setVisible(true);
		
		// text color and font size
		name.setForeground(Color.white);
		name.setFont(new Font("Verdana", Font.PLAIN, 18));
		
		// position player name
		gameScreen.setLayout(new FlowLayout(FlowLayout.RIGHT, 125, 350));
		gameScreen.add(name);
	}
}
