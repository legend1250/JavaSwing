package Beginner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class STDI_Gui_with_String extends JFrame{
	//
	JLabel lblcount = new JLabel("N.o.Ws: ");
	JTextField txtinput = new JTextField(),  txtoutput = new JTextField(), txtcount = new JTextField();
	JButton btnals = new JButton("analyse"), btnclear = new JButton("clear");
	
	//main function
	public static void main(String[] args){
		//new windows
		STDI_Gui_with_String frame = new STDI_Gui_with_String();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//show the windows
		frame.setVisible(true);
		
		/*
		String s = "";
		for (int i = 0 ; i < 5 ; i++){
			s = s + "abc" + "\n";
		}
		System.out.print(s);
		*/
	}
	
	public STDI_Gui_with_String(){
		//
		setSize(600,400);
		setTitle("STDI_Gui_with_String");
		setLayout(null);
		setLocation(600,300);
		
		//add component
		//add(lblinput);
		add(txtinput);
		add(btnals);
		add(btnclear);
		add(lblcount);
		add(txtcount);
		add(txtoutput);
		//set location
		txtinput.setBounds(20,20,200,25);
		btnals.setBounds(20,50,100,25);
		btnclear.setBounds(140,50,70,25);
		lblcount.setBounds(20,80,100,25);
		txtcount.setBounds(140,80,70,25);
		txtoutput.setBounds(20,110,200,200);
		
		ActionListener button = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String input = txtinput.getText(),rtn = "";
				int count = 0,i;
				for ( i = 0 ; i < input.length() ; i++){
					rtn = rtn + input.charAt(i) + "\n";
				}
				
				if (arg0.getSource() == btnals){
					txtoutput.setText(rtn);
					txtcount.setText(Integer.toString(input.length()));
				}
				
				if(arg0.getSource() == btnclear){
					txtinput.setText("");
					txtcount.setText("");
					txtoutput.setText("");
				}
				
			}
		};
		btnals.addActionListener(button);
		btnclear.addActionListener(button);
	}
}
