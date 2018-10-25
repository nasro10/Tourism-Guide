package tn.esprit.b3.esprit1718b3tourism.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.esprit.b3.esprit1718b3tourism.entities.Admin;
import tn.esprit.b3.esprit1718b3tourism.utilities.GenericDAO;

/**
 * Session Bean implementation class AdminService
 */
@Stateless
@LocalBean
public class AdminService extends GenericDAO<Admin> implements AdminServiceRemote, AdminServiceLocal {

    /**
     * Default constructor. 
     */
    public AdminService() {
       super(Admin.class);
    }

}
