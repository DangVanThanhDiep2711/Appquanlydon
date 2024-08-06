package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.*;
import javax.swing.GroupLayout.Alignment;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.prefs.Preferences;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;

import dao.EmployeeDao;
import dao.LeaveRequestDao;
import entity.Employees;
import entity.Role;
import helper.RegexConst;
import helper.Valid;
import subFrame.FormApprove;
import component.Processed;
import component.PendingApproval;
import java.awt.event.MouseAdapter;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.AncestorEvent;
import component.AddLeaveRequest;
import component.VacationRequest;
import javax.swing.LayoutStyle.ComponentPlacement;
import component.LeaveTypes;
import component.ProfileEmployee;

public class JFrameMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPaneCard;
	private JPanel panelLogin;
	private JPanel panelMain;
	private JPanel penalSiledbar;
	private JButton btnStatistics;
	private JButton btnApproval;
	private JButton btnVacation;
	private JPanel panelNarbar;
	private JPanel panelSubCard;
	private JPanel panelStatistics;
	private JPanel panelApproval;
	private JPanel panelVacation;
	private JTabbedPane tabbedPane;
	private JPanel panelRequest;
	private JPanel panelVactionRequest;
	private JTabbedPane tabbedPaneApproval;
	private JPanel panelPending;
	private JPanel panelProcessed;
	private JPanel panel;
	private JTextField txtEmail;
	private JPasswordField txtPassword;
	private JLabel lblNewLabel_1;
	private JLabel lblNameEmployeeLogin;
	private JCheckBox chkRememberMe;
	private JCalendar calendar;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JTable tableStatic;
	private Employees emp = null;
	private Processed processed;
	private PendingApproval pendingApproval;
	private Integer pageNumber = 1; // Trang thu may
	private Integer rowOfPage = 10; // So dong mac dinh trong trang
	private Integer totalRow = 0; // so dong trong database
	private Double totalPage = 1.0; // Tong so trang
	private AddLeaveRequest addLeaveRequest;
	private VacationRequest vacationRequest;
	private JButton btnLeavetypes;
	private JPanel panelLeaveTypes;
	private LeaveTypes leaveTypes;
	private JLabel lblNewLabel;
	private JButton btnLogout;
	private JButton btnProfileEmployee;
	private JPanel panelProfileEmployee;
	private ProfileEmployee profileEmployee;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameMain frame = new JFrameMain();
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
	public JFrameMain() {
		setTitle("Leave request");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 720);
		contentPaneCard = new JPanel();
		contentPaneCard.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPaneCard);
		contentPaneCard.setLayout(new CardLayout(0, 0));

		panelLogin = new JPanel();
//		Color panelyellow = Color.decode("#F6FB7A");
		Color panelyellow = Color.decode("#F3CA52");
//		Color panelgreen = Color.decode("#B4E380");
		Color panelgreen = Color.decode("#7ABA78");
		Color panelgrey = Color.decode("#686D76");
		panelLogin.setBackground(panelyellow);
		contentPaneCard.add(panelLogin, "Login");
		panelLogin.setLayout(null);

		panel = new JPanel();
		panel.setBackground(panelgreen);
		panel.setBounds(139, 91, 889, 555);
		panelLogin.add(panel);
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setBounds(240, 113, 78, 35);
		panel.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(341, 109, 324, 39);
		panel.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(240, 214, 78, 25);
		panel.add(lblPassword);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(341, 214, 324, 39);
		panel.add(txtPassword);

		txtPassword.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					checkLogin();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});

		chkRememberMe = new JCheckBox("Remember Me");
		Color panelgreenf = Color.decode("#73BBA3");
		chkRememberMe.setBackground(panelgreenf);
		chkRememberMe.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkRememberMe.setBounds(341, 288, 129, 25);
		panel.add(chkRememberMe);

		JSeparator separator = new JSeparator();
		separator.setBounds(321, 279, 344, 2);
		panel.add(separator);

		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(76, 175, 80));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogin.setBounds(341, 336, 128, 35);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkEventButton(e);
			}
		});
		panel.add(btnLogin);

		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(new Color(76, 175, 80));
		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReset.setBounds(516, 336, 128, 35);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkEventButton(e);
			}
		});
		panel.add(btnReset);
		panel.setLayout(null);
		panel.add(lblEmail);
		panel.add(txtEmail);
		panel.add(lblPassword);
		panel.add(txtPassword);
		panel.add(chkRememberMe);
		panel.add(separator);
		panel.add(btnLogin);
		panel.add(btnReset);

		lblNewLabel_1 = new JLabel("Member Login");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(131, 23, 619, 46);
		panel.add(lblNewLabel_1);

		panelMain = new JPanel();
		contentPaneCard.add(panelMain, "Main");
		panelMain.setLayout(new BorderLayout(0, 0));

		penalSiledbar = new JPanel();
		penalSiledbar.setBackground(panelgrey);
		panelMain.add(penalSiledbar, BorderLayout.WEST);
		Color colorbutton = Color.decode("#88D66C");
		btnStatistics = new JButton("Statistics");
		btnStatistics.setMnemonic('S');
		btnStatistics.setBackground(colorbutton);
		btnStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkEventButton(e);
			}
		});

		btnApproval = new JButton("Approval");
		btnApproval.setMnemonic('A');
		btnApproval.setBackground(panelgreenf);
		btnApproval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkEventButton(e);
			}
		});

		btnVacation = new JButton("Vacation");
		btnVacation.setMnemonic('V');
		btnVacation.setBackground(colorbutton);
		btnVacation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkEventButton(e);
			}
		});

		btnLeavetypes = new JButton("LeaveTypes");
		btnLeavetypes.setMnemonic('L');
		btnLeavetypes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkEventButton(e);
			}
		});
		
        loadSavedLoginDetails();
		btnLeavetypes.setBackground(new Color(136, 214, 108));
		
		btnLogout = new JButton("Logout");
		btnLogout.setMnemonic('L');
		btnLogout.setBackground(new Color(136, 214, 108));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkEventButton(e);
			}
		});
		
		btnProfileEmployee = new JButton("Profile Employee");
		btnProfileEmployee.setMnemonic('P');
		btnProfileEmployee.setBackground(new Color(136, 214, 108));
		
		
		GroupLayout gl_penalSiledbar = new GroupLayout(penalSiledbar);
		gl_penalSiledbar.setHorizontalGroup(
			gl_penalSiledbar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_penalSiledbar.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_penalSiledbar.createParallelGroup(Alignment.LEADING)
						.addComponent(btnProfileEmployee, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnStatistics, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
						.addComponent(btnApproval, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
						.addComponent(btnLeavetypes, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
						.addComponent(btnVacation, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
						.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_penalSiledbar.setVerticalGroup(
			gl_penalSiledbar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_penalSiledbar.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnProfileEmployee, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnStatistics, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnApproval, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnLeavetypes, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnVacation, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(380, Short.MAX_VALUE))
		);
		penalSiledbar.setLayout(gl_penalSiledbar);

		panelNarbar = new JPanel();
		panelMain.add(panelNarbar, BorderLayout.NORTH);

		lblNameEmployeeLogin = new JLabel("");
		lblNameEmployeeLogin.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(255, 255, 0));
		GroupLayout gl_panelNarbar = new GroupLayout(panelNarbar);
		gl_panelNarbar.setHorizontalGroup(
			gl_panelNarbar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNarbar.createSequentialGroup()
					.addGap(292)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNameEmployeeLogin, GroupLayout.PREFERRED_SIZE, 471, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(306, Short.MAX_VALUE))
		);
		gl_panelNarbar.setVerticalGroup(
			gl_panelNarbar.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNameEmployeeLogin, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
				.addComponent(lblNewLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
		);
		panelNarbar.setLayout(gl_panelNarbar);

		panelSubCard = new JPanel();
		panelMain.add(panelSubCard, BorderLayout.CENTER);
		panelSubCard.setLayout(new CardLayout(0, 0));

		panelStatistics = new JPanel();
		panelSubCard.add(panelStatistics, "Statistics");
		panelStatistics.setLayout(null);

		calendar = new JCalendar();
		calendar.setBounds(67, 99, 364, 437);
		panelStatistics.add(calendar);

		panel_1 = new JPanel();
		panel_1.setBounds(441, 99, 612, 437);
		panelStatistics.add(panel_1);
		panel_1.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 74, 561, 340);
		panel_1.add(scrollPane);

		tableStatic = new JTable();
		scrollPane.setViewportView(tableStatic);

		panelApproval = new JPanel();
		panelApproval.setBackground(panelyellow);
		panelSubCard.add(panelApproval, "Approval");
		panelApproval.setLayout(null);

		tabbedPaneApproval = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneApproval.setBounds(32, 11, 1001, 625);
		panelApproval.add(tabbedPaneApproval);

//		pendingApproval = new PendingApproval();
//		pendingApproval.setBounds(10, 11, 976, 577);
//		panelPending.add(pendingApproval);

		panelProcessed = new JPanel();

		tabbedPaneApproval.addTab("Processed", null, panelProcessed, null);
		panelProcessed.setLayout(null);

		panelPending = new JPanel();

		tabbedPaneApproval.addTab("Pending Approval", null, panelPending, null);
		panelPending.setLayout(new CardLayout(0, 0));

//		processed = new Processed();
//		processed.setBounds(10, 11, 983, 581);
//		panelProcessed.add(processed);

		panelVacation = new JPanel();
		panelSubCard.add(panelVacation, "Vacation");
		panelVacation.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		tabbedPane.setBounds(32, 11, 1001, 625);
		panelVacation.add(tabbedPane);

		panelRequest = new JPanel();

		tabbedPane.addTab("New Request", null, panelRequest, null);
		panelRequest.setLayout(null);
		tabbedPane.addChangeListener((ChangeListener) new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				int selectedIndex = tabbedPane.getSelectedIndex();
				if (selectedIndex == 0) {
					loadNewRequestData();
				} else if (selectedIndex == 1) {
					loadVacationRequestsData();
				}
			}
		});

		panelVactionRequest = new JPanel();
		tabbedPane.addTab("Vacation Requests", null, panelVactionRequest, null);
		panelVactionRequest.setLayout(null);

		panelLeaveTypes = new JPanel();
		panelSubCard.add(panelLeaveTypes, "LeaveTypes");
		panelLeaveTypes.setLayout(null);

		leaveTypes = new LeaveTypes();
		leaveTypes.setBounds(10, 11, 1043, 649);
		panelLeaveTypes.add(leaveTypes);
		
		panelProfileEmployee = new JPanel();
		panelSubCard.add(panelProfileEmployee, "name_1682134070000");
		panelProfileEmployee.setLayout(null);
		
		profileEmployee = new ProfileEmployee();
		profileEmployee.setBounds(10, 11, 1042, 649);
		panelProfileEmployee.add(profileEmployee);
//		
//		vacationRequest = new VacationRequest((Employees) null);
//		vacationRequest.setBounds(10, 11, 976, 564);
//		panelVactionRequest.add(vacationRequest);

	}

//	kiểm tra sự kiện của nút button
	protected void checkEventButton(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		switch (actionCommand) {
		case "Statistics" -> {
			var cardLayout = (CardLayout) panelSubCard.getLayout();
			cardLayout.show(panelSubCard, "Statistics");
		}

		case "Approval" -> {
			var cardLayout = (CardLayout) panelSubCard.getLayout();
			cardLayout.show(panelSubCard, "Approval");
		}

		case "Vacation" -> {
			var cardLayout = (CardLayout) panelSubCard.getLayout();
			cardLayout.show(panelSubCard, "Vacation");
			addLeaveRequest = new AddLeaveRequest(emp);
			addLeaveRequest.setBounds(52, 42, 898, 511);
			panelRequest.add(addLeaveRequest);
			vacationRequest = new VacationRequest(emp);
			vacationRequest.setBounds(10, 11, 976, 564);
			panelVactionRequest.add(vacationRequest);
		}
		
		case "LeaveTypes" -> {
			 var cardLayoutLeaveTypes = (CardLayout) panelSubCard.getLayout();
	            cardLayoutLeaveTypes.show(panelSubCard, "LeaveTypes");
		}
		case "Logout" -> {
			var cardLayout = (CardLayout) contentPaneCard.getLayout();
			loadSavedLoginDetails();
			resetLoginForm();
			cardLayout.show(contentPaneCard, "Login");
		}
		

		case "GetMain" -> {
			var cardLayout = (CardLayout) contentPaneCard.getLayout();

		}
		case "Login" -> {
			checkLogin();
		}
		case "Reset" -> {
			Reset();
		}

		}
	}


	private void resetLoginForm() {
		// TODO Auto-generated method stub
		
	}

	public void checkLogin() {
		
	    String email = txtEmail.getText();
	    String password = new String(txtPassword.getPassword());

	    StringBuilder sb = new StringBuilder();
	    


	    if (email.equals("")) {
	        sb.append("Email cannot be blank!\n");
	    }
	    else if (!isValidEmail(email)) {
	        sb.append("Invalid email format! domains are allowed.\n");
	    }
	    if (password.equals("")) {
	        sb.append("Password cannot be blank!");
	    }

	    if (sb.length() > 0) {
	        JOptionPane.showMessageDialog(this, sb.toString(), "Invalidation", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    

	    var dao = new EmployeeDao();
	    emp = dao.checkLogin(email, password);

	    if (emp != null) {
	        // Save login details if "Remember Me" is selected
	        Preferences prefs = Preferences.userNodeForPackage(JFrameMain.class);
	        prefs.put("email", email);
	        if (chkRememberMe.isSelected()) {
	            prefs.put("password", password);
	        } else {
	            prefs.remove("password");
	        }

	        var cardLayout = (CardLayout) contentPaneCard.getLayout();
	        var role = dao.selectRole(emp.getEmployeeID());
	        
	        lblNameEmployeeLogin.setText("Welcome, " + emp.getEmployeeName() + " (" + role.getRoleName() + ")");

	        switch (role.getRoleName()) {
	            case "User" -> {
	                cardLayout.show(contentPaneCard, "Main");
	                btnApproval.setVisible(false);
	            }
	            case "Admin", "Leader" -> {
	                cardLayout.show(contentPaneCard, "Main");
	                addLeaveRequest = new AddLeaveRequest(emp);
	                addLeaveRequest.setBounds(52, 42, 898, 511);
	                panelRequest.add(addLeaveRequest);

	                processed = new Processed(emp);
	                processed.setBounds(10, 11, 983, 581);
	                panelProcessed.add(processed);
	                pendingApproval = new PendingApproval(emp, role);
	                pendingApproval.setBounds(10, 11, 976, 577);
	                panelPending.add(pendingApproval);
	            }
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "The account does not exist, please re-enter");
	        Reset();
	    }
	}
	
	
	private boolean isValidEmail(String email) {
	    // Regex pattern to validate email addresses ending with .com
		String emailRegex = "^[a-zA-Z0-9._%+-]+@(gmail\\.com|outlook\\.com|icloud\\.com|zoho\\.com|yahoo\\.com|aol\\.com|gmx\\.com|example\\.com)$";
	    return email.matches(emailRegex);
	}
	

	private void loadSavedLoginDetails() {
        Preferences prefs = Preferences.userNodeForPackage(JFrameMain.class);
        String savedEmail = prefs.get("email", "");
        String savedPassword = prefs.get("password", "");

        txtEmail.setText(savedEmail);
        txtPassword.setText(savedPassword);

        if (!savedEmail.isEmpty() && !savedPassword.isEmpty()) {
            chkRememberMe.setSelected(true);
        }
    }

    public void Reset() {
        txtEmail.setText("");
        txtPassword.setText("");
        chkRememberMe.setSelected(false);

        Preferences prefs = Preferences.userNodeForPackage(JFrameMain.class);
        prefs.remove("email");
        prefs.remove("password");
    }

	private void loadNewRequestData() {
		panelRequest.removeAll();
		addLeaveRequest = new AddLeaveRequest(emp);
		addLeaveRequest.setBounds(52, 42, 898, 511);
		panelRequest.add(addLeaveRequest);
		panelRequest.revalidate();
		panelRequest.repaint();
	}

	private void loadVacationRequestsData() {
		panelRequest.removeAll();
		addLeaveRequest = new AddLeaveRequest(emp);
		addLeaveRequest.setBounds(52, 42, 898, 511);
		panelRequest.add(addLeaveRequest);
		panelRequest.revalidate();
		panelRequest.repaint();
	}
}
