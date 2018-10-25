package tn.esprit.b3.esprit1718b3tourism.mBeans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import tn.esprit.b3.esprit1718b3tourism.entities.CommandedDish;
import tn.esprit.b3.esprit1718b3tourism.services.CommandedDishServiceLocal;

@ManagedBean
@SessionScoped
public class CalculRecetteBean {
	@EJB	
	private CommandedDishServiceLocal commandedServiceLocal;
	
	
	
	public CalculRecetteBean()
	{super();
		
	}
	//private List<CommandedDish>ls1=commandedServiceLocal.findAll();
	private List<CommandedDish>ls1=new ArrayList<CommandedDish>();
	private List<CommandedDish> ls2=new ArrayList<CommandedDish>();
	private List<CommandedDish> ls3=new ArrayList<CommandedDish>();
	private Integer commandedDishSelected;
	private CommandedDish commandedDish;
	private CommandedDish commandedDish2;
	private String selectedDate;
	
	/*@PostConstruct
	public void init() throws ParseException
	{
		ls2=findCommandedDish();
	
	}
	
	
	public List<CommandedDish> findCommandedDish() throws ParseException 
	{
		//commandedDish=commandedServiceLocal.find(commandedDishSelected);
		ls2=commandedServiceLocal.findCommandedDishByDate1("2018-04-27");
		
		return ls2;
		
	}
	*/
public CommandedDish returnDish()
{
	return commandedDish=commandedServiceLocal.find(commandedDishSelected);
}
	
	public String returnDateSelectedDish()
	{
		 selectedDate= commandedServiceLocal.find(commandedDishSelected).getDate()+"";
		 return selectedDate;
	}
	public void afficheDate()
	{
		
	}
	
	public String afficherDishSelected() throws ParseException
	{
		System.out.println("+++++++++++++++++++++++++"+ returnDateSelectedDish());
		String navigateTo = "";
		navigateTo = "/commandedDish2?faces-redirect=true";
		return navigateTo;
		
		//System.out.println("+++++++++++++++++++++++++"+ returnDateSelectedDish());
		/*
	/*	for(int i=0;i<ls2.size();i++)
	{
		System.out.println("+++++++++++++++++++++++++"+ls2.get(i).getDate());
	}
		/*commandedDish=commandedServiceLocal.find(commandedDishSelected);
		System.out.println("+++++++++++++++++++++++++"+commandedDish.getDate()+"");*/
		
	}
	
	

	public List<CommandedDish> getLs1() {
		return commandedServiceLocal.findAll();
	}


	public void setLs1(List<CommandedDish> ls1) {
		this.ls1 = ls1;
	}
	
	
	
	public List<CommandedDish> getLs2() throws ParseException {
	
		return ls2;
	}


	public void setLs2(List<CommandedDish> ls2) {
		this.ls2 = ls2;
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
	public List<CommandedDish> getLs3() {
		return ls3;
	}
	public void setLs3(List<CommandedDish> ls3) {
		this.ls3 = ls3;
	}

	public CommandedDish getCommandedDish2() {
		return commandedDish2;
	}

	public void setCommandedDish2(CommandedDish commandedDish2) {
		this.commandedDish2 = commandedDish2;
	}
	public String getSelectedDate() {
		return selectedDate;
	}
	public void setSelectedDate(String selectedDate) {
		this.selectedDate = selectedDate;
	}


	
}
