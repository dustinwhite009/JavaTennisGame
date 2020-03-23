package pong.game.v1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class PlayerClass {
	private static final int PLAYER_WIDTH = 7, PLAYER_HEIGHT = 60;
	private MainClass game;
	private int up, down;
	private int x;
	private int y, yAxis;
	
	public PlayerClass(MainClass game, int up, int down, int x) {
		this.game = game;
		this.x = x;
		y = game.getHeight() / 2;
		this.up = up;
		this.down = down;
	}
	
	public void update() {
		if(y > 0 && y < game.getHeight() - PLAYER_HEIGHT - 29)
			y += yAxis;
		else if(y == 0)
			y++;
		else if(y == game.getHeight() - PLAYER_HEIGHT - 29)
			y--;
	}
	
	public void pressed(int keyCode) {
		if(keyCode == up)
			yAxis = -1;
		else if(keyCode == down)
			yAxis = 1;
	}
	
	public void released(int keyCode) {
		if(keyCode == up || keyCode == down)
			yAxis = 0;
	}
	
	//Set player paddle boundaries
	public Rectangle getBounds() {
		return new Rectangle(x, y, PLAYER_WIDTH, PLAYER_HEIGHT);
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, PLAYER_WIDTH, PLAYER_HEIGHT);				
	}
}
