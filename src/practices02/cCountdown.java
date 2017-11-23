package practices02;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;

public class cCountdown extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cCountdown frame = new cCountdown();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	JLabel lblCurrentTime2 = new JLabel("00:00:00");
	private JLabel lblCountdown;
	private JTextField txtHour;
	private JTextField txtMinute;
	Timer t;
	int sec_total,sec_count;
	boolean initTime = false;
	private JLabel lblNewLabel_2;
	private JLabel lblTimeLeft;
	private JButton btnCancel;
	private JButton btnStart;
	
	public cCountdown() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCurrentTime = new JLabel("Gi\u1EDD hi\u1EC7n t\u1EA1i");
		lblCurrentTime.setBounds(33, 23, 71, 27);
		contentPane.add(lblCurrentTime);
		
		
		lblCurrentTime2.setBounds(125, 20, 86, 33);
		contentPane.add(lblCurrentTime2);
		
		lblCountdown = new JLabel("Countdown");
		lblCountdown.setBounds(33, 84, 71, 27);
		contentPane.add(lblCountdown);
		
		txtHour = new JTextField();
		txtHour.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() < '0' || e.getKeyChar() > '9'){
					e.consume();
				}
			}
		});
		txtHour.setHorizontalAlignment(SwingConstants.CENTER);
		txtHour.setText("0");
		txtHour.setBounds(125, 85, 48, 24);
		contentPane.add(txtHour);
		txtHour.setColumns(10);
		
		txtMinute = new JTextField();
		txtMinute.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyChar() < '0' || e.getKeyChar() > '9'){
					e.consume();
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		txtMinute.setHorizontalAlignment(SwingConstants.CENTER);
		txtMinute.setText("0");
		txtMinute.setColumns(10);
		txtMinute.setBounds(219, 84, 48, 27);
		contentPane.add(txtMinute);
		
		JLabel lblNewLabel = new JLabel("gi\u1EDD");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(183, 89, 30, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ph\u00FAt");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(277, 89, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		btnStart = new JButton("Start");
		t = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				sec_count++;
				int sec_left = sec_total - sec_count;
				if(sec_left >= 3600){
					int h = sec_left/3600;
					int m = sec_left/60 - h*60;
					int s = sec_left - h*3600 - m*60;
					lblTimeLeft.setText(h +" giờ " + m +" phút " + s + " giây");
				}
				else if (sec_left >= 60){
					int m = sec_left/60 ;
					int s = sec_left - m*60;
					lblTimeLeft.setText(m +" phút " + s + " giây");
				}
				else if (sec_left >= 0){		
					lblTimeLeft.setText( sec_left + " giây");
				}
				else{	
					lblTimeLeft.setText( "Quá thời gian " + sec_left + " giây");
				}
			}
		});
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//JOptionPane.showMessageDialog(null, "sec_total: " +sec_total);
				if(!initTime){
					int hour=0, min=0;
					try {
						hour = Integer.parseInt(txtHour.getText());
						min = Integer.parseInt(txtMinute.getText());
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Invalid input string");
						initTime = false;
					}
					sec_total = hour*3600 + min*60;
					sec_count = 0;
					initTime = true;
				}
				
				if(btnStart.getText().equals("Start")){
					t.start();
					btnStart.setText("Stop");
				}
				else{
					t.stop();
					btnStart.setText("Start");
				}
			}
		});
		btnStart.setBounds(333, 84, 71, 27);
		contentPane.add(btnStart);
		
		lblNewLabel_2 = new JLabel("Thời gian còn lại");
		lblNewLabel_2.setBounds(33, 186, 86, 27);
		contentPane.add(lblNewLabel_2);
		
		lblTimeLeft = new JLabel("0 giờ 0 phút 0 giây");
		lblTimeLeft.setBounds(183, 186, 112, 27);
		contentPane.add(lblTimeLeft);
		
		btnCancel = new JButton("H\u1EE7y b\u1ECF");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtHour.setText("0");
				txtMinute.setText("0");
				initTime = false;
				btnStart.setText("Start");
				t.stop();
				lblTimeLeft.setText("0 giờ 0 phút 0 giây");
			}
		});
		btnCancel.setBounds(189, 268, 89, 23);
		contentPane.add(btnCancel);
		setTimeLabel();
	}
	
	public void setTimeLabel(){
		Timer t1 = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
				Date td = new Date();
				lblCurrentTime2.setText(time.format(td));
			}
		});
		t1.start();
	}
}
