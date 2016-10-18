package readfile;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class cWE09_Grid_Prog01_T151487 extends JFrame{

	public static void main(String[] args){
		cWE09_Grid_Prog01_T151487 f = new cWE09_Grid_Prog01_T151487();
		f.setVisible(true);
	}
	
	cWE09_Vinh_PanelProgr01 panel01 = new cWE09_Vinh_PanelProgr01();
	int x[] = new int[1000];
	int y[] = new int[1000];
	int i=0;
	boolean wasReceive = false;
	
	public cWE09_Grid_Prog01_T151487(){
		setTitle("T151487 - Polygon – Ver1.0");
		setPreferredSize(new Dimension(600,600));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();

		initializeMenu();
		ActionListener action = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == mniOpen){
					openFile();
					doDraw();
				}
				else if(e.getSource() == mniExit){
					exit();
				}
				else if(e.getSource() == mniRepaint){
					if(wasReceive){
						panel01.repaint();
					}
					else{
						JOptionPane.showMessageDialog(null, "The file hasn't been opened \nPlease open file then repaint");
					}
				}
			}
		};
		mniOpen.addActionListener(action);
		mniRepaint.addActionListener(action);
		mniExit.addActionListener(action);
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				//exit();
			}
			
		});
	}
	
	JMenuBar mnbBar;
	JMenu mnuFile;
	JMenuItem mniOpen, mniExit, mniRepaint;
	public void initializeMenu(){
		mnbBar = new JMenuBar();
		mnuFile = new JMenu("File");
		mniOpen = new JMenuItem("Open");
		mniExit = new JMenuItem("Exit");
		mniRepaint = new JMenuItem("Repaint");
		//add menu item to mnu file
		mnuFile.add(mniOpen);
		mnuFile.add(mniExit);
		mnuFile.addSeparator();
		mnuFile.add(mniRepaint);
		//add menu => menu bar
		mnbBar.add(mnuFile);
		setJMenuBar(mnbBar);
	}
	
	public void openFile(){
		
		JFileChooser fchOpenFile = new JFileChooser();
		int result = fchOpenFile.showOpenDialog(this);
		boolean firstCol = true;
		if(result == JFileChooser.APPROVE_OPTION){
			try {
				Scanner reader = new Scanner(fchOpenFile.getSelectedFile());
				i=0;
				while(reader.hasNextInt()){
					if(firstCol){
						x[i] = reader.nextInt();
						firstCol = false;
					}
					else {
						y[i] = reader.nextInt();
						firstCol = true;
						i++;
					}
				}
				reader.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				JOptionPane.showMessageDialog(null, "File not found");
			}
		}
		
	}
	
	public void setparamPanel(int x[], int y[]){
		panel01.x = this.x;
		panel01.y = this.y;
		panel01.var = this.i;
		wasReceive = true;
	}
	
	public void doDraw(){
		int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to draw Polygon?", "Confirm", 
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (result== JOptionPane.YES_OPTION){
			this.add(panel01);
			panel01.setBounds(0, 0, 600, 600);
			setparamPanel(x, y);
			panel01.repaint();
		}
	}
	
	public void exit(){
		int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the program?", "Confirm", 
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (result== JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}
}
