package tn.esprit.b3.esprit1718b3tourism.mBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

import tn.esprit.b3.esprit1718b3tourism.entities.Plat;
import tn.esprit.b3.esprit1718b3tourism.entities.Product;
import tn.esprit.b3.esprit1718b3tourism.services.PlatServiceLocal;
import tn.esprit.b3.esprit1718b3tourism.services.ProductServiceLocal;



@ManagedBean
@RequestScoped
public class bean {
	@EJB
	private PlatServiceLocal platServiceLocal;
	@EJB
	private ProductServiceLocal productServiceLocale;
	private PieChartModel pie;
	private BarChartModel bar;
	private BarChartModel barStock;
	private Plat plat=new Plat();
	private List<Plat> lsPlat;
	private List<Product> lsProduct;

	public bean()
	{
	
	}
	public PieChartModel getPie() {
		return pie;
	}
	public void setPie(PieChartModel pie) {
		this.pie = pie;
	}
	@PostConstruct
	public void init()
	{
		//createPie();
		createBar();
		createBarStock();
	}
	/*
	public void createPie()
	{
	
		lsProduct=productServiceLocale.findAll();
		pie = new PieChartModel();
		for(int i=0;i<lsProduct.size();i++)
		{
		pie.set(lsProduct.get(i).getProductName(),lsProduct.get(i).getQuantityStock());
		}

		pie.setTitle("Quantity of product in stock");
		pie.setLegendPosition("w");

	}*/
	public void createBarStock()
	{	lsProduct=productServiceLocale.findAll();
		barStock=new BarChartModel();
		for(int i=0;i<lsProduct.size();i++)
		{
			ChartSeries newOrder= new ChartSeries(lsProduct.get(i).getProductName());
			newOrder.set(lsProduct.get(i).getProductName(),lsProduct.get(i).getQuantityStock());
			barStock.addSeries(newOrder);
		}

		barStock.setTitle("Quantity of product in stock/kg");
		barStock.setLegendPosition("ne");
		barStock.getAxis(AxisType.X).setLabel("Product Name");
		barStock.getAxis(AxisType.Y).setLabel("Quantity");
		barStock.getAxis(AxisType.Y).setMax(50);
		barStock.getAxis(AxisType.Y).setMin(0);
	}
	
	public void createBar()
	{	lsPlat=platServiceLocal.findAll();
		bar=new BarChartModel();
		for(int i=0;i<lsPlat.size();i++)
		{
			ChartSeries newOrder= new ChartSeries(lsPlat.get(i).getPlatName());
			newOrder.set(lsPlat.get(i).getPlatName(),lsPlat.get(i).getRecommanded());
			bar.addSeries(newOrder);
		}

		bar.setTitle("Recommanded Dishes");
		bar.setLegendPosition("ne");
		bar.getAxis(AxisType.X).setLabel("Dish Name");
		bar.getAxis(AxisType.Y).setLabel("Recommanded");
		bar.getAxis(AxisType.Y).setMax(100);
		bar.getAxis(AxisType.Y).setMin(0);
	}
	
	public String passChart()
	{
		String navigateTo = "";
		navigateTo = "/chart?faces-redirect=true";
		return navigateTo;
	}
	
	
	
	public Plat getPlat() {
		return plat;
	}
	public void setPlat(Plat plat) {
		this.plat = plat;
	}
	public List<Plat> getLsPlat() {
		return lsPlat;
	}
	public void setLsPlat(List<Plat> lsPlat) {
		this.lsPlat = lsPlat;
	}
	public BarChartModel getBar() {
		return bar;
	}
	public void setBar(BarChartModel bar) {
		this.bar = bar;
	}
	public List<Product> getLsProduct() {
		return lsProduct;
	}
	public void setLsProduct(List<Product> lsProduct) {
		this.lsProduct = lsProduct;
	}
	public BarChartModel getBarStock() {
		return barStock;
	}
	public void setBarStock(BarChartModel barStock) {
		this.barStock = barStock;
	}
	
}
