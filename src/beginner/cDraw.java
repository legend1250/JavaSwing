package beginner;

import java.awt.Panel;

import javax.swing.JFrame;


public class cDraw extends JFrame{
	cDraw3 panelDraw = new cDraw3();
	
	public static void main(String[] args){
		//new frame
		cDraw frame = new cDraw();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//
		frame.setVisible(true);
		
	}
	
	
	
	public cDraw(){
		setSize(400,500);
		setTitle("Windows");
		
		//add
		this.add(panelDraw);
		panelDraw.setBounds(0,0,400,400);
		
	}
}
