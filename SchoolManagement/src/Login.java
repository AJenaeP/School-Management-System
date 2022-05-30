
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
	Statement stmt1 = null;
	Statement stmt2 = null;
	ResultSet rs = null;
	ResultSet rs2 = null;
	
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
		StudentRadioBttn.setBounds(130, 306, 100, 41);
		Loginpanel.add(StudentRadioBttn);
		
		JRadioButton TeacherRadioBttn = new JRadioButton("Teacher");
		TeacherRadioBttn.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		TeacherRadioBttn.setBounds(253, 306, 100, 41);
		Loginpanel.add(TeacherRadioBttn);
		
		JRadioButton AdminRadioBttn = new JRadioButton("Admin");
		AdminRadioBttn.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		AdminRadioBttn.setBounds(372, 306, 106, 41);
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
		
		JLabel warningLabel = new JLabel("");
		warningLabel.setVisible(false);
		warningLabel.setForeground(Color.RED);
		warningLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		warningLabel.setHorizontalAlignment(SwingConstants.CENTER);
		warningLabel.setBounds(118, 349, 377, 31);
		Loginpanel.add(warningLabel);
		
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userCode = usercodeField.getText();
				String userPass = passwordField.getText();	
				String firstName;
				String lastName;
				try {
					stmt = conn.createStatement();
					stmt1 = conn.createStatement();
					stmt2 = conn.createStatement();
					String sql = "SELECT firstName, lastName FROM Login WHERE userCode='"+ userCode + "' && password ='" + userPass +"'"; //checks if login is right
					rs = stmt.executeQuery(sql);
					
					Boolean login = stmt1.execute(sql);
					String sql2 = "SELECT EXISTS(SELECT * FROM admin WHERE userCode = '" + userCode + "')"; //checks if correct radio button is selected
					boolean admin = stmt2.execute(sql2);
					/*//if(!login) {
						do {
							warningLabel.setText("Wrong usercode or password");
							warningLabel.setVisible(true);
						}while(!login);
					//}
					
					while(login && rs.next()){
						setVisible(false);
						firstName = rs.getString("firstName");
						lastName = rs.getString("lastName");
						if(AdminRadioBttn.isSelected() && admin){
							AdminHome object = new AdminHome(firstName, lastName);
							object.setVisible(true);
						} else if (AdminRadioBttn.isSelected() && (!admin)){
							warningLabel.setText("You are not an Admin!");
							warningLabel.setVisible(true);
						} else if ((!AdminRadioBttn.isSelected()) && admin) {
							warningLabel.setText("Incorrect radio button selected");
							warningLabel.setVisible(true);
						}
						
						if(StudentRadioBttn.isSelected() ) {
							
						} else {
							warningLabel.setText("You are not a Student");
							warningLabel.setVisible(true);
						}
						
						if(TeacherRadioBttn.isSelected() ) {
							
						} else {
							warningLabel.setText("You are not a Teacher");
							warningLabel.setVisible(true);
						}
					} */
					
					if((rs.next())){
						setVisible(false);
						firstName = rs.getString("firstName");
						lastName = rs.getString("lastName");
						if(admin && AdminRadioBttn.isSelected()) {
							AdminHome object = new AdminHome(firstName, lastName);
							object.setVisible(true);	
						} else {
							warningLabel.setText("Wrong view selected");
							warningLabel.setVisible(true);
						}
					} else {
						warningLabel.setText("Usercode or Password is invalid");
						warningLabel.setVisible(true);
					}
					
				} catch(Exception e1) {
					JOptionPane.showMessageDialog(null,e1);
				}
			
			}
		});
		
	}
}
