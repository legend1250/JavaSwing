package weekyexam;
/*
 * @author: Vinh Nguyen - T151487
 */
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class cWE06A_Prog02_T151487 extends JFrame{

	public static void main(String[] args){
		cWE06A_Prog02_T151487 f = new cWE06A_Prog02_T151487();
		f.setVisible(true);
	}
	
	cWE06A_Prog02_T151487_Panel01 panel01 = new cWE06A_Prog02_T151487_Panel01();
	cRectangle_Data rect_data = new cRectangle_Data();
	
	JLabel lblInputnum = new JLabel("Input number of RECTANGE: ");
	JTextField txtInputnum = new JTextField();
	JButton btnDisplay = new JButton("Display");
	
	public cWE06A_Prog02_T151487(){
		setPreferredSize(new Dimension(600,600));
		setTitle("T151487 - Simple Rectangle");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		initializeCmp();
		add(panel01);
		panel01.setBounds(0,100,500,500);
	}
	
	public void initializeCmp(){
		setLayout(null);
		//
		add(lblInputnum);
		add(txtInputnum);
		add(btnDisplay);
		//
		lblInputnum.setBounds(30,30,180,30);
		txtInputnum.setBounds(230,30,50,30);
		btnDisplay.setBounds(350,30,80,30);
		
		btnDisplay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String num = txtInputnum.getText();
				int iNum = 0;
				if(cStringLib.isIntegerNumbers(num)){
					iNum = Integer.parseInt(num);
					rect_data.init(iNum);
					panel01.doDraw = true;
					panel01.repaint();
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrect Integer number");
				}
			}
		});
	}
}
