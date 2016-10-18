package weekyexam.practices;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class cWe15_Pro02_Panel_CCP extends JPanel{

	public cWe15_Pro02_Panel_CCP(){
		
	}
	
	int nRow = 3 , nCol = 3;
	int w= 20, h=20;
	int x0 = 10, y0 = 10;
	int P_WIDTH =  x0 + (nCol-1)*w, P_HEIGHT = y0 + (nRow-1)*h;
	
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.LIGHT_GRAY);
		for(int i  = 0 ; i < nRow ; i++){
			g.drawLine(x0, y0+i*h, P_WIDTH, y0+i*h);
		}
		for(int i  = 0 ; i < nCol ; i++){
			g.drawLine(x0+i*w, y0, x0+i*w, P_HEIGHT);
		}
		int c = 0;
		for(int i = 0 ; i < nRow ; i++){
			if(c>0){
				c--;
			}
			for(int j = 0 ; j < nCol ; j++){
				c++;
				if(c==1){
					g.setColor(Color.BLUE);
				}
				else if(c==2){
					g.setColor(Color.RED);
				}
				else if(c==3){
					g.setColor(Color.YELLOW);
				}
				else if(c==4){
					g.setColor(Color.GREEN);
				}
				g.fillRect(x0+j*w+1, y0+i*h+1, w-1, h-1);
				
			}
		}
	}
}
