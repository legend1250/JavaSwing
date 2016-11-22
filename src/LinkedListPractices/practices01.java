/**
 * 
 */
package LinkedListPractices;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import com.sun.media.jfxmedia.events.NewFrameEvent;

/**
 * @author Vinh - legend1250
 *
 */
public class practices01 extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8538217587498603223L;

	public static void main(String[] args){
		practices01 frame = new practices01();
		frame.setVisible(true);
	}
	
	public practices01(){
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		setPreferredSize(new Dimension(600,600));
		setTitle("LinkedList - Practices01");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		pack();
		
		initMenu();
		initComponents();
	}
	
	JMenuBar mnbBar;
	JMenu mnuFile;
	JMenuItem mniOpen;
	
	private void initMenu(){
		//
		mniOpen = new JMenuItem("Open");
		mnuFile = new JMenu("File");
		mnbBar = new JMenuBar();
		//add 
		mnbBar.add(mnuFile);
		mnuFile.add(mniOpen);
		setJMenuBar(mnbBar);
		
		ActionListener actionMenu = new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource() == mniOpen){
					openFile();
				}
			}
		};
		
		mniOpen.addActionListener(actionMenu);
	}
	
	JTextArea txtOutput = new JTextArea();
	JScrollPane scrPane = new JScrollPane(txtOutput);
	private void initComponents(){
		add(scrPane);
		scrPane.setBounds(10, 10, 572, 500);
		txtOutput.setEditable(false);
		txtOutput.setCaretPosition(0);
	}
	
	JFileChooser fchChooser;
	File currentFile;
	
	LinkedList<String> strInformation = new LinkedList<>();
	
	private void openFile(){
		fchChooser = new JFileChooser();
		int result = fchChooser.showOpenDialog(this);
		if(result == JFileChooser.APPROVE_OPTION){
			currentFile = fchChooser.getSelectedFile();
			try {
				Scanner reader = new Scanner(currentFile);
				strInformation.clear();
				while(reader.hasNextLine()){
					strInformation.add(reader.nextLine().trim());
				}
				reader.close();
				txtOutput.setText("Size: " +strInformation.size()+"\n\r");
				for(int j = strInformation.size() -1; j >= 0 ;j--){
					txtOutput.append(strInformation.get(j) + "\n\r");
				}
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
	}

}
