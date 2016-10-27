package chartPractices;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class cProg04_SimplePieChart_T151487 extends JFrame{

	public static void main(String[] args){
		cProg04_SimplePieChart_T151487 f = new cProg04_SimplePieChart_T151487();
		f.setVisible(true);
		double d = 5.6;
		System.out.println((int) d);
	}
	
	private static int FRAME_WIDTH = 600, FRAME_HEIGHT = 600;
	
	public cProg04_SimplePieChart_T151487(){
		setTitle("T151487 – Simple Network Calculator");
		setPreferredSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLayout(null);
		setLocationRelativeTo(null);
		
		initCmp();
	}
	
	JLabel lblInput[] = new JLabel[3];
	JTextField txtInput[] = new JTextField[3];
	JButton btnDraw = new JButton("Draw");
	String sColor[] = {"RED","BLUE","GREEN","PINK","ORANGE","CYAN","YELLOW","LIGHT_GRAY"};
	JComboBox<String> cmbColor01 = new JComboBox<String>(sColor);
	JComboBox<String> cmbColor02 = new JComboBox<String>(sColor);
	
	JComboBox<String> cmbColor03 = new JComboBox<String>(sColor);
	cProg04_SimplePieChart_Panel01_T151487 panel01 = new cProg04_SimplePieChart_Panel01_T151487();
	
	private void initCmp(){
		for(int i = 0 ; i < 3 ;i++){
			lblInput[i] = new JLabel("A"+(i+1));
			add(lblInput[i]);
			lblInput[i].setBounds(55 + 120*i , 20 , 60,30);
			txtInput[i] = new JTextField();
			add(txtInput[i]);
			txtInput[i].setBounds(30 + 120*i , 50 , 60,30);
		}
		add(cmbColor01);
		add(cmbColor02);
		add(cmbColor03);
		cmbColor01.setBounds(30, 90, 80, 30);
		cmbColor02.setBounds(150, 90, 80, 30);
		cmbColor02.setSelectedIndex(1);
		cmbColor03.setBounds(270, 90, 80, 30);
		cmbColor03.setSelectedIndex(2);
		add(btnDraw);
		btnDraw.setBounds(400,50,70,30);
		add(panel01);
		panel01.setBounds(0, 150, FRAME_WIDTH, 400);
		
		btnDraw.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String s1 = txtInput[0].getText();
				String s2 = txtInput[1].getText();
				String s3 = txtInput[2].getText();
				
				if(chkTxt(s1) && chkTxt(s2) && chkTxt(s3)){
					int x1 = Integer.parseInt(s1);
					int x2 = Integer.parseInt(s2);
					int x3 = Integer.parseInt(s3);
					panel01.setX1(x1);
					panel01.setX2(x2);
					panel01.setX3(x3);
					panel01.setC1(cmbColor01.getSelectedIndex());
					panel01.setC2(cmbColor02.getSelectedIndex());
					panel01.setC3(cmbColor03.getSelectedIndex());
					panel01.doDraw = true;
					panel01.repaint();
				}
				else{
					JOptionPane.showMessageDialog(null, "Invalid input");
				}
			}
		});
	}
	
	private boolean chkTxt(String s){
		
		if(!cStringLib.isIntegerNumbers(s)){
			return false;
		}
		else{
			if(Integer.parseInt(s) < 0){
				return false;
			}
		}
		return true;
	}
	
}
