package Beginner;

/*
 * @author: Vinh Nguyen
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Calculator3 extends JFrame {
	//

	JButton btnMC = new JButton("MC"), btnM1 = new JButton("M+"),
			btnM2 = new JButton("M-"), btnMR = new JButton("MR");
	JButton btnC = new JButton("C"), btncongtru = new JButton("+/-"),
			btnchia = new JButton("/"), btnnhan = new JButton("*");
	JButton btn7 = new JButton("7"), btn8 = new JButton("8"),
			btn9 = new JButton("9"), btntru = new JButton("-");
	JButton btn4 = new JButton("4"), btn5 = new JButton("5"),
			btn6 = new JButton("6"), btncong = new JButton("+");
	JButton btn1 = new JButton("1"), btn2 = new JButton("2"),
			btn3 = new JButton("3"), btnequal = new JButton("=");
	JButton btn0 = new JButton("0"), btnphay = new JButton(".");

	JTextArea txtresult = new JTextArea(), txtfom = new JTextArea();
	double x = 0, y = 0, z = 0;
	String s1 = "", fml = "";
	String sOper = "";
	boolean blAppend, addCal = false;
	boolean firstCal = true;

	public static void main(String[] args) {
		// new frame
		Calculator3 frame = new Calculator3();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// show window
		frame.setVisible(true);
	}

	public Calculator3() {
		//
		setSize(250, 500);
		setTitle("Calculator");
		setLayout(null);
		setLocation(1000, 100);

		//
		add(btnMC);
		add(btnM1);
		add(btnM2);
		add(btnMR);
		add(btnC);
		add(btncongtru);
		add(btnchia);
		add(btnnhan);
		add(btn7);
		add(btn8);
		add(btn9);
		add(btntru);
		add(btn4);
		add(btn5);
		add(btn6);
		add(btncong);
		add(btn1);
		add(btn2);
		add(btn3);
		add(btnequal);
		add(btn0);
		add(btnphay);
		add(txtresult);
		// add(txtfom);

		// set Location
		btnMC.setBounds(0, 0, 60, 60);
		btnM1.setBounds(60, 0, 60, 60);
		btnM2.setBounds(120, 0, 60, 60);
		btnMR.setBounds(180, 0, 60, 60);
		btnC.setBounds(0, 60, 60, 60);
		btncongtru.setBounds(60, 60, 60, 60);
		btnchia.setBounds(120, 60, 60, 60);
		btnnhan.setBounds(180, 60, 60, 60);
		btn7.setBounds(0, 120, 60, 60);
		btn8.setBounds(60, 120, 60, 60);
		btn9.setBounds(120, 120, 60, 60);
		btntru.setBounds(180, 120, 60, 60);
		btn4.setBounds(0, 180, 60, 60);
		btn5.setBounds(60, 180, 60, 60);
		btn6.setBounds(120, 180, 60, 60);
		btncong.setBounds(180, 180, 60, 60);
		btn1.setBounds(0, 240, 60, 60);
		btn2.setBounds(60, 240, 60, 60);
		btn3.setBounds(120, 240, 60, 60);
		btnequal.setBounds(180, 240, 60, 120);
		btn0.setBounds(0, 300, 120, 60);
		btnphay.setBounds(120, 300, 60, 60);
		txtresult.setBounds(0, 360, 300, 60);
		txtfom.setBounds(0, 420, 300, 60);
		txtresult.setEditable(false);
		txtfom.setEditable(false);

		ActionListener btnnum = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JButton btnT = (JButton) arg0.getSource();
				s1 = btnT.getText();
				pressNumber(s1);
			}

		};

		ActionListener btncal = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JButton btnT = (JButton) arg0.getSource();
				sOper = btnT.getText();
				x = Double.parseDouble(txtresult.getText());
				addCal(sOper,x);
				
			}
		};

		ActionListener acEqual = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

			}
		};

		KeyListener pressnum = new KeyListener() {

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
				char num[] = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
				for (int i = 0; i < num.length; i++) {
					if (e.getKeyChar() == num[i]) {
						pressNumber("" + num[i]);
						// setFml(num[i]+"",false);
						// getFml();
					}
				}
				// System.out.println("a");
			}

		};
		this.addKeyListener(pressnum);
		for (int i = 0; i < this.getContentPane().getComponentCount(); i++) {
			this.getContentPane().getComponent(i).addKeyListener(pressnum);
		}

		btn1.addActionListener(btnnum);
		btn2.addActionListener(btnnum);
		btn3.addActionListener(btnnum);
		btn4.addActionListener(btnnum);
		btn5.addActionListener(btnnum);
		btn6.addActionListener(btnnum);
		btn7.addActionListener(btnnum);
		btn8.addActionListener(btnnum);
		btn9.addActionListener(btnnum);
		btn0.addActionListener(btnnum);
		btnphay.addActionListener(btnnum);
		btncong.addActionListener(btncal);
		btntru.addActionListener(btncal);
		btnnhan.addActionListener(btncal);
		btnchia.addActionListener(btncal);
		btnequal.addActionListener(acEqual);
		btnC.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				x = 0;
				y = 0;
				txtresult.setText("");
				txtfom.setText("");
				fml = "";
			}
		});

	}

	public void pressNumber(String snum) {
		String sLocal = snum;
		if (blAppend == true) {
			sLocal = txtresult.getText() + sLocal;
			txtresult.setText(sLocal);
		} else {
			txtresult.setText(sLocal);
			blAppend = true;
		}
		addCal = false;
		setFml(snum);
	}

	public void setFml(String a) {
		fml = fml + a;
		System.out.println("fml: " + fml);
	}

	public void addCal(String sOper,double x) {
		if (!addCal) {
			setFml(sOper);
			blAppend = false;
			addCal = true;
		} else {
			fml = fml.substring(0, fml.length() - 1) + sOper;
			System.out.println("fml: " + fml);
		}
		getCal(sOper);
	}

	public String getCal(String sOper) {
		this.sOper = sOper;
		return sOper;
	}

	public void calculating(double x) {
		if(firstCal){
			
			firstCal = false;
		}
		else{
			this.y = x;
			
		}
	}

}
