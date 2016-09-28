package MrNamVu;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 
 */

/**
 * @author KTTH
 * Demo TextArea without scrollbar
 */
public class cWindowDemo_ActionListener_02_Scrollbar extends JFrame {
	JLabel lblSource = new JLabel("source");
	JTextField txtSource = new JTextField();
	JButton cmdCopy = new JButton("Copy"),
			cmdCut = new JButton("Cut");
	JTextArea txtDest = new JTextArea();
	
	JScrollPane panDest = new JScrollPane(txtDest);
	
	public cWindowDemo_ActionListener_02_Scrollbar(){
		//set title for the window
		setTitle("Window Demo");
		// set the size of the window
		setSize(240, 210);
		//set layout null
		setLayout(null);
		
			
		// add components
		add( panDest);
		//add( txtDest); DON'T activate this LINE
		add( lblSource);
		add( txtSource);
		add( cmdCopy);
		add( cmdCut);
		
		
		
		//set location
		lblSource.setBounds(10, 10, 80, 25);
		txtSource.setBounds(90, 10, 130, 25);
		cmdCopy.setBounds(10, 40, 100, 25);
		cmdCut.setBounds(120, 40, 100, 25);
		panDest.setBounds(10, 70, 210, 90);
		//txtDest.setBounds(0, 0, width, height);
		
		ActionListener alXuly = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String sInput = txtSource.getText();
				txtDest.append( sInput+"\n");
				if( e.getSource().equals(cmdCut)){
					txtSource.setText("");
				}
			}
		};
		cmdCopy.addActionListener(alXuly);
		cmdCut.addActionListener(alXuly);
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// new window
		cWindowDemo_ActionListener_02_Scrollbar wMain = new cWindowDemo_ActionListener_02_Scrollbar();
		// end program as closing window.
		wMain.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// show the window
		wMain.setVisible(true);
	}

}
