package tn.esprit.b3.esprit1718b3tourism.app.client.gui;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;

import java.io.IOException;
import java.lang.reflect.Proxy;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.controlsfx.control.Notifications;

import com.jfoenix.controls.JFXButton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import tn.esprit.b3.esprit1718b3tourism.entities.Claim;
import tn.esprit.b3.esprit1718b3tourism.entities.Hotel;
import tn.esprit.b3.esprit1718b3tourism.entities.HotelManager;
import tn.esprit.b3.esprit1718b3tourism.entities.User;
import tn.esprit.b3.esprit1718b3tourism.services.ClaimServiceRemote;
import tn.esprit.b3.esprit1718b3tourism.services.HotelManagerServiceRemote;
import tn.esprit.b3.esprit1718b3tourism.services.UserServiceRemote;

public class ClaimsController {
	@EJB
	ClaimServiceRemote claimServiceRemote;
	@EJB
	HotelManagerServiceRemote hrm;
	@EJB
	UserServiceRemote urm;
	@FXML
	private Label username;
	@FXML
	private Label email;
	@FXML
	private Label phone;
	 @FXML
	    private AnchorPane Claimanchor;
	 @FXML
	    private TableView<Claim> tab1;
	
	  @FXML
	    private TableColumn<Claim, Date> date;
	  @FXML
	    private TableColumn<Claim, String> text;
	  @FXML
	    private TableColumn<Claim, String> status;
	
	@FXML
	private Label username1;
	@FXML
	private Label email1;
	@FXML
	private Label phone1;
	
	@FXML
	private Label count;
	@FXML
	private Label count1;
	
	@FXML
    private JFXButton retour;
	
	@FXML
	private CheckBox block;
	
	@FXML
	private CheckBox pricedec;
	
	@FXML
	private CheckBox deldonejob;
	
	private int s;
	public static Claim c;
	
	public static int nc;
	public static int nc1;
	
	
	
	
	
	
	@FXML
	public void initialize() {
		LoadData();
		String jndiName="esprit1718b3tourism-ear/esprit1718b3tourism-service/ClaimService!tn.esprit.b3.esprit1718b3tourism.services.ClaimServiceRemote";
		//User u = new User(11, "ss", "saz", 44,"ss", "a", "aa");
			Context context;
			try {
				context = new InitialContext();
				ClaimServiceRemote proxy = (ClaimServiceRemote) context.lookup(jndiName);
				c=proxy.getNextNotTreatedClaim();
			
				nc=proxy.claimNumber(LoginController.getUser());
				username.setText(LoginController.getUser().getName());
				email.setText(LoginController.getUser().getMail());
				phone.setText(String.valueOf(LoginController.getUser().getPhone())) ;
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

		count.setText("claimed "+nc+" times \n");
		if(c!=null){
			username.setText(c.getClaimer().getName());
			email.setText(c.getClaimer().getMail());
			phone.setText(c.getClaimer().getPhone()+"");
			
		}
		
		}
		
	
	
	@FXML
	public void declineClaim(ActionEvent event) {
		HotelManager hManager=new HotelManager();
		hManager= (HotelManager) LoginController.getUser();
		c.setHmanang(hManager);
		c.setTreated(true);
		String jndiName="esprit1718b3tourism-ear/esprit1718b3tourism-service/ClaimService!tn.esprit.b3.esprit1718b3tourism.services.ClaimServiceRemote";
		Context context;
		try {
			context = new InitialContext();
			ClaimServiceRemote proxy = (ClaimServiceRemote) context.lookup(jndiName);
			
			proxy.claimIsTreated(c);
			 Notifications notification = Notifications.create()
                     .title("Attention")
                     .text("Claim was Treated!")
                     .graphic(null)
                     .hideAfter(Duration.seconds(5))
                     .position(Pos.BOTTOM_RIGHT);
                 
         
         notification.darkStyle();
         notification.show();
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LoadData();
	
				
	}

	// Event Listener on Button.onAction
	@FXML
public void acceptClaim(ActionEvent event) {
		
		HotelManager hManager=new HotelManager();
		hManager= (HotelManager) LoginController.getUser();
		c.setHmanang(hManager);
		
		c.setTreated(true);
		String jndiName="esprit1718b3tourism-ear/esprit1718b3tourism-service/ClaimService!tn.esprit.b3.esprit1718b3tourism.services.ClaimServiceRemote";
		Context context;
		try {
			context = new InitialContext();
			ClaimServiceRemote proxy = (ClaimServiceRemote) context.lookup(jndiName);
			
			proxy.claimIsTreated(c);
			Notifications notification = Notifications.create()
                    .title("Attention")
                    .text(" Claim was Treated!")
                    .graphic(null)
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.BOTTOM_RIGHT);
                
        
        notification.darkStyle();
        notification.show();
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LoadData();

		
	}
	
	public void LoadData(){
		tab1.setVisible(true);
		String jndiName="esprit1718b3tourism-ear/esprit1718b3tourism-service/ClaimService!tn.esprit.b3.esprit1718b3tourism.services.ClaimServiceRemote";
		Context context;
		try {
			context = new InitialContext();
			ClaimServiceRemote proxy = (ClaimServiceRemote) context.lookup(jndiName);
			List<Claim>list;
			ObservableList<Claim>list1=FXCollections.observableArrayList();
			list=proxy.findAll();
			for(int i = 0; i < list.size(); i++){
				if(list.get(i).getTreated()==false){
				list1.add(new Claim(list.get(i).getClaimId(),list.get(i).getDate(),list.get(i).getText(),list.get(i).getStatus(),list.get(i).getTreated()));
				tab1.setItems(list1);
				}
			}
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		date.setCellValueFactory(new PropertyValueFactory<>("date"));
		status.setCellValueFactory(new PropertyValueFactory<>("status"));
		text.setCellValueFactory(new PropertyValueFactory<>("text"));

	}
	
	 @FXML
	    void back(ActionEvent event) throws IOException {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("AddHotel.fxml"));
		    Parent root = loader.load();
		    HotelManController tsController = loader.getController();
		    retour.getScene().setRoot(root);
	    }

	
	
}
	








