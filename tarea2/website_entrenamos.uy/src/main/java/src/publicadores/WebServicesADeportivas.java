
package src.publicadores;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import net.java.dev.jaxb.array.StringArray;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WebServicesADeportivas", targetNamespace = "http://Publicadores.src/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    net.java.dev.jaxb.array.ObjectFactory.class,
    src.publicadores.ObjectFactory.class
})
public interface WebServicesADeportivas {


    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://Publicadores.src/WebServicesADeportivas/cambiarEstadoRequest", output = "http://Publicadores.src/WebServicesADeportivas/cambiarEstadoResponse")
    public void cambiarEstado(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        EstadoActi arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns net.java.dev.jaxb.array.StringArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores.src/WebServicesADeportivas/getActividadesCategoriaRequest", output = "http://Publicadores.src/WebServicesADeportivas/getActividadesCategoriaResponse")
    public StringArray getActividadesCategoria(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns net.java.dev.jaxb.array.StringArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores.src/WebServicesADeportivas/mostrarClasesVigentesDeActividadDeportivaRequest", output = "http://Publicadores.src/WebServicesADeportivas/mostrarClasesVigentesDeActividadDeportivaResponse")
    public StringArray mostrarClasesVigentesDeActividadDeportiva(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns src.publicadores.DataActividadArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores.src/WebServicesADeportivas/buscarActividadesRequest", output = "http://Publicadores.src/WebServicesADeportivas/buscarActividadesResponse")
    public DataActividadArray buscarActividades(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @return
     *     returns src.publicadores.DataActividadArray
     * @throws ActividadDeportivaNoExisteException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores.src/WebServicesADeportivas/getDataActividadesIngresadasRequest", output = "http://Publicadores.src/WebServicesADeportivas/getDataActividadesIngresadasResponse", fault = {
        @FaultAction(className = ActividadDeportivaNoExisteException_Exception.class, value = "http://Publicadores.src/WebServicesADeportivas/getDataActividadesIngresadas/Fault/ActividadDeportivaNoExisteException")
    })
    public DataActividadArray getDataActividadesIngresadas()
        throws ActividadDeportivaNoExisteException_Exception
    ;

    /**
     * 
     * @return
     *     returns src.publicadores.WrapperSetDtClase
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores.src/WebServicesADeportivas/getTodasLasClasesRequest", output = "http://Publicadores.src/WebServicesADeportivas/getTodasLasClasesResponse")
    public WrapperSetDtClase getTodasLasClases();

    /**
     * 
     * @param arg0
     * @return
     *     returns src.publicadores.DataActividadArray
     * @throws ActividadDeportivaNoExisteException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores.src/WebServicesADeportivas/getActividadesRequest", output = "http://Publicadores.src/WebServicesADeportivas/getActividadesResponse", fault = {
        @FaultAction(className = ActividadDeportivaNoExisteException_Exception.class, value = "http://Publicadores.src/WebServicesADeportivas/getActividades/Fault/ActividadDeportivaNoExisteException")
    })
    public DataActividadArray getActividades(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws ActividadDeportivaNoExisteException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns src.publicadores.DataActividad
     * @throws ActividadDeportivaNoExisteException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores.src/WebServicesADeportivas/getDataActividadRequest", output = "http://Publicadores.src/WebServicesADeportivas/getDataActividadResponse", fault = {
        @FaultAction(className = ActividadDeportivaNoExisteException_Exception.class, value = "http://Publicadores.src/WebServicesADeportivas/getDataActividad/Fault/ActividadDeportivaNoExisteException")
    })
    public DataActividad getDataActividad(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws ActividadDeportivaNoExisteException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns net.java.dev.jaxb.array.StringArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores.src/WebServicesADeportivas/darNombresActividadesDeportivasRequest", output = "http://Publicadores.src/WebServicesADeportivas/darNombresActividadesDeportivasResponse")
    public StringArray darNombresActividadesDeportivas(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg5
     * @param arg4
     * @param arg1
     * @param arg0
     * @param arg7
     * @param arg6
     * @param arg8
     * @throws ActividadDeportivaRepetidaException_Exception
     */
    @WebMethod
    @Action(input = "http://Publicadores.src/WebServicesADeportivas/altaActividadDeportivaRequest", output = "http://Publicadores.src/WebServicesADeportivas/altaActividadDeportivaResponse", fault = {
        @FaultAction(className = ActividadDeportivaRepetidaException_Exception.class, value = "http://Publicadores.src/WebServicesADeportivas/altaActividadDeportiva/Fault/ActividadDeportivaRepetidaException")
    })
    public void altaActividadDeportiva(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        float arg4,
        @WebParam(name = "arg5", partName = "arg5")
        float arg5,
        @WebParam(name = "arg6", partName = "arg6")
        XMLGregorianCalendar arg6,
        @WebParam(name = "arg7", partName = "arg7")
        StringArray arg7,
        @WebParam(name = "arg8", partName = "arg8")
        String arg8)
        throws ActividadDeportivaRepetidaException_Exception
    ;

    /**
     * 
     * @return
     *     returns net.java.dev.jaxb.array.StringArray
     * @throws ActividadDeportivaNoExisteException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores.src/WebServicesADeportivas/getActividadesIngresadasRequest", output = "http://Publicadores.src/WebServicesADeportivas/getActividadesIngresadasResponse", fault = {
        @FaultAction(className = ActividadDeportivaNoExisteException_Exception.class, value = "http://Publicadores.src/WebServicesADeportivas/getActividadesIngresadas/Fault/ActividadDeportivaNoExisteException")
    })
    public StringArray getActividadesIngresadas()
        throws ActividadDeportivaNoExisteException_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     * @throws IOException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores.src/WebServicesADeportivas/saveFileRequest", output = "http://Publicadores.src/WebServicesADeportivas/saveFileResponse", fault = {
        @FaultAction(className = IOException_Exception.class, value = "http://Publicadores.src/WebServicesADeportivas/saveFile/Fault/IOException")
    })
    public boolean saveFile(
        @WebParam(name = "arg0", partName = "arg0")
        byte[] arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1)
        throws IOException_Exception
    ;

    /**
     * 
     * @return
     *     returns src.publicadores.DataActividad
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores.src/WebServicesADeportivas/newDataActividadRequest", output = "http://Publicadores.src/WebServicesADeportivas/newDataActividadResponse")
    public DataActividad newDataActividad();

}
