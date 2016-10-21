package text.editor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class cTextEditor extends JFrame{
	
	public static void main(String[] args){
		cTextEditor f = new cTextEditor();
		f.setVisible(true);
	}
	
	public cTextEditor(){
		setTitle("Text Editor");
		setPreferredSize(new Dimension(600,600));
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		
		initializeMenu();
		//content area
		txtContent = new JTextArea();
		//new scrPane
		scrPane = new JScrollPane(txtContent);
		//add scrPane to JFrame
		getContentPane().add(scrPane);
		
		ActionListener action = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==mniOpen){
					openFile();
				}
				else if(e.getSource()==mniSave){
					saveDoc();
				}
				else if(e.getSource()==mniExit){
					closewindows();
				}
				else if(e.getSource()==mniChangeBgColor){
					changeBGColor();
				}
				else if(e.getSource()==mniChangeFontColor){
					changeFontColor();
				}
			}
		};
		mniOpen.addActionListener(action);
		mniSave.addActionListener(action);
		mniExit.addActionListener(action);
		mniChangeBgColor.addActionListener(action);
		mniChangeFontColor.addActionListener(action);
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				closewindows();
			}
			
		});
	}
	
	JMenuBar mnbBar;
	JMenu mnuFile, mnuFormat;
	JMenuItem mniOpen, mniSave, mniExit, mniChangeBgColor, mniChangeFontColor;
	JTextArea txtContent;
	JScrollPane scrPane;
	
	public void initializeMenu(){
		//menuBar
		mnbBar = new JMenuBar();
		//Menu
		mnuFile = new JMenu("File");
		mnuFormat = new JMenu("Format");
		//MenuItme
		mniOpen = new JMenuItem("Open");
		mniExit = new JMenuItem("Exit");
		mniSave = new JMenuItem("Save");
		mniChangeBgColor = new JMenuItem("Change BG color");
		mniChangeFontColor = new JMenuItem("Change font color");
		//add MenuItem => menuFile
		mnuFile.add(mniOpen);
		mniOpen.setMnemonic('O');
		mnuFile.add(mniSave);
		mniSave.setMnemonic('s');
		mnuFile.addSeparator();
		mnuFile.add(mniExit);
		//add MenuItem => menuFormat
		mnuFormat.add(mniChangeBgColor);
		//mnuFormat.addSeparator();
		mnuFormat.add(mniChangeFontColor);
		//add MenuFile, menuFormat => menuBar
		mnbBar.add(mnuFile);
		mnbBar.add(mnuFormat);
		setJMenuBar(mnbBar);
		
	}
	
	public void openFile(){
		
		JFileChooser fchOpenFile = new JFileChooser();
		int result = fchOpenFile.showOpenDialog(this);
		
		if(result == JFileChooser.APPROVE_OPTION){
			try {
				Scanner reader = new Scanner(fchOpenFile.getSelectedFile());
				while(reader.hasNextLine()){
					txtContent.append(reader.nextLine() + "\n");
				}
				reader.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				JOptionPane.showMessageDialog(null, "File not found");
			}
		}
		
	}
	
	public void changeBGColor(){
		Color newColor = JColorChooser.showDialog(this, "Choose background color", txtContent.getBackground());
		txtContent.setBackground(newColor);
	}
	
	public void changeFontColor(){
		Color newColor = JColorChooser.showDialog(this, "Choose background color", txtContent.getForeground());
		txtContent.setForeground(newColor);;
	}
	
	public void closewindows(){
		int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the program?", "Confirm", 
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (result== JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}
	
	public void saveDoc(){
		String s = txtContent.getText();
	    JFileChooser chooser = new JFileChooser();
	    //chooser.setCurrentDirectory(new File("/home/me/Documents"));
	    int result = chooser.showSaveDialog(null);
	    if (result == JFileChooser.APPROVE_OPTION) {
	        try(FileWriter fw = new FileWriter(chooser.getSelectedFile()+".txt")) {
	            //FileWriter fw = new FileWriter(chooser.getSelectedFile()+".txt");
	            fw.write(s);
	            fw.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
	}
}
