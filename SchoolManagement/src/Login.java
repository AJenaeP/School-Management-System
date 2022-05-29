
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.net.ssl.SNIHostName;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


import java.awt.*;


public class Login extends JFrame{

	private JPanel contentPane;
	private JTextField usercodeField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	
	/**
	 * Create the frame.
	 */
	public Login() {
		super("Login");
		conn = databaseConnection.connection();
		
		
		setFont(new Font("Dialog", Font.PLAIN, 15));
		setTitle("School Managment System\n");
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 618, 492);
		contentPane = new JPanel();
		contentPane.setLocation(5, 0);
		contentPane.setBackground(new Color(153, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel Loginpanel = new JPanel();
		Loginpanel.setBackground(new Color(204, 204, 255));
		contentPane.add(Loginpanel, BorderLayout.CENTER);
		Loginpanel.setLayout(null);
		
		JLabel lblusercode = new JLabel("User Code");
		lblusercode.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblusercode.setHorizontalAlignment(SwingConstants.CENTER);
		lblusercode.setBounds(155, 207, 100, 16);
		Loginpanel.add(lblusercode);
		
		JLabel lblpassword = new JLabel("Password");
		lblpassword.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblpassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblpassword.setBounds(155, 260, 100, 16);
		Loginpanel.add(lblpassword);
		
		usercodeField = new JTextField();
		usercodeField.setBorder(new LineBorder(new Color(0, 0, 0)));
		usercodeField.setToolTipText("User Code..");
		usercodeField.setBounds(328, 200, 138, 31);
		Loginpanel.add(usercodeField);
		usercodeField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new LineBorder(new Color(0, 0, 0)));
		passwordField.setDisabledTextColor(Color.LIGHT_GRAY);
		passwordField.setToolTipText("");
		passwordField.setBounds(328, 253, 138, 31);
		Loginpanel.add(passwordField);
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(153, 0, 255));
		btnLogin.setBounds(225, 382, 157, 51);
		Loginpanel.add(btnLogin);
		
		ImageIcon schoolIcon = new ImageIcon("/Users/ajenaepompey/Pictures/university.png");
		Image img = schoolIcon.getImage();
		Image newimg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		schoolIcon = new ImageIcon(newimg);
		JLabel schoolLabel = new JLabel("");
		schoolLabel.setIcon(schoolIcon);
		schoolLabel.setBounds(172, 16, 100, 100);
		Loginpanel.add(schoolLabel);
		
		
		JRadioButton StudentRadioBttn = new JRadioButton("Student");
		StudentRadioBttn.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		StudentRadioBttn.setBounds(130, 316, 100, 41);
		Loginpanel.add(StudentRadioBttn);
		
		JRadioButton TeacherRadioBttn = new JRadioButton("Teacher");
		TeacherRadioBttn.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		TeacherRadioBttn.setBounds(253, 316, 100, 41);
		Loginpanel.add(TeacherRadioBttn);
		
		JRadioButton AdminRadioBttn = new JRadioButton("Admin");
		AdminRadioBttn.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		AdminRadioBttn.setBounds(372, 316, 106, 41);
		Loginpanel.add(AdminRadioBttn);
		
		ButtonGroup group = new ButtonGroup();
		group.add(StudentRadioBttn);
		group.add(TeacherRadioBttn);
		group.add(AdminRadioBttn);
		
		JLabel uniLabel = new JLabel("<html>AP<br>University</html>");
		uniLabel.setVerticalAlignment(SwingConstants.TOP);
		uniLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		uniLabel.setHorizontalAlignment(SwingConstants.CENTER);
		uniLabel.setFont(new Font("Academy Engraved LET", Font.PLAIN, 37));
		uniLabel.setBounds(278, 30, 189, 86);
		Loginpanel.add(uniLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Sign in with your organizational account");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNewLabel_2.setBounds(155, 141, 337, 29);
		Loginpanel.add(lblNewLabel_2);
		
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userCode = usercodeField.getText();
				String userPass = passwordField.getText();	
				String firstName;
				String lastName;
				if(AdminRadioBttn.isSelected()) {
				try {
					stmt = conn.createStatement();
;					String sql = "SELECT firstName, lastName FROM Login WHERE userCode='"+userCode+ "' && password ='" +userPass+"'";
					rs = stmt.executeQuery(sql);
								
					if(rs.next()) {
						setVisible(false);
						firstName = rs.getString("firstName");
						lastName = rs.getString("lastName");
						AdminHome object = new AdminHome(firstName, lastName);
						object.setVisible(true);
					
						
					} else {
						JOptionPane.showMessageDialog(null, "Usercode or Password is invalid");
					}
					
				} catch(Exception e1) {
					JOptionPane.showMessageDialog(null,e1);
				}
			}
			}
		});
		
	}

	
	
}
