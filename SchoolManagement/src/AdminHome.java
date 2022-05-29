import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Button;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.Choice;
import javax.swing.ButtonGroup;

public class AdminHome extends JFrame {
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private final ButtonGroup genderButtonGroup = new ButtonGroup();
	private JTextField phoneNumTextField;
	private JTextField emailTextField;
	private JTextField streetAddressTextField;
	private JTextField cityTextField;

	/**
	 * Create the frame.
	 */
	public AdminHome(String firstName, String lastName) {
		getContentPane().setBackground(new Color(204, 204, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 775);		
		getContentPane().setLayout(null);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(new Color(153, 204, 255));
		menuPanel.setBorder(null);
		menuPanel.setBounds(0, 0, 194, 747);
		getContentPane().add(menuPanel);
		menuPanel.setLayout(null);
		
		//Icons
		ImageIcon uni = new ImageIcon("/Users/ajenaepompey/Pictures/university.png");
		Image img00 = uni.getImage();
		Image newimg00 = img00.getScaledInstance(55, 55, Image.SCALE_SMOOTH);
		uni = new ImageIcon(newimg00);
		
		ImageIcon lookupIcon = new ImageIcon("/Users/ajenaepompey/Pictures/lookup.png");
		Image img1 = lookupIcon.getImage();
		Image newimg1 = img1.getScaledInstance(55, 55, Image.SCALE_SMOOTH);
		lookupIcon = new ImageIcon(newimg1);
		
		ImageIcon profIcon = new ImageIcon("/Users/ajenaepompey/Pictures/professor.png");
		Image img2 = profIcon.getImage();
		Image newimg2 = img2.getScaledInstance(55, 55, Image.SCALE_SMOOTH);
		profIcon = new ImageIcon(newimg2);
		
		ImageIcon stuIcon = new ImageIcon("/Users/ajenaepompey/Pictures/graduates.png");
		Image img0 = stuIcon.getImage();
		Image newimg0 = img0.getScaledInstance(55, 55, Image.SCALE_SMOOTH);
		stuIcon = new ImageIcon(newimg0);
	
		//Labels
		JLabel welcomeLabel = new JLabel("Welcome " + firstName + " " + lastName);
		welcomeLabel.setOpaque(true);
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setBackground(new Color(204, 204, 255));
		welcomeLabel.setFont(new Font("Academy Engraved LET", Font.PLAIN, 27));
		welcomeLabel.setBounds(206, 6, 894, 54);
		getContentPane().add(welcomeLabel);
		
		JLabel stuLabel = new JLabel("");
		stuLabel.setBounds(74, 116, 60, 57);
		menuPanel.add(stuLabel);
		stuLabel.setIcon(stuIcon);
		
		JLabel lookupLabel = new JLabel("");
		lookupLabel.setBounds(74, 271, 60, 57);
		menuPanel.add(lookupLabel);
		lookupLabel.setIcon(lookupIcon);
		
		JLabel profLabel = new JLabel("");
		profLabel.setBounds(74, 469, 60, 57);
		menuPanel.add(profLabel);
		profLabel.setIcon(profIcon);
		
		JLabel univ = new JLabel("");
		univ.setBounds(0, 6, 60, 63);
		menuPanel.add(univ);
		univ.setIcon(uni);
		
		JLabel uniLabel = new JLabel("<html>AP<br>University</html>");
		uniLabel.setBounds(51, 13, 132, 63);
		menuPanel.add(uniLabel);
		uniLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		uniLabel.setHorizontalAlignment(SwingConstants.CENTER);
		uniLabel.setFont(new Font("Academy Engraved LET", Font.BOLD, 26));
		
		//TabbedPane
		JTabbedPane displayAreaTabbed = new JTabbedPane(JTabbedPane.TOP);
		displayAreaTabbed.setVisible(false);
		displayAreaTabbed.setOpaque(true);
		displayAreaTabbed.setBackground(new Color(153, 204, 255));
		displayAreaTabbed.setBounds(216, 36, 884, 730);
		getContentPane().add(displayAreaTabbed);
			
			//Tabs
		JPanel enrollStudentsPane = new JPanel();
		enrollStudentsPane.setToolTipText("ex: johndoe@example.com");
		enrollStudentsPane.setOpaque(false);
		displayAreaTabbed.addTab("New tab", null, enrollStudentsPane, null);
		enrollStudentsPane.setLayout(null);
		
		JLabel firstNameLabel = new JLabel("First Name: ");
		firstNameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		firstNameLabel.setBounds(64, 154, 130, 24);
		enrollStudentsPane.add(firstNameLabel);
		
		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(237, 149, 169, 34);
		enrollStudentsPane.add(firstNameTextField);
		firstNameTextField.setColumns(10);
		
		JLabel lastNameLabel = new JLabel("Last Name:");
		lastNameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lastNameLabel.setBounds(64, 205, 130, 24);
		enrollStudentsPane.add(lastNameLabel);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(237, 203, 169, 34);
		enrollStudentsPane.add(lastNameTextField);
		lastNameTextField.setColumns(10);
		
		JLabel dateOfBirthLabel = new JLabel("Date of Birth:");
		dateOfBirthLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		dateOfBirthLabel.setBounds(435, 152, 133, 24);
		enrollStudentsPane.add(dateOfBirthLabel);
		
		JLabel genderLabel = new JLabel("Gender:");
		genderLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		genderLabel.setBounds(447, 205, 109, 24);
		enrollStudentsPane.add(genderLabel);
		
		JRadioButton femaleRadioBttn = new JRadioButton("Female");
		femaleRadioBttn.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		genderButtonGroup.add(femaleRadioBttn);
		femaleRadioBttn.setBounds(574, 206, 97, 23);
		enrollStudentsPane.add(femaleRadioBttn);
		
		JRadioButton maleRadioBttn = new JRadioButton("Male");
		maleRadioBttn.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		genderButtonGroup.add(maleRadioBttn);
		maleRadioBttn.setBounds(666, 206, 83, 23);
		enrollStudentsPane.add(maleRadioBttn);
		
		phoneNumTextField = new JTextField();
		phoneNumTextField.setBounds(237, 274, 169, 34);
		enrollStudentsPane.add(phoneNumTextField);
		phoneNumTextField.setColumns(10);
		
		JLabel phoneNumLabel = new JLabel("Phone Number:");
		phoneNumLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		phoneNumLabel.setBounds(45, 272, 169, 24);
		enrollStudentsPane.add(phoneNumLabel);
		
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		emailLabel.setBounds(466, 282, 71, 24);
		enrollStudentsPane.add(emailLabel);
		
		emailTextField = new JTextField();
		emailTextField.setName("");
		emailTextField.setBounds(580, 277, 189, 34);
		enrollStudentsPane.add(emailTextField);
		emailTextField.setColumns(50);
		
		JLabel streetAddressLabel = new JLabel("Street Address:");
		streetAddressLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		streetAddressLabel.setBounds(47, 348, 164, 24);
		enrollStudentsPane.add(streetAddressLabel);
		
		streetAddressTextField = new JTextField();
		streetAddressTextField.setBounds(237, 348, 169, 34);
		enrollStudentsPane.add(streetAddressTextField);
		streetAddressTextField.setColumns(10);
		
		JLabel cityLabel = new JLabel("City:");
		cityLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		cityLabel.setBounds(476, 353, 51, 24);
		enrollStudentsPane.add(cityLabel);
		
		cityTextField = new JTextField();
		cityTextField.setBounds(580, 348, 169, 34);
		enrollStudentsPane.add(cityTextField);
		cityTextField.setColumns(10);
		
		JLabel stateLabel = new JLabel("State: ");
		stateLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		stateLabel.setBounds(94, 419, 71, 24);
		enrollStudentsPane.add(stateLabel);
		
		JLabel lblNewLabel_8 = new JLabel("Enroll a Student");
		lblNewLabel_8.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel_8.setBounds(341, 16, 199, 45);
		enrollStudentsPane.add(lblNewLabel_8);
		
		JComboBox monthComboBox = new JComboBox();
		monthComboBox.setBounds(585, 154, 86, 27);
		enrollStudentsPane.add(monthComboBox);
		
		JComboBox dayComboBox = new JComboBox();
		dayComboBox.setBorder(null);
		dayComboBox.setBounds(683, 154, 64, 27);
		enrollStudentsPane.add(dayComboBox);
		
		JComboBox yearComboBox = new JComboBox();
		yearComboBox.setBounds(760, 154, 71, 27);
		enrollStudentsPane.add(yearComboBox);
		
		JLabel lblNewLabel_9 = new JLabel("Month");
		lblNewLabel_9.setForeground(Color.GRAY);
		lblNewLabel_9.setBounds(595, 178, 40, 16);
		enrollStudentsPane.add(lblNewLabel_9);
		
		JLabel dayLabel = new JLabel("Day");
		dayLabel.setForeground(Color.GRAY);
		dayLabel.setBounds(693, 178, 32, 16);
		enrollStudentsPane.add(dayLabel);
		
		JLabel yearLabel = new JLabel("Year");
		yearLabel.setForeground(Color.GRAY);
		yearLabel.setBounds(770, 178, 32, 16);
		enrollStudentsPane.add(yearLabel);
		
		JComboBox stateCombobox = new JComboBox();
		stateCombobox.setBounds(237, 422, 71, 27);
		enrollStudentsPane.add(stateCombobox);
		
		JButton submitBttn = new JButton("Submit");
		submitBttn.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		submitBttn.setBounds(395, 525, 117, 29);
		enrollStudentsPane.add(submitBttn);
		
		JPanel disenrollStudentsPane = new JPanel();
		disenrollStudentsPane.setVisible(false);
		disenrollStudentsPane.setOpaque(false);
		displayAreaTabbed.addTab("New tab", null, disenrollStudentsPane, null);
		
		JPanel lookUpStudentsPane = new JPanel();
		lookUpStudentsPane.setVisible(false);
		lookUpStudentsPane.setOpaque(false);
		displayAreaTabbed.addTab("New tab", null, lookUpStudentsPane, null);
		
		JPanel lookUpProfessorPane = new JPanel();
		lookUpProfessorPane.setVisible(false);
		lookUpProfessorPane.setOpaque(false);
		displayAreaTabbed.addTab("New tab", null, lookUpProfessorPane, null);
		
		JPanel lookUpClassPane = new JPanel();
		lookUpClassPane.setVisible(false);
		lookUpClassPane.setOpaque(false);
		displayAreaTabbed.addTab("New tab", null, lookUpClassPane, null);
		
		JPanel addTeacherPane = new JPanel();
		addTeacherPane.setVisible(false);
		addTeacherPane.setOpaque(false);
		displayAreaTabbed.addTab("New tab", null, addTeacherPane, null);
		
		JPanel removeTeacherPane = new JPanel();
		removeTeacherPane.setVisible(false);
		removeTeacherPane.setOpaque(false);
		displayAreaTabbed.addTab("New tab", null, removeTeacherPane, null);
		
		JPanel accountSettingsPane = new JPanel();
		accountSettingsPane.setVisible(false);
		accountSettingsPane.setOpaque(false);
		displayAreaTabbed.addTab("New tab", null, accountSettingsPane, null);
		
		//Menu Buttons
			//enroll a student
			JButton enrollBttn = new JButton("Enroll Student");
			enrollBttn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					displayAreaTabbed.setVisible(true);
					displayAreaTabbed.setSelectedIndex(0);
				}
			});
			enrollBttn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, new Color(153, 153, 255), new Color(153, 153, 255)));
			enrollBttn.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			enrollBttn.setOpaque(true);
			enrollBttn.setBounds(0, 177, 183, 39);
			menuPanel.add(enrollBttn);
			enrollBttn.setBackground(new Color(204, 204, 255));
			
			//disenroll a student
			JButton disenrollBttn = new JButton("Disenroll Student");
			disenrollBttn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					displayAreaTabbed.setSelectedIndex(1);
				}
			});
			disenrollBttn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, new Color(153, 153, 255), new Color(153, 153, 255)));
			disenrollBttn.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			disenrollBttn.setOpaque(true);
			disenrollBttn.setBackground(new Color(204, 204, 255));
			disenrollBttn.setBounds(0, 220, 183, 39);
			menuPanel.add(disenrollBttn);
		
		
		
		JButton lookupSBttn = new JButton("Look Up Student");
		lookupSBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayAreaTabbed.setSelectedIndex(2);
			}
		});
		lookupSBttn.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lookupSBttn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, new Color(153, 153, 255), new Color(153, 153, 255)));
		lookupSBttn.setOpaque(true);
		lookupSBttn.setBackground(new Color(204, 204, 255));
		lookupSBttn.setBounds(0, 334, 183, 39);
		menuPanel.add(lookupSBttn);
		
		JButton lookupPBttn = new JButton("Look Up Professor");
		lookupPBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayAreaTabbed.setSelectedIndex(3);
			}
		});
		lookupPBttn.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lookupPBttn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, new Color(153, 153, 255), new Color(153, 153, 255)));
		lookupPBttn.setOpaque(true);
		lookupPBttn.setBackground(new Color(204, 204, 255));
		lookupPBttn.setBounds(0, 376, 183, 39);
		menuPanel.add(lookupPBttn);
		
		JButton lookupCBttn = new JButton("Look Up Class");
		lookupCBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayAreaTabbed.setSelectedIndex(4);
			}
		});
		lookupCBttn.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lookupCBttn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, new Color(153, 153, 255), new Color(153, 153, 255)));
		lookupCBttn.setOpaque(true);
		lookupCBttn.setBackground(new Color(204, 204, 255));
		lookupCBttn.setBounds(0, 418, 183, 39);
		menuPanel.add(lookupCBttn);
		
		JButton addTBttn = new JButton("Add Teacher");
		addTBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayAreaTabbed.setSelectedIndex(5);
			}
		});
		addTBttn.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		addTBttn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, new Color(153, 153, 255), new Color(153, 153, 255)));
		addTBttn.setOpaque(true);
		addTBttn.setBackground(new Color(204, 204, 255));
		addTBttn.setBounds(0, 530, 183, 39);
		menuPanel.add(addTBttn);
		
		JButton removeTBttn = new JButton("Remove Teacher");
		removeTBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayAreaTabbed.setSelectedIndex(6);
			}
		});
		removeTBttn.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		removeTBttn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, new Color(153, 153, 255), new Color(153, 153, 255)));
		removeTBttn.setOpaque(true);
		removeTBttn.setBackground(new Color(204, 204, 255));
		removeTBttn.setBounds(0, 572, 183, 39);
		menuPanel.add(removeTBttn);
		
		JButton acctBttn = new JButton("Account Settings");
		acctBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayAreaTabbed.setSelectedIndex(7);
			}
		});
		acctBttn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, new Color(153, 153, 255), new Color(153, 153, 255)));
		acctBttn.setBackground(new Color(204, 204, 255));
		acctBttn.setOpaque(true);
		acctBttn.setBounds(0, 635, 183, 39);
		menuPanel.add(acctBttn);
		acctBttn.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
		
		JButton logoutBttn = new JButton("Logout");
		logoutBttn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, new Color(153, 153, 255), new Color(153, 153, 255)));
		logoutBttn.setOpaque(true);
		logoutBttn.setBackground(new Color(204, 204, 255));
		logoutBttn.setBounds(0, 677, 183, 39);
		menuPanel.add(logoutBttn);
		logoutBttn.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
		logoutBttn.setForeground(new Color(0, 0, 0));
		
		
		
		
		
	}
}
