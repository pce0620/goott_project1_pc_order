package Project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class JoinMain extends JFrame implements ActionListener{

	JButton ok, cancel;
	JLabel id, pw, name, birth;
	JTextField idText, pwText, nmText, btText;
	
	public JoinMain() {
		
		setBounds(700, 300, 300, 400);
		setLayout(null);
	
		id = new JLabel("아  이  디");
		id.setBounds(30, 60, 60, 30);
		id.setHorizontalAlignment(0);
		id.setOpaque(true);
		id.setBackground(Color.YELLOW);
		add(id);
		
		pw = new JLabel("비밀번호");
		pw.setBounds(30, 110, 60, 30);
		pw.setBackground(new Color(0, 0, 75));
		pw.setHorizontalAlignment(0);
		pw.setOpaque(true);
		pw.setBackground(Color.YELLOW);
		add(pw);
		
		name = new JLabel("이　　름");
		name.setBounds(30, 160, 60, 30);
		name.setHorizontalAlignment(0);
		name.setOpaque(true);
		name.setBackground(Color.YELLOW);
		add(name);
		
		birth = new JLabel("생년월일");
		birth.setBounds(30, 210, 60, 30);
		birth.setHorizontalAlignment(0);
		birth.setOpaque(true);
		birth.setBackground(Color.YELLOW);
		
		add(birth);
		
		
		idText = new JTextField();
		idText.setBounds(100, 60, 150, 30);
		add(idText);
		
		pwText = new JTextField();
		pwText.setBounds(100, 110, 150, 30);
		add(pwText);
		
		nmText = new JTextField();
		nmText.setBounds(100, 160, 150, 30);
		add(nmText);
		
		btText = new JTextField("ex)960620");
		btText.setBounds(100, 210, 150, 30);
		btText.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				btText.setText("");
			}
			
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {}
		});

		add(btText);
		
		ok = new JButton("가입");
		ok.setBounds(50, 260, 70, 40);
		add(ok);
		
		cancel = new JButton("취소");
		cancel.setBounds(160, 260, 70, 40);
		add(cancel);
		
		ok.addActionListener(this);
		cancel.addActionListener(this);
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JoinMain();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj==ok) {
			Connection conn = MakeConnection.getConnection();
			
			StringBuffer sb = new StringBuffer();
			sb.append("insert into login ");
			sb.append("values (?, ?, ?, ?) ");
			
			String idP = idText.getText();
			String pwP = pwText.getText();
			String nmP = nmText.getText();
			String btP = btText.getText();
			
			PreparedStatement pstmt = null;
			
			try {
				pstmt = conn.prepareStatement(sb.toString());
				pstmt.setString(1, idP);
				pstmt.setString(2, pwP);
				pstmt.setString(3, nmP);
				pstmt.setString(4, btP);
				
				pstmt.executeUpdate();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			finally {
				try {
					if(pstmt!=null) pstmt.close();
					if(conn!=null) conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			JOptionPane.showConfirmDialog(null, nmP+"님 회원가입을 축하드립니다!","확인",JOptionPane.CLOSED_OPTION);
			idText.setText("");
			pwText.setText("");
			nmText.setText("");
			btText.setText("ex)960620");
			
		}else if(obj==cancel) {
			dispose();
		}
		
		
	}//버튼 이벤트 end
	
	
}
