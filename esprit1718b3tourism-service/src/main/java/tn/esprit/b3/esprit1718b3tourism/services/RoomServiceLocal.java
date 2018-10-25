package tn.esprit.b3.esprit1718b3tourism.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.b3.esprit1718b3tourism.entities.Hotel;
import tn.esprit.b3.esprit1718b3tourism.entities.HotelManager;
import tn.esprit.b3.esprit1718b3tourism.entities.Room;
import tn.esprit.b3.esprit1718b3tourism.utilities.IGenericDAO;

@Local
public interface RoomServiceLocal extends IGenericDAO<Room> {
    public  List<Room>FindById(HotelManager hotelManager);
    public  List<Room>FindByEtat(Boolean available);
}
