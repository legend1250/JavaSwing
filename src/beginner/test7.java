/**
 * 
 */
package beginner;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import com.sun.prism.paint.Color;

/**
 * @author Vinh - legend1250
 *
 */
public class test7 extends JFrame{
	
	public static void main(String[] args){
		test7 mainFrame = new test7();
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	JTextPane txtTopPlayer = new JTextPane();
	JScrollPane scrPane = new JScrollPane(txtTopPlayer);
	String str_headerTopPlayer = "Rank \tName \tScore\n";
	
	public test7(){
		setPreferredSize(new Dimension(300, 300));
		setTitle("Top Player");
		setLocation(400,200);
		setLayout(null);
		pack();
		
		//
		add(scrPane);
		txtTopPlayer.setEditable(false);
		scrPane.setBounds(10, 10, 250, 200);
		//txtTopPlayer = getTopTenTable("D:\\top.txt");
		txtTopPlayer.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtTopPlayer.setAlignmentY(Component.TOP_ALIGNMENT);
		txtTopPlayer.setAlignmentX(Component.RIGHT_ALIGNMENT);
		txtTopPlayer.setFocusTraversalKeysEnabled(false);
		txtTopPlayer.setFocusCycleRoot(false);
		txtTopPlayer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTopPlayer.setText(getTopTenTable("D:\\top.txt").getText());
	}
	

	/**
	 * 
	 * @param path: path link to "highscore.txt" 
	 * @return component JTextArea with minimum required width and height: 
	 */
	private JTextArea getTopTenTable(String path){
		JTextArea txtHandleTop = new JTextArea(str_headerTopPlayer);
		String [][]data = new String[15][2];
		int iCount = 0;
		try {
			Scanner reader = new Scanner(new FileReader(path));
			iCount = 0;
			String[] strLines;
			while(reader.hasNextLine() && iCount < 10){
				strLines = reader.nextLine().split(";");
				data[iCount][0] = strLines[0];
				data[iCount][1] = strLines[1];
				//System.out.println(data[iCount][0] + " \t" +data[iCount][1]);
				iCount++;
			}
			reader.close();
		}
		catch (FileNotFoundException  | NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "highscore.txt not found or data corrupted");
		}
		//sap xep thu tu
		int max = 0,num;
		for(int i = 0 ; i < iCount ; i++){
			max = Integer.parseInt(data[i][0]);
			for(int j = i ; j < iCount ; j++){
				num = Integer.parseInt(data[j][0]);
				if(num > max){
					//System.out.println(num);
					String sTmp = data[i][0];
					String sTmp2 = data[i][1];
					data[i][0] = data[j][0];
					data[j][0] = sTmp;
					data[i][1] = data[j][1];
					data[j][1] = sTmp2;
					max = num;
				}
			}
		}
		for(int i = 0 ; i < 10 ; i++){
			String Player = String.format("%d \t%s \t%s\n", (i+1),data[i][1], data[i][0]);
			txtHandleTop.append(Player);
		}

		return txtHandleTop;
	}
}
