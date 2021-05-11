package hust.soict.globalict.aims.media;

import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DigitalVideoDisc extends Disc implements Playable {
	public DigitalVideoDisc(String title, String category, String director, int length, float cost,int id) {
		super(title,category,director,length,cost,id);
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title,category,director,length,cost);
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title,category,director,cost);	
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title,category,cost);
	}
	
	public void play() {
		JPanel fa = new JPanel();
		fa.setLayout(new GridLayout(2,1));
		fa.add(new JLabel("Title:" + title));
		fa.add(new JLabel("Length: " + length));
		int result = JOptionPane.showConfirmDialog(null, fa, "Playing " + title, JOptionPane.NO_OPTION);;
	}
	
	@Override
	public String toString() {
		return id + ".DVD "  + " " + title + " - " + category + " - " + cost +" $";
	}
		
}
