/**
 * 
 */
package chartPractices;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * @author Vinh - legend1250
 *
 */
public class cProg04_SimplePieChart_Panel01_T151487 extends JPanel{

	/**
	 * @param args
	 */
	

	int x1 = 0;
	int x2 = 0;
	int x3 = 0;
	int x0 = 150;
	int y0 = 50;
	int r = 250;
	boolean doDraw = false;
	int c1 = 0, c2 = 1, c3 = 2;
	
	public void paint(Graphics g){
		super.paint(g);
		if(doDraw){
			int sum = x1 + x2 + x3;
			double a1 = x1*360/sum;
			double a2 = x2*360/sum;
			double a3 = x3*360/sum;
			//a1 = (int) a1;
			System.out.println(a1 + " " +a2 +" " +a3);
			//g.drawOval(x0, y0, r, r);
			g.setColor(setColor(c1));
			g.fillArc(x0, y0, r, r, 0, (int) Math.round(a1));
			g.setColor(setColor(c2));
			g.fillArc(x0, y0, r, r, (int) Math.round(a1), (int) Math.round(a2));
			g.setColor(setColor(c3));
			g.fillArc(x0, y0, r, r, (int) Math.round(a1+a2), (int) Math.round(a3));
			//g.setColor(Color.black);
			//g.drawLine(x0, y0, x0 + r, y0+r);
		}
		
	}
	
	public void setX1(int x1){
		this.x1 = x1;
	}
	
	public void setX2(int x2){
		this.x2 = x2;
	}
	
	public void setX3(int x3){
		this.x3 = x3;
	}
	
	public Color setColor(int x){
		if(x==0){
			return Color.RED;
		} 
		else if(x==1){
			return Color.BLUE;
		}
		else if(x==2){
			return Color.GREEN;
		}
		else if(x==3){
			return Color.PINK;
		}
		else if(x==4){
			return Color.ORANGE;
		}
		else if(x==5){
			return Color.CYAN;
		}
		else if(x==6){
			return Color.YELLOW;
		}
		else if(x==7){
			return Color.LIGHT_GRAY;
		}
		return Color.WHITE;
	}
	
	public void setC1(int c1){
		this.c1 = c1;
	}
	
	public void setC2(int c2){
		this.c2 = c2;
	}
	
	public void setC3(int c3){
		this.c3 = c3;
	}
}
