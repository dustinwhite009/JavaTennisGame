package pong.game.v1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainClass extends JFrame{
	private final static int PLAYING_AREA_WIDTH = 700, PLAYING_AREA_HEIGHT = 450;
	private PanelClass panel;
	private Toolkit it;
	private Dimension dimension;
	int dWidth, dHeight;
	
	public MainClass() {		
		setSize(PLAYING_AREA_WIDTH, PLAYING_AREA_HEIGHT);
		setTitle("Tennis");
		setBackground(Color.WHITE);		
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel = new PanelClass(this);
		add(panel);
		setFrame();
	}	

	public PanelClass getPanel() {
		return panel;
	}
	
	//Center JFrame in center of screen
	public void setFrame() {
		it = Toolkit.getDefaultToolkit();
		dimension = it.getScreenSize();
		dWidth = getWidth();
		dHeight = getHeight();
		setLocation(dimension.width/2 - dWidth/2, dimension.height/2 - dHeight/2);
	}
	
	public static void main(String[] args) {
		new MainClass();		
	}
}
