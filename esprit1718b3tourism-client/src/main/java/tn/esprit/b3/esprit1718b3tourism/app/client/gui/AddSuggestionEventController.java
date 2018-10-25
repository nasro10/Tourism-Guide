package tn.esprit.b3.esprit1718b3tourism.app.client.gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import tn.esprit.b3.esprit1718b3tourism.entities.Event;
import tn.esprit.b3.esprit1718b3tourism.entities.EventManager;
import tn.esprit.b3.esprit1718b3tourism.entities.Local;
import tn.esprit.b3.esprit1718b3tourism.services.EventServiceRemote;

public class AddSuggestionEventController implements Initializable{
	 @FXML
	    private JFXTextField eventname;

	    @FXML
	    private JFXTextArea description;

	    @FXML
	    private JFXTextField availableplaces;

	    @FXML
	    private JFXTextField price;
	    @FXML
	    private JFXTextField sponsorshipmoney;

	    @FXML
	    private JFXButton btadd;
	    @FXML
	    private TableView<Event> tab;

	    @FXML
	    private TableColumn<Event,String> name;

	    @FXML
	    private TableColumn<Event,String> desc;

	    @FXML
	    private TableColumn<Event,Integer> places;

	    @FXML
	    private TableColumn<Event,Float> prices;

	    @FXML
	    private TableColumn<Event,Float> money;

	    @FXML
	    private TableColumn<Event, String> status;
	    @FXML
	    private JFXButton delete;
	  
	    @FXML
	    void ajouterevent(ActionEvent event) {
	    	
	    
	    	Event events =new Event(eventname.getText(), description.getText(), Integer.parseInt(availableplaces.getText()), "non profitable", Float.parseFloat(price.getText()), Float.parseFloat(sponsorshipmoney.getText()));
			 String jndiName="esprit1718b3tourism-ear/esprit1718b3tourism-service/EventService!tn.esprit.b3.esprit1718b3tourism.services.EventServiceRemote";
		  	  try {
		  		 Context context=new InitialContext();
		  		EventServiceRemote proxy = (EventServiceRemote) context.lookup(jndiName);
		  		proxy.save(events);
		  		tab.refresh();
		  		LoadData();
		  		
		  	} catch (NamingException e) {
		  		 //TODO Auto-generated catch block
		  		e.printStackTrace();
		  	}
		  
		    }
	    public void LoadData() {
	        
            tab.setVisible(true);
            String jndiName="esprit1718b3tourism-ear/esprit1718b3tourism-service/EventService!tn.esprit.b3.esprit1718b3tourism.services.EventServiceRemote";
      	  try {
      		 Context context=new InitialContext();
      		EventServiceRemote proxy = (EventServiceRemote) context.lookup(jndiName);
      		List<Event> list ;
      		ObservableList<Event> list1 = FXCollections.observableArrayList();
      		list=proxy.findAll();
      		for(int i = 0; i < list.size(); i++){
      		list1.add(new Event(list.get(i).getIdEvent(),list.get(i).getEventName(),list.get(i).getEventDescription(),list.get(i).getEventPlaces(),list.get(i).getStatus(),list.get(i).getPrice(),list.get(i).getSponsorshipMoney()));	
      		tab.setItems(list1);
      		}
      	} catch (NamingException e) {
      		 //TODO Auto-generated catch block
      		e.printStackTrace();
      	}
      	name.setCellValueFactory(new PropertyValueFactory<>("eventName"));
      	desc.setCellValueFactory(new PropertyValueFactory<>("eventDescription"));
      	places.setCellValueFactory(new PropertyValueFactory<>("eventPlaces"));
      	status.setCellValueFactory(new PropertyValueFactory<>("status"));
    	prices.setCellValueFactory(new PropertyValueFactory<>("price"));
    	money.setCellValueFactory(new PropertyValueFactory<>("sponsorshipMoney"));
    	
    }
	    @FXML
	    void supprimer(ActionEvent event) {
	    	String jndiName="esprit1718b3tourism-ear/esprit1718b3tourism-service/EventService!tn.esprit.b3.esprit1718b3tourism.services.EventServiceRemote";
			  try {
				 Context context=new InitialContext();
				 EventServiceRemote proxy = (EventServiceRemote) context.lookup(jndiName);
				Event x ;
				 x=proxy.find(tab.getSelectionModel().getSelectedItem().getIdEvent());
				 
				proxy.delete(x);
				LoadData();
				
			} catch (NamingException e) {
				 //TODO Auto-generated catch block
				e.printStackTrace();
			}
		    }
	    	
	    
	    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
        tab.refresh();
		LoadData();
	}

}
