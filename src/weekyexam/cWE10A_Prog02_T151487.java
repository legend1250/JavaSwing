package weekyexam;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Timer;
import javax.swing.JTextField;

public class cWE10A_Prog02_T151487 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cWE10A_Prog02_T151487 frame = new cWE10A_Prog02_T151487();
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
	
	Timer t;
	boolean moving = true;
	int ti = 0;
	int[] actArray = new int[10000];
	int actCount = 0;
	int x = 282, y = 96;
	private JTextField txtInput;
	
	JFileChooser fchOpen = new JFileChooser();
	
	public cWE10A_Prog02_T151487() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				t.start();
			}
		});
		btnPlay.setBounds(436, 11, 89, 32);
		contentPane.add(btnPlay);
		
		JButton btnPause = new JButton("Pause");
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.stop();
			}
		});
		btnPause.setBounds(544, 11, 89, 32);
		contentPane.add(btnPause);
		
		int width = 90;
		int height = 60;
		
		panelRectangle panelRectangle = new panelRectangle();
		panelRectangle.setBounds(x, y, width+1, height+1);
		panelRectangle.setWidth(width);
		panelRectangle.setHeight(height);
		contentPane.add(panelRectangle);
		
		txtInput = new JTextField();
		txtInput.setEditable(false);
		txtInput.setBounds(10, 11, 295, 32);
		contentPane.add(txtInput);
		txtInput.setColumns(10);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFile();
			}
		});
		btnBrowse.setBounds(327, 11, 81, 32);
		contentPane.add(btnBrowse);
		
		t = new Timer(200, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				/*if(moving){
					t.start();
				}*/
				
				
				if(Math.abs(ti) > 30){
					moving = false;
					x+=ti;
					ti = 0;
					actCount++;
					if(actCount >= actArray.length){
						t.stop();
					}
					if(actArray[actCount]==1){
						System.out.println("move right");
					}
					else if(actArray[actCount] == 0){
						System.out.println("move left");
					}
				}
				else{
					panelRectangle.setLocation(x+ti, y);
					//System.out.println(x+ti);
				}
				
				if(actArray[actCount] == 1){
					ti++;
				}
				else if (actArray[actCount] == 0){
					ti--;
				}
			}
		});
		
	}
	
	private void openFile(){
		int result = fchOpen.showOpenDialog(this);
		if(result == fchOpen.APPROVE_OPTION){
			try {
				Scanner reader = new Scanner(new FileReader(fchOpen.getSelectedFile()));
				int i = 0;
				while(reader.hasNextInt()){
					actArray[i] = reader.nextInt();
				}
				reader.close();
				setAct(actArray);
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void setAct(int[] act) {
		this.actArray = act;
	}
}

class panelRectangle extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8408764561202437255L;
	
	int width, height;
	
	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void paint(Graphics g){
		g.setColor(Color.RED);
		g.drawRect(0, 0, width, height);
	}
}
