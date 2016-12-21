/**
 * 
 */
package beginner;

import java.awt.Dimension;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author Vinh - legend1250
 *
 */
public class test7 extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6738928679463775687L;

	public static void main(String[] args){
		test7 mainFrame = new test7();
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	JTextArea txtTopPlayer = new JTextArea();
	JScrollPane scrPane = new JScrollPane(txtTopPlayer);
	
	String str_headerTopPlayer = "Rank \tName \tScore\n";
	String[][] data_Player = new String[15][2];
	String data_url = "D:\\top.txt";
	
	JTextArea txtTopPlayer02 = new JTextArea();
	JScrollPane scrPane02 = new JScrollPane(txtTopPlayer02);
	
	public test7(){
		setPreferredSize(new Dimension(600, 300));
		setTitle("Top Player");
		setLocation(400,200);
		setLayout(null);
		pack();
		
		//init Data Player
		data_Player = initData(data_url);
		
		//
		add(scrPane);
		txtTopPlayer.setEditable(false);
		scrPane.setBounds(10, 10, 250, 200);
		txtTopPlayer.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtTopPlayer.setText(getTopTenTable(data_url));
		
		//ScrollPane02 - insert new data
		add(scrPane02);
		txtTopPlayer02.setEditable(false);
		scrPane02.setBounds(280, 10, 250, 200);
		txtTopPlayer02.setFont(new Font("Tahoma", Font.PLAIN, 11));
		String result = insertData(data_Player, String.valueOf(5000), "Someone");  //add new Data
		txtTopPlayer02.setText(result);
		
	}
	

	/**
	 * 
	 * @param path: path link to "highscore.txt" 
	 * @return (String) top ten high score Player
	 */
	
	private String getTopTenTable(String path){
		String[][] data = initData(path);
		String result = str_headerTopPlayer;
		for(int i = 0 ; i < 10 ; i++){
			String Player = String.format("%d \t%s \t%s\n", (i+1),data[i][1], data[i][0]);
			result += Player;
		}

		return result;
	}
	
	/**
	 * 
	 * @param path: path link to "highscore.txt" 
	 * @return (String) array 2-Dimension sorted
	 */
	private String[][] initData(String path){
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
		catch (FileNotFoundException  | NumberFormatException | ArrayIndexOutOfBoundsException e ) {
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
		
		return data;
	}
	
	/**
	 * 
	 * @param data (String) array 2-Dimension: many rows, 2 column: score;name. 2 column separated by ";"
	 * @param score (String) score of new Player 
	 * @param name (String) name of new Player
	 * @return (String) top ten high score Player include new Player (if had)
	 */
	
	private String insertData(String[][] data, String score, String name){
		int max = 0,num;
		int iCount = 10;
		data[9][0] = score;
		data[9][1] = name;
		try {
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
		}
		catch (NumberFormatException | ArrayIndexOutOfBoundsException e ) {
			JOptionPane.showMessageDialog(null, "data corrupted");
		}
		String result = str_headerTopPlayer;
		for(int i = 0 ; i < 10 ; i++){
			String Player = String.format("%d \t%s \t%s\n", (i+1),data[i][1], data[i][0]);
			result += Player;
		}

		return result;
	}
}
