package persistencia;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

public class ServicioActividades {
	
	protected EntityManager em;
	
	public ServicioActividades(EntityManager em) {
		this.em = em;
	}
	
	public Actividad crearActividad(String nombre, String descripcion,
			float duracion, float costo, Date fecha_alta, Long id_profesor)
	{
		Actividad act = new Actividad();
		act.setNombre(nombre);
		act.setDescripcion(descripcion);
		act.setDuracion(duracion);
		act.setCosto(costo);
		act.setFecha_alta(fecha_alta);
		act.setId_profesor(id_profesor);
		
		em.persist(act);
		return act;
	}
	
	public List<Actividad> findAllActividades() {
		TypedQuery<Actividad> query = em.createQuery(
				"SELECT a FROM Actividad a", Actividad.class);
		return query.getResultList();
	}
}
