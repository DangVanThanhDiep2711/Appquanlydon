package component;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

import java.awt.Font;
import java.awt.Image;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;

public class ProfileEmployee extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panelImage;
	private JPanel panelProfile;
	private JLabel lblImage;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblEmployeeID;
	private JTextField textEmployeeID;
	private JLabel lblFullName;
	private JLabel lblNewLabel_4;
	private JLabel lblDateOfBirth;
	private JLabel lblGender;
	private JPanel panelGender;
	private JRadioButton rbFemale;
	private JRadioButton rbMale;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public ProfileEmployee() {
		setSize(846, 500);
		setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("PROFILE");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel, BorderLayout.NORTH);
		
		panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		
		btnNewButton = new JButton("thoat");
		panel.add(btnNewButton);
		
		panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		panelImage = new JPanel();
		panel_1.add(panelImage, BorderLayout.WEST);
		
		 lblImage = new JLabel();
		 lblImage.setAlignmentX(Component.RIGHT_ALIGNMENT);
	        lblImage.setHorizontalAlignment(JLabel.CENTER);
	        lblImage.setIcon(
	        		new ImageIcon("C:\\Users\\ngthi\\eclipse-workspace\\projectLeaveManagement\\image\\login1.png"));
	        lblImage.setPreferredSize(new Dimension(250, 200));
	        lblImage.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	        
	        btnNewButton_1 = new JButton("chọn ảnh");
	        GroupLayout gl_panelImage = new GroupLayout(panelImage);
	        gl_panelImage.setHorizontalGroup(
	        	gl_panelImage.createParallelGroup(Alignment.LEADING)
	        		.addGroup(gl_panelImage.createSequentialGroup()
	        			.addGroup(gl_panelImage.createParallelGroup(Alignment.LEADING)
	        				.addGroup(gl_panelImage.createSequentialGroup()
	        					.addGap(24)
	        					.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	        				.addGroup(gl_panelImage.createSequentialGroup()
	        					.addGap(105)
	        					.addComponent(btnNewButton_1)))
	        			.addContainerGap(38, Short.MAX_VALUE))
	        );
	        gl_panelImage.setVerticalGroup(
	        	gl_panelImage.createParallelGroup(Alignment.LEADING)
	        		.addGroup(gl_panelImage.createSequentialGroup()
	        			.addGap(81)
	        			.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
	        			.addGap(18)
	        			.addComponent(btnNewButton_1)
	        			.addContainerGap(41, Short.MAX_VALUE))
	        );
	        panelImage.setLayout(gl_panelImage);
	        
	       
		
		panelProfile = new JPanel();
		panel_1.add(panelProfile, BorderLayout.CENTER);
		panelProfile.setLayout(null);
		
		lblEmployeeID = new JLabel("Employee ID :");
		lblEmployeeID.setBounds(0, 11, 152, 41);
		lblEmployeeID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmployeeID.setHorizontalAlignment(SwingConstants.CENTER);
		panelProfile.add(lblEmployeeID);
		
		textEmployeeID = new JTextField();
		textEmployeeID.setBounds(162, 12, 362, 41);
		panelProfile.add(textEmployeeID);
		textEmployeeID.setColumns(10);
		
		lblFullName = new JLabel("Full Name :");
		lblFullName.setBounds(0, 63, 152, 41);
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFullName.setHorizontalAlignment(SwingConstants.CENTER);
		panelProfile.add(lblFullName);
		
		lblNewLabel_4 = new JLabel("Email :");
		lblNewLabel_4.setBounds(0, 115, 152, 41);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panelProfile.add(lblNewLabel_4);
		
		lblDateOfBirth = new JLabel("Date Of Birth :");
		lblDateOfBirth.setBounds(0, 166, 152, 41);
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDateOfBirth.setHorizontalAlignment(SwingConstants.CENTER);
		panelProfile.add(lblDateOfBirth);
		
		lblGender = new JLabel("Gender :");
		lblGender.setBounds(0, 218, 152, 41);
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		panelProfile.add(lblGender);
		
		panelGender = new JPanel();
		panelGender.setBounds(162, 220, 362, 41);
		panelProfile.add(panelGender);
		
		rbMale = new JRadioButton("Male");
		rbMale.setMnemonic('M');
		buttonGroup.add(rbMale);
		panelGender.add(rbMale);
		
		rbFemale = new JRadioButton("Female");
		rbFemale.setMnemonic('F');
		buttonGroup.add(rbFemale);
		rbFemale.setSelected(true);
		panelGender.add(rbFemale);
		
		lblNewLabel_7 = new JLabel("Phone Number :");
		lblNewLabel_7.setBounds(0, 270, 152, 41);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelProfile.add(lblNewLabel_7);
		
		lblNewLabel_2 = new JLabel("Address :");
		lblNewLabel_2.setBounds(0, 323, 152, 41);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelProfile.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(162, 64, 362, 41);
		panelProfile.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(162, 115, 362, 41);
		panelProfile.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(162, 166, 362, 41);
		panelProfile.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(162, 272, 362, 41);
		panelProfile.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(162, 324, 362, 41);
		panelProfile.add(textField_4);

	}
}
