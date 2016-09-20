package Beginner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class cDigitalClock_T151487 extends JFrame {

	JLabel lblTime = new JLabel("00:00:00");
	JButton btnStart = new JButton("Start");
	
	
	public static void main(String[] args){
		//new frame
		cDigitalClock_T151487 frame = new cDigitalClock_T151487();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//
		frame.setVisible(true);
	}
	
	public cDigitalClock_T151487(){
		//
		setSize(400,400);
		setTitle("T151487 - Digital Clock");
		setLayout(null);
		setLocation(1000,300);
	
		//add component
		add(lblTime);
		add(btnStart);
		//
		lblTime.setBounds(120,100,200,100);
		btnStart.setBounds(150,250,70,40);
		btnStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Timer t = new Timer(1000,new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Date now = new Date();
						SimpleDateFormat ft = new SimpleDateFormat("HH:mm:ss");
						lblTime.setText(ft.format(now));
					}
				});
				t.start();
			}
		});
	}
}
