package beginner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Exercise04 extends JFrame{
	//
	JTextField txt01 = new JTextField(), txt02 = new JTextField(); 
	JButton btnplus = new JButton("+"), btnnhan = new JButton("*");
	JTextArea txtreturn = new JTextArea();
	JPasswordField pwd = new JPasswordField();
	public static void main(String[] args){
		//new frame
		Exercise04 frame = new Exercise04();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//set visibile
		frame.setVisible(true);
	}
	
	public Exercise04(){
		setSize(600,400);
		setTitle("Exercise04");
		setLayout(null);
		setLocation(600,300);
		
		//add component
		add(txt01);
		add(txt02);
		add(btnplus);
		add(btnnhan);
		add(txtreturn);
		add(pwd);
		
		//set location
		txt01.setBounds(20,20,200,25);
		txt02.setBounds(20,50,200,25);
		btnplus.setBounds(110,80,45,25);
		btnnhan.setBounds(170,80,40,25);
		txtreturn.setBounds(20,110,200,25);
		pwd.setBounds(400, 20,200,25);
		txtreturn.setEditable(false);
		ActionListener button = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int a = 0;
				String str1 = txt01.getText(), str2 = txt02.getText();
				boolean result1,result2;
				result1 = cStringLib.isNumberString(str1);
				result2 = cStringLib.isNumberString(str2);
				
				if (result1 == false || result2 == false){
					txtreturn.setText("NaN");
				}
				else{
					if (arg0.getSource() == btnplus ){
					a = Integer.parseInt(str1) + Integer.parseInt(str2);
					txtreturn.setText(Integer.toString(a));
					}
					if(arg0.getSource() == btnnhan){
						a = Integer.parseInt(str1) * Integer.parseInt(str2);
						txtreturn.setText(Integer.toString(a));
					}
				}
				
			}
			
		};
		
		btnplus.addActionListener(button);
		btnnhan.addActionListener(button);
	}
}
