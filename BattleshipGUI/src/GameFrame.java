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
	private JButton userStatBtns[];
	private JFrame gameScreen;
	private PlayerBoard pBoard;
	private OpponentsBoard oppBoard;
	private JPanel playerInfoSection;
	private JPanel gameWindow;

	public GameFrame(JFrame currScreen, String name) {
		
		gameScreen = currScreen;
		gameScreen.setTitle("Game");
		gameScreen.setSize(1000, 900);
		gameScreen.getContentPane().setBackground(new Color(47, 69, 105));
		
		// display opponent grid
		oppBoard = new OpponentsBoard(gameScreen);
		
		// display player name
		displayPlayerName(name, oppBoard.getGamePane());
		
		// display player grid
		pBoard = new PlayerBoard(gameScreen, oppBoard.getGamePane());
	}

	public void displayPlayerName(String pName, JPanel gamePane) {
		JLabel name = new JLabel("Player name: " + pName, JLabel.CENTER);
		name.setVisible(true);
		
		// text color and font size
		name.setForeground(Color.white);
		name.setFont(new Font("Verdana", Font.PLAIN, 18));
		
		// position player name
		gameWindow = gamePane;
		gameWindow.setPreferredSize(new Dimension(700, 700));
		gameWindow.setBackground(new Color(47, 69, 105));
		
		// add name to cell
		gameWindow.add(name);
		
		gameScreen.add(gameWindow);
		gameWindow.setVisible(true);
		gameScreen.setVisible(true);
	}
}
