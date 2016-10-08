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

public class cDraw2 extends JPanel{

	int nRow = 12, nCol = 12;
	int w= 20, h=20;
	int x0 =0, y0=0;
	Timer tmTemp;
	boolean moveU_D,moveL_R;
	public void paint(Graphics g){

		super.paint(g);
		int P_WIDTH = nCol*w, P_HEIGHT = nRow*h;
		for(int i = 0 ; i <= nCol ; i++){
			g.drawLine(i*w, y0, i*w, y0+ P_HEIGHT);
		}
		for(int i = 0 ; i <= nRow ; i++){
			g.drawLine(x0, i*h, x0+P_WIDTH, i*h );
		}
		for(int i = 0; i < nRow ;i++){
			for(int j = 0 ; j < nCol ; j++){
				if( arr[i][j]==1){
					g.setColor(Color.RED);
				}
				if( arr[i][j]==2){
					g.setColor(Color.BLUE);
				}
				if( arr[i][j]==0){
					g.setColor(Color.WHITE);
				}
				if( arr[i][j]==3){
					g.setColor(Color.GREEN);
				}
				g.fillRect(x0+j*w+1, y0+i*h+1,	w-2, h-2);
			}
		}
		
	}
	
	int[][] arr = new int[nRow][nCol];
	int[][] snk= new int [100][2];
	int len_snk=0 ;
	JButton btnS = new JButton("Stop"), btnNew = new JButton("New"),
			btnNewBait = new JButton("NewBait"), btnPrintSnk = new JButton("Print");
	String strAction = "";
	boolean firstRun = false;
	
	//variable for Bait
	Random rd = new Random();
	boolean isBaitShow = false;
	int baitLocation = 0;
	int bRow = 0;
	int bCol = 0;
	
	public cDraw2(){
		//
		setLayout(null);
		add(btnS);
		add(btnNew);
		add(btnNewBait);
		add(lblPoint);
		add(btnPrintSnk);
		//
		btnS.setBounds(50,280,90,30);
		btnNew.setBounds(170,280,90,30);
		btnNewBait.setBounds(50,320,90,30);
		lblPoint.setBounds(180, 320,90,30);
		btnPrintSnk.setBounds(300,280,70,30);
		//addActionListener
		btnPrintSnk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(int j = 0 ; j <len_snk;j++){
					System.out.println(snk[j][0] + " " + snk[j][1]);
				}
			}
		});
		btnNewBait.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				createBait();
			}
		});
		btnNew.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (strAction.equals("moveRight")){
					len_snk+=1;
					for(int i = len_snk ; i >= 1 ; i--){
						snk[i][0] = snk[i-1][0];
						snk[i][1] = snk[i-1][1];
					}
					snk[0][0] = snk[1][0];
					snk[0][1] = snk[1][1]-1;
					arr[snk[len_snk-1][0]][snk[len_snk-1][1]] = 2;
					/*arr[snk[len_snk-1][0]][snk[len_snk-1][1]] = 1; //change head to 1
					System.out.println("Head: " +snk[len_snk-1][0] + " " +snk[len_snk-1][1] + "\tLength: "+(len_snk+1));
					len_snk+=1;
					snk[len_snk-1][0]=snk[len_snk-2][0]; //new head
					snk[len_snk-1][1]=snk[len_snk-2][1]+1; //new head
					if( snk[len_snk-1][1]>=nCol){
						snk[len_snk-1][1]= 0;
					}
					arr[snk[len_snk-1][0]][snk[len_snk-1][1]] = 2; //color head
*/					
					repaint();
				}
			}
		});
		
		KeyListener move = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getKeyCode() == KeyEvent.VK_UP && !moveU_D){
					strAction = "moveUp";
					moveU_D = true;
					moveL_R = false;
				}
				else if (arg0.getKeyCode() == KeyEvent.VK_DOWN && !moveU_D){
					strAction = "moveDown";
					moveU_D = true;
					moveL_R = false;
				}
				else if (arg0.getKeyCode() == KeyEvent.VK_LEFT && !moveL_R){
					strAction = "moveLeft";
					moveL_R = true;
					moveU_D = false;
				}
				else if (arg0.getKeyCode() == KeyEvent.VK_RIGHT && !moveL_R){
					strAction = "moveRight";
					moveL_R = true;
					moveU_D = false;
				}
				//System.out.println(strAction);
			}
		};
		
		btnS.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(btnS.getText().equals("Stop")){
					tmTemp.stop();
					btnS.setText("Start");
				}
				else{
					tmTemp.start();
					btnS.setText("Stop");
				}
			}
		});
		btnS.addKeyListener(move);
		btnNew.addKeyListener(move);
		
		for(int i = 0; i < nRow ;i++){
			for(int j = 0 ; j < nCol ; j++){
				arr[i][j] = 0;// ((int)(Math.random()*10)%3);
				//System.out.print(arr[i][j]+ " ");
			}
			//System.out.println();
		}
		
		snk[0][0]=3;
		snk[0][1]=3;
		snk[1][0]=3;
		snk[1][1]=4;
		snk[2][0]=3;
		snk[2][1]=5;
		arr[snk[0][0]][snk[0][1]] = 1;
		arr[snk[1][0]][snk[1][1]] = 1;
		arr[snk[2][0]][snk[2][1]] = 2;
		len_snk = 3;
		
		tmTemp = new Timer(500, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(strAction.equals("moveUp")){
					move(strAction);
				}
				else if(strAction.equals("moveDown")) {
					move(strAction);
				}
				else if(strAction.equals("moveLeft")) {
					move(strAction);
				}
				else if(strAction.equals("moveRight")) {
					move(strAction);
				}
				eatingBait();
			}
		});
		
		if(!firstRun){
			tmTemp.start();
			strAction="moveRight";
			move(strAction);
			createBait();
			System.out.println(strAction);
			firstRun=true; 
		}
		
		
	}
	public void move(String mv){
		
		/*
		 int[][] snk= {
			{3, 1},
			{3, 2},
			{3, 3},			
			};
		 */
		
		
		/*arr[snk[0][0]][snk[0][1]] = 0;
		arr[snk[1][0]][snk[1][1]] = 0;
		arr[snk[2][0]][snk[2][1]] = 0;
		*/
		for(int i = 0 ; i < len_snk ; i++){
			arr[snk[i][0]][snk[i][1]]=0;
		}
		
		/*snk[0][0] = snk[1][0];
		snk[0][1] = snk[1][1];
		snk[1][0] = snk[2][0];
		snk[1][1] = snk[2][1];*/
		for(int i = 0 ; i < len_snk-1;i++){
			for(int j = 0 ; j < 2 ; j++){
				snk[i][j]=snk[i+1][j];
			}
		}
		
		if(mv.equals("moveRight")){
			snk[len_snk-1][0] = snk[len_snk-1][0];		
			snk[len_snk-1][1] = snk[len_snk-1][1]+1;  //move right at row snk[2][0] (3 is here) - colum +1 right side
		}
		else if (mv.equals("moveLeft")){
			snk[len_snk-1][0] = snk[len_snk-1][0];		
			snk[len_snk-1][1] = snk[len_snk-1][1]-1;
		}
		else if (mv.equals("moveUp")){
			snk[len_snk-1][0] = snk[len_snk-1][0]-1;
			snk[len_snk-1][1] = snk[len_snk-1][1];
		}
		else if (mv.equals("moveDown")){
			snk[len_snk-1][0] = snk[len_snk-1][0]+1;
			snk[len_snk-1][1] = snk[len_snk-1][1];
		}
		//if moveRight > 9
		if( snk[len_snk-1][1]>=nCol){
			snk[len_snk-1][1]= 0;
		}
		if( snk[len_snk-1][1]<0){
			snk[len_snk-1][1]= nCol -1;
		}
		if( snk[len_snk-1][0]<0){
			snk[len_snk-1][0]= nRow-1;
		}
		if( snk[len_snk-1][0]>=nRow){
			snk[len_snk-1][0]= 0;
		}
		
		for(int i = 0 ; i < len_snk; i++){
			arr[snk[i][0]][snk[i][1]]=1;
		}
		arr[snk[len_snk-1][0]][snk[len_snk-1][1]] = 2;
		
		repaint();
	}
	
	public void createBait(){
		//baitLocation = (int)(Math.random()*100);
		
		bRow = rd.nextInt(nRow);
		bCol = rd.nextInt(nCol);
		
		
		if(!isBaitShow){
			for(int i = 0 ; i < len_snk ; i++){
				if(bRow != snk[i][0]){
					arr[bRow][bCol] = 3;
					isBaitShow = true;
					break;
				}
				else{
					if(bCol != snk[i][1]){
						System.out.println("Bait 2: "+bRow + "-" + bCol);
						arr[bRow][bCol] = 3;
						isBaitShow = true;
						break;
					}
					else{
						System.out.println("MATCH! Create new bait");
						createBait();
						isBaitShow = false;
						break;
					}
				}
			}
		}
		
		repaint();
		
		/*if(!isBaitShow){
			//System.out.println(baitLocation);
			System.out.println("Bait: "+bRow + "-" + bCol);
			
			for(int i = 0;i<len_snk;i++){
				
				if(snk[i][0] != bRow || snk[i][1] != bCol){
					//isBaitShow = true;
					arr[bRow][bCol] = 3;
					break;
				}
				else{
					//isBaitShow=false;
					
					System.out.println(snk[i][0] == bRow);
					System.out.println(snk[i][1] == bCol);
					System.out.println("MATCH! Bait("+bRow+" "+bCol+")"+"\tCreate new Bait " );
					//tmTemp.stop();
					for(int j = 0 ; j <len_snk;j++){
						System.out.println(snk[j][0] + " " + snk[j][1]);
					}
					System.out.println(snk[i][0] == bRow);
					System.out.println(snk[i][1] == bCol);
					
					
			
				}
			}
			if(isBaitShow=true){
				arr[bRow][bCol] = 3;
			}
			else{
				createBait();
			}
			
		}*/

	}
	
		
	JLabel lblPoint = new JLabel("Point: 0");
	public void eatingBait(){
		if(snk[len_snk-1][0]==bRow && snk[len_snk-1][1]==bCol){
			System.out.println("HIT Bait");
			isBaitShow=false;
			createBait();
			
			if (strAction.equals("moveRight")){
				len_snk+=1;
				for(int i = len_snk ; i >= 1 ; i--){
					snk[i][0] = snk[i-1][0];
					snk[i][1] = snk[i-1][1];
				}
				snk[0][0] = snk[1][0];
				snk[0][1] = snk[1][1]-1;
				if( snk[0][1] <0){
					snk[0][1]= nCol - 1;
				}
				arr[snk[len_snk-1][0]][snk[len_snk-1][1]] = 2;
			}
			else if (strAction.equals("moveLeft")){
				len_snk+=1;
				for(int i = len_snk ; i >= 1 ; i--){
					snk[i][0] = snk[i-1][0];
					snk[i][1] = snk[i-1][1];
				}
				snk[0][0] = snk[1][0];
				snk[0][1] = snk[1][1]+1;
				if( snk[0][1] >=nCol){
					snk[0][1]= 0;
				}
				arr[snk[len_snk-1][0]][snk[len_snk-1][1]] = 2;
			}
			else if (strAction.equals("moveUp")){
				len_snk+=1;
				for(int i = len_snk ; i >= 1 ; i--){
					snk[i][0] = snk[i-1][0];
					snk[i][1] = snk[i-1][1];
				}
				snk[0][0] = snk[1][0]-1;
				snk[0][1] = snk[1][1];
				if( snk[0][0] <0){
					snk[0][0]= nRow -1;
				}
				arr[snk[len_snk-1][0]][snk[len_snk-1][1]] = 2;
			}
			else if (strAction.equals("moveDown")){
				len_snk+=1;
				for(int i = len_snk ; i >= 1 ; i--){
					snk[i][0] = snk[i-1][0];
					snk[i][1] = snk[i-1][1];
				}
				snk[0][0] = snk[1][0]+1;
				snk[0][1] = snk[1][1];
				if( snk[0][0] >=nRow){
					snk[0][0]= 0;
				}
				arr[snk[len_snk-1][0]][snk[len_snk-1][1]] = 2;
			}
			/*if (strAction.equals("moveRight")){
				arr[snk[len_snk-1][0]][snk[len_snk-1][1]] = 1; //change head to 1
				len_snk+=1;
				snk[len_snk-1][0]=snk[len_snk-2][0]; //new head
				snk[len_snk-1][1]=snk[len_snk-2][1]+1; //new head +1 colum right side
				if( snk[len_snk-1][1]>=nCol){
					snk[len_snk-1][1]= 0;
				}
				arr[snk[len_snk-1][0]][snk[len_snk-1][1]] = 2; //color head
				
			}
			else if (strAction.equals("moveLeft")){
				arr[snk[len_snk-1][0]][snk[len_snk-1][1]] = 1; //change head to 1
				len_snk+=1;
				snk[len_snk-1][0]=snk[len_snk-2][0]; //new head
				snk[len_snk-1][1]=snk[len_snk-2][1]-1; //new head +1 colum right side
				if( snk[len_snk-1][1] <0){
					snk[len_snk-1][1]= nCol - 1;
				}
				arr[snk[len_snk-1][0]][snk[len_snk-1][1]] = 2; //color head
			}
			else if (strAction.equals("moveUp")){
				arr[snk[len_snk-1][0]][snk[len_snk-1][1]] = 1; //change head to 1
				len_snk+=1;
				snk[len_snk-1][0]=snk[len_snk-2][0]-1; //new head
				snk[len_snk-1][1]=snk[len_snk-2][1]; //new head +1 colum right side
				if( snk[len_snk-1][0] <0){
					snk[len_snk-1][0]= nRow - 1;
				}
				arr[snk[len_snk-1][0]][snk[len_snk-1][1]] = 2; //color head
			}
			else if (strAction.equals("moveDown")){
				arr[snk[len_snk-1][0]][snk[len_snk-1][1]] = 1; //change head to 1
				len_snk+=1;
				snk[len_snk-1][0]=snk[len_snk-2][0]+1; //new head
				snk[len_snk-1][1]=snk[len_snk-2][1]; //new head +1 colum right side
				if( snk[len_snk-1][0] >= nRow){
					snk[len_snk-1][0]= 0;
				}
				arr[snk[len_snk-1][0]][snk[len_snk-1][1]] = 2; //color head
			}*/
			
			repaint();
			lblPoint.setText("Point: " +(len_snk-3));
		}
		
	}
	
/*
	public void moveRight(){
		
		arr[snk[0][0]][snk[0][1]] = 0;
		arr[snk[1][0]][snk[1][1]] = 0;
		arr[snk[2][0]][snk[2][1]] = 0;
		
		
		 int[][] snk= {
			{3, 1},
			{3, 2},
			{3, 3},			
			};
		 
		snk[0][0] = snk[1][0];
		snk[0][1] = snk[1][1];
		snk[1][0] = snk[2][0];
		snk[1][1] = snk[2][1];
		snk[2][0] = snk[2][0];		
		snk[2][1] = snk[2][1]+1;  //move right at row snk[2][0] (3 is here) - colum +1 right side
		if( snk[2][1]>=nCol){
			snk[2][1]= 0;
		}
		
		arr[snk[0][0]][snk[0][1]] = 1;
		arr[snk[1][0]][snk[1][1]] = 1;
		arr[snk[2][0]][snk[2][1]] = 2;
		
		repaint();
	}

	public void moveLeft(){
		arr[snk[0][0]][snk[0][1]] = 0;
		arr[snk[1][0]][snk[1][1]] = 0;
		arr[snk[2][0]][snk[2][1]] = 0;

		//int hx =snk[0][0], hy= snk[0][0];
		
		 int[][] snk= {
			{3, 1},
			{3, 2},
			{3, 3},			
			};
		 
		
		snk[0][0] = snk[1][0];
		snk[0][1] = snk[1][1];
		snk[1][0] = snk[2][0];
		snk[1][1] = snk[2][1];
		snk[2][0] = snk[2][0];		
		snk[2][1] = snk[2][1]-1;
		
		if( snk[2][1]<0){
			snk[2][1]= nCol -1;
		}
		
		arr[snk[0][0]][snk[0][1]] = 1;
		arr[snk[1][0]][snk[1][1]] = 1;
		arr[snk[2][0]][snk[2][1]] = 2;
		
		repaint();
		
	}
	
	public void moveUp(){
		
		arr[snk[0][0]][snk[0][1]] = 0;
		arr[snk[1][0]][snk[1][1]] = 0;
		arr[snk[2][0]][snk[2][1]] = 0;
		
		
		 int[][] snk= {
			{3, 1},
			{3, 2},
			{3, 3},			
			};
		 
		snk[0][0] = snk[1][0];
		snk[0][1] = snk[1][1];
		snk[1][0] = snk[2][0];
		snk[1][1] = snk[2][1];
		snk[2][0] = snk[2][0]-1;
		snk[2][1] = snk[2][1];
		if( snk[2][0]<0){
			snk[2][0]= nRow-1;
		}
		
		arr[snk[0][0]][snk[0][1]] = 1;
		arr[snk[1][0]][snk[1][1]] = 1;
		arr[snk[2][0]][snk[2][1]] = 2;
		
		repaint();
	}
	
	public void moveDown(){
		
		arr[snk[0][0]][snk[0][1]] = 0;
		arr[snk[1][0]][snk[1][1]] = 0;
		arr[snk[2][0]][snk[2][1]] = 0;
		
		
		 int[][] snk= {
			{3, 1},
			{3, 2},
			{3, 3},			
			};
		 
		snk[0][0] = snk[1][0];
		snk[0][1] = snk[1][1];
		snk[1][0] = snk[2][0];
		snk[1][1] = snk[2][1];
		snk[2][0] = snk[2][0]+1;
		snk[2][1] = snk[2][1];
		if( snk[2][0]>=nRow){
			snk[2][0]= 0;
		}
		
		arr[snk[0][0]][snk[0][1]] = 1;
		arr[snk[1][0]][snk[1][1]] = 1;
		arr[snk[2][0]][snk[2][1]] = 2;
		
		repaint();
	}
*/
}
