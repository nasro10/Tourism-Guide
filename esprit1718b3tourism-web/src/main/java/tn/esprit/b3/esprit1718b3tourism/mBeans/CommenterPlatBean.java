package tn.esprit.b3.esprit1718b3tourism.mBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import tn.esprit.b3.esprit1718b3tourism.entities.CommenterPlat;
import tn.esprit.b3.esprit1718b3tourism.entities.Plat;
import tn.esprit.b3.esprit1718b3tourism.services.CommenterPlatSeviceLocal;

@ManagedBean
@ViewScoped
public class CommenterPlatBean {
	@EJB
	private CommenterPlatSeviceLocal commenterPlatLocal;
	@ManagedProperty(value="#{identity}")
	 private Identity identity;
	@ManagedProperty(value="#{avisClientBean}")
	private AvisClientBean avisClient;
	private String commentaire;
	private CommenterPlat commenterPlat;
	private Plat plat;
	private String commantaireUser;
	private List<String> lsCommentaire=new ArrayList<String>();
	private List<String> lsFiltre=new ArrayList<String>();
	@PostConstruct
	public void init()
	{
		plat=avisClient.getPlatSelected();
		lsCommentaire=returnCommentaire();
	}
	
	public void doInsert()
	{	
		commantaireUser=identity.getUser().getLastName().concat(": ").concat(commentaire);
		commenterPlat=new CommenterPlat(commantaireUser, identity.getUser(), avisClient.getPlatSelected());
		if(filtreCommentaire()==false)
		{
			System.out.println("falseeeeeeeeee!!!!!!!!");
		}
		else
		{
		commenterPlatLocal.save(commenterPlat);
		lsCommentaire=returnCommentaire();
		}
	}
	
	public boolean filtreCommentaire()
	{	
		lsFiltre.add("bad");
		lsFiltre.add("worse");
		
		for(int j=0;j<lsFiltre.size();j++)
			{
			if(commentaire.contains(lsFiltre.get(j)))
				return false;
		}
			
		return true;
		
	}
	public List<String> returnCommentaire()
	{
		lsCommentaire=commenterPlatLocal.findCommantaireByIdPlat(avisClient.getPlatSelected().getIdPlat());
		return lsCommentaire;
		
		
	}
	public void refresh()
	{
		lsCommentaire=returnCommentaire();
	}
	public void affiche()
	{for(int i=0;i<lsCommentaire.size();i++)
		System.out.println("*************** "+lsCommentaire.get(i));
	//System.out.println("*************** "+commentaire);
	}
	public String passOtherComment()
	{
		String navigateTo = "";
		navigateTo = "/otherComment?faces-redirect=true";
		return navigateTo;
	}
	
	
	
	
	public Identity getIdentity() {
		return identity;
	}
	public void setIdentity(Identity identity) {
		this.identity = identity;
	}
	public AvisClientBean getAvisClient() {
		return avisClient;
	}
	public void setAvisClient(AvisClientBean avisClient) {
		this.avisClient = avisClient;
	}
	
	public String getCommentaire() {
		return commentaire;
	}


	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}


	public CommenterPlat getCommenterPlat() {
		return commenterPlat;
	}





	public void setCommenterPlat(CommenterPlat commenterPlat) {
		this.commenterPlat = commenterPlat;
	}

	public Plat getPlat() {
		return plat;
	}

	public void setPlat(Plat plat) {
		this.plat = plat;
	}

	public String getCommantaireUser() {
		return commantaireUser;
	}

	public void setCommantaireUser(String commantaireUser) {
		this.commantaireUser = commantaireUser;
	}

	

	public List<String> getLsCommentaire() {
		return lsCommentaire;
	}

	public void setLsCommentaire(List<String> lsCommentaire) {
		this.lsCommentaire = lsCommentaire;
	}

	
	public List<String> getLsFiltre() {
		return lsFiltre;
	}

	public void setLsFiltre(List<String> lsFiltre) {
		this.lsFiltre = lsFiltre;
	}
	
	
	
	
	
	
}
