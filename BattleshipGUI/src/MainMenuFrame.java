import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainMenuFrame extends JFrame {

	private JButton startGameBtn;
	private JButton rulesBtn;
	private JLabel gameTitle;
	private startGameListener sgl;
	private GameFrame gameLinks;
	private JTextField serverConnectTxt;

	// Initial state of main menu
	public MainMenuFrame() {
		initialize();
	}

	public void initialize() {
		// window specifications
		setTitle("Main Menu");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		getContentPane().setBackground(new Color(47, 69, 105));

		// game title
		gameTitle = new JLabel("Battleship");
		gameTitle.setBounds(172, 30, 200, 200);
		gameTitle.setForeground(Color.white);
		gameTitle.setFont(new Font("Verdana", Font.PLAIN, 30));
		setLayout(null);
		add(gameTitle);

		// start button
		sgl = new startGameListener();
		startGameBtn = new JButton("Start Game");
		startGameBtn.setBackground(Color.GREEN);
		startGameBtn.setBounds(170, 200, 150, 50);
		add(startGameBtn);
		startGameBtn.addActionListener(sgl);

		// rules button
		rulesBtn = new JButton("Rules");
		rulesBtn.setBackground(Color.GRAY);
		rulesBtn.setBounds(170, 275, 150, 50);
		add(rulesBtn);
	}

	private class startGameListener implements ActionListener {

		// goes to screen to enter player name
		public void actionPerformed(ActionEvent e) {
			// close current frame
			setVisible(false);
			// create frame for entering player name
			PlayerInfoFrame playerInfoFrame = new PlayerInfoFrame();
		}
	}
}
