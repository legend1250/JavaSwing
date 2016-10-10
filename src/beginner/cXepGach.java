package beginner;

import javax.swing.JFrame;

public class cXepGach extends JFrame{
	
	public static void main(String[] args){
		//new frame
		cXepGach frame = new cXepGach();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//show frame
		frame.setVisible(true);
		
	}
	
	cXepGachPanel brick = new cXepGachPanel();
	
	public cXepGach(){
		setSize(650,600);
		setTitle("Xep Gach");
		setLayout(null);
		setLocation(400,0);
		//
		add(brick);
		brick.setBounds(0,0,800,600);
	}
	
}
