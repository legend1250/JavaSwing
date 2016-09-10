package Beginner;

import javax.swing.*;

public class Calculator2 extends JFrame{
	
	JButton btnnum = new JButton(), btnM = new JButton(), btncal = new JButton();
	JButton btnequal = new JButton(), btnclear = new JButton();
	
	JTextArea txt_return = new JTextArea();
	
	public static void main(String[] args) {
		// new frame
		Calculator2 frame = new Calculator2();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// show window
		frame.setVisible(true);
	}

	public Calculator2() {
		//
		setSize(250, 500);
		setTitle("Exercise04");
		setLayout(null);
		//setLocation(0, 0);
		
		//add
		
		add(btnM,"M");
		
		//set location
		btnM.setBounds(0, 0, 60, 60);
	}

	

}
