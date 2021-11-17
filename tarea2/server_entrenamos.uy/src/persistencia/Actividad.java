package persistencia;

import javax.persistence.*;


import java.io.Serializable;
import java.util.Date;

@Entity
public class Actividad implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;
	private String descripcion;
	private Float duracion;
	private Float costo;
	private Date fecha_alta;
	private Long id_profesor; // FK !!
	
	/* ---------
	 * GET & SET *
	   --------- */
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Float getDuracion() {
		return duracion;
	}
	public void setDuracion(float duracion) {
		this.duracion = duracion;
	}
	
	public Float getCosto() {
		return costo;
	}
	public void setCosto(Float costo) {
		this.costo = costo;
	}
	
	public Date getFecha_alta() {
		return fecha_alta;
	}
	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}
	
	public long getId_profesor() {
		return id_profesor;
	}
	public void setId_profesor(Long id_profesor) {
		this.id_profesor = id_profesor;
	}
	
	/* ----------------------
	 * Equals & HashCode *
	   ---------------------*/
	
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
	
	@Override
    public boolean equals(Object object) {
        if (!(object instanceof Actividad)) {
            return false;
        }
        Actividad other = (Actividad) object;
        if ( (this.id == null && other.id != null) ||
        		(this.id != null && !this.id.equals(other.id)) ) {
            return false;
        }
        return true;
    }
	
	/* ------------------------
	 * ToString() para testing *
	   ------------------------*/
	
	@Override
	public String toString() {
		return "Actividad {\n" 
				+ "\t nombre: " + nombre + "\n"
				+ "\t descripcion: " + descripcion + "\n"
				+ "\t costo: " + costo.toString() + "\n"
				+ "\t duracion: " + duracion.toString() + "\n"
				+ "\t fecha_alta: " + fecha_alta.toString() + "\n"
				+ "}";
	}
}
