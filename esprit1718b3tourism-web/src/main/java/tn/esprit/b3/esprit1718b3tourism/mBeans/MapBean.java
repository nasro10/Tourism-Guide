package tn.esprit.b3.esprit1718b3tourism.mBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.map.GeocodeEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.GeocodeResult;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import tn.esprit.b3.esprit1718b3tourism.entities.Hotel;


@ManagedBean
@SessionScoped
public class MapBean {
	@ManagedProperty(value="#{hotels}")
	private Hotels hotels;
	
	private Hotel h = new Hotel();
	
	void placeHotel(){
		h.getCountry();
	}
	
	public MapBean(){
		
	}
	 private MapModel geoModel;
	    private String centerGeoMap = "36.89839200000001, 10.189732000000049";
	     
	    @PostConstruct
	    public void init() {
	        geoModel = new DefaultMapModel();
	    }
	     
	    public void onGeocode(GeocodeEvent event) {
	        List<GeocodeResult> results = event.getResults();
	         
	        if (results != null && !results.isEmpty()) {
	            LatLng center = results.get(0).getLatLng();
	            centerGeoMap = center.getLat() + "," + center.getLng();
	             
	            for (int i = 0; i < results.size(); i++) {
	                GeocodeResult result = results.get(i);
	                geoModel.addOverlay(new Marker(result.getLatLng(), result.getAddress()));
	            }
	        }
	    }
	     
	  
	 
	    public MapModel getGeoModel() {
	        return geoModel;
	    }
	 
	   
	 
	    public String getCenterGeoMap() {
	        return centerGeoMap;
	    }

		public Hotels getHotels() {
			return hotels;
		}

		public void setHotels(Hotels hotels) {
			this.hotels = hotels;
		}

		public Hotel getH() {
			return h;
		}

		public void setH(Hotel h) {
			this.h = h;
		}

		public void setGeoModel(MapModel geoModel) {
			this.geoModel = geoModel;
		}

		public void setCenterGeoMap(String centerGeoMap) {
			this.centerGeoMap = centerGeoMap;
		}
	 
	   
}