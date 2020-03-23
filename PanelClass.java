package pong.game.v1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class PanelClass extends JPanel implements ActionListener, KeyListener {
	private MainClass game;
	private BallClass ball;
	private PlayerClass p1, p2;
	private int score1, score2;
	
	public PanelClass(MainClass game) {
		setBackground(Color.CYAN);
		this.game = game;		
		ball = new BallClass(game);
		
		//Player 1 game play keys (up and down) arrows
		//Player 2 game play keys W(up) and S(down)
		p1 = new PlayerClass(game, KeyEvent.VK_UP, KeyEvent.VK_DOWN, game.getWidth() - 36);
		p2 = new PlayerClass(game, KeyEvent.VK_W, KeyEvent.VK_S, 20);		
		Timer timer = new Timer(5, this);
		timer.start();
		addKeyListener(this);
		setFocusable(true);
	}
	
	public PlayerClass getPlayer(int playerNo) {
		if(playerNo == 1)
			return p1;
		else
			return p2;
	}
	
	//Increase player score by player number
	public void upScore(int playerNo) {
		if(playerNo == 1)
			score1++;
		else
			score2++;
	}
	
	public int getScore(int playerNo) {
		if(playerNo ==1)
			return score1;
		else
			return score2;
	}	

	public void update() {
		ball.update();
		p1.update();
		p2.update();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		;		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		p1.pressed(e.getKeyCode());
		p2.pressed(e.getKeyCode());		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		p1.released(e.getKeyCode());
		p2.released(e.getKeyCode());		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		update();
		repaint();		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//Places score in top center of screen
		g.setFont(new Font("Jokerman", Font.BOLD, 20));
		g.drawString(game.getPanel().getScore(1) + " : " + game.getPanel().getScore(2), game.getWidth() / 2 - 20, 18);
		g.drawLine(game.getWidth() / 2, 20, game.getWidth() / 2 , 450);
		
		p1.paint(g);
		p2.paint(g);
		ball.paint(g);		
	}
}
