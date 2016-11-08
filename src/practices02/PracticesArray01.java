/**
 * 
 */
package practices02;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author Vinh - legend1250
 *
 */

public class PracticesArray01 extends JFrame{
	
	public static void main(String[] args){
		PracticesArray01 f = new PracticesArray01();
		f.setVisible(true);
	}
	
	JLabel lblInputPath = new JLabel("Path: ");
	JTextField txtInputPath = new JTextField();
	JButton btnBrowse = new JButton("Browse");
	JTextArea 	txtOddNumbers = new JTextArea(),
				txtEvenNumbers = new JTextArea();
	JScrollPane scrPane01 = new JScrollPane(txtEvenNumbers);
	JScrollPane scrPane02 = new JScrollPane(txtOddNumbers);
	JLabel 	lblEvenNumbers = new JLabel("Even Numbers"),
			lblOddNumbers = new JLabel("Odd Numbers");
	JButton btnOutputEvenNumbers = new JButton("Output EvenNumbers"),
			btnOutputOddNumbers = new JButton("Output OddNumbers");
			
	
	public PracticesArray01() {
		setSize(500,500);
		setTitle("Even - Odd numbers");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);

		//add
		add(lblInputPath);
		add(txtInputPath);
		add(btnBrowse);
		/*add(txtEvenNumbers);
		add(txtOddNumbers);
		*/
		add(scrPane01);
		add(scrPane02);
		add(lblEvenNumbers);
		add(lblOddNumbers);
		add(btnOutputEvenNumbers);
		add(btnOutputOddNumbers);
		
		//set location
		lblInputPath.setBounds(20,20,60,30);
		txtInputPath.setBounds(80, 20, 220, 30);
		txtInputPath.setEditable(false);
		btnBrowse.setBounds(360, 20, 80, 30);
		lblEvenNumbers.setBounds(50, 70, 100, 30);
		lblOddNumbers.setBounds(350, 70, 100, 30);
		int w1 = getWidth()/2-6;
		int h1 = 300;
		txtEvenNumbers.setWrapStyleWord(true);
		txtEvenNumbers.setLineWrap(true);
		txtOddNumbers.setWrapStyleWord(true);
		txtOddNumbers.setLineWrap(true);
		scrPane01.setBounds(10, 120, w1-20, h1);
		scrPane02.setBounds(w1, 120, w1-15, h1);
		btnOutputEvenNumbers.setBounds(30, 125+h1, 180, 30);
		btnOutputOddNumbers.setBounds(265, 125+h1, 180, 30);
		
		ActionListener actionButton = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JButton btnT = (JButton)e.getSource();
				if(btnT.equals(btnBrowse)){
					openFile();
				}
				else if(btnT.equals(btnOutputEvenNumbers)){
					
				}
				else if(btnT.equals(btnOutputOddNumbers)){
					
				}
			}
		};
		btnBrowse.addActionListener(actionButton);
		
	}
	
	JFileChooser fchChooser = new JFileChooser();
	File currentFile;
	int []arrNumbers = new int[100000];
	int iCount = 0;
	
	
	private void openFile(){
		
		int result = fchChooser.showOpenDialog(this);
		
		if(result == JFileChooser.APPROVE_OPTION){
			try {
				Scanner reader = new Scanner(fchChooser.getSelectedFile());
				currentFile = fchChooser.getSelectedFile();
				txtInputPath.setText(currentFile.getAbsolutePath());
				while(reader.hasNextInt()){
					int n = reader.nextInt();
					if(n%2==0){
						txtEvenNumbers.append(n + " \n");
					}
					else if(n%2==1){
						txtOddNumbers.append(n + " \n");
					}
					arrNumbers[iCount] = n;
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
