package Project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class RamenMenu {
	JPanel jPanel;
	JScrollPane jScrollPane = null;
	int count[] = new int[12];

	JPanel ordertotal, order;
	JTextArea jTextArea;
	static JLabel totPrice;
	JButton jbtn;

	public RamenMenu(ProdOrdTable prodOrdTable) {
		
		jPanel = new JPanel();
		jPanel.setBounds(0, 0, 1050, 650);

		String[] menu = { "너구리", "불닭볶음면", "삼양라면", "신라면", "열라면", "오징어짬뽕", "진라면", "진짬뽕", "짜파게티", "참깨라면", "치즈불닭볶음면",
				"팔도비빔면" };
		JLabel[] menuNm = new JLabel[menu.length];
		JLabel[] menuImg = new JLabel[menu.length];
		JLabel[] menuPrice = new JLabel[menu.length];
		ImageIcon[] img = { new ImageIcon("src/projectimages2/너구리.jpg"), new ImageIcon("src/projectimages2/불닭볶음면.jpg"),
				new ImageIcon("src/projectimages2/삼양라면.jpg"), new ImageIcon("src/projectimages2/신라면.jpg"),
				new ImageIcon("src/projectimages2/열라면.jpg"), new ImageIcon("src/projectimages2/오징어짬뽕.jpg"),
				new ImageIcon("src/projectimages2/진라면.jpg"), new ImageIcon("src/projectimages2/진짬뽕.jpg"),
				new ImageIcon("src/projectimages2/짜파게티.jpg"), new ImageIcon("src/projectimages2/참깨라면.jpg"),
				new ImageIcon("src/projectimages2/치즈불닭볶음면.jpg"), new ImageIcon("src/projectimages2/팔도비빔면.jpg"), };
		int[] arrayMenuPrice = { 2500, 2500, 2000, 2500, 2000, 2500, 2500, 2500, 2500, 2500, 2000, 2000 };
		JButton[] minus = new JButton[menu.length];
		JTextField[] menuCnt = new JTextField[menu.length];
		JButton[] plus = new JButton[menu.length];


		/*
		 * 주문가격,버튼
		 */

		ordertotal = new JPanel();
		ordertotal.setBackground(new Color(0, 0, 75));
		order = new JPanel();
		totPrice = new JLabel("0원");

		totPrice.setFont(new Font("맑은 고딕", Font.BOLD, 70));
		totPrice.setHorizontalAlignment(SwingConstants.CENTER);
		totPrice.setSize(400, 180);
		totPrice.setForeground(Color.WHITE);

		// 주문확인
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy년 MM월 dd일");
		SimpleDateFormat time = new SimpleDateFormat("hh시 mm분");

		jbtn = new JButton("주문하기");
		jbtn.setHorizontalAlignment(SwingConstants.CENTER);
		jbtn.setSize(385, 130);
		jbtn.setFont(new Font("맑은 고딕", Font.BOLD, 60));
		jbtn.setBackground(new Color(201, 0, 0));
		jbtn.setForeground(Color.WHITE);
		jbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "주문하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
				if (result == 0) {
					int result2 = JOptionPane.showConfirmDialog(null,
							date.format(today) + "\n" + time.format(today) + "\n" + "주문하신 정보가 접수 되었습니다.", "확인",
							JOptionPane.CLOSED_OPTION);
					for (int i = 0; i < prodOrdTable.model.getRowCount(); i++) {
						int row = prodOrdTable.model.getRowCount();
						prodOrdTable.model.setNumRows(0);
					}
					totPrice.setText("0원");
					for (int j = 0; j < menu.length; j++) {
						menuCnt[j].setText("0");
					}
				} else if (result == 2) {
					System.exit(0);
				}
			}
		});

		ordertotal.add(totPrice);
		order.add(jbtn);
		/*
		 * 여기까지주문
		 */

		
		// 메뉴 이름
		Dimension size = new Dimension();
		jPanel.setBackground(Color.LIGHT_GRAY);
		jPanel.setLayout(null);
		jPanel.setPreferredSize(size);
		size.setSize(1000, 1000);

		//위치 set
		for (int i = 0; i < menu.length; i++) {
			menuNm[i] = new JLabel(menu[i]);
			menuNm[i].setFont(new Font("맑은 고딕", Font.BOLD, 20));
			menuNm[i].setOpaque(true);
			menuNm[i].setBackground(Color.BLACK);
			menuNm[i].setForeground(Color.white);
			menuNm[i].setHorizontalAlignment(0);
			if (i < 4) {
				menuNm[i].setBounds(30 + i * 250, 20, 200, 30);
			} else if (i < 8) {
				menuNm[i].setBounds(30 + (i - 4) * 250, 310, 200, 30);
			} else {
				menuNm[i].setBounds(30 + (i - 8) * 250, 610, 200, 30);
			}
			jPanel.add(menuNm[i]);

			menuImg[i] = new JLabel();
			menuImg[i].setBounds(menuNm[i].getX(), menuNm[i].getY() + 30, 200, 200);
			menuImg[i].setIcon(img[i]);
			jPanel.add(menuImg[i]);

			minus[i] = new JButton("-");
			minus[i].setFont(new Font("맑은 고딕", Font.BOLD, 9));
			minus[i].setBounds(menuNm[i].getX() + 70, menuNm[i].getY() + 235, 40, 30);
			jPanel.add(minus[i]);

			menuCnt[i] = new JTextField("0");
			menuCnt[i].setBounds(menuNm[i].getX() + 110, menuNm[i].getY() + 235, 40, 30);
			jPanel.add(menuCnt[i]);

			plus[i] = new JButton("+");
			plus[i].setBounds(menuNm[i].getX() + 153, menuNm[i].getY() + 235, 40, 30);
			plus[i].setFont(new Font("맑은 고딕", Font.BOLD, 9));
			jPanel.add(plus[i]);

			menuPrice[i] = new JLabel(" " + arrayMenuPrice[i] + "원");
			menuPrice[i].setFont(new Font("맑은 고딕", Font.BOLD, 17));
			menuPrice[i].setOpaque(true);
			menuPrice[i].setBackground(Color.BLACK);
			menuPrice[i].setForeground(Color.WHITE);
			menuPrice[i].setBounds(menuNm[i].getX(), menuNm[i].getY() + 230, 200, 40);
			jPanel.add(menuPrice[i]);

		}

		//버튼 이벤트
		for (int i = 0; i < menu.length; i++) {
			int j = i;

			minus[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					count[j] = Integer.parseInt(menuCnt[j].getText());
					if (count[j] > 0) {
						count[j] = count[j] - 1;
					} else {
						// 0 값으로 진행 불가. 0이상이 아니면 빠져나오기
						return;
					}
					menuCnt[j].setText(count[j] + "");
///////////////////////////////////////////////////////////////////////////ADD////////////////////////////////////
					int price = Integer.parseInt(totPrice.getText().replace("원", ""));
					totPrice.setText(price - arrayMenuPrice[j] + "원"); // 버튼두번눌리는거 이해하기
					FoodMenu.setTotPrice(totPrice);
					RamenMenu.setTotPrice(totPrice);
					FastFoodMenu.setTotPrice(totPrice);
					CafeMenu.setTotPrice(totPrice);
///////////////////////////////////////////////////ADD////////////////////////////////////	
					Vector rowData = new Vector();

					int sum = arrayMenuPrice[j] * Integer.parseInt(menuCnt[j].getText());

					if (count[j] > 0) {
						for (int k = 0; k < prodOrdTable.model.getRowCount(); k++) {
							if (prodOrdTable.model.getValueAt(k, 0) == menu[j]) {
								prodOrdTable.model.setValueAt(count[j], k, 2);
								prodOrdTable.model.setValueAt(sum, k, 3);

							}
						}
					} else if (count[j] == 0) {
						for (int k = 0; k < prodOrdTable.model.getRowCount(); k++) {
							if (prodOrdTable.model.getValueAt(k, 0) == menu[j]) {
								prodOrdTable.model.removeRow(k);
							}
						}
					}

				}
			});

			plus[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					count[j] = Integer.parseInt(menuCnt[j].getText()); // 메뉴갯수가 적히는 jtextfield를 인트로 count에 대입

					if (count[j] >= 0) {
						count[j] = count[j] + 1;
					}

					menuCnt[j].setText(count[j] + "");
///////////////////////////////////////////////////////////////////////////ADD////////////////////////////////////
					int price = Integer.parseInt(totPrice.getText().replace("원", ""));
					totPrice.setText(price + arrayMenuPrice[j] + "원");	
					FoodMenu.setTotPrice(totPrice);
					RamenMenu.setTotPrice(totPrice);
					FastFoodMenu.setTotPrice(totPrice);
					CafeMenu.setTotPrice(totPrice);
///////////////////////////////////////////////////ADD////////////////////////////////////
					Vector rowData = new Vector();

					int sum = arrayMenuPrice[j] * Integer.parseInt(menuCnt[j].getText());

					if (count[j] == 1) {
						rowData.add(menu[j]);
						rowData.add(arrayMenuPrice[j]);
						rowData.add(Integer.parseInt(menuCnt[j].getText()));
						rowData.add(sum);
						prodOrdTable.model.addRow(rowData);

					} else if (count[j] > 1) {
						for (int k = 0; k < prodOrdTable.model.getRowCount(); k++) {
							if (prodOrdTable.model.getValueAt(k, 0) == menu[j]) {
								prodOrdTable.model.setValueAt(count[j], k, 2);
								prodOrdTable.model.setValueAt(sum, k, 3);

							}
						}
					}
				}
			});

		}

		// 스크롤바
		jScrollPane = new JScrollPane(jPanel, jScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				jScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jScrollPane.setViewportView(jPanel);// 스크롤 팬 위에 패널을 올린다.

	}

///////////////////////////////////////////////////ADD////////////////////////////////////
	public static void setTotPrice(JLabel requestTotPrice) {
		totPrice = requestTotPrice;
	}
///////////////////////////////////////////////////ADD////////////////////////////////////
}
