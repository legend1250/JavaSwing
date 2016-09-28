package MrNamVu;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 
 */

/**
 * @author KTTH
 * 
 */
public class cWindowDemo_SwingComponent_Calculator extends JFrame {
	JTextField txtScreen = new JTextField("0");
	JButton btnN9 = new JButton("9"), 
			btnN8 = new JButton("8"),
			btnN7 = new JButton("7"), 
			btnN6 = new JButton("6"),
			btnN5 = new JButton("5"), 
			btnN4 = new JButton("4"),
			btnN3 = new JButton("3"), 
			btnN2 = new JButton("2"),
			btnN1 = new JButton("1"), 
			btnN0 = new JButton("0"),
			btnC = new JButton("C"), 
			btnCe = new JButton("CE"),
			btnA = new JButton("+"), // add
			btnS = new JButton("-"), // sub
			btnD = new JButton("*"), // div
			btnM = new JButton("/"), // mul
			btnMR = new JButton("MR"), // mul
			btnMA = new JButton("M+"), // mul
			btnMS = new JButton("M-"), // mul
			btnMC = new JButton("MC"), // mul
			btnSig = new JButton("-/+"), 
			btnEqu = new JButton("=");

	double a = 0;
	double m = 0;

	public cWindowDemo_SwingComponent_Calculator() {
		// set title for the window
		setTitle("Calculator");
		// set the size of the window
		setSize(180, 340);
		// set layout null
		setLayout(null);

		// add components
		add(txtScreen);
		add(btnN0);
		add(btnN1);
		add(btnN2);
		add(btnN3);
		add(btnN4);
		add(btnN5);
		add(btnN6);
		add(btnN7);
		add(btnN8);
		add(btnN9);
		add(btnCe);
		add(btnC);
		add(btnA);
		add(btnS);
		add(btnM);
		add(btnD);
		add(btnSig);
		add(btnEqu);
		add(btnMR);
		add(btnMA);
		add(btnMS);
		add(btnMC);
		
		//
		txtScreen.setHorizontalAlignment(JTextField.RIGHT);
		// set location
		txtScreen.setBounds(10, 10, 155, 35);
		btnN7.setBounds(10, 90, 35, 35);
		btnN8.setBounds(50, 90, 35, 35);
		btnN9.setBounds(90, 90, 35, 35);
		btnA.setBounds(130, 90, 35, 35);
		btnN4.setBounds(10, 130, 35, 35);
		btnN5.setBounds(50, 130, 35, 35);
		btnN6.setBounds(90, 130, 35, 35);
		btnS.setBounds(130, 130, 35, 35);
		btnN1.setBounds(10, 170, 35, 35);
		btnN2.setBounds(50, 170, 35, 35);
		btnN3.setBounds(90, 170, 35, 35);
		btnM.setBounds(130, 170, 35, 35);
		btnN0.setBounds(10, 210, 35, 35);
		btnSig.setBounds(50, 210, 35, 35);
		btnEqu.setBounds(90, 210, 35, 35);
		btnD.setBounds(130, 210, 35, 35);
		btnMR.setBounds(10, 250, 35, 35);
		btnMA.setBounds(50, 250, 35, 35);
		btnMS.setBounds(90, 250, 35, 35);
		btnMC.setBounds(130, 250, 35, 35);
		// define action listener for events
		btnN1.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtScreen.setText("1");
			}
		});
		
		btnN2.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String sDisplay = txtScreen.getText();
				sDisplay = sDisplay + "2";
				txtScreen.setText(sDisplay);
			}
		});
		
		ActionListener alNumber = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JButton btnClicked = (JButton) e.getSource();
				String sClicked = btnClicked.getText();
				
				String sDisplay = txtScreen.getText();
				sDisplay = sDisplay + sClicked;
				txtScreen.setText(sDisplay);
			}
		};
		
		btnN3.addActionListener(alNumber);
		btnN4.addActionListener(alNumber);
		btnN5.addActionListener(alNumber);
		btnN6.addActionListener(alNumber);
		btnN7.addActionListener(alNumber);
		btnN8.addActionListener(alNumber);
		btnN9.addActionListener(alNumber);
		btnN0.addActionListener(alNumber);
		
		//update the margin for TEXT-DISPLAYING
		/*Insets marginButton = new Insets(10,10,10,10);
		btnN7.setMargin(marginButton);
		btnN8.setMargin(marginButton);
		btnN9.setMargin(marginButton);
		btnN4.setMargin(marginButton);
		btnN5.setMargin(marginButton);
		btnN6.setMargin(marginButton);
		btnN1.setMargin(marginButton);
		btnN2.setMargin(marginButton);
		btnN3.setMargin(marginButton);
		btnN0.setMargin(marginButton);
		*/
		
		// action

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// new window
		cWindowDemo_SwingComponent_Calculator wMain = new cWindowDemo_SwingComponent_Calculator();
		// end program as closing window.
		wMain.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// show the window
		wMain.setVisible(true);
	}

}
