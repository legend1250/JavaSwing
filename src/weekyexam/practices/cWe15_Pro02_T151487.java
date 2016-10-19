package weekyexam.practices;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class cWe15_Pro02_T151487 extends JFrame {

	public static void main(String[] args) {
		cWe15_Pro02_T151487 f = new cWe15_Pro02_T151487();
		f.setVisible(true);
	}

	private static int FRAME_WIDTH = 600, FRAME_HEIGHT = 600;
	// 2 panel of drawing
	cWe15_Pro02_Panel_CCP panel01 = new cWe15_Pro02_Panel_CCP();
	cWe15_Pro01_T151487_CDP panel02 = new cWe15_Pro01_T151487_CDP();

	public cWe15_Pro02_T151487(){
		setTitle("T151487 - TestDrawing");
		setPreferredSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setLayout(null);
		
		this.add(panel01);
		this.add(panel02);
		panel01.setBounds(0, 0, panel01.P_WIDTH+1, 600);
		panel02.setBounds(panel01.P_WIDTH+2, 0, panel02.P_WIDTH+1,600);
		
		panel01.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				int x = e.getX();
				int y = e.getY();
				if( x >= panel01.x0 && x <= panel01.P_WIDTH && y >= panel01.y0 && y <= panel01.P_HEIGHT){
					panel01.drawDPanel(x,y);
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		panel02.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				int x = arg0.getX();
				int y = arg0.getY();
				
				if( x >= panel02.x0 && x <= panel02.P_WIDTH && y >= panel02.y0 && y <= panel02.P_HEIGHT){
					panel02.drawDPanel(x,y);
				}
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
