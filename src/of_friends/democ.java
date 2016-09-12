package of_friends;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * 
 */

/**
 * @author My Phan T153586
 */
public class democ extends JFrame {
	JTextField txtScreen = new JTextField();
	JButton btnN9 = new JButton("9"), btnN8 = new JButton("8"), btnN7 = new JButton("7"), btnN6 = new JButton("6"),
			btnN5 = new JButton("5"), btnN4 = new JButton("4"), btnN3 = new JButton("3"), btnN2 = new JButton("2"),
			btnN1 = new JButton("1"), btnN0 = new JButton("0"), btnC = new JButton("C"), btnCe = new JButton("CE"),
			btnA = new JButton("+"), btnS = new JButton("-"), btnD = new JButton("*"), btnM = new JButton("/"),
			btnMR = new JButton("MR"), btnMA = new JButton("M+"), btnMS = new JButton("M-"), btnMC = new JButton("MC"),
			btnSig = new JButton("-/+"), btnEqu = new JButton("=");

	public democ() {
		setTitle("Calculator");
		setSize(200, 350);
		setLayout(null);
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

		txtScreen.setHorizontalAlignment(JTextField.RIGHT);

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
		Insets marginButton = new Insets(1, 1, 1, 1);
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
		btnA.setMargin(marginButton);
		btnS.setMargin(marginButton);
		btnD.setMargin(marginButton);
		btnM.setMargin(marginButton);
		btnEqu.setMargin(marginButton);

		ActionListener all = new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// xuat chuoi ra man hinh textScreen
				JButton btnClicked = (JButton) e.getSource();
				String sClicked = btnClicked.getText();
				String sDisplay = txtScreen.getText();
				double[] a = new double[100];
				// neu click dau +, lay chuoi o textScreen chuyen thanh double
				// x1 va tiep tuc nhap mot chuoi khac
				if (btnClicked == btnA) {

					txtScreen.setText(sDisplay);
					String sInput = txtScreen.getText();
					double x1 = Double.parseDouble(sInput);
					a[1] = x1;

					JButton btnClicked2 = (JButton) e.getSource();
					String sClicked2 = btnClicked2.getText();
					String sDisplay2 = txtScreen.getText();

					// neu click dau =,lay chuoi o textScreen chuyen thanh
					// double x2, cong voi x1, xuat ra ket qua la chuoi o
					// textscreen
					if (btnClicked2 == btnEqu) {
						txtScreen.setText(sDisplay2);
						String sInput2 = txtScreen.getText();
						double x2 = Double.parseDouble(sInput2);
						a[2] = x2;
						double s = a[1] + a[2];
						String chuoi = s + "";
						txtScreen.setText(chuoi);
					} 
				}else
					sDisplay = sDisplay + sClicked;
				txtScreen.setText(sDisplay);
			}
		};
		btnN1.addActionListener(all);
		btnN0.addActionListener(all);
		btnN2.addActionListener(all);
		btnN3.addActionListener(all);
		btnN4.addActionListener(all);
		btnN5.addActionListener(all);
		btnN6.addActionListener(all);
		btnN7.addActionListener(all);
		btnN8.addActionListener(all);
		btnN9.addActionListener(all);
		btnA.addActionListener(all);
		btnS.addActionListener(all);
		btnD.addActionListener(all);
		btnM.addActionListener(all);
		btnEqu.addActionListener(all);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		democ main = new democ();
		main.setDefaultCloseOperation(EXIT_ON_CLOSE);
		main.setVisible(true);
	}

}
