package text.editor;
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

public class cWe15_Pro01_T151487 extends JFrame{
	
	public static void main(String[] args){
		cWe15_Pro01_T151487 f = new cWe15_Pro01_T151487();
		f.setVisible(true);
	}
	
	public cWe15_Pro01_T151487(){
		setPreferredSize(new Dimension(550,600));
		setTitle("SALARY");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		
		initializeCmp();
	}
	
	JLabel lblPath = new JLabel("Path: ");
	JTextField txtInputPath = new JTextField();
	JButton btnBrowse = new JButton("Browse");
	boolean bgetPath = false;
	
	public void initializeCmp(){
		setLayout(null);
		add(lblPath);
		add(txtInputPath);
		add(btnBrowse);
		//
		lblPath.setBounds(30,30,60,30);
		txtInputPath.setBounds(100, 30, 250, 30);
		txtInputPath.setEditable(false);
		btnBrowse.setBounds(400, 30, 90, 30);
		
		btnBrowse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				openFile();
			}
		});
			
	}
	
	String data[][] = new String[15000][8];
	int salary[] = new int[15000];
	
	int nRow = 0;
	int nCol = 0;
	
	public void openFile(){
		JFileChooser fchOpenFile = new JFileChooser();
		int result = fchOpenFile.showOpenDialog(this);
		
		if(result == JFileChooser.APPROVE_OPTION){
			txtInputPath.setText(fchOpenFile.getSelectedFile().getAbsolutePath());
			try {
				Scanner reader = new Scanner(fchOpenFile.getSelectedFile());
				while(reader.hasNextLine()){
					if (nRow >= 10){
						break;
					}
					for(int i = 0 ; i < 8 ; i++){
						if(reader.hasNext()){
							//System.out.print(reader.next() + " ");
							data[nRow][i] = reader.next();
						}
					}
					System.out.println();
					nRow++;
				}
				reader.close();
				for(int i = 0 ; i < 10 ; i++){
					for(int j = 0 ; j < 8; j++){
						System.out.print(data[i][j] + " ");
					}
					System.out.println();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				JOptionPane.showMessageDialog(null, "File not found");
			}
		}
		
	}
	
}
