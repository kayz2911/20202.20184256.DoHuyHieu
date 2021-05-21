package hust.soict.globalict.gui.javafx;

import javax.swing.JFrame;

import hust.soict.globalict.aims.order.Order;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class OrderScreen extends JFrame{
	private Order order;
	
	public OrderScreen(Order order) {
		super();
		this.order = order;
		
		JFXPanel jfxPanel = new JFXPanel();
		this.add(jfxPanel);
		
		this.setTitle("Order");
		this.setVisible(true);
		this.setSize(1024, 768);
		javafx.application.Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("aims.fxml"));
					OrderScreenController controller = new OrderScreenController(order);
					loader.setController(controller);
					Parent root = loader.load();
					jfxPanel.setScene(new Scene(root));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
