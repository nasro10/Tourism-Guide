package tn.esprit.b3.esprit1718b3tourism.mBeans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import tn.esprit.b3.esprit1718b3tourism.entities.TableR;
import tn.esprit.b3.esprit1718b3tourism.services.TableRServiceLocal;

@ManagedBean
@ViewScoped
public class UpdateTableBean {
	@EJB
	private TableRServiceLocal tableServiceLocal;
	@ManagedProperty(value="#{table}")
	 private TableBean table;
	private TableR tableSel;
	
	public void doUpdate()
	{ 
	
		tableServiceLocal.update(table.getSelectedTable());
	}
	
	public String afficher()
	{
		String navigateTo = "";
		navigateTo = "/table?faces-redirect=true";
		return navigateTo;
	}
	
	public TableBean getTable() {
		return table;
	}
	public void setTable(TableBean table) {
		this.table = table;
	}
	public TableR getTableSel() {
		return tableSel;
	}
	public void setTableSel(TableR tableSel) {
		this.tableSel = tableSel;
	}
	
	
	
	
	
	
}
