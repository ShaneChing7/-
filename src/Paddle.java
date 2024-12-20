import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Paddle {
	private int x,y;
	private final int WIDTH = 20;
	private final int HEIGHT = 100;
	
	public Paddle(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void moveUp() {
		if(y > 0) {
			y -= 20;
		}
	}
	
	public void moveDown() {
		if(y < 700) {
			y += 20;
		}
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}
	public Rectangle getBounds() {
		
		return new Rectangle(x,y,WIDTH,HEIGHT);
		
	}
}
