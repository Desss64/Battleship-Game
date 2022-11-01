package View;
import java.awt.*;
import javax.swing.*;
import model.Player;

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
	private OpponentsBoardView oppBoard;
	private JPanel playerInfoSection;
	private JPanel gameWindow;
	private JPanel contentPane = new JPanel();

	public GameFrame(JFrame currScreen, Player player) {
		
		gameScreen = currScreen;
		gameScreen.setTitle("Game");
		gameScreen.setSize(800, 800);
		gameScreen.getContentPane().setBackground(new Color(47, 69, 105));
		
		// pane to hold various game components
		JPanel gamePane = new JPanel();
		gamePane.setLayout(new GridLayout(2, 2, 5, 5));
		gamePane.setPreferredSize(new Dimension(630, 680));
		
		// display player grid
		pBoard = new PlayerBoard(gameScreen, gamePane);
		
		// display player name 
		JPanel playerInfoPane = new JPanel();
		playerInfoPane.setLayout(new GridLayout(3,1));
		displayPlayerName(player.getName(), playerInfoPane);
		gamePane.add(playerInfoPane);
		
		// display player ships
		playerInfoPane.add(new JLabel("Ships"));
		showShips(player);
		
		gamePane.add(new JLabel("PlaceHolder"));
		gamePane.add(new JLabel("PlaceHolder"));
		
		// display opponent grid
		/*oppBoard = new OpponentsBoard(gameScreen);*/
		
		// display player grid
		//pBoard = new PlayerBoard(gameScreen, oppBoard.getGamePane());
		
		gameScreen.getContentPane().add(gamePane);
		gameScreen.setVisible(true);
	}

	public void displayPlayerName(String pName, JPanel playerInfoPane) {
		JLabel name = new JLabel("Player name: " + pName, JLabel.CENTER);
		name.setVisible(true);
		
		// text color and font size
		name.setForeground(Color.white);
		name.setFont(new Font("Verdana", Font.PLAIN, 18));
		
		// add name to cell
		playerInfoPane.add(name);
	}
	
	public void showShips(Player p) {
		// paint image for each ship
	}
}
