package MrNamVu;
/**
 * 
 */

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * @author Michael Vu
 * 9600278
 * 
 */
public class cWe02_Prg02C_Ad extends JFrame{
	JButton btnA = new JButton("A");
	JButton btnB = new JButton("B");
	public cWe02_Prg02C_Ad(){
       
        setSize(450, 550);
        setLayout(null);
        add(btnA);
        add(btnB);
        
        
        btnA.setBounds(10, 10, 40, 40);
        btnB.setBounds(80,	80, 40, 40);
        
        Insets mrgBut = new Insets(1,1,1,1);
        btnA.setMargin(mrgBut);
        btnB.setMargin(mrgBut);
        
        KeyListener klControl = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				int x = btnA.getX(), y = btnA.getY();
				if(arg0.getKeyChar() == 'a' || arg0.getKeyChar() == 'A'){
					x= x-5;
				}
				if(arg0.getKeyChar() == 'd' || arg0.getKeyChar() == 'D'){
					x= x+5;
				}
				if(arg0.getKeyChar() == 'w' || arg0.getKeyChar() == 'W'){
					y= y-5;
				}
				if(arg0.getKeyChar() == 'x' || arg0.getKeyChar() == 'X'){
					y= y+5;
				}
				if(arg0.getKeyChar() == 'q' || arg0.getKeyChar() == 'Q'){
					x= x-5;
					y= y-5;
				}
				if(arg0.getKeyChar() == 'e' || arg0.getKeyChar() == 'E'){
					x= x+5;
					y= y-5;
				}
				if(arg0.getKeyChar() == 'c' || arg0.getKeyChar() == 'C'){
					x= x+5;
					y= y+5;
				}
				if(arg0.getKeyChar() == 'z' || arg0.getKeyChar() == 'Z'){
					x= x-5;
					y= y+5;
				}
				btnA.setLocation(x, y);
				int x1 = btnB.getX(), y1 = btnB.getY();
				if( arg0.getKeyCode() == KeyEvent.VK_LEFT){
					x1=x1-5;
				}
				if( arg0.getKeyCode() == KeyEvent.VK_RIGHT){
					x1=x1+5;
				}
				if( arg0.getKeyCode() == KeyEvent.VK_UP){
					y1=y1-5;
				}
				if( arg0.getKeyCode() == KeyEvent.VK_DOWN){
					y1=y1-5;
				}
				if( arg0.getKeyCode() == KeyEvent.VK_HOME){
					x1=x1-5;
					y1=y1-5;
				}
				if( arg0.getKeyCode() == KeyEvent.VK_PAGE_UP){
					x1=x1+5;
					y1=y1-5;
				}
				if( arg0.getKeyCode() == KeyEvent.VK_PAGE_DOWN){
					x1=x1+5;
					y1=y1+5;
				}
				if( arg0.getKeyCode() == KeyEvent.VK_END){
					y1=y1+5;
					x1=x1-5;
				}
				btnB.setLocation(x1, y1);
			}
		}; // end key listener
	
		Timer timAutoMoving = new Timer(100, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int x = btnA.getX(), y = btnA.getY();
				x=x+2;
				if( x>getWidth()){
					x = - btnA.getWidth();
				}
				btnA.setLocation(x, y);
			}
		});
		timAutoMoving.start();
		
		this.addKeyListener(klControl);
		btnA.addKeyListener(klControl);
		btnB.addKeyListener(klControl);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cWe02_Prg02C_Ad mainWindow = new cWe02_Prg02C_Ad();
        mainWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainWindow.setVisible(true);

	}

}
