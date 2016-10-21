package weekyexam.practices;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class cWe15_Pro02_Panel_CCP extends JPanel{

	public cWe15_Pro02_Panel_CCP(){
		
	}
	
	int nRow = 2 , nCol = 2;
	int w= 20, h=20;
	int x0 = 10, y0 = 10;
	int P_WIDTH =  x0 + nCol*w, P_HEIGHT = y0 + nRow*h;
	public static int p=0;
	
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.LIGHT_GRAY);
		for(int i  = 0 ; i <= nRow ; i++){
			g.drawLine(x0, y0+i*h, P_WIDTH, y0+i*h);
		}
		for(int i  = 0 ; i <= nCol ; i++){
			g.drawLine(x0+i*w, y0, x0+i*w, P_HEIGHT);
		}
		int c = 0;
		for(int i = 0 ; i < nRow; i++){
			for(int j = 0 ; j < nCol; j++){
				c = i*nRow + j +1;
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
		g.setColor(Color.LIGHT_GRAY);
		g.drawRect(x0, P_HEIGHT + h*2, w*2, h);
		if (p > 0){
			if(p==1){
				g.setColor(Color.BLUE);
			}
			else if(p==2){
				g.setColor(Color.RED);
			}
			else if(p==3){
				g.setColor(Color.YELLOW);
			}
			else if(p==4){
				g.setColor(Color.GREEN);
			}
			System.out.println("Color: " +p);
			g.fillRect(x0+1, P_HEIGHT + h*2 +1, w*2, h);
		}
		
	}
	
	public void drawDPanel(int x, int y){
		for(int i = 0 ; i < nRow ; i++){
			for(int j = 0 ; j < nCol ; j++){
				if (x >= x0+(j*w) && x < x0+(j+1)*w && y >= y0+(h*i) && y< y0+(i+1)*h){
					p=i*nRow + j + 1;
					repaint();
				}
			}
		}
	}
	
	public int getP(){
		return this.p;
	}
}
