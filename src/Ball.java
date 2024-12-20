import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball {
	//球的位置，像素坐标
	private int x,y;
	//dx、dy相当于方向向量
	private int dx = 2,dy = 2;
	//球的大小
	private final int SIZE = 20;
	
	public Ball(int x , int y ) {
		this.x = x;
		this.y = y;
	}
	
	public void move() {
		x += dx;
		y += dy;
	}
	
	public void reverseX(){
		dx =-dx;
	}
	public void reverseY(){
		dy =-dy;
	}
	//绘图小球
	public void paint(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillOval(x, y, SIZE, SIZE);
	}
	//把小球用外接矩形包装一下，利于判定碰撞
	public Rectangle getBounds() {
		
		return new Rectangle(x,y,SIZE,SIZE);
		
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
