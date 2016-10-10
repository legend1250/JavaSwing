package beginner;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

/**
 * @author Michael Vu
 * 9600278
 * 
 */
public class cCircle extends JFrame{
	int x00= 200, y00=250, r00= 150;
	int x01= x00, y01=y00, r01= 200;
	int x02= x00, y02=y00, r02= (r00+r01)/2;
	int nLine = 4;
	public cCircle(){
		setTitle("cCricle");
		setSize(700,700);
	}
	
	public void paint( Graphics g){
		int alpha=0;
		int x1, y1,x2, y2;
		int r = (r01-r00) /2;
		super.paint(g);
		g.setColor(Color.BLUE);
		g.drawOval(x00-r00, y00-r00, 2*r00, 2*r00);
		x1= x02 + (int)( r02*Math.cos(Math.PI*alpha/180.0));
		y1= y02 - (int)( r02*Math.sin(Math.PI*alpha/180.0));
		x2= x02 + (int)( r02*Math.cos(Math.PI*(alpha+180)/180.0));
		y2= y02 - (int)( r02*Math.sin(Math.PI*(alpha+180)/180.0));
		g.drawLine(x1, y1, x2, y2);
		g.drawOval(x01-r01, y01-r01, 2*r01, 2*r01);
		g.setColor(Color.RED);
		for( int i=0; i<nLine; i++){
			alpha = i* 180/nLine;
			x1= x02 + (int)( r02*Math.cos(Math.PI*alpha/180.0));
			y1= y02 - (int)( r02*Math.sin(Math.PI*alpha/180.0));
			x2= x02 + (int)( r02*Math.cos(Math.PI*(alpha+180)/180.0));
			y2= y02 - (int)( r02*Math.sin(Math.PI*(alpha+180)/180.0));			
			g.drawLine(x1, y1, x2, y2);
			
			g.fillOval(x1-r, y1-r, 2*r, 2*r);
			g.fillOval(x2-r, y2-r, 2*r, 2*r);
		}
		
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		cCircle mainwindow = new cCircle();
		mainwindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mainwindow.setVisible(true);

	}
}
