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
	private GridBagConstraints gbc;
	private String[] gridLetters = { "A", "B", "C", "D", "E", "F", "G", "H" };
	private JLabel topCoordinateLabel;
	private JLabel sideCoordinateLabel;

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
		buttonPanel.setLayout(new GridBagLayout());
		buttonPanel.setBackground(new Color(47, 69, 105));
		gbc = new GridBagConstraints();
		userBtns = new JButton[boardArray.length][boardArray.length];

		// top coordinate labels
		for (int i = 0; i < boardArray.length; i++) {
			gbc.gridx = i + 1;
			gbc.gridy = 0;
			
			topCoordinateLabel = new JLabel(Integer.toString(i + 1), JLabel.CENTER);
			topCoordinateLabel.setPreferredSize(new Dimension(25, 25));
			topCoordinateLabel.setForeground(Color.white);
			
			buttonPanel.add(topCoordinateLabel, gbc);
		}

		// loop through boardArray creating jbutton for each cell
		for (int i = 0; i < boardArray.length; i++) {
			for (int j = 0; j < boardArray.length; j++) {
				gbc.gridx = i + 1;
				gbc.gridy = j + 1;
				userBtns[i][j] = new JButton();
				userBtns[i][j].setPreferredSize(new Dimension(50, 50));
				userBtns[i][j].setBackground(Color.white);
				buttonPanel.add(userBtns[i][j], gbc);
			}
		}

		// side coordinate labels
		for (int i = 0; i < boardArray.length; i++) {
			gbc.gridx = 0;
			gbc.gridy = i + 1;
			
			sideCoordinateLabel = new JLabel(gridLetters[i], JLabel.CENTER);
			sideCoordinateLabel.setPreferredSize(new Dimension(25, 25));
			sideCoordinateLabel.setForeground(Color.white);
			
			buttonPanel.add(sideCoordinateLabel, gbc);
		}

		gameScreen.setLayout(new FlowLayout(FlowLayout.LEFT, 150, 30));
		gameScreen.add(buttonPanel);
		gameScreen.setVisible(true);
	}
}
