
package src.publicadores;

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
@WebService(name = "WebServicesControladorUsuario", targetNamespace = "http://Publicadores.src/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WebServicesControladorUsuario {


    /**
     * 
     * @param arg0
     * @throws UsuarioDisponibilidadException_Exception
     */
    @WebMethod
    @Action(input = "http://Publicadores.src/WebServicesControladorUsuario/altaUsuarioRequest", output = "http://Publicadores.src/WebServicesControladorUsuario/altaUsuarioResponse", fault = {
        @FaultAction(className = UsuarioDisponibilidadException_Exception.class, value = "http://Publicadores.src/WebServicesControladorUsuario/altaUsuario/Fault/UsuarioDisponibilidadException")
    })
    public void altaUsuario(
        @WebParam(name = "arg0", partName = "arg0")
        InfoBasicaUser arg0)
        throws UsuarioDisponibilidadException_Exception
    ;

    /**
     * 
     * @return
     *     returns src.publicadores.WrapperSetString
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores.src/WebServicesControladorUsuario/mostrarNicknameSociosRequest", output = "http://Publicadores.src/WebServicesControladorUsuario/mostrarNicknameSociosResponse")
    public WrapperSetString mostrarNicknameSocios();

    /**
     * 
     * @return
     *     returns src.publicadores.WrapperListString
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores.src/WebServicesControladorUsuario/usuariosEnSistemaNickNameRequest", output = "http://Publicadores.src/WebServicesControladorUsuario/usuariosEnSistemaNickNameResponse")
    public WrapperListString usuariosEnSistemaNickName();

    /**
     * 
     * @param arg0
     * @return
     *     returns src.publicadores.WrapperSetString
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores.src/WebServicesControladorUsuario/mostrarNombreProfesoresDeInstitucionRequest", output = "http://Publicadores.src/WebServicesControladorUsuario/mostrarNombreProfesoresDeInstitucionResponse")
    public WrapperSetString mostrarNombreProfesoresDeInstitucion(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @return
     *     returns src.publicadores.WrapperListString
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores.src/WebServicesControladorUsuario/institucionesEnSistemaRequest", output = "http://Publicadores.src/WebServicesControladorUsuario/institucionesEnSistemaResponse")
    public WrapperListString institucionesEnSistema();

    /**
     * 
     * @param arg0
     * @return
     *     returns src.publicadores.InformacionActividad
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores.src/WebServicesControladorUsuario/informacionActividadRequest", output = "http://Publicadores.src/WebServicesControladorUsuario/informacionActividadResponse")
    public InformacionActividad informacionActividad(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://Publicadores.src/WebServicesControladorUsuario/actualizarInformacionUsuarioRequest", output = "http://Publicadores.src/WebServicesControladorUsuario/actualizarInformacionUsuarioResponse")
    public void actualizarInformacionUsuario(
        @WebParam(name = "arg0", partName = "arg0")
        InfoBasicaUser arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns src.publicadores.InfoBasicaUser
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores.src/WebServicesControladorUsuario/informacionBasicaUsuarioRequest", output = "http://Publicadores.src/WebServicesControladorUsuario/informacionBasicaUsuarioResponse")
    public InfoBasicaUser informacionBasicaUsuario(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns src.publicadores.WrapperSetString
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores.src/WebServicesControladorUsuario/mostrarCuponerasDisponiblesRequest", output = "http://Publicadores.src/WebServicesControladorUsuario/mostrarCuponerasDisponiblesResponse")
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
    @Action(input = "http://Publicadores.src/WebServicesControladorUsuario/seguirUsuarioRequest", output = "http://Publicadores.src/WebServicesControladorUsuario/seguirUsuarioResponse")
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
    @Action(input = "http://Publicadores.src/WebServicesControladorUsuario/dejarDeSeguirUsuarioRequest", output = "http://Publicadores.src/WebServicesControladorUsuario/dejarDeSeguirUsuarioResponse")
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
    @Action(input = "http://Publicadores.src/WebServicesControladorUsuario/esSocioRequest", output = "http://Publicadores.src/WebServicesControladorUsuario/esSocioResponse", fault = {
        @FaultAction(className = UsuarioInexistenteException_Exception.class, value = "http://Publicadores.src/WebServicesControladorUsuario/esSocio/Fault/UsuarioInexistenteException")
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
     *     returns src.publicadores.WrapperStringNull
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores.src/WebServicesControladorUsuario/autenticarUsarioRequest", output = "http://Publicadores.src/WebServicesControladorUsuario/autenticarUsarioResponse")
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
     *     returns src.publicadores.WrapperStringNull
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores.src/WebServicesControladorUsuario/autenticarUsarioMovilRequest", output = "http://Publicadores.src/WebServicesControladorUsuario/autenticarUsarioMovilResponse")
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
    @Action(input = "http://Publicadores.src/WebServicesControladorUsuario/getNicknameUsuarioRequest", output = "http://Publicadores.src/WebServicesControladorUsuario/getNicknameUsuarioResponse")
    public String getNicknameUsuario(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns src.publicadores.WrapperListString
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores.src/WebServicesControladorUsuario/usuariosSiguiendoRequest", output = "http://Publicadores.src/WebServicesControladorUsuario/usuariosSiguiendoResponse")
    public WrapperListString usuariosSiguiendo(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns src.publicadores.WrapperListString
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores.src/WebServicesControladorUsuario/usuariosSeguidoresRequest", output = "http://Publicadores.src/WebServicesControladorUsuario/usuariosSeguidoresResponse")
    public WrapperListString usuariosSeguidores(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns src.publicadores.WrapperDataCuponera
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores.src/WebServicesControladorUsuario/cuponerasRequest", output = "http://Publicadores.src/WebServicesControladorUsuario/cuponerasResponse")
    public WrapperDataCuponera cuponeras(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns src.publicadores.InfoActividadProfe
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores.src/WebServicesControladorUsuario/informacionActDepEstadoIngRechRequest", output = "http://Publicadores.src/WebServicesControladorUsuario/informacionActDepEstadoIngRechResponse")
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
    @Action(input = "http://Publicadores.src/WebServicesControladorUsuario/usuarioSigueAUsuarioRequest", output = "http://Publicadores.src/WebServicesControladorUsuario/usuarioSigueAUsuarioResponse")
    public boolean usuarioSigueAUsuario(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns src.publicadores.WrapperListString
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores.src/WebServicesControladorUsuario/getGanadoresDeClaseRequest", output = "http://Publicadores.src/WebServicesControladorUsuario/getGanadoresDeClaseResponse")
    public WrapperListString getGanadoresDeClase(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns src.publicadores.WrapperListDtPremio
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores.src/WebServicesControladorUsuario/getPremiosDeUsuarioRequest", output = "http://Publicadores.src/WebServicesControladorUsuario/getPremiosDeUsuarioResponse")
    public WrapperListDtPremio getPremiosDeUsuario(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @return
     *     returns src.publicadores.InfoBasicaSocio
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores.src/WebServicesControladorUsuario/sinProposito1Request", output = "http://Publicadores.src/WebServicesControladorUsuario/sinProposito1Response")
    public InfoBasicaSocio sinProposito1();

    /**
     * 
     * @return
     *     returns src.publicadores.InfoBasicaProfesor
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores.src/WebServicesControladorUsuario/sinProposito2Request", output = "http://Publicadores.src/WebServicesControladorUsuario/sinProposito2Response")
    public InfoBasicaProfesor sinProposito2();

    /**
     * 
     * @return
     *     returns src.publicadores.InfoActividadProfe
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores.src/WebServicesControladorUsuario/sinProposito3Request", output = "http://Publicadores.src/WebServicesControladorUsuario/sinProposito3Response")
    public InfoActividadProfe sinProposito3();

    /**
     * 
     * @return
     *     returns src.publicadores.InfoActividadSocio
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores.src/WebServicesControladorUsuario/sinProposito4Request", output = "http://Publicadores.src/WebServicesControladorUsuario/sinProposito4Response")
    public InfoActividadSocio sinProposito4();

    /**
     * 
     * @param arg0
     * @return
     *     returns src.publicadores.InfoActividadProfe
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores.src/WebServicesControladorUsuario/todasLasActividadesDeUnProfesorRequest", output = "http://Publicadores.src/WebServicesControladorUsuario/todasLasActividadesDeUnProfesorResponse")
    public InfoActividadProfe todasLasActividadesDeUnProfesor(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns src.publicadores.WrapperListaUsuarios
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Publicadores.src/WebServicesControladorUsuario/darParticipantesRequest", output = "http://Publicadores.src/WebServicesControladorUsuario/darParticipantesResponse")
    public WrapperListaUsuarios darParticipantes(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

}
