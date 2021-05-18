package hust.soict.globalict.aims.screen;
import javax.swing.*;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AddDigitalVideoDisc extends StoreScreen {
	private JTextField title;
	private JTextField category;
	private JTextField cost;
	private JTextField director;
	private JTextField length;
	private Store store2;
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		
		center.setLayout(new GridLayout(7,2));
		
		center.add(new JLabel("Enter title:"));
		title = new JTextField(50);
		center.add(title);
		
		center.add(new JLabel("Enter category:"));
		category = new JTextField(50);
		center.add(category);
		
		center.add(new JLabel("Enter cost:"));
		cost = new JTextField(10);
		center.add(cost);
		
		center.add(new JLabel("Enter director:"));
		director = new JTextField(50);

		center.add(director);
		
		center.add(new JLabel("Enter length:"));
		length = new JTextField(10);
		center.add(length);
		
		return center;
	}
	JPanel createBottom() {
		JPanel Bottom = new JPanel();
		Bottom.setLayout(new GridLayout(1, 5));
		JButton send = new JButton("Send");
		send.addActionListener(new SendListener());
		send.setPreferredSize(new Dimension(70,30));
		send.setMaximumSize(new Dimension(70, 30));
		Bottom.add(Box.createHorizontalGlue());
		Bottom.add(send, BorderLayout.CENTER);
		Bottom.add(Box.createHorizontalGlue());
		
		Bottom.add(Box.createRigidArea(new Dimension(50, 30)));
		return Bottom;
	}
	private class SendListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String title1 = title.getText();
			String category1 = category.getText();
			String director1 = director.getText();
			Float cost1 = Float.parseFloat(cost.getText());
			int length1 = Integer.parseInt(length.getText());
			DigitalVideoDisc dvd1 = new DigitalVideoDisc(title1, category1, director1, length1, cost1);
			store2.addMedia(dvd1);
			JOptionPane.showMessageDialog(null,"Successfully!");
		}
		
	}
	
	public AddDigitalVideoDisc(Store store, Cart cart) {
		super(store, cart);
		this.store2 = store;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		cp.add(createBottom(), BorderLayout.SOUTH);
		
		setVisible(true);
		setSize(500, 300);
		setTitle("Add DVD");
	}
	
}
