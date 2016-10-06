package baikiemtra;

/*
 * @author: Vinh Nguyen - T151487
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class cWE04B_Prog02_JPanel extends JPanel {

	int x0 = 150, y0 = 200;
	int cao = 150, ngang = 90;
	int x[] = { x0, x0, x0 + ngang };
	int y[] = { y0, y0 - cao, y0 };

	JButton btnRotate = new JButton("Roate90"),
			btnRotateM = new JButton("RoateM90");
	

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.RED);
		if (degree==0) {
			x[1] = x0;
			y[1] = y0 - cao;
			x[2] = x0 + ngang;
			y[2] = y0;
		}
		else if (degree==90) {
			x[1] = x0 - cao;
			y[1] = y0;
			x[2] = x0;
			y[2] = y0 - ngang;
		}
		else if(degree==180) {
			x[1] = x0;
			y[1] = y0+cao;
			x[2] = x0 + ngang;
			y[2] = y0;
		}
		else if(degree==270) {
			x[1] = x0;
			y[1] = y0-ngang;
			x[2] = x0+cao;
			y[2] = y0;
		}
		

		g.drawPolygon(x, y, 3);

	}
	
	int degree = 0;
	
	public cWE04B_Prog02_JPanel() {
		setLayout(null);
		//
		add(btnRotate);
		add(btnRotateM);
		btnRotate.setBounds(40, 320, 90, 30);
		btnRotateM.setBounds(280, 320, 95, 30);
		btnRotate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				degree +=90;
				if (degree >= 360){
					degree = 0;
				}
				//System.out.println(degree);
				repaint();
				
			}
		});
		btnRotateM.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				degree -=90;
				if (degree < 0){
					degree = 360-90;
				}
				//System.out.println(degree);
				repaint();
			}
		});

	}
}
