package weekyexam;
/*
 * @author: Vinh Nguyen - T151487
 */
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class cWE04B_Prog01_T151487 extends JFrame{
	
	public static void main(String[] args){
		//new frame
		cWE04B_Prog01_T151487 frame = new cWE04B_Prog01_T151487();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//show frame
		frame.setVisible(true);
	}
	
	cWE04B_Prog01_JPanel prog01_Panel = new cWE04B_Prog01_JPanel();
	
	
	public cWE04B_Prog01_T151487(){
		//
		setSize(420,400);
		setTitle("T151487 – SimpleDrawing");
		setLayout(null);
		//
		add(prog01_Panel);
		prog01_Panel.setBounds(0,0,400,400);
		
	}
}
