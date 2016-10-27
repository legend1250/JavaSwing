package weekyexam;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @author Vinh
 *
 */

public class cWE07C_Prog02_T151487 extends JFrame{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		cWE07C_Prog02_T151487 f = new cWE07C_Prog02_T151487();
		f.setVisible(true);
		
	}

	private static int FRAME_WIDTH = 500, FRAME_HEIGHT = 250;
	
	public cWE07C_Prog02_T151487(){
		setTitle("T151487 – File Validation");
		setPreferredSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setLayout(null);
		initCmp();
	}

	JLabel lblInputPath = new JLabel("Input Path:");
	JTextField txtPath = new JTextField();
	JButton btnBrowse = new JButton("Browse"), btnReset = new JButton("Reset");
	JLabel lblOutput = new JLabel();
	
	private void initCmp(){
		//add
		add(lblInputPath);
		add(txtPath);
		add(btnBrowse);
		add(btnReset);
		add(lblOutput);
		//set location
		lblInputPath.setBounds(20, 20, 80, 30);
		txtPath.setBounds(110, 20, 250, 30);
		txtPath.setEditable(false);
		btnBrowse.setBounds(390, 20, 80, 30);
		btnReset.setBounds(390, 70, 80, 30);
		lblOutput.setBounds(100, 70, 250, 30);
		
		btnBrowse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				openFile();
			}
		});
		
		btnReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setFlag(true);
				txtPath.setText("");
				lblOutput.setText("");
			}
		});
	}
	int []arr = new int[10000];
	int iCount = 0;
	boolean flag = true;
	
	private void openFile(){
		
		JFileChooser fchOpenFile = new JFileChooser();
		int result = fchOpenFile.showOpenDialog(this);
		
		if(result == JFileChooser.APPROVE_OPTION){
			try {
				Scanner reader = new Scanner(fchOpenFile.getSelectedFile());
				txtPath.setText(fchOpenFile.getSelectedFile().getAbsolutePath());
				while(reader.hasNextInt()){
					if(reader.nextInt() % 2 == 1){
						setFlag(false);
						break;
					}
				}
				reader.close();
				chkFlag();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				JOptionPane.showMessageDialog(null, "File not found");
			}
		}
	}
	
	private void setFlag(boolean flag){
		this.flag = flag;
	}
	
	private void chkFlag(){
		if(flag){
			JOptionPane.showMessageDialog(null, "PASSED! All number is EVEN");
			lblOutput.setText("PASSED! All number is EVEN");
		}
		else{
			JOptionPane.showMessageDialog(null, "OOPS! There's at least one ODD number");
			lblOutput.setText("OOPS! There's at least one ODD number");
		}
	}
}
