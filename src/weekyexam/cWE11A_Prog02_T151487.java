package weekyexam;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class cWE11A_Prog02_T151487 extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3742460180742724200L;

	public static void main(String[] args){
		cWE11A_Prog02_T151487 frame = new cWE11A_Prog02_T151487();
		frame.setVisible(true);
	}
	
	private static int WIDTH = 600, HEIGHT = 600;
	panelDraw panel;
	public cWE11A_Prog02_T151487(){
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setTitle("T151487 – Display Panel");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		
		panel = new panelDraw();
		add(panel);
		panel.setBounds(0, 0, WIDTH-30, HEIGHT-70);
		
		initMenu();
	}
	
	JMenuBar mnbMenuBar = new JMenuBar();
	JMenu mnuFile;
	JMenuItem mniOpen,mniExit;
	
	private void initMenu(){
		mnuFile = new JMenu("File");
		mniOpen = new JMenuItem("Open");
		mniExit = new JMenuItem("Exit");
		
		mnuFile.add(mniOpen);
		mnuFile.addSeparator();
		mnuFile.add(mniExit);
		mnbMenuBar.add(mnuFile);
		setJMenuBar(mnbMenuBar);
		
		mniOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				openFile();
			}
		});
	}
	
	JFileChooser fchChooser;
	File currentFile;
	String currentFileName;
	int nRow = 9, nCol = 9;
	int[][] d = new int[nRow][nCol];
	
	private void openFile(){
		
		fchChooser = new JFileChooser();
		int result = fchChooser.showOpenDialog(this);
		
		if(result == JFileChooser.APPROVE_OPTION){
			try {
				currentFile = fchChooser.getSelectedFile();
				currentFileName = fchChooser.getSelectedFile().getName();
				Scanner reader = new Scanner(fchChooser.getSelectedFile());
				int i = 0;
				int j = 0;
				while(reader.hasNextInt()){
					if(j > 8){
						j=0;
						i++;
					}
					d[i][j] = reader.nextInt();
					j++;
					//System.out.print(reader.nextInt() + " ");
				}
				
				for(int n = 0 ; n < 9 ; n++){
					for(int m = 0 ; m < 9; m++){
						System.out.print(d[n][m] + " ");
					}
					System.out.println();
				}
				reader.close();
				panel.setData(d);
				panel.repaint();
				
			}
			catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "File not found");
			}
		}
	}
}

class panelDraw extends JPanel{
	
	int nRow = 9, nCol = 9;
	int x0 = 10, y0 = 10;
	int width = 50, height = 50;
	int[][] d = new int[nRow][nCol];
	
	public void paint(Graphics g){
		super.paint(g);
		for(int i = 0 ; i <= nRow ; i++){
			g.drawLine(x0 , y0 + height*i, x0 + width*nRow, y0 + height*i);
			
		}
		for(int i = 0 ; i <= nCol ; i++){
			g.drawLine(x0 + width*i, y0 , x0 + width*i, y0 + height*nCol);
		}
		
		for(int i = 0 ; i < nRow ; i++){
			for(int j = 0 ; j < nCol ; j++){
				if((i+j)%2 == 0){
					g.setColor(Color.WHITE);
				}
				else{
					g.setColor(Color.BLACK);
				}
				g.fillRect(x0 + width*i +1, y0 + height*j +1, width-1, height-1);
				int d0 = 20;
				if(d[i][j] == -1){
					g.setColor(Color.BLUE);
					g.fillOval(x0 + width*i + d0/2, y0 + height*j +d0/2 , width-d0, height -d0);
				}
				else if(d[i][j] == 0){
					
				}
				else if(d[i][j] == 1){
					g.setColor(Color.RED);
					g.fillOval(x0 + width*i + d0/2, y0 + height*j +d0/2 , width-d0, height -d0);
				}
			}
		}
	}
	
	
	public void setData(int[][] d){
		this.d = d;
	}
	
}