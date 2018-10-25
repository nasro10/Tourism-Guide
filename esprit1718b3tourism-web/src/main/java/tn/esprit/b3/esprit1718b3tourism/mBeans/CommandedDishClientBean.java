package tn.esprit.b3.esprit1718b3tourism.mBeans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import tn.esprit.b3.esprit1718b3tourism.entities.CommandedDish;
import tn.esprit.b3.esprit1718b3tourism.entities.Plat;
import tn.esprit.b3.esprit1718b3tourism.entities.User;
import tn.esprit.b3.esprit1718b3tourism.services.CommandedDishServiceLocal;
import tn.esprit.b3.esprit1718b3tourism.services.PlatServiceLocal;
import tn.esprit.b3.esprit1718b3tourism.services.UserServiceLocal;


@ManagedBean
@ViewScoped
public class CommandedDishClientBean {
	
	@EJB
	private PlatServiceLocal platServiceLocal;
	@EJB	
	private CommandedDishServiceLocal commandedServiceLocal;
	@EJB
	private UserServiceLocal userServiceLocal;

	@ManagedProperty(value="#{identity}")
	 private Identity identity;
	private List<Plat> lsPlat=new ArrayList<Plat>();
	private Plat platSelected;
	
	
	public void commander()
	{
		
		User user=identity.getUser();

		Plat p=platServiceLocal.find(platSelected.getIdPlat());
		Calendar c = Calendar.getInstance ();
		Date d1= c.getTime ();
		CommandedDish commandedDish=new CommandedDish(user, p,d1,p.getPrice());
		commandedServiceLocal.save(commandedDish);
		
	}
	public String passPaiement()
	{
		String navigateTo = "";
		navigateTo = "/paiementClient?faces-redirect=true";
		return navigateTo;
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

	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}
	
	

}
