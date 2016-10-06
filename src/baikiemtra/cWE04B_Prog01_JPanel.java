package baikiemtra;
/*
 * @author: Vinh Nguyen - T151487
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class cWE04B_Prog01_JPanel extends JPanel {

	int width = 240, height = 240;
	// int color
	JButton btnDraw = new JButton("Draw"), btnClear = new JButton("Clear");
	String color[] = { "RED", "YELLOW", "GREEN", "BLUE", "GRAY" };
	JComboBox<String> cmbColor = new JComboBox(color);
	JLabel lblChooseClr = new JLabel("Choose Color:");
	boolean doDraw = false;
	String color_choosed = "";

	public void paint(Graphics g) {
		super.paint(g);
		if (color_choosed.equals("RED")){
			g.setColor(Color.RED);
		}
		else if (color_choosed.equals("YELLOW")){
			g.setColor(Color.YELLOW);
		}
		else if (color_choosed.equals("GREEN")){
			g.setColor(Color.GREEN);
		}
		else if (color_choosed.equals("BLUE")){
			g.setColor(Color.BLUE);
		}
		else if (color_choosed.equals("GRAY")){
			g.setColor(Color.GRAY);
		}
		if (doDraw) {
			g.drawRect(20, 20, width, height);
		}

	}

	public cWE04B_Prog01_JPanel() {
		setLayout(null);
		// add coponent
		add(btnDraw);
		add(btnClear);
		add(cmbColor);
		add(lblChooseClr);

		// set Location
		lblChooseClr.setBounds(280, 40, 90, 30);
		cmbColor.setBounds(280, 80, 90, 30);
		btnDraw.setBounds(50, 280, 70, 30);
		btnClear.setBounds(150, 280, 70, 30);
		//
		btnDraw.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				color_choosed = cmbColor.getSelectedItem() + "";
				doDraw = true;
				repaint();
			}
		});
		btnClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				color_choosed = "";
				doDraw = false;
				repaint();
			}
		});

	}


}
