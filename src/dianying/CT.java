package dianying;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
import java.util.Date;

public class CT extends JFrame {

	private JTextField movie_text;
	private JComboBox line_box;
	private JComboBox row_box;
	private JList sess_list;
	private JList movie_list;
	public String m_name, m_time, m_row, m_line;
	public int tmp;
	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CT frame = new CT();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame
	 */
	public CT() {
		super();
		setTitle("C-T (mini)");
		getContentPane().setFont(new Font("Arial", Font.PLAIN, 12));
		getContentPane().setBackground(SystemColor.inactiveCaptionText);
		getContentPane().setLayout(null);
		setBounds(100, 100, 375, 544);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final DefaultListModel listModel = new DefaultListModel();
		listModel.addElement("Spider Man 4");
		listModel.addElement("Transformer 2");
		listModel.addElement("Dragonball Evolution");
		listModel.addElement("Australia");
		listModel.addElement("WALL-E");
		movie_list = new JList(listModel);
		movie_list.setFont(new Font("Arial", Font.PLAIN, 12));
		movie_list.setBounds(30, 97, 195, 132);
		getContentPane().add(movie_list);
		
		final JButton add_m_btn = new JButton();
		add_m_btn.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				String tmp = movie_text.getText();
				listModel.addElement(tmp);
			}
		});
		add_m_btn.setFont(new Font("Arial", Font.PLAIN, 12));
		add_m_btn.setText(" Add ");
		add_m_btn.setBounds(243, 149, 85, 25);
		getContentPane().add(add_m_btn);
//		add_m_btn.addActionListener(this);
		
		
		final JButton del_m_btn = new JButton();
		del_m_btn.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				listModel.removeElementAt(movie_list.getSelectedIndex());
			}
		});
		del_m_btn.setFont(new Font("Arial", Font.PLAIN, 12));
		del_m_btn.setText("Delete");
		del_m_btn.setBounds(243, 204, 85, 25);
		getContentPane().add(del_m_btn);

		final DefaultListModel listModel2 = new DefaultListModel();
		listModel2.addElement(" 07:00-09:00                          $30");
		listModel2.addElement(" 09:30-11:30                          $30");
		listModel2.addElement(" 12:00-14:00                          $40");
		listModel2.addElement(" 14:30-16:30                          $30");
		listModel2.addElement(" 17:00-19:00                          $60");
		listModel2.addElement(" 19:30-21:30                          $60");
		listModel2.addElement(" 22:00-23:30                          $40");
		sess_list = new JList(listModel2);
		sess_list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(final MouseEvent e) {
				m_time = (String)sess_list.getSelectedValue();
//				System.out.println(m_time);
			}
		});
		sess_list.setFont(new Font("Arial", Font.PLAIN, 12));
		sess_list.setBounds(30, 275, 298, 156);
		getContentPane().add(sess_list);
		
		movie_list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(final MouseEvent arg0) {
				m_name = (String)movie_list.getSelectedValue();				
				Date MyDate = new Date();
				int h=MyDate.getHours();
//				System.out.println(m_name);
				if (9<=h && h<=10)
				{
					listModel2.set(0," 07:00-09:00                      Expired");
				}
				if (11<=h &&h<=12)
				{
					listModel2.set(0," 07:00-09:00                      Expired");
					listModel2.set(1," 09:30-11:30                      Expired");
				}
				if (14<=h &&h<=15)
				{
					listModel2.set(0," 07:00-09:00                      Expired");
					listModel2.set(1," 09:30-11:30                      Expired");
					listModel2.set(2," 12:00-14:00                      Expired");
				}
				if (16<=h &&h<=17)
				{
					listModel2.set(0," 07:00-09:00                      Expired");
					listModel2.set(1," 09:30-11:30                      Expired");
					listModel2.set(2," 12:00-14:00                      Expired");
					listModel2.set(3," 14:30-16:30                      Expired");
				}
				if (19<=h &&h<=20)
				{
					listModel2.set(0," 07:00-09:00                      Expired");
					listModel2.set(1," 09:30-11:30                      Expired");
					listModel2.set(2," 12:00-14:00                      Expired");
					listModel2.set(3," 14:30-16:30                      Expired");
					listModel2.set(4," 17:00-19:00                      Expired");
				}
				if (21<=h &&h<=22)
				{
					listModel2.set(0," 07:00-09:00                      Expired");
					listModel2.set(1," 09:30-11:30                      Expired");
					listModel2.set(2," 12:00-14:00                      Expired");
					listModel2.set(3," 14:30-16:30                      Expired");
					listModel2.set(4," 17:00-19:00                      Expired");
					listModel2.set(5," 19:30-21:30                      Expired");
				}
				else
				{}
			}
		});

		row_box = new JComboBox();
		row_box.addItemListener(new ItemListener() {
			public void itemStateChanged(final ItemEvent arg0) {
				m_row = (String)row_box.getSelectedItem();
//				System.out.println(m_row);
			}
		});
		row_box.setFont(new Font("Arial", Font.PLAIN, 12));
		row_box.setBounds(31, 476, 87, 18);
		row_box.addItem("");
		row_box.addItem("01");
		row_box.addItem("02");
		row_box.addItem("03");
		row_box.addItem("04");
		row_box.addItem("05");
		row_box.addItem("06");
		row_box.addItem("07");
		row_box.addItem("08");
		row_box.addItem("09");
		row_box.addItem("10");
		row_box.addItem("11");
		row_box.addItem("12");
		row_box.addItem("11");
		row_box.addItem("12");
		row_box.addItem("13");
		row_box.addItem("14");
		row_box.addItem("15");
		row_box.addItem("16");
		getContentPane().add(row_box);

		line_box = new JComboBox();
		line_box.addItemListener(new ItemListener() {
			public void itemStateChanged(final ItemEvent e) {
				m_line = null;
				m_line = (String)line_box.getSelectedItem();
				tmp = line_box.getSelectedIndex();
//				System.out.println(m_line);			
			}
		});
		line_box.setFont(new Font("Arial", Font.PLAIN, 12));
		line_box.setBounds(142, 476, 83, 18);
		line_box.addItem("");
		line_box.addItem("01");
		line_box.addItem("02");
		line_box.addItem("03");
		line_box.addItem("04");
		line_box.addItem("05");
		line_box.addItem("06");
		line_box.addItem("07");
		line_box.addItem("08");
		line_box.addItem("09");
		line_box.addItem("10");
		line_box.addItem("11");
		line_box.addItem("12");
		line_box.addItem("13");
		line_box.addItem("14");
		line_box.addItem("15");
		line_box.addItem("16");
		line_box.addItem("17");
		line_box.addItem("18");
		line_box.addItem("19");
		line_box.addItem("20");
		getContentPane().add(line_box);

		final JButton buy_btn = new JButton();
		buy_btn.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				confirm c =new confirm();
				c.setValue(m_name, m_time, m_row, m_line);
				c.setVisible(true);
				line_box.removeItemAt(tmp);
			}
		});
		buy_btn.setFont(new Font("Arial", Font.PLAIN, 12));
		buy_btn.setText("BUY!");
		buy_btn.setBounds(244, 475, 85, 25);
		getContentPane().add(buy_btn);

		final JLabel movieListLabel = new JLabel();
		movieListLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		movieListLabel.setText("Select Movie");
		movieListLabel.setBounds(30, 77, 114, 18);
		getContentPane().add(movieListLabel);

		final JLabel label = new JLabel();
		label.setFont(new Font("Arial", Font.PLAIN, 12));
		label.setText("Select Screen");
		label.setBounds(30, 255, 114, 18);
		getContentPane().add(label);

		final JLabel label_1 = new JLabel();
		label_1.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1.setText("Select Row");
		label_1.setBounds(30, 455, 66, 18);
		getContentPane().add(label_1);

		final JLabel label_2 = new JLabel();
		label_2.setFont(new Font("Arial", Font.PLAIN, 12));
		label_2.setText("Select No");
		label_2.setBounds(141, 455, 66, 18);
		getContentPane().add(label_2);

		final JLabel cinemaTicketminiLabel = new JLabel();
		cinemaTicketminiLabel.setForeground(new Color(0, 0, 255));
		cinemaTicketminiLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		cinemaTicketminiLabel.setText("Cinema Ticket (mini version)");
		cinemaTicketminiLabel.setBounds(55, 20, 266, 18);
		getContentPane().add(cinemaTicketminiLabel);

		final JLabel step1Label = new JLabel();
		step1Label.setFont(new Font("Arial", Font.PLAIN, 12));
		step1Label.setText("------------------------------------  Step 1 ------------------------------------");
		step1Label.setBounds(15, 56, 350, 18);
		getContentPane().add(step1Label);

		final JLabel label_4_1 = new JLabel();
		label_4_1.setFont(new Font("Arial", Font.PLAIN, 12));
		label_4_1.setText("------------------------------------  Step 2 ------------------------------------");
		label_4_1.setBounds(15, 235, 350, 18);
		getContentPane().add(label_4_1);

		final JLabel label_4_1_1 = new JLabel();
		label_4_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		label_4_1_1.setText("------------------------------------  Step 3 ------------------------------------");
		label_4_1_1.setBounds(15, 435, 350, 18);
		getContentPane().add(label_4_1_1);

		movie_text = new JTextField();
		movie_text.setBounds(243, 121, 85, 22);
		getContentPane().add(movie_text);

		final JLabel movieListLabel_1 = new JLabel();
		movieListLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		movieListLabel_1.setText("Movie's Name");
		movieListLabel_1.setBounds(243, 97, 114, 18);
		getContentPane().add(movieListLabel_1);
		//
	}
}
