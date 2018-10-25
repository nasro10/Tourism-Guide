package tn.esprit.b3.esprit1718b3tourism.mBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.b3.esprit1718b3tourism.entities.Plat;
import tn.esprit.b3.esprit1718b3tourism.services.PlatServiceLocal;

@ManagedBean
@SessionScoped
public class ImcBean {
	@EJB
	PlatServiceLocal platServiceLocal;
	private Float taille;
	private Float poids;
	private Float result;
	private List<Plat> lsPlat=new ArrayList<Plat>();
	
	
	
	public Float calculImc()
	{
		result=platServiceLocal.calculICM(taille, poids);
		return result;
	}
	
	public void afficheImc()
	{
		result=platServiceLocal.calculICM(taille, poids);
	}
	public List<Plat> affichePlat()
	{	result=calculImc();

		if(result<18.5)
			lsPlat=platServiceLocal.bestDish0(result,2);
		if((result>18.5) &&(result<24.9))
			lsPlat=platServiceLocal.bestDish1(result,2);
		if((result>24.9)&& (result<29.9))
			lsPlat=platServiceLocal.bestDish2(result,2);
		if(result>29.9)
			lsPlat=platServiceLocal.bestDish3(result,2);
		return lsPlat;
			
	}
	
	public void affiche()
	{	 affichePlat();
		for(int i=0;i<lsPlat.size();i++)
		{
			System.out.println("++++++++++++++ "+lsPlat.get(i).getPlatName());
		}
	}
	
	
	public Float getTaille() {
		return taille;
	}
	public void setTaille(Float taille) {
		this.taille = taille;
	}
	public Float getPoids() {
		return poids;
	}
	public void setPoids(Float poids) {
		this.poids = poids;
	}
	public List<Plat> getLsPlat() {

	return lsPlat;
	}
	public void setLsPlat(List<Plat> lsPlat) {
		this.lsPlat = lsPlat;
	}






	public Float getResult() {
		return result;
	}






	public void setResult(Float result) {
		this.result = result;
	}
	
	
	
	
	

}
