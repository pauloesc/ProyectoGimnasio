package persistencia;

import javax.persistence.*;
import java.util.List;
import java.util.Date;

public class TestPersistencia {

	public static void main(String[] args) {
		
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("SPA");
		EntityManager em = emf.createEntityManager();
		ServicioActividades service = new ServicioActividades(em);
		
		/*
		 * Crear y persistir actividad
		 */
		em.getTransaction().begin();
		Actividad act = service.crearActividad("Pruebita",
				"Es una prueba", 10, 30, new Date(), new Long(10000));
		em.getTransaction().commit();
		System.out.println("Persistida " + act);
		
		/*
		 * Imprimir todas las actividades persistidas
		 */
		List<Actividad> actividades = service.findAllActividades();
		for (Actividad actividad : actividades) {
			System.out.println( actividad.toString() );
		}
		
		em.close();
		emf.close();
	}
}
