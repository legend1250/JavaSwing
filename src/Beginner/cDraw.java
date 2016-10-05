package Beginner;

import javax.swing.JFrame;


public class cDraw extends JFrame{
	
	public static void main(String[] args){
		//new frame
		cDraw frame = new cDraw();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//
		frame.setVisible(true);
		
		System.out.println(36%10);
	}
	
	cDraw2 panel = new cDraw2();
	
	public cDraw(){
		setSize(400,400);
		setTitle("Windows");
		
		//add
		this.add(panel);
		panel.setBounds(0,0,400,400);
		
	}
}
