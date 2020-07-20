package Project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * @author CHAEN
 * 메인화면
 */
public class MainOrder extends JFrame{
	private static final long serialVersionUID = 1L;
		JFrame jFrame;
		JPanel ad, menuTab, jPanelChat, jPanelPurchaseWay, jPanelPurchaseWay2, orderText, orderTotC, orderTotR, orderTotFF, orderTotF, 
			orderBtnC, orderBtnR, orderBtnF, orderBtnFF, jPanelTable;
		JScrollPane scrollcafe, scrollramen, scrollfood, scrollfastfood;
		JButton cafe, ramen, food, fastfood;
		JLabel jlb, adjlb;

		Chatting ch;
		PurchaseWay purchaseWay;
		AdMain adMain;
		
		ProdOrdTable prodOrdTable;
		CafeMenu cafeMenu;
		RamenMenu ramenMenu;
		FoodMenu foodMenu;
		FastFoodMenu fastfoodMenu;
		
		public MainOrder() {
			
			jFrame = new JFrame();
			jFrame.setBounds(0, 0, 1400, 1000);
			jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
			jFrame.setLayout(null);
			
			
			ch = new Chatting();
			jPanelChat = ch.jPanel;
			jPanelChat.setBounds(0, 0, 200, 400);

			
			adMain = new AdMain();
			ad = adMain.jp;
			ad.setBounds(0, 400, 350, 250);
		
			
			//메뉴 탭
			menuTab = new JPanel();
			menuTab.setBounds(200, 0, 150, 400);
			menuTab.setBackground(Color.DARK_GRAY);
			menuTab.setLayout(null);
			
			cafe = new JButton("카페");
			cafe.setFont(new Font("맑은 고딕", Font.BOLD, 50));
			cafe.setBounds(0, 0, 150, 100);
			cafe.setBackground(new Color(0, 0, 75));
			cafe.setForeground(Color.WHITE);
			cafe.setBorderPainted(false);
			menuTab.add(cafe);
			
			ramen = new JButton("라면");
			ramen.setFont(new Font("맑은 고딕", Font.BOLD, 50));
			ramen.setBounds(0, 100, 150, 100);
			ramen.setBackground(new Color(0, 0, 75));
			ramen.setForeground(Color.WHITE);
			menuTab.add(ramen);
			
			food = new JButton("음식");
			food.setFont(new Font("맑은 고딕", Font.BOLD, 50));
			food.setBounds(0, 200, 150, 100);
			food.setBackground(new Color(0, 0, 75));
			food.setForeground(Color.WHITE);
			menuTab.add(food);
			
			fastfood = new JButton("버거");
			fastfood.setFont(new Font("맑은 고딕", Font.BOLD, 50));
			fastfood.setBounds(0, 300, 150, 100);
			fastfood.setBackground(new Color(0, 0, 75));
			fastfood.setForeground(Color.WHITE);
			menuTab.add(fastfood);
			
			
			prodOrdTable = new ProdOrdTable();
			cafeMenu = new CafeMenu(prodOrdTable);
			ramenMenu = new RamenMenu(prodOrdTable);
			fastfoodMenu = new FastFoodMenu(prodOrdTable);
			foodMenu = new FoodMenu(prodOrdTable);
			
			scrollcafe = new JScrollPane();
			scrollcafe = cafeMenu.jScrollPane;
			scrollcafe.setBounds(350, 0, 1035, 650);
			scrollcafe.setBackground(Color.PINK);		
			
			scrollramen = new JScrollPane();
			scrollramen = ramenMenu.jScrollPane;
			scrollramen.setBounds(350, 0, 1035, 650);
			
			scrollfood = new JScrollPane();
			scrollfood = foodMenu.jScrollPane;
			scrollfood.setBounds(350, 0, 1035, 650);
			
			scrollfastfood = new JScrollPane();
			scrollfastfood = fastfoodMenu.jScrollPane;
			scrollfastfood.setBounds(350, 0, 1035, 650);
			
			
			
			//버튼으로 탭패널 바꾸기
			cafe.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					scrollcafe.setVisible(true);
					scrollramen.setVisible(false);
					scrollfood.setVisible(false);
					scrollfastfood.setVisible(false);
					cafe.setBackground(new Color(0, 51, 153));
					ramen.setBackground(new Color(0, 0, 75));
					food.setBackground(new Color(0, 0, 75));
					fastfood.setBackground(new Color(0, 0, 75));
				}
			});
			
			ramen.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					scrollcafe.setVisible(false);
					scrollramen.setVisible(true);
					scrollfood.setVisible(false);
					scrollfastfood.setVisible(false);
					cafe.setBackground(new Color(0, 0, 75));
					ramen.setBackground(new Color(0, 51, 153));
					food.setBackground(new Color(0, 0, 75));
					fastfood.setBackground(new Color(0, 0, 75));
				}
			});
			
			food.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					scrollcafe.setVisible(false);
					scrollramen.setVisible(false);
					scrollfood.setVisible(true);
					scrollfastfood.setVisible(false);
					cafe.setBackground(new Color(0, 0, 75));
					ramen.setBackground(new Color(0, 0, 75));
					food.setBackground(new Color(0, 51, 153));
					fastfood.setBackground(new Color(0, 0, 75));
					
				}
			});
			
			fastfood.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					scrollcafe.setVisible(false);
					scrollramen.setVisible(false);
					scrollfood.setVisible(false);
					scrollfastfood.setVisible(true);
					cafe.setBackground(new Color(0, 0, 75));
					ramen.setBackground(new Color(0, 0, 75));
					food.setBackground(new Color(0, 0, 75));
					fastfood.setBackground(new Color(0, 51, 153));
				}
			});
			
			
			jPanelTable = prodOrdTable.jp;
			jPanelTable.setBounds(0, 651, 700, 310);
	
			
			purchaseWay = new PurchaseWay();
			jPanelPurchaseWay = purchaseWay.jp1;
			jPanelPurchaseWay.setBounds(700, 650, 300, 100);
			jPanelPurchaseWay.setBackground(Color.LIGHT_GRAY);
		
			
			jPanelPurchaseWay2 = purchaseWay.jp2;
			jPanelPurchaseWay2.setBounds(700, 750, 300, 50);
			jPanelPurchaseWay2.setBackground(Color.LIGHT_GRAY);
		
			
			orderText = purchaseWay.jp3;
			orderText.setBounds(700, 800, 300, 160);
			orderText.setBackground(Color.LIGHT_GRAY);
		
			//주문 패널부분
			orderTotC = cafeMenu.ordertotal;
			orderTotC.setLayout(null);
			orderTotC.setBounds(1000, 650, 385, 180);
			orderBtnC = cafeMenu.order;
			orderBtnC.setLayout(null);
			orderBtnC.setBounds(1000, 830, 385, 130);
			
			jFrame.add(orderTotC); jFrame.add(orderBtnC);
			

			orderTotR = ramenMenu.ordertotal;
			orderTotR.setLayout(null);
			orderTotR.setBounds(1000, 650, 385, 180);
			orderBtnR = ramenMenu.order;
			orderBtnR.setLayout(null);
			orderBtnR.setBounds(1000, 830, 385, 130);
			
			jFrame.add(orderTotR); jFrame.add(orderBtnR);
			
			
			orderTotF = foodMenu.ordertotal;
			orderTotF.setLayout(null);
			orderTotF.setBounds(1000, 650, 385, 180);
			orderBtnF = foodMenu.order;
			orderBtnF.setLayout(null);
			orderBtnF.setBounds(1000, 830, 385, 130);
			
			jFrame.add(orderTotF); jFrame.add(orderBtnF);
			
			
			orderTotFF = fastfoodMenu.ordertotal;
			orderTotFF.setLayout(null);
			orderTotFF.setBounds(1000, 650, 385, 180);
			orderBtnFF = fastfoodMenu.order;
			orderBtnFF.setLayout(null);
			orderBtnFF.setBounds(1000, 830, 385, 130);
			
			jFrame.add(orderTotFF); jFrame.add(orderBtnFF);
			
			
			
			
			jFrame.add(jPanelChat); 
			jFrame.add(scrollcafe); jFrame.add(scrollramen); jFrame.add(scrollfood); jFrame.add(scrollfastfood);
			jFrame.add(jPanelTable); jFrame.add(jPanelPurchaseWay); 
			jFrame.add(jPanelPurchaseWay2); jFrame.add(orderText); 

			
			jFrame.add(ad); jFrame.add(menuTab);
			

			
			jFrame.setVisible(true);
		}
		
		
		
		public static void main(String[] args) {
			new MainOrder();
			
		}
		
}

