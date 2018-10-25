package tn.esprit.b3.esprit1718b3tourism.mBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import tn.esprit.b3.esprit1718b3tourism.entities.CarteFid;
import tn.esprit.b3.esprit1718b3tourism.entities.CommandedDish;
import tn.esprit.b3.esprit1718b3tourism.services.CarteFidServiceLocal;
import tn.esprit.b3.esprit1718b3tourism.services.CommandedDishServiceLocal;

@ManagedBean
@SessionScoped
public class PaiementClientBean {
	@EJB	
	private CommandedDishServiceLocal commandedServiceLocal;
	@EJB
	private CarteFidServiceLocal carteServiceLocal;
	@ManagedProperty(value="#{identity}")
	 private Identity identity;
	private List<CommandedDish> ls1=new ArrayList<CommandedDish>();
	private Float reduction=0f;
	private Integer point;
	private Float prixFinal;
	private List<CommandedDish> ls3=new ArrayList<CommandedDish>();
	private Float facture=0f;
	private CarteFid carte;
	public PaiementClientBean()
	{
		
	}
	@PostConstruct
	public void inti()
	{
		facture= calculFature1();
		point=returnPoint();
		//prixFinal= factureFinal();
		
	}
	
public Float calculFature1()
{

	ls3=commandedServiceLocal.findCommandedDishById(identity.getUser().getId());
	
	for(int i=0;i<ls3.size();i++)
	
	 facture= facture+ls3.get(i).getDishPrice();
	return facture;
	
}


public Integer returnPoint()
{
	
	Integer point=carteServiceLocal.findCarteByIdUser(identity.getUser().getId()).getPoint();
	return point;
}
public void affiche()
{	
	System.out.println("eeeeeeeeeee"+reduction);
}

public Float factureFinal()
{
		prixFinal=facture-(reduction*5)/point;
		point=(int) (point-reduction);
		carte=carteServiceLocal.findCarteByIdUser(identity.getUser().getId());
		carte.setPoint(point);
		carteServiceLocal.update(carte);
		
	
		return prixFinal;
}

public String passAvis()
{
	String navigateTo = "";
	navigateTo = "/avisClient?faces-redirect=true";
	return navigateTo;
}






public List<CommandedDish> getLs1() {
		return commandedServiceLocal.findCommandedDishById(identity.getUser().getId()) ;
	}

	public void setLs1(List<CommandedDish> ls1) {
		this.ls1 = ls1;
	}
	public Float getReduction() {
		return reduction;
	}
	public void setReduction(Float reduction) {
		this.reduction = reduction;
	}
	
	public Identity getIdentity() {
		return identity;
	}
	public void setIdentity(Identity identity) {
		this.identity = identity;
	}
	public Float getFacture() {
		return facture;
	}
	public void setFacture(Float facture) {
		this.facture = facture;
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	public Float getPrixFinal() {
		return prixFinal;
	}
	public void setPrixFinal(Float prixFinal) {
		this.prixFinal = prixFinal;
	}
	
	
}
