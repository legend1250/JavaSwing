package MrNamVu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 
 */

/**
 * @author KTTH
 * Demo TextArea with scrollbar
 */
public class cWindowDemo_KeyListener_02 extends JFrame {
	JTextField txtEnter = new JTextField();
	JTextField txtExit = new JTextField();
	// add text-area to scrollbar
	//JScrollPane panNotes = new JScrollPane(txtNotes);
	JLabel lblDisplay = new JLabel("display");
	
	public cWindowDemo_KeyListener_02(){
		//set title for the window
		setTitle("Window Demo");
		// set the size of the window
		setSize(240, 140);
		//set layout null
		setLayout(null);
		
		// add components
		//add( panNotes);
		add(txtEnter);
		add(lblDisplay);
		add(txtExit);
		txtEnter.setBounds(10, 10, 120, 25);
		lblDisplay.setBounds(10, 40, 80, 25);
		txtExit.setBounds(10, 70, 80, 25);
		//set location
		//panNotes.setBounds(10, 10, 210, 90);
		KeyListener klEnter = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				lblDisplay.setText(""+ e.getKeyChar());
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
		this.addKeyListener(klEnter);
		txtEnter.addKeyListener(klEnter);
		txtExit.addKeyListener(klEnter);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// new window
		cWindowDemo_KeyListener_02 wMain = new cWindowDemo_KeyListener_02();
		// end program as closing window.
		wMain.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// show the window
		wMain.setVisible(true);
	}

}
