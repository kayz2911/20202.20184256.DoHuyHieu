package hust.soict.globalict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

	@FXML
	private Pane drawingAreaPane;
	private int t = 0;
	
	 @FXML
	 void penfunction(MouseEvent event) {
	    t = 0;
	 }

	 @FXML
	 void erasefunction(MouseEvent event) {
	    t = 1;
	 }
	
	 @FXML
	 void clearButtonPressed(ActionEvent event) {
		drawingAreaPane.getChildren().clear();
	 }
	
	 @FXML
	 void drawingAreaMouseDragged(MouseEvent event) {
		Circle newCircle;
    	if(t == 0) {
    		newCircle = new Circle(event.getX(),event.getY(), 4, Color.BLACK);
    	}
    	else {
    		newCircle = new Circle(event.getX(),event.getY(), 4, Color.WHITE);
    	}
    	drawingAreaPane.getChildren().add(newCircle);	
	
	 }
}
