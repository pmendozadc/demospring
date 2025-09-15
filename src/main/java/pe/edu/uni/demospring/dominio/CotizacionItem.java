package pe.edu.uni.demospring.dominio;

public class CotizacionItem {

	private String productoNombre;
	
	private int cantidad;
	
	private double monto;

	public CotizacionItem(String productoNombre, int cantidad, double monto) {
		super();
		this.productoNombre = productoNombre;
		this.cantidad = cantidad;
		this.monto = monto;
	}

	public String getProductoNombre() {
		return productoNombre;
	}

	public void setProductoNombre(String productoNombre) {
		this.productoNombre = productoNombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}
	
	
}
