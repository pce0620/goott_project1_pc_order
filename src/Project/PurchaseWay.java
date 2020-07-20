package Project;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PurchaseWay {
	
	JPanel jp1, jp2, jp3;
	JTextArea jta;
	JRadioButton jrb1, jrb2;
	JLabel jlb;
	String[] str = {"-----------------------------------------------------------------","카드", "현금", "계좌이체"};

	
	
	public PurchaseWay() {

		
		jp1 = new JPanel();		
		jp2 = new JPanel();
		jp3 = new JPanel();

		jlb = new JLabel("        결제 방법을 선택해주세요.        ");
		jlb.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		jlb.setForeground(Color.BLACK);
		jlb.setHorizontalAlignment(SwingConstants.CENTER);
		jlb.setBounds(0, 20, 400, 400);
		
		//라디오버튼
		jrb1 = new JRadioButton("선불");
		jrb1.setFont(new Font("맑은 고딕", 0, 13));
		jrb1.setBounds(30, 45, 100, 50);
		jrb1.setBackground(Color.LIGHT_GRAY);
		jrb1.setForeground(Color.BLACK);
		jrb1.setOpaque(false);
		
		jrb2 = new JRadioButton("충전 시간 차감");
		jrb2.setFont(new Font("맑은 고딕", 0, 15));
		jrb2.setBounds(130, 45, 150, 50);
		jrb2.setBackground(Color.LIGHT_GRAY);
		jrb2.setForeground(Color.BLACK);
		jrb2.setOpaque(false);
		
		ButtonGroup group = new ButtonGroup();
		
		group.add(jrb1); group.add(jrb2);
		
		jp1.add(jlb); jp1.add(jrb1); jp1.add(jrb2);
		
		
		//콤보박스
		JComboBox<String> combox = new JComboBox<String>(str);
		jp2.add(combox);
		
		
		
		//주문요청사항 텍스트필드
		jta = new JTextArea("주문시 요청사항을 입력해주세요.", 7, 22);
		jta.setFont(new Font("맑은 고딕", 0, 15));
		//jta.setText("");
		jta.addMouseListener(new MouseListener() {
		
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				jta.setText("");
			}
			public void mouseClicked(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		});
		
		jp3.add(jta);
		

		
	}

}
