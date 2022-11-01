package View;
import java.awt.*;
import javax.swing.*;

import model.Board;

/**
 * 
 * Displays the player's own board
 *
 */
public class PlayerBoard extends Board {

	private JPanel buttonPanel;
	private JPanel contentPane;
	private JButton userBtns[][];
	private JFrame gameScreen;
	private GridBagConstraints gbc;
	private String[] gridLetters = { "A", "B", "C", "D", "E", "F", "G", "H" };
	private JLabel topCoordinateLabel;
	private JLabel sideCoordinateLabel;
	private int boardSize;

	public PlayerBoard(JFrame currScreen, JPanel gamePane) {

		// make current screen the game screen
		gameScreen = currScreen;

		// create and draw player's board
		drawPlayerBoard(gamePane);
	}

	// draw player's board
	public void drawPlayerBoard(JPanel gamePane) {
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridBagLayout());
		buttonPanel.setBackground(new Color(47, 69, 105));

		gbc = new GridBagConstraints();
		boardSize = getSize();
		userBtns = new JButton[boardSize][boardSize];

		// top coordinate labels
		for (int i = 0; i < boardSize; i++) {
			gbc.gridx = i + 1;
			gbc.gridy = 0;

			topCoordinateLabel = new JLabel(Integer.toString(i + 1), JLabel.CENTER);
			topCoordinateLabel.setPreferredSize(new Dimension(12, 12));
			topCoordinateLabel.setForeground(Color.white);

			buttonPanel.add(topCoordinateLabel, gbc);
		}

		// loop through boardArray creating jbutton for each cell
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				gbc.gridx = i + 1;
				gbc.gridy = j + 1;
				userBtns[i][j] = new JButton();
				userBtns[i][j].setPreferredSize(new Dimension(40, 40));
				userBtns[i][j].setBackground(Color.white);
				buttonPanel.add(userBtns[i][j], gbc);
			}
		}

		// side coordinate labels
		for (int i = 0; i < boardSize; i++) {
			gbc.gridx = 0;
			gbc.gridy = i + 1;

			sideCoordinateLabel = new JLabel(gridLetters[i], JLabel.CENTER);
			sideCoordinateLabel.setPreferredSize(new Dimension(12, 12));
			sideCoordinateLabel.setForeground(Color.white);

			buttonPanel.add(sideCoordinateLabel, gbc);
		}

		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(480, 480));
		contentPane.add(buttonPanel);
		contentPane.setBackground(new Color(47, 69, 105));
		gamePane.add(contentPane);
	}
}
