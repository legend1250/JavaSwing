package weekyexam.practices;
/*
 * @author: Vinh Nguyen - T151487
 */
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
	
	String data[][] = new String[15000][9];
	int salary[] = new int[15000];
	
	int nRow = 0;
	int nCol = 0;
	
	public void openFile(){
		JFileChooser fchOpenFile = new JFileChooser();
		File workingDirectory = new File(System.getProperty("user.dir"));
		fchOpenFile.setCurrentDirectory(workingDirectory);
		int result = fchOpenFile.showOpenDialog(this);
		
		if(result == JFileChooser.APPROVE_OPTION){
			txtInputPath.setText(fchOpenFile.getSelectedFile().getAbsolutePath());
			try {
				Scanner reader = new Scanner(fchOpenFile.getSelectedFile());
				while(reader.hasNextLine()){
					String s[] = reader.nextLine().split(",");
					for(int i = 0 ; i < 8 ; i++){ 
						data[nRow][i] = s[i];
					}
					if(nRow > 0){
						System.err.println(data[nRow][7]);
						data[nRow][8] = cReadingNumber.convertN2S(Integer.parseInt(data[nRow][7]));
					}
					nRow++;
				}
				reader.close();
				for(int i = 0 ; i < nRow ; i++){
					for(int j = 0 ; j < 9; j++){
						System.out.print(data[i][j] + " ");
					}
					System.out.print("\t\tlength: " +data[i].length);
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
