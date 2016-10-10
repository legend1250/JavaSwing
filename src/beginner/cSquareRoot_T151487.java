package beginner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/*
 * @author: Vinh Nguyen
 */

public class cSquareRoot_T151487 extends JFrame {
	JLabel txt_input = new JLabel("Nhập số: "), txt_chonsaiso = new JLabel("Chọn sai số: ");
	JTextField txt_inputnum = new JTextField();
	String ss[] = {"1","2","3","4","5","6","7","8","9"};
	JComboBox<String> cmb_saiso = new JComboBox(ss);
	JButton btnTinh = new JButton("Tính"), btnXoa = new JButton("Xóa"), btnXoahet = new JButton("Xóa hết");
	JTextArea txt_result = new JTextArea();
	
	int i = 1; 
	double tolerance_number=0;
	String result = "",saiso = "";
	public static void main(String[] args) {
		// new frame
		cSquareRoot_T151487 frame = new cSquareRoot_T151487();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// show window
		frame.setVisible(true);
	}
	
	public cSquareRoot_T151487() {
		//
		setSize(400, 450);
		setTitle("T151487 - Square Root ");
		setLayout(null);
		setLocation(1000, 100);
		
		//add component
		add(txt_input);
		add(txt_inputnum);
		add(txt_chonsaiso);
		add(cmb_saiso);
		add(btnTinh);
		add(btnXoa);
		add(btnXoahet);
		add(txt_result);
		//set
		txt_input.setBounds(10, 30, 70,25);
		txt_inputnum.setBounds(100,30,250,25);
		txt_chonsaiso.setBounds (90,75,120,25);
		cmb_saiso.setBounds(190,75,120,25);
		btnTinh.setBounds(30,130,70,35);
		btnXoa.setBounds(130,130,70,35);
		btnXoahet.setBounds(230,130,100,35);
		txt_result.setBounds(10,200,365,180);
		cmb_saiso.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JComboBox<String> cmbsaiso = (JComboBox<String>) arg0.getSource();
				saiso = cmbsaiso.getSelectedItem() + "";
				tolerance_number = (double) 1/Math.pow(10, Double.parseDouble(saiso));
			}
		});
		
		btnTinh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String num = txt_inputnum.getText();
				boolean isNum;
				isNum = cStringLib.isIntegerNumbers(num);
				if (isNum){
					double x = Double.parseDouble(num);
					double k = x/2,k2=0;
					while(Math.abs(k-k2)>tolerance_number){
						k2=k;
						k = (double) 1 / 2 * (k + x / k);
						System.out.println(tolerance_number);
					}
					result = result +i +". Sqrt("+num+") = " + k +"\n";
					txt_result.setText(result);
					i++;
				}
			}
		});
	}
	

}
