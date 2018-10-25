package tn.esprit.b3.esprit1718b3tourism.mBeans;

import java.util.ArrayList;
import java.util.List;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.b3.esprit1718b3tourism.entities.TableR;
import tn.esprit.b3.esprit1718b3tourism.services.TableRServiceLocal;

@ManagedBean
@SessionScoped
public class AvailableTableBean {
	@EJB
	private TableRServiceLocal tableServiceLocal;
	private List<TableR> lsTable=new ArrayList<TableR>();
	private TableR selectedTable;
	
	public String passReservation()
	{	System.out.println("********** "+selectedTable.getIdTable());
		String navigateTo = "";
		navigateTo = "/reservationTable?faces-redirect=true";
		return navigateTo;
	}
	
	
	
	
	public List<TableR> getLsTable() {
		return tableServiceLocal.findTableByEtat();
	}
	public void setLsTable(List<TableR> lsTable) {
		this.lsTable = lsTable;
	}
	public TableR getSelectedTable() {
		return selectedTable;
	}
	public void setSelectedTable(TableR selectedTable) {
		this.selectedTable = selectedTable;
	}
	
	
	
	

}
