package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;
import application.model.SearchGoogle;
import application.model.ZipCode;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

public class RestaurantController implements EventHandler<ActionEvent>, Initializable{
	
	@FXML
	private AnchorPane pane;
	@FXML
	private TextArea listOfR;
	@FXML
	private Button back;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		String zipcode = MainController.zipString;
		String restResult = MainController.restResult;
		ZipCode zip = new ZipCode(zipcode);
		ArrayList<String> latlon = zip.returnLatLong();
		SearchGoogle g1 = new SearchGoogle( restResult, latlon.get(0), latlon.get(1));
		
		try {
			g1.find(restResult, latlon.get(0), latlon.get(1));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		listOfR.setText(g1.ToString());
		
	}

	@Override
	public void handle(ActionEvent e) {
		
        try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/view/YouChoose.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));	
			Main.stage.show();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
		
	}
	
	

}
