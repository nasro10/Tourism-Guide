package tn.esprit.b3.esprit1718b3tourism.services;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import tn.esprit.b3.esprit1718b3tourism.entities.Admin;
import tn.esprit.b3.esprit1718b3tourism.entities.AirlineCompanyManager;
import tn.esprit.b3.esprit1718b3tourism.entities.EventManager;
import tn.esprit.b3.esprit1718b3tourism.entities.HotelManager;
import tn.esprit.b3.esprit1718b3tourism.entities.RestaurantManager;
import tn.esprit.b3.esprit1718b3tourism.entities.TravelAgencyManager;

import tn.esprit.b3.esprit1718b3tourism.entities.AirlineCompanyManager;
import tn.esprit.b3.esprit1718b3tourism.entities.EventManager;
import tn.esprit.b3.esprit1718b3tourism.entities.RestaurantManager;
import tn.esprit.b3.esprit1718b3tourism.entities.TravelAgencyManager;

import tn.esprit.b3.esprit1718b3tourism.entities.EventManager;

import tn.esprit.b3.esprit1718b3tourism.entities.Sponsors;

import tn.esprit.b3.esprit1718b3tourism.entities.RestaurantManager;
import tn.esprit.b3.esprit1718b3tourism.entities.Server;


import tn.esprit.b3.esprit1718b3tourism.entities.User;
import tn.esprit.b3.esprit1718b3tourism.utilities.GenericDAO;

/**
 * Session Bean implementation class UserService
 */
@Stateless
public class UserService extends GenericDAO<User> implements UserServiceRemote, UserServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public UserService() {
		super(User.class);
	}

	@Override
	public User login(String login, String password) {
		User user = null;
		try {
			user = entityManager.createQuery("SELECT u FROM User u WHERE u.login=:l AND u.passwd=:p", User.class)
					.setParameter("l", login).setParameter("p", password).getSingleResult();

			if(user.getRole().equals("RestaurantManager"))
			{ RestaurantManager rsMan=new RestaurantManager();
			rsMan.setCin(user.getCin());;
			rsMan.setLastName(user.getLastName());
			rsMan.setName(user.getName());
			rsMan.setId(user.getId());
			rsMan.setLogin(user.getLogin());
			rsMan.setPasswd(user.getPasswd());
			rsMan.setMail(user.getMail());
			rsMan.setPhone(user.getPhone());
			
			return rsMan;
				
			}
			if(user.getRole().equals("EventManager"))
			{
				EventManager evMan=new EventManager();
				evMan.setCin(user.getCin());;
				evMan.setLastName(user.getLastName());
				evMan.setName(user.getName());
				evMan.setId(user.getId());
				evMan.setLogin(user.getLogin());
				evMan.setPasswd(user.getPasswd());
				evMan.setMail(user.getMail());
				evMan.setPhone(user.getPhone());
				return evMan;
			}
			
			if(user.getRole().equals("HotelManager"))
			{ HotelManager hMan=new HotelManager();
			hMan.setCin(user.getCin());;
			hMan.setLastName(user.getLastName());
			hMan.setName(user.getName());
			hMan.setId(user.getId());
			hMan.setLogin(user.getLogin());
			hMan.setPasswd(user.getPasswd());
			hMan.setMail(user.getMail());
			hMan.setPhone(user.getPhone());
			
			return hMan;
				
			}
			if(user.getRole().equals("Admin"))
			{ Admin ad=new Admin();
			ad.setCin(user.getCin());;
			ad.setLastName(user.getLastName());
			ad.setName(user.getName());
			ad.setId(user.getId());
			ad.setLogin(user.getLogin());
			ad.setPasswd(user.getPasswd());
			ad.setMail(user.getMail());
			ad.setPhone(user.getPhone());
			
			return ad;
				
			}
			if(user.getRole().equals("User"))
			{ User u=new User();
			u.setCin(user.getCin());;
			u.setLastName(user.getLastName());
			u.setName(user.getName());
			u.setId(user.getId());
			u.setLogin(user.getLogin());
			u.setPasswd(user.getPasswd());
			u.setMail(user.getMail());
			u.setPhone(user.getPhone());
			
			return u;
				
			}
		
			if(user.getRole().equals("AirlineCompanyManager"))
			{
				AirlineCompanyManager acMan=new AirlineCompanyManager();
				acMan.setCin(user.getCin());;
				acMan.setLastName(user.getLastName());
				acMan.setName(user.getName());
				acMan.setId(user.getId());
				acMan.setLogin(user.getLogin());
				acMan.setPasswd(user.getPasswd());
				acMan.setMail(user.getMail());
				acMan.setPhone(user.getPhone());
				return acMan;
			}
			
			/*if(user.getRole().equals("TravelAgencyManager"))
			{
				TravelAgencyManager taMan=new TravelAgencyManager();
				taMan.setCin(user.getCin());;
				taMan.setLastName(user.getLastName());
				taMan.setName(user.getName());
				taMan.setId(user.getId());
				taMan.setLogin(user.getLogin());
				taMan.setPasswd(user.getPasswd());
				taMan.setMail(user.getMail());
				taMan.setPhone(user.getPhone());
				return taMan;
			}*/
			

			 if(user.getRole().equals("Sponsors"))
			{ Sponsors sp=new Sponsors();
			sp.setCin(user.getCin());;
			sp.setLastName(user.getLastName());
			sp.setName(user.getName());
			sp.setId(user.getId());
			sp.setLogin(user.getLogin());
			sp.setPasswd(user.getPasswd());
			sp.setSocietyName(sp.getSocietyName());
			return sp;
			
				
			}

		
			
			
			if(user.getRole().equals("Server"))
			{
				Server s=new Server();
				s.setCin(user.getCin());;
				s.setLastName(user.getLastName());
				s.setName(user.getName());
				s.setId(user.getId());
				s.setLogin(user.getLogin());
				s.setPasswd(user.getPasswd());
				s.setMail(user.getMail());
				s.setPhone(user.getPhone());
				return s;
			}
			
			
		} catch (Exception e) {
		}
	
	


		return null;
	}
	}
