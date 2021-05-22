package hust.soict.globalict.aims.screen;

import javax.swing.JFrame;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


public class CartScreenController extends JFrame{
	
	private Store store;
	private Cart cart;
	
	@FXML
    private Button btnPlay;
	
	@FXML
	private Button btnPlaceOrder;
	
	@FXML
    private Label TotalCost;
	
    @FXML
    private Button btnRemove;
	
	@FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private MenuItem mniAddBook;

    @FXML
    private MenuItem mniAddCD;

    @FXML
    private MenuItem mniAddDVD;
    @FXML
    void mniAddBookPressed(ActionEvent event) {
    	new AddBook(store, cart);
    }

    @FXML
    void mniAddCDPressed(ActionEvent event) {
    	new AddCD(store, cart);
    }

    @FXML
    void mniAddDVDPressed(ActionEvent event) {
    	new AddDigitalVideoDisc(store,cart);
    }
    @FXML
    void MenuItemClicked(ActionEvent event) {
    	new StoreScreen(store, cart);
    }
  
    public CartScreenController(Cart cart, Store store) {
    	super();
    	this.cart = cart;
    	this.store = store;
    }
    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    	TotalCost.setText(Float.toString(cart.totalCost()) + "$");
    }
    @FXML
    void btnPlayPressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	try {
			media.play();
		} catch (PlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    @FXML
    void btnPlaceOrderPressed(MouseEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	if(cart.getQtyOrdered() > 0) {
	    	alert.setTitle("Place Order");
	    	alert.setContentText("Order Succesfully! Your total cost is: " + TotalCost.getText());
	    	alert.showAndWait();
	    	cart.removeMedia();
    	}
    	else {
    		alert.setTitle("Place Order");
	    	alert.setContentText("Your cart is empty");
	    	alert.showAndWait();
    	}
    	TotalCost.setText(Float.toString(cart.totalCost()) + "$");
    }
    @FXML
    void initialize() {
    	
    	colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
    	colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(new PropertyValueFactory<Media,Float>("Cost"));
    	tblMedia.setItems(this.cart.getItemsOrdered());
    	btnPlay.setVisible(false);
    	btnRemove.setVisible(false);
    	tblMedia.getSelectionModel().selectedItemProperty().addListener(
    			new ChangeListener<Media>() {

					@Override
					public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
						// TODO Auto-generated method stub
						if(newValue!=null) {
							
							updateButtonBar(newValue);
						}
					}
    				
    			}
    			);
    	TotalCost.setText(Float.toString(cart.totalCost()) + "$");
    }
    void updateButtonBar(Media media) {
    	btnRemove.setVisible(true);
    	if(media instanceof Playable) {
    		btnPlay.setVisible(true);
    	}
    	else {
    		btnPlay.setVisible(false);
    	}
    }
}