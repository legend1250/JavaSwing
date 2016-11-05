/**
 * 
 */
package weekyexam;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Vinh
 *
 */
public class cWE07C_Prog01_T151487 extends JFrame{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		cWE07C_Prog01_T151487 f = new cWE07C_Prog01_T151487();
		f.setVisible(true);
		
	}

	private static int FRAME_WIDTH = 600, FRAME_HEIGHT = 600;
	
	public cWE07C_Prog01_T151487(){
		setTitle("T151487 – Canvas");
		setPreferredSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setLayout(null);
		initCmp();
	}
	JTextField txtInput = new JTextField();	
	JButton btnDraw = new JButton("Draw"), btnClear = new JButton("Clear");
	int []arrX = new int[3];
	int []arrY = new int[3];
	int iCount = 0;
	draw panel = new draw();
	
	private void initCmp(){
		//add
		add(txtInput);
		txtInput.setBounds(30, 60, 200, 30);
		
		add(btnDraw);
		btnDraw.setBounds(280, 60, 70, 30);
		add(btnClear);
		btnClear.setBounds(370, 60, 70, 30);
		
		add(panel);
		panel.setBounds(0, 150, FRAME_WIDTH, 400);
		
		btnDraw.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String []s;
				s = txtInput.getText().split("\\s+");
				if(s.length != 6){
					JOptionPane.showMessageDialog(null, "Invalid input. Input 6 Integer number between 0 and 400");
				}
				else{
					iCount= 0;
					for(int i = 0 ; i < 6 ; i++){
						if(chkStr(s[i])){
							if(i%2==0){
								arrX[iCount] = Integer.parseInt(s[i]);
							}
							else{
								arrY[iCount] = Integer.parseInt(s[i]);
								iCount++;
							}
						}
						else{
							JOptionPane.showMessageDialog(null, "Invalid input. Input Integer number between 0 and 400");
						}
					}
				}
					
				panel.setArrX(arrX);
				panel.setArrY(arrY);
				panel.doDraw = true;
				panel.repaint();
				
			}
		});
		
		btnClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(int i = 0 ; i < 3 ;i++){
					arrX[i] = 0;
					arrY[i] = 0;
				}
				txtInput.setText("");
				panel.setArrX(arrX);
				panel.setArrY(arrY);
				panel.doDraw = false;
				panel.repaint();
			}
		});
	}
	
	private boolean chkStr(String s){
		if(!cStringLib.isIntegerNumbers(s)){
			return false;
		}
		else{
			if(Integer.parseInt(s) < 0 || Integer.parseInt(s) > 400){
				return false;
			}
		}
		return true;
	}
}

class draw extends JPanel{
	
	int []arrX = new int [3];
	int []arrY = new int [3];
	
	boolean doDraw = false;
	
	public void paint(Graphics g){
		super.paint(g);
		if(doDraw){
			g.setColor(Color.RED);
			g.drawPolygon(arrX, arrY, 3);
		}
	}
	
	
	public void setArrX(int []arr){
		this.arrX = arr;
	}
	
	public void setArrY(int []arr){
		this.arrY = arr;
	}
	
}