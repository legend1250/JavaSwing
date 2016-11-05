package textEditor;

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
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.sun.javafx.font.FontConfigManager.FcCompFont;

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
				else if(e.getSource() == mniSaveAs){
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
		mniSaveAs.addActionListener(action);
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
		
		fchChooser.addChoosableFileFilter(filterTxt);
		fchChooser.addChoosableFileFilter(filterJava);
		
	}
	
	JMenuBar mnbBar;
	JMenu mnuFile, mnuFormat;
	JMenuItem mniOpen, mniSave, mniSaveAs, mniExit, mniChangeBgColor, mniChangeFontColor;
	JTextArea txtContent;
	JScrollPane scrPane;
	File currentFile;
	JFileChooser fchChooser = new JFileChooser();
	
	FileNameExtensionFilter filterTxt = new FileNameExtensionFilter("Text", "txt");
	FileNameExtensionFilter filterJava = new FileNameExtensionFilter("Java", "java");
	
	
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
		mniSaveAs = new JMenuItem("SaveAs");
		mniChangeBgColor = new JMenuItem("Change BG color");
		mniChangeFontColor = new JMenuItem("Change font color");
		//add MenuItem => menuFile
		mnuFile.add(mniOpen);
		mniOpen.setMnemonic('O');
		mnuFile.add(mniSave);
		mniSave.setMnemonic('s');
		mnuFile.add(mniSaveAs);
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
		
		int result = fchChooser.showOpenDialog(this);
		
		if(result == JFileChooser.APPROVE_OPTION){
			try {
				Scanner reader = new Scanner(fchChooser.getSelectedFile());
				currentFile = fchChooser.getSelectedFile();
				currentFileName = fchChooser.getSelectedFile().getName();
				this.setTitle(currentFile.getName());
				
				txtContent.setText("");
				
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
	
	String currentFileName = "";
	
	public void saveDoc(){
		
		if(currentFile != null){
			currentFileName = currentFile.getAbsolutePath();
			saveContent(currentFileName);
			
		}
		else{
			SaveDocAs();
		}
		
	}
	
	private void SaveDocAs(){
		int result = fchChooser.showSaveDialog(this);
	    if(result == fchChooser.APPROVE_OPTION){
	    	
	    	currentFile = fchChooser.getSelectedFile();
	    	currentFileName = fchChooser.getSelectedFile().getAbsolutePath();
	    	this.setTitle(currentFile.getName());
	    	
	    	if(fchChooser.getFileFilter().equals(filterTxt)){
	    		currentFileName += ".txt";
	    	}
	    	else if(fchChooser.getFileFilter().equals(filterJava)){
	    		currentFileName += ".java";
	    	}
	    	
	    }
	    saveContent(currentFileName);
	}
	
	private void saveContent(String fileName){
		if(!fileName.isEmpty()){
			String sContent = txtContent.getText();
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
	
}
