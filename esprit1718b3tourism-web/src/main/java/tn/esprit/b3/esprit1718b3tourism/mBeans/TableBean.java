package tn.esprit.b3.esprit1718b3tourism.mBeans;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import tn.esprit.b3.esprit1718b3tourism.entities.TableR;
import tn.esprit.b3.esprit1718b3tourism.services.TableRServiceLocal;

@ManagedBean
@SessionScoped
public class TableBean {
	@EJB
	private TableRServiceLocal tableServiceLocal;
	private List<TableR> lsTable=new ArrayList<TableR>();
	TableR table=new TableR();
	private TableR selectedTable;
	private TableR TableUpdate;
	private Date date3;

	public TableBean() {
		super();
	}

	public void doInsert()
	{
		
		tableServiceLocal.save(table);
	}
	public String PassUpdate()
	{
		String navigateTo = "";
		navigateTo = "/updateTable?faces-redirect=true";
		return navigateTo;
	}
	
	public void afficher()
	{
		System.out.println("*********** "+getSelectedTable().getIdTable());
	}
	
	
	public void doDelete()
	{
		tableServiceLocal.delete(selectedTable);
	}
	
	public void doUpdate()
	{
		tableServiceLocal.update(selectedTable);
	}

	     
	 

	public TableR getTable() {
		return table;
	}


	public void setTable(TableR table) {
		this.table = table;
	}

	public List<TableR> getLsTable() {
		return tableServiceLocal.findAll();
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

	public TableR getTableUpdate() {
		return TableUpdate;
	}

	public void setTableUpdate(TableR tableUpdate) {
		TableUpdate = tableUpdate;
	}

	public Date getDate3() {
		return date3;
	}

	public void setDate3(Date date3) {
		this.date3 = date3;
	}

	

}
