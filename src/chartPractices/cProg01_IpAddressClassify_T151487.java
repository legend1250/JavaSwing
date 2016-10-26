package chartPractices;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class cProg01_IpAddressClassify_T151487 extends JFrame{
	
	public static void main(String[] args){
		cProg01_IpAddressClassify_T151487 f = new cProg01_IpAddressClassify_T151487();
		f.setVisible(true);
		
	}

	private static int FRAME_WIDTH = 600, FRAME_HEIGHT = 600;
	
	public cProg01_IpAddressClassify_T151487(){
		setTitle("T151487 – Simple Network Calculator");
		setPreferredSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setLayout(null);
		initCmp();
	}
	
	JTextField txtInputAddress = new JTextField();
	JTextArea 	txtOutputA = new JTextArea(), txtOutputB = new JTextArea(),
				txtOutputC = new JTextArea();
	JButton btnAdd = new JButton("Add");
	
	public void initCmp(){
		setLayout(null);
		add(txtInputAddress);
		add(txtOutputA);
		add(txtOutputB);
		add(txtOutputC);
		add(btnAdd);
		//set location
		txtInputAddress.setBounds(50, 20, 150, 30);
		txtOutputA.setBounds(30, 100, 120, 180);
		txtOutputB.setBounds(230, 100, 120, 180);
		txtOutputC.setBounds(430, 100, 120, 180);
		txtOutputA.setEditable(false);
		txtOutputB.setEditable(false);
		txtOutputC.setEditable(false);
		btnAdd.setBounds(220, 20, 65, 30);
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String s1 = txtInputAddress.getText();
				String s[] = new String[4];
				s = s1.split("\\.");
				if(s.length == 4){
					if(chkString(s)){
						int x0 = Integer.parseInt(s[0]);
						int x1 = Integer.parseInt(s[1]);
						int x2 = Integer.parseInt(s[2]);
						int x3 = Integer.parseInt(s[3]);
						
						if( x0>=1 || x0<=126){
							if(x1 > 0 || x2 > 0 || x3 >0){
								errorJOp();
							}
							else{
								txtOutputA.append(s1 + "\n");
							}
							
						}
						else if ((x0 >= 128 && x1 >= 1) || (x0 <= 191 && x1 <= 254)){
							txtOutputB.append(s1 + "\n");
						}
						//else if( (x0>= 192 && x1 == 0 && )
					}
				}
				else{
					errorJOp();
				}
			}
		});
		
	}
	
	public void errorJOp(){
		JOptionPane.showMessageDialog(null, "This IP Adress is invalid");
		return;
	}
	
	public boolean chkString(String[] s){
		for(int i = 0 ; i < 4 ; i++){
			if(!cStringLib.isIntegerNumbers(s[i])){
				return false;
			}
			else{
				int x = Integer.parseInt(s[i]);
				if( x < 1 || x > 255){
					return false;
				}
			}
		}
		
		return true;
	}
}
