import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PlayerInfoFrame extends JFrame {
	private JTextField nameField;
	private findGameListener fgl;
	private JLabel playerNameTxt;
	private JButton findGame;
	private GridBagConstraints gbc; 

	public PlayerInfoFrame() {
		initialize();
	}

	public void initialize() {
		setTitle("Player Information");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		getContentPane().setBackground(new Color(47, 69, 105));

		// set layout for frame
		setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(25, 5, 8, 5);

		// area for player name text
		playerNameTxt = new JLabel("Enter player name");
		playerNameTxt.setForeground(Color.white);
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(playerNameTxt, gbc);

		// name textfield
		nameField = new JTextField();
		nameField.setPreferredSize(new Dimension(250, 40));
		gbc.gridx = 1;
		gbc.gridy = 0;
		add(nameField, gbc);
		
		fgl = new findGameListener();

		// button to begin game matching
		findGame = new JButton("Find Game");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.gridheight = 3;
		add(findGame, gbc);
		findGame.addActionListener(fgl);
	}

	private class findGameListener implements ActionListener {
		
		public void createLoadingScreen() {
			JFrame loadScreen = new JFrame();
			loadScreen.setTitle("Load Game");
			loadScreen.setVisible(true);
			loadScreen.setSize(500, 500);
			loadScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			loadScreen.getContentPane().setBackground(Color.white);
			//new Color(76, 114, 173)
			
			// set layout
			loadScreen.setLayout(new GridBagLayout());
			gbc = new GridBagConstraints();
			
			// place loading icon for finding match
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.gridwidth = 4;
			ImageIcon loadingIcon = new ImageIcon("media/loading-icon.png");
			loadScreen.add(new JLabel(loadingIcon), gbc);
			
			// resize loading gif
			ImageIcon loading = new ImageIcon("media/Loading_icon.gif");
			Image img = loading.getImage();
			Image newImg = img.getScaledInstance(80, 80, DO_NOTHING_ON_CLOSE);
			
			// add newly resized gif and loading text
			gbc.gridx = 0;
			gbc.gridy = 1;
			loading = new ImageIcon(newImg);
			loadScreen.add(new JLabel("Loading game", SwingConstants.CENTER), gbc);
			
			gbc.gridx = 1;
			gbc.gridy = 2;
			loadScreen.add(new JLabel(loading, JLabel.CENTER), gbc);
		}
		
		public void actionPerformed(ActionEvent e) {
			// close current frame
			setVisible(false);

			// loading screen
			createLoadingScreen();
		}
	}

}
