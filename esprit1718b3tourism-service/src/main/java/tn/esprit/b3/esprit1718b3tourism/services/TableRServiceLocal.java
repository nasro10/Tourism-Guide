package tn.esprit.b3.esprit1718b3tourism.services;

import java.sql.Blob;
import java.util.List;

import javax.ejb.Local;

import tn.esprit.b3.esprit1718b3tourism.entities.TableR;
import tn.esprit.b3.esprit1718b3tourism.utilities.IGenericDAO;

@Local
public interface TableRServiceLocal extends IGenericDAO<TableR>{
	 public Blob findPictureById(Integer id);
	   public List<TableR >findTableByRestaurant(int id);
	   public List<TableR> findTableByEtat();
}
