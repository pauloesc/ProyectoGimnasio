/**
 * 
 */
package logica;

import java.util.Date;
import java.util.Map;

public class Compra {

		private Date fecha;
		private Cuponera cup;
		private Map<String,Integer> cantClases;
		
		public Integer clasesDisponibles(String act) {
			return cantClases.get(act);
		}
		
		public String getNombreCuponera() {
			return cup.getNombre();
		}
		
		public Date comienzoCuponera() {
			return cup.getFecha_ini();
		}
		
		public Date vencimientoCuponera() {
			return cup.getFecha_fin();
		}
		
		public Float getDescuento() {
			return cup.getDescuento();
		}
		
		public Date getFCompra() {
			return fecha;
		}
		
		public void descontarClase(String actDept) {
			Integer Cclas = cantClases.get(actDept);
			cantClases.remove(actDept);
			cantClases.put(actDept, Cclas);
		}
}
