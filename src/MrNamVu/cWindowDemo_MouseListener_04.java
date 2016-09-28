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
public class cWindowDemo_MouseListener_04 extends JFrame {
	JButton btnMove = new JButton("test");
	int x=100, y=100;
	int dx=0, dy=0;
	public cWindowDemo_MouseListener_04(){
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
				x = e.getX();
				y= e.getY();
				btnMove.setBounds(x, y, 80, 80);
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

			}
		};
		
		this.addMouseListener(mlMoving);
	
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// new window
		cWindowDemo_MouseListener_04 wMain = new cWindowDemo_MouseListener_04();
		// end program as closing window.
		wMain.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// show the window
		wMain.setVisible(true);
	}

}
