package tn.esprit.b3.esprit1718b3tourism.app.client.gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tn.esprit.b3.esprit1718b3tourism.entities.Tripopinion;
import tn.esprit.b3.esprit1718b3tourism.services.TripopinionServiceRemote;

public class AccueilAgenceController implements Initializable {
	 @FXML
	    private HBox hb1;

	    @FXML
	    private Text l1;

	    @FXML
	    private Text l2;

	    @FXML
	    private Text l3;

	    @FXML
	    private Text l4;

	    @FXML
	    private Text l10;

	    @FXML
	    private Text l20;

	    @FXML
	    private Text l30;

	    @FXML
	    private Text l40;

	    @FXML
	    private ImageView iv1;

	    @FXML
	    private Text l13;

	    @FXML
	    private Text l23;

	    @FXML
	    private Text l33;

	    @FXML
	    private Text l43;

	    @FXML
	    private ImageView iv4;

	    @FXML
	    private Text l11;

	    @FXML
	    private Text l21;

	    @FXML
	    private Text l31;

	    @FXML
	    private Text l41;

	    @FXML
	    private ImageView iv2;

	    @FXML
	    private Text l14;

	    @FXML
	    private Text l24;

	    @FXML
	    private Text l34;

	    @FXML
	    private Text l44;

	    @FXML
	    private ImageView iv5;

	    @FXML
	    private Text l12;

	    @FXML
	    private Text l22;

	    @FXML
	    private Text l32;

	    @FXML
	    private Text l42;

	    @FXML
	    private ImageView iv3;

	    @FXML
	    private Text l15;

	    @FXML
	    private Text l25;

	    @FXML
	    private Text l35;

	    @FXML
	    private Text l45;

	    @FXML
	    private ImageView iv6;
    javafx.scene.image.Image image = new javafx.scene.image.Image(getClass().getResource("barcelona.png").toExternalForm());
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		//iv1.setImage(image);
		voirstat();
	}
	void voirstat(){
		int nb1=0;
		int nb2=0;
		int nb3=0;
		int nb4=0;
		int nb5=0;
		int nb6=0;
		float nb11=0;
		float nb22=0;
		float nb33=0;
		float nb44=0;
		float nb55=0;
		float nb66=0;
		float nb111=0;
		float nb222=0;
		float nb333=0;
		float nb444=0;
		float nb555=0;
		float nb666=0;
		String jndiName="esprit1718b3tourism-ear/esprit1718b3tourism-service/TripopinionService!tn.esprit.b3.esprit1718b3tourism.services.TripopinionServiceRemote";
  	  try {
  		 Context context=new InitialContext();
  		 TripopinionServiceRemote proxy = (TripopinionServiceRemote) context.lookup(jndiName);
  		 List<Tripopinion> list1;
  		 list1 = proxy.findAll();
  		List<Tripopinion> list4;
  		list4 = proxy.stat1("Absolutely");
  		ObservableList<String> list2 = FXCollections.observableArrayList();
  		ObservableList<String> list3 = FXCollections.observableArrayList();
  		float n100=0;
  		float n101=0;
  		n100=list4.size();
  		n101=list1.size();
  		
  		float f100=(n100/n101)*100;
  		l3.setText(f100+"% Like it");
  		int n106=Math.round(n101);
  		l1.setText(n106+"");
  		float n102=0;
  		for(int i = 0; i < list1.size(); i++){
  			list2.add(list1.get(i).getTrip().getDestination());
  			list3.add(list1.get(i).getTrip().getDestination());
  			n102=n102+list1.get(i).getRateag();
  		}
  		
  		l2.setText(n102/n101+"/5");
  		
  		System.out.println(list2);
 String[] tabp= new String[6]; 	
 int w=0; 		
 while(list2.size()!=0){
  			
  		String destf1="";
  		int k=0;
  		int n=0 ;
  		for(int i = 0; i < list2.size(); i++){
  			String deste=list2.get(i);
  			k=0;	
  			
  			for(int j = 0; j < list2.size(); j++){
  				if (deste==list2.get(j))
  					
  					k=k+1;
  					if (k>n)
  		  				{n=k;
  		  				destf1=deste;
  		  				tabp[w]=destf1;
  		  				
  		  				}
  					
  			}
  			
  			
  		
  			
  	}
  		System.out.println("hahahhaaha");
			System.out.println(destf1);
			System.out.println(list2.size());
			for(int l = 0; l < list2.size(); l++){
				if (list2.get(l).equals(destf1))
				{	list2.remove(l);
				l--;
				}
				System.out.println(list2);
				System.out.println(list2.size());
				}
			w++;
  		}
 System.out.println("hahaha");
 System.out.println(w);
  		
		if (w==1)	{
			
			javafx.scene.image.Image image1 = new javafx.scene.image.Image(getClass().getResource(tabp[0]+".png").toExternalForm());
  			iv1.setImage(image1);
			l10.setText(tabp[0]);
			for (int i=0;i<list3.size();i++){
				if (tabp[0].equals(list3.get(i))){
					nb1++;
					nb111=nb111+list1.get(i).getRatedest();
				}
			l20.setText(nb1+ " Person Went to that destination");			
			}
			for (int i=0;i<list4.size();i++){
				if (tabp[0].equals(list1.get(i).getTrip().getDestination())){
					nb11++;
					
					
				}
				
			}
			float f1=nb111/nb1;
			l30.setText(f1+"/5");
			float f2=(nb11/nb1)*100;
			l40.setText(f2+"% Like it");
			l20.setText(nb1+ " Person Went there");
			
		}
		if (w==2)	{
			javafx.scene.image.Image image1 = new javafx.scene.image.Image(getClass().getResource(tabp[0]+".png").toExternalForm());
  			iv1.setImage(image1);
			l10.setText(tabp[0]);
			javafx.scene.image.Image image2 = new javafx.scene.image.Image(getClass().getResource(tabp[1]+".png").toExternalForm());
			iv2.setImage(image2);
			l11.setText(tabp[1]);
		
			for (int i=0;i<list3.size();i++){
				if (tabp[0].equals(list3.get(i))){
					nb1++;
					nb111++;
				}
				if (tabp[1].equals(list3.get(i))){
					nb2++;
					nb222++;
				}
		
			l20.setText(nb1+ " Person Went to that destination");
			l21.setText(nb2+ " Person Went to that destination");
		
			}
			for (int i=0;i<list4.size();i++){
				if (tabp[0].equals(list1.get(i).getTrip().getDestination())){
					nb11++;
				}
				if (tabp[1].equals(list1.get(i).getTrip().getDestination())){
					nb22++;
				}
				
				float f1=nb111/nb1;
				l30.setText(f1+"/5");
				float f2=(nb11/nb1)*100;
				l40.setText(f2+"% Like it");
				float f3=nb222/nb2;				
				l31.setText(f3+"/5");
				float f4=(nb22/nb2)*100;
				l41.setText(f4+"% Like it");
				l20.setText(nb1+ " Person Went there");
				l21.setText(nb2+ " Person Went there");
				
			}
		}
		if (w==3)	{
			javafx.scene.image.Image image1 = new javafx.scene.image.Image(getClass().getResource(tabp[0]+".png").toExternalForm());
  			iv1.setImage(image1);
			l10.setText(tabp[0]);
			javafx.scene.image.Image image2 = new javafx.scene.image.Image(getClass().getResource(tabp[1]+".png").toExternalForm());
			iv2.setImage(image2);
			l11.setText(tabp[1]);
			javafx.scene.image.Image image3 = new javafx.scene.image.Image(getClass().getResource(tabp[2]+".png").toExternalForm());
			iv3.setImage(image3);
			l12.setText(tabp[2]);
			for (int i=0;i<list3.size();i++){
				if (tabp[0].equals(list3.get(i))){
					nb1++;
				}
				if (tabp[1].equals(list3.get(i))){
					nb2++;
				}
				if (tabp[2].equals(list3.get(i))){
					nb3++;
				}
		
			}
			for (int i=0;i<list4.size();i++){
				if (tabp[0].equals(list1.get(i).getTrip().getDestination())){
					nb11++;
				}
				if (tabp[1].equals(list1.get(i).getTrip().getDestination())){
					nb22++;
				}
				if (tabp[2].equals(list1.get(i).getTrip().getDestination())){
					nb33++;
				}
				float f1=nb111/nb1;
				l30.setText(f1+"/5");
				float f2=(nb11/nb1)*100;
				l40.setText(f2+"% Like it");
				float f3=nb222/nb2;				
				l31.setText(f3+"/5");
				float f4=(nb22/nb2)*100;
				l41.setText(f4+"% Like it");
				float f5=nb333/nb3;
				l32.setText(f5+"/5");
				float f6=(nb33/nb3)*100;
				l42.setText(f6+"% Like it");
				
				
				l20.setText(nb1+ " Person Went there");
				l21.setText(nb2+ " Person Went there");
				l22.setText(nb3+ " Person Went there");
				
			
				
			}
			
		}
		if (w==4)	{
			javafx.scene.image.Image image1 = new javafx.scene.image.Image(getClass().getResource(tabp[0]+".png").toExternalForm());
  			iv1.setImage(image1);
			l10.setText(tabp[0]);
			javafx.scene.image.Image image2 = new javafx.scene.image.Image(getClass().getResource(tabp[1]+".png").toExternalForm());
			iv2.setImage(image2);
			l11.setText(tabp[1]);
			javafx.scene.image.Image image3 = new javafx.scene.image.Image(getClass().getResource(tabp[2]+".png").toExternalForm());
			iv3.setImage(image3);
			l12.setText(tabp[2]);
			javafx.scene.image.Image image4 = new javafx.scene.image.Image(getClass().getResource(tabp[3]+".png").toExternalForm());
			iv3.setImage(image4);
			l12.setText(tabp[3]);
			for (int i=0;i<list3.size();i++){
				if (tabp[0].equals(list3.get(i))){
					nb1++;
				}
				if (tabp[1].equals(list3.get(i))){
					nb2++;
				}
				if (tabp[2].equals(list3.get(i))){
					nb3++;
				}
				if (tabp[3].equals(list3.get(i))){
					nb4++;
				}
				
			
		
			}
			for (int i=0;i<list4.size();i++){
				if (tabp[0].equals(list1.get(i).getTrip().getDestination())){
					nb11++;
				}
				if (tabp[1].equals(list1.get(i).getTrip().getDestination())){
					nb22++;
				}
				if (tabp[2].equals(list1.get(i).getTrip().getDestination())){
					nb33++;
				}
				if (tabp[3].equals(list1.get(i).getTrip().getDestination())){
					nb44++;
				}
				float f1=nb111/nb1;
				l30.setText(f1+"/5");
				float f2=(nb11/nb1)*100;
				l40.setText(f2+"% Like it");
				float f3=nb222/nb2;				
				l31.setText(f3+"/5");
				float f4=(nb22/nb2)*100;
				l41.setText(f4+"% Like it");
				float f5=nb333/nb3;
				l32.setText(f5+"/5");
				float f6=(nb33/nb3)*100;
				l42.setText(f6+"% Like it");
				float f7=nb444/nb4;
				l33.setText(f7+"/5");
				float f8=(nb44/nb4)*100;
				l43.setText(f8+"% Like it");
				l20.setText(nb1+ " Person Went there");
				l21.setText(nb2+ " Person Went there");
				l22.setText(nb3+ " Person Went there");
				l23.setText(nb4+ " Person Went there");
				
				
				
			}
			
		}
		if (w==5)	{
			javafx.scene.image.Image image1 = new javafx.scene.image.Image(getClass().getResource(tabp[0]+".png").toExternalForm());
  			iv1.setImage(image1);
			l10.setText(tabp[0]);
			javafx.scene.image.Image image2 = new javafx.scene.image.Image(getClass().getResource(tabp[1]+".png").toExternalForm());
			iv2.setImage(image2);
			l11.setText(tabp[1]);
			javafx.scene.image.Image image3 = new javafx.scene.image.Image(getClass().getResource(tabp[2]+".png").toExternalForm());
			iv3.setImage(image3);
			l12.setText(tabp[2]);
			javafx.scene.image.Image image4 = new javafx.scene.image.Image(getClass().getResource(tabp[3]+".png").toExternalForm());
			iv4.setImage(image4);
			l13.setText(tabp[3]);
			javafx.scene.image.Image image5 = new javafx.scene.image.Image(getClass().getResource(tabp[4]+".png").toExternalForm());
			iv5.setImage(image5);
			l14.setText(tabp[4]);
			for (int i=0;i<list3.size();i++){
				if (tabp[0].equals(list3.get(i))){
					nb1++;
				}
				if (tabp[1].equals(list3.get(i))){
					nb2++;
				}
				if (tabp[2].equals(list3.get(i))){
					nb3++;
				}
				if (tabp[3].equals(list3.get(i))){
					nb4++;
				}
				if (tabp[4].equals(list3.get(i))){
					nb5++;
				}
				
			}
			for (int i=0;i<list4.size();i++){
				if (tabp[0].equals(list1.get(i).getTrip().getDestination())){
					nb11++;
				}
				if (tabp[1].equals(list1.get(i).getTrip().getDestination())){
					nb22++;
				}
				if (tabp[2].equals(list1.get(i).getTrip().getDestination())){
					nb33++;
				}
				if (tabp[3].equals(list1.get(i).getTrip().getDestination())){
					nb44++;
				}
				if (tabp[4].equals(list1.get(i).getTrip().getDestination())){
					nb55++;
				}
				float f1=nb111/nb1;
				l30.setText(f1+"/5");
				float f2=(nb11/nb1)*100;
				l40.setText(f2+"% Like it");
				float f3=nb222/nb2;				
				l31.setText(f3+"/5");
				float f4=(nb22/nb2)*100;
				l41.setText(f4+"% Like it");
				float f5=nb333/nb3;
				l32.setText(f5+"/5");
				float f6=(nb33/nb3)*100;
				l42.setText(f6+"% Like it");
				float f7=nb444/nb4;
				l33.setText(f7+"/5");
				float f8=(nb44/nb4)*100;
				l43.setText(f8+"% Like it");
				float f9=nb555/nb5;
				l34.setText(f9+"/5");
				float f10=(nb55/nb5)*100;
				l44.setText(f10+"% Like it");
				l20.setText(nb1+ " Person Went there");
				l21.setText(nb2+ " Person Went there");
				l22.setText(nb3+ " Person Went there");
				l23.setText(nb4+ " Person Went there");
				l24.setText(nb5+ " Person Went there");	
					
				
				
				
			}
		}
  		if(w==6){
  			javafx.scene.image.Image image1 = new javafx.scene.image.Image(getClass().getResource(tabp[0]+".png").toExternalForm());
  			iv1.setImage(image1);
			l10.setText(tabp[0]);
			javafx.scene.image.Image image2 = new javafx.scene.image.Image(getClass().getResource(tabp[1]+".png").toExternalForm());
			iv2.setImage(image2);
			l11.setText(tabp[1]);
			javafx.scene.image.Image image3 = new javafx.scene.image.Image(getClass().getResource(tabp[2]+".png").toExternalForm());
			iv3.setImage(image3);
			l12.setText(tabp[2]);
			l13.setText(tabp[3]);
			l14.setText(tabp[4]);
			l15.setText(tabp[5]);
			javafx.scene.image.Image image4 = new javafx.scene.image.Image(getClass().getResource(tabp[3]+".png").toExternalForm());
			iv4.setImage(image4);
			javafx.scene.image.Image image5 = new javafx.scene.image.Image(getClass().getResource(tabp[4]+".png").toExternalForm());
			iv5.setImage(image5);
			javafx.scene.image.Image image6 = new javafx.scene.image.Image(getClass().getResource(tabp[5]+".png").toExternalForm());
			iv6.setImage(image6);
			for (int i=0;i<list3.size();i++){
				if (tabp[0].equals(list3.get(i))){
					nb1++;
					nb111=nb111+list1.get(i).getRatedest();
					
				}
				if (tabp[1].equals(list3.get(i))){
					nb2++;
					nb222=nb333+list1.get(i).getRatedest();
				}
				if (tabp[2].equals(list3.get(i))){
					nb3++;
					nb333=nb333+list1.get(i).getRatedest();
				}
				if (tabp[3].equals(list3.get(i))){
					nb4++;
					nb444=nb444+list1.get(i).getRatedest();
				}
				if (tabp[4].equals(list3.get(i))){
					nb5++;
					nb555=nb555+list1.get(i).getRatedest();
				}
				if (tabp[5].equals(list3.get(i))){
					nb6++;
					nb666=nb666+list1.get(i).getRatedest();
				}
			
			}
			for (int i=0;i<list4.size();i++){
				if (tabp[0].equals(list1.get(i).getTrip().getDestination())){
					nb11++;
				}
				if (tabp[1].equals(list1.get(i).getTrip().getDestination())){
					nb22++;
				}
				if (tabp[2].equals(list1.get(i).getTrip().getDestination())){
					nb33++;
				}
				if (tabp[3].equals(list1.get(i).getTrip().getDestination())){
					nb44++;
				}
				if (tabp[4].equals(list1.get(i).getTrip().getDestination())){
					nb55++;
				}
				if (tabp[5].equals(list1.get(i).getTrip().getDestination())){
					nb66++;
				}
				float f1=nb111/nb1;
				l30.setText(f1+"/5");
				float f2=(nb11/nb1)*100;
				l40.setText(f2+"% Like it");
				float f3=nb222/nb2;				
				l31.setText(f3+"/5");
				float f4=(nb22/nb2)*100;
				l41.setText(f4+"% Like it");
				float f5=nb333/nb3;
				l32.setText(f5+"/5");
				float f6=(nb33/nb3)*100;
				l42.setText(f6+"% Like it");
				float f7=nb444/nb4;
				l33.setText(f7+"/5");
				float f8=(nb44/nb4)*100;
				l43.setText(f8+"% Like it");
				float f9=nb555/nb5;
				l34.setText(f9+"/5");
				float f10=(nb55/nb5)*100;
				l44.setText(f10+"% Like it");
				float f11=nb666/nb6;
				l35.setText(f11+"/5");
				float f12=(nb66/nb6)*100;
				l45.setText(f12+"% Like it");
				l20.setText(nb1+ " Person Went there");
				l21.setText(nb2+ " Person Went there");
				l22.setText(nb3+ " Person Went there");
				l23.setText(nb4+ " Person Went there");
				l24.setText(nb5+ " Person Went there");	
				l25.setText(nb6+ " Person Went there");	
				
			}
			}
			
			System.out.println(list2);
  	} catch (NamingException e) {
		 //TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
    @FXML
    private void gototripmanagement() {
    	 try {
             Parent root = FXMLLoader.load(getClass().getResource("tm.fxml"));
             Scene scene = new Scene(root);
             Stage stage = (Stage) hb1.getScene().getWindow();
             stage.setScene(scene);
             stage.show();
         } catch (IOException ex) {
             Logger.getLogger(TMController.class.getName()).log(Level.SEVERE, null, ex);
         }

    }
    @FXML
    private void gototripstats() {
    	 try {
             Parent root = FXMLLoader.load(getClass().getResource("ChartTrips.fxml"));
             Scene scene = new Scene(root);
             Stage stage = (Stage) hb1.getScene().getWindow();
             stage.setScene(scene);
             stage.show();
         } catch (IOException ex) {
             Logger.getLogger(TMController.class.getName()).log(Level.SEVERE, null, ex);
         }

    }
    @FXML
    private void gotochartall() {
    	 try {
             Parent root = FXMLLoader.load(getClass().getResource("UIall.fxml"));
             Scene scene = new Scene(root);
             Stage stage = (Stage) hb1.getScene().getWindow();
             stage.setScene(scene);
             stage.show();
         } catch (IOException ex) {
             Logger.getLogger(TMController.class.getName()).log(Level.SEVERE, null, ex);
         }

    }
}
