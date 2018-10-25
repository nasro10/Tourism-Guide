package tn.esprit.b3.esprit1718b3tourism.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b3.esprit1718b3tourism.entities.Claim;
import tn.esprit.b3.esprit1718b3tourism.entities.User;
import tn.esprit.b3.esprit1718b3tourism.utilities.GenericDAO;

/**
 * Session Bean implementation class ClaimService
 */
@Stateless
@LocalBean
public class ClaimService extends GenericDAO<Claim> implements ClaimServiceRemote, ClaimServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	private EntityManager em;
    public ClaimService() {
    	super(Claim.class);
    }
    
    @Override
	public Claim getNextNotTreatedClaim() {
		 
		List<Claim> sd= em.createQuery("select c from Claim c where c.treated = 0").getResultList();
		if(sd.isEmpty())
			return null;
		return sd.get(0);
	}
    @Override
   	public List<Claim> getNextNotTreatedClaims() {
   		 
   		List<Claim> sd= em.createQuery("select c from Claim c where c.treated = 0").getResultList();
   		//List<Claim> sd=em.createQuery("select c from Claim c where c.claimer.id ="+u.getId(),Claim.class).getResultList();
		System.out.println(sd);
		return sd;
   	}
    
    @Override
	public void claimIsTreated(Claim c) {
    	
		em.merge(c);
		
	}

	@Override
	public int claimNumber(User u) {
		
		List<Claim> sd= em.createQuery("select c from Claim c where c.claimer.id ="+u.getId()).getResultList();
		return sd.size();
	}
	
	@Override
	public List<Claim> historyClaim(User u) {
		
		List<Claim> sd=em.createQuery("select c from Claim c where c.claimer.id ="+u.getId(),Claim.class).getResultList();
		System.out.println(sd);
		return sd;
	}
	
	@Override
	public void blockUser(User u) {
		em.merge(u);
	}



}
