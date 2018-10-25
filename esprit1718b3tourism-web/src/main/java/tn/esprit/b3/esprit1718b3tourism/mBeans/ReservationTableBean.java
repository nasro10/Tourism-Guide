package tn.esprit.b3.esprit1718b3tourism.mBeans;


import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import tn.esprit.b3.esprit1718b3tourism.entities.ReservationTable;
import tn.esprit.b3.esprit1718b3tourism.entities.TableR;
import tn.esprit.b3.esprit1718b3tourism.services.ReservationTableServiceLocal;
import tn.esprit.b3.esprit1718b3tourism.services.TableRServiceLocal;



@ManagedBean
@ViewScoped
public class ReservationTableBean {
	@EJB
	private ReservationTableServiceLocal reservationTableLocal;
	@EJB
	private TableRServiceLocal tableServiceLocal;
	@ManagedProperty(value="#{identity}")
	 private Identity identity;
	@ManagedProperty(value="#{availableTableBean}")
	private AvailableTableBean availabletableBean;
	private ReservationTable reservationTable;
	private Date dateRes;
	private String heureRes;
	private Integer nbPersonne;
	private TableR table;
	
	public void doInsert()
	{
		reservationTable=new ReservationTable(dateRes,heureRes,nbPersonne,identity.getUser(),availabletableBean.getSelectedTable());
		table=tableServiceLocal.find(availabletableBean.getSelectedTable().getIdTable());
		table.setAvailable("false");
		
		reservationTableLocal.save(reservationTable);
		tableServiceLocal.update(table);
	}
	
	public Identity getIdentity() {
		return identity;
	}
	public void setIdentity(Identity identity) {
		this.identity = identity;
	}
	public AvailableTableBean getAvailabletableBean() {
		return availabletableBean;
	}
	public void setAvailabletableBean(AvailableTableBean availabletableBean) {
		this.availabletableBean = availabletableBean;
	}
	public ReservationTable getReservationTable() {
		return reservationTable;
	}
	public void setReservationTable(ReservationTable reservationTable) {
		this.reservationTable = reservationTable;
	}
	public Date getDateRes() {
		return dateRes;
	}
	public void setDateRes(Date dateRes) {
		this.dateRes = dateRes;
	}
	public String getHeureRes() {
		return heureRes;
	}
	public void setHeureRes(String heureRes) {
		this.heureRes = heureRes;
	}
	public Integer getNbPersonne() {
		return nbPersonne;
	}
	public void setNbPersonne(Integer nbPersonne) {
		this.nbPersonne = nbPersonne;
	}

	public TableR getTable() {
		return table;
	}

	public void setTable(TableR table) {
		this.table = table;
	}
	
	
	
	
	

}
