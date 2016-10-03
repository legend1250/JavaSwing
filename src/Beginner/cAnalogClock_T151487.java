package Beginner;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class cAnalogClock_T151487 extends JFrame {

	// Define constants
	public static final int FRAME_WIDTH = 400;
	public static final int FRAME_HEIGHT = 400;
	private DrawClock clock;
	private int r = 250;
	private int w_h = 50; //weight and height
	private int x = w_h + r/2; 
	private int y = w_h + r/2;
	JLabel lbltime = new JLabel();
	Timer t;
	public cAnalogClock_T151487(){
		clock = new DrawClock();
		clock.setPreferredSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
		//
		Container cp = getContentPane();
		cp.add(clock);
		//
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		
		
		
		
		
		
	}
	
	private class DrawClock extends JPanel{
		JButton btnStart = new JButton("Start");
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			int x1 = x;
			int y1 = y-r/2;
			Date td = new Date();
			SimpleDateFormat sec = new SimpleDateFormat("ss");
			SimpleDateFormat now = new SimpleDateFormat("HH:mm:ss");
			int sec2 = Integer.parseInt(sec.format(td));
			x1 += Math.sin(Math.toRadians(360/60*sec2))*(r/2);
			y1 += (r/2)-Math.cos(Math.toRadians(360/60*sec2))*(r/2);
			g.drawOval(w_h, w_h, r, r);
			g.drawLine(x, y, x1, y1);
			System.out.println("x1: "+x1+"\ty1: "+y1 +"\ttime: " +now.format(td));
			lbltime.setText(now.format(td));
		}
		
		public DrawClock(){
			//
			setLayout(null);
			//
			add(btnStart);
			add(lbltime);
			
			btnStart.setBounds(x-30,0,70,30);
			lbltime.setBounds(FRAME_WIDTH-80,FRAME_HEIGHT-80,60,30);
			
			btnStart.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if (btnStart.getText().equals("Start")){
						t.start();
						btnStart.setText("Stop");
					}
					else{
						t.stop();
						btnStart.setText("Start");
					}
					
				}
			});
			t = new Timer(1000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					repaint();
				}
			});
		}
	}
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new cAnalogClock_T151487();
			}
		});
	}
}
