package weekyexam;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
/**
 *@author Vinh - T151487
 * 
 */
public class cWE14B_Prog01_T151487 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2061136282076970706L;

	public static void main(String[] args){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		cWE14B_Prog01_T151487 mainFrame = new cWE14B_Prog01_T151487();
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public cWE14B_Prog01_T151487(){
		setPreferredSize(new Dimension(400, 400));
		setTitle("T151487 – Fibonacci");
		setLayout(null);
		pack();
		
		initComponents();
	}
	
	JLabel lblInput = new JLabel("Input integer");
	JTextField txtInput = new JTextField();
	JButton btnCal = new JButton("Calculate"),
			btnClear = new JButton("Clear");
	JTextArea txtResult = new JTextArea();
	JScrollPane scrPane01 = new JScrollPane(txtResult);
	
	void initComponents(){
		add(lblInput);
		add(txtInput);
		add(btnCal);
		add(btnClear);
		add(scrPane01);
		//setBounds
		lblInput.setBounds(10,10,90,30);
		txtInput.setBounds(90, 10, 45, 30);
		btnCal.setBounds(170, 10, 80, 30);
		btnClear.setBounds(275, 10, 70, 30);
		scrPane01.setBounds(20, 50, 200, 200);
		txtResult.setEditable(false);
		
		btnCal.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				try {
					int n = Integer.parseInt(txtInput.getText());
					if(n >=0){
						String strResult = String.format("F(%d) = %f", n,f(n));
						txtResult.setText(strResult);
					}
					else{
						txtResult.setText("F(" + n + ") = n/a");
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Only integer number accepted");
				}
			}
		});
		
		btnClear.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				txtResult.setText("");
				txtInput.setText("");
			}
		});
	}
	
	double f(int n){
		if(n <= 0 ){
			return 1;
		}
		if( n == 1){
			return 1000000;
		}
		
		return Math.sqrt(f(n-1)*f(n-2)); 
	}
}
