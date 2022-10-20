import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainMenu extends JFrame {

	private JButton startGameBtn;
	private JButton rulesBtn;
	private JLabel gameTitle;
	private startGameListener sgl;
	private GameFrame gameLinks;
	private JTextField serverConnectTxt;
	private JFrame menu;

	// Initial state of main menu
	public MainMenu() {
		initialize();
	}

	public void initialize() {
		
		menu = new JFrame();
		
		// window specifications
		menu.setTitle("Main Menu");
		menu.setSize(500, 500);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setResizable(false);
		menu.setVisible(true);
		menu.getContentPane().setBackground(new Color(47, 69, 105));

		// game title
		gameTitle = new JLabel("Battleship");
		gameTitle.setBounds(172, 30, 200, 200);
		gameTitle.setForeground(Color.white);
		gameTitle.setFont(new Font("Verdana", Font.PLAIN, 30));
		menu.setLayout(null);
		menu.add(gameTitle);

		// start button
		sgl = new startGameListener();
		startGameBtn = new JButton("Start Game");
		startGameBtn.setBackground(Color.GREEN);
		startGameBtn.setBounds(170, 200, 150, 50);
		menu.add(startGameBtn);
		startGameBtn.addActionListener(sgl);

		// rules button
		rulesBtn = new JButton("Rules");
		rulesBtn.setBackground(Color.GRAY);
		rulesBtn.setBounds(170, 275, 150, 50);
		menu.add(rulesBtn);
	}

	private class startGameListener implements ActionListener {

		// goes to screen to enter player name
		public void actionPerformed(ActionEvent e) {

			// hide contentes of main menu
			gameTitle.setVisible(false);
			startGameBtn.setVisible(false);
			rulesBtn.setVisible(false);
			
			// show screen for entering plaayer information
			PlayerInfoFrame playerInfoFrame = new PlayerInfoFrame(menu);
		}
	}
}
