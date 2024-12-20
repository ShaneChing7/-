import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.Timer;

public class GameCanvas extends Canvas implements KeyListener{
	private Timer timer;
	public Ball ball;
	public Paddle paddle;
	private Wall[] walls;
	public int score;
	public boolean gameOver;
	
	GameCanvas(){
		this.setBackground(Color.BLACK);
		this.setFocusable(true);
		//初始化球、板、墙位置
		ball = new Ball(400,400);
		paddle = new Paddle(50,350);
		walls = new Wall[3];
		walls[0] = new Wall(150,50,550,20);
		walls[1] = new Wall(700,70,20,630);
		walls[2] = new Wall(150,700,550,20);
		
		score = 0;
		gameOver = false;
		
		//添加键盘点击事件
		this.addKeyListener(this);
	
		//动态游戏过程
		timer = new Timer(10,new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					if(!gameOver) {
						ball.move();
						
						//判定碰撞，矩形相交则为碰撞
						if(ball.getBounds().intersects(paddle.getBounds())) {
							ball.reverseX();
							score++;
						}
						
						for(Wall wall : walls) {
							if(ball.getBounds().intersects(wall.getBounds())) {
								if(wall == walls[0] || wall == walls[2]) {
									ball.reverseY();
								}else {
									ball.reverseX();
								}
							}
						}
						
						//check一下是否gameOver
						if(ball.getX() < 0 || ball.getY() > 800 || ball.getY() < 0 || ball.getY() > 800) {
							gameOver = true;
						}
					}
					repaint();
				}
				
		});
	}
	public void start() {
		timer.start();
	}
	public void stop() {
		timer.stop();
	}
	public void paint(Graphics g) {
		super.paint(g);
		
		ball.paint(g);
		paddle.paint(g);
		for(Wall wall : walls) {
			wall.draw(g);
		}
		//绘制左上角得分
		g.setColor(Color.WHITE);
		g.drawString("得分" + score,20,30);
		if(gameOver) {
			g.setColor(Color.RED);
			g.drawString("游戏结束!", 300, 400);
		}
	}

	public void keyTyped(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			paddle.moveUp();
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			paddle.moveDown();
		}
	}

	public void keyReleased(KeyEvent e) {
		
	}
}
