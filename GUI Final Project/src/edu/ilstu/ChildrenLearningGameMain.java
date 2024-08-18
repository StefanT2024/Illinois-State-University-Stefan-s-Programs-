package edu.ilstu;

/**
 * ChildrenLearningGameMain class represents the main class for the Children's Learning Game.
 * It creates a GUI with a welcome message, input field for the player's name,
 * and a button to start the learning game. Upon starting the game, instances of AlphabetModule and
 * CountingModule are created.
 * 
 * @author Stefan Tujarov 
 * ULID: SBTUJAR
 * 
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChildrenLearningGameMain {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Children's Learning Game");
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(200, 230, 255));
		frame.add(panel);

		placeComponents(panel);

		frame.setVisible(true);
	}

	private static void placeComponents(JPanel panel) {
		panel.setLayout(new BorderLayout());

		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
		topPanel.setBackground(new Color(100, 160, 220));

		JLabel titleLabel = new JLabel("Children's Learning Game");
		titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
		titleLabel.setForeground(Color.WHITE);
		topPanel.add(titleLabel);

		// Adding the top panel to the main panel.
		panel.add(topPanel, BorderLayout.NORTH);

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(3, 1, 10, 10));
		centerPanel.setBackground(new Color(200, 230, 255));

		JTextField nameText = new JTextField("Enter your name");
		nameText.setHorizontalAlignment(JTextField.CENTER);
		centerPanel.add(nameText);

		nameText.addFocusListener(new FocusAdapter() {

			public void focusGained(FocusEvent e) {
				nameText.setText("");
			}
		});

		JButton startButton = new JButton("Start Game");
		startButton.setBackground(new Color(100, 160, 220));
		startButton.setForeground(Color.WHITE);
		centerPanel.add(startButton);

		panel.add(centerPanel, BorderLayout.CENTER);

		startButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String playerName = nameText.getText().trim();
				if (!playerName.isEmpty()) {
					startLearningGame(playerName);
				} else {
					JOptionPane.showMessageDialog(null, "Please enter your name.");
				}
			}
		});
	}

	// Displaying a welcome message and starting the learning game with AlphabetModule and CountingModule instances.
	
	private static void startLearningGame(String playerName) {
		JOptionPane.showMessageDialog(null, "Let's start the learning game, " + playerName + "!");
		AlphabetModule alphabetModule = new AlphabetModule(playerName);
		CountingModule countingModule = new CountingModule(playerName);
		JOptionPane.showMessageDialog(null, "Alphabet Module");
		alphabetModule.runModule();
		JOptionPane.showMessageDialog(null, "Counting Module");
		countingModule.runModule();
	}
}
