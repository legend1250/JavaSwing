package beginner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class cSimpleController extends JFrame {

	JButton btnA = new JButton("A"), btnB = new JButton("B"),
			btnC = new JButton("C"), btnX = new JButton();
	int x = 0, y = 0;
	boolean chk = false;
	Timer t;

	public static void main(String[] args) {
		// new frame
		cSimpleController frame = new cSimpleController();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// show frame
		frame.setVisible(true);
	}

	public cSimpleController() {
		setSize(400, 400);
		setTitle("SimpleController");
		setLayout(null);

		//
		add(btnA);
		add(btnB);
		add(btnC);

		//
		btnA.setBounds(30, 0, 70, 30);
		btnB.setBounds(150, 0, 70, 30);
		btnC.setBounds(270, 0, 70, 30);

		KeyListener move = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_A) {
					move(btnA);
					
				}
				if (e.getKeyCode() == KeyEvent.VK_B) {
					move(btnB);
					
				}
				if (e.getKeyCode() == KeyEvent.VK_C) {
					move(btnC);
				}
			}
		};

		btnA.addKeyListener(move);
		btnB.addKeyListener(move);
		btnC.addKeyListener(move);

	}

	public void move(JButton btnT) {
		this.btnX = btnT;
		t = new Timer(20, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int x1 = btnX.getX();
				int y1 = btnX.getY();
				if (y1 > getHeight() - 40) {
					t.stop();
					y1 = 0;
					chk = false;
					btnX.setLocation(x1, y1);
				} else {
					y1 += 2;
				}
				btnX.setLocation(x1, y1);
			}
		});
		if (!chk) {
			t.start();
			chk = true;
		}
	}
}
