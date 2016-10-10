package beginner;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class cXepGachPanel extends JPanel{

	int nRow = 30, nCol = 20;
	int w= 15, h=15;
	int x0 =100, y0=20;
	int[][] brick = new int[nRow][nCol];
	int[][] arr = new int [4][2];
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
	
	JButton btnStart = new JButton("Start");
	//variable new brick
	Random rd = new Random();
	int puzzle = 0,count=0;
	boolean firstP = false;
	Timer t;
	
	public cXepGachPanel(){
		setLayout(null);
		//
		add(btnStart);
		btnStart.setBounds(50,500,80,30);
		
		//
		btnStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				newPiece();
				t.start();
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
				move();
				
			}
		});
	}
	
	
	public void newPiece(){
		int n = 0;
		n=rd.nextInt(5);
		if(!firstP){
			addPiece(rd.nextInt(5));
			showNextPiece(n);
			setnumPiece(n);
			firstP = true;
		}
		else{
			addPiece(getnumPiece());
			showNextPiece(n);
			setnumPiece(n);
		}
		
	}
	
	public void showNextPiece(int n){
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
	
	public void addPiece(int n){
		n+=1;
		String s[] = {
				"square",
				"L",
				"I",
				"Z",
				"T",
		};
		for(int i = 0 ; i < 4 ; i++){
			arr[i][0] = 0;
			arr[i][1] = 0;
		}
		if( n==1){	//hinh vuông
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
		
		
		for(int i = 0 ; i < 4 ; i++){
			brick[arr[i][0]][arr[i][1]] = 1;
		}
		System.out.println("Show: " +s[n-1]);
		repaint();
	}
	
	public void move(){
		
		
		//
		for(int i = 0 ; i < 4 ; i++){
			brick[arr[i][0]][arr[i][1]] = 0;
		}
		
		for(int i = 0 ; i < 4 ; i++){
			arr[i][0] +=1;
			if(arr[i][0] >= nRow){
				//arr[i][0] +=30;
				newPiece();
			}
		}
		
		for(int i = 0 ; i < 4 ; i++){
			brick[arr[i][0]][arr[i][1]] = 1;
		}
		
		repaint();
		
	}
	
	public void setnumPiece(int n){
		this.puzzle = n;
	}
	
	public int getnumPiece(){
		return puzzle;
	}
}
