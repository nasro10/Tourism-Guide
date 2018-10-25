package tn.esprit.b3.esprit1718b3tourism.app.client.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;

public class clientRestau implements Initializable{

    @FXML
    private JFXButton btnPassWolf;
    @FXML
    private Label txtLabel;
  

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	  @FXML
	    void passWolf(ActionEvent event) throws IOException {
		  FXMLLoader loader = new FXMLLoader(getClass().getResource("ImcClient.fxml"));
          Parent root = loader.load();
          ImcCientController imcController = loader.getController();
          btnPassWolf.getScene().setRoot(root);

	    }
}
