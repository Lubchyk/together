package lightning;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class GameWindow extends JFrame{
	
	private static GameWindow gameWindow;

	public static void main(String[] args) {
		gameWindow = new GameWindow();
		gameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		gameWindow.setLocation(150, 25);
		gameWindow.setSize(1000, 700);
		gameWindow.setResizable(false);
		GamePanel gamePanel = new GamePanel();
		gameWindow.add(gamePanel);
		gameWindow.setVisible(true);
		
	}
	private static  void onRepaind(Graphics g) {
		g.fillOval(50, 20, 150, 30);
		g.drawLine(0, 600, 1000, 600);
		
	}
	private static class GamePanel extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			onRepaind(g);
			
		}
		
		
	}
}
