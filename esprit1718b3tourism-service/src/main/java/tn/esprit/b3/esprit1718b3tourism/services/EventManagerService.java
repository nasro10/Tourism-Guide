package tn.esprit.b3.esprit1718b3tourism.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.esprit.b3.esprit1718b3tourism.entities.EventManager;

import tn.esprit.b3.esprit1718b3tourism.entities.User;
import tn.esprit.b3.esprit1718b3tourism.utilities.GenericDAO;




/**
 * Session Bean implementation class EventManagerService
 */
@Stateless
@LocalBean
public class EventManagerService extends GenericDAO<EventManager> implements EventManagerServiceRemote, EventManagerServiceLocal {

    /**
     * Default constructor. 
     */
    public EventManagerService() {
      super(EventManager.class);

    }

}
