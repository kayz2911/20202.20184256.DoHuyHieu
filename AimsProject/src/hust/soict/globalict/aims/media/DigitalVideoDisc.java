package hust.soict.globalict.aims.media;

import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hust.soict.globalict.aims.exception.PlayerException;

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
	
	public void play() throws PlayerException {
		if(this.getLength() > 0) {
			JPanel fa = new JPanel();
			fa.setLayout(new GridLayout(2,1));
			fa.add(new JLabel("Title:" + title));
			fa.add(new JLabel("Length: " + length));
			JOptionPane.showConfirmDialog(null, fa, "Playing " + title, JOptionPane.NO_OPTION);;
		} else {
			throw new PlayerException("ERROR: DVD length is non-positive!");
		}
		
	}
	
	@Override
	public String toString() {
		return id + ".DVD "  + " " + title + " - " + category + " - " + cost +" $";
	}
		
}
