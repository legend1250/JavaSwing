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
	
	ImageIcon img,img2;
	
	JLabel lblpic = new JLabel(), lblpic2 = new JLabel();
	
	int i = 0;
	int Width = 450, Height = 600;
	int PicX = -20;
	int PicX2 = Width-150;
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
		add(lblpic2);
		//set location
		lblpic.setBounds(PicX,50,180,180);
		lblpic2.setBounds(PicX2,300,180,180);
		btnStart.setBounds(70,250,70,35);
		
		//add pic
		img = new ImageIcon("./imgs/aFrame0"+i+".gif");
		lblpic.setIcon(img);
		img2 = new ImageIcon("./imgs/bFrame0"+i+".gif");
		lblpic2.setIcon(img2);
		
		t = new Timer(100, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(i>15){
					i=0;
				}
				if ( i < 10){
					img = new ImageIcon("./imgs/aFrame0"+i+".gif");
					img2 = new ImageIcon("./imgs/bFrame0"+i+".gif");
				}
				if ( i >= 10){
					img = new ImageIcon("./imgs/aFrame"+i+".gif");
					img2 = new ImageIcon("./imgs/bFrame"+i+".gif");
				}
				lblpic.setIcon(img);
				lblpic2.setIcon(img2);
				if (PicX > Width-80){
					PicX = -70;
				}else{
					PicX +=5;
				}
				if (PicX2 <= -80){
					PicX2 = Width;
				}
				else{
					PicX2 -= 5;
				}
				
				lblpic.setBounds(PicX,50,180,180);
				lblpic2.setBounds(PicX2,300,180,180);
				System.out.println(img +"  \t"+img2);
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
		
	}
}
