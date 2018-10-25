package tn.esprit.b3.esprit1718b3tourism.mBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import tn.esprit.b3.esprit1718b3tourism.entities.Countries;
import tn.esprit.b3.esprit1718b3tourism.entities.Hotel;
import tn.esprit.b3.esprit1718b3tourism.entities.HotelManager;
import tn.esprit.b3.esprit1718b3tourism.entities.User;
import tn.esprit.b3.esprit1718b3tourism.services.CountriesServiceLocal;
import tn.esprit.b3.esprit1718b3tourism.services.HotelServiceLocal;

@ManagedBean
@SessionScoped
public class Hotels {
	private Hotel hotel = new Hotel();
	
	public Hotels(){
		
	}
	
	@EJB
	private HotelServiceLocal hotelServiceLocal;
	
	@EJB 
	private CountriesServiceLocal countryServiceLocal;
	
	
	private String selectedCountry;
	private Hotel hotelupdate;

	private User u =new User();
	
	@ManagedProperty(value="#{identity}")
	 private Identity identity ;
	
    	private List<Hotel> Hls=new ArrayList<Hotel>();
    	private List<Hotel> cli=new ArrayList<Hotel>();
    	
    	
/*    	
    	public List<SelectItem> getCountry(){
    		List<SelectItem> items=new ArrayList<SelectItem>();
    	List<Countries> countrys=countryServiceLocal.findAll();
    	for(Countries country:countrys){
    		SelectItem item = new SelectItem(country.getName(), country.getName());
    	items.add(item);
    	}
    	return items;	
    	}
		*/
	public List<Hotel> getHls() {
			Hls=hotelServiceLocal.FindByEtat(false);
			return Hls;
		}
	
	public String selectEdit(Hotel h){
		String navTo= "";
		
		setHotelupdate(h);
		navTo="edit?faces-redirect=true";
		return navTo;
	}
	
	
	public String doUpdate(){
	
		hotelServiceLocal.update(hotelupdate);
		return "home?faces-redirect=true"; 
	}
	
	
	public String doDelete(Hotel h){
		hotelServiceLocal.delete(h);
		return "home?faces-redirect=true";
	}
	

		public String ajoutHotel() {
			String navTo = "";
			hotel.setCountry(selectedCountry);
			hotel.setEtat(false);
			
			hotel.setHotelmanager((HotelManager) identity.getUser());
			hotelServiceLocal.save(hotel);
			navTo = "/test?faces-redirect=true";

			return navTo;

		}


		public Hotel getHotel() {
			return hotel;
		}


		public void setHotel(Hotel hotel) {
			this.hotel = hotel;
		}


		public User getU() {
			return u;
		}


		public void setU(User u) {
			this.u = u;
		}


		public Identity getIdentity() {
			return identity;
		}


		public void setIdentity(Identity identity) {
			this.identity = identity;
		}

		public String getSelectedCountry() {
			return selectedCountry;
		}

		public void setSelectedCountry(String selectedCountry) {
			this.selectedCountry = selectedCountry;
		}

		public Hotel getHotelupdate() {
			return hotelupdate;
		}

		public void setHotelupdate(Hotel hotelupdate) {
			this.hotelupdate = hotelupdate;
		}

		public List<Hotel> getCli() {
			cli=hotelServiceLocal.findAll();
			return cli;
		}

		public void setCli(List<Hotel> cli) {
			this.cli = cli;
		}


	

}
