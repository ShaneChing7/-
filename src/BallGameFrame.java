import java.awt.Color;
import java.awt.event.*;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BallGameFrame extends JFrame{
	private GameCanvas gameCanvas;
	private JButton start_btn;
	private JButton reset_btn;
	
	public BallGameFrame(){
		setTitle("接球游戏");
		setSize(800,800);
		//小球位置随机生成
		Random r = new Random(0);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//开始游戏
		start_btn = new JButton("开始");
		start_btn.setBounds(100, 0, 50, 50);
		start_btn.setBackground(Color.BLACK);
		start_btn.setForeground(Color.RED);
		start_btn.setBorder(null);
		start_btn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				gameCanvas.start();
				//请求到Canvas绘图板
				gameCanvas.requestFocus();
			}
			
		});
		this.add(start_btn);
		
		//重开一把
		reset_btn = new JButton("重置");
		reset_btn.setBounds(150, 0, 50, 50);
		reset_btn.setBackground(Color.BLACK);
		reset_btn.setForeground(Color.RED);
		reset_btn.setBorder(null);
		reset_btn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(gameCanvas.gameOver) {
					gameCanvas.gameOver = false;
				}
				//重开初始化，随机生成小球
				int x = r.nextInt(550) + 70;
				int y = r.nextInt(500) + 70;
				gameCanvas.score = 0;
				gameCanvas.ball = new Ball(x,y);
				//重置接球板的位置
				gameCanvas.paddle = new Paddle(50,350);
				//重新刷新绘图
				gameCanvas.repaint();
				gameCanvas.stop();
				gameCanvas.requestFocus();
			}
			
		});
		this.add(reset_btn);
		
		gameCanvas = new GameCanvas();
		this.add(gameCanvas);
		this.setVisible(true);
	}
}
