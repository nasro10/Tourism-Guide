package tn.esprit.b3.esprit1718b3tourism.mBeans;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.b3.esprit1718b3tourism.entities.HotelBook;
import tn.esprit.b3.esprit1718b3tourism.entities.HotelManager;
import tn.esprit.b3.esprit1718b3tourism.entities.Promotion;
import tn.esprit.b3.esprit1718b3tourism.entities.Room;
import tn.esprit.b3.esprit1718b3tourism.entities.User;
import tn.esprit.b3.esprit1718b3tourism.services.HotelBookServiceLocal;
import tn.esprit.b3.esprit1718b3tourism.services.PromotionServiceLocal;
import tn.esprit.b3.esprit1718b3tourism.services.RoomServiceLocal;

@ManagedBean
@SessionScoped
public class RoomBean {
	
	public RoomBean(){
		
	}
	
	private List<Room> roomls = new ArrayList<Room>();
	private List<Room> roomcli = new ArrayList<Room>();
	private List<Promotion>promotionls= new ArrayList<Promotion>();
	private List<Room>available=new ArrayList<Room>();

	@EJB
	private RoomServiceLocal roomServiceLocal;
	
	@EJB
	private PromotionServiceLocal promotionServiceLocal;
	
	@EJB
	private HotelBookServiceLocal hotelBookServiceLocal;
	
	private Promotion p =new Promotion();
	private User u =new User();
	private Room room;
	private Room roomPromo;
	private Room roombook;
	private Promotion promo;
	private HotelBook hot =new HotelBook();
	
	@ManagedProperty(value="#{identity}")
	 private Identity identity ;
		
	public String selectRoom(Room r){
		String navTo="";
		setRoomPromo(r);
		navTo="addpromo?faces-redirect=true";
		return navTo;
	}
	
	public Promotion getP() {
		return p;
	}

	public void setP(Promotion p) {
		this.p = p;
	}

	public String doPromo(){
		p.setR(roomPromo);
		
		
	    roomPromo.setPrice(roomPromo.getPrice()-(roomPromo.getPrice()*p.getPrixPro())/100);
		p.setHotelManager((HotelManager) identity.getUser());
		
		if(p.getDate_fin().before(p.getDate_deb())){
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contact admin."));

		}
		else if(p.getDate_fin().equals(LocalDate.now())){
		    roomPromo.setPrice(roomPromo.getPrice()+(roomPromo.getPrice()*p.getPrixPro())/100);

		}
		else{
			promotionServiceLocal.save(p);
			roomServiceLocal.update(roomPromo);
			return "RoomMan?faces-redirect=true";
		}
		
		return "RoomMan?faces-redirect=true";
	}
	
	public String doDelete(Promotion p){
		promotionServiceLocal.delete(p);
		return "promotionroom?faces-redirect=true";
	}
	
	
	
	
	
	public User getU() {
		return u;
	}


	public void setU(User u) {
		this.u = u;
	}


	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public List<Room> getRoomls() {
		
		roomls=roomServiceLocal.FindById((HotelManager) identity.getUser());
		
		return roomls;
	}

	public void setRoomls(List<Room> roomls) {
		this.roomls = roomls;
	}

	public Identity getIdentity() {
		return identity;
	}


	public void setIdentity(Identity identity) {
		this.identity = identity;
	}


	public Room getRoomPromo() {
		return roomPromo;
	}


	public void setRoomPromo(Room roomPromo) {
		this.roomPromo = roomPromo;
	}

	public Promotion getPromo() {
		return promo;
	}

	public void setPromo(Promotion promo) {
		this.promo = promo;
	}

	public List<Promotion> getPromotionls() {
		promotionls=promotionServiceLocal.findAll();
		return promotionls;
	}

	public void setPromotionls(List<Promotion> promotionls) {
		this.promotionls = promotionls;
	}

	public List<Room> getRoomcli() {
		roomServiceLocal.FindByEtat(true);
		return roomcli;
	}

	public void setRoomcli(List<Room> roomcli) {
		this.roomcli = roomcli;
	}

	public List<Room> getAvailable() {
		available=roomServiceLocal.FindByEtat(true);
		return available;
	}

	public void setAvailable(List<Room> available) {
		this.available = available;
	}

	public HotelBook getHot() {
		return hot;
	}

	public void setHot(HotelBook hot) {
		this.hot = hot;
	}
	
	public void selectRoombook(Room r){
		setRoombook(r);
	}
	
	

	public Room getRoombook() {
		return roombook;
	}

	public void setRoombook(Room roombook) {
		this.roombook = roombook;
	}

	public String Bookin(Room r){
		r.setAvailable(false);
		roomServiceLocal.update(r);
		hot.setH(r);
		hot.setU(identity.getUser());
		hotelBookServiceLocal.save(hot);
		return"clientbook?faces-redirect=true";
	}
	
}
