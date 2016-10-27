package chartPractices;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class cProg02_SimpleBarChart_T151487 extends JFrame{
	
	public static void main(String[] args){
		cProg02_SimpleBarChart_T151487 f = new cProg02_SimpleBarChart_T151487();
		f.setVisible(true);
	}
	
	private static int FRAME_WIDTH = 800, FRAME_HEIGHT = 800;
	cProg02_SimpleBarChart_Panel01_T151487 panel01 = new cProg02_SimpleBarChart_Panel01_T151487();
	int arr[] = new int[12];
	
	
	public cProg02_SimpleBarChart_T151487(){
		setTitle("T151487 – Simple Network Calculator");
		setPreferredSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLayout(null);
		setLocationRelativeTo(null);
		
		//add cmp
		initCmp();
		add(panel01);
		final int yPanel = 360;
		panel01.setY0(yPanel);
		panel01.setBounds(0, 250, FRAME_WIDTH, yPanel+40);
		
	}
	
	JTextField txtInput[] = new JTextField[12];
	JLabel lblInput[] = new JLabel[12];
	JTextField txtInput02 = new JTextField(), txtInput03 = new JTextField();
	JButton btnAddn12 = new JButton("Add_02"), btnDraw = new JButton("Draw"),
			btnAddL = new JButton("Add_01"), btnAddO = new JButton("Add_03");
	JLabel lblvalue[] = new JLabel[12];
	
	
	
	public void initCmp(){
		add(txtInput02);
		//txtInput02.setBounds(200, 20, 250, 30);
		//btnAdd01
		add(btnAddL);
		//btnAddL.setBounds(460, 20, 80, 30);
		//btnAdd02
		add(btnAddn12);
		btnAddn12.setBounds(550, 80, 80, 30);
		//btnAdd03
		add(txtInput03);
		//txtInput03.setBounds(20,20,40,30);
		add(btnAddO);
		//btnAddO.setBounds(550, 80, 80, 30);
		
		add(btnDraw);
		btnDraw.setBounds(550, 20, 70, 30);
		
		//12 TextField
		int y0 = 80;
		int y1 = 150;
		int r = 90;
		for(int i = 0 ; i < 6 ;i++){
			txtInput[i] = new JTextField();
			lblInput[i] = new JLabel();
			add(lblInput[i]);
			add(txtInput[i]);
			
			txtInput[i].setBounds(30 + r*i,y0,50,30);
			lblInput[i].setBounds(50 + r*i, y0+25, 50, 30);
			lblInput[i].setText("" +(i+1));
		}
		for(int i = 6 ; i < 12 ;i++){
			txtInput[i] = new JTextField();
			lblInput[i] = new JLabel();
			add(lblInput[i]);
			add(txtInput[i]);
			txtInput[i].setBounds(30 + r*(i-6),y1,50,30);
			lblInput[i].setBounds(50 + r*(i-6), y1+25, 50, 30);
			lblInput[i].setText("" +(i+1));
		}
		for(int i = 0 ; i < 12 ; i++){
			lblvalue[i] = new JLabel();
			add(lblvalue[i]);
			lblvalue[i].setBounds(650, i*20, 70, 20);
			lblvalue[i].setText("value"+i+":  "+arr[i]);
		}
		
		ActionListener act = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JButton btnT = (JButton)e.getSource();
				if(btnT.equals(btnAddn12)){
					actBtn12();
					
				}
				else if(btnT.equals(btnDraw)){
					panel01.setArrD(arr);
					panel01.doDraw = true;
					panel01.repaint();
				}
				showvalue();
			}
		};
		
		btnAddn12.addActionListener(act);
		btnDraw.addActionListener(act);
	
	}
	
	private boolean chkStr(String str){
		if(cStringLib.isIntegerNumbers(str)){
			if(Integer.parseInt(str)<0 || Integer.parseInt(str)>120){
				return false;
			}
		}
		else{
			if(!str.isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	private void actBtn12(){
		for(int i = 0 ; i < 12 ;i++){
			if(chkStr(txtInput[i].getText())){
				if(txtInput[i].getText().isEmpty()){
					arr[i] = 0;
				}
				else{
					
					arr[i] = Integer.parseInt(txtInput[i].getText());
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Invalid input at TextField: " + (i+1));
				return;
			}
		}
	}
	
	private void showvalue(){
		for(int i = 0 ; i < 12 ; i++){
			lblvalue[i].setText("value"+i+":  "+arr[i]);
		}
	}
}

