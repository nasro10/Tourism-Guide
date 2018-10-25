package tn.esprit.b3.esprit1718b3tourism.utilities;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.swing.text.PlainDocument;

import tn.esprit.b3.esprit1718b3tourism.entities.Admin;
import tn.esprit.b3.esprit1718b3tourism.entities.Bill;
import tn.esprit.b3.esprit1718b3tourism.entities.Claim;
import tn.esprit.b3.esprit1718b3tourism.entities.CommandedDish;
import tn.esprit.b3.esprit1718b3tourism.entities.CommenterPlat;
import tn.esprit.b3.esprit1718b3tourism.entities.EventManager;

import tn.esprit.b3.esprit1718b3tourism.entities.Hotel;
import tn.esprit.b3.esprit1718b3tourism.entities.HotelManager;
import tn.esprit.b3.esprit1718b3tourism.entities.Event;
import tn.esprit.b3.esprit1718b3tourism.entities.Local;
import tn.esprit.b3.esprit1718b3tourism.entities.Promotion;
import tn.esprit.b3.esprit1718b3tourism.entities.Menu;
import tn.esprit.b3.esprit1718b3tourism.entities.Plat;
import tn.esprit.b3.esprit1718b3tourism.entities.Product;
import tn.esprit.b3.esprit1718b3tourism.entities.Recepionist;
import tn.esprit.b3.esprit1718b3tourism.entities.Room;

import tn.esprit.b3.esprit1718b3tourism.entities.Recette;
import tn.esprit.b3.esprit1718b3tourism.entities.Restaurant;
import tn.esprit.b3.esprit1718b3tourism.entities.RestaurantManager;
import tn.esprit.b3.esprit1718b3tourism.entities.TableR;
import tn.esprit.b3.esprit1718b3tourism.entities.User;
import tn.esprit.b3.esprit1718b3tourism.services.AdminServiceLocal;
import tn.esprit.b3.esprit1718b3tourism.services.ClaimServiceLocal;
import tn.esprit.b3.esprit1718b3tourism.services.CommandedDishServiceLocal;
import tn.esprit.b3.esprit1718b3tourism.services.CommenterPlatSeviceLocal;
import tn.esprit.b3.esprit1718b3tourism.services.HotelManagerServiceLocal;
import tn.esprit.b3.esprit1718b3tourism.services.HotelService;
import tn.esprit.b3.esprit1718b3tourism.services.HotelServiceLocal;
import tn.esprit.b3.esprit1718b3tourism.services.PromotionServiceLocal;
import tn.esprit.b3.esprit1718b3tourism.services.RoomServiceLocal;

import tn.esprit.b3.esprit1718b3tourism.services.EventManagerServiceLocal;
import tn.esprit.b3.esprit1718b3tourism.services.EventServiceLocal;
import tn.esprit.b3.esprit1718b3tourism.services.EventSponsorServiceLocal;
import tn.esprit.b3.esprit1718b3tourism.services.LocalServiceLocal;
import tn.esprit.b3.esprit1718b3tourism.services.MenuServiceLocal;
import tn.esprit.b3.esprit1718b3tourism.services.PlatServiceLocal;
import tn.esprit.b3.esprit1718b3tourism.services.ProductServiceLocal;
import tn.esprit.b3.esprit1718b3tourism.services.RecetteServiceLocal;
import tn.esprit.b3.esprit1718b3tourism.services.RestaurantManagerServiceLocal;
import tn.esprit.b3.esprit1718b3tourism.services.RestaurantServiceLocal;
import tn.esprit.b3.esprit1718b3tourism.services.SponsorsServiceLocal;
import tn.esprit.b3.esprit1718b3tourism.services.TableRServiceLocal;
import tn.esprit.b3.esprit1718b3tourism.services.UserServiceLocal;

@Singleton
@Startup //1ere class aprés deploiment
public class DBPopulator {
	@EJB
	private UserServiceLocal userServiceLocal;
	@EJB
	private HotelServiceLocal hotelServiceLocal;
	@EJB
	private HotelManagerServiceLocal hotelManagerServiceLocal;
	@EJB
	private RoomServiceLocal roomServiceLocal;
	
	@EJB	
	private PromotionServiceLocal promotionServiceLocal;
	
	@EJB
	private ClaimServiceLocal claimServiceLocal;
	
	@EJB 
	private AdminServiceLocal adminServiceLocal;
	
	private EventServiceLocal eventServiceLocal;
	@EJB
	private EventManagerServiceLocal eventmanagerServicelocal;
	@EJB
	private LocalServiceLocal localServiceLocal;
	@EJB
	private SponsorsServiceLocal sponsorsServiceLocal;
	@EJB
	private EventSponsorServiceLocal eventsponsorServiceLocal;

	private RestaurantManagerServiceLocal restaurantManagerServiceLocal;
	@EJB
	private RestaurantServiceLocal restaurantServiceLocal;
	@EJB
	private MenuServiceLocal menuServiceLocal;
	@EJB
	private PlatServiceLocal platServiceLocal;
	@EJB
	private RecetteServiceLocal recetteServiceLocal;
	@EJB
	private ProductServiceLocal productServiceLocal;
	@EJB
	private EventManagerServiceLocal eventManagerServiceLocal;
	@EJB
	private TableRServiceLocal tableRServiceLocal;
	@EJB
	private CommandedDishServiceLocal commandedServiceLocal;
	@EJB
	private CommenterPlatSeviceLocal commenterPlatLocal;
	public DBPopulator() {
	}

	@PostConstruct
	public void init() throws ParseException {
		/*
		List<String>lsCommenter=commenterPlatLocal.findCommantaireByIdPlat(17);
		for(int i=0;i<lsCommenter.size();i++)
		{
			System.out.println("********** "+lsCommenter.get(i));
		}
		
		
	/*	List<TableR> lsTable=tableRServiceLocal.findTableByEtat();
				for(int i=0;i<lsTable.size();i++)
				{
					System.out.println("********** "+lsTable.get(i).getDescription());
				}
		
		//SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy", Locale.ENGLISH);
		//Date d = dateFormat.parse( "Wed Mar 11 00:00:00 GMT 2009" );
	
		Calendar c = Calendar.getInstance ();
		Date d= c.getTime();
		
		 String input =d+""; 
	        SimpleDateFormat parser = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy",Locale.ENGLISH);
	        Date date1 = parser.parse(input);
	        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	        String formattedDate = formatter.format(date1);
	    	System.out.println("********** "+formattedDate);
	/*	
		 
		Calendar c = Calendar.getInstance ();
		Date d= c.getTime();
		String b=d+"";
		/*SimpleDateFormat dt1 = new SimpleDateFormat("yyyyy-mm-dd");
		Date d2=dt1.parse(b);
		String a= dt1.format(d);
		SimpleDateFormat parser=new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
		Date date1 = parser.parse(b); 
		 System.out.println("hhhhhhhhhhhh "+date1);
		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		//String formattedDate = formatter.format(date1);
	    //Date convertedCurrentDate = sdf.parse(d+"");
	   // String date=sdf.format(convertedCurrentDate );
	   // System.out.println("hhhhhhhhhhhh "+formattedDate);
	
		
		/*
		List<CommandedDish>ls1=commandedServiceLocal.findAll(); 
		List<CommandedDish> ls2=new ArrayList<>();
		List<CommandedDish> ls3=commandedServiceLocal.findCommandedDishByDate1("2018-04-27");
		 for(int i=0;i<ls3.size();i++)
		{ 
			 System.out.println("+++++++++++ "+ls3.get(i).getDate());
		}
		/* for(int i=0;i<ls1.size();i++)
		{ 

		   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    Date convertedCurrentDate = sdf.parse(ls1.get(i).getDate()+"");
		    String date=sdf.format(convertedCurrentDate );
		  if(date.equals("2018-04-27"))//"2018-04-19" valeur obtenue à partir d'un combobox
		  {
			  ls2.add(ls1.get(i));
			 
		  }	
		  }
		 for(int j=0;j<ls2.size();j++)
		 {
			 System.out.println("+++++++++++ "+ls2.get(j).getDate());
		 }
		 /*
		List<CommandedDish>ls1=commandedServiceLocal.findCommandedDishByDate1("2018-04-28");
		for(int i=0;i<ls1.size();i++)
		{
			System.out.println("hhhhhhhhhhhhh "+ls1.get(i).getDishPrice());
		}
		
	/*	Float facture=0f
		List<CommandedDish>ls1=commandedServiceLocal.findCommandedDishById(15);
		for(int i=0;i<ls1.size();i++)
		{
			//System.out.println("hhhhhhhhhh "+ls1.get(i).getDishPrice());
			//facture=facture+ls1.get(i).getDishPrice();
			//System.out.println("++++++++++++++++++++++++"+facture);
			
		}
	 facture=commandedServiceLocal.calculFacture();
		System.out.println("++++++++++++++++++++++++"+facture);
		
	/*	
		List<CommandedDish>ls1=commandedServiceLocal.findAll(); 
		List<CommandedDish> ls2=new ArrayList<>();
	 List<CommandedDish> ls3=new ArrayList<CommandedDish>();
	 
	 
	 ls3=commandedServiceLocal.findCommandedDishByDate1("2018-04-19");
	 
	 for(int i=0;i<ls3.size();i++)
	 {
			System.out.println("++++++++++++++++++++++++"+ls3.get(i).getDishPrice());
		}
	
	/* for(int i=0;i<ls1.size();i++)
		{ 

		   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    Date convertedCurrentDate = sdf.parse(ls1.get(i).getDate()+"");
		    String date=sdf.format(convertedCurrentDate );
		  if(date.equals("2018-04-19"))//"2018-04-19" valeur obtenue à partir d'un combobox
		  {
			  ls2.add(ls1.get(i));
			  System.out.println(ls2.get(i).getDate());
		  }	
		  }
	
		  // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		   // Date convertedCurrentDate = sdf.parse("2018-04-19");//valeur obtenue d'un combobo
		    //String date=sdf.format(convertedCurrentDate );
		  
		   // List<CommandedDish>ls=commandedServiceLocal.findCommandedDishByDate("2018-04-19");
			/*List<CommandedDish>ls1=commandedServiceLocal.findAll(); 
			List<CommandedDish> ls2=new ArrayList<>();
			
		
			
		
		  /* SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    Date convertedCurrentDate = sdf.parse("2013-09-18");
		    String date=sdf.format(convertedCurrentDate );
		    System.out.println(date);
		for(int i=0;i<ls.size();i++)
		{
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa"+ls.get(i).getId());
		
			
		}
		/*Calendar c = Calendar.getInstance ();
		Date d= c.getTime();
		String b=d+"";
		SimpleDateFormat dt1 = new SimpleDateFormat("yyyyy-mm-dd");
		Date d2=dt1.parse(b);*/
		//String a= dt1.format(d);
		
		
	
		/*
		/*Plat plat = new Plat();
		plat.setImc(23f);
		plat.setPrice(25f);
		platServiceLocal.save(plat);
		User u=new User();
		u.setName("aaa");
		userServiceLocal.save(u);
		Calendar c = Calendar.getInstance ();
		Date d1= c.getTime ();
		CommandedDish cDish=new CommandedDish(u, plat, d1,plat.getPrice());
		commandedServiceLocal.save(cDish);
		
		
		
		//SimpleDateFormat dt1 = new SimpleDateFormat("yyyyy-mm-dd");
		//String d= dt1.format(d1);
		//Date date = dt.parse(date_s);
		
		//String oldstring = "2011-01-18 00:00:00.0";
		//LocalDateTime datetime = LocalDateTime.parse(oldstring, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		
		
		
;
		
		
	/*	HotelManager hm=new HotelManager(11, "nasro", "ss", 213659, "sss", "nasro", "10", "HotelManager");
		
		hotelManagerServiceLocal.save(hm);
		User u = new User(12, "nasro", "maizi", 21554,"dd", "ss", "a");
		userServiceLocal.save(u);

		Room room = new Room("double", 30, false, "vip");
		roomServiceLocal.save(room);
		/*String Date1="31/12/1998";
		Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(Date1);
		String Date2="31/12/1999";
		Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(Date2);

		Promotion p=new Promotion(date1,date2,"hello",25);
		promotionServiceLocal.save(p);*/
		//Claim claim= new Claim("hi dude!", u);
	//	claim.setText("bonjour");
	//	claimServiceLocal.save(claim);
		/*	claimServiceLocal.getNextNotTreatedClaim();
		claimServiceLocal.claimIsTreated(claim);*/
		//claimServiceLocal.historyClaim(u);
		
	/*	Admin a=new Admin(55, "mohsen", "bouheli", 22269887, "alo", "het", "10lef", "Admin", 5);
		adminServiceLocal.save(a);*/
}}
