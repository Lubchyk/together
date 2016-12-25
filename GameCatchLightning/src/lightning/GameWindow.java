package lightning;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
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

	public static void main(String[] args) throws IOException {
		
		drop = ImageIO.read(GameWindow.class.getResourceAsStream("drop.png"));
		background = ImageIO.read(GameWindow.class.getResourceAsStream("background.png"));
		game_over = ImageIO.read(GameWindow.class.getResourceAsStream("game_over.png"));
		gameWindow = new GameWindow();
		gameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		gameWindow.setLocation(150, 25);
		gameWindow.setSize(970, 700);
		gameWindow.setResizable(false);
		start_time = System.nanoTime();
		GamePanel gamePanel = new GamePanel();
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
				gameWindow.setTitle("Score" + score);
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
		//drop_left = drop_left + drop_speed * delta_time;
		g.drawImage(background, 0, 0, null);
		g.drawImage(drop, (int) drop_left, (int) drop_top, null);
		if (drop_top > gameWindow.getHeight())g.drawImage(game_over, 130, 230, null);
//		g.fillOval(50, 20, 150, 30);
//		g.drawLine(0, 600, 1000, 600);
		
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
