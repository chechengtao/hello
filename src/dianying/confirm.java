package dianying;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class confirm extends JDialog {

	private JTextField line_text;
	private JTextField row_text;
	private JTextField sess_text;
	private JTextField name_text;
 
	public confirm() {
		super();
		setTitle("Ticket");
		getContentPane().setBackground(SystemColor.inactiveCaptionText);
		getContentPane().setLayout(null);
		setBounds(100, 100, 334, 243);

		final JButton okButton = new JButton();
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				setVisible(false);
			}
		});
		okButton.setText("OK");
		okButton.setBounds(30, 177, 90, 25);
		getContentPane().add(okButton);

		final JButton concelButton = new JButton();
		concelButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				setVisible(false);
			}
		});
		concelButton.setText("Concel");
		concelButton.setBounds(208, 177, 90, 25);
		getContentPane().add(concelButton);

		final JLabel movieNameLabel = new JLabel();
		movieNameLabel.setText("Movie  Name :");
		movieNameLabel.setBounds(30, 55, 86, 18);
		getContentPane().add(movieNameLabel);

		name_text = new JTextField();
		name_text.setEditable(false);
		name_text.setBounds(122, 53, 176, 22);
		getContentPane().add(name_text);

		final JLabel timePriceLabel = new JLabel();
		timePriceLabel.setText("Time & Price :");
		timePriceLabel.setBounds(30, 93, 90, 18);
		getContentPane().add(timePriceLabel);

		sess_text = new JTextField();
		sess_text.setEditable(false);
		sess_text.setBounds(122, 91, 176, 22);
		getContentPane().add(sess_text);

		final JLabel numberLabel = new JLabel();
		numberLabel.setText("Seat Number :");
		numberLabel.setBounds(30, 135, 86, 18);
		getContentPane().add(numberLabel);

		final JLabel noLabel = new JLabel();
		noLabel.setFont(new Font("Verdana", Font.PLAIN, 9));
		noLabel.setText("--    NO.");
		noLabel.setBounds(210, 135, 45, 18);
		getContentPane().add(noLabel);

		row_text = new JTextField();
		row_text.setEditable(false);
		row_text.setBounds(164, 133, 40, 22);
		getContentPane().add(row_text);

		line_text = new JTextField();
		line_text.setEditable(false);
		line_text.setBounds(253, 133, 45, 22);
		getContentPane().add(line_text);

		final JLabel label_4 = new JLabel();
		label_4.setText("----------------------------Your Ticket-------------------------------");
		label_4.setBounds(10, 20, 306, 18);
		getContentPane().add(label_4);

		final JLabel noLabel_1 = new JLabel();
		noLabel_1.setFont(new Font("Verdana", Font.PLAIN, 9));
		noLabel_1.setText("ROW.");
		noLabel_1.setBounds(135, 135, 28, 18);
		getContentPane().add(noLabel_1);
		//
	}
	public void setValue(String s1, String s2, String s3, String s4)
	{
		name_text.setText(s1);
		sess_text.setText(s2);
		 row_text.setText(s3);
		line_text.setText(s4);
	}

}
