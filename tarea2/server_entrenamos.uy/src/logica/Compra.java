package logica;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Compra {

		private Date fecha;
		private Cuponera cup;
		private Map<String, Integer> cantClases;
		
		
		public Compra(Date fec, Cuponera cupo, Set<String> act) {
			this.fecha = fec;
			this.cup = cupo;
			if (!cupo.isComprada()) {
				cupo.setComprada(true);
			}
			this.cantClases = new HashMap<String, Integer>();


			Set<InfoClases> inf = cupo.getInfo();
			
			for (Iterator<InfoClases> iter=inf.iterator(); iter.hasNext();) {
				this.cantClases.put(iter.next().getAct().getNombre(), iter.next().getCantidad());
			
			}
		}
		
		
		public Integer clasesDisponibles(String act) {
			Integer res = cantClases.get(act);
			if (res != null) {
				return res;
			} else {
				return 0;
			}
			
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
		
		public void descontarClase(String actDept) {
			Integer Cclas = cantClases.get(actDept);
			cantClases.remove(actDept);
			cantClases.put(actDept, Cclas-1);
		}

		public boolean tienecuponera(String nombre) {
			return nombre == cup.getNombre();
			
		}
		
		public Cuponera getCup() {
			return cup;
		}

		public Date getFechaCompra() {
			return fecha;
		}
		
		public DataCuponera DarInformacionCuponera() {
			return cup.getDataCuponera();
		}
}
