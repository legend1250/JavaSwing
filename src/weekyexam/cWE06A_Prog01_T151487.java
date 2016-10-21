package weekyexam;
/*
 * @author: Vinh Nguyen - T151487
 */
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
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class cWE06A_Prog01_T151487 extends JFrame{
	
	public static void main(String[] args){
		cWE06A_Prog01_T151487 f = new cWE06A_Prog01_T151487();
		f.setVisible(true);
	}
	
	public cWE06A_Prog01_T151487(){
		setPreferredSize(new Dimension(550,600));
		setTitle("T151487 – Sum of Double");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		
		initializeCmp();
	}
	
	JLabel lblPath = new JLabel("Path: ");
	JTextField txtInputPath = new JTextField();
	JButton btnBrowse = new JButton("Browse"),
			btnCal = new JButton("Calculate"),
			btnReset = new JButton("Reset");
	JTextArea txtOutput = new JTextArea();
	boolean bgetPath = false;
	
	public void initializeCmp(){
		setLayout(null);
		add(lblPath);
		add(txtInputPath);
		add(btnBrowse);
		add(btnCal);
		add(txtOutput);
		add(btnReset);
		//
		lblPath.setBounds(30,30,60,30);
		txtInputPath.setBounds(100, 30, 250, 30);
		btnBrowse.setBounds(400, 30, 90, 30);
		btnCal.setBounds(30,120,90,30);
		btnReset.setBounds(150,120,90,30);
		if(!bgetPath){
			btnCal.setEnabled(false);
			btnReset.setEnabled(false);
		}
		txtInputPath.setEditable(false);
		txtOutput.setBounds(30,170,400,350);
		
		btnBrowse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				openFile();
			}
		});
		btnCal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dSum = 0;
				for(int i = 0 ; i < iCount ; i++){
					dSum += arr[i];
				}
				txtOutput.setText("Path: " +sPath + ""
						+ "\nCount: "+iCount + 
						"\nSum double: " + dSum);
				btnReset.setEnabled(true);
			}
		});
		btnReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				sPath = "";
				for(int i = 0 ; i < iCount ; i++){
					arr[i] = 0;
				}
				iCount = 0;
				dSum = 0;
				txtInputPath.setText(sPath);
				txtOutput.setText("Path: " +sPath + ""
						+ "\nCount: "+iCount + 
						"\nSum double: " + dSum);
				txtOutput.append("\nPlese, input a new file!");
				btnReset.setEnabled(false);
				btnCal.setEnabled(false);
			}
		});
		
	}
	
	double dSum = 0;
	int iCount = 0;
	double arr[] = new double [10000];
	String sPath = "";
	
	public void openFile(){
		JFileChooser fchOpenFile = new JFileChooser();
		int result = fchOpenFile.showOpenDialog(this);
		
		if(result == JFileChooser.APPROVE_OPTION){
			try {
				txtOutput.setText("");
				bgetPath = true;
				btnCal.setEnabled(true);
				sPath = fchOpenFile.getSelectedFile().getAbsolutePath();
				txtInputPath.setText(sPath);
				Scanner reader = new Scanner(fchOpenFile.getSelectedFile());
				while(reader.hasNextDouble()){
					//dSum += reader.hasNextDouble();
					arr[iCount] = reader.nextDouble();
					iCount++;
				}
				reader.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				JOptionPane.showMessageDialog(null, "File not found");
			}
		}
		
	}
	
}
