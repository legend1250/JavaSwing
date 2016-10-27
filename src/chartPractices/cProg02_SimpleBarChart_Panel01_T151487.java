package chartPractices;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class cProg02_SimpleBarChart_Panel01_T151487 extends JPanel{

	int arrD[] = new int[12];
	boolean doDraw = false;
	int y0; //height of panel
	int lines = 6; //unit of drawLine
	final int w = 30; //width of rect
	int size = 120;
	
	
	public void paint(Graphics g){
		super.paint(g);
		if(doDraw){
			int p = y0/size;
			
			for(int i = 0 ; i <= lines ; i++){
				int y1 = y0 - i*(y0/lines)+20;
				String s = (size/lines)*i +"";
				
				g.setColor(Color.LIGHT_GRAY);
				g.drawLine(20, y1, 800, y1);
				
				g.setColor(Color.BLACK);
				g.drawString( s, 0, y1);
			}
			
			for(int i = 0 ; i < arrD.length ;i++){
				//int y1 = (size - arrD[i])*p;
				int y1 = y0 +20;
				g.setColor(Color.RED);
				//g.drawRect(30 + 60*i, y1, w, arrD[i]*p);
				//g.fillRect(30 + 60*i, y1, w, arrD[i]*p);
				g.fillRect(30 + 60*i, y1, w, -arrD[i]*p);
				//draw String value
				if(arrD[i] != 0){
					g.setColor(Color.BLUE);
					//g.drawString("" + arrD[i], 30 + 60*i + 11, y1-5);
					g.drawString("" + arrD[i], 30 + 60*i + 11, y1- arrD[i]*p - 5);
				}
				g.setColor(Color.BLACK);
				g.drawString("" + (i+1), 30 + 60*i + 11, y1+20);
			}
		}
		
	}
	
	/**
	 * @param: array 1-D for drawing
	 */
	public void setArrD(int []arr){
		arrD = arr;
	}
	
	public void setY0(int y0){
		this.y0 = y0;
	}
	
}
