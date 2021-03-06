package pWE12B_Snack_T151487;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class cWE12B_Snack_T151487 extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5191990402189366249L;

	public static void main(String[] args){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());;
		}
		cWE12B_Snack_T151487 frame = new cWE12B_Snack_T151487();
		frame.setVisible(true);
	}
	
	private static int WIDTH = 550, HEIGHT = 750;
	
	public cWE12B_Snack_T151487() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("T151487 - Snack");
		setLayout(null);
		pack();
		
		//init components
		initComponents();
	}
	
	JLabel lblInputRow = new JLabel("Input Row: ");
	JTextField txtRow = new JTextField();
	JLabel lblInputCol = new JLabel("Input Col: ");
	JTextField txtCol = new JTextField();
	JButton btnAction = new JButton("Action"),
			btnDraw = new JButton("Draw"),
			btnRun = new JButton("Run");
	KeyListener InputNum;
	
	
	drawPanel panelSnack = new drawPanel();
	
	private void initComponents(){
		//add
		add(lblInputRow);
		add(lblInputCol);
		add(txtRow);
		add(txtCol);
		add(btnAction);
		//setbounds
		lblInputRow.setBounds(10, 10, 60, 30);
		txtRow.setBounds(70, 10, 40, 30);
		lblInputCol.setBounds(140, 18, 60, 10);
		txtCol.setBounds(200, 10, 40, 30);
		add(btnDraw);
		btnDraw.setBounds(270, 10, 70, 30);
		btnAction.setBounds(355, 10, 70, 30);
		add(btnRun);
		btnRun.setBounds(440, 10, 70, 30);
		btnRun.setEnabled(false);
		InputNum = new KeyListener() {
			
			public void keyTyped(KeyEvent arg0) {
				if(arg0.getKeyChar() < '0' || arg0.getKeyChar() > '9'){
					arg0.consume();
				}
			}
			
			public void keyReleased(KeyEvent arg0) { }
			
			public void keyPressed(KeyEvent arg0) { }
		};
		txtRow.addKeyListener(InputNum);
		txtCol.addKeyListener(InputNum);
		//
		add(panelSnack);
		int h0_panel = 60;
		panelSnack.setBounds(5, h0_panel, WIDTH-25+1, 650+1);
		//panelSnack.setBorder(new EtchedBorder());
		panelSnack.setVisible(false);
		
		ActionListener actionButton = new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource() == btnDraw){
					drawPanel();
				}
				if(arg0.getSource() == btnAction){
					openFile();
				}
				if(arg0.getSource() == btnRun){
					panelSnack.moving();
				}
			}
		};
		
		btnDraw.addActionListener(actionButton);
		btnAction.addActionListener(actionButton);
		btnRun.addActionListener(actionButton);
	}
	
	private void drawPanel(){
		int x= 0, y= 0;
		try {
			if(txtRow.getText().isEmpty()){
				x = 0;
			}
			else{
				x = Integer.parseInt(txtRow.getText());
			}
			if(txtCol.getText().isEmpty()){
				y = 0;
			}
			else{
				y = Integer.parseInt(txtCol.getText());
			}
			if(x>=10 && y >= 10){
				panelSnack.setData(x, y);
				panelSnack.setVisible(true);
			}
			else{
				JOptionPane.showMessageDialog(null, "Row and Collum must greater or equal 10");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
	
	JFileChooser fchChooser = new JFileChooser();
	File currentFile;
	int[] move = new int[10000];
	int iCount = 0;
	
	private void openFile(){
		int result = fchChooser.showOpenDialog(this);
		
		if(result == JFileChooser.APPROVE_OPTION){
			try {
				Scanner reader = new Scanner(fchChooser.getSelectedFile());
				currentFile = fchChooser.getSelectedFile();
				//this.setTitle(currentFile.getName());
				iCount = 0;
				while(reader.hasNextInt()){
					move[iCount] = reader.nextInt();
					iCount++;
				}
				reader.close();
				panelSnack.setAction(move,iCount);
				btnRun.setEnabled(true);
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "File not found");
			}
		}
	}
}

class drawPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6097374446179664415L;
	int xMax = 520, yMax = 650;
	int x0 = 10, y0 = 10, r0 = 30;
	int nRow = 0, nCol = 0;
	int[][] data;
	int[][] snk = {
			{0,2},
			{0,1},
			{0,0}
	};
	
	
	
	public void paint(Graphics g){
		super.paint(g);
		//draw Row
		for(int i = 0 ; i <= nRow ; i++){
			g.drawLine(x0, y0 + r0*i, x0 + r0*nCol, y0+r0*i);
		}
		//draw Collum
		for(int i = 0 ; i <= nCol ; i++){
			g.drawLine(x0 + r0*i, y0, x0 + r0*i, y0 + r0*nRow);
		}
		
		for(int i = 0 ; i < nRow ; i++){
			for(int j = 0 ; j < nCol ; j++){
				g.setColor(Color.WHITE);
				if(data[i][j] == 1){
					g.setColor(Color.GREEN);
				}
				if(data[i][j] == 2){
					g.setColor(Color.RED);
				}
				g.fillRect(x0 + r0*j+1, y0 + r0*i +1, r0-1, r0-1);
				//System.out.print(data[i][j] + " ");
			}
			//System.out.println();
		}
	}
	
	public void setData(int x, int y){
		this.nRow = x;
		this.nCol = y;
		data = new int[x][y];
		for(int i = 0 ; i < nRow ; i++){
			for(int j = 0 ; j < nCol ; j++){
				data[i][j] = 0;
			}
		}
		data[snk[0][0]][snk[0][1]] = 2;
		data[snk[1][0]][snk[1][1]] = 1;
		data[snk[2][0]][snk[2][1]] = 1;
		repaint();
	}
	
	int[] move;
	int iCount = 0;
	public void setAction(int[] move, int n){
		this.move = new int[n];
		this.iCount = n;
		for(int i = 0 ; i < n ; i++){
			this.move[i] = move[i];
			//System.out.println(this.move[i]);
		}
	}
	
	
	Timer t1;
	int direction = 2; //snake is moving right by default; 1:left; 3: up, 4: down
	
	public drawPanel() {
		t1 = new Timer(1000, new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String strCantmove = "hit wall or illegal direction";
				if(move[step] == 0 ){ 
					if(snk[0][1] -1 >=0 && direction != 2){ //move left => snake can't moving right
						direction = 1;
						move(direction);
						System.out.println(move[step] +": move left");
					}
					else{
						System.out.println(strCantmove);
					}
				}
				if(move[step] == 1 ){ 
					if(snk[0][0] -1 >= 0 && direction != 4){ //move up => snake can't moving down
						direction = 3;
						move(direction);
						System.out.println(move[step] + ": move up");
					}
					else{
						System.out.println(strCantmove);
					}
				}
				if(move[step] == 2 ){ 
					if(snk[0][0] +1 < nRow && direction != 3){ //move down => snake can't moving up
						direction = 4;
						move(direction);
						System.out.println(move[step] + ": move down");
					}
					else{
						System.out.println(strCantmove);
					}
				}
				if(move[step] == 3 ){ 
					if(snk[0][1] +1 < nCol && direction != 1){ //move right => snake can't moving left
						direction = 2;
						move(direction);
						System.out.println(move[step] +": move right");
					}
					else{
						System.out.println(strCantmove);
					}
				}
				step++;
				if(step>= iCount){
					System.out.println("end moving");
					t1.stop();
				}
			}
		});
	}
	
	int step = 0;
	public void moving(){
		step=0;
		t1.start();
	}
	
	
	public void move(int key){
		
		for(int i = 0 ; i < 3 ; i++){
			data[snk[i][0]][snk[i][1]]=0;
		}
		
		for(int i = 2 ; i >= 1 ; i--){
			snk[i][0]=snk[i-1][0];
			snk[i][1]=snk[i-1][1];
		}
		
		if(key == 1){
			snk[0][0] = snk[0][0];
			snk[0][1] -= 1;
		}
		else if(key == 2){
			snk[0][0] = snk[0][0];
			snk[0][1] += 1;
		}
		else if(key == 3){
			snk[0][0] -= 1;
			snk[0][1] = snk[0][1];
		}
		else if(key == 4){
			snk[0][0] += 1;
			snk[0][1] = snk[0][1];
		}
		
		for(int i = 1 ; i < 3; i++){
			data[snk[i][0]][snk[i][1]]=1;
		}
		data[snk[0][0]][snk[0][1]] = 2;
		
		repaint();
	}
	
}
