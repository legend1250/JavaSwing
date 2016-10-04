package Beginner;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class cDraw2 extends JPanel{
	int nRow = 10, nCol = 10;
	int w= 20, h=20;
	int x0 =0, y0=0;
	public void paint(Graphics g){
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
				g.fillRect(x0+j*w+1, y0+i*h+1,	w-2, h-2);
			}
		}
		
	}
	int[][] arr = new int[nRow][nCol];
	int[][] snk= {
			{3, 1},
			{3, 2},
			{3, 3},			
	};
	public cDraw2(){
		//int x = ;
		for(int i = 0; i < nRow ;i++){
			for(int j = 0 ; j < nCol ; j++){
				arr[i][j] = 0;// ((int)(Math.random()*10)%3);
				//System.out.print(arr[i][j]+ " ");
			}
			//System.out.println();
		}
		
		arr[snk[0][0]][snk[0][1]] = 1;
		arr[snk[1][0]][snk[1][1]] = 1;
		arr[snk[2][0]][snk[2][1]] = 1;
		
		Timer tmTemp = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				moveRight();
			}
		});
		tmTemp.start();
	}
	
	public void moveLeft(){
		arr[snk[0][0]][snk[0][1]] = 0;
		arr[snk[1][0]][snk[1][1]] = 0;
		arr[snk[2][0]][snk[2][1]] = 0;

		//int hx =snk[0][0], hy= snk[0][0];
		/*
		 int[][] snk= {
			{3, 1},
			{3, 2},
			{3, 3},			
			};
		 */
		
		snk[2][0] = snk[1][0];
		snk[2][1] = snk[1][1];
		snk[1][0] = snk[0][0];
		snk[1][1] = snk[0][1];
		snk[0][0] = snk[0][0];
		snk[0][1] = snk[0][1]-1;
		
		if( snk[0][1]<0){
			snk[0][1]= nCol -1;
		}
		
		arr[snk[0][0]][snk[0][1]] = 1;
		arr[snk[1][0]][snk[1][1]] = 1;
		arr[snk[2][0]][snk[2][1]] = 1;
		
		repaint();
		
	}
	
	public void moveRight(){
		
		arr[snk[0][0]][snk[0][1]] = 0;
		arr[snk[1][0]][snk[1][1]] = 0;
		arr[snk[2][0]][snk[2][1]] = 0;
		
		/*
		 int[][] snk= {
			{3, 1},
			{3, 2},
			{3, 3},			
			};
		 */
		snk[0][0] = snk[1][0];
		snk[0][1] = snk[1][1];
		snk[1][0] = snk[2][0];
		snk[1][1] = snk[2][1];
		snk[2][0] = snk[2][0];
		snk[2][1] = snk[2][1]+1;
		if( snk[2][1]>=nCol){
			snk[2][1]= 0;
		}
		
		arr[snk[0][0]][snk[0][1]] = 1;
		arr[snk[1][0]][snk[1][1]] = 1;
		arr[snk[2][0]][snk[2][1]] = 1;
		
		repaint();
	}
	
	public void moveUp(){
		
		arr[snk[0][0]][snk[0][1]] = 0;
		arr[snk[1][0]][snk[1][1]] = 0;
		arr[snk[2][0]][snk[2][1]] = 0;
		
		/*
		 int[][] snk= {
			{3, 1},
			{3, 2},
			{3, 3},			
			};
		 */
		snk[0][0] = snk[1][0];
		snk[0][1] = snk[1][1];
		snk[1][0] = snk[2][0];
		snk[1][1] = snk[2][1];
		snk[2][0] = snk[2][0];
		snk[2][1] = snk[2][1]+1;
		if( snk[2][1]>=nCol){
			snk[2][1]= 0;
		}
	}
	
	
}
