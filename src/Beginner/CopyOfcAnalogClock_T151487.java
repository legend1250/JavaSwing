package Beginner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class CopyOfcAnalogClock_T151487 extends JFrame {
	
	cClockSample panel = new cClockSample();
	JLabel lbltime = new JLabel();
	
	public CopyOfcAnalogClock_T151487(){
		setSize(500,500);
		setTitle("CopyOfcAnalogClock_T151487");
		setLocation(1200,100);
		setLayout(null);
		//
		add(panel);
		add(lbltime);
		//
		lbltime.setBounds(400,400,50,25);
		panel.setBounds(0,0,400,400);
		Timer t = new Timer(1000,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.r = 250;
				panel.w_h = 70;
				//panel.x = panel.w_h + panel.r/2;
				//panel.y = panel.w_h + panel.r/2;
				repaint();
				
				//
				Date td = new Date();
				SimpleDateFormat now = new SimpleDateFormat("HH:mm:ss");
				lbltime.setText(now.format(td));
			}
			
		});
		t.start();
		
	}
	
	
	public static void main(String[] args){
		//new frame
		CopyOfcAnalogClock_T151487 frame = new CopyOfcAnalogClock_T151487();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//show
		frame.setVisible(true);
	}
}
