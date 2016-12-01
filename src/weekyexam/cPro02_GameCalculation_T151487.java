/**
 * 
 */
package weekyexam;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author Vinh - legend1250
 *
 */
public class cPro02_GameCalculation_T151487 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6167778113462234652L;
	private JPanel contentPane;
	private JTextField txtSing;
	private JTextField txtTwin;
	private JTextField txtTrip;
	private JTextField txtTetr;
	private JTextArea txtOutput;
	private JButton btnCalculate;
	private JButton btnClear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cPro02_GameCalculation_T151487 frame = new cPro02_GameCalculation_T151487();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public cPro02_GameCalculation_T151487() {
		setTitle("Score Calculation - T151487");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 385, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSing = new JLabel("Sing");
		lblSing.setBounds(32, 40, 29, 14);
		contentPane.add(lblSing);
		
		JLabel lblTwin = new JLabel("Twin");
		lblTwin.setBounds(120, 40, 46, 14);
		contentPane.add(lblTwin);
		
		JLabel lblTrip = new JLabel("Trip");
		lblTrip.setBounds(215, 40, 29, 14);
		contentPane.add(lblTrip);
		
		JLabel lblTetr = new JLabel("Tetr");
		lblTetr.setBounds(302, 40, 34, 14);
		contentPane.add(lblTetr);
		
		txtSing = new JTextField();
		txtSing.setBounds(10, 65, 67, 27);
		contentPane.add(txtSing);
		txtSing.setColumns(10);
		
		txtTwin = new JTextField();
		txtTwin.setBounds(99, 65, 67, 27);
		contentPane.add(txtTwin);
		txtTwin.setColumns(10);
		
		txtTrip = new JTextField();
		txtTrip.setBounds(195, 65, 67, 27);
		contentPane.add(txtTrip);
		txtTrip.setColumns(10);
		
		txtTetr = new JTextField();
		txtTetr.setBounds(281, 65, 67, 27);
		contentPane.add(txtTetr);
		txtTetr.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 129, 170, 234);
		contentPane.add(scrollPane);
		
		txtOutput = new JTextArea();
		scrollPane.setViewportView(txtOutput);
		
		btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Sing=0,Twin=0,Trip=0,Tetr=0;
				String strInfo ="Sing: 10 \nTwin: 30\nTrip: 60 \nTetr: 90";
				txtOutput.setText(strInfo+"\n\r");
				try {
					if(txtSing.getText().isEmpty()){
						Sing = 0;
					}
					else{
						Sing = Integer.parseInt(txtSing.getText());
					}
					if(txtTetr.getText().isEmpty()){
						Tetr = 0;
					}
					else{
						Tetr = Integer.parseInt(txtTetr.getText());
					}
					if(txtTrip.getText().isEmpty()){
						Trip = 0;
					}
					else{
						Trip = Integer.parseInt(txtTrip.getText());
					}
					if(txtTwin.getText().isEmpty()){
						Twin = 0;
					}
					else{
						Twin = Integer.parseInt(txtTwin.getText());
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Inalid input: " + e1.getMessage());
				}
				
				int sum = Sing*10 + Twin*30 + Trip*60 + Tetr*90;
				txtOutput.append("Result: " +sum +"\n\r");
				txtOutput.append("Gameplay: " +(Sing + Twin + Trip + Tetr));
				
			}
		});
		btnCalculate.setBounds(226, 129, 89, 32);
		contentPane.add(btnCalculate);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtOutput.setText("");
			}
		});
		btnClear.setBounds(226, 182, 89, 32);
		contentPane.add(btnClear);
	}
}
