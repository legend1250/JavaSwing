package beginner;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

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
					g.setColor(Color.BLUE);	//next brick background color
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
				nextBrick();
			}
		});
		
		
		
		
		//draw background
		for(int i = 0; i < nRow ;i++){
			for(int j = 0 ; j < nCol ; j++){
				brick[i][j] = 0;
			}
		}
		
	}
	
	public void nextBrick(){
		int n = rd.nextInt(2);
		n+=1;
		setPuzzle(n);
		//clear 
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
			nextbrick[0][1] = n;
			nextbrick[1][1] = n;
			nextbrick[2][1] = n;
			nextbrick[2][2] = n;
			arr[0][0] = 0;
			arr[0][1] = 8;
			arr[1][0] = 1;
			arr[1][1] = 8;
			arr[2][0] = 2;
			arr[2][1] = 8;
			arr[3][0] = 0;
			arr[3][1] = 9;
			
		}
		
		String s[] = {
				"square",
				"L",
				"I",
				"Z",
				"T",
		};
		System.out.println(s[n-1]);
		newBrick();
		repaint();
	}
	
	public void setPuzzle(int n){
		this.puzzle = n;
	}
	
	public int getPuzzle(){
		return puzzle;
	}
	
	public void newBrick(){
		int P = getPuzzle();
		
		if(P==1){
			brick[arr[0][0]][arr[0][1]] = P;
			brick[arr[1][0]][arr[1][1]] = P;
			brick[arr[2][0]][arr[2][1]] = P;
			brick[arr[3][0]][arr[3][1]] = P;
			
		}
		
		repaint();
		
	}
}
