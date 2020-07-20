package Project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class LoginMain extends JFrame implements ActionListener{

	JPanel imgPanel, loginPanel;
	ImageIcon img;
	JLabel num, id, pw, imgLabel, jlb;
	JButton login, join;
	JTextField idText, pwText;
	
	MainOrder mainOrder;
	JoinMain joinMain;
	
	public LoginMain() {
		setBounds(0, 0, 1366, 768);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);

		imgLabel = new JLabel("");
		imgLabel.setIcon(new ImageIcon("src\\projectimages\\login.jpg"));
		imgLabel.setBounds(0, 0, 1360, 768);
		add(imgLabel);
		
		jlb = new JLabel("020번");
		jlb.setBounds(700, 10, 500, 100);
		jlb.setFont(new Font("맑은 고딕", Font.BOLD, 80));
		jlb.setForeground(new Color(255, 228, 0));
		imgLabel.add(jlb);

		id = new JLabel("아이디");
		id.setBounds(700, 130, 100, 30);
		id.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		imgLabel.add(id);
		
		pw = new JLabel("비밀번호");
		pw.setBounds(700, 190, 100, 30);
		pw.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		imgLabel.add(pw);
		
		
		idText = new JTextField(30);
		idText.setBounds(830, 130, 200, 30);
		imgLabel.add(idText);
		
		pwText = new JTextField(30);
		pwText.setBounds(830, 190, 200, 30);
		imgLabel.add(pwText);
		
		login = new JButton(new ImageIcon("src/projectimages/loginimg.png"));
		login.setBounds(1050, 120, 100, 110);
		login.setOpaque(false);
		imgLabel.add(login);
		
		join = new JButton(new ImageIcon("src/projectimages/joinimg.jpg"));
		join.setBounds(1160, 120, 100, 110);
		imgLabel.add(join);
		
		login.addActionListener(this);
		join.addActionListener(this);
		

		add(imgLabel);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new LoginMain();
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		
		if(obj==login) {
			String idP = idText.getText();
			String pwP = pwText.getText();
			
			Connection conn = MakeConnection.getConnection();
			
			StringBuffer sb = new StringBuffer();
			sb.append("select * from login ");
			sb.append("where id = ? and pw = ? ");
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				pstmt = conn.prepareStatement(sb.toString());
				pstmt.setString(1, idP);
				pstmt.setString(2, pwP);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					mainOrder = new MainOrder();
				}else {
					JOptionPane.showConfirmDialog(null, "입력과 일치하는 정보가 없습니다", "확인", JOptionPane.CLOSED_OPTION);
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
			
		}else if(obj==join) {
			
			joinMain = new JoinMain();
			
		}
		
		
	}//버튼 이벤트 end
	
}
