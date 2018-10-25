package tn.esprit.b3.esprit1718b3tourism.mBeans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.b3.esprit1718b3tourism.entities.Admin;
import tn.esprit.b3.esprit1718b3tourism.entities.HotelManager;
import tn.esprit.b3.esprit1718b3tourism.entities.RestaurantManager;
import tn.esprit.b3.esprit1718b3tourism.entities.Server;
import tn.esprit.b3.esprit1718b3tourism.entities.RestaurantManager;
import tn.esprit.b3.esprit1718b3tourism.entities.Server;
import tn.esprit.b3.esprit1718b3tourism.entities.User;
import tn.esprit.b3.esprit1718b3tourism.services.UserServiceLocal;

@ManagedBean
@SessionScoped
public class Identity {
	private boolean isLogged = false;
	private User user = new User();
	private String role;
	@EJB
	private UserServiceLocal userServiceLocal;

	public String logout() {
		isLogged = false;
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
	}

	public String doLogin() {
		String navigateTo = "";
		User userLoggedIn = userServiceLocal.login(user.getLogin(), user.getPasswd());
		if (userLoggedIn != null) {
			isLogged = true;
			user = userLoggedIn;
			if(userLoggedIn instanceof HotelManager){
				navigateTo = "/index?faces-redirect=true";
			}else
			if (userLoggedIn instanceof  RestaurantManager) {
				navigateTo = "/RestaurantManager?faces-redirect=true";
			} 
			 else if (userLoggedIn instanceof User) {
					//navigateTo = "/commandedDishClient?faces-redirect=true";
					navigateTo = "/accueilClient?faces-redirect=true";
				} 
			 
			 else if (userLoggedIn instanceof Server) {
				 navigateTo = "/table?faces-redirect=true";
				} 
						
		} 
		
		else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Veuillez insérer un login et un mot de passe valide", ""));
			return "/login?faces-redirect=true";

		}
		return navigateTo;

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}

	public Boolean getIsLogged() {
		return isLogged;
	}

	public void setIsLogged(Boolean isLogged) {
		this.isLogged = isLogged;
	}
	
	

}
