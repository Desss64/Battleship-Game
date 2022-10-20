import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PlayerInfoFrame extends JFrame {
	private JTextField nameField;
	private findGameListener fgl;
	private JLabel enterNameLabel;
	private JButton findGameBtn;
	private GridBagConstraints gbc;
	private JFrame playerInfoScreen;

	public PlayerInfoFrame(JFrame currScreen) {
		initialize(currScreen);
	}

	public void initialize(JFrame currScreen) {

		playerInfoScreen = currScreen;
		playerInfoScreen.setTitle("Player Information");

		// set layout for frame
		playerInfoScreen.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(25, 5, 8, 5);

		// area for player name text
		enterNameLabel = new JLabel("Enter player name");
		enterNameLabel.setForeground(Color.white);
		gbc.gridx = 0;
		gbc.gridy = 0;
		playerInfoScreen.add(enterNameLabel, gbc);

		// name textfield
		nameField = new JTextField();
		nameField.setPreferredSize(new Dimension(250, 40));
		gbc.gridx = 1;
		gbc.gridy = 0;
		playerInfoScreen.add(nameField, gbc);
		
		// find game listener
		fgl = new findGameListener();

		// button to begin game matching
		findGameBtn = new JButton("Find Game");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.gridheight = 3;
		playerInfoScreen.add(findGameBtn, gbc);
		findGameBtn.addActionListener(fgl);
	}

	private class findGameListener implements ActionListener {

		public void createLoadingScreen(JFrame loadingScreen) {
			loadingScreen.setTitle("Load Game");
			loadingScreen.setVisible(true);
			loadingScreen.setSize(500, 500);
			loadingScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			loadingScreen.getContentPane().setBackground(Color.white);
			// new Color(76, 114, 173)

			// set layout
			loadingScreen.setLayout(new GridBagLayout());
			gbc = new GridBagConstraints();

			// place loading icon for finding match
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.gridwidth = 4;
			ImageIcon loadingIcon = new ImageIcon("media/loading-icon.png");
			JLabel loadIconArea = new JLabel(loadingIcon);
			loadingScreen.add(loadIconArea, gbc);

			// resize loading gif
			ImageIcon loading = new ImageIcon("media/Loading_icon.gif");
			Image img = loading.getImage();
			Image newImg = img.getScaledInstance(80, 80, DO_NOTHING_ON_CLOSE);

			// add newly resized gif and loading text
			gbc.gridx = 0;
			gbc.gridy = 1;
			loading = new ImageIcon(newImg);
			JLabel loadGameLabel = new JLabel("Loading game", SwingConstants.CENTER);
			loadingScreen.add(loadGameLabel, gbc);

			gbc.gridx = 1;
			gbc.gridy = 2;
			JLabel loadingGif = new JLabel(loading, JLabel.CENTER);
			loadingScreen.add(loadingGif, gbc);

			// action listener for opening up game screen
			ActionListener openGameScreen = new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					// hide components
					loadIconArea.setVisible(false);
					loadGameLabel.setVisible(false);
					loadingGif.setVisible(false);
					String pName = nameField.getText();
					GameFrame gameScreen = new GameFrame(loadingScreen, pName);
				}
			};

			// timer before going to next screen
			Timer timer = new Timer(2000, openGameScreen);
			timer.start();
			timer.setRepeats(false);
		}

		public void actionPerformed(ActionEvent e) {

			// hide components from player info screen
			nameField.setVisible(false);
			findGameBtn.setVisible(false);
			enterNameLabel.setVisible(false);
			
			// loading screen
			createLoadingScreen(playerInfoScreen);
		}
	}

}
