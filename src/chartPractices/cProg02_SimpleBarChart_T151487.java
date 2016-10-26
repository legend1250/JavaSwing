package chartPractices;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class cProg02_SimpleBarChart_T151487 extends JFrame{
	
	public static void main(String[] args){
		cProg02_SimpleBarChart_T151487 f = new cProg02_SimpleBarChart_T151487();
		f.setVisible(true);
		
	}
	
	private static int FRAME_WIDTH = 600, FRAME_HEIGHT = 600;
	
	public cProg02_SimpleBarChart_T151487(){
		setTitle("T151487 – Simple Network Calculator");
		setPreferredSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setLayout(null);
		//add cmp
		//initCmp();
		add(txtInput[0]);
		txtInput[0].setBounds(30, 30, 70, 30);
	}

	JTextField txtInput[] = new JTextField[12];
	JLabel lblInput[] = new JLabel[12];
	JTextField txtInput02 = new JTextField();
	JButton btnAdd = new JButton("Add");
	
	public void initCmp(){
		
		for(int i = 0 ; i < 6 ;i++){
			add(lblInput[i]);
			add(txtInput[i]);
			lblInput[i].setBounds(30 + 60*i, 100, 30, 30);
			lblInput[i].setText("lbl " +i);
		}
	
	}
	
	
}

