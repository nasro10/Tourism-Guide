package tn.esprit.b3.esprit1718b3tourism.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b3.esprit1718b3tourism.entities.Hotel;
import tn.esprit.b3.esprit1718b3tourism.entities.HotelManager;
import tn.esprit.b3.esprit1718b3tourism.utilities.IGenericDAO;


@Remote
public interface HotelServiceRemote extends IGenericDAO<Hotel> {

	public List <Hotel> hcr(String cn , int ci);
	public  List<Hotel>FindById(HotelManager hotelManager);
	 public  List<Hotel>FindByEtat(Boolean etat);
}
