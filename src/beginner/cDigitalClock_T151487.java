package beginner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.*;

public class cDigitalClock_T151487 extends JFrame {

	JLabel lblTime = new JLabel();
	JButton btnStart = new JButton("Start");
	

	public static void main(String[] args) {
		// new frame
		cDigitalClock_T151487 frame = new cDigitalClock_T151487();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//
		frame.setVisible(true);
	}

	public cDigitalClock_T151487() {
		setSize(400,400);
		setTitle("T151487 - Digital Clock");
		setLayout(null);
		setLocation(1000, 300);

		// add component 
		add(lblTime);
		//add(btnStart); 
		lblTime.setBounds(120, 100, 200, 100);
		Timer t = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODOAuto-generated method stub
				Date now = new Date();
				SimpleDateFormat ft = new SimpleDateFormat("HH:mm:ss");
				SimpleDateFormat hour = new SimpleDateFormat("HH");
				SimpleDateFormat min = new SimpleDateFormat("mm");
				SimpleDateFormat sec = new SimpleDateFormat("ss");
				lblTime.setText(ft.format(now));
			}
		});
		t.start();
	}

}
