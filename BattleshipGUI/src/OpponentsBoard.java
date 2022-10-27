import java.awt.*;
import javax.swing.*;

public class OpponentsBoard extends Board {

	private JButton oppBtns[][];
	private JPanel buttonPanel;
	private int boardSize;
	private JFrame gameScreen;
	private JPanel contentPane;
	private JPanel gamePane;

	public OpponentsBoard(JFrame currScreen) {
		gameScreen = currScreen;
		draw();
	}

	// draw opponent's board
	public void draw() {
		buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(350, 350));
		buttonPanel.setLayout(new GridLayout(8, 8));
		buttonPanel.setBackground(new Color(47, 69, 105));
		boardSize = getSize();
		oppBtns = new JButton[boardSize][boardSize];

		// loop through boardArray creating jbutton for each cell
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				oppBtns[i][j] = new JButton();
				oppBtns[i][j].setPreferredSize(new Dimension(50, 50));
				oppBtns[i][j].setBackground(Color.white);
				buttonPanel.add(oppBtns[i][j]);
			}
		}

		// pane to hold opponent board
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(750, 750));
		contentPane.setBackground(new Color(47, 69, 105));
		contentPane.add(buttonPanel);

		// game pane to hold game components
		gamePane = new JPanel();
		gamePane.setLayout(new GridLayout(2, 2, 10, 10));
		gamePane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		gamePane.setPreferredSize(new Dimension(600, 700));
		gamePane.add(contentPane);

		gameScreen.add(gamePane);
		gameScreen.setVisible(true);
	}
	
	// gets JPanel where all the game components are
	public JPanel getGamePane() {
		return gamePane;
	}

}
