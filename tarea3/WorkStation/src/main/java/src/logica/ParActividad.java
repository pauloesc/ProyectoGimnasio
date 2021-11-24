package src.logica;


public class ParActividad {

    
	private String nombre;
    private int numclase;
	
   
	public ParActividad(String nombre, int numclase) {
		this.nombre = nombre;
		this.numclase = numclase;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getNumclase() {
		return numclase;
	}
	
	public void setNumclase(int numclase) {
		this.numclase = numclase;
	}
    	
}
