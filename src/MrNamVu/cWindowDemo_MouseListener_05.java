package MrNamVu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class cWindowDemo_MouseListener_05 extends JFrame {
	String[] sFilenames = {
			"D:/michaelvu/foc02/pics/s1/ant0.jpg",
			"D:/michaelvu/foc02/pics/s1/ant1.jpg",
			"D:/michaelvu/foc02/pics/s1/ant2.gif",
			"D:/michaelvu/foc02/pics/s1/ant3.jpg",
			"D:/michaelvu/foc02/pics/s1/ant4.jpg",
			"D:/michaelvu/foc02/pics/s1/ant5.jpg",
			"D:/michaelvu/foc02/pics/s1/ant6.jpg"
	};
	int iPixIndex=0;
	int nPics = 7;
	ImageIcon[] icPictures= new ImageIcon[nPics];
	JButton btnChangeImg = new JButton("change");
	// lable with Image only
	JLabel lblMsg1= new JLabel();
		
	public cWindowDemo_MouseListener_05(){
		setTitle("Label Demo with image!");
		setSize( 300, 200);
		setLayout(null);
		for( int i=0; i<nPics; i++){
			icPictures[i]= new ImageIcon(sFilenames[i]);
		}
		
		lblMsg1.setIcon( icPictures[ iPixIndex]);
		add(lblMsg1);
		//add( btnChangeImg);
		lblMsg1.setBounds(10, 30, 120, 120);
		btnChangeImg.setBounds(10, 160, 120, 25);
		
		btnChangeImg.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				iPixIndex++;
				if( iPixIndex>5){
					iPixIndex=0;
				}
				lblMsg1.setIcon( icPictures[ iPixIndex]);
			}
		});
		
		MouseListener maChange = new MouseListener() {
			
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
				iPixIndex++;
				if( iPixIndex>= nPics){
					iPixIndex =0;
				}
				lblMsg1.setIcon( icPictures[ iPixIndex]);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				iPixIndex++;
				if( iPixIndex>= nPics){
					iPixIndex =0;
				}
				lblMsg1.setIcon( icPictures[ iPixIndex]);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int x = e.getX();
				int y= e.getY();
			//	e.get
				
				lblMsg1.setBounds(x-5, y-30, 120, 120);
			}
		}; 
		this.addMouseListener(maChange);
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cWindowDemo_MouseListener_05 mainwindow = new cWindowDemo_MouseListener_05();
		mainwindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mainwindow.setVisible(true);
	}

}
