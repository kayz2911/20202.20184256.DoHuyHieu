package hust.soict.globalict.gui.javafx;



import java.awt.Dialog;

import javax.swing.JOptionPane;

import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.order.Order;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;



public class OrderScreenController {
	private Order order;
	private OrderScreen orderScreen;

	@FXML
	private TableView<Media> tblMedia;
	
	@FXML
	private TableColumn<Media, String> mediaTitleColumn;
	
	@FXML
	private TableColumn<Media, String> mediaCategoryColumn;
	
	@FXML
	private TableColumn<Media, Float> mediaCostColumn;
	
	@FXML
	private Button btnPlay;
	
	@FXML
	private Button btnRemove;

	
	@FXML
	private Label totalCostLabel;
	
	public OrderScreenController(Order order) {
		super();
		this.order = order;
	}
	
	@FXML
	private void initialize() {
		mediaTitleColumn.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		mediaCategoryColumn.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		mediaCostColumn.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
		tblMedia.setItems(this.order.getItemsOrderList());
		if (btnPlay != null && btnRemove != null) {
			btnPlay.setVisible(false);
			btnRemove.setVisible(false);
		}	
		totalCostLabel.setText(String.format("%.2f $",this.order.totalCost()));
		
		
		tblMedia.getSelectionModel().selectedItemProperty().addListener( new ChangeListener<Media>() {
			@Override
			public void changed(ObservableValue<?extends Media> observable, Media oldValue, Media newValue) {
				if ( newValue != null) {
					updateButtonBar(newValue);
				}
				else {
					hideButtonBar();
				}
			}
		});
	}
	
	void updateButtonBar(Media media) {
		btnRemove.setVisible(true);
		if ( media instanceof Playable ) {
			btnPlay.setVisible(true);
		}
		else {
			btnPlay.setVisible(false);
		}
	}
	
	void hideButtonBar() {
		btnRemove.setVisible(false);
		btnPlay.setVisible(false);
	}
	
	@FXML
	void viewOrderListener() {
		new OrderScreen(order);
	
	}
	
	@FXML
	void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		order.removeMedia(media);
		tblMedia.setItems(order.getItemsOrderList());
		tblMedia.refresh();
		totalCostLabel.setText(String.format("%.2f $",this.order.totalCost()));
	}
	
	@FXML
	void btnPlayPressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		try {
			JOptionPane.showMessageDialog(orderScreen, "Playing " + media.getTitle()); 
			((Playable) media).play();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(orderScreen, "Playing is invalid");
		}
	}
}
