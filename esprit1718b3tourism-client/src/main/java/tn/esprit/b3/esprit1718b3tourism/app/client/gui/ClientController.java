package tn.esprit.b3.esprit1718b3tourism.app.client.gui;


import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.controlsfx.control.Notifications;
import org.controlsfx.control.Rating;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXProgressBar;
import com.jfoenix.controls.JFXTextField;
import  tn.esprit.b3.esprit1718b3tourism.entities.EventBooking;
import tn.esprit.b3.esprit1718b3tourism.entities.Event;
import tn.esprit.b3.esprit1718b3tourism.entities.EventBooking_PK;
import tn.esprit.b3.esprit1718b3tourism.entities.EventRating;
import tn.esprit.b3.esprit1718b3tourism.entities.Hotel;
import tn.esprit.b3.esprit1718b3tourism.entities.HotelBooking_Pk;
import tn.esprit.b3.esprit1718b3tourism.entities.HotelManager;
import tn.esprit.b3.esprit1718b3tourism.entities.HotelRating;
import tn.esprit.b3.esprit1718b3tourism.entities.Restaurant;
import tn.esprit.b3.esprit1718b3tourism.entities.RestaurantRating;
import javafx.animation.RotateTransition;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.*;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import javafx.util.Duration;
import tn.esprit.b3.esprit1718b3tourism.services.EventBookingServiceRemote;
import tn.esprit.b3.esprit1718b3tourism.services.EventRatingServiceRemote;
import tn.esprit.b3.esprit1718b3tourism.services.EventServiceRemote;
import tn.esprit.b3.esprit1718b3tourism.services.HotelBookingServiceRemote;
import tn.esprit.b3.esprit1718b3tourism.services.HotelManagerServiceRemote;
import tn.esprit.b3.esprit1718b3tourism.services.HotelRateServiceRemote;
import tn.esprit.b3.esprit1718b3tourism.services.HotelServiceRemote;
import tn.esprit.b3.esprit1718b3tourism.services.RestaurantRatingServiceRemote;
import tn.esprit.b3.esprit1718b3tourism.services.RestaurantServiceRemote;
import tn.esprit.b3.esprit1718b3tourism.services.RoomServiceRemote;
import tn.esprit.b3.esprit1718b3tourism.services.TableBookingServiceRemote;
import tn.esprit.b3.esprit1718b3tourism.services.TableRServiceRemote;
import tn.esprit.b3.esprit1718b3tourism.services.TripBookingServiceRemote;
import tn.esprit.b3.esprit1718b3tourism.services.TripRatingServiceRemote;
import tn.esprit.b3.esprit1718b3tourism.services.TripServiceRemote;
import tn.esprit.b3.esprit1718b3tourism.services.UserServiceRemote;
import tn.esprit.b3.esprit1718b3tourism.entities.Room;
import tn.esprit.b3.esprit1718b3tourism.entities.TableBooking;
import tn.esprit.b3.esprit1718b3tourism.entities.TableBooking_Pk;
import tn.esprit.b3.esprit1718b3tourism.entities.TableR;
import tn.esprit.b3.esprit1718b3tourism.entities.Trip;
import tn.esprit.b3.esprit1718b3tourism.entities.TripBooking;
import tn.esprit.b3.esprit1718b3tourism.entities.TripBooking_Pk;
import tn.esprit.b3.esprit1718b3tourism.entities.TripRating;
import tn.esprit.b3.esprit1718b3tourism.entities.User;
import tn.esprit.b3.esprit1718b3tourism.entities.HotelBooking;
import javafx.beans.value.ObservableValue;

public class ClientController implements Initializable {
	 @FXML
	    private TableView<HotelBooking> tabres;

	    @FXML
	    private TableColumn<HotelBooking_Pk, Date> dateres;

	    @FXML
	    private TableColumn<HotelBooking, Integer> nberes;
	    @FXML
	    private Button Update;
	    @FXML
	    private Button Delete;
    @FXML
    private JFXButton Acceuil;
	
    @FXML
    private JFXButton checkBooking;
    
    @FXML
    private JFXButton Finish;
    @FXML
    private AnchorPane EventBookingpane2;

    @FXML
    private JFXTextField tf21;

    @FXML
    private JFXButton finishevent;

    @FXML
    private Rating Hotelrate11;

    @FXML
    private Label lHotelrate11;
    
	 @FXML
	    private DatePicker dp1;
	 @FXML
	    private JFXTextField tf1;
	 @FXML
	    private DatePicker dp11;
	 @FXML
	    private JFXTextField tf11;
	    @FXML
	    private JFXButton EventBooking;
	    @FXML
	    private AnchorPane Eventbookingpane;
	    @FXML
	    private JFXButton NextEventBooking;
	    @FXML
	    private JFXButton RestaurantBooking;
	    @FXML
	    private JFXButton RestaurantBooking1;
	    @FXML
	    private TableView<TableR> tab11;

	    @FXML
	    private TableColumn<TableR,Integer> columnNumber;

	    @FXML
	    private TableColumn<TableR, Integer> columnPlaces;

	    @FXML
	    private TableColumn<TableR, String> columnDescription;

	    @FXML
	    private TableColumn<TableR,Boolean> columnAvailable;
	    @FXML
	    private AnchorPane restopane1;
	    @FXML
	    private AnchorPane restopane;

	    @FXML
	    private TableView<Restaurant> tabr;

	    @FXML
	    private TableColumn<Restaurant, String> namer;

	    @FXML
	    private TableColumn<Restaurant, String> addressr;

	    @FXML
	    private TableColumn<Restaurant, String> emailr;

	    @FXML
	    private TableColumn<Restaurant, Integer> phoner;

	    @FXML
	    private JFXButton NextRestaurantBooking;
	    @FXML
	    private AnchorPane restopane2;

	    @FXML
	    private JFXDatePicker dp2;

	    @FXML
	    private JFXButton finishresto;

	    @FXML
	    private Rating Hotelrate111;

	    @FXML
	    private Label lHotelrate111;
	    @FXML
	    private Label resl;

	 

	  @FXML
	    private TableView<Room> tab2;
	  @FXML
	    private JFXButton NextRoom;

	    @FXML
	    private TableColumn<Room, String> typeC;
	    @FXML
	    private TableColumn<Room, String> vipC;

	    @FXML
	    private TableColumn<Room, Integer> priceC;
	    @FXML
	    private JFXButton tripBooking;

	    @FXML
	    private AnchorPane tripBookingpane;
	    @FXML
	    private JFXButton NextTripBooking;
	    @FXML
	    private JFXProgressBar progbartrip;
	    @FXML
	    private AnchorPane tripBookingpane1;
	    @FXML
	    private JFXTextField tf2;

	    @FXML
	    private JFXButton finishtrip;

	    @FXML
	    private Rating Hotelrate1;

	    @FXML
	    private Label lHotelrate1;

	    @FXML
	    private JFXProgressBar progbartrip1;
	  

	@FXML
    private TableColumn<Hotel, String> StateC;

    @FXML
    private AnchorPane Progression;

    @FXML
    private ImageView img3;

    @FXML
    private TableColumn<Hotel, String> descC;

    @FXML
    private TableColumn<Hotel, String> nameC;

    @FXML
    private TableColumn<Hotel, Integer> PhoneC;

    @FXML
    private Label lbl1;

    @FXML
    private TableView<Hotel> tab1;

    @FXML
    private AnchorPane Booking;

    @FXML
    private Label lbl2;

    @FXML
    private TableColumn<Hotel, Integer> roomnbrC;

    @FXML
    private JFXButton NextHotel;

    @FXML
    private TableColumn<Hotel, String> adresseC;

    @FXML
    private TableColumn<Hotel, Integer> starC;
    @FXML
    private TableView<Trip> tv1;

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
    private JFXButton HotelBooking;

    @FXML
    private AnchorPane Home;

    @FXML
    private AnchorPane Room;
    @FXML
    private AnchorPane Room1;

    @FXML
    private AnchorPane Hotelpane;

    @FXML
    private TableColumn<Hotel, String> countryC;

    @FXML
    private ImageView img2;

    @FXML
    private ImageView img1;
    @FXML
	Rating Hotelrate;
	@FXML 
	Label lHotelrate;
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
	private TableColumn<Event, Date> colonedebut;

	@FXML
	private TableColumn<Event, Date> colonefin;
	@FXML

    
    private RotateTransition rotateTransition1, rotateTransition2, rotateTransition3;
	private Hotel h;
	private HotelRating hr;
	private Room r;
	private HotelBooking_Pk hpk;
	private HotelBookingServiceRemote proxy;
	private HotelRateServiceRemote proxy3;
	private Trip trip;
	private Event e;
	private Restaurant resto;
	private TableR taler;


	    @FXML
	    void HotelBooking(ActionEvent event) {
	    	Hotelpane.setVisible(true);
	    	Room.setVisible(false);
	    	Booking.setVisible(false);
	    	Progression.setVisible(true);
	    	LoadDatahotel();
	    	img1.setImage(new Image(getClass().getResource("syn.png").toExternalForm()));
	        rotateTransition1 = new RotateTransition(Duration.seconds(2), img1);
	        rotateTransition2 = new RotateTransition(Duration.seconds(2), img2);
	        rotateTransition3 = new RotateTransition(Duration.seconds(3), img3);
	        RotateTransition transition[] = {rotateTransition1, rotateTransition2,
		            rotateTransition3};
		        for (RotateTransition rTransition : transition) {
		            rTransition.setCycleCount(1);
		            rTransition.setAutoReverse(false);
		            rTransition.setFromAngle(720);
		            rTransition.setToAngle(0);
		        }
		        rotateTransition1.playFromStart();
		       
	    }
	    @FXML
	    void NextHotel(ActionEvent event) {
	    	 
	    	 if( tab1.getSelectionModel().getSelectedItem() instanceof Hotel){
	    		 h = tab1.getSelectionModel().getSelectedItem();
	    		 Hotelpane.setVisible(false);
	    	Room.setVisible(true);
	    	rotateTransition1.play();
	        rotateTransition1.setOnFinished((e) -> {
	            img1.setImage(new Image(getClass().getResource("ok.png").toExternalForm()));
	            lbl1.setStyle("-fx-background-color:#45A563");
	            img2.setImage(new Image(getClass().getResource("syn.png").toExternalForm()));	            
	            rotateTransition2.playFromStart();
	        });
	        LoadDataRoom();
	        
	        
	    	 }
	    	 else{
	    		 Notifications notification11 = Notifications.create()
	                     .title("Attention")
	                     .text("SVP Selectionner un Hotel")
	                     .graphic(null)
	                     .hideAfter(Duration.seconds(5))
	                     .position(Pos.BOTTOM_RIGHT);

	             notification11.darkStyle();
	             notification11.showError();
	    	 }
	        
	    	
	    }
	    @FXML
	    void NextRoom(ActionEvent event) {
	    	 r = tab2.getSelectionModel().getSelectedItem();
	    	 if(r instanceof Room){
	    	rotateTransition2.play();
	    	  rotateTransition2.setOnFinished((e) -> {
		            img2.setImage(new Image(getClass().getResource("ok.png").toExternalForm()));
		            lbl2.setStyle("-fx-background-color:#45A563");
		            img3.setImage(new Image(getClass().getResource("syn.png").toExternalForm()));
		            rotateTransition3.playFromStart();
		        });
	    	  Room.setVisible(false);
	    	  Booking.setVisible(true);}
	    	 else{
	    		 Notifications notification12 = Notifications.create()
	                     .title("Attention")
	                     .text("SVP Selectionner une Chambre")
	                     .graphic(null)
	                     .hideAfter(Duration.seconds(5))
	                     .position(Pos.BOTTOM_RIGHT);

	    		 notification12.darkStyle();
	    		 notification12.showError();
	    	 }
	    	 
	    }
	    @FXML
	    void Finish(ActionEvent event) {
	    	String jndiName="esprit1718b3tourism-ear/esprit1718b3tourism-service/HotelBookingService!tn.esprit.b3.esprit1718b3tourism.services.HotelBookingServiceRemote";
	    	String jndiName2="esprit1718b3tourism-ear/esprit1718b3tourism-service/HotelManagerService!tn.esprit.b3.esprit1718b3tourism.services.HotelManagerServiceRemote";
	    	String jndiName3 = "esprit1718b3tourism-ear/esprit1718b3tourism-service/HotelRateService!tn.esprit.b3.esprit1718b3tourism.services.HotelRateServiceRemote";
	    	String jndiName4 = "esprit1718b3tourism-ear/esprit1718b3tourism-service/RoomService!tn.esprit.b3.esprit1718b3tourism.services.RoomServiceRemote";
			 Context context;
			 Context context2;
			 Context context3;
			 Context context4;
			 
			try {
				context = new InitialContext();
			    context3 = new InitialContext();
			    context4= new InitialContext();
			    context2= new InitialContext();
			
			proxy = (HotelBookingServiceRemote) context.lookup(jndiName);
			HotelManagerServiceRemote proxy2 = (HotelManagerServiceRemote) context2.lookup(jndiName2);
			proxy3 = (HotelRateServiceRemote) context3.lookup(jndiName3);
			RoomServiceRemote proxy10 = (RoomServiceRemote) context4.lookup(jndiName4);
              hr = new HotelRating(Hotelrate.getRating(), h);
			 java.util.Date date = java.util.Date.from(dp1.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
			 hpk = new HotelBooking_Pk(LoginController.getUser().getId(),r.getIdRoom(),date);
			 HotelBooking h1 = new HotelBooking(hpk,Integer.valueOf(tf1.getText()),LoginController.getUser(),r);

			 proxy.save(h1);
			 proxy3.save(hr);
			 r.setAvailable(false);
			 r.setHotel(h);
			 HotelManager hb = proxy2.find(r.getHotelManager().getId());
			 r.setHotelManager(hb);
			 proxy10.update(r);
			
			
	    } catch (NamingException e) {
			e.printStackTrace();
		}
            img3.setImage(new Image(getClass().getResource("ok.png").toExternalForm()));           

			Home.setVisible(true);
			Hotelpane.setVisible(false);
	    	Room.setVisible(false);
	    	Booking.setVisible(false);
	    	Progression.setVisible(false);
	    	img1.setImage(new Image(getClass().getResource("clock.png").toExternalForm()));
	    	img2.setImage(new Image(getClass().getResource("clock.png").toExternalForm()));
	    	img3.setImage(new Image(getClass().getResource("clock.png").toExternalForm()));
	    	lbl1.setStyle("-fx-background-color:#2A2E37");
	    	lbl2.setStyle("-fx-background-color:#2A2E37");
	    	
	    
	    }
	    @FXML
	    void NextTripBooking(ActionEvent event) {
	    	trip = tv1.getSelectionModel().getSelectedItem();
	    	 if(trip instanceof Trip){
	    	Hotelpane.setVisible(false);
	    	Room.setVisible(false);
	    	Booking.setVisible(false);
	    	Progression.setVisible(false);
	    	tripBookingpane.setVisible(false);
	    	progbartrip1.setProgress(0.5);
	    	tripBookingpane1.setVisible(true);
	    	 }
	    	 else{
	    		 Notifications notification14 = Notifications.create()
	                     .title("Attention")
	                     .text("SVP Selectionner Tip")
	                     .graphic(null)
	                     .hideAfter(Duration.seconds(5))
	                     .position(Pos.BOTTOM_RIGHT);

	    		 notification14.darkStyle();
	    		 notification14.showError();
	    	 }

	    }
	    @FXML
	    void tripBooking(ActionEvent event) {
	    	Hotelpane.setVisible(false);
	    	Room.setVisible(false);
	    	Booking.setVisible(false);
	    	Progression.setVisible(false);
	    	tripBookingpane.setVisible(true); 	
	    	progbartrip.setProgress(-1.0f);
	    	LoadData();
	    }
	    @FXML
	    void finishtrip(ActionEvent event) {
	    	String jndiName="esprit1718b3tourism-ear/esprit1718b3tourism-service/TripBookingService!tn.esprit.b3.esprit1718b3tourism.services.TripBookingServiceRemote";
	    	String jndiName3 = "esprit1718b3tourism-ear/esprit1718b3tourism-service/TripRatingService!tn.esprit.b3.esprit1718b3tourism.services.TripRatingServiceRemote";
	    	String jndiName4 = "esprit1718b3tourism-ear/esprit1718b3tourism-service/TripService!tn.esprit.b3.esprit1718b3tourism.services.TripServiceRemote";
	    	 Context context;
			 Context context3;
			 Context context4;
			 if(trip.getPlaces()>Integer.parseInt(tf2.getText())){ 
			try {
				context = new InitialContext();
			    context3 = new InitialContext();
			    context4 = new InitialContext();
			
			   TripBookingServiceRemote proxy4 = (TripBookingServiceRemote) context.lookup(jndiName);
			 TripRatingServiceRemote proxy5 = (TripRatingServiceRemote) context3.lookup(jndiName3);
			 TripServiceRemote proxy15 = (TripServiceRemote) context4.lookup(jndiName4);
			 TripRating tr = new TripRating(Hotelrate1.getRating(), trip);
				LocalDate localDate = LocalDate.now();
				java.util.Date date = java.util.Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
			 TripBooking_Pk tpk = new TripBooking_Pk(LoginController.getUser().getId(),trip.getIdTrip(),Integer.parseInt(tf2.getText()));
			 TripBooking tb = new TripBooking(tpk, LoginController.getUser(), trip,date);
			 trip.setPlaces(trip.getPlaces()-Integer.parseInt(tf2.getText()));
			 proxy15.update(trip);

			 proxy4.save(tb);
			 progbartrip.setProgress(1.0);
			 proxy5.save(tr);
				
		    } catch (NamingException e) {
				e.printStackTrace();
			}
			Home.setVisible(true);
			Hotelpane.setVisible(false);
	    	Room.setVisible(false);
	    	Booking.setVisible(false);
	    	tripBookingpane1.setVisible(false);
	    	Progression.setVisible(false);
	    	progbartrip.setProgress(0.0f);
			}
			 else{
	    		 Notifications notification13 = Notifications.create()
	                     .title("Attention")
	                     .text("Nombre De Places Tres grand")
	                     .graphic(null)
	                     .hideAfter(Duration.seconds(5))
	                     .position(Pos.BOTTOM_RIGHT);

	    		 notification13.darkStyle();
	    		 notification13.showError();
	    	 }
	    	
	    	
	    	
	    }
	    @FXML
	    void EventBooking(ActionEvent event) {
	    	Hotelpane.setVisible(false);
	    	Room.setVisible(false);
	    	Booking.setVisible(false);
	    	tripBookingpane1.setVisible(false);
	    	Progression.setVisible(false);
	    	Eventbookingpane.setVisible(true);	    	
	    	LoadDataEvent();
	    }

	    @FXML
	    void NextEventBooking(ActionEvent event) {

	    	e = tab.getSelectionModel().getSelectedItem();
	    	if(e instanceof Event){
	    	EventBookingpane2.setVisible(true);
	    	Hotelpane.setVisible(false);
	    	Room.setVisible(false);
	    	Booking.setVisible(false);
	    	tripBookingpane1.setVisible(false);
	    	Progression.setVisible(false);
	    	Eventbookingpane.setVisible(false);}
	    	else{
	    		 Notifications notification16 = Notifications.create()
	                     .title("Attention")
	                     .text("SVP Selectionner un Event")
	                     .graphic(null)
	                     .hideAfter(Duration.seconds(5))
	                     .position(Pos.BOTTOM_RIGHT);

	    		 notification16.darkStyle();
	    		 notification16.showError();
	    	 }

	    }

	    @FXML
	    void finishevent(ActionEvent event) {

	    	String jndiName="esprit1718b3tourism-ear/esprit1718b3tourism-service/EventBookingService!tn.esprit.b3.esprit1718b3tourism.services.EventBookingServiceRemote";
	    	String jndiName3 = "esprit1718b3tourism-ear/esprit1718b3tourism-service/EventRatingService!tn.esprit.b3.esprit1718b3tourism.services.EventRatingServiceRemote";
	    	String jndiName4 = "esprit1718b3tourism-ear/esprit1718b3tourism-service/EventService!tn.esprit.b3.esprit1718b3tourism.services.EventServiceRemote";
	    	 Context context;
			 Context context3;
			 Context context4;
			 if(e.getEventPlaces()>Integer.parseInt(tf21.getText())){ 
			 
			try {
				context = new InitialContext();
			    context3 = new InitialContext();
			    context4= new InitialContext();
			    EventServiceRemote proxy16 = (EventServiceRemote) context4.lookup(jndiName4);
			   EventBookingServiceRemote proxy6 = (EventBookingServiceRemote) context.lookup(jndiName);
			 EventRatingServiceRemote proxy7 = (EventRatingServiceRemote) context3.lookup(jndiName3);
			 e.setEventPlaces(e.getEventPlaces()-Integer.parseInt(tf21.getText()));
			 proxy16.update(e);
			 EventRating er = new EventRating(Hotelrate11.getRating(), e);
			 proxy7.save(er);
			 EventBooking_PK epk = new EventBooking_PK(LoginController.getUser().getId(), e.getIdEvent(),Integer.parseInt(tf21.getText()));
			EventBooking eb = new EventBooking(epk, LoginController.getUser(), e);
			proxy6.save(eb);
			 
			 
			} catch (NamingException e) {
				e.printStackTrace();
			}
			Home.setVisible(true);
			Hotelpane.setVisible(false);
	    	Room.setVisible(false);
	    	Booking.setVisible(false);
	    	tripBookingpane1.setVisible(false);
	    	Progression.setVisible(false);
	    	Eventbookingpane.setVisible(false);
	    	tripBookingpane.setVisible(false); 
	    	EventBookingpane2.setVisible(false);
			 }
			 else{
	    		 Notifications notification13 = Notifications.create()
	                     .title("Attention")
	                     .text("Nombre De Places Tres grand")
	                     .graphic(null)
	                     .hideAfter(Duration.seconds(5))
	                     .position(Pos.BOTTOM_RIGHT);

	    		 notification13.darkStyle();
	    		 notification13.showError();
	    	 }
	    }
	    

              @FXML
            void RestaurantBooking(ActionEvent event) {

            	  Hotelpane.setVisible(false);
            	Room.setVisible(false);
            	Booking.setVisible(false);
            	tripBookingpane1.setVisible(false);
            	Progression.setVisible(false);
            	Eventbookingpane.setVisible(false);
            	tripBookingpane.setVisible(false); 
            	EventBookingpane2.setVisible(false);
            	restopane.setVisible(true);
            	LoadDataRestaurant();
            	
            }

	    
	    
	    @FXML
	    void NextRestaurantBooking(ActionEvent event) {
	    	resto = tabr.getSelectionModel().getSelectedItem();
      	  if(resto instanceof Restaurant){
	    	Hotelpane.setVisible(false);
	    	Room.setVisible(false);
	    	Booking.setVisible(false);
	    	tripBookingpane1.setVisible(false);
	    	Progression.setVisible(false);
	    	Eventbookingpane.setVisible(false);
	    	tripBookingpane.setVisible(false); 
	    	EventBookingpane2.setVisible(false);
	    	restopane.setVisible(false);
	    	restopane1.setVisible(true);
	    	LoadDatatable();}
	    	else{
	    		 Notifications notification17 = Notifications.create()
	                     .title("Attention")
	                     .text("SVP Selectionner un Restaurant")
	                     .graphic(null)
	                     .hideAfter(Duration.seconds(5))
	                     .position(Pos.BOTTOM_RIGHT);

	    		 notification17.darkStyle();
	    		 notification17.showError();
	    	 }

	    }
	    @FXML
	    void NextRestaurantBooking1(ActionEvent event) {
	    	taler = tab11.getSelectionModel().getSelectedItem();
	    	if(taler instanceof TableR){
	    	Hotelpane.setVisible(false);
	    	Room.setVisible(false);
	    	Booking.setVisible(false);
	    	tripBookingpane1.setVisible(false);
	    	Progression.setVisible(false);
	    	Eventbookingpane.setVisible(false);
	    	tripBookingpane.setVisible(false); 
	    	EventBookingpane2.setVisible(false);
	    	restopane.setVisible(false);
	    	restopane1.setVisible(false);
	    	restopane2.setVisible(true);
	    	}
	    	else{
	    		 Notifications notification18 = Notifications.create()
	                     .title("Attention")
	                     .text("SVP Selectionner une Table")
	                     .graphic(null)
	                     .hideAfter(Duration.seconds(5))
	                     .position(Pos.BOTTOM_RIGHT);

	    		 notification18.darkStyle();
	    		 notification18.showError();
	    	 }


	    }
	    @FXML
	    void finishresto(ActionEvent event) {
	    	String jndiName="esprit1718b3tourism-ear/esprit1718b3tourism-service/TableBookingService!tn.esprit.b3.esprit1718b3tourism.services.TableBookingServiceRemote";
	    	String jndiName3 = "esprit1718b3tourism-ear/esprit1718b3tourism-service/RestaurantRatingService!tn.esprit.b3.esprit1718b3tourism.services.RestaurantRatingServiceRemote";
	    	String jndiName4 = "esprit1718b3tourism-ear/esprit1718b3tourism-service/TableRService!tn.esprit.b3.esprit1718b3tourism.services.TableRServiceRemote";
	    	 Context context;

			 Context context3;
			 Context context4;
			 
			try {
				context = new InitialContext();

			    context3 = new InitialContext();
			    context4 = new InitialContext();
			    
			    TableRServiceRemote proxy20 = (TableRServiceRemote) context4.lookup(jndiName4);
			    TableBookingServiceRemote proxy6 = (TableBookingServiceRemote) context.lookup(jndiName);

			 RestaurantRatingServiceRemote proxy7 = (RestaurantRatingServiceRemote) context3.lookup(jndiName3);
			 taler.setAvailable("false");
			 taler.setRestaurantT(resto);
			 proxy20.update(taler);
			 RestaurantRating rr = new RestaurantRating(Hotelrate111.getRating(), resto);
			 proxy7.save(rr);
			 java.util.Date date = java.util.Date.from(dp2.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
			 TableBooking_Pk tpk = new TableBooking_Pk(LoginController.getUser().getId(), taler.getIdTable(), date);
			 TableBooking tb = new TableBooking(tpk, LoginController.getUser(), taler);
			proxy6.save(tb);
			 
			 
			} catch (NamingException e) {
				e.printStackTrace();
			}
			Home.setVisible(true);
			Hotelpane.setVisible(false);
	    	Room.setVisible(false);
	    	Booking.setVisible(false);
	    	tripBookingpane1.setVisible(false);
	    	Progression.setVisible(false);
	    	Eventbookingpane.setVisible(false);
	    	tripBookingpane.setVisible(false); 
	    	EventBookingpane2.setVisible(false);
	    	restopane.setVisible(false);
	    	restopane1.setVisible(false);
	    	restopane2.setVisible(false);
	    	

	    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	Home.setVisible(true);
    	Hotelpane.setVisible(false);
    	Room.setVisible(false);
    	Booking.setVisible(false);
    	tripBookingpane1.setVisible(false);
    	Progression.setVisible(false);
    	Eventbookingpane.setVisible(false);
    	tripBookingpane.setVisible(false); 
    	EventBookingpane2.setVisible(false);
    	restopane.setVisible(false);
    	restopane1.setVisible(false);
    	restopane2.setVisible(false);
    	Room1.setVisible(false);

    	
    	progbartrip.setProgress(0.0f);
    	Hotelrate.ratingProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
            	lHotelrate.setText("Rating : "+ t1.toString());
            }
        });
    	Hotelrate1.ratingProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
            	lHotelrate1.setText("Rating : "+ t1.toString());
            }
        });
    	Hotelrate11.ratingProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
            	lHotelrate11.setText("Rating : "+ t1.toString());
            }
        });

    	Hotelrate111.ratingProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
            	lHotelrate111.setText("Rating : "+ t1.toString());
            }
        });
    	
    }
    public void LoadDatahotel() {
    	tab1.setVisible(true);
		 String jndiName="esprit1718b3tourism-ear/esprit1718b3tourism-service/HotelService!tn.esprit.b3.esprit1718b3tourism.services.HotelServiceRemote";
		 

		 Context context;
		try {
			context = new InitialContext();
		
		 HotelServiceRemote proxy =(HotelServiceRemote) context.lookup(jndiName);
		 List<Hotel>list;
		 ObservableList<Hotel> list1 = FXCollections.observableArrayList();
		 list=proxy.FindByEtat(true);
		 for(int i = 0; i < list.size(); i++){
			 
			 list1.add(new Hotel(list.get(i).getIdHotel(),list.get(i).getHotelName(),list.get(i).getStars(),list.get(i).getRoomNbr(),list.get(i).getAdresse(),list.get(i).getCountry(),list.get(i).getState(),list.get(i).getDescription(),list.get(i).getPhone(),list.get(i).getEtat()));
			 tab1.setItems(list1);
			
		 }
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nameC.setCellValueFactory(new PropertyValueFactory<>("hotelName"));
		starC.setCellValueFactory(new PropertyValueFactory<>("stars"));
		roomnbrC.setCellValueFactory(new PropertyValueFactory<>("roomNbr"));
		adresseC.setCellValueFactory(new PropertyValueFactory<>("adresse"));
		StateC.setCellValueFactory(new PropertyValueFactory<>("state"));
		countryC.setCellValueFactory(new PropertyValueFactory<>("country"));
		descC.setCellValueFactory(new PropertyValueFactory<>("description"));
		PhoneC.setCellValueFactory(new PropertyValueFactory<>("phone"));
    	
	    }
    public void LoadDataRoom() {
    	tab2.setVisible(true);
		 String jndiName="esprit1718b3tourism-ear/esprit1718b3tourism-service/RoomService!tn.esprit.b3.esprit1718b3tourism.services.RoomServiceRemote";

		 Context context;
		try {
			context = new InitialContext();
		
		 RoomServiceRemote proxy =(RoomServiceRemote) context.lookup(jndiName);
		 List<Room>list;
		 ObservableList<Room>list1 = FXCollections.observableArrayList();
		 list=proxy.findAll();
		 for(int i = 0; i < list.size(); i++){
			 if(list.get(i).getHotel().getIdHotel()==h.getIdHotel()&&list.get(i).getAvailable()==true)
			 {list1.add(new Room(list.get(i).getIdRoom(),list.get(i).getType(),list.get(i).getPrice(),list.get(i).getAvailable(),list.get(i).getVip(),list.get(i).getHotelManager(),list.get(i).getHotel()));
			 tab2.setItems(list1);
			 }
			
		 }
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		typeC.setCellValueFactory(new PropertyValueFactory<>("type"));
		priceC.setCellValueFactory(new PropertyValueFactory<>("price"));

		vipC.setCellValueFactory(new PropertyValueFactory<>("vip"));
		
	    }
   
public void LoadData() {
    
    tv1.setVisible(true);
    String jndiName="esprit1718b3tourism-ear/esprit1718b3tourism-service/TripService!tn.esprit.b3.esprit1718b3tourism.services.TripServiceRemote";
	  try {
		 Context context=new InitialContext();
		 TripServiceRemote proxy = (TripServiceRemote) context.lookup(jndiName);

		
		
		 List<Trip> list ;
		ObservableList<Trip> list1 = FXCollections.observableArrayList();
		list=proxy.findAll() ;
		for(int i = 0; i < list.size(); i++){
		list1.add(new Trip(list.get(i).getIdTrip(),list.get(i).getDestination(),list.get(i).getTravelDate(),list.get(i).getReturnDate(),list.get(i).getPrice(),list.get(i).getPlaces(),list.get(i).getImg(),list.get(i).getHomecountry(),list.get(i).getDestinationcountry(), list.get(i).getFlight()));	
		tv1.setItems(list1);
		System.out.println(list1);
		}
		
	} catch (NamingException e) {
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
	   tc19.setCellValueFactory(new Callback<CellDataFeatures<Trip,String>,ObservableValue<String>>(){

       @Override
       public ObservableValue<String> call(CellDataFeatures<Trip, String> param) {
           return new SimpleStringProperty(param.getValue().getFlight().getDestinationCityF());
       }
   });

}
public void LoadDataEvent() {

    tab.setVisible(true);
    String jndiName="esprit1718b3tourism-ear/esprit1718b3tourism-service/EventService!tn.esprit.b3.esprit1718b3tourism.services.EventServiceRemote";
	  try {
		 Context context=new InitialContext();
		EventServiceRemote proxy = (EventServiceRemote) context.lookup(jndiName);
		List<Event> list =proxy.findAll();
		ObservableList<Event> list1 = FXCollections.observableArrayList();
		for(int i = 0; i < list.size(); i++){
		list1.add(new Event(list.get(i).getIdEvent(),list.get(i).getEventName(),list.get(i).getEventDescription(),list.get(i).getEventPlaces(),list.get(i).getStatus(),list.get(i).getPrice(),list.get(i).getSponsorshipMoney(),list.get(i).getDatedebut(),list.get(i).getDatefin()));
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
      colonedebut.setCellValueFactory(new PropertyValueFactory<>("datedebut"));
       colonefin.setCellValueFactory(new PropertyValueFactory<>("datefin"));

}
public void LoadDataRestaurant() {

    tabr.setVisible(true);
    String jndiName="esprit1718b3tourism-ear/esprit1718b3tourism-service/RestaurantService!tn.esprit.b3.esprit1718b3tourism.services.RestaurantServiceRemote";
	  try {
		 Context context=new InitialContext();
		 RestaurantServiceRemote proxy8= (RestaurantServiceRemote) context.lookup(jndiName);
		List<Restaurant> list =proxy8.findAll();
		ObservableList<Restaurant> list1 = FXCollections.observableArrayList();
		for(int i = 0; i < list.size(); i++){
		list1.add(new Restaurant(list.get(i).getIdRestaurant(),list.get(i).getName(),list.get(i).getAddress(),list.get(i).getEmail(),list.get(i).getPhone()));
		tabr.setItems(list1);
		 
		}
	} catch (NamingException e) {
		 //TODO Auto-generated catch block
		e.printStackTrace();
	}
	namer.setCellValueFactory(new PropertyValueFactory<>("name"));
	addressr.setCellValueFactory(new PropertyValueFactory<>("address"));
	emailr.setCellValueFactory(new PropertyValueFactory<>("email"));
	phoner.setCellValueFactory(new PropertyValueFactory<>("Phone"));
    

}

public void LoadDatatable() {
    
	  tab11.setVisible(true);
	  String jndiName1="esprit1718b3tourism-ear/esprit1718b3tourism-service/TableRService!tn.esprit.b3.esprit1718b3tourism.services.TableRServiceRemote";

	  try {
		 Context context=new InitialContext();
		  TableRServiceRemote proxy1 =( TableRServiceRemote)context.lookup(jndiName1); 
		List<TableR> lsTable ;
		ObservableList<TableR> list1 = FXCollections.observableArrayList();
		lsTable=proxy1.findAll(); //findTableByRestaurant
		for(int i = 0; i < lsTable.size(); i++){
			if(lsTable.get(i).getRestaurantT().getIdRestaurant()==resto.getIdRestaurant()&&lsTable.get(i).getAvailable().equals("true")){
		list1.add(new TableR(lsTable.get(i).getIdTable(),lsTable.get(i).getNumber(),lsTable.get(i).getPlaces(),lsTable.get(i).getDescription(),lsTable.get(i).getAvailable()));	
		tab11.setItems(list1);
			}
	}
} catch (NamingException e) {

	e.printStackTrace();
}
columnNumber.setCellValueFactory(new PropertyValueFactory<>("number"));
columnPlaces.setCellValueFactory(new PropertyValueFactory<>("places"));
columnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
columnAvailable.setCellValueFactory(new PropertyValueFactory<>("available"));


}
@FXML
void Acceuil(ActionEvent event) throws IOException {
	 FXMLLoader loader = new FXMLLoader(getClass().getResource("AccueilClient.fxml"));
	    Parent root = loader.load();
	    AccueilClientController tsController = loader.getController();
	    Acceuil.getScene().setRoot(root);
}
private List<HotelBooking> ls ;
private int k =0;
private HotelBooking h12;
@FXML
void checkBooking(ActionEvent event) {
	Room1.setVisible(true);

	 String jndiName1="esprit1718b3tourism-ear/esprit1718b3tourism-service/HotelBookingService!tn.esprit.b3.esprit1718b3tourism.services.HotelBookingServiceRemote";

	 try {
		 Context context=new InitialContext();
		 HotelBookingServiceRemote proxy1 =( HotelBookingServiceRemote)context.lookup(jndiName1); 
		
		ObservableList<HotelBooking> list1 = FXCollections.observableArrayList();
		ls=proxy1.findAll(); 
		for(int i = 0; i < 1; i++){
		list1.add(new HotelBooking(ls.get(i).getHotelpk(), ls.get(i).getDaynbr()));
		h12 = new HotelBooking(ls.get(i).getHotelpk(), ls.get(i).getDaynbr());
		tf11.setText(ls.get(i).getDaynbr().toString());
		resl.setText(ls.get(i).getHotelpk().getArrivedate().toString());
		i=k;
		
			}		
	 }

	  catch (NamingException e) {

	e.printStackTrace();
}
	
	
}
@FXML
void Update(ActionEvent event) {

           
	String jndiName1="esprit1718b3tourism-ear/esprit1718b3tourism-service/HotelBookingService!tn.esprit.b3.esprit1718b3tourism.services.HotelBookingServiceRemote";

	 try {
		 Context context=new InitialContext();
		 HotelBookingServiceRemote proxy1 =( HotelBookingServiceRemote)context.lookup(jndiName1); 
		 java.util.Date date = java.util.Date.from(dp11.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
		 HotelBooking_Pk hpkx = new HotelBooking_Pk(LoginController.getUser().getId(),ls.get(k).getH().getIdRoom(),date);
		 HotelBooking hbx = new HotelBooking(hpkx,Integer.valueOf(tf11.getText()),LoginController.getUser(),ls.get(k).getH());
		proxy1.delete(h12);	
		 proxy1.update(hbx);	
	 }

	  catch (NamingException e) {

	e.printStackTrace();
}
    }
@FXML
void Delete(ActionEvent event) {

           
	String jndiName1="esprit1718b3tourism-ear/esprit1718b3tourism-service/HotelBookingService!tn.esprit.b3.esprit1718b3tourism.services.HotelBookingServiceRemote";

	 try {
		 Context context=new InitialContext();
		 HotelBookingServiceRemote proxy1 =( HotelBookingServiceRemote)context.lookup(jndiName1); 
		proxy1.delete(h12);	

	 }

	  catch (NamingException e) {

	e.printStackTrace();
}
    }
}