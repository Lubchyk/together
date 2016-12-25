package lightning;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class GameWindow extends JFrame{
	
	private static GameWindow gameWindow;
	private static Image drop;
	private static Image background;
	private static Image game_over;
	private static float drop_left = 200;
	private static float drop_top = -100;
	private static long start_time;
	private static float drop_speed = 200;
	private static float one_sec = 0.000000001f;
	private static int score;
	private static int life = 5;
	private static Image life1;
	private static Image life2;
	private static Image life3;
	private static Image life4;
	private static Image life5;

	public static void main(String[] args) throws IOException {
		//Point a = new Point(200, 200);
		JLabel totalScore = new JLabel("Score " + score);
		
		//totalScore.setBounds(100,200,40,20);
		
		drop = ImageIO.read(GameWindow.class.getResourceAsStream("drop.png"));
		background = ImageIO.read(GameWindow.class.getResourceAsStream("background.png"));
		game_over = ImageIO.read(GameWindow.class.getResourceAsStream("game_over.png"));
		life1 = ImageIO.read(GameWindow.class.getResourceAsStream("life_1.png"));
		life2 = ImageIO.read(GameWindow.class.getResourceAsStream("life_2.png"));
		life3 = ImageIO.read(GameWindow.class.getResourceAsStream("life_3.png"));
		life4 = ImageIO.read(GameWindow.class.getResourceAsStream("life_4.png"));
		life5 = ImageIO.read(GameWindow.class.getResourceAsStream("life_5.png"));
		
		gameWindow = new GameWindow();
		gameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		gameWindow.setLocation(150, 25);
		gameWindow.setSize(970, 700);
		gameWindow.setResizable(false);
		start_time = System.nanoTime();
		GamePanel gamePanel = new GamePanel();
		//FlowLayout fl = new FlowLayout();
		//gamePanel.setLayout(fl);
		//gamePanel.setLayout(null);
		//totalScore.setLocation(a);
		gamePanel.add(totalScore);
		
		gamePanel.addMouseListener(new MouseAdapter() {
		@Override
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			float drop_right = drop_left + drop.getWidth(null);
			float drop_bottom = drop_top + drop.getHeight(null);
			boolean is_drop = x >= drop_left && x <= drop_right && y >= drop_top && y <= drop_bottom;
			if (is_drop) {
				drop_top = -100;
				drop_left = (int) (Math.random() * (gamePanel.getWidth() - drop.getWidth(null)));
				drop_speed += 20;
				score++;
				gameWindow.setTitle("lightning");
				totalScore.setText("Score " + score);
				gamePanel.add(totalScore);
			}
		}
		});
		gameWindow.add(gamePanel);
		gameWindow.setVisible(true);		
	}
	private static  void onRepaind(Graphics g) {
		long current_time = System.nanoTime();
		float delta_time = (current_time - start_time) * one_sec;
		start_time = current_time;
		drop_top = drop_top + drop_speed * delta_time;
		g.drawImage(background, 0, 0, null);
		if (life == 5 )g.drawImage(life5, 0, 0, null);		
		g.drawImage(drop, (int) drop_left, (int) drop_top, null);	
		switch (life) {
		case 4:
			g.drawImage(life4, 0, 0, null);		
			break;
		case 3:
			g.drawImage(life3, 0, 0, null);	
			break;
		case 2:
			g.drawImage(life2, 0, 0, null);	
			break;
		case 1:
			g.drawImage(life1, 0, 0, null);				
			break;
		}
		if (drop_top > gameWindow.getHeight()) {
			life = life - 1;
			drop_speed = 200;
			if (life > 0) {
				drop_top = -100;
				drop_left = (int) (Math.random() * (970 - drop.getWidth(null)));
			}
			else {
				g.drawImage(game_over, 130, 230, null);
			}
		}
	}
	private static class GamePanel extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			onRepaind(g);
			repaint();			
		}				
	}
}
