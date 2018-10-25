package tn.esprit.b3.esprit1718b3tourism.services;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import tn.esprit.b3.esprit1718b3tourism.entities.CommandedDish;
import tn.esprit.b3.esprit1718b3tourism.entities.User;
import tn.esprit.b3.esprit1718b3tourism.utilities.IGenericDAO;

@Local
public interface CommandedDishServiceLocal extends IGenericDAO<CommandedDish>{
	 public List<CommandedDish> findCommandedDishById(int id);
	 public List<CommandedDish> findCommandedDishByDate1(String date1)throws ParseException ;
	 public float calculFacture();
	 

}
