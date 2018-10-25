package tn.esprit.b3.esprit1718b3tourism.mBeans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import tn.esprit.b3.esprit1718b3tourism.entities.CommandedDish;
import tn.esprit.b3.esprit1718b3tourism.entities.GainRestaurantManager;
import tn.esprit.b3.esprit1718b3tourism.entities.Plat;
import tn.esprit.b3.esprit1718b3tourism.entities.Product;
import tn.esprit.b3.esprit1718b3tourism.entities.Recette;
import tn.esprit.b3.esprit1718b3tourism.services.CommandedDishServiceLocal;
import tn.esprit.b3.esprit1718b3tourism.services.GainRestaurantManagerServiceLocal;
import tn.esprit.b3.esprit1718b3tourism.services.PlatServiceLocal;
import tn.esprit.b3.esprit1718b3tourism.services.ProductServiceLocal;
import tn.esprit.b3.esprit1718b3tourism.services.RecetteServiceLocal;
@ManagedBean
@ViewScoped
public class CalculRecetteTabBean {

	@EJB	
	private CommandedDishServiceLocal commandedServiceLocal;
	@EJB
	private PlatServiceLocal platServiceLocal;
	@EJB
	private RecetteServiceLocal recetteSrviceLocal;
	@EJB
	private ProductServiceLocal productServiceLocal;
	@EJB
	private GainRestaurantManagerServiceLocal gainRestaurantService;
	@ManagedProperty(value="#{calculRecetteBean}")
	 private CalculRecetteBean calculRecette;
	
	
	
	public CalculRecetteTabBean() {
		super();
	}
	
	
	private List<CommandedDish> ls4=new ArrayList<CommandedDish>();
	private List<Plat> ls5=new ArrayList<Plat>();
	private List<Recette> ls6=new ArrayList<Recette>();
	private List<Product> ls7=new ArrayList<Product>();
	private List<GainRestaurantManager> ls8=new ArrayList<GainRestaurantManager>();
	private Integer commandedDishSelected;
	private CommandedDish commandedDish;
	private CommandedDish commandedDish2;
	private String date;
	private Float gain=0f;
	private Float cout=0f;
	private Float gainNet=0f;
	private LineChartModel dateModel;
	private String dateRecette;
	private Integer a;
	private String date2;
	@PostConstruct
	public void init() throws ParseException
	{		 dateRecette=calculRecette.getSelectedDate();
	 a=dateRecette.indexOf(" ");
	 date2=dateRecette.substring(0,10);
		ls4=findCommandedDish();
		ls5=findCommandedPlat();
		ls6=findRecetteCommandedPlat();
		ls8=gainRestaurantService.findAll();
		 createDateModel();
	

	
		
	}
	
	public void afficher() throws ParseException
	{
		/*Calendar c = Calendar.getInstance ();
		Date d1= c.getTime ();
        SimpleDateFormat parser = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
        Date date = parser.parse(d1+"");
		System.out.println("********* "+d1+"");*/
		//2018-04-28 00:00:00.0
		/* a=dateRecette.indexOf(" ");
			System.out.println("************* "+a);
			 date2=dateRecette.substring(0,10);
			System.out.println("jjjjjjjjjjjjjjjjjjj "+date2);*/
		for(int i=0;i<ls4.size();i++)
		{
			System.out.println("-------------- "+ls4.get(i).getDishPrice());
		}
		System.out.println("+++++++++++++ "+RecetteJourVendu());
		System.out.println("+++++++++++++ "+CoutRecetteJour());
		System.out.println("+++++++++++++ "+ gainDuJour());

	}
	
	public List<CommandedDish> findCommandedDish() throws ParseException 
	{
		Calendar c = Calendar.getInstance ();
		Date d1= c.getTime ();
		 
		 a=dateRecette.indexOf(" ");
		 date2=dateRecette.substring(0,10);
		ls4=commandedServiceLocal.findCommandedDishByDate1(date2);
		
		return ls4;
		
	}
	
	public Float RecetteJourVendu() throws ParseException
	{	ls4=findCommandedDish();
		for(int i=0;i<ls4.size();i++)
		
			gain+=ls4.get(i).getDishPrice();
		
		return gain;
	}
	
	public Float CoutRecetteJour()
	{
		for(int i=0;i<ls6.size();i++)
		
			cout=cout+ls6.get(i).getCoutRecette();
		
		return cout;
	}
	public Float gainDuJour()
	{
		gainNet=gain-cout;
		return gainNet;
	}
	
	
	
	public List<Plat> findCommandedPlat()
	{
		for(int i=0;i<ls4.size();i++)
		{
			ls5.add(platServiceLocal.find(ls4.get(i).getPlat().getIdPlat()));
		}
		return ls5;
		
	}
	public List<Recette> findRecetteCommandedPlat()
	{
		for(int i=0;i<ls5.size();i++)
		{
			ls6.add(recetteSrviceLocal.find(ls5.get(i).getRecette().getIdRecette()));
		}
		return ls6;
	}
	private void createDateModel() {
		ls8=gainRestaurantService.findAll();

		
        dateModel = new LineChartModel();
        
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Series 1");
        
       for(int i=0;i<ls8.size();i++)
        {
    	   String a=ls8.get(i).getDate()+"";
        	series1.set(a,ls8.get(i).getGain());
    	   
        	dateModel.addSeries(series1);
        }
        
      
         
        dateModel.setTitle("Zoom for Details");
        dateModel.setZoom(true);
        dateModel.getAxis(AxisType.Y).setLabel("Values");
        DateAxis axis = new DateAxis("Dates");
        axis.setTickAngle(-50);
        axis.setMax("2018-07-01");
        axis.setTickFormat("%b %#d, %y");
         
        dateModel.getAxes().put(AxisType.X, axis);
    }
	
	public void refreshLine()
	{			
		Calendar c = Calendar.getInstance ();
		Date d1= c.getTime ();
		GainRestaurantManager gainRes=new GainRestaurantManager(d1, gainNet);
		gainRestaurantService.save(gainRes);
		createDateModel();
	}
	
	
public CommandedDish returnDish()
{
	return commandedDish=commandedServiceLocal.find(commandedDishSelected);
}

	public Integer getCommandedDishSelected() {
		return commandedDishSelected;
	}


	public void setCommandedDishSelected(Integer commandedDishSelected) {
		this.commandedDishSelected = commandedDishSelected;
	}


	public CommandedDish getCommandedDish() {
		return commandedDish;
	}


	public void setCommandedDish(CommandedDish commandedDish) {
		this.commandedDish = commandedDish;
	}


	public CommandedDish getCommandedDish2() {
		return commandedDish2;
	}


	public void setCommandedDish2(CommandedDish commandedDish2) {
		this.commandedDish2 = commandedDish2;
	}

	public CalculRecetteBean getCalculRecette() {
		return calculRecette;
	}

	public void setCalculRecette(CalculRecetteBean calculRecette) {
		this.calculRecette = calculRecette;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<CommandedDish> getLs4() {
		return ls4;
	}

	public void setLs4(List<CommandedDish> ls4) {
		this.ls4 = ls4;
	}

	public List<Plat> getLs5() {
		return ls5;
	}

	public void setLs5(List<Plat> ls5) {
		this.ls5 = ls5;
	}

	public List<Recette> getLs6() {
		return ls6;
	}

	public void setLs6(List<Recette> ls6) {
		this.ls6 = ls6;
	}

	public List<Product> getLs7() {
		return ls7;
	}

	public void setLs7(List<Product> ls7) {
		this.ls7 = ls7;
	}

	public Float getGain() {
		return gain;
	}

	public void setGain(Float gain) {
		this.gain = gain;
	}

	public Float getCout() {
		return cout;
	}

	public void setCout(Float cout) {
		this.cout = cout;
	}

	public Float getGainNet() {
		return gainNet;
	}

	public void setGainNet(Float gainNet) {
		this.gainNet = gainNet;
	}

	public LineChartModel getDateModel() {
		return dateModel;
	}

	public void setDateModel(LineChartModel dateModel) {
		this.dateModel = dateModel;
	}

	public List<GainRestaurantManager> getLs8() {
		return gainRestaurantService.findAll();
	}

	public void setLs8(List<GainRestaurantManager> ls8) {
		this.ls8 = ls8;
	}

	public String getDateRecette() {
		return dateRecette;
	}

	public void setDateRecette(String dateRecette) {
		this.dateRecette = dateRecette;
	}

	public Integer getA() {
		return a;
	}

	public void setA(Integer a) {
		this.a = a;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}


     
	
}
