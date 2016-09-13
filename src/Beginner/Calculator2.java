package Beginner;

/*
 * @author: Vinh Nguyen
 */

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

	JTextArea txtresult = new JTextArea(), txtfom = new JTextArea();
	double x = 0, y = 0, z = 0;
	String s1 = "", s2 = "", s3 = "",x1="",fml="";
	boolean blAppend = false;
	boolean addCal = false;
	boolean blEqual = false;
	boolean getCal = false;
	String sOper = "", sOper2 = "";
	double m = 0;

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
				setFml(btnT.getText(),false);
				if (blAppend == true) {
					s1 = txtresult.getText() + s1;
					txtresult.setText(s1);
				} else {
					txtresult.setText(s1);
					blAppend = true;
				}
				if (blEqual == true) {
					y = Double.parseDouble(s1);
				}
				getFml();
			}
			
			
		};
		
		ActionListener btncal = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				blAppend = false;
				JButton btnT = (JButton) arg0.getSource();
				sOper = btnT.getText();
				
				if (addCal == false) {
					addCal = true; // da co phep tinh
					x = Double.parseDouble(txtresult.getText()); // parseDouble
																	// tu chuoi
																	// nhap vao
					sOper2 = sOper; // lay phep tinh
					s1 = null; // number need to input
					System.out.println("addCal = false, cal = " + sOper);
					setFml(sOper,false);
				} else {
					y = Double.parseDouble(txtresult.getText());
					//System.out.println("sOper2: " + sOper2);
					//System.out.println("addCal = true");
					if (s1 != null) { // number need to input must have
						System.out.println("s1: " + s1);
						if (sOper2 == "+") {
							System.out.println(x + " + " + y + " = " + (x + y));
							x = x + y;
						} else if (sOper2 == "-") {
							System.out.println(x + " - " + y + " = " + (x - y));
							x = x - y;
						} else if (sOper2 == "*") {
							System.out.println(x + " x " + y + " = " + (x * y));
							x = x * y;
						} else if (sOper2 == "/") {
							System.out.println(x + " / " + y + " = " + (x / y));
							x = x / y;
						}
						fml = getFml() + sOper;
						setFml(sOper,true);
						s1 = null; // after calculating, number (s1) = null;
					} else { // must have number to calculate
						System.out.println("There is no number for calculating, return 0 \nPlease, input a number");
						setFml(sOper,true);
						//System.out.println("s2:"+s2);
					}
					sOper2 = sOper;
					txtresult.setText("" + x);
					blEqual = false;
					
				}
				txtfom.setText(s2);
				getFml();

			}
		};

		ActionListener acEqual = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// check sOper here
				
				if (txtresult.getText().length() != 0) {
					
					if (blEqual == false) {// equal first time
						y = Double.parseDouble(txtresult.getText());
						if (sOper2 == "+") {
							x = x + y;
						} else if (sOper2 == "-") {
							x = x - y;
						} else if (sOper2 == "*") {
							x = x * y;
						} else if (sOper2 == "/") {
							x = x / y;
						}
						else{
							x =  Double.parseDouble(txtresult.getText());
						}
						blEqual = true; // move to equal next time (y = new
										// value get from bntnum function)
						
					} else {
						if (sOper2 == "+") {
							x = x + y;
						} else if (sOper2 == "-") {
							x = x - y;
						} else if (sOper2 == "*") {
							x = x * y;
						} else if (sOper2 == "/") {
							x = x / y;
						}
						
					}
					
					txtresult.setText("" + x);
					fml = txtresult.getText();
					getFml();
				}
				blAppend = false;
				addCal = false;

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
				z = 0;
				sOper = "";
				sOper2 = "";
				txtresult.setText("");
				txtfom.setText("");
				fml="";
			}
		});
		// new jre
	}
	public final void setFml(String x, boolean getCal){//str is num or cal ...
		if (getCal == false){
			fml = fml + x;
			//System.out.println("fml 1:     "+fml);
		}
		else{
//			char[] m = {'+','-','*','/'};
//			for (int i = 0 ; i < m.length ; i++){
//				fml = fml.substring(0, fml.lastIndexOf(m[i]))+x;
//			}
			//fml = getFml();
			//fml = fml + x;
			//System.out.println("x: "+x.charAt(0));
			
			fml = fml.substring(0, fml.length()-1)+x;
			//System.out.println("fml 2: "+fml);
			
		}
		
	}
	
	public final String getFml(){ //x is the final num or cal...
		System.out.println(fml);
		return fml;
	}
	
	
}
