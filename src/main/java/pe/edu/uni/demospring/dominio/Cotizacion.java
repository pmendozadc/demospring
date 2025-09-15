package pe.edu.uni.demospring.dominio;

import java.util.List;

public class Cotizacion {

	private int id; 
	
	private List<CotizacionItem> items;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<CotizacionItem> getItems() {
		return items;
	}

	public void setItems(List<CotizacionItem> items) {
		this.items = items;
	}
	
	 
}
