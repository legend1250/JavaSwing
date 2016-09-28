package Beginner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class cRobotDemo extends JFrame{
	
	public static void main(String[] args){
		//
		cRobotDemo frame = new cRobotDemo();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//
		frame.setVisible(true);
	}
	
	ImageIcon img;
	
	JLabel lblpic = new JLabel();
	int i = 0;
	int PicX = -20;
	int Width = 600, Height = 600;
	JButton btnStart = new JButton("Start");
	Timer t;
	public cRobotDemo(){
		//
		
		setSize(Width,Height);
		setTitle("Robot - Demo");
		setLayout(null);
		
		//
		add(lblpic);
		add(btnStart);
		
		//set location
		lblpic.setBounds(PicX,50,180,180);
		btnStart.setBounds(70,250,70,35);
		
		//add pic
		img = new ImageIcon("./imgs/aFrame0"+i+".gif");
		lblpic.setIcon(img);
		t = new Timer(100, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(i>15){
					i=0;
				}
				if ( i < 10){
					img = new ImageIcon("./imgs/aFrame0"+i+".gif");
				}
				if ( i >= 10){
					img = new ImageIcon("./imgs/aFrame"+i+".gif");
				}
				lblpic.setIcon(img);
				if (PicX > Width-80){
					PicX = -70;
				}else{
					PicX +=5;
				}
				
				lblpic.setBounds(PicX,50,180,180);
				System.out.println(img);
				i++;
				
			}
		});
		btnStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JButton btnS = (JButton) e.getSource();
				if (btnS.getText().equals("Start")){
					btnS.setText("Stop");
					t.start();
				}
				else{
					t.stop();
					btnS.setText("Start");
				}
			}
		});
		/*img = new ImageIcon("./imgs/aFrame0"+i+".gif");
		lblpic.setIcon(img);
		lblpic.setBounds(50,50,180,180);
		*/
	}
}
