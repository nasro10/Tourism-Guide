package tn.esprit.b3.esprit1718b3tourism.mBeans;

import java.util.Date;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import tn.esprit.b3.esprit1718b3tourism.entities.Plat;
import tn.esprit.b3.esprit1718b3tourism.entities.PromotionDish;
import tn.esprit.b3.esprit1718b3tourism.services.PlatServiceLocal;
import tn.esprit.b3.esprit1718b3tourism.services.PromotionDishServiceLocal;

@ManagedBean
@ViewScoped
public class PromotionPlatBean {
	@EJB
	private PlatServiceLocal platServiceLocal;
	@EJB
	private PromotionDishServiceLocal promotionDishService;
	
	private PromotionDish promotionDish;
	private Plat plat;
	private Date dateDebut;
	private Date dateFin;
	private Integer pourcentage;
	private Float newPrice;
	
	/*public void doInsert()
	{
		promotionDish=new PromotionDish(dateDebut, dateFin, pourcentage,promotionDishB.getPlatSelected());
		plat=platServiceLocal.find(promotionDishB.getPlatSelected().getIdPlat());
		newPrice=plat.getPrice()-((plat.getPrice()*pourcentage)/100);
		plat.setPrice(newPrice);
		promotionDishService.save(promotionDish);
		platServiceLocal.update(plat);
		
	}*/
	public String passPromo()
	{
		String navigateTo = "";
		navigateTo = "/promotionDish?faces-redirect=true";
		return navigateTo;
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

	public Float getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(Float newPrice) {
		this.newPrice = newPrice;
	}

}
