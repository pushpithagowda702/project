package snakegame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends JPanel implements ActionListener {
	private int dots;
	private Image dot;
	private Image apple;
	private Image head;
	
	private final int all_dots = 900;
	private final int dot_size = 10;
	private final int random_position = 29;
	
	private int apple_x;
	private int apple_y;
	
	private final int x[] = new int[all_dots];
	private final int y[] = new int[all_dots];
	
	private boolean leftDirection = false;
	private boolean rightDirection = true;
	private boolean upDirection = false;
	private boolean downDirection = false;
	
	private boolean inGame = true;
	private Timer timer;
	
	
	Board() {
		addKeyListener (new TAdapter());
		setBackground(new Color(0, 0, 0));
		setFocusable(true);
		loadImages();
		initGame();
		
	}
	
	public void loadImages() {
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("snakegame/icons/apple.png"));
		apple = i1.getImage();
		ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("snakegame/icons/dot.png"));
		dot = i2.getImage();
		ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("snakegame/icons/head.png"));
		head = i3.getImage();
	}
	
	public void initGame() {
		dots = 3;
		
		for(int i=0; i<dots; i++) {
			y[i] = 50;
			x[i] = 50 - i * dot_size;
		}
		locateApple();
		timer = new Timer(140, this);
		timer.start();
	}
	
	public void locateApple() {
		int r = (int)(Math.random() * random_position);
		apple_x = r * dot_size;
		r = (int)(Math.random() * random_position);
		apple_y = r * dot_size;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	
	public void draw(Graphics g) {
		g.drawImage(apple, apple_x, apple_y, this);
		for(int i=0; i<dots; i++) {
			if(i == 0) {
				g.drawImage(head, x[i], y[i], this);
			} else {
				g.drawImage(dot, x[i], y[i], this);
			}
		}
		Toolkit.getDefaultToolkit().sync();
	}
	
	public void move() {
		for(int i=dots; i>0; i--) {
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
		
		if(leftDirection) {
			x[0] = x[0] - dot_size;
		}

		if(rightDirection) {
			x[0] = x[0] + dot_size;
		}

		if(upDirection) {
			y[0] = y[0] - dot_size;
		}

		if(downDirection) {
			y[0] = y[0] + dot_size;
		}
	}
	
	public void actionPerformed(ActionEvent ae) {
		checkApple();
		checkCollision();
		move();
		repaint();
	}
	
	public void checkCollision() {
		for(int i=dots; i>0; i--) {
			if((i > 4) && (x[0] == x[i] && (y[0] == y[i]))) {
				inGame = false;
			}
		}
		
		if(y[0] >= 290) {
			inGame = false;
		}

		if(x[0] >= 290) {
			inGame = false;
		}
		
		if(y[0] < 0) {
			inGame = false;
		}

		if(x[0] < 0) {
			inGame = false;
		}
		
		if(!inGame) {
			timer.stop();
		}
	}
	
	public void checkApple() {
		if((x[0] == apple_x) && (y[0] == apple_y)) {
			dots++;
			locateApple();
		}
	}
	
	public class TAdapter extends KeyAdapter {
		
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			
			if(key == KeyEvent.VK_LEFT && (!rightDirection)) {
				leftDirection = true;
				upDirection = false;
				downDirection = false;
			}

			if(key == KeyEvent.VK_RIGHT && (!leftDirection)) {
				rightDirection = true;
				upDirection = false;
				downDirection = false;
			}
			
			if(key == KeyEvent.VK_UP && (!downDirection)) {
				upDirection = true;
				leftDirection = false;
				rightDirection = false;
			}
			
			if(key == KeyEvent.VK_DOWN && (!upDirection)) {
				downDirection = true;
				leftDirection = false;
				rightDirection = false;
			}
		}
	}
}
