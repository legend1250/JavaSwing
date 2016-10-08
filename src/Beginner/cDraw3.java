package Beginner;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class cDraw3 extends JPanel{

	int nRow = 15, nCol = 15;
	int w= 20, h=20;
	int x0 =0, y0=0;
	int[][] arr = new int[nRow][nCol];
	int[][] snk= new int [100][2];
	int snk_length = 3;
	
	Timer tmTemp;
	
	
	public void paint(Graphics g){
		
		//paint snake
		super.paint(g);
		int P_WIDTH = nCol*w, P_HEIGHT = nRow*h;
		for(int i = 0 ; i <= nCol ; i++){
			//g.drawLine(i*w, y0, i*w, y0+ P_HEIGHT);
		}
		for(int i = 0 ; i <= nRow ; i++){
			//g.drawLine(x0, i*h, x0+P_WIDTH, i*h );
		}
		for(int i = 0; i < nRow ;i++){
			for(int j = 0 ; j < nCol ; j++){
				if( arr[i][j]==1){
					g.setColor(Color.GREEN);	//body color
				}
				if( arr[i][j]==2){
					g.setColor(Color.RED);	//head color
				}
				if( arr[i][j]==3){
					g.setColor(Color.BLUE);	//bait color
				}
				if( arr[i][j]==0){
					g.setColor(Color.WHITE);	//background color
				}
				
				g.fillRect(x0+j*w+1, y0+i*h+1,	w-2, h-2);
			}
		}
		
	}
	
	JButton btnStart = new JButton("Start"), btnNewbody = new JButton("NewBody"),
			btnNewBait = new JButton("NewBait");
	JLabel lblPoint = new JLabel("Point: 0");
	//moving variable
	String strMove = "";
	boolean moveU_D,moveL_R;
	//first run variable
	boolean isFirstRun = true;
	//bait variable
	boolean isMatchSnk=false;
	Random rd = new Random();
	int bRow = 0;
	int bCol = 0;
	
	public cDraw3(){
		//create Snake
		snk[0][0]=3;
		snk[0][1]=5;
		snk[1][0]=3;
		snk[1][1]=4;
		snk[2][0]=3;
		snk[2][1]=3;
		arr[snk[0][0]][snk[0][1]] = 2;	//head
		arr[snk[1][0]][snk[1][1]] = 1;	//body
		arr[snk[2][0]][snk[2][1]] = 1;	//body
		//setLayout
		setLayout(null);
		
		//add component
		add(btnStart);
		add(btnNewbody);
		add(lblPoint);
		add(btnNewBait);
		
		//set location component
		lblPoint.setBounds(310,30,90,30);
		btnStart.setBounds(40,350,90,30);
		btnNewbody.setBounds(150,350,90,30);
		btnNewBait.setBounds(40,420,90,30);
		//add Actionlistener
		
		btnStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// TODO Auto-generated method stub
				if(isFirstRun){
					tmTemp.start();
					createBait();
					strMove = "moveRight";
					isFirstRun = false;
					btnStart.setText("Stop");
				}
				else {
					if(btnStart.getText().equals("Stop")){
						tmTemp.stop();
						System.out.println("Stop");
						btnStart.setText("Start");
					}
					else {
						tmTemp.start();
						System.out.println("Start");
						btnStart.setText("Stop");
					}
				}
				
			}
		});
		
		btnStart.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getKeyCode() == KeyEvent.VK_UP && !moveU_D){
					strMove = "moveUp";
					moveU_D = true;
					moveL_R = false;
				}
				else if (arg0.getKeyCode() == KeyEvent.VK_DOWN && !moveU_D){
					strMove = "moveDown";
					moveU_D = true;
					moveL_R = false;
				}
				else if (arg0.getKeyCode() == KeyEvent.VK_LEFT && !moveL_R){
					strMove = "moveLeft";
					moveL_R = true;
					moveU_D = false;
				}
				else if (arg0.getKeyCode() == KeyEvent.VK_RIGHT && !moveL_R){
					strMove = "moveRight";
					moveL_R = true;
					moveU_D = false;
				}
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		tmTemp = new Timer(200, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				move(strMove);
				hitBait();
				lblPoint.setText("Point: " +(snk_length-3));
			}
		});
		
		btnNewbody.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				newbody();
			}
		});
		
		btnNewBait.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				createBait();
			}
		});
	}
	
	public void move(String move){
		
		//no paint snake
		for(int i = 0 ; i < snk_length ; i++){
			arr[snk[i][0]][snk[i][1]]=0;
		}
		
		for(int i = snk_length-1 ; i >= 1 ; i--){
			
			snk[i][0]=snk[i-1][0];
			snk[i][1]=snk[i-1][1];
		}
		
		if(move.equals("moveRight")){
			snk[0][0] = snk[0][0];
			snk[0][1] += 1;
			if(snk[0][1] >= nCol){
				snk[0][1] = 0;
			}
		}
		else if (move.equals("moveLeft")){
			snk[0][0] = snk[0][0];
			snk[0][1] -= 1;
			if(snk[0][1] < 0){
				snk[0][1] = nCol-1;
			}
		}
		else if (move.equals("moveUp")){
			snk[0][0] -= 1;
			snk[0][1] = snk[0][1];
			if(snk[0][0] < 0){
				snk[0][0] = nRow-1;
			}
		}
		else if (move.equals("moveDown")){
			snk[0][0] += 1;
			snk[0][1] = snk[0][1];
			if(snk[0][0] >= nRow){
				snk[0][0] = 0;
			}
		}
		
		//repaint snake
		arr[snk[0][0]][snk[0][1]] = 2;
		for(int i = 1 ; i < snk_length; i++){
			arr[snk[i][0]][snk[i][1]]=1;
		}
		
		repaint();
	}
	
	public void newbody(){
		
		snk[snk_length][0] = snk[snk_length-1][0];
		snk[snk_length][1] = snk[snk_length-1][1];
		snk_length+=1;
		
		repaint();
	}
	
	public void createBait(){
		bRow = rd.nextInt(nRow);
		bCol = rd.nextInt(nCol);
		
		for(int i = 0 ; i < snk_length ; i++){
			if (bRow != snk[i][0] || bCol != snk[i][1]){
				arr[bRow][bCol] = 3;
				//System.out.println("New bait: "+bRow + " " + bCol);
				
			}
			else{
				System.out.println("MATCH BAIT: "+bRow + " " + bCol);
				createBait();
				break;
			}
		}
		System.out.println("New bait: "+bRow + " " + bCol);
		
		/*if(!isMatchSnk){
			arr[bRow][bCol] = 3;
			System.out.println("New bait: "+bRow + " " + bCol);
		}
		else{
			System.out.println("MATCH BAIT: "+bRow + " " + bCol);
			createBait();
		}*/
	
	}
	
	public void hitBait(){
		if(snk[0][0] == bRow && snk[0][1] == bCol){
			arr[bRow][bCol]=2;	//change color bait into head
			createBait();
			newbody();
			System.out.println("HIT Bait");
		}
	}

}
