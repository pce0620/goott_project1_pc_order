package Project;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ProdOrdTable {
	JPanel jp;
	JTable table;
	String[] column = { "상품명", "금액", "수량", "최종금액" };
	Object[][] data = {};

	JScrollPane jPane;
	DefaultTableModel model;
	JButton jbtn;
	
	public ProdOrdTable() {
		
		jp = new JPanel();
		jp.setSize(700, 310);
		jp.setLayout(new BorderLayout());

		model = new DefaultTableModel(data, column);   //********순서대로 중요!
		table = new JTable(model);

		jPane = new JScrollPane(table);
		jp.add(jPane);
		jPane.setBounds(0, 450, 350, 250);

	}


//	public void getddd(String menuNm, int price, int menuCnt, int totPrice) {
//		// TODO Auto-generated method stub
//		//Object[][] data = {{menuNm,price,menuCnt,totPrice}};
//		Vector rowData = new Vector();
//		rowData.add(menuNm);
//		rowData.add(price);
//		rowData.add(menuCnt);
//		rowData.add(totPrice);
//
////		model = new DefaultTableModel(data, column);
//		System.out.println(rowData);
//		model.addRow(rowData);
//	}

}
