package baikiemtra;
/*
 * @author: Vinh Nguyen - T151487
 */
import javax.swing.JFrame;

public class cWE04B_Prog02_T151487 extends JFrame{
	
	public static void main(String[] args){
		//new frame
		cWE04B_Prog02_T151487 frame = new cWE04B_Prog02_T151487();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//show frame
		frame.setVisible(true);
		
	}
	cWE04B_Prog02_JPanel prog02_panel = new cWE04B_Prog02_JPanel();
	
	public cWE04B_Prog02_T151487(){
		//
		setSize(420,400);
		setTitle("T151487 – SimpleDrawing");
		setLayout(null);
		//
		add(prog02_panel);
		prog02_panel.setBounds(0,0,400,400);
	}
}
