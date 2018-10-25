package tn.esprit.b3.esprit1718b3tourism.mBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;


import tn.esprit.b3.esprit1718b3tourism.entities.CommandedDish;
import tn.esprit.b3.esprit1718b3tourism.entities.Plat;
import tn.esprit.b3.esprit1718b3tourism.services.CommandedDishServiceLocal;
import tn.esprit.b3.esprit1718b3tourism.services.PlatServiceLocal;

@ManagedBean
@SessionScoped
public class AvisClientBean {
	@EJB
	private CommandedDishServiceLocal commandedServiceLocal;
	@EJB
	private PlatServiceLocal platServiceLocal;
	@ManagedProperty(value="#{identity}")
	 private Identity identity;
	private List<CommandedDish> lsCommandedDish=new ArrayList<CommandedDish>();
	private List<Plat> lsPlat=new ArrayList<Plat>();
	private Plat platSelected;
	private Plat plat;
	@PostConstruct
	public void init()
	{
		lsPlat= PlatCommander();
	}
	
	public List<Plat> PlatCommander()
	{
		lsCommandedDish=commandedServiceLocal.findCommandedDishById(identity.getUser().getId());
		for(int i=0;i<lsCommandedDish.size();i++)
		
			lsPlat.add(platServiceLocal.find(lsCommandedDish.get(i).getPlat().getIdPlat()));
		
		return lsPlat;
		
	}
	public void likePlat()
	{
		System.out.println("<3 <3 <3 <3 <3");
		plat=platServiceLocal.find(platSelected.getIdPlat());
		plat.setRecommanded(plat.getRecommanded()+1);
		platServiceLocal.update(plat);
	
	}
	public void disLikePlat()
	{
		plat=platServiceLocal.find(platSelected.getIdPlat());
		plat.setRecommanded(plat.getRecommanded()-1);
		platServiceLocal.update(plat);
	}
	public String passCommentaire()
	{	System.out.println("+++++++++ "+platSelected.getPlatName());
		String navigateTo = "";
		navigateTo = "/commenterPlat?faces-redirect=true";
		return navigateTo;
	}
	public void affiche()
	{
		/*System.out.println("+++++++++ "+identity.getUser().getId());
		lsCommandedDish=commandedServiceLocal.findCommandedDishById(identity.getUser().getId());
		for(int i=0;i<lsCommandedDish.size();i++)
		{
			
			System.out.println("************* "+lsCommandedDish.get(i).getDishPrice());
			lsPlat.add(platServiceLocal.find(lsCommandedDish.get(i).getPlat().getIdPlat()));
			System.out.println("************* "+lsPlat.get(i).getPlatName());
		}*/
		
	}
	
	public List<CommandedDish> getLsCommandedDish() {
		return lsCommandedDish;
	}
	public void setLsCommandedDish(List<CommandedDish> lsCommandedDish) {
		this.lsCommandedDish = lsCommandedDish;
	}
	
	
	
	public List<Plat> getLsPlat() {
		return lsPlat;
	}
	public void setLsPlat(List<Plat> lsPlat) {
		this.lsPlat = lsPlat;
	}



	public Identity getIdentity() {
		return identity;
	}



	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

	public Plat getPlatSelected() {
		return platSelected;
	}

	public void setPlatSelected(Plat platSelected) {
		this.platSelected = platSelected;
	}
	public Plat getPlat() {
		return plat;
	}
	public void setPlat(Plat plat) {
		this.plat = plat;
	}
	
	

}
