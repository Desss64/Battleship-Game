import java.awt.*;
import javax.swing.*;

/**
 * 
 * Displays the player's own board
 *
 */
public class PlayerBoard extends Board {

	private Board playerBoard;
	private JPanel buttonPanel;
	private JButton userBtns[][];
	private JFrame gameScreen;

	public PlayerBoard(JFrame currScreen) {

		// make current screen the game screen
		gameScreen = currScreen;

		// create and draw player's board
		playerBoard = new Board();
		draw();
	}

	// draw player's board
	public void draw() {

		buttonPanel = new JPanel();
		// buttonPanel.setBackground(new Color(47, 69, 105));
		buttonPanel.setLayout(new GridLayout(boardArray.length + 1, boardArray.length));
		userBtns = new JButton[boardArray.length][boardArray.length];

		// top coordinate labels
		for (int i = 1; i <= 8; i++)
			buttonPanel.add(new JLabel(Integer.toString(i), JLabel.CENTER));
		
		// loop through boardArray creating jbutton for each cell
		for (int i = 0; i < boardArray.length; i++) {
			
			for (int j = 0; j < boardArray.length; j++) {
				userBtns[i][j] = new JButton();
				userBtns[i][j].setPreferredSize(new Dimension(50, 50));
				userBtns[i][j].setBackground(Color.white);
				buttonPanel.add(userBtns[i][j]);
			}
		}

		gameScreen.setLayout(new FlowLayout(FlowLayout.LEFT, 150, 30));
		gameScreen.add(buttonPanel);
		gameScreen.setVisible(true);
	}
}
