
package publicadores;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WebServicesControladorUsuario", targetNamespace = "http://Publicadores/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WebServicesControladorUsuario {


    /**
     * 
     * @return
     *     returns publicadores.WrapperListString
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores/WebServicesControladorUsuario/usuariosEnSistemaNickNameRequest", output = "http://Publicadores/WebServicesControladorUsuario/usuariosEnSistemaNickNameResponse")
    public WrapperListString usuariosEnSistemaNickName();

    /**
     * 
     * @param arg0
     * @throws UsuarioDisponibilidadException_Exception
     */
    @WebMethod
    @Action(input = "http://Publicadores/WebServicesControladorUsuario/altaUsuarioRequest", output = "http://Publicadores/WebServicesControladorUsuario/altaUsuarioResponse", fault = {
        @FaultAction(className = UsuarioDisponibilidadException_Exception.class, value = "http://Publicadores/WebServicesControladorUsuario/altaUsuario/Fault/UsuarioDisponibilidadException")
    })
    public void altaUsuario(
        @WebParam(name = "arg0", partName = "arg0")
        InfoBasicaUser arg0)
        throws UsuarioDisponibilidadException_Exception
    ;

    /**
     * 
     * @return
     *     returns publicadores.WrapperSetString
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores/WebServicesControladorUsuario/mostrarNicknameSociosRequest", output = "http://Publicadores/WebServicesControladorUsuario/mostrarNicknameSociosResponse")
    public WrapperSetString mostrarNicknameSocios();

    /**
     * 
     * @param arg0
     * @return
     *     returns publicadores.WrapperSetString
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores/WebServicesControladorUsuario/mostrarNombreProfesoresDeInstitucionRequest", output = "http://Publicadores/WebServicesControladorUsuario/mostrarNombreProfesoresDeInstitucionResponse")
    public WrapperSetString mostrarNombreProfesoresDeInstitucion(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @return
     *     returns publicadores.WrapperListString
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores/WebServicesControladorUsuario/institucionesEnSistemaRequest", output = "http://Publicadores/WebServicesControladorUsuario/institucionesEnSistemaResponse")
    public WrapperListString institucionesEnSistema();

    /**
     * 
     * @param arg0
     * @return
     *     returns publicadores.InformacionActividad
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores/WebServicesControladorUsuario/informacionActividadRequest", output = "http://Publicadores/WebServicesControladorUsuario/informacionActividadResponse")
    public InformacionActividad informacionActividad(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://Publicadores/WebServicesControladorUsuario/actualizarInformacionUsuarioRequest", output = "http://Publicadores/WebServicesControladorUsuario/actualizarInformacionUsuarioResponse")
    public void actualizarInformacionUsuario(
        @WebParam(name = "arg0", partName = "arg0")
        InfoBasicaUser arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns publicadores.InfoBasicaUser
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores/WebServicesControladorUsuario/informacionBasicaUsuarioRequest", output = "http://Publicadores/WebServicesControladorUsuario/informacionBasicaUsuarioResponse")
    public InfoBasicaUser informacionBasicaUsuario(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns publicadores.WrapperSetString
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores/WebServicesControladorUsuario/mostrarCuponerasDisponiblesRequest", output = "http://Publicadores/WebServicesControladorUsuario/mostrarCuponerasDisponiblesResponse")
    public WrapperSetString mostrarCuponerasDisponibles(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://Publicadores/WebServicesControladorUsuario/seguirUsuarioRequest", output = "http://Publicadores/WebServicesControladorUsuario/seguirUsuarioResponse")
    public void seguirUsuario(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://Publicadores/WebServicesControladorUsuario/dejarDeSeguirUsuarioRequest", output = "http://Publicadores/WebServicesControladorUsuario/dejarDeSeguirUsuarioResponse")
    public void dejarDeSeguirUsuario(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     * @throws UsuarioInexistenteException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores/WebServicesControladorUsuario/esSocioRequest", output = "http://Publicadores/WebServicesControladorUsuario/esSocioResponse", fault = {
        @FaultAction(className = UsuarioInexistenteException_Exception.class, value = "http://Publicadores/WebServicesControladorUsuario/esSocio/Fault/UsuarioInexistenteException")
    })
    public boolean esSocio(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws UsuarioInexistenteException_Exception
    ;

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns publicadores.WrapperStringNull
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores/WebServicesControladorUsuario/autenticarUsarioRequest", output = "http://Publicadores/WebServicesControladorUsuario/autenticarUsarioResponse")
    public WrapperStringNull autenticarUsario(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns publicadores.WrapperStringNull
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores/WebServicesControladorUsuario/autenticarUsarioMovilRequest", output = "http://Publicadores/WebServicesControladorUsuario/autenticarUsarioMovilResponse")
    public WrapperStringNull autenticarUsarioMovil(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores/WebServicesControladorUsuario/getNicknameUsuarioRequest", output = "http://Publicadores/WebServicesControladorUsuario/getNicknameUsuarioResponse")
    public String getNicknameUsuario(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns publicadores.WrapperListString
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores/WebServicesControladorUsuario/usuariosSiguiendoRequest", output = "http://Publicadores/WebServicesControladorUsuario/usuariosSiguiendoResponse")
    public WrapperListString usuariosSiguiendo(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns publicadores.WrapperListString
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores/WebServicesControladorUsuario/usuariosSeguidoresRequest", output = "http://Publicadores/WebServicesControladorUsuario/usuariosSeguidoresResponse")
    public WrapperListString usuariosSeguidores(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns publicadores.WrapperDataCuponera
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores/WebServicesControladorUsuario/cuponerasRequest", output = "http://Publicadores/WebServicesControladorUsuario/cuponerasResponse")
    public WrapperDataCuponera cuponeras(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns publicadores.InfoActividadProfe
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores/WebServicesControladorUsuario/informacionActDepEstadoIngRechRequest", output = "http://Publicadores/WebServicesControladorUsuario/informacionActDepEstadoIngRechResponse")
    public InfoActividadProfe informacionActDepEstadoIngRech(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores/WebServicesControladorUsuario/usuarioSigueAUsuarioRequest", output = "http://Publicadores/WebServicesControladorUsuario/usuarioSigueAUsuarioResponse")
    public boolean usuarioSigueAUsuario(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns publicadores.WrapperListString
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores/WebServicesControladorUsuario/getGanadoresDeClaseRequest", output = "http://Publicadores/WebServicesControladorUsuario/getGanadoresDeClaseResponse")
    public WrapperListString getGanadoresDeClase(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns publicadores.WrapperListDtPremio
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores/WebServicesControladorUsuario/getPremiosDeUsuarioRequest", output = "http://Publicadores/WebServicesControladorUsuario/getPremiosDeUsuarioResponse")
    public WrapperListDtPremio getPremiosDeUsuario(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @return
     *     returns publicadores.InfoBasicaSocio
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores/WebServicesControladorUsuario/sinProposito1Request", output = "http://Publicadores/WebServicesControladorUsuario/sinProposito1Response")
    public InfoBasicaSocio sinProposito1();

    /**
     * 
     * @return
     *     returns publicadores.InfoBasicaProfesor
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores/WebServicesControladorUsuario/sinProposito2Request", output = "http://Publicadores/WebServicesControladorUsuario/sinProposito2Response")
    public InfoBasicaProfesor sinProposito2();

    /**
     * 
     * @return
     *     returns publicadores.InfoActividadProfe
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores/WebServicesControladorUsuario/sinProposito3Request", output = "http://Publicadores/WebServicesControladorUsuario/sinProposito3Response")
    public InfoActividadProfe sinProposito3();

    /**
     * 
     * @return
     *     returns publicadores.InfoActividadSocio
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores/WebServicesControladorUsuario/sinProposito4Request", output = "http://Publicadores/WebServicesControladorUsuario/sinProposito4Response")
    public InfoActividadSocio sinProposito4();

    /**
     * 
     * @param arg0
     * @return
     *     returns publicadores.InfoActividadProfe
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores/WebServicesControladorUsuario/todasLasActividadesDeUnProfesorRequest", output = "http://Publicadores/WebServicesControladorUsuario/todasLasActividadesDeUnProfesorResponse")
    public InfoActividadProfe todasLasActividadesDeUnProfesor(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

}
