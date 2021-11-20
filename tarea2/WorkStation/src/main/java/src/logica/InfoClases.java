package src.logica;



public class InfoClases {
	private int cantidad;
	private ActividadDeportiva act;
	
	public InfoClases(ActividadDeportiva act, int cant) {
		this.act = act;
		this.cantidad = cant;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public ActividadDeportiva getAct() {
		return act;
	}
	public void setAct(ActividadDeportiva act) {
		this.act = act;
	}
	public String getNombreActividadDeportiva() {
		return act.getNombre();
	}

}
