package Project;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 채팅창
 */
public class Chatting implements ActionListener, KeyListener{ 					//JFrame을 상속받지 않고 

	String[] str = {"달콤한 아이스티 어때?","김치볶음밥이 맛있어!","게임이 잘 안될땐 불닭볶음면이지!","브리핑은 아메리카노와 함께!"
					,"여기 짜파게티 개잘끓여!","Winner Winner Chicken Burger!","스팸마요덮밥은 기본이지!","단짠단짠 감자튀김!"};
	
	JTextArea jTextArea;
	JTextField jTextField;
	JButton jButton;
	JPanel jPanel;
	JScrollPane jScrollPane;
	
	public Chatting() {
		
		jPanel = new JPanel();
		jPanel.setBackground(Color.LIGHT_GRAY);

		
		jTextArea = new JTextArea(22, 17);
		jTextArea.setBackground(Color.WHITE);

		
		
		jTextField = new JTextField("말을 걸어보세요!",10);

		jButton = new JButton("Enter");
		
		jScrollPane = new JScrollPane(jTextArea, jScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
									jScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		jPanel.add(jScrollPane, "Center");
		
		jPanel.add(jTextField, "South");
		
		jPanel.add(jButton);
		
		jTextField.addKeyListener(this);
		jButton.addActionListener(this);
		
		jTextField.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				jTextField.setText("");
			}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {}
		});
		
		
		
		jTextField.requestFocus();
	}

	
	
	private void makeWord() {
		Random rnd = new Random();
		int value = rnd.nextInt(str.length);
		jTextArea.append(str[value]+"\n");		
	
	}
	
	
	private void appendData() {
		String txt = jTextField.getText();				//사용자가 입력한 내용을 가져와서(gettext)
		
		jTextArea.append("User : "+txt+"\n");			//jta에 노출시킨다.
		
		makeWord(); 							//사용자가 대화를 걸고 심심이가 대답을 하도록
		
		//글을 보내고 난 뒤 지우게하는 작업
		jTextField.setText("");
	
	}
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key==e.VK_ENTER) {
			appendData();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		appendData();
	}

}
