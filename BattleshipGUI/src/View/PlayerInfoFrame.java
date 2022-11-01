package View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import model.Player;

/**
 * 
 * Represents screen for getting player's name
 *
 */
public class PlayerInfoFrame extends JFrame {
	private JTextField nameField;
	private findGameListener fgl;
	private JLabel enterNameLabel;
	private JButton findGameBtn;
	private GridBagConstraints gbc;
	private JFrame playerInfoScreen;
	private JPanel playerInfoArea;

	public PlayerInfoFrame(JFrame currScreen) {
		initialize(currScreen);
	}

	public void initialize(JFrame currScreen) {

		playerInfoScreen = currScreen;
		playerInfoScreen.setTitle("Player Information");

		playerInfoArea = new JPanel();
		playerInfoArea.setBackground(new Color(47, 69, 105));
		enterNameLabel = new JLabel();

		// label text for player name
		playerInfoArea.setLayout(new FlowLayout());
		enterNameLabel = new JLabel("Enter player name:");
		enterNameLabel.setForeground(Color.white);
		playerInfoArea.add(enterNameLabel);

		// name textfield
		playerInfoArea.add(Box.createVerticalStrut(475));
		nameField = new JTextField();
		nameField.setPreferredSize(new Dimension(250, 30));
		playerInfoArea.add(nameField);
		playerInfoScreen.getContentPane().add(playerInfoArea);

		// find game listener
		fgl = new findGameListener();

		// button to begin game matching
		findGameBtn = new JButton("Find Game");
		playerInfoArea.add(findGameBtn);
		findGameBtn.addActionListener(fgl);
	}

	private class findGameListener implements ActionListener {

		public void createLoadingScreen(JFrame loadingScreen) {
			loadingScreen.setTitle("Load Game");
			loadingScreen.setVisible(true);
			loadingScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			loadingScreen.getContentPane().setBackground(Color.white);

			// set layout
			loadingScreen.getContentPane().setLayout(new GridBagLayout());
			gbc = new GridBagConstraints();

			// place loading icon for finding match
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.gridwidth = 4;
			ImageIcon loadingIcon = new ImageIcon("media/loading-icon.png");
			JLabel loadIconArea = new JLabel(loadingIcon);
			loadingScreen.getContentPane().add(loadIconArea, gbc);

			// resize loading gif
			ImageIcon loading = new ImageIcon("media/Loading_icon.gif");
			Image img = loading.getImage();
			Image newImg = img.getScaledInstance(80, 80, DO_NOTHING_ON_CLOSE);

			// add newly resized gif and loading text
			gbc.gridx = 0;
			gbc.gridy = 1;
			loading = new ImageIcon(newImg);
			JLabel loadGameLabel = new JLabel("Loading game", SwingConstants.CENTER);
			loadingScreen.getContentPane().add(loadGameLabel, gbc);

			gbc.gridx = 1;
			gbc.gridy = 2;
			JLabel loadingGif = new JLabel(loading, JLabel.CENTER);
			loadingScreen.getContentPane().add(loadingGif, gbc);

			// action listener for opening up game screen
			ActionListener openGameScreen = new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					// hide components
					loadIconArea.setVisible(false);
					loadGameLabel.setVisible(false);
					loadingGif.setVisible(false);
					
					// create player
					Player p1 = new Player(nameField.getText());
					GameFrame gameScreen = new GameFrame(loadingScreen, p1);
				}
			};

			// timer before going to next screen
			Timer timer = new Timer(1000, openGameScreen);
			timer.start();
			timer.setRepeats(false);
		}

		public void actionPerformed(ActionEvent e) {

			// hide components from player info screen
			nameField.setVisible(false);
			findGameBtn.setVisible(false);
			enterNameLabel.setVisible(false);
			playerInfoArea.setVisible(false);

			// loading screen
			createLoadingScreen(playerInfoScreen);
		}
	}

}
