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

	int nRow = 30, nCol = 20;
	int w= 15, h=15;
	int x0 =100, y0=20;
	int numLength=0,numColor=0;
	int[][] brick = new int[nRow][nCol];
	int[][] arr = new int [10000][3];
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
	JLabel lblCount = new JLabel("Count: 0"), lblLength = new JLabel("Length: 0");;
	//variable new brick
	Random rd = new Random();
	int numNextBrick = 0,numCurrentBrick = 0, count=0;
	boolean firstP = false;
	Timer t;
	//moving variable
	int move = 0, LEFT = 1, RIGHT = 2, UP = 3;
	
	
	public cXepGachPanel(){
		setLayout(null);
		//
		add(btnStart);
		add(btnShow);
		add(lblCount);
		add(lblLength);
		btnStart.setBounds(50,500,80,30);
		btnShow.setBounds(160,500,80,30);
		lblCount.setBounds(500,200,80,30);
		lblLength.setBounds(500,250,80,30);
		
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
					System.out.println(arr[i][0] + " " +arr[i][1] + " " + arr[i][2]);
				}
				
			}
		});
		//draw background
		for(int i = 0; i < nRow ;i++){
			for(int j = 0 ; j < nCol ; j++){
				brick[i][j] = 0;
			}
		}
		
		t = new Timer(300, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				/*if(brick[0][7] > 0 || brick[0][8] > 0 || brick[0][9] > 0 || brick[0][10] > 0 ){
					t.stop();
					System.out.println("Game Over");
				}*/
				
				move();
				lblCount.setText("Count: " +count);
				lblLength.setText("Length: " +numLength);
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
		btnShow.addKeyListener(moving);
	}
	
	
	public void newBrick(){
		int n = rd.nextInt(5);
		if(firstP){
			setnumCurrentBrick(getnumNextBrick());
			addBrick();
			setnumNextBrick(n);
			showNextBrick();
		}
		else{
			int x = rd.nextInt(5);
			setnumCurrentBrick(x);
			addBrick();
			setnumNextBrick(n);
			showNextBrick();
			firstP = true;
		}
		
	}
	
	public void showNextBrick(){
		int n = getnumNextBrick() +1;
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
		int n = getnumCurrentBrick()+1;
		String s[] = {
				"square",
				"L",
				"I",
				"Z",
				"T",
		};
		
		if( n==1){	//hinh vuông
			arr[numLength][0] = 0;
			arr[numLength][1] = 8;
			arr[numLength+1][0] = 0;
			arr[numLength+1][1] = 9;
			arr[numLength+2][0] = 1;
			arr[numLength+2][1] = 8;
			arr[numLength+3][0] = 1;
			arr[numLength+3][1] = 9;
		}
		else if(n==2){	//hinh L
			arr[numLength][0] = 0;
			arr[numLength][1] = 8;
			arr[numLength+1][0] = 1;
			arr[numLength+1][1] = 8;
			arr[numLength+2][0] = 2;
			arr[numLength+2][1] = 8;
			arr[numLength+3][0] = 2;
			arr[numLength+3][1] = 9;
		}
		else if(n==3){	//hinh I
			arr[numLength][0] = 0;
			arr[numLength][1] = 7;
			arr[numLength+1][0] = 0;
			arr[numLength+1][1] = 8;
			arr[numLength+2][0] = 0;
			arr[numLength+2][1] = 9;
			arr[numLength+3][0] = 0;
			arr[numLength+3][1] = 10;
		}
		else if(n==4){	//hinh Z
			arr[numLength][0] = 0;
			arr[numLength][1] = 8;
			arr[numLength+1][0] = 0;
			arr[numLength+1][1] = 9;
			arr[numLength+2][0] = 1;
			arr[numLength+2][1] = 7;
			arr[numLength+3][0] = 1;
			arr[numLength+3][1] = 8;
		}
		else if(n==5){	//hinh T
			arr[numLength][0] = 1;
			arr[numLength][1] = 8;
			arr[numLength+1][0] = 1;
			arr[numLength+1][1] = 9;
			arr[numLength+2][0] = 1;
			arr[numLength+2][1] = 10;
			arr[numLength+3][0] = 0;
			arr[numLength+3][1] = 9;
		}
		setnumColor(n);
		
		for(int i = numLength ; i < numLength + 4 ; i++){
			arr[i][2] = getnumColor();
			brick[arr[i][0]][arr[i][1]] = arr[i][2];
		}
		
		numLength+=4;
		count++;
		
		System.out.println("Show: " +s[n-1]);
		repaint();
	}
	
	public void move(){
		
		/*if(!chkmove(getnumCurrentBrick())){
			addtoBrick();
			newBrick();
			return;
		}*/
		
		/*if( add[3][0]>=29 || add[0][0]>=29 || add[2][0] >= 29 || add[0][0] >= 29){
			newBrick();
			return;
		}*/
		
		/*for(int i = 0 ; i < nRow ; i++){
			for(int j = 0 ; j < nCol ; j++ ){
				brick[i][j] = 0;
			}
		}*/
		
		for(int i = numLength -4; i < numLength; i++){
			brick[arr[i][0]][arr[i][1]] = 0;
		}
		//move LEFT or RIGHT
		if(move>0){
			if(chkmoveLeft() && move == LEFT){
				for(int i = numLength-4 ; i < numLength; i++){
					arr[i][1]-=1;
				}
				
			}
			if(chkmoveRight() && move == RIGHT){
				for(int i = numLength-4 ; i < numLength; i++){
					arr[i][1]+=1;
				}
				
			}
			move=0;
		}
		
		
		//move DOWN
		if(chkmove()){
			for(int i = numLength-4 ; i < numLength; i++){
				arr[i][0]+=1;
			}
		}else{
			for(int i = numLength-4 ; i < numLength; i++){
				arr[i][2] = getnumColor();
				brick[arr[i][0]][arr[i][1]] = arr[i][2];
			}
			chkLine();
			newBrick();
		}
		
		for(int i = numLength-4 ; i < numLength; i++){
			arr[i][2] = getnumColor();
			brick[arr[i][0]][arr[i][1]] = arr[i][2];
		}
		
		repaint();
		
	}
	
	public boolean chkmove(){
		
		for(int i = numLength-4 ; i < numLength; i++){
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
		
		for(int i = numLength-4 ; i < numLength; i++){
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
		
		for(int i = numLength-4 ; i < numLength; i++){
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
	
	public void chkLine(){
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
		repaint();
		//t.stop();
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
	
	public void setnumColor(int n){
		this.numColor = n;
	}
	
	public int getnumColor(){
		return numColor;
	}
}
