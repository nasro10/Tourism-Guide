package tn.esprit.b3.esprit1718b3tourism.app.client.gui;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jfoenix.controls.JFXButton;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import tn.esprit.b3.esprit1718b3tourism.entities.Trip;
import tn.esprit.b3.esprit1718b3tourism.services.TripServiceRemote;

public class ChartTripsController implements Initializable {
private static Trip t1;
	
	public static Trip getT1() {
		return t1;
	}
	public static void setT1(Trip t1) {
		ChartTripsController.t1 = t1;
	}
	@FXML
    private TableView<Trip> tv1;
	

	    @FXML
	    private AnchorPane TM;
	    @FXML
	    private TableColumn<Trip, Integer> tc11;

	    @FXML
	    private TableColumn<Trip, String> tc12;

	    @FXML
	    private TableColumn<Trip, String> tc13;

	    @FXML
	    private TableColumn<Trip, String> tc14;

	    @FXML
	    private TableColumn<Trip, Float> tc15;

	    @FXML
	    private TableColumn<Trip, Integer> tc16;

	    @FXML
	    private TableColumn<Trip, Date> tc17;

	    @FXML
	    private TableColumn<Trip, Date> tc18;

	    @FXML
	    private TableColumn<Trip, String> tc19;

	    @FXML
	    private TableColumn<Trip, String> tc10;
	    

	    @FXML
	    private JFXButton b1;

	    @FXML
	    private JFXButton b11;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		LoadData();
	}
public void LoadData() {
	LocalDate localDate = LocalDate.now();
	java.util.Date date = java.util.Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        tv1.setVisible(true);
        String jndiName="esprit1718b3tourism-ear/esprit1718b3tourism-service/TripService!tn.esprit.b3.esprit1718b3tourism.services.TripServiceRemote";
  	  try {
  		 Context context=new InitialContext();
  		 TripServiceRemote proxy = (TripServiceRemote) context.lookup(jndiName);
  
  		
  		
  		 List<Trip> list ;
  		ObservableList<Trip> list1 = FXCollections.observableArrayList();
  		list=proxy.findAll() ;
  		for(int i = 0; i < list.size(); i++){
  	  	  	if (list.get(i).getReturnDate().after(date))	{
  	  	  		list.remove(i);
  	  	  		i--;
  	  	  	}
  	  		}
  		for(int i = 0; i < list.size(); i++){
  		list1.add(new Trip(list.get(i).getIdTrip(),list.get(i).getDestination(),list.get(i).getTravelDate(),list.get(i).getReturnDate(),list.get(i).getPrice(),list.get(i).getPlaces(),list.get(i).getHomecountry(),list.get(i).getDestinationcountry(),list.get(i).getHotel(), list.get(i).getFlight()));	
  		tv1.setItems(list1);
  		System.out.println(list1);
  		}


  		}
  		
  	 catch (NamingException e) {
  		 //TODO Auto-generated catch block
  		e.printStackTrace();
  	}
  	   tc11.setCellValueFactory(new PropertyValueFactory<>("idTrip"));
  	   tc12.setCellValueFactory(new PropertyValueFactory<>("homecountry"));
  	   tc13.setCellValueFactory(new PropertyValueFactory<>("destinationcountry"));
  	   tc14.setCellValueFactory(new PropertyValueFactory<>("destination"));
  	   tc15.setCellValueFactory(new PropertyValueFactory<>("price"));
  	   tc16.setCellValueFactory(new PropertyValueFactory<>("places"));
  	   tc17.setCellValueFactory(new PropertyValueFactory<>("travelDate"));
  	   tc18.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
  	 tc19.setCellValueFactory(new PropertyValueFactory<>("hotel"));
  	   tc10.setCellValueFactory(new Callback<CellDataFeatures<Trip,String>,ObservableValue<String>>(){

           @Override
           public ObservableValue<String> call(CellDataFeatures<Trip, String> param) {
               return new SimpleStringProperty(param.getValue().getFlight().getAirlines().getAirline().getACompanyName());
           }
       });
   
}

@FXML
private void gotoUI() {
	
	t1=tv1.getSelectionModel().getSelectedItem();
	
	try {
         Parent root = FXMLLoader.load(getClass().getResource("UI.fxml"));
         Scene scene = new Scene(root);
         Stage stage = (Stage) b1.getScene().getWindow();
         stage.setScene(scene);
         stage.show();
     } catch (IOException ex) {
         Logger.getLogger(TMController.class.getName()).log(Level.SEVERE, null, ex);
     }
	}

}
