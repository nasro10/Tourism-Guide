package tn.esprit.b3.esprit1718b3tourism.mBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import tn.esprit.b3.esprit1718b3tourism.entities.Claim;
import tn.esprit.b3.esprit1718b3tourism.entities.HotelManager;
import tn.esprit.b3.esprit1718b3tourism.entities.User;
import tn.esprit.b3.esprit1718b3tourism.services.ClaimServiceLocal;

@ManagedBean
@SessionScoped
public class ClaimBean {

	
	public ClaimBean(){
		
	}
	
	@EJB
	private ClaimServiceLocal claimServiceLocal;
	
	@ManagedProperty(value="#{identity}")
	 private Identity identity ;
	
	Claim c=new Claim();
	
	private User u = new User();
	private List<Claim> claimls = new ArrayList<Claim>();
	private List<Claim> note = new ArrayList<Claim>();


	
	@PostConstruct
	public void init() {
	//	claimls = claimServiceLocal.historyClaim(identity.getUser());
	}

	

	public String ajoutClaim() {
		String navTo = "";

		c.setStatus("test");
		c.setTreated(false);
		c.setClaimer(identity.getUser());
		java.util.Date date = new java.util.Date();
		c.setDate(date);
		claimServiceLocal.save(c);
		c.setText("");
		navTo = "/Claims?faces-redirect=true";
		return navTo;

	}
	


	
	public String accept(Claim c){
		
		c.setHmanang((HotelManager) identity.getUser());
		c.setStatus("treated");
		c.setTreated(true);
		claimServiceLocal.update(c);
		return "treatclaim?faces-redirect=true";
	}
	
	public String refuser(Claim x){
		c.setHmanang((HotelManager) identity.getUser());
		claimServiceLocal.delete(x);
		return "treatclaim?faces-redirect=true";
	}




	public Claim getC() {
		return c;
	}

	public void setC(Claim c) {
		this.c = c;
	}



	public Identity getIdentity() {
		return identity;
	}



	public void setIdentity(Identity identity) {
		this.identity = identity;
	}



	public User getU() {
		return u;
	}



	public void setU(User u) {
		this.u = u;
	}



	public List<Claim> getClaimls() {
		claimls=claimServiceLocal.getNextNotTreatedClaims();
		return claimls;
	}



	public void setClaimls(List<Claim> claimls) {
		this.claimls = claimls;
	}



	public List<Claim> getNote() {
		note=claimServiceLocal.getNextNotTreatedClaims();
		return note;
	}



	public void setNote(List<Claim> note) {
		this.note = note;
	}

		
		
}
