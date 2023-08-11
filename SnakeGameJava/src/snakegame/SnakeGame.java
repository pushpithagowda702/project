package snakegame;

import javax.swing.*;

public class SnakeGame extends JFrame {
	
	SnakeGame() {
		super("Snake Game");
		add(new Board());
		
		// Refresh the frame to reflect the changes
		pack();
		setSize(400, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new SnakeGame();

	}

}
