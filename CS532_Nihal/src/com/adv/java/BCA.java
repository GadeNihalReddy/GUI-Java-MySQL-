package com.adv.java;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.jcraft.jsch.Session;

import net.proteanit.sql.DbUtils;

import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;

public class BCA extends JFrame {

	private JPanel contentPane;
	public static Db db=new Db();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table_2;
	private JTable table;
	private JTable table_1;
	private JTable table_3;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JDialog jDialog_upd;
	
	public static Connection conn=db.driverCon();
	public static Session ses=db.session;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BCA frame = new BCA();
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
	public BCA() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1078, 810);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenu mnNew = new JMenu("New");
		mnFile.add(mnNew);
		
		JMenuItem mntmQueries = new JMenuItem("Queries");
		mntmQueries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Will Be Released in Next Build","Build Update",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnNew.add(mntmQueries);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Will Be Released in Next Build","Build Update",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnFile.add(mntmSave);
		
		JMenuItem mntmSaveAs = new JMenuItem("Save As");
		mntmSaveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Will Be Released in Next Build","Build Update",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnFile.add(mntmSaveAs);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Db.closeCon();
				try {
					
					System.out.println(conn);
					conn.close();
					System.out.println(ses.isConnected());
					System.out.println(ses.getUserName());
					ses.disconnect();
					System.out.println("disconnected");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.exit(JFrame.EXIT_ON_CLOSE);
				
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);
		
		JMenu mnTables = new JMenu("Tables");
		mnView.add(mnTables);
		
		JMenuItem mntmAllTables = new JMenuItem("All Tables");
		mntmAllTables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Will Be Released in Next Build","Build Update",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnTables.add(mntmAllTables);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JLabel lblNewLabel_2 = new JLabel("contact : ngade@mail.bradley.edu");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(683, 37, 243, 16);
		
		lblNewLabel_2.setVisible(false);
		
		JMenuItem mntmCustomerSupport = new JMenuItem("Customer Support");
		mntmCustomerSupport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_2.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_2.setVisible(true);
			}
		});
		mnHelp.add(mntmCustomerSupport);
		
		JMenuItem mntmDeveloperSupport = new JMenuItem("Developer Support");
		mntmDeveloperSupport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblNewLabel_2.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_2.setVisible(false);
			}
		});
		mnHelp.add(mntmDeveloperSupport);
		
		JMenuItem mntmManual = new JMenuItem("Manual");
		mntmManual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProcessBuilder pb=new ProcessBuilder("Notepad.exe","test2");
				try {
					pb.start();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null,"Manual Not Found(Missed while Installation may be :( )","Message",JOptionPane.INFORMATION_MESSAGE);
					System.out.println("File not Found");
					//e1.printStackTrace();
				}
			}
		});
		mnHelp.add(mntmManual);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBookClientDatabase = new JLabel("Book Client Database");
		lblBookClientDatabase.setBounds(377, 13, 223, 16);
		lblBookClientDatabase.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblBookClientDatabase);
		contentPane.add(lblNewLabel_2);
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(22, 66, 998, 600);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Search", null, panel, null);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		
		comboBox.setEditable(true);
		comboBox.setBounds(12, 34, 139, 22);
		panel.add(comboBox);
		comboBox.setSelectedItem("Select Table");
		//Connection conn=db.driverCon();
		String query="show tables;";
		ResultSet res = null;
		Statement stmt;
		try {
			stmt = conn.createStatement();
			res = stmt.executeQuery(query);
			while(res.next()) {
				comboBox.addItem(res.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 89, 138, 107);
		panel.add(scrollPane);
		
		DefaultListModel<String> dlm1 = new DefaultListModel<String>();
		JList list_1 = new JList(dlm1);
		scrollPane.setViewportView(list_1);
		comboBox.setSelectedItem("Titles");
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query10="describe "+comboBox.getSelectedItem().toString();
				dlm1.clear();
				ResultSet res10 = null;
				Statement stmt10;
				try {
					stmt10 = conn.createStatement();
					res10 = stmt10.executeQuery(query10);
					while(res10.next()) {
						dlm1.addElement(res10.getString(1));
					}
					list_1.setModel(dlm1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		JLabel lblColumns = new JLabel("Columns");
		lblColumns.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblColumns.setBounds(12, 67, 83, 16);
		panel.add(lblColumns);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(182, 335, 777, 155);
		panel.add(scrollPane_2);
		
		table = new JTable();
		scrollPane_2.setViewportView(table);
		
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(182, 34, 776, 277);
		panel.add(tabbedPane_1);
		
		JPanel panel_5 = new JPanel();
		tabbedPane_1.addTab("Search", null, panel_5, null);
		panel_5.setLayout(null);
		
		
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(147, 60, 283, 103);
		panel_5.add(textArea);
		
		JButton button = new JButton(">>");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str=comboBox.getSelectedItem().toString()+'.'+list_1.getSelectedValue().toString();
				textArea.setText(str);
			}
		});
		button.setBounds(23, 90, 63, 25);
		panel_5.add(button);
		
		JButton btnRetrieve = new JButton("Retrieve");
		btnRetrieve.setBounds(523, 72, 97, 25);
		panel_5.add(btnRetrieve);
		
		
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		btnClear.setBounds(523, 135, 97, 25);
		panel_5.add(btnClear);
		btnRetrieve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query12="select Authors.AuthorID,FirstName,LastName,Title,Titles.ISBN,EditionNumber,Copyright from Authors,Titles,AuthorISBN "
						+ "where AuthorISBN.AuthorID=Authors.AuthorID and AuthorISBN.ISBN=Titles.ISBN and "+textArea.getText();
				ResultSet res12 = null;
				Statement stmt12;
				try {
					stmt12 = conn.createStatement();
					res12 = stmt12.executeQuery(query12);
					table.setModel(DbUtils.resultSetToTableModel(res12));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		
		JPanel panel_6 = new JPanel();
		tabbedPane_1.addTab("Advanced Search", null, panel_6, null);
		panel_6.setLayout(null);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_4.setEditable(true);
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"   >", "   <", "   =", "   >=", "   <="}));
		comboBox_4.setBounds(37, 52, 56, 22);
		panel_6.add(comboBox_4);
		
		JLabel lblOperator = new JLabel("Operator");
		lblOperator.setBounds(37, 23, 56, 16);
		panel_6.add(lblOperator);
		
		textField_12 = new JTextField();
		textField_12.setBounds(162, 52, 195, 22);
		panel_6.add(textField_12);
		textField_12.setColumns(10);
		
		JLabel lblValue = new JLabel("Value");
		lblValue.setBounds(246, 23, 56, 16);
		panel_6.add(lblValue);
		
		JRadioButton rdbtnAnd = new JRadioButton("AND");
		rdbtnAnd.setBounds(37, 101, 127, 25);
		panel_6.add(rdbtnAnd);
		
		JRadioButton rdbtnOr = new JRadioButton("OR");
		rdbtnOr.setBounds(37, 131, 127, 25);
		panel_6.add(rdbtnOr);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(162, 102, 195, 67);
		panel_6.add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(519, 36, 240, 147);
		panel_6.add(textArea_2);
		
		JButton button_1 = new JButton(">>");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str=comboBox.getSelectedItem().toString()+'.'+list_1.getSelectedValue().toString();
				
				String str2=comboBox_4.getSelectedItem().toString()+textField_12.getText();
				
				String st=str+str2;
				String st1=null;
				if(rdbtnAnd.isSelected()){
					st1=rdbtnAnd.getText().toString();
				}
				else if(rdbtnOr.isSelected()){
					st1=rdbtnOr.getText().toString();
				}
				if(st1!=null){
					String st2=textArea_1.getText();
					String st3=st+" "+st1+" "+st2;
					textArea_2.setText(st3);
				}
				else{
					textArea_2.setText(st);
				}
				
			}
		});
		button_1.setBounds(404, 101, 69, 25);
		panel_6.add(button_1);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query_adv="select Authors.AuthorID,FirstName,LastName,Title,Titles.ISBN,EditionNumber,Copyright from Authors,Titles,AuthorISBN "
						+ "where AuthorISBN.AuthorID=Authors.AuthorID and AuthorISBN.ISBN=Titles.ISBN and "+textArea_2.getText();
				ResultSet res_adv = null;
				Statement stmt_adv;
				try {
					stmt_adv = conn.createStatement();
					res_adv = stmt_adv.executeQuery(query_adv);
					table.setModel(DbUtils.resultSetToTableModel(res_adv));
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
			}
		});
		btnSearch.setBounds(205, 198, 97, 25);
		panel_6.add(btnSearch);
		
		JButton btnClear_2 = new JButton("Clear");
		btnClear_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_12.setText("");
				rdbtnAnd.setSelected(false);;
				rdbtnOr.setSelected(false);
				textArea_1.setText("");
				textArea_2.setText("");
			}
		});
		btnClear_2.setBounds(424, 198, 97, 25);
		panel_6.add(btnClear_2);
		
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Insert", null, panel_1, null);
		panel_1.setLayout(null);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setEditable(true);
		comboBox_1.setBounds(12, 48, 121, 22);
		panel_1.add(comboBox_1);
		comboBox_1.setSelectedItem("Select Table");
		ResultSet res8 = null;
		Statement stmt8;
		try {
			stmt8 = conn.createStatement();
			res8 = stmt8.executeQuery(query);
			while(res8.next()) {
				comboBox_1.addItem(res8.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 101, 128, 123);
		panel_1.add(scrollPane_1);
		
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		JList list = new JList(dlm);
		scrollPane_1.setViewportView(list);
		//Connection conn9=db.driverCon();
		comboBox_1.setSelectedItem("Titles");
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query9="describe "+comboBox_1.getSelectedItem().toString();
				dlm.clear();
				ResultSet res9 = null;
				Statement stmt9;
				try {
					stmt9 = conn.createStatement();
					res9 = stmt9.executeQuery(query9);
					while(res9.next()) {
						dlm.addElement(res9.getString(1));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		
		JLabel lblAuthor = new JLabel("Author Information");
		lblAuthor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAuthor.setBounds(225, 51, 128, 16);
		panel_1.add(lblAuthor);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(178, 105, 81, 16);
		panel_1.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(178, 156, 71, 16);
		panel_1.add(lblLastName);
		
		textField = new JTextField();
		textField.setBounds(271, 102, 135, 22);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(271, 153, 135, 22);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Book Information");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(494, 51, 146, 16);
		panel_1.add(lblNewLabel);
		
		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setBounds(449, 101, 56, 16);
		panel_1.add(lblIsbn);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(449, 150, 49, 16);
		panel_1.add(lblTitle);
		
		JLabel lblNewLabel_1 = new JLabel("Edition Number");
		lblNewLabel_1.setBounds(410, 185, 95, 16);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblCopyright = new JLabel("Copyright");
		lblCopyright.setBounds(438, 232, 56, 16);
		panel_1.add(lblCopyright);
		
		textField_2 = new JTextField();
		textField_2.setBounds(517, 100, 116, 22);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(517, 147, 116, 22);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(517, 182, 116, 22);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(517, 229, 116, 22);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query_ins1="insert into Authors(FirstName,LastName) values(?,?)";
					PreparedStatement ps=conn.prepareStatement(query_ins1);
					ps.setString(1,textField.getText());
					ps.setString(2,textField_1.getText());
					ps.execute();
					String query_ins2="insert into Titles values(?,?,?,?)";
					PreparedStatement ps2=conn.prepareStatement(query_ins2);
					ps2.setString(1,textField_2.getText());
					ps2.setString(2,textField_3.getText());
					ps2.setString(3,textField_4.getText());
					ps2.setString(4,textField_5.getText());
					ps2.execute();
					String getID="select AuthorID from Authors where Authors.FirstName= ? and Authors.LastName= ?";
					//System.out.println(getID);
					PreparedStatement ps3=conn.prepareStatement(getID);
					ps3.setString(1,textField.getText());
					ps3.setString(2,textField_1.getText());
					ResultSet rs=ps3.executeQuery();
					if(rs.next())
					{
						String query_ins3="insert into AuthorISBN values(?,?)";
						PreparedStatement ps4=conn.prepareStatement(query_ins3);
						ps4.setString(1,rs.getString(1));
						ps4.setString(2,textField_2.getText());
						ps4.execute();
					}
					JOptionPane.showMessageDialog(null,"Inserted Successfully","Insert Performed",JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		btnInsert.setBounds(790, 152, 97, 25);
		panel_1.add(btnInsert);
		
		JButton btnClear_1 = new JButton("Clear");
		btnClear_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				
			}
		});
		btnClear_1.setBounds(790, 228, 97, 25);
		panel_1.add(btnClear_1);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(72, 314, 800, 169);
		panel_1.add(scrollPane_5);
		
		table_3 = new JTable();
		scrollPane_5.setViewportView(table_3);
		
		JButton btnLoadTable = new JButton("Load Table");
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query13="select Authors.AuthorID,FirstName,LastName,Title,Titles.ISBN,EditionNumber,Copyright from Authors,Titles,AuthorISBN where AuthorISBN.AuthorID=Authors.AuthorID and AuthorISBN.ISBN=Titles.ISBN";
				ResultSet res13 = null;
				Statement stmt13;
				try {
					stmt13 = conn.createStatement();
					res13 = stmt13.executeQuery(query13);
					table_3.setModel(DbUtils.resultSetToTableModel(res13));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnLoadTable.setBounds(346, 261, 97, 25);
		panel_1.add(btnLoadTable);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Delete", null, panel_2, null);
		panel_2.setLayout(null);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setEditable(true);
		comboBox_2.setBounds(438, 38, 103, 22);
		panel_2.add(comboBox_2);
		comboBox_2.setSelectedItem("Select Table");
		//Connection conn=db.driverCon();
		String query6="show tables;";
		ResultSet res6 = null;
		Statement stmt6;
		try {
			stmt6 = conn.createStatement();
			res6 = stmt6.executeQuery(query6);
			while(res6.next()) {
				comboBox_2.addItem(res6.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query14="select * from "+ comboBox_2.getSelectedItem().toString();
				ResultSet res14 = null;
				Statement stmt14;
				try {
					stmt14 = conn.createStatement();
					res14 = stmt14.executeQuery(query14);
					table_1.setModel(DbUtils.resultSetToTableModel(res14));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JLabel lblSelectOneRow = new JLabel("Select One Row");
		lblSelectOneRow.setBounds(438, 118, 109, 16);
		panel_2.add(lblSelectOneRow);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel tb=(DefaultTableModel) table_1.getModel();
				if(table_1.getSelectedRowCount()==1){
					
					String query_del="Delete from "+comboBox_2.getSelectedItem().toString()+" where "+tb.getColumnName(0)+" = "+tb.getValueAt(table_1.getSelectedRow(), 0);
					//System.out.println(query_del);
					PreparedStatement ps;
					
					try {
						ps = conn.prepareStatement(query_del);
						ps.execute();
						tb.removeRow(table_1.getSelectedRow());
						JOptionPane.showMessageDialog(null,"Deleted Successfully","Delete Performed",JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,"First AuthorISBN Table Data Should be deleted because of its Referential Integrety","Warning Message",JOptionPane.INFORMATION_MESSAGE);
						//e.printStackTrace();
					}
					
					
				}
				else if(table_1.getSelectedRowCount()==0){
					JOptionPane.showMessageDialog(null,"There is No Data Selected from Table","Message",JOptionPane.INFORMATION_MESSAGE);
					
				}
				else {
					JOptionPane.showMessageDialog(null,"Please select One row at a time from table","Message",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnDelete.setBounds(461, 368, 97, 25);
		panel_2.add(btnDelete);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(218, 147, 623, 193);
		panel_2.add(scrollPane_3);
		
		table_1 = new JTable();
		scrollPane_3.setViewportView(table_1);
		
		JLabel lblSelectTable = new JLabel("Tables");
		lblSelectTable.setBounds(461, 13, 56, 16);
		panel_2.add(lblSelectTable);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Update", null, panel_3, null);
		panel_3.setLayout(null);
		
		JComboBox comboBox_3 = new JComboBox();
		
		comboBox_3.setEditable(true);
		comboBox_3.setBounds(244, 51, 121, 22);
		panel_3.add(comboBox_3);
		comboBox_3.setSelectedItem("Select Table");
		//Connection conn=db.driverCon();
		String query5="show tables;";
		ResultSet res5 = null;
		Statement stmt5;
		try {
			stmt5 = conn.createStatement();
			res5 = stmt5.executeQuery(query5);
			while(res5.next()) {
				comboBox_3.addItem(res5.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query15="select * from "+ comboBox_3.getSelectedItem().toString();
				String query_updt="select Authors.AuthorID,FirstName,LastName,Title,Titles.ISBN,EditionNumber,Copyright from Authors,Titles,AuthorISBN where AuthorISBN.AuthorID=Authors.AuthorID and AuthorISBN.ISBN=Titles.ISBN ";
				//String query15="select * from Authors,Titles,AuthorISBN where AuthorISBN.AuthorID=Authors.AuthorID and AuthorISBN.ISBN=Titles.ISBN";
				ResultSet res15 = null;
				Statement stmt15;
				try {
					stmt15 = conn.createStatement();
					res15 = stmt15.executeQuery(query_updt);
					table_2.setModel(DbUtils.resultSetToTableModel(res15));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(33, 134, 612, 213);
		panel_3.add(scrollPane_4);
		
		table_2 = new JTable();
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				DefaultTableModel tb2=(DefaultTableModel) table_2.getModel();
				
				String fn=tb2.getValueAt(table_2.getSelectedRow(), 1).toString();
				String ln=tb2.getValueAt(table_2.getSelectedRow(), 2).toString();
				String ttl=tb2.getValueAt(table_2.getSelectedRow(), 3).toString();
				String isbn=tb2.getValueAt(table_2.getSelectedRow(), 4).toString();
				String edn=tb2.getValueAt(table_2.getSelectedRow(), 5).toString();
				String cr=tb2.getValueAt(table_2.getSelectedRow(), 6).toString();
				
				
				textField_6.setText(fn);
				textField_7.setText(ln);
				textField_8.setText(ttl);
				textField_9.setText(isbn);
				textField_10.setText(edn);
				textField_11.setText(cr);
				
			}
		});
		scrollPane_4.setViewportView(table_2);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel tb2=(DefaultTableModel) table_2.getModel();
				if(table_2.getSelectedRowCount()==1){
					try {
						String query_upd1="update Authors set FirstName=?, LastName=? where AuthorID="+tb2.getValueAt(table_2.getSelectedRow(), 0).toString();
						PreparedStatement ps=conn.prepareStatement(query_upd1);
						ps.execute("SET FOREIGN_KEY_CHECKS=0");
						ps.setString(1,textField_6.getText().toString());
						ps.setString(2,textField_7.getText().toString());
						ps.execute();
						String query_upd3="update AuthorISBN set ISBN=? where AuthorID="+tb2.getValueAt(table_2.getSelectedRow(), 0).toString();
						PreparedStatement ps3=conn.prepareStatement(query_upd3);
						ps3.setString(1,textField_9.getText().toString());
						ps3.execute();
						String query_upd2="update Titles set Title=?,ISBN=?, EditionNumber=?, Copyright=? where ISBN="+tb2.getValueAt(table_2.getSelectedRow(), 4).toString();
						PreparedStatement ps2=conn.prepareStatement(query_upd2);
						ps2.setString(1,textField_8.getText().toString());
						ps2.setString(2,textField_9.getText().toString());
						ps2.setString(3,textField_10.getText().toString());
						ps2.setString(4,textField_11.getText().toString());
						ps2.execute();
						ps.execute("SET FOREIGN_KEY_CHECKS=1");
						
						JOptionPane.showMessageDialog(null,"Update Succesful","Message",JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e1) {
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null,"Error in Update","Message",JOptionPane.INFORMATION_MESSAGE);
					}
					
				}
			
			}
		});
		btnUpdate.setBounds(324, 398, 97, 25);
		panel_3.add(btnUpdate);
		
		JLabel lblDeatils = new JLabel("Author Deatils");
		lblDeatils.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDeatils.setBounds(783, 71, 134, 16);
		panel_3.add(lblDeatils);
		
		JLabel lblFirstName_1 = new JLabel("First Name");
		lblFirstName_1.setBounds(706, 111, 74, 16);
		panel_3.add(lblFirstName_1);
		
		JLabel lblLastName_1 = new JLabel("Last Name");
		lblLastName_1.setBounds(706, 142, 80, 16);
		panel_3.add(lblLastName_1);
		
		JLabel lblTitle_1 = new JLabel("Title");
		lblTitle_1.setBounds(706, 229, 56, 16);
		panel_3.add(lblTitle_1);
		
		JLabel lblIsbn_1 = new JLabel("ISBN");
		lblIsbn_1.setBounds(706, 264, 56, 16);
		panel_3.add(lblIsbn_1);
		
		JLabel lblEdition = new JLabel("Edition Number");
		lblEdition.setBounds(706, 302, 97, 16);
		panel_3.add(lblEdition);
		
		JLabel lblCopyright_1 = new JLabel("Copyright");
		lblCopyright_1.setBounds(706, 331, 56, 16);
		panel_3.add(lblCopyright_1);
		
		textField_6 = new JTextField();
		textField_6.setBounds(805, 108, 147, 22);
		panel_3.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(804, 139, 147, 22);
		panel_3.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(805, 226, 147, 22);
		panel_3.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(805, 261, 147, 22);
		panel_3.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(805, 296, 147, 22);
		panel_3.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(805, 325, 147, 22);
		panel_3.add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblTables = new JLabel("Tables");
		lblTables.setBounds(275, 22, 56, 16);
		panel_3.add(lblTables);
		
		JButton btnClear_3 = new JButton("Clear");
		btnClear_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				textField_9.setText("");
				textField_10.setText("");
				textField_11.setText("");
			}
		});
		btnClear_3.setBounds(595, 398, 97, 25);
		panel_3.add(btnClear_3);
		
		JLabel lblBookDetails = new JLabel("Book Details");
		lblBookDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBookDetails.setBounds(783, 197, 105, 16);
		panel_3.add(lblBookDetails);
	}
}
