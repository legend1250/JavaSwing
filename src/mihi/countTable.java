/**
 * 
 */
package mihi;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author Vinh - legend1250
 *
 */
public class countTable extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					countTable frame = new countTable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public countTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String [] str01 = new String[10];
		for(int i = 0 ; i < 10 ;i++){
			str01[i] = "Ques: " +(i+1);
		}
		
		JComboBox<String> comboBox = new JComboBox(str01);
		comboBox.setBounds(37, 28, 97, 30);
		contentPane.add(comboBox);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFile();
			}
		});
		btnBrowse.setBounds(162, 28, 89, 30);
		contentPane.add(btnBrowse);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 93, 150, 120);
		contentPane.add(scrollPane);
		
		JTextArea txtOutput = new JTextArea();
		txtOutput.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollPane.setViewportView(txtOutput);
		
		JButton btnCount = new JButton("Count");
		btnCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = comboBox.getSelectedIndex();
				//System.out.println(row);
				int[] ans = new int[5];
				for(int i = 0 ; i < linesCount ; i++){
					if(data[i][row] == 1){
						ans[0]++;
					}
					else if(data[i][row] == 2){
						ans[1]++;
					}
					else if(data[i][row] == 3){
						ans[2]++;
					}
					else if(data[i][row] == 4){
						ans[3]++;
					}
					else if(data[i][row] == 5){
						ans[4]++;
					}
				}
				txtOutput.setText("");
				String strDefault = "Ques \tAnswerCount\n";
				txtOutput.setText(strDefault);
				for(int i = 0 ; i < 5 ; i++){
					txtOutput.append(String.format("%d \t%d\n", (i+1), ans[i]));
				}
			}
		});
		btnCount.setBounds(282, 28, 89, 30);
		contentPane.add(btnCount);
	}
	
	JFileChooser fchChooser = new JFileChooser();
	File currentFile;
	int linesCount = 0;
	int[][] data = new int[10000][10];
	
	public void openFile(){
		
		int result = fchChooser.showOpenDialog(this);
		
		if(result == JFileChooser.APPROVE_OPTION){
			try {
				Scanner reader = new Scanner(fchChooser.getSelectedFile());
				currentFile = fchChooser.getSelectedFile();
				this.setTitle(currentFile.getName());
				linesCount = 0;
				String[] strLines;
				
				while(reader.hasNextLine()){
					strLines = reader.nextLine().split("\\s+");
					for(int i = 0 ; i < 10 ; i++){
						data[linesCount][i] = Integer.parseInt(strLines[i]);
					}
					linesCount++;
				}
				reader.close();
				/*for(int i = 0 ; i < linesCount ;i++ ){
					for(int j = 0 ; j < 10 ; j++){
						System.out.print(data[i][j] + " ");
					}
					System.out.println();
				}*/
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				JOptionPane.showMessageDialog(null, "File not found");
			}
		}
		
	}
}
