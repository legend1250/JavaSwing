package text.editor;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class cTextEditor extends JFrame{
	
	public static void main(String[] args){
		cTextEditor f = new cTextEditor();
		f.setVisible(true);
	}
	
	JMenuBar mnbBar;
	JMenu mnuFile, mnuFormat;
	JMenuItem mniOpen, mniExit, mniChangeBgColor, mniChangeFontColor;
	JTextArea txtContent;
	JScrollPane scrPane;
	
	public cTextEditor(){
		setTitle("Text Editor");
		setPreferredSize(new Dimension(600,600));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		
		initializeMenu();
		//content area
		txtContent = new JTextArea();
		//new scrPane
		scrPane = new JScrollPane(txtContent);
		//add scrPane to JFrame
		
	}
	
	public void initializeMenu(){
		//menuBar
		mnbBar = new JMenuBar();
		//Menu
		mnuFile = new JMenu();
		mnuFormat = new JMenu();
		//MenuItme
		mniOpen = new JMenuItem();
		mniExit = new JMenuItem();
		mniChangeBgColor = new JMenuItem();
		mniChangeFontColor = new JMenuItem();
		//add MenuItem => menuFile
		mnuFile.add(mniOpen);
		mnuFile.addSeparator();
		mnuFile.add(mniExit);
		//add MenuItem => menuFormat
		mnuFormat.add(mniChangeBgColor);
		mnuFormat.addSeparator();
		mnuFormat.add(mniChangeFontColor);
		//add MenuFile, menuFormat => menuBar
		mnbBar.add(mnuFile);
		mnbBar.add(mnuFormat);
		
		
		
		
	}
}
