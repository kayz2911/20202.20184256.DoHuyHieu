package hust.soict.globalict.aims.screen;
import javax.swing.*;

import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.store.Store;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddCD extends StoreScreen {
	private JTextField title;
	private JTextField category;
	private JTextField cost;
	private JTextField director;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	private JTextField length;
	public Store store2 = new Store();
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		
		center.setLayout(new GridLayout(7,2));
		
		center.add(new JLabel("Enter title:"));
		title = new JTextField(50);
		center.add(title);
		
		
		center.add(new JLabel("Enter category:"));
		category = new JTextField(50);
		center.add(category);
		
		
		center.add(new JLabel("Enter director:"));
		director = new JTextField(10);
		center.add(director);
		
		center.add(new JLabel("Enter length:"));
		length = new JTextField(50);
		center.add(length);
		
		center.add(new JLabel("Enter cost:"));
		cost = new JTextField(10);
		center.add(cost);
		
		
		return center;
	}
	JPanel createBottom() {
		JPanel Bottom = new JPanel();
		JButton send = new JButton("Send");
		send.addActionListener(new SendListener());
		
		JButton addTrack = new JButton("Add Track");
		addTrack.addActionListener(new AddTrackInputListener());
		
		Bottom.add(Box.createHorizontalGlue());
		Bottom.add(send, BorderLayout.CENTER);
		Bottom.add(Box.createHorizontalGlue());
		Bottom.add(addTrack, BorderLayout.CENTER);
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
			CompactDisc cd1 = new CompactDisc(title1, category1, director1, length1, cost1);
			cd1.addTrack(tracks);
			store2.addMedia(cd1);
			JOptionPane.showMessageDialog(null,"Add Successfully!");
			
		}
		
	}
	
	private class AddTrackInputListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new addTrack();
		}
	}
	
	public class addTrack{
		public addTrack() {
			JPanel fa = new JPanel();
			JTextField title = new JTextField(30);
			JTextField length = new JTextField(10);
			fa.add(new JLabel("Title:"));
			fa.add(title);
			fa.add(new JLabel("Length:"));
			fa.add(length);
			int result = JOptionPane.showConfirmDialog(null, fa, "Track", JOptionPane.OK_CANCEL_OPTION);
			if(result == JOptionPane.OK_OPTION) {
				Track track1 = new Track(title.getText(), Integer.parseInt(length.getText()));
				tracks.add(track1);
			}
		}
	}
	
	public AddCD(Store store) {
		super(store);
		this.store2 = store;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		cp.add(createBottom(), BorderLayout.SOUTH);
		
		setVisible(true);
		setSize(500, 300);
		setTitle("Add CD");
	}
	
	
}