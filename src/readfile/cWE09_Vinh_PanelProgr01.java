package readfile;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class cWE09_Vinh_PanelProgr01 extends JPanel{
	
	int x[] = new int[1000];
	int y[] = new int[1000];
	int var = 0;
	Random rd = new Random();
	@Override
	public void paint(Graphics g){
		super.paint(g);
		//g.setColor(Color.RED);
		//g.drawPolygon(x, y, var);
		int c = 2;
		for(int i = 1 ; i < var ; i++){
			c = rd.nextInt(5)+1;
			if( c == 1){
				g.setColor(Color.RED);
			}
			else if( c== 2){
				g.setColor(Color.GREEN);
			}
			else if( c== 3){
				g.setColor(Color.CYAN);
			}
			else if( c== 4){
				g.setColor(Color.YELLOW);
			}
			else if( c== 5){
				g.setColor(Color.PINK);
			}
			g.drawLine(x[i-1], y[i-1], x[i], y[i]);
		}
		g.drawLine(x[var-1], y[var-1], x[0], y[0]);
	}
	
}
