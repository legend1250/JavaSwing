package Beginner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class cSimpleController2 extends JFrame{

	public void main(String[] args) {
		button A = new button();
		A.btnX.setText("A");
		A.start();
	}
}

class button extends JPanel {

	JButton btnX = new JButton();
	Timer tm1;
	int x = 30, y = 0;

	public button() {
		// add
		add(btnX);
		// set location
		btnX.setBounds(x, y, 70, 30);
		//
		tm1 = new Timer(100, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int y = btnX.getY();
				y += 5;
				if (y >= getHeight()) {
					tm1.stop();
					y = 0;
				}
				btnX.setLocation(x, y);
			}
		});

		KeyListener down = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if (arg0.getKeyCode() == KeyEvent.VK_A) {
					start();
				}
			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}
		};

	}

	public void start() {
		tm1.stop();
	}
}
