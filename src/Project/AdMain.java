package Project;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdMain {

	JPanel jp;
	JLabel jlb;
	ImageIcon[] img = { new ImageIcon("src/projectimages/0.jpg"), new ImageIcon("src/projectimages/1.jpg"),
			new ImageIcon("src/projectimages/2.jpg") };
	JButton pre, next;
	
	
	int count = 0;

	public AdMain() {

		jp = new JPanel();
		jp.setBounds(0, 0, 350, 250);
		jp.setLayout(null);

		jlb = new JLabel();
		jlb.setBounds(0, 0, 350, 250);

		ImageIcon icon = new ImageIcon("src/projectimages/pre.png");
		Image im = icon.getImage();
		Image im2 = im.getScaledInstance(50, 70, Image.SCALE_DEFAULT);	
		
		pre = new JButton(new ImageIcon(im2));
		pre.setBounds(10, 90, 50, 70);
		pre.setOpaque(false);
		pre.setBorderPainted(false);
		pre.setContentAreaFilled(false);
		
		ImageIcon icon2 = new ImageIcon("src/projectimages/next.png");
		Image im3 = icon2.getImage();
		Image im4 = im3.getScaledInstance(50, 70, Image.SCALE_DEFAULT);

		next = new JButton(new ImageIcon(im4));
		next.setBounds(280, 90, 50, 70);
		next.setOpaque(false);
		next.setBorderPainted(false);
		next.setContentAreaFilled(false);

		jp.add(pre);
		jp.add(next);
		jp.add(jlb);
		jlb.setIcon(img[0]);

		pre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * 0 = 메이플 1= 배그 2= 오버워치
				 */
				count--; 
				count = count % 3; 
				if (count == 0) {
					jlb.setIcon(img[count]);
				} else if (count == 1 || count == -2) {
					jlb.setIcon(img[1]);
				} else if (count == 2 || count == -1) {
					jlb.setIcon(img[2]);
				}
			}
		});

		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				count++;
				count = count % 3;
				if (count == 0) {
					jlb.setIcon(img[count]);
				} else if (count == 1 || count == -2) {
					jlb.setIcon(img[count]);
				} else if (count == 2 || count == -1) {
					jlb.setIcon(img[count]);
				}
			}
		});

	}
}
