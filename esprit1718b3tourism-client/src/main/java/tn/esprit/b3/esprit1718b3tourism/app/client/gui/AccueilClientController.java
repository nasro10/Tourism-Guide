package tn.esprit.b3.esprit1718b3tourism.app.client.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AccueilClientController implements Initializable{
	 @FXML
	    private Text txtWolf;
	 @FXML
	    private Text cl;
	    @FXML
	    private HBox hb3;
	    @FXML
	    private Text book;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	  @FXML
	    void claim(MouseEvent event) throws IOException {
		  
		  FXMLLoader loader = new FXMLLoader(getClass().getResource("AddClaim.fxml"));
	         Parent root = loader.load();
	        AddClaimController addclaimController = loader.getController();
	         cl.getScene().setRoot(root);
		  
	    }
	  
	  @FXML
	    void book(MouseEvent event) throws IOException {
		  
		  FXMLLoader loader = new FXMLLoader(getClass().getResource("Client.fxml"));
	         Parent root = loader.load();
	        ClientController clientController = loader.getController();
	        
	         book.getScene().setRoot(root);
		  
	    }
	 @FXML
	    void PassImcClients(MouseEvent event) throws IOException {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("NvImcClient.fxml"));
         Parent root = loader.load();
        ImcCientController GiveOpController = loader.getController();
         txtWolf.getScene().setRoot(root);

	    }
	 @FXML
	    private void gotochartall() {
	    	 try {
	             Parent root = FXMLLoader.load(getClass().getResource("PastTrips.fxml"));
	             Scene scene = new Scene(root);
	             Stage stage = (Stage) hb3.getScene().getWindow();
	             stage.setScene(scene);
	             stage.show();
	         } catch (IOException ex) {
	             Logger.getLogger(TMController.class.getName()).log(Level.SEVERE, null, ex);
	         }

	    }
}
