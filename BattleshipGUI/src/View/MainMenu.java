package View;
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
	private JPanel menuPane;

	// Initial state of main menu
	public MainMenu() {
		initialize();
	}

	public void initialize() {

		menu = new JFrame();

		// window specifications
		menu.setTitle("Main Menu");
		menu.setSize(700, 500);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setResizable(false);
		menu.getContentPane().setBackground(new Color(47, 69, 105));

		menuPane = new JPanel();

		// set menuPane layout
		menuPane.setLayout(new BoxLayout(menuPane, BoxLayout.Y_AXIS));
		menuPane.setPreferredSize(new Dimension(100, 700));
		menuPane.setBackground(new Color(47, 69, 105));
		
		gameTitle();
		startBtn();
		rulesBtn();
		
		menu.getContentPane().add(menuPane);
		menu.setVisible(true);
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

	// place menutitle on menu screen
	public void gameTitle() {
		menuPane.add(Box.createVerticalStrut(150));
		// game title
		gameTitle = new JLabel("Battleship");
		gameTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		gameTitle.setForeground(Color.white);
		gameTitle.setFont(new Font("Verdana", Font.PLAIN, 30));
		menuPane.add(gameTitle);
	}
	
	// place start btn on menu screen
	public void startBtn() {
		menuPane.add(Box.createVerticalStrut(40));
		 sgl = new startGameListener(); 
		 startGameBtn = new JButton("Start Game");
		 startGameBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		 startGameBtn.setBackground(Color.GREEN); 
		 startGameBtn.setPreferredSize(new Dimension(80, 40));
		 menuPane.add(startGameBtn);
		 startGameBtn.addActionListener(sgl);
	}
	
	// place rules btn on menu screen
	public void rulesBtn() {
		menuPane.add(Box.createVerticalStrut(25));
		 rulesBtn = new JButton("Rules");
		 rulesBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		 rulesBtn.setBackground(Color.GRAY); 
		 rulesBtn.setPreferredSize(new Dimension(80, 40));
		 menuPane.add(rulesBtn);
		menuPane.add(Box.createVerticalStrut(70));
	}
}
