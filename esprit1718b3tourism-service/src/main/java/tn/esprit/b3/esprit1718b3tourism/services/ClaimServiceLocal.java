package tn.esprit.b3.esprit1718b3tourism.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.b3.esprit1718b3tourism.entities.Claim;
import tn.esprit.b3.esprit1718b3tourism.entities.User;
import tn.esprit.b3.esprit1718b3tourism.utilities.IGenericDAO;

@Local
public interface ClaimServiceLocal extends IGenericDAO<Claim> {
	public Claim getNextNotTreatedClaim();
    public void claimIsTreated(Claim c);
    public List<Claim> getNextNotTreatedClaims();
	public int claimNumber(User u);
	public java.util.List<Claim> historyClaim(User u);
	public void blockUser(User u);

}
