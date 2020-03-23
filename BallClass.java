package pong.game.v1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JOptionPane;

public class BallClass {
	private static final int BALL_WIDTH = 16, BALL_HEIGHT = 16;
	private MainClass game;
	private int x, y, xAxis = 1, yAxis =1;
	
	public BallClass(MainClass game) {	
		this.game = game;
		x = game.getWidth() / 2;
		y = game.getHeight() / 2;
	}
	
	public void update() {
		x += xAxis;
		y += yAxis;		
		
		if(x < 0) {
			game.getPanel().upScore(1);
			x = game.getWidth() / 2;
			xAxis = -xAxis;
		}
		else if(x > game.getWidth() - BALL_WIDTH - 7) {
			game.getPanel().upScore(2);
			x = game.getWidth() / 2;
			xAxis = -xAxis;
		}
		else if(y < 0 || y > game.getHeight() - BALL_HEIGHT - 35)
			yAxis = -yAxis;		
		
		//Display Winner Dialog if Player 1 Score = 10, close program
		if(game.getPanel().getScore(1) == 10) {
			JOptionPane.showMessageDialog(null, "Player 1 Wins!", "Tennis", JOptionPane.PLAIN_MESSAGE);			
			System.exit(0);
		}
		
		//Display Winner Dialog if Player 2 Score = 10, close program
		else if(game.getPanel().getScore(2) == 10) {
			JOptionPane.showMessageDialog(null, "Player 1 Wins!", "Tennis", JOptionPane.PLAIN_MESSAGE);	
			System.exit(0);
		}
		checkCollision();
	}
	
	//Check for ball contact with paddle
	public void checkCollision() {
		if(game.getPanel().getPlayer(1).getBounds().intersects(getBounds()) || 
		   game.getPanel().getPlayer(2).getBounds().intersects(getBounds()))
			xAxis = -xAxis;
	}
	
	//Return ball boundaries
	public Rectangle getBounds() {
		return new Rectangle(x, y, BALL_WIDTH, BALL_HEIGHT);
	}
	
	public void paint(Graphics g) {	
		g.setColor(Color.RED);
		g.fillOval(x, y, BALL_WIDTH, BALL_HEIGHT);
	}
}
