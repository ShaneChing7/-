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
		setTitle("������Ϸ");
		setSize(800,800);
		//С��λ���������
		Random r = new Random(0);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//��ʼ��Ϸ
		start_btn = new JButton("��ʼ");
		start_btn.setBounds(100, 0, 50, 50);
		start_btn.setBackground(Color.BLACK);
		start_btn.setForeground(Color.RED);
		start_btn.setBorder(null);
		start_btn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				gameCanvas.start();
				//����Canvas��ͼ��
				gameCanvas.requestFocus();
			}
			
		});
		this.add(start_btn);
		
		//�ؿ�һ��
		reset_btn = new JButton("����");
		reset_btn.setBounds(150, 0, 50, 50);
		reset_btn.setBackground(Color.BLACK);
		reset_btn.setForeground(Color.RED);
		reset_btn.setBorder(null);
		reset_btn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(gameCanvas.gameOver) {
					gameCanvas.gameOver = false;
				}
				//�ؿ���ʼ�����������С��
				int x = r.nextInt(550) + 70;
				int y = r.nextInt(500) + 70;
				gameCanvas.score = 0;
				gameCanvas.ball = new Ball(x,y);
				//���ý�����λ��
				gameCanvas.paddle = new Paddle(50,350);
				//����ˢ�»�ͼ
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
