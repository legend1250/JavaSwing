package Beginner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Calculator2 extends JFrame {
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

	JTextArea txtresult = new JTextArea();
	double x = 0, y = 0, z = 0;
	String str = "", output = "", str1 = "";
	boolean blAppend = false;
	String sOper = "", s1 = "";

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
		setLocation(1200, 100);

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
		txtresult.setEditable(false);

		ActionListener btnnum = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JButton btnT = (JButton) arg0.getSource();
				s1 = s1+btnT.getText();
				if( blAppend == true){
					txtresult.setText(s1);
				}
				else{
					x=Double.parseDouble(s1);
					txtresult.setText(s1);
				}
				
				
			}
		};

		ActionListener btncal = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JButton btnT = (JButton) arg0.getSource();
				sOper = btnT.getText();
				//x = Double.parseDouble(txtresult.getText());
				
				if (blAppend == false) {
					if (sOper == "+") {
						txtresult.setText(s1);
					}
				}
				else {
					if (sOper == "+"){
						s1=s1.substring(s1.indexOf("+")+1, s1.length());
						y=Double.parseDouble(s1);
						z=x+y+z;
						txtresult.setText(""+z);
						
					}
				}
			}
		};

		ActionListener acEqual = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				blAppend = false;
				double y = Double.parseDouble(txtresult.getText());
				// check sOper here
				if (sOper == "+") {
					z = x + y;
				} else if (sOper == "-") {
					z = x - y;
				} else if (sOper == "*") {
					z = x * y;
				} else if (sOper == "/") {
					z = x / y;
				}

				txtresult.setText("" + z);
			}
		};

		btn1.addActionListener(btnnum);
		btn2.addActionListener(btnnum);
		btn3.addActionListener(btnnum);
		btn4.addActionListener(btnnum);
		btn5.addActionListener(btnnum);
		btn6.addActionListener(btnnum);
		btn7.addActionListener(btnnum);
		btn8.addActionListener(btnnum);
		btn9.addActionListener(btnnum);
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
				z = 0;
				s1="";
				txtresult.setText("");
			}
		});

	}
}
