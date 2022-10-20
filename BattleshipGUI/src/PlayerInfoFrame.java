import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PlayerInfoFrame extends JFrame {
	private JTextField nameField;
	private findGameListener fgl;
	private JLabel playerNameTxt;
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
		playerNameTxt = new JLabel("Enter player name");
		playerNameTxt.setForeground(Color.white);
		gbc.gridx = 0;
		gbc.gridy = 0;
		playerInfoScreen.add(playerNameTxt, gbc);

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
			//new Color(76, 114, 173)
			
			// set layout
			loadingScreen.setLayout(new GridBagLayout());
			gbc = new GridBagConstraints();
			
			// place loading icon for finding match
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.gridwidth = 4;
			ImageIcon loadingIcon = new ImageIcon("media/loading-icon.png");
			loadingScreen.add(new JLabel(loadingIcon), gbc);
			
			// resize loading gif
			ImageIcon loading = new ImageIcon("media/Loading_icon.gif");
			Image img = loading.getImage();
			Image newImg = img.getScaledInstance(80, 80, DO_NOTHING_ON_CLOSE);
			
			// add newly resized gif and loading text
			gbc.gridx = 0;
			gbc.gridy = 1;
			loading = new ImageIcon(newImg);
			loadingScreen.add(new JLabel("Loading game", SwingConstants.CENTER), gbc);
			
			gbc.gridx = 1;
			gbc.gridy = 2;
			loadingScreen.add(new JLabel(loading, JLabel.CENTER), gbc);
		}
		
		public void actionPerformed(ActionEvent e) {
			
			// hide components from player info screen
			
			nameField.setVisible(false);
			findGameBtn.setVisible(false);
			playerNameTxt.setVisible(false);
			
			// loading screen
			createLoadingScreen(playerInfoScreen);
		}
	}

}
