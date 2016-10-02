package Beginner;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class cSimpleController2 extends JFrame {
	
	JButton btnX = new JButton();
	
	public static void main(String[] args) {
		// new frame
		cSimpleController2 frame = new cSimpleController2();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// show frame
		frame.setVisible(true);
	}

	

	public cSimpleController2() {
		button A = new button();
		button B = new button();
		button C = new button();
		setSize(600, 600);
		setLayout(null);
		setTitle("SimpleController 2");
		
		//add component
		this.add(A);
		A.btnX.setText("A");
		A.setBounds(0,0,200,getHeight());
		this.add(B);
		B.btnX.setText("B");
		B.setBounds(200,0,200,getHeight());
		this.add(C);
		C.btnX.setText("C");
		C.setBounds(400,0,200,getHeight());
	}
}

class button extends JPanel {

	JButton btnX = new JButton();
	Timer tm1;
	int x = 0, y = 0;
	
	
	public button() {
		
		// TODO Auto-generated constructor stub
		add(btnX);
		//
		btnX.setBounds(x,y,70,30);
		//btnX.setFocusable(false);
		
		KeyListener down = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if (arg0.getKeyCode() == KeyEvent.VK_A && btnX.getText().equals("A")) {
					startmv();
				}
				if (arg0.getKeyCode() == KeyEvent.VK_B && btnX.getText().equals("B")) {
					startmv();
				}
				if (arg0.getKeyCode() == KeyEvent.VK_C && btnX.getText().equals("C")) {
					startmv();
				}
				
			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}
		};
		tm1 = new Timer(100, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int y1 = btnX.getY();
				if (y1 < getHeight() - 40){
					y1+=5;
				}
				else{
					tm1.stop();
					y1=0;
				}
				btnX.setLocation(btnX.getX(),y1);
			}
		});
		
		btnX.addKeyListener(down);
	}
	
	
	

	public void startmv() {
		System.out.println("move");
		tm1.start();
	}
}
