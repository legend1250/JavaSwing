package weekyexam.practices;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class cWe15_Pro01_T151487_CDP extends JPanel{

	cWe15_Pro02_Panel_CCP panel01 = new cWe15_Pro02_Panel_CCP();
	
	int nRow = 20 , nCol = 20;
	int w= 20, h=20;
	int x0 = panel01.P_WIDTH + 10, y0 = 10;
	int P_WIDTH =  x0 + (nCol-1)*w, P_HEIGHT = y0 + (nRow-1)*h;
	
	int xR = 0, yR = 0;
	
	public void paint(Graphics g){
		g.setColor(Color.LIGHT_GRAY);
		for(int i = 0 ; i <= nRow ; i++){
			g.drawLine(x0 , y0 + i*h , P_WIDTH , y0+i*w);
		}
		for(int i = 0 ; i <= nCol ; i++){
			g.drawLine(x0+i*w, y0, x0+i*w, P_HEIGHT);
		}
	}
	
	public void drawRect(){
		int x = getxR();
		int y = getyR();
		
		if( !(x < x0 || x > P_WIDTH || y < y0 || y > P_HEIGHT)){
			System.out.println(x-(x%10) + " " +(y-(y%10)));
			
		}
	}
	
	public int getxR(){
		return xR;
	}
	public int getyR(){
		return yR;
	}
}
