package beginner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class cTrucXanh extends JFrame{
	
	public static void main(String[] args){
		//new frame
		cTrucXanh frame = new cTrucXanh();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//
		frame.setVisible(true);
		
	}
	
	int nRow=4,nCol = 4;
	Random rd = new Random();
	//
	JButton btnPics[][] = new JButton[nRow][nCol];
	JButton btnPic01 = new JButton(), btnPic02 = new JButton();
	JLabel 	lblPic01 = new JLabel(), lblPic02 = new JLabel(),
			lblPoint = new JLabel("Point: 0");
	//variable pics
	String urlPics[] = {
			"./imgs/gameImgs/bridge.jpg",
			"./imgs/gameImgs/bunny.jpg",
			"./imgs/gameImgs/dog.jpg",
			"./imgs/gameImgs/eiffel.jpg",
			"./imgs/gameImgs/flower.jpg",
			"./imgs/gameImgs/horse.jpg",
			"./imgs/gameImgs/landscape.jpg",
			"./imgs/gameImgs/tokyo.jpg",
			
	};
	//
	int picsNum[] =new int[nRow*nCol];
	ImageIcon img[] = new ImageIcon[nRow*nCol];
	boolean firstButton = false;
	boolean TimerIsRunning = false;
	//
	int point=0;
	//Timertask
	
	public cTrucXanh(){
		setSize(800,800);
		setTitle("Windows");
		setLayout(null);
		//add
		for(int i = 0 ; i < nRow ;i++ ){
			for(int j = 0 ; j < nCol ; j++){
				btnPics[i][j] = new JButton("Pic "+((j+1)+i*nCol));
				add(btnPics[i][j]);
				btnPics[i][j].setBounds(30 + j*150, 30 + i*145 , 112,112);
				
			}
		}
		
		for(int i = 0 ; i < picsNum.length;i++){
			picsNum[i] = rd.nextInt(nRow*nCol);
			for(int j = 0 ; j < i ; j++){
				if (picsNum[j] == picsNum[i]){
					picsNum[i] = rd.nextInt(nRow*nCol);
					j=-1;
				}
			}
			//System.out.println(picsNum[i]%(nRow*nCol/2));
		}
		
		add(lblPic01);
		add(lblPic02);
		add(lblPoint);
		lblPic01.setBounds(650,30,112,112);
		lblPic02.setBounds(650,170,112,112);
		lblPoint.setBounds(80,720,70,30);
		ActionListener btnPic = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JButton btnT = (JButton)e.getSource();
				if(!TimerIsRunning){
					if(!firstButton){
						setbtn01(btnT);
						firstButton = true;
						//showPicture(btnT);
					}
					else{
						setbtn02(btnT);
					}
				}
			}
		};
		
		for(int i = 0 ; i < nRow ;i++ ){
			for(int j = 0 ; j < nCol ; j++){
				btnPics[i][j].addActionListener(btnPic);
			}
			
		}
		
	}
	
	public void setbtn01(JButton btn01){
		this.btnPic01 = btn01;
		showPicture(btnPic01);
	}
	public JButton getbtn01(){
		return btnPic01;
	}
	
	Timer timer = new Timer();
	
	public void setbtn02(JButton btn02){
		this.btnPic02 = btn02;
		showPicture(btnPic02);
		TimerIsRunning = true;
		timer.schedule(new TimerTask() {
			public void run() {
				checkPicture();
			}
		},1000);
		
	}
	public JButton getbtn02(){
		return btnPic02;
	}
	
	public void showPicture(JButton btnT){
		for(int i = 0 ; i < nRow ;i++ ){
			for(int j = 0 ; j < nCol ; j++){
				if(btnT.equals(btnPics[i][j])){
					int x = j+i*nCol; //so thu tu
					int picnum = picsNum[x]%8;
					System.out.println("Pic: " +(x+1));
					btnT.setIcon(new ImageIcon(urlPics[picnum]));
					/*if(lblpic==1){
						lblPic01.setIcon(new ImageIcon(urlPics[picnum]));
					}
					if(lblpic == 2){
						lblPic02.setIcon(new ImageIcon(urlPics[picnum]));
						firstButton = false;
					}*/
					
				}
			}
		}
	}
	
	public void checkPicture(){
		String pic1 = getbtn01().getIcon().toString();
		String pic2 = getbtn02().getIcon().toString();
		if (pic1.equals(pic2)){
			System.out.println("TRUE");
			remove(btnPic01);
			remove(btnPic02);
			point +=10;
			lblPoint.setText("Point: " +point);
			if(point>= 10*urlPics.length){
				JOptionPane.showMessageDialog(null, "Winner");
			}
			repaint();
		}
		else{
			System.out.println(pic1);
			System.out.println(pic2);
			System.out.println("FALSE");
			btnPic01.setIcon(new ImageIcon());
			btnPic02.setIcon(new ImageIcon());
		}
		
		firstButton = false;
		TimerIsRunning = false;
	}
	
}
