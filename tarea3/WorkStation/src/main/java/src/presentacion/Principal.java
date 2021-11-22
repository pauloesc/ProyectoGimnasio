package src.presentacion;

import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.xml.ws.Endpoint;

import Publicadores.WebServicesClases;
import Publicadores.WebServicesControladorUsuario;
import Publicadores.WebServicesCuponeras;
import Publicadores.WebServicesADeportivas;
import Publicadores.WebServicesIDeportivas;
import Publicadores.WebServicesCategorias;

import src.excepciones.ActividadDeportivaNoExisteException;
import src.logica.Fabrica;
import src.logica.IctrlADeportivas;
import src.logica.IctrlCategorias;
import src.logica.IctrlClases;
import src.logica.IctrlCuponeras;
import src.logica.IctrlIDeportivas;
import src.logica.IctrlUsuarios;

import javax.swing.JMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;


public class Principal {
	
	public static Principal instancia = null;

    private JFrame entrenamosUy;
    private JDesktopPane desktopPane;
    private AltaInstitucionDeportiva altaInstDeportivaInternalFrame;
    private AltaActividadDeportiva altaActividadDeportivaInternalFrame;
    public ConsultaActividadDeportiva consultaActividadDeportivaInternalFrame;
    private AltaDictadoDeClases altaDictadoDeClasesInternalFrame;
    private CrearCuponera CrearCuponeraInternalFrame;
    public ConsultaDictadoDeClases consultaDictadoDeClasesFrame;
    private AltaUsuario AltaUsuarioInternalFrame;
    private AgregarActividadaCuponera AgregarActividadaCuponeraInternalFrame;
    private ConsultarCuponera ConsultarCuponeraInternalFrame;
    private RegistroDictadoDeClases RegistroDictadoDeClasesFrame;   
    private AltaCategoria AltaCategoriaFrame;
    private IctrlIDeportivas ICID;
    private IctrlADeportivas ICAD;
    private IctrlCuponeras ICC;
    private IctrlClases ICCL;
    private IctrlUsuarios IUSR;
    private IctrlCategorias ICAT;
    private ConsultaUsuario ConsultaUsuarioInternalFrame;  
    private ModificarUsuario ModificarUsuarioInternalFrame;
    private AceptaRechazaActividadDeportiva AceptaRechazaADInternalFrame;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Principal window = Principal.getInstance();
                    window.entrenamosUy.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        WebServicesControladorUsuario wscu = new WebServicesControladorUsuario();
        wscu.publicar();
        WebServicesCuponeras wsc = new WebServicesCuponeras();
        wsc.publicar();
        WebServicesIDeportivas wsi = new WebServicesIDeportivas();
        wsi.publicar();
        WebServicesClases wscl = new WebServicesClases();
        wscl.publicar();
	WebServicesCategorias wscat = new WebServicesCategorias();
        wscat.publicar();
        WebServicesADeportivas wsa = new WebServicesADeportivas();
        wsa.publicar();
        
    }

    public static Principal getInstance() {
    	if (instancia == null)
    		instancia = new Principal();
    	
		return instancia;
	}
	
    /**
     * Create the application.
     * @wbp.parser.entryPoint
     */
    public Principal() {
        
    	initialize();
    	
    	
        // Inicialización
        Fabrica fabrica = Fabrica.getInstance();
        ICAD = fabrica.getIctrlADeportivas();
        ICID = fabrica.getIctrlIDeportivas();
        ICC = fabrica.getIctrlCuponeras();
        ICCL = fabrica.getIctrlClases();
        IUSR = fabrica.getIctrlUsuarios();
        ICAT = fabrica.getIctrlCategorias();       
        IctrlUsuarios ICU = fabrica.getIctrlUsuarios();
        
        // Se crean los tres InternalFrame y se incluyen al Frame principal ocultos.
        // De esta forma, no es necesario crear y destruir objetos lo que enlentece la ejecución.
        // Cada InternalFrame usa un layout diferente, simplemente para mostrar distintas opciones.
        altaInstDeportivaInternalFrame = new AltaInstitucionDeportiva(ICID);
        altaInstDeportivaInternalFrame.setVisible(false);
        
        altaActividadDeportivaInternalFrame = new AltaActividadDeportiva(ICAD, ICID, ICAT);
        altaActividadDeportivaInternalFrame.setVisible(false);
        
        CrearCuponeraInternalFrame = new CrearCuponera(ICC);
        CrearCuponeraInternalFrame.setVisible(false);
        
        altaDictadoDeClasesInternalFrame = new AltaDictadoDeClases();
        altaDictadoDeClasesInternalFrame.setLocation(106, 25);
        altaDictadoDeClasesInternalFrame.setVisible(false);
        
        consultaDictadoDeClasesFrame = new ConsultaDictadoDeClases();
        consultaDictadoDeClasesFrame.setVisible(false);
        AltaUsuarioInternalFrame = new AltaUsuario(ICU);
        AltaUsuarioInternalFrame.setVisible(false);
        
        AgregarActividadaCuponeraInternalFrame = new AgregarActividadaCuponera(ICC, ICID, ICAD);
        AgregarActividadaCuponeraInternalFrame.setVisible(false);
        
        RegistroDictadoDeClasesFrame = new RegistroDictadoDeClases();
        RegistroDictadoDeClasesFrame.setVisible(false);

        ConsultarCuponeraInternalFrame= new ConsultarCuponera(ICC,ICID,ICAD);
        ConsultarCuponeraInternalFrame.setVisible(false);
        
        ConsultaUsuarioInternalFrame = new ConsultaUsuario(ICU);
        ConsultaUsuarioInternalFrame.setVisible(false);
        
        consultaActividadDeportivaInternalFrame = new ConsultaActividadDeportiva(ICID, ICAD, ICC, ICCL, consultaDictadoDeClasesFrame, ConsultarCuponeraInternalFrame);
        consultaActividadDeportivaInternalFrame.setVisible(false);
        
        ModificarUsuarioInternalFrame = new ModificarUsuario(ICU);
        ModificarUsuarioInternalFrame.setVisible(false);
        
        AltaCategoriaFrame = new AltaCategoria();
        AltaCategoriaFrame.setVisible(false);
        
        AceptaRechazaADInternalFrame = new AceptaRechazaActividadDeportiva(ICID, ICAD, ICC, ICCL, consultaDictadoDeClasesFrame, ConsultarCuponeraInternalFrame);
        AceptaRechazaADInternalFrame.setVisible(false);
        
        desktopPane.setLayout(null);
        
        desktopPane.add(altaInstDeportivaInternalFrame);
        desktopPane.add(altaActividadDeportivaInternalFrame);
        desktopPane.add(consultaActividadDeportivaInternalFrame);
        desktopPane.add(CrearCuponeraInternalFrame);
        desktopPane.add(altaDictadoDeClasesInternalFrame);
        desktopPane.add(consultaDictadoDeClasesFrame);
        desktopPane.add(AltaUsuarioInternalFrame);
        desktopPane.add(AgregarActividadaCuponeraInternalFrame);
        desktopPane.add(ConsultarCuponeraInternalFrame);        
        desktopPane.add(RegistroDictadoDeClasesFrame);
        desktopPane.add(ConsultaUsuarioInternalFrame);
        desktopPane.add(ModificarUsuarioInternalFrame);
        desktopPane.add(AltaCategoriaFrame);
        desktopPane.add(AceptaRechazaADInternalFrame);
    		
    		
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        
        // Se crea el Frame con las dimensiones indicadas.
    	entrenamosUy = new JFrame();
    	entrenamosUy.setTitle("entrenamos.uy - backend administrador");
    	entrenamosUy.setBounds(100, 100, 900, 700);
        entrenamosUy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        desktopPane = new JDesktopPane();
        entrenamosUy.getContentPane().add(desktopPane);

        // Se crea una barra de menú (JMenuBar) con dos menú (JMenu) desplegables.
        // Cada menú contiene diferentes opciones (JMenuItem), los cuales tienen un 
        // evento asociado que permite realizar una acción una vez se seleccionan. 
        JMenuBar menuBar = new JMenuBar();
        entrenamosUy.setJMenuBar(menuBar);

        JMenu menuSistema = new JMenu("Sistema");
        menuBar.add(menuSistema);

        JMenuItem menuDatosPrueba = new JMenuItem("Cargar datos de prueba");
        menuDatosPrueba.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	ICID.cargarDatosIDeportivas();
            	ICAT.cargarCategorias();
            	IUSR.cargarUsuarios();
                ICAD.cargarDatosADeportivas();
                ICC.cargarDatosCuponeras();
                ICCL.cargarDatosClases();
                ICCL.cargarRegistroAClases();
                
                
            }
        });
        menuSistema.add(menuDatosPrueba);

        JMenuItem menuSalir = new JMenuItem("Salir");
        menuSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // Salgo de la aplicación
            	entrenamosUy.setVisible(false);
            	entrenamosUy.dispose();
            }
        });
        menuSistema.add(menuSalir);


        JMenu menuUsuarios = new JMenu("Usuarios");
        menuBar.add(menuUsuarios);

        JMenuItem menuItemRegistrar = new JMenuItem("Alta de Usuario");
        menuItemRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eve) {
                // Muestro el InternalFrame para registrar un usuario
            	AltaUsuarioInternalFrame.setVisible(true);
            }
        });
        menuUsuarios.add(menuItemRegistrar);

        JMenuItem menuItemVerInfo = new JMenuItem("Consulta de Usuario");
        menuItemVerInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eve) {
                // Muestro el InternalFrame para ver información de un usuario
            	ConsultaUsuarioInternalFrame.CargarDatos();
            	ConsultaUsuarioInternalFrame.setVisible(true);
            	
            	
            }
        });
        menuUsuarios.add(menuItemVerInfo);

        JMenuItem menuItemModificaUsuario = new JMenuItem("Modificar Datos de Usuario");
        menuItemModificaUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eve) {
            	ModificarUsuarioInternalFrame.CargarDatos();
            	ModificarUsuarioInternalFrame.setVisible(true);

            }
        });
        menuUsuarios.add(menuItemModificaUsuario);
        
        JMenu menuInstDeportivas = new JMenu("Instituciones Deportivas");
        menuBar.add(menuInstDeportivas);

        JMenuItem menuItemRegistrarID = new JMenuItem("Alta de Institución Deportiva");
        menuItemRegistrarID.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eve) {
                // Muestro el InternalFrame para registrar una Institucion Deportiva
            	altaInstDeportivaInternalFrame.setVisible(true);
            }
        });
        menuInstDeportivas.add(menuItemRegistrarID);

        
        JMenu menuActDeportivas = new JMenu("Actividades Deportivas");
        menuBar.add(menuActDeportivas);

        JMenuItem menuItemRegistrarAD = new JMenuItem("Alta de Actividad Deportiva");
        menuItemRegistrarAD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eve) {
                // Muestro el InternalFrame para registrar una Actividad Deportiva
            	altaActividadDeportivaInternalFrame.setVisible(true);
            	altaActividadDeportivaInternalFrame.cargarInstituciones();
            }
        });
        menuActDeportivas.add(menuItemRegistrarAD);

        JMenuItem menuItemVerInfoAD = new JMenuItem("Consulta de Actividad Deportiva");
        menuItemVerInfoAD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eve) {
                // Muestro el InternalFrame para ver información de una Actividad Deportiva
            	consultaActividadDeportivaInternalFrame.setVisible(true);
            	consultaActividadDeportivaInternalFrame.cargarInstituciones();
            }
        });
        menuActDeportivas.add(menuItemVerInfoAD);
        
        JMenuItem menuItemAceptarRechazarAD = new JMenuItem("Aceptar/Rechazar Actividad Deportiva");
        menuItemAceptarRechazarAD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eve) {
                // Muestro el InternalFrame para cambiar el estado de una Actividad Deportiva
            	try {
					AceptaRechazaADInternalFrame.cargarIngresadas();
				} catch (ActividadDeportivaNoExisteException ex1) {
					// TODO Auto-generated catch block
					ex1.printStackTrace();
				}
            	AceptaRechazaADInternalFrame.setVisible(true);
  
            }
        });
        menuActDeportivas.add(menuItemAceptarRechazarAD);
        
        JMenu menuClases = new JMenu("Clases");
        menuBar.add(menuClases);

        JMenuItem menuItemAltaClase = new JMenuItem("Alta de dictado de Clase");
        menuItemAltaClase.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eve) {
                // Muestro el InternalFrame para registrar una clase
            	altaDictadoDeClasesInternalFrame.cargarFormulario();
            	altaDictadoDeClasesInternalFrame.setVisible(true);


            }
        });
        menuClases.add(menuItemAltaClase);

        JMenuItem menuItemVerInfoClase = new JMenuItem("Consulta de dictado de Clase");
        menuItemVerInfoClase.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eve) {
                // Muestro el InternalFrame para ver información de una clase
            	consultaDictadoDeClasesFrame.cargarFormulario();
            	consultaDictadoDeClasesFrame.setVisible(true);
            	

            }
        });
        menuClases.add(menuItemVerInfoClase);

        JMenuItem menuItemRegistrarClase = new JMenuItem("Registro a dictado de Clase");
        menuItemRegistrarClase.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eve) {
            	RegistroDictadoDeClasesFrame.cargarFormulario();
            	RegistroDictadoDeClasesFrame.setVisible(true);

            }
        });
        menuClases.add(menuItemRegistrarClase);
        
        JMenu menuCuponeras = new JMenu("Cuponeras");
        menuBar.add(menuCuponeras);

        JMenuItem menuItemRegistrarCuponera = new JMenuItem("Crear Cuponera de Actividades Deportivas");
        menuItemRegistrarCuponera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eve) {
                // Muestro el InternalFrame para registrar un usuario
            	CrearCuponeraInternalFrame.setVisible(true);
            }
        });
        menuCuponeras.add(menuItemRegistrarCuponera);
       
        JMenuItem menuAgregaADCuponera = new JMenuItem("Agregar Actividad Deportiva a Cuponera");
        menuAgregaADCuponera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eve) {
                // Muestro el InternalFrame para ver la lista de todos los usuarios,
                // cargando previamente la lista
            	AgregarActividadaCuponeraInternalFrame.cargarCuponeras();
            	AgregarActividadaCuponeraInternalFrame.cargarInstituciones();
            	AgregarActividadaCuponeraInternalFrame.setVisible(true);
            }
        });
        menuCuponeras.add(menuAgregaADCuponera);
        
        JMenuItem menuItemVerInfoCuponera = new JMenuItem("Consulta de Cuponeras de Actividades Deportivas");
        menuItemVerInfoCuponera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eve) {
                // Muestro el InternalFrame para ver información de un usuario
            	ConsultarCuponeraInternalFrame.cargarCuponeras();
            	ConsultarCuponeraInternalFrame.setVisible(true);
            }
        });
        menuCuponeras.add(menuItemVerInfoCuponera);
    
    
	    JMenu menuCategorias = new JMenu("Categorias");
	    menuBar.add(menuCategorias);
	
	    JMenuItem menuItemRegistrarCat = new JMenuItem("Alta de Categoria");
	    menuItemRegistrarCat.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent eve) {
	            // Muestro el InternalFrame para registrar una categoria
	        	AltaCategoriaFrame.setVisible(true);
	        }
	    });
	    menuCategorias.add(menuItemRegistrarCat);
    }
	   
}
