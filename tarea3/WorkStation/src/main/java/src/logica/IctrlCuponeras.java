package src.logica;

import java.util.Date;
import java.util.Set;

import src.excepciones.*;




public interface IctrlCuponeras {
	
	public abstract boolean registrarCuponera(String nombre, String descrip, Date fecha_ini, Date fecha_fin, Float descuento, Date fecha_alta, String imagen) throws CuponeraRepetidaException;
	public abstract Set<String> listarCuponeras() throws CuponeraNoExisteException;
	
	public abstract Set<String> listarActividadesfaltantes(String nomcup, String nominst)throws ActividadDeportivaNoExisteException;
	
	public abstract void agregarActividad(String nomcup, String act, int numclase)throws ActividadDeportivaRepetidaException ;

	public abstract DataCuponera mostrarCuponera(String nomCup)throws CuponeraNoExisteException; 
	
	public abstract Set<String> getCuponerasActividad(String nac) throws CuponeraNoExisteException;

	public abstract void cargarDatosCuponeras();
	public abstract Set<String> listarcuponeraslibres() throws CuponeraNoExisteException ;
	public abstract void comprarCuponera(Date fecha, String cuponera, String nomsocio) throws CuponeraCompradaException;
	public abstract Set<String> getCuponerasCategoria(String cat);
	public abstract Set<String> getCuponerasInstitucion(String inst);
	public abstract Set<String> getCuponerasAD(String act); 
	
	public abstract Set<DataCuponera> buscarCuponeras(String consulta)throws CuponeraNoExisteException;
}
