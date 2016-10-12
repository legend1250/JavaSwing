package beginner;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class cXepGachPanel2_error extends JPanel{

	int nRow = 30, nCol = 20;
	int w= 15, h=15;
	int x0 =100, y0=20;
	int numLength=0;
	int[][] brick = new int[nRow][nCol];
	int[][] arr = new int [nRow*nCol][2];
	int[][] add = new int [4][2];
	//next brick
	int[][] nextbrick = new int[3][4];
	int x00 = 500;
	
	public void paint(Graphics g){
		super.paint(g);
		//
		for(int i = 0; i < nRow ;i++){
			for(int j = 0 ; j < nCol ; j++){
				if( brick[i][j]==0){
					g.setColor(Color.WHITE);	//background color
				}
				if( brick[i][j]==1){
					g.setColor(Color.RED);	//next brick background color
				}
				if( brick[i][j]==2){
					g.setColor(Color.GREEN);	//next brick background color
				}
				g.fillRect(x0+j*w+1, y0+i*h+1,	w-2, h-2);
			}
		}
		
		for(int i = 0 ; i < 3 ; i++){
			for(int j = 0 ; j < 4 ; j++){
				if( nextbrick[i][j]==0){
					g.setColor(Color.WHITE);	//next brick background color
				}
				if( nextbrick[i][j]==1){
					g.setColor(Color.BLUE);	//next brick background color
				}
				if( nextbrick[i][j]==2){
					g.setColor(Color.GREEN);	//next brick background color
				}
				g.fillRect(x00+j*w+1, y0+i*h+1,	w-2, h-2);
			}
		}
		
	}
	
	JButton btnStart = new JButton("Start"), btnShow = new JButton("Show");
	//variable new brick
	Random rd = new Random();
	int numNextBrick = 0,numCurrentBrick = 0, count=0;
	boolean firstP = false;
	Timer t;
	//moving variable
	int move = 0, LEFT = 1, RIGHT = 2, UP = 3;
	
	
	public cXepGachPanel2_error(){
		setLayout(null);
		//
		add(btnStart);
		add(btnShow);
		btnStart.setBounds(50,500,80,30);
		btnShow.setBounds(160,500,80,30);
		//
		btnStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(btnStart.getText().equals("Start")){
					newBrick();
					t.start();
					btnStart.setText("Stop");
				}
				else{
					t.stop();
					btnStart.setText("Start");
				}
			}
		});
		
		btnShow.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("show: ");
				for(int i = 0 ; i < numLength;i++){
					System.out.println(arr[i][0] + " " +arr[i][1]);
				}
			}
		});
		//draw background
		for(int i = 0; i < nRow ;i++){
			for(int j = 0 ; j < nCol ; j++){
				brick[i][j] = 0;
			}
		}
		
		t = new Timer(200, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				/*if(brick[0][7] > 0 || brick[0][8] > 0 || brick[0][9] > 0 || brick[0][10] > 0 ){
					t.stop();
					System.out.println("Game Over");
				}*/
				move();
				
			}
		});
		
		KeyListener moving = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_LEFT){
					move = LEFT;
				}
				else if (e.getKeyCode()==KeyEvent.VK_RIGHT){
					move = RIGHT;
				}
			}
		};
		btnStart.addKeyListener(moving);
	}
	
	
	public void newBrick(){
		int n = rd.nextInt(5);
		if(firstP){
			addBrick(getnumNextBrick());
			setnumCurrentBrick(getnumNextBrick());
			showNextBrick(n);
			setnumNextBrick(n);
			
		}
		else{
			int x = rd.nextInt(5);
			addBrick(x);
			setnumCurrentBrick(x);
			showNextBrick(n);
			setnumNextBrick(n);
			firstP = true;
		}
		
	}
	
	public void showNextBrick(int n){
		n+=1;
		String s[] = {
				"square",
				"L",
				"I",
				"Z",
				"T",
		};
		for(int i = 0; i < 3 ;i++){
			for(int j = 0 ; j < 4 ; j++){
				nextbrick[i][j] = 0;
			}
		}
		
		if( n==1){	//hinh vuông
			nextbrick[1][1] = 1;
			nextbrick[1][2] = 1;
			nextbrick[2][1] = 1;
			nextbrick[2][2] = 1;
		}
		else if(n==2){	//hinh L
			nextbrick[0][1] = 1;
			nextbrick[1][1] = 1;
			nextbrick[2][1] = 1;
			nextbrick[2][2] = 1;
		}
		else if(n==3){	//hinh I
			nextbrick[1][0] = 1;
			nextbrick[1][1] = 1;
			nextbrick[1][2] = 1;
			nextbrick[1][3] = 1;
		}
		else if(n==4){	//hinh Z
			nextbrick[1][1] = 1;
			nextbrick[1][2] = 1;
			nextbrick[2][0] = 1;
			nextbrick[2][1] = 1;
		}
		else if(n==5){	//hinh T
			nextbrick[2][1] = 1;
			nextbrick[2][2] = 1;
			nextbrick[2][3] = 1;
			nextbrick[1][2] = 1;
		}
		
		System.out.println("Next: "+s[n-1]);
		
		repaint();
	}
	
	public void addBrick(int n){
		n+=1;
		String s[] = {
				"square",
				"L",
				"I",
				"Z",
				"T",
		};
		for(int i = 0 ; i < 4 ; i++){
			add[i][0] = 0;
			add[i][1] = 0;
		}
		if( n==1){	//hinh vuông
			add[0][0] = 0;
			add[0][1] = 8;
			add[1][0] = 0;
			add[1][1] = 9;
			add[2][0] = 1;
			add[2][1] = 8;
			add[3][0] = 1;
			add[3][1] = 9;
		}
		else if(n==2){	//hinh L
			add[0][0] = 0;
			add[0][1] = 8;
			add[1][0] = 1;
			add[1][1] = 8;
			add[2][0] = 2;
			add[2][1] = 8;
			add[3][0] = 2;
			add[3][1] = 9;
		}
		else if(n==3){	//hinh I
			add[0][0] = 0;
			add[0][1] = 7;
			add[1][0] = 0;
			add[1][1] = 8;
			add[2][0] = 0;
			add[2][1] = 9;
			add[3][0] = 0;
			add[3][1] = 10;
		}
		else if(n==4){	//hinh Z
			add[0][0] = 0;
			add[0][1] = 8;
			add[1][0] = 0;
			add[1][1] = 9;
			add[2][0] = 1;
			add[2][1] = 7;
			add[3][0] = 1;
			add[3][1] = 8;
		}
		else if(n==5){	//hinh T
			add[0][0] = 1;
			add[0][1] = 8;
			add[1][0] = 1;
			add[1][1] = 9;
			add[2][0] = 1;
			add[2][1] = 10;
			add[3][0] = 0;
			add[3][1] = 9;
		}
		
		/*for(int i = 0 ; i < num ; i++){
			arr[i][0] = add[i%num][0];
			arr[i][1] = add[i%num][1];
		}
		num+=4;
		*/
		
		for(int i = numLength; i < numLength +4 ; i++){
			arr[i][0] = add[i%4][0];
			arr[i][1] = add[i%4][1];
			System.out.println(arr[i][0] + " " +arr[i][1]);
		}
		numLength+=4;
		count++;
		
		for(int i = numLength -4 ; i < numLength ; i++){
			brick[arr[i][0]][arr[i][1]] = 1;
		}
		
		System.out.println("Show: " +s[n-1]);
		repaint();
	}
	
	public void move(){
		
		if(!chkmove(getnumCurrentBrick())){
			addtoBrick();
			newBrick();
			return;
		}
		
		if( arr[3][0]>=29 || arr[0][0]>=29 || arr[2][0] >= 29 || arr[0][0] >= 29){
			newBrick();
			return;
		}
		
		for(int i = numLength ; i < numLength - 4 ; i++){
			brick[arr[i][0]][arr[i][1]] = 0;
		}
		
		
		if(move == LEFT){
			for(int i = 0 ; i < 4 ; i++){
				arr[i][1]-=1;
				if (arr[i][1] < 0){
					arr[i][1] = 0;
					break;
				}
			}
			move=0;
		}
		if(move == RIGHT){
			for(int i = 0 ; i < 4 ; i++){
				arr[i][1]+=1;
				if (arr[i][1] >= nCol){
					System.out.println(arr[i][1]);
					arr[i][1] = nCol-1;
					break;
				}
			}
			move=0;
		}
		
		for(int i = 0 ; i < 4 ; i++){
			arr[i][0] +=1;
		}
		
		for(int i = numLength ; i < numLength - 4 ; i++){
			brick[arr[i][0]][arr[i][1]] = 1;
		}
		
		repaint();
		
	}
	
	public boolean chkmove(int numBrickCurrent){
		int n = numBrickCurrent +1;
		
		int x[] = new int [4];
		int y[] = new int [4];
		if( n==1){	//hinh vuông
			x[0] = add[2][0];
			y[0] = add[2][1];
			x[1] = add[3][0];
			y[1] = add[3][1];
		}
		else if(n==2){	//hinh L
			x[0] = add[2][0];
			y[0] = add[2][1];
			x[1] = add[3][0];
			y[1] = add[3][1];
		}
		else if(n==3){	//hinh I
			x[0] = add[0][0];
			y[0] = add[0][1];
			x[1] = add[1][0];
			y[1] = add[1][1];
			x[2] = add[2][0];
			y[2] = add[2][1];
			x[3] = add[3][0];
			y[3] = add[3][1];
		}
		else if(n==4){	//hinh Z
			x[0] = add[1][0];
			y[0] = add[1][1];
			x[1] = add[2][0];
			y[1] = add[2][1];
			x[2] = add[3][0];
			y[2] = add[3][1];
			
		}
		else if(n==5){	//hinh T
			x[0] = add[0][0];
			y[0] = add[0][1];
			x[1] = add[1][0];
			y[1] = add[1][1];
			x[2] = add[2][0];
			y[2] = add[2][1];
		}
		
		for(int i = 0 ; i < x.length; i++){
			if(x[i]+1>=nRow){
				return false;
			}
			if (brick[x[i]+1][y[i]]>0){
				System.out.println(brick[x[i]][y[i]] + " FALSE");
				return false;
			}
		}
		return true;
	}
	
	public void addtoBrick(){
		
	}
	
	public void setnumNextBrick(int n){
		this.numNextBrick = n;
	}
	
	public int getnumNextBrick(){
		return numNextBrick;
	}
	
	public void setnumCurrentBrick(int n){
		this.numCurrentBrick = n;
	}
	
	public int getnumCurrentBrick(){
		return numCurrentBrick;
	}
}
