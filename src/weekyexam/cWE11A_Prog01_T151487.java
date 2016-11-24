package weekyexam;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

/*
 * @author: Vinh Nguyen - T151487
 */
public class cWE11A_Prog01_T151487 extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -781879676400867633L;

	public static void main(String[] args) {
		cWE11A_Prog01_T151487 frame = new cWE11A_Prog01_T151487();
		frame.setVisible(true);
	}

	
	private static int WIDTH = 500, HEIGHT = 600;
	
	public cWE11A_Prog01_T151487(){
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setTitle("T151487 – Scanner ");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		
		initMenu();
		initComponents();
		
		ActionListener actionOpenFile = new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource() == mniOpen || arg0.getSource() == btnBrowse){
					openFile();
				}
				else if(arg0.getSource() == btnClear){
					txtPath.setText("");
					txtOutput.setText("");
				}
			}
		};
		mniOpen.addActionListener(actionOpenFile);
		btnBrowse.addActionListener(actionOpenFile);
		btnClear.addActionListener(actionOpenFile);
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
		
	}
	
	JLabel lblPath = new JLabel("Path:");
	JTextField txtPath = new JTextField();
	JButton btnBrowse = new JButton("Browse"),
			btnClear = new JButton("Clear");
	JTextArea txtOutput = new JTextArea();
	JScrollPane scrPane = new JScrollPane(txtOutput);
	
	private void initComponents(){
		add(lblPath);
		add(txtPath);
		add(scrPane);
		add(btnBrowse);
		add(btnClear);
		//setBounds
		lblPath.setBounds(10, 10, 50, 30);
		txtPath.setBounds(55, 10, 250, 30);
		txtPath.setEditable(false);
		Insets isMargin = new Insets(1, 1, 1, 1);
		btnBrowse.setBounds(315, 10, 75, 30);
		btnBrowse.setMargin(isMargin);
		btnClear.setBounds(405, 10, 75, 30);
		btnClear.setMargin(isMargin);
		scrPane.setBounds(10, 50, WIDTH-40, 450);
		txtOutput.setEditable(false);
	}
	
	JFileChooser fchChooser;
	File currentFile;
	String currentFileName;
	int nLines = 0;
	private void openFile(){
		
		fchChooser = new JFileChooser();
		int result = fchChooser.showOpenDialog(this);
		
		if(result == JFileChooser.APPROVE_OPTION){
			try {
				currentFile = fchChooser.getSelectedFile();
				currentFileName = fchChooser.getSelectedFile().getName();
				Scanner reader = new Scanner(new FileReader(currentFile));
				this.setTitle(currentFile.getName());
				txtPath.setText(currentFile.getAbsolutePath());
				txtOutput.setText("");
				nLines = 1;
				String sNum[];
				while(reader.hasNextLine()){
					/*String s = reader.nextLine();
					sNum = s.split("\\s+");
					num[nLines][0] = sNum.length+1;
					for(int j = 1 ; j < sNum.length+1; j++){
						num[nLines][j] = Integer.parseInt(sNum[j-1].trim());
					}
					nLines++;*/
					String strNext = "Line " + nLines + ": "+reader.nextLine() + "\n\r";
					if(strNext.indexOf('-') > 0){
						txtOutput.insert(strNext, 0);
					}
					nLines++;
				}
				reader.close();
				/*for(int i = nLines ; i >= 0 ; i--){
					if(isNegativeNumber(num[i])){
						for(int j = 1 ; j < num[i][0] ;j++){
							//System.out.print(num[i][j] + " ");
							txtOutput.append(num[i][j] + " ");
						}
						txtOutput.append("\n\r");
					}
					for(int j = 1 ; j < num[i][0]  ;j++){
						System.out.print(num[i][j] + " ");
					}
				}*/
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "File not found");
			}
		}
	}
	
	int [][]num = new int[10000][10000];
	
	private boolean isNegativeNumber(int[] nLines){
		for(int i = 1 ; i < nLines[0] ;i++){
			if(nLines[i] <0){
				return true;
			}
		}
		return false;
	}
	
}
