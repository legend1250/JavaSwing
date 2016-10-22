package weekyexam.practices;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class cWe15_Pro02_T151487_CDP extends JPanel{

	cWe15_Pro02_Panel_CCP panel01 = new cWe15_Pro02_Panel_CCP();
	
	int nRow = 20 , nCol = 20;
	int w= 20, h=20;
	int x0 = panel01.P_WIDTH + 10, y0 = 10;
	int P_WIDTH =  x0 + nCol*w, P_HEIGHT = y0 + nRow*h;
	//draw piece
	int arr[][] = new int[nRow][nCol];
	int p = 0;
	
	public void paint(Graphics g){
		super.paint(g);
		/*g.setColor(Color.black);
		for(int i = 0 ; i <= nRow ; i++){
			g.drawLine(x0 , y0 + i*h , P_WIDTH , y0+i*w);
		}
		for(int i = 0 ; i <= nCol ; i++){
			g.drawLine(x0+i*w, y0, x0+i*w, P_HEIGHT);
		}*/
		
		for(int i = 0 ; i < nRow ; i++){
			for(int j = 0 ; j < nCol ; j++){
				if(arr[i][j] == 0){
					g.setColor(Color.WHITE);
				}
				else if(arr[i][j]==1){
					g.setColor(Color.BLUE);
				}
				else if(arr[i][j]==2){
					g.setColor(Color.RED);
				}
				else if(arr[i][j]==3){
					g.setColor(Color.YELLOW);
				}
				else if(arr[i][j]==4){
					g.setColor(Color.GREEN);
				}
				g.fillRect(x0+j*nCol, y0+i*nRow, w-1, h-1);
			}
		}
	}
	
	public void drawDPanel(int x, int y){
		
		for(int i = 0 ; i < nRow ; i++){
			for(int j = 0 ; j < nCol ; j++){
				arr[i][j] = 0;
			}
		}
		
		for(int i = 0 ; i < nRow ; i++){
			for(int j = 0 ; j < nCol ; j++){
				if (x >= x0+(j*w) && x < x0+(j+1)*w && y >= y0+(h*i) && y< y0+(i+1)*h){
					this.arr[i][j] = p;
					if(arr[i][j]>0){
						repaint();
					}
					System.out.println("piece: " + (i*nRow + j + 1));
				}
			}
		}
	}
	
	public void setP( int pIn){
		p= pIn;
	}
}
