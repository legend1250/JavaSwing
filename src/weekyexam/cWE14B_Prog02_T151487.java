package weekyexam;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

public class cWE14B_Prog02_T151487 extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1995820303374217034L;

	public static void main(String[] args){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		cWE14B_Prog02_T151487 mainFrame = new cWE14B_Prog02_T151487();
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public cWE14B_Prog02_T151487(){
		setPreferredSize(new Dimension(400, 400));
		setTitle("T151487 – Fibonacci2");
		setLayout(null);
		pack();
		
		initComponents();
		
	}
	
	
	JLabel lblPath = new JLabel("Input Path");
	JTextField txtPath = new JTextField();
	JButton btnBrowse = new JButton("Browse"),
			btnSaveFile = new JButton("Save to File");
	File currentFile = null;
	String currentFileName;
	int[] data = new int[100000];
	int iCount = 0;
	FileNameExtensionFilter filterTxt = new FileNameExtensionFilter("Text", "txt");
	
	void initComponents(){
		add(lblPath);
		add(txtPath);
		add(btnBrowse);
		add(btnSaveFile);
		//setBounds
		lblPath.setBounds(10, 10, 70, 30);
		txtPath.setBounds(80, 10, 200, 30);
		txtPath.setEditable(false);
		btnBrowse.setBounds(300, 10, 70, 30);
		btnSaveFile.setBounds(150, 150, 100, 30);
		btnSaveFile.setEnabled(false);
		
		btnBrowse.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				openFile();
			}
		});
		btnSaveFile.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				SaveDocAs();
			}
		});
	}

	JFileChooser fchChooser = new JFileChooser();
	
	void openFile(){
		int result = fchChooser.showOpenDialog(this);
		iCount = 0;
		if(result == JFileChooser.APPROVE_OPTION){
			try {
				Scanner reader = new Scanner(fchChooser.getSelectedFile());
				currentFile = fchChooser.getSelectedFile();
				this.setTitle(currentFile.getName());
				txtPath.setText(currentFile.getAbsolutePath());
				
				String[] sLines;
				while(reader.hasNextLine()){
					sLines = reader.nextLine().split(",");
					for(int i = 0 ; i < sLines.length ; i++){
						try {
							data[iCount] = Integer.parseInt(sLines[i]);
							iCount++;
						} catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(null, "data corrupted");
							break;
						}
					}
				}
				reader.close();
				
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "File not found");
			}
		}
		String strContent = strContent(data, iCount);
		if(!strContent.isEmpty()){
			JOptionPane.showMessageDialog(null, "Output file already!");
			btnSaveFile.setEnabled(true);
		}
		else{
			JOptionPane.showMessageDialog(null, "There's error while reading data. Contact ... for more detail");
		}
	}
	
	private void SaveDocAs(){
		int result = fchChooser.showSaveDialog(this);
	    if(result == JFileChooser.APPROVE_OPTION){
	    	
	    	currentFile = fchChooser.getSelectedFile();
	    	currentFileName = fchChooser.getSelectedFile().getAbsolutePath();
	    	if(fchChooser.getFileFilter().equals(filterTxt)){
	    		currentFileName += ".txt";
	    	}
	    	
	    }
	    saveContent(strContent(data, iCount), currentFileName);
	}
	
	private void saveContent(String sContent, String fileName){
		if(!fileName.isEmpty()){
			
			BufferedWriter writer;
			try {
				writer = new BufferedWriter(new FileWriter(fileName));
				writer.write(sContent);
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	String strContent(int[] data, int length){
		String strContent = "";
		for(int i = 0 ; i < length ; i++ ){
			strContent += String.format("%d, %f\r\n", data[i] , f(data[i]));
		}
		
		return strContent;
	}
	
	
	double f(int n){
		if(n <= 0 ){
			return 1;
		}
		if( n == 1){
			return 1000000;
		}
		
		return Math.sqrt(f(n-1)*f(n-2)); 
	}
}
