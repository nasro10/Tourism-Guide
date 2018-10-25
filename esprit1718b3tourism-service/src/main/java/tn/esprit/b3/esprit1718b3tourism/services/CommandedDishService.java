package tn.esprit.b3.esprit1718b3tourism.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b3.esprit1718b3tourism.entities.CommandedDish;
import tn.esprit.b3.esprit1718b3tourism.entities.Plat;
import tn.esprit.b3.esprit1718b3tourism.utilities.GenericDAO;

/**
 * Session Bean implementation class CommandedDishService
 */
@Stateless
@LocalBean
public class CommandedDishService extends GenericDAO<CommandedDish> implements CommandedDishServiceRemote, CommandedDishServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;
	@EJB	
	private CommandedDishServiceLocal commandedServiceLocal;
	private Float facture=0f;
    /**
     * Default constructor. 
     */
	private List<CommandedDish> ls1=new ArrayList<CommandedDish>();
	private List<CommandedDish> ls2=new ArrayList<CommandedDish>();
	private List<CommandedDish> ls3=new ArrayList<CommandedDish>();
    public CommandedDishService() {
    super(CommandedDish.class);
    }
    public List<CommandedDish> findCommandedDishById(int id)
    {
    	return  entityManager.createQuery("select p from CommandedDish p where p.user.id="+id,CommandedDish.class).getResultList();
    }
    
    public List<CommandedDish> findCommandedDishByDate1(String date1) throws ParseException 
	{
    	List<CommandedDish>ls1=commandedServiceLocal.findAll(); 
		List<CommandedDish> ls2=new ArrayList<>();
		 for(int i=0;i<ls1.size();i++)
		{ 

		   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    Date convertedCurrentDate = sdf.parse(ls1.get(i).getDate()+"");
		    String date=sdf.format(convertedCurrentDate );
		  if(date.equals(date1))//"2018-04-19" valeur obtenue à partir d'un combobox
		  {
			  ls2.add(ls1.get(i));
			 
		  }	
		  }
		 for(int j=0;j<ls2.size();j++)
		 {
			// System.out.println("+++++++++++ "+ls2.get(j).getDate());
		 }
		return ls2;
		
		
	}
    public float calculFacture()
	{
		
		ls3=commandedServiceLocal.findCommandedDishById(5);
		
		for(int i=0;i<ls3.size();i++)
		
		 facture= facture+ls3.get(i).getDishPrice();
		return facture;
			
		}
    
}
