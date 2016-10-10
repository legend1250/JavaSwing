package beginner;

import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class cClockSample extends JPanel {
	
	int r;
	int w_h; //weight and height
	//JLabel lbltime = new JLabel();
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		int x = w_h + r/2; 
		int y = w_h + r/2;
		int x1 = x;
		int y1 = y-r/2;
		
		Date td = new Date();
		SimpleDateFormat sec = new SimpleDateFormat("ss");
		SimpleDateFormat now = new SimpleDateFormat("HH:mm:ss");
		int sec2 = Integer.parseInt(sec.format(td));
		x1 += Math.sin(Math.toRadians(360/60*sec2))*(r/2);
		y1 += (r/2)-Math.cos(Math.toRadians(360/60*sec2))*(r/2);
		g.drawOval(w_h, w_h, r, r);
		g.drawLine(x, y, x1, y1);
		System.out.println("x: "+x+"\ty: "+y +"\ttime: " +now.format(td));
		
	}
	
	
	
	public static void main(String[] args){
		
	}

}
