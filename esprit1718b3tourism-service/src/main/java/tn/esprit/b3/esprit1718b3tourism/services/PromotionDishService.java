package tn.esprit.b3.esprit1718b3tourism.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.esprit.b3.esprit1718b3tourism.entities.Plat;
import tn.esprit.b3.esprit1718b3tourism.entities.PromotionDish;
import tn.esprit.b3.esprit1718b3tourism.utilities.GenericDAO;

/**
 * Session Bean implementation class PromotionDishService
 */
@Stateless
@LocalBean
public class PromotionDishService extends GenericDAO <PromotionDish> implements PromotionDishServiceRemote, PromotionDishServiceLocal {
	@EJB
	private PromotionDishServiceLocal promotionDishService;
	@EJB
	private PlatServiceLocal platServiceLocal;
	private List<PromotionDish> lsPromotion=new ArrayList<PromotionDish>();
	private Plat plat;
    public PromotionDishService() {
      super(PromotionDish.class);
    }
    public void refresh() throws ParseException
	{	//avoir dateSystem
		Calendar c = Calendar.getInstance ();
		Date d1= c.getTime ();
		 String input =d1+""; 
	        SimpleDateFormat parser = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy",Locale.ENGLISH);
	        Date date1 = parser.parse(input);
	        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	        String formattedDate = formatter.format(date1);
	    	
		
		lsPromotion =promotionDishService.findAll();
		for(int i=0;i<lsPromotion.size();i++)
		{
			//avoir date depuis la base avec ce format
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			 Date convertedCurrentDate = sdf.parse(lsPromotion.get(i).getDateFin()+"");
			 String date=sdf.format(convertedCurrentDate );
			    
			    
		if(date.equals(formattedDate))
			
		{
			plat=lsPromotion.get(i).getPlat();
			plat.setPrice(plat.getPrice()+((plat.getPrice()*lsPromotion.get(i).getPourcentage())/100));
			platServiceLocal.update(plat);
			promotionDishService.delete(promotionDishService.find(lsPromotion.get(i).getId()));
		}
		}
	}
}
