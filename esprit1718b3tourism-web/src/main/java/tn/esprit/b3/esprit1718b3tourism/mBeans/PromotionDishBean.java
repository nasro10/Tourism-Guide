package tn.esprit.b3.esprit1718b3tourism.mBeans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.b3.esprit1718b3tourism.entities.Plat;
import tn.esprit.b3.esprit1718b3tourism.entities.PromotionDish;
import tn.esprit.b3.esprit1718b3tourism.services.PlatServiceLocal;
import tn.esprit.b3.esprit1718b3tourism.services.PromotionDishServiceLocal;
import tn.esprit.b3.esprit1718b3tourism.services.PromotionServiceLocal;

@ManagedBean
@SessionScoped
public class PromotionDishBean {
	@EJB
	private PlatServiceLocal platServiceLocal;
	@EJB
	private PromotionDishServiceLocal promotionDishService;
	private PromotionDish promotionDish;
	private Plat plat;
	private List<Plat> lsPlat=new ArrayList<Plat>();
	private List<PromotionDish> lsPromotion=new ArrayList<PromotionDish>();
	private Plat platSelected;
	private Date dateDebut;
	private Date dateFin;
	private Integer pourcentage;
	private Float newPrice;
	
	
	public String affiche()
	{
		System.out.println("************* "+ platSelected.getPlatName());
		String navigateTo = "";
		navigateTo = "/promotionPlat?faces-redirect=true";
		return navigateTo;
		
		
		
	}
	 public void error() {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contact admin."));
	    }
	 
	public void doInsert()
	{
		promotionDish=new PromotionDish(dateDebut, dateFin, pourcentage,platSelected);
		plat=platServiceLocal.find(platSelected.getIdPlat());
		newPrice=plat.getPrice()-((plat.getPrice()*pourcentage)/100);
		plat.setPrice(newPrice);
		if(dateFin.before(dateDebut))
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error Check Your date!", "Check Your date"));
			
		}
		else
		{
		promotionDishService.save(promotionDish);
		platServiceLocal.update(plat);
		}
		
	}
	public void refresh() throws ParseException
	{
		promotionDishService.refresh();
		
	}
	
	public List<Plat> getLsPlat() {
		return platServiceLocal.findAll();
	}
	public void setLsPlat(List<Plat> lsPlat) {
		this.lsPlat = lsPlat;
	}
	public Plat getPlatSelected() {
		return platSelected;
	}
	public void setPlatSelected(Plat platSelected) {
		this.platSelected = platSelected;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}


	public Integer getPourcentage() {
		return pourcentage;
	}


	public void setPourcentage(Integer pourcentage) {
		this.pourcentage = pourcentage;
	}
	public PromotionDish getPromotionDish() {
		return promotionDish;
	}
	public void setPromotionDish(PromotionDish promotionDish) {
		this.promotionDish = promotionDish;
	}
	public Plat getPlat() {
		return plat;
	}
	public void setPlat(Plat plat) {
		this.plat = plat;
	}
	public Float getNewPrice() {
		return newPrice;
	}
	public void setNewPrice(Float newPrice) {
		this.newPrice = newPrice;
	}
	
	
	
}
