package tn.esprit.b3.esprit1718b3tourism.app.client.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.controlsfx.control.Notifications;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import tn.esprit.b3.esprit1718b3tourism.entities.Claim;
import tn.esprit.b3.esprit1718b3tourism.services.ClaimServiceRemote;
import tn.esprit.b3.esprit1718b3tourism.services.RoomServiceRemote;

public class AddClaimController implements Initializable{
	
	 @FXML
	    private JFXTextArea claimAr;

	    @FXML
	    private JFXButton ajouter;
	    @FXML
	    private AnchorPane reclamationpane;
	    @FXML
	    private JFXComboBox<String> cb;
	    @FXML
	    private JFXButton acc;


	@EJB
	private ClaimServiceRemote claimserviceRemote;
	
	  @FXML
	    void accueil(ActionEvent event) throws IOException {
		  FXMLLoader loader = new FXMLLoader(getClass().getResource("AccueilClient.fxml"));
		    Parent root = loader.load();
		    AccueilClientController tsController = loader.getController();
		    acc.getScene().setRoot(root);
	    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cb.getItems().addAll("RoomService","Missing thing","Wifi","RoomState","Too much noise");
		
	}

	  
	    @FXML
	    void ajouter(ActionEvent event) {
			String jndiName="esprit1718b3tourism-ear/esprit1718b3tourism-service/ClaimService!tn.esprit.b3.esprit1718b3tourism.services.ClaimServiceRemote";
			 try{
				 
				 Context context=new InitialContext();
				 ClaimServiceRemote proxy = (ClaimServiceRemote) context.lookup(jndiName);
				 Claim claim=new Claim(claimAr.getText(), cb.getValue(),LoginController.getUser());
				 proxy.save(claim);
				 Notifications notification = Notifications.create()
	                       .title("Thank you!")
	                       .text("Your Claim will be Treated")
	                       .graphic(null)
	                       .hideAfter(Duration.seconds(5))
	                       .position(Pos.BOTTOM_RIGHT);
	                   
	           
	           notification.darkStyle();
	           notification.show();

	    }catch (NamingException e) {
			 //TODO Auto-generated catch block
			e.printStackTrace();
		}
			

}
}
