package MrNamVu;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 
 */

/**
 * @author KTTH
 * Demo TextArea with scrollbar
 */
public class cWindowDemo_MouseListener_03 extends JFrame {
	JButton btnMove = new JButton("test");
	int x=100, y=100;
	int dx=0, dy=0;
	public cWindowDemo_MouseListener_03(){
		//set title for the window
		setTitle("Window Demo");
		// set the size of the window
		setSize(240, 140);
		//set layout null
		setLayout(null);

		// add components
		//add( panNotes);
		add(btnMove);
		btnMove.setBounds(x, y, 80, 80);
		
		//set location
		//panNotes.setBounds(10, 10, 210, 90);
		MouseListener mlMoving = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btnMove.setText("Exit");
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				btnMove.setText("Enter");
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				x = e.getX()-dx;
				y= e.getY()-dy;
				btnMove.setBounds(x, y, 80, 80);
			}
		};
		
		this.addMouseListener(mlMoving);
		//dx= (this.getWidth()- this.getContentPane().getWidth())/2;
		//dy= this.getHeight() -this.getContentPane().getHeight()-dx;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// new window
		cWindowDemo_MouseListener_03 wMain = new cWindowDemo_MouseListener_03();
		// end program as closing window.
		wMain.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// show the window
		wMain.setVisible(true);
	}

}
