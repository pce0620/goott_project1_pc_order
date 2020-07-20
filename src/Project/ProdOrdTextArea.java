package Project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.TextArea;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ProdOrdTextArea {
	JTextArea jTextArea;
	JPanel jp;
	
	public ProdOrdTextArea() {
		
		jp = new JPanel();
		jp.setSize(700, 310);
		jp.setLayout(new BorderLayout());		
		
		jTextArea = new JTextArea();
		jTextArea.setText("   상품명        단가        수량        합계\n\n");
		jTextArea.setBackground(Color.white);
		jTextArea.setEditable(false);
		
		jp.add(jTextArea);
		
	}
	
	
}
