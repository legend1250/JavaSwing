package beginner;

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

public class cXepGachPanel extends JPanel{

	int nRow = 30, nCol = 12;
	int w= 15, h=15;
	int x0 =100, y0=20;
	int numColor=0,nBCount=0;
	int[][] brick = new int[nRow][nCol];
	int[][] arr = new int [4][3];
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
					g.setColor(Color.RED);	//brick color => square
				}
				if( brick[i][j]==2){
					g.setColor(Color.GREEN);	//brick color => L
				}
				if( brick[i][j]==3){
					g.setColor(Color.BLUE);	//brick color => I
				}
				if( brick[i][j]==4){
					g.setColor(Color.CYAN);	//brick color => Z
				}
				if( brick[i][j]==5){
					g.setColor(Color.LIGHT_GRAY);	//brick color => T
				}
				/*if( brick[i][j]==6){
					g.setColor(Color.MAGENTA);	//next brick background color
				}*/
				g.fillRect(x0+j*w+1, y0+i*h+1,	w-2, h-2);
			}
		}
		
		for(int i = 0 ; i < 3 ; i++){
			for(int j = 0 ; j < 4 ; j++){
				if( nextbrick[i][j]==0){
					g.setColor(Color.WHITE);	//background color
				}
				if( nextbrick[i][j]==1){
					g.setColor(Color.RED);	//next brick color => square
				}
				if( nextbrick[i][j]==2){
					g.setColor(Color.GREEN);	//next brick color => L
				}
				if( nextbrick[i][j]==3){
					g.setColor(Color.BLUE);	//next brick color => I
				}
				if( nextbrick[i][j]==4){
					g.setColor(Color.CYAN);	//next brick color => Z
				}
				if( nextbrick[i][j]==5){
					g.setColor(Color.LIGHT_GRAY);	//next brick color => T
				}
				g.fillRect(x00+j*w+1, y0+i*h+1,	w-2, h-2);
			}
		}
		
	}
	
	JButton btnStart = new JButton("Start"), btnShow = new JButton("Show");
	JLabel lblCount = new JLabel("Count: 0"), lblLength = new JLabel("nBCount: 0"), lblPoint = new JLabel("Point: 0");
	//variable new brick
	Random rd = new Random();
	int numNextBrick = 0,numCurrentBrick = 0, count=0;
	boolean firstP = true;
	Timer t;
	//moving variable
	int move = 0, LEFT = 1, RIGHT = 2, UP = 3,DOWN = 4;
	int Point = 0;
	//rotate variable
	int stage = 0,rotating=0;
	
	public cXepGachPanel(){
		setLayout(null);
		//
		add(btnStart);
		add(btnShow);
		add(lblCount);
		add(lblLength);
		add(lblPoint);
		btnStart.setBounds(50,500,80,30);
		btnShow.setBounds(160,500,80,30);
		lblCount.setBounds(500,200,80,30);
		lblLength.setBounds(500,250,80,30);
		lblPoint.setBounds(500,300,80,30);
		
		//draw background
		for(int i = 0; i < nRow ;i++){
			for(int j = 0 ; j < nCol ; j++){
				brick[i][j] = 0;
			}
		}
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
				for(int i = 0; i < nRow ;i++){
					for(int j = 0 ; j < nCol ; j++){
						if(brick[i][j] >0){
							nBCount++;
							System.out.println(i+ " " + j + " " + brick[i][j]);
						}
					}
				}
				lblLength.setText("nBCount: " +nBCount);
				
			}
		});
		
		t = new Timer(500, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				/*if(brick[0][7] > 0 || brick[0][8] > 0 || brick[0][9] > 0 || brick[0][10] > 0 ){
					t.stop();
					System.out.println("Game Over");
				}*/
				
				move();
				lblCount.setText("Count: " +count);
				lblPoint.setText("Point: " +Point);
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
				if(e.getKeyCode() == KeyEvent.VK_UP){
					rotate();
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_LEFT){
					move = LEFT;
					move();
				}
				else if (e.getKeyCode()==KeyEvent.VK_RIGHT){
					move = RIGHT;
					move();
				}
				else if(e.getKeyCode()==KeyEvent.VK_DOWN){
					move=DOWN;
					move();
				}
			}
		};
		btnStart.addKeyListener(moving);
		btnShow.addKeyListener(moving);
	}
	
	
	public void newBrick(){
		stage=1;
		int n = rd.nextInt(5)+1;
		if(!firstP){
			setnumCurrentBrick(getnumNextBrick());
			addBrick();
			setnumNextBrick(n);
			showNextBrick();
		}
		else{
			int x = rd.nextInt(5)+1;
			setnumCurrentBrick(x);
			addBrick();
			setnumNextBrick(n);
			showNextBrick();
			firstP = false;
		}
		
	}
	
	public void showNextBrick(){
		int n = getnumNextBrick();
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
		
		if( n==1){	//hinh vu�ng
			nextbrick[1][1] = n;
			nextbrick[1][2] = n;
			nextbrick[2][1] = n;
			nextbrick[2][2] = n;
		}
		else if(n==2){	//hinh L
			nextbrick[0][1] = n;
			nextbrick[1][1] = n;
			nextbrick[2][1] = n;
			nextbrick[2][2] = n;
		}
		else if(n==3){	//hinh I
			nextbrick[1][0] = n;
			nextbrick[1][1] = n;
			nextbrick[1][2] = n;
			nextbrick[1][3] = n;
		}
		else if(n==4){	//hinh Z
			nextbrick[1][1] = n;
			nextbrick[1][2] = n;
			nextbrick[2][0] = n;
			nextbrick[2][1] = n;
		}
		else if(n==5){	//hinh T
			nextbrick[2][1] = n;
			nextbrick[2][2] = n;
			nextbrick[2][3] = n;
			nextbrick[1][2] = n;
		}
		
		System.out.println("Next: "+s[n-1]);
		
		repaint();
	}
	
	public void addBrick(){
		int n = getnumCurrentBrick();
		String s[] = {
				"square",
				"L",
				"I",
				"Z",
				"T",
		};
		
		if( n==1){	//hinh vu�ng
			arr[0][0] = 0;
			arr[0][1] = 8;
			arr[1][0] = 0;
			arr[1][1] = 9;
			arr[2][0] = 1;
			arr[2][1] = 8;
			arr[3][0] = 1;
			arr[3][1] = 9;
		}
		else if(n==2){	//hinh L
			arr[0][0] = 0;
			arr[0][1] = 8;
			arr[1][0] = 1;
			arr[1][1] = 8;
			arr[2][0] = 2;
			arr[2][1] = 8;
			arr[3][0] = 2;
			arr[3][1] = 9;
		}
		else if(n==3){	//hinh I
			arr[0][0] = 0;
			arr[0][1] = 7;
			arr[1][0] = 0;
			arr[1][1] = 8;
			arr[2][0] = 0;
			arr[2][1] = 9;
			arr[3][0] = 0;
			arr[3][1] = 10;
		}
		else if(n==4){	//hinh Z
			arr[0][0] = 0;
			arr[0][1] = 8;
			arr[1][0] = 0;
			arr[1][1] = 9;
			arr[2][0] = 1;
			arr[2][1] = 7;
			arr[3][0] = 1;
			arr[3][1] = 8;
		}
		else if(n==5){	//hinh T
			arr[0][0] = 1;
			arr[0][1] = 8;
			arr[1][0] = 1;
			arr[1][1] = 9;
			arr[2][0] = 1;
			arr[2][1] = 10;
			arr[3][0] = 0;
			arr[3][1] = 9;
		}
		setnumColor(n);
		
		for(int i = 0 ; i < 4 ; i++){
			arr[i][2] = getnumColor();
			brick[arr[i][0]][arr[i][1]] = arr[i][2];
		}
		
		count++;
		
		System.out.println("Show: " +s[n-1]);
		repaint();
	}
	
	public void move(){
		
		for(int i = 0; i < 4; i++){
			brick[arr[i][0]][arr[i][1]] = 0;
		}
		//move LEFT or RIGHT
		
		if(move>0){
			if(chkmoveLeft() && move == LEFT){
				for(int i = 0 ; i < 4; i++){
					arr[i][1]-=1;
				}
				
			}
			if(chkmoveRight() && move == RIGHT){
				for(int i = 0 ; i < 4; i++){
					arr[i][1]+=1;
				}
				
			}
			if(chkmoveDown() && move == DOWN){
				for(int i = 0 ; i < 4; i++){
					arr[i][0]+=1;
				}
			}
			move=0;
			
		}
		else{
			
			//move DOWN
			if(chkmove()){
				for(int i = 0 ; i < 4; i++){
					arr[i][0]+=1;
				}
				
			}else{
				for(int i = 0 ; i < 4; i++){
					arr[i][2] = getnumColor();
					brick[arr[i][0]][arr[i][1]] = arr[i][2];
				}
				//chkLine();
				Point+=tinhdiem();
				newBrick();
			}
			
		}
		
		for(int i = 0 ; i < 4; i++){
			arr[i][2] = getnumColor();
			brick[arr[i][0]][arr[i][1]] = arr[i][2];
		}
			
			
		repaint();
		
	}
	
	public void rotate(){
		if(stage>0){
			for(int i = 0; i < 4; i++){
				brick[arr[i][0]][arr[i][1]] = 0;
			}
			int n = getnumCurrentBrick();
			if(n==2 ){
				if(stage>4){
					stage=1;
				}
				/*
				 * //hinh L
				arr[0][0] = 0;
				arr[0][1] = 8;
				arr[1][0] = 1;
				arr[1][1] = 8;
				arr[2][0] = 2;
				arr[2][1] = 8;
				arr[3][0] = 2;
				arr[3][1] = 9;
				 */
				if(stage == 1 && chkrotate(n,stage)){
					arr[0][0] = arr[0][0] +1;
					arr[0][1] = arr[0][1] +2;
					arr[1][0] = arr[1][0];
					arr[1][1] = arr[1][1] +1;
					arr[2][0] = arr[2][0]-1;
					arr[2][1] = arr[2][1];
					arr[3][0] = arr[3][0];
					arr[3][1] = arr[3][1]-1;
					stage++;
				}
				else if( stage == 2 && chkrotate(n,stage)){
					arr[0][0] = arr[0][0]+1;
					arr[0][1] = arr[0][1]-1;
					arr[1][0] = arr[1][0];
					arr[1][1] = arr[1][1];
					arr[2][0] = arr[2][0]-1;
					arr[2][1] = arr[2][1]+1;
					arr[3][0] = arr[3][0]-2;
					arr[3][1] = arr[3][1];
					stage++;
				}
				else if(stage == 3 && chkrotate(n,stage)){
					arr[0][0] = arr[0][0];
					arr[0][1] = arr[0][1]-1;
					arr[1][0] = arr[1][0]+1;
					arr[1][1] = arr[1][1];
					arr[2][0] = arr[2][0]+2;
					arr[2][1] = arr[2][1]+1;
					arr[3][0] = arr[3][0]+1;
					arr[3][1] = arr[3][1]+2;
					stage++;
				}
				else if(stage == 4 && chkrotate(n,stage)){
					arr[0][0] = arr[0][0] -2;
					arr[0][1] = arr[0][1];
					arr[1][0] = arr[1][0]-1;
					arr[1][1] = arr[1][1] -1;
					arr[2][0] = arr[2][0];
					arr[2][1] = arr[2][1]-2;
					arr[3][0] = arr[3][0]+1;
					arr[3][1] = arr[3][1]-1;
					stage++;
				}
				
			}
			else if(n==3){
				if(stage>2){
					stage=1;
				}
				if(stage == 1 && chkrotate(n,stage)){
					arr[0][0] = arr[0][0] -1;
					arr[0][1] = arr[0][1] +1;
					arr[1][0] = arr[1][0];
					arr[1][1] = arr[1][1];
					arr[2][0] = arr[2][0]+1;
					arr[2][1] = arr[2][1]-1;
					arr[3][0] = arr[3][0]+2;
					arr[3][1] = arr[3][1]-2;
					stage++;
				}
				else if(stage==2 && chkrotate(n,stage)){
					arr[0][0] = arr[0][0] +1;
					arr[0][1] = arr[0][1] -1;
					arr[1][0] = arr[1][0];
					arr[1][1] = arr[1][1];
					arr[2][0] = arr[2][0]-1;
					arr[2][1] = arr[2][1]+1;
					arr[3][0] = arr[3][0]-2;
					arr[3][1] = arr[3][1]+2;
					stage++;
				}
			}
			else if(n==4){
				if(stage>2){
					stage=1;
				}
				//hinh Z
				/*
				arr[0][0] = 0;
				arr[0][1] = 8;
				arr[1][0] = 0;
				arr[1][1] = 9;
				arr[2][0] = 1;
				arr[2][1] = 7;
				arr[3][0] = 1;
				arr[3][1] = 8;*/
				if(stage==1 && chkrotate(n,stage)){
					arr[0][0] = arr[0][0];
					arr[0][1] = arr[0][1];
					arr[1][0] = arr[1][0]+1;
					arr[1][1] = arr[1][1]-1;
					arr[2][0] = arr[2][0]-2;
					arr[2][1] = arr[2][1];
					arr[3][0] = arr[3][0]-1;
					arr[3][1] = arr[3][1]-1;
					stage++;
				}
				else if (stage == 2 && chkrotate(n,stage)){
					arr[0][0] = arr[0][0];
					arr[0][1] = arr[0][1];
					arr[1][0] = arr[1][0]-1;
					arr[1][1] = arr[1][1]+1;
					arr[2][0] = arr[2][0]+2;
					arr[2][1] = arr[2][1];
					arr[3][0] = arr[3][0]+1;
					arr[3][1] = arr[3][1]+1;
					stage++;
				}
			}
			else if(n==5){
				if(stage>4){
					stage=1;
				}
				if(stage == 1 && chkrotate(n,stage)){
					arr[0][0] = arr[0][0]-2;
					arr[0][1] = arr[0][1];
					arr[1][0] = arr[1][0]-1;
					arr[1][1] = arr[1][1]-1;
					arr[2][0] = arr[2][0];
					arr[2][1] = arr[2][1]-2;
					arr[3][0] = arr[3][0];
					arr[3][1] = arr[3][1];
					stage++;
				}
				else if(stage == 2 && chkrotate(n,stage)){
					arr[0][0] = arr[0][0];
					arr[0][1] = arr[0][1]+2;
					arr[1][0] = arr[1][0]-1;
					arr[1][1] = arr[1][1]+1;
					arr[2][0] = arr[2][0]-2;
					arr[2][1] = arr[2][1];
					arr[3][0] = arr[3][0];
					arr[3][1] = arr[3][1];
					stage++;
				}
				else if(stage == 3 && chkrotate(n,stage)){
					arr[0][0] = arr[0][0]+2;
					arr[0][1] = arr[0][1];
					arr[1][0] = arr[1][0]+1;
					arr[1][1] = arr[1][1]+1;
					arr[2][0] = arr[2][0];
					arr[2][1] = arr[2][1]+2;
					arr[3][0] = arr[3][0];
					arr[3][1] = arr[3][1];
					stage++;
				}
				else if(stage == 4 && chkrotate(n,stage)){
					arr[0][0] = arr[0][0];
					arr[0][1] = arr[0][1]-2;
					arr[1][0] = arr[1][0]+1;
					arr[1][1] = arr[1][1]-1;
					arr[2][0] = arr[2][0]+2;
					arr[2][1] = arr[2][1];
					arr[3][0] = arr[3][0];
					arr[3][1] = arr[3][1];
					stage++;
				}
			}
			for(int i = 0 ; i < 4 ; i++){
				brick[arr[i][0]][arr[i][1]] = arr[i][2];
			}
			repaint();
		}
	}
	
	public boolean chkrotate(int n, int stage){
		
		if(n==2){
			/*
			 * //hinh L
			arr[0][0] = 0;
			arr[0][1] = 8;
			arr[1][0] = 1;
			arr[1][1] = 8;
			arr[2][0] = 2;
			arr[2][1] = 8;
			arr[3][0] = 2;
			arr[3][1] = 9;
			 */
			int x0 = arr[0][0];
			int y0 = arr[0][1];
			int x1 = arr[1][0];
			int y1 = arr[1][1];
			int x2 = arr[2][0];
			int y2 = arr[2][1];
			if (stage==1){
				if(y0+2 >= nCol || y1 +2 >= nCol || brick[x0][y0+1]>0 || brick[x0][y0+2] >0 || brick[x1][y1+1]>0 || brick[x1][y1+2] >0){
					return false;
				}
			}
			else if(stage == 2){
				if(x0 +1 >= nRow || x1 +1 >= nRow || brick[x0+1][y0]>0 || brick[x1+1][y1]>0){
					return false;
				}
			}
			else if(stage == 3){
				if(y0 - 1 < 0 || y0+1 >=nCol || y1+1 >= nCol || y2 +1 >= nCol ||
					brick[x0][y0-1]>0 || brick[x0][y0+1]>0 || brick[x1][y1+1]>0 || brick[x2][y2+1]>0){
					return false;
				}
			}
			else if(stage == 4){
				if(brick[x0-1][y0]>0||brick[x0-2][y0]>0||brick[x1-1][y1]>0||brick[x1-2][y1]>0){
					return false;
				}
			}
		}
		else if(n==3){
			//hinh I
			/*
			arr[0][0] = 0;
			arr[0][1] = 7;
			arr[1][0] = 0;
			arr[1][1] = 8;
			arr[2][0] = 0;
			arr[2][1] = 9;
			arr[3][0] = 0;
			arr[3][1] = 10;*/
			int x0 = arr[1][0];
			int y0 = arr[1][1];
			if(stage == 1){
				if(	brick[x0+1][y0] > 0 || brick[x0+2][y0] > 0 || 
					brick[x0+1][y0+1] > 0 || brick[x0+1][y0+2] > 0 ||
					brick[x0+2][y0+1] > 0 || brick[x0+2][y0+2] > 0 ||
					brick[x0-1][y0-1] > 0){
					return false;
				}
			}
			else if(stage==2){
				if( y0-1 < 0 || brick[x0-1][y0-1] > 0 || brick[x0][y0-1] > 0 ||
					brick[x0+1][y0] > 0 || brick[x0+2][y0] > 0 || 
					brick[x0+1][y0+1] > 0 || brick[x0+1][y0+2] > 0 ||
					brick[x0+2][y0+1] > 0 || brick[x0+2][y0+2] > 0 ){
					return false;
				}
			}
		}
		else if(n==4){
			//hinh Z
			/*
			arr[0][0] = 0;
			arr[0][1] = 8;
			arr[1][0] = 0;
			arr[1][1] = 9;
			arr[2][0] = 1;
			arr[2][1] = 7;
			arr[3][0] = 1;
			arr[3][1] = 8;*/
			int x0 = arr[2][0];
			int y0 = arr[2][1]; 
			int x1 = arr[1][0];
			int y1 = arr[1][1];
			
			if (stage==1){
				if(x0 -1 < 0 || x0-2 < 0 || brick[x0-1][y0] > 0 || brick[x0-2][y0] >0 || brick[x1+1][y1]>0){
					return false;
				}
			}
			else if (stage == 2){
				if(y0-1< 0 || y1 -1 < 0 || y1 + 1 >= nCol || x0+2>=nRow ||
					brick[x0][y0-1] > 0 || brick[x0+1][y0-1] > 0 || brick[x0+2][y0-1] > 0 ||
					brick[x1][y1-1] > 0 || brick[x1][y1+1] > 0 || brick[x1-1][y1+1] > 0 ){
					return false;
				}
			}
		}
		else if(n==5){
			//hinh T
			/*
			arr[0][0] = 1;
			arr[0][1] = 8;
			arr[1][0] = 1;
			arr[1][1] = 9;
			arr[2][0] = 1;
			arr[2][1] = 10;
			arr[3][0] = 0;
			arr[3][1] = 9;*/
			int x0 = arr[0][0];
			int y0 = arr[0][1];
			if(stage == 1){
				if(brick[x0-2][y0] > 0 || brick[x0-1][y0] > 0){
					return false;
				}
			}
			else if(stage == 2){
				if(y0 + 2 >= nCol || brick[x0][y0+1] > 0 || brick[x0][y0+2] > 0){
					return false;
				}
			}
			else if(stage == 3){
				if(brick[x0+2][y0] > 0 || brick[x0+1][y0] >0){
					return false;
				}
			}
			else if(stage == 4){
				if(y0-2 < 0 || brick[x0][y0-1] > 0 || brick[x0][y0-2]>0){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean chkmove(){
		
		for(int i = 0 ; i < 4; i++){
			//check max line
			if(arr[i][0]>= nRow-1){
				return false;
			}
			
			//check next line
			int x = arr[i][0]+1;
			int y = arr[i][1];
			if(brick[x][y] > 0){
				return false;
			}
			
		}
		return true;
	}
	
	public boolean chkmoveLeft(){
		
		for(int i = 0 ; i < 4; i++){
			int x = arr[i][0];
			int y = arr[i][1]-1;
			if(y < 0){
				return false;
			}
			if(brick[x][y] > 0){
				return false;
			}
		}
		
		return true;
	}
	
	public boolean chkmoveRight(){
		
		for(int i = 0 ; i < 4; i++){
			int x = arr[i][0];
			int y = arr[i][1]+1;
			if(y >= nCol){
				return false;
			}
			if(brick[x][y] > 0){
				return false;
			}
		}
		
		return true;
	}
	
	public boolean chkmoveDown(){
		
		for(int i = 0 ; i < 4; i++){
			int x = arr[i][0]+1;
			int y = arr[i][1];
			if(x >= nRow-1){
				return false;
			}
			if(brick[x][y] > 0){
				return false;
			}
		}
		
		return true;
	}
	
	public int tinhdiem(){
		int s=0;
		int countTmp;
		for(int r=0; r<nRow; r++){
			countTmp=0;
			for(int c=0; c<nCol; c++){
				if( brick[r][c]>0){
					countTmp++;
				}
			}	
			if( countTmp== nCol){
				s++;
				//remove row;
				for(int rT=r; rT>0; rT--){
					for(int c=0; c<nCol; c++){
						brick[rT][c]= brick[rT-1][c];
					}						
				}
				for(int c=0; c<nCol; c++){
					brick[0][c]= 0;
				}						
			}
		}
		return s;
	}
	
	/*public void chkLine(){
		int c = 0;
		for(int i = 0 ; i < nRow ; i++){
			c=0;
			for(int j = 0 ; j < nCol ; j++){
				if(brick[i][j] > 0){
					c++;
				}
			}
			if (c==nCol){
				//t.stop();
				System.out.println("BINGO! Line: " +i);
				push(i);
				return;
			}
		}
	}
	
	public void push(int n){
		int Line = n;
		for(int i = 0 ; i < numLength ; i++){
			if(arr[i][0] < Line){
				arr[i][0] +=1;
			}
			else{
				arr[i][2] = 0;
			}
		}
		for(int i = 0 ; i < nRow ; i++){
			for(int j = 0 ; j < nCol ; j++){
				brick[i][j] = 0;
			}
		}
		for(int i = 0 ; i < numLength ; i++){
			if(arr[i][2]!=0){
				brick[arr[i][0]][arr[i][1]] = arr[i][2];
			}
		}
		Point+=12;
		repaint();
		//t.stop();
	}	*/
	
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
	
	public void setnumColor(int n){
		this.numColor = n;
	}
	
	public int getnumColor(){
		return numColor;
	}
}
