package application.controller;

import java.io.IOException;
import java.net.URL;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;
import application.Main;
import application.model.RandomSelection;
import application.model.CircleMap;
import javafx.animation.FillTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainController implements Initializable{

	@FXML
	private Circle circle1;
	@FXML
	private Circle circle2;
	@FXML
	private Circle circle3;
	@FXML
	private Circle circle4;
	@FXML
	private Circle circle5;
	@FXML
	private Circle circle6;
	@FXML
	private Circle circle7;
	@FXML
	private Circle circle8;
	@FXML
	private Circle circle9;
	@FXML
	private Circle circle10;
	@FXML
	private Circle mamaCircle;
	@FXML
	private Label indian;
	@FXML
	private Label italian;
	@FXML
	private Label chinese;
	@FXML
	private Label med;
	@FXML
	private Label thai;
	@FXML
	private Label american;
	@FXML
	private Label japanese;
	@FXML
	private Label seafood;
	@FXML
	private Label mexican;
	@FXML
	private Label bbq;
	@FXML
	private TextField zipCode;
	@FXML
	private Label zipError;
	@FXML
	private Label error;
	
	private CircleMap map = new CircleMap();
	
	public static String zipString;
	public static String restResult; 

	
	Stage primaryStage;
	
	int counter = 0;
	int save;
	Color temp;
	public static Stage stage;
	boolean flag = false;

	public void handle(ActionEvent e) {
			
		map.getMap().put(circle1, indian.getText());
		map.getMap().put(circle2, chinese.getText());
		map.getMap().put(circle3, thai.getText());
		map.getMap().put(circle4, bbq.getText());
		map.getMap().put(circle5, mexican.getText());
		map.getMap().put(circle6, american.getText());
		map.getMap().put(circle7, japanese.getText());
		map.getMap().put(circle8, seafood.getText());
		map.getMap().put(circle9, italian.getText());
		map.getMap().put(circle10, med.getText());
		
		String zip = zipCode.getText();
		
		if( zip.length() != 5 || zip.isEmpty()) {
			zipError.setVisible(true);
			flag = false;
		}
		else {
			zipError.setVisible(false);
			error.setVisible(false);
			int rand = RandomSelection.randomNumber(10, 31);
			
			Collection<Circle> keys = map.getMap().keySet();
			
			ArrayList<Circle> list = new ArrayList<Circle>(keys);

			if(counter > 0) {
				list.get(save).setFill(temp);
			}
			int i;
			for(i = 0; i < rand; i++) {
				

				if(i == 10) {
					i = 0;
					rand = rand - 10;
				}
						
				Color c = (Color) list.get(i).getFill();
					
				FillTransition fill = new FillTransition();  
			      
			    //setting cycle count for the fill transition   
			    fill.setCycleCount(20);  
			      
			    //setting duration for the Fill Transition   
			    fill.setDuration(Duration.millis(100));  
			      
			    //setting the Intital from value of the color  
			    fill.setFromValue(c);  
			      
			    //setting the target value of the color  
			    fill.setToValue(Color.BLACK);  
			      
			    //setting polygon as the shape onto which the fill transition will be applied   
			    fill.setShape(list.get(i));  
			    
			    if(i != rand - 1) {
					fill.setFromValue(c);
					fill.setToValue(c);  
				} 
		
			    fill.play();
			    

				
				save = rand - 1;
				temp = c;
				
				if(i == rand - 1) {
					list.get(i).setFill(javafx.scene.paint.Color.BLACK);
				} 
			
			} 
			
			
			zipString = zipCode.getText();
			restResult = map.getMap().get(list.get(i-1));
			
			counter++;
			
			
			flag = true;
		}
	}
	
	public void handleRestaurant( ActionEvent event ) throws IOException {
      
        if(flag == true) {
			Parent root = FXMLLoader.load(getClass().getResource("/application/view/Restaurant.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));	
			Main.stage.show();
        } else {
        	error.setVisible(true);
        }
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		zipError.setVisible(false);
		error.setVisible(false);
	
	}
}
