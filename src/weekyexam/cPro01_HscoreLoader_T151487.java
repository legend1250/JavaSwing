package weekyexam;

import java.awt.Dimension;
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

public class cPro01_HscoreLoader_T151487 extends JFrame{
	
	public static void main(String[] args){
		cPro01_HscoreLoader_T151487 frame = new cPro01_HscoreLoader_T151487();
		frame.setVisible(true);
	}
	
	private static int WIDTH = 460,HEIGHT = 500;
	
	cPro01_HscoreLoader_T151487(){
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setTitle("Image Viewer - T151487");
		pack();
		
		initComponents();
		btnBrowse.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				openFile();
			}
		});
	}
	
	JFileChooser fchChooser = new JFileChooser();
	
	JLabel lblPath = new JLabel("Path:");
	JTextField txtPath = new JTextField();
	JButton btnBrowse = new JButton("Browse");
	JTextArea txtOutput = new JTextArea();
	JScrollPane scrPane = new JScrollPane(txtOutput);
	
	private void initComponents(){
		add(lblPath);
		add(txtPath);
		add(btnBrowse);
		add(scrPane);
		//
		lblPath.setBounds(10, 10, 55, 30);
		txtPath.setBounds(65, 10, 250, 30);
		txtPath.setEditable(false);
		btnBrowse.setBounds(335, 10, 85, 30);
		scrPane.setBounds(80, 50, 250, 350);
		txtOutput.setEditable(false);
	}
	
	File currentFile;
	String[][] strData = new String[10000][2];
	int iCount = 0;
	
	private void openFile(){
		int result = fchChooser.showOpenDialog(this);
		
		if(result == JFileChooser.APPROVE_OPTION){
			try {
				Scanner reader = new Scanner(fchChooser.getSelectedFile());
				currentFile = fchChooser.getSelectedFile();
				this.setTitle(currentFile.getName());
				
				txtOutput.setText("");
				iCount = 0;
				String[] strLines;
				while(reader.hasNextLine()){
					strLines = reader.nextLine().split("\\|");
					strData[iCount][0] = strLines[0];
					strData[iCount][1] = strLines[1];
					iCount++;
				}
				reader.close();
				int max = 0,num;
				for(int i = 0 ; i < iCount ; i++){
					max = Integer.parseInt(strData[i][0]);
					for(int j = i ; j <iCount ; j++){
						num = Integer.parseInt(strData[j][0]);
						if(num > max){
							//System.out.println(num);
							String sTmp = strData[i][0];
							String sTmp2 = strData[i][1];
							strData[i][0] = strData[j][0];
							strData[j][0] = sTmp;
							strData[i][1] = strData[j][1];
							strData[j][1] = sTmp2;
							max = num;
						}
					}
				}
				txtOutput.setText("");
				for(int i = 0 ; i < iCount ; i++){
					txtOutput.append((i+1) + ": " +strData[i][0] + "  -  " + strData[i][1]  + "\n\r"); 
				}
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "File not found");
			}
		}
	}

}
