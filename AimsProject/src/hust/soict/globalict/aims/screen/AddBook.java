package hust.soict.globalict.aims.screen;
import javax.swing.*;

import hust.soict.globalict.aims.media.Book;

import hust.soict.globalict.aims.store.Store;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
public class AddBook extends JFrame {
	private JTextField title;
	private JTextField category;
	private JTextField cost;
	private JTextField author;
	private JTextField content;
	public Store store = new Store();
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		
		return north;
	}
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
		
		center.add(new JLabel("Enter author:"));
		author = new JTextField(50);
		center.add(author);
		
		center.add(new JLabel("Enter content:"));
		content = new JTextField(10);
		center.add(content);
		
		
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
			// TODO Auto-generated method stub
			String button = e.getActionCommand();
			String title1 = title.getText();
			String category1 = category.getText();
			List<String> author1 = Arrays.asList(author.getText().split(","));
			Float cost1 = Float.parseFloat(cost.getText());
			String content1 = content.getText();
			Book book1 = new Book(title1, category1, cost1, author1, content1);
			store.addMedia(book1);
			JOptionPane.showMessageDialog(null,"Add Successfully!");
			
		}
		
	}
	public AddBook() {
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		cp.add(createBottom(), BorderLayout.SOUTH);
		
		setVisible(true);
		setSize(500, 300);
		setTitle("Add Book");
	}
	public static void main(String[] args) {
		new AddBook();
	}
	
}