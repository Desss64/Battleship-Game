import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame{
	
	private JTextArea nameTxt; 
	private JTextArea oppNameTxt;
	private JButton userBtns[];
	private JButton oppBtns[];
	private JButton userStatBtns[];
	private JButton oppStatBtns[];
	private GridBagConstraints gbc; 
	private JFrame gameScreen;
	
	public GameFrame(JFrame currScreen) {	
		gameScreen = currScreen;
		gameScreen.setTitle("Game");
		gameScreen.setSize(800, 800);
		
		// display opponent grid
		loadOppBoard();
		
		// display player name
	}
	
	public void loadOppBoard() {
		JPanel buttonPanel = new JPanel();
		JPanel containerPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(9, 10));
		
		// initialize userBtns arr
		userBtns = new JButton[64];
		for(int i = 0; i < userBtns.length; i++)
			userBtns[i] = new JButton();
		
		// add btn array panel in grid format
		for(int i = 0; i < userBtns.length; i++) {
			buttonPanel.add(userBtns[i]);
		}
		
		buttonPanel.setPreferredSize(new Dimension(300, 400));
		containerPanel.setPreferredSize(new Dimension(800, 800));
        containerPanel.add(buttonPanel);

        gameScreen.getContentPane().add(containerPanel);
        //pack();
        gameScreen.setVisible(true);
	}
	
	public void displayPlayerName() {
		
	}

}
