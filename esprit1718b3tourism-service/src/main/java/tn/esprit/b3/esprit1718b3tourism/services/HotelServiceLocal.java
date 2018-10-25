package tn.esprit.b3.esprit1718b3tourism.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.b3.esprit1718b3tourism.entities.Hotel;
import tn.esprit.b3.esprit1718b3tourism.entities.HotelManager;
import tn.esprit.b3.esprit1718b3tourism.utilities.IGenericDAO;


@Local
public interface HotelServiceLocal extends IGenericDAO<Hotel> {


	public List <Hotel> hcr(String cn , int ci);
	public  List<Hotel>FindById(HotelManager hotelManager);
	 public  List<Hotel>FindByEtat(Boolean etat);

}
