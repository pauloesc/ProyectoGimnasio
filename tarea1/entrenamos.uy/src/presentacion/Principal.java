package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import logica.Fabrica;
import logica.IctrlADeportivas;
import logica.IctrlClases;
import logica.IctrlCuponeras;
import logica.IctrlIDeportivas;
import logica.IctrlUsuarios;

import javax.swing.JMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Principal {

    private JFrame entrenamosUy;
    private AltaInstitucionDeportiva altaInstDeportivaInternalFrame;
    private AltaActividadDeportiva altaActividadDeportivaInternalFrame;
    private ConsultaActividadDeportiva consultaActividadDeportivaInternalFrame;
    private AltaDictadoDeClases altaDictadoDeClasesInternalFrame;
    private CrearCuponera CrearCuponeraInternalFrame;
    private ConsultaDictadoDeClases consultaDictadoDeClasesFrame;
    private AltaUsuario AltaUsuarioInternalFrame;
    private AgregarActividadaCuponera AgregarActividadaCuponeraInternalFrame;
    private ConsultarCuponera ConsultarCuponeraInternalFrame;
    private RegistroDictadoDeClases RegistroDictadoDeClasesFrame;    
    private IctrlIDeportivas ICID;
    private IctrlADeportivas ICAD;
    private IctrlCuponeras ICC;
    private IctrlClases ICCL;
    private ConsultaUsuario ConsultaUsuarioInternalFrame;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Principal window = new Principal();
                    window.entrenamosUy.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Principal() {
        
    	initialize();
    	
        // Inicialización
        Fabrica fabrica = Fabrica.getInstance();
        ICAD = fabrica.getIctrlADeportivas();
        ICID = fabrica.getIctrlIDeportivas();
        ICC =fabrica.getIctrlCuponeras();
        ICCL = fabrica.getIctrlClases();
        
        IctrlUsuarios ICU = fabrica.getIctrlUsuarios();
        
        // Se crean los tres InternalFrame y se incluyen al Frame principal ocultos.
        // De esta forma, no es necesario crear y destruir objetos lo que enlentece la ejecución.
        // Cada InternalFrame usa un layout diferente, simplemente para mostrar distintas opciones.
        altaInstDeportivaInternalFrame = new AltaInstitucionDeportiva(ICID);
        altaInstDeportivaInternalFrame.setVisible(false);
        
        altaActividadDeportivaInternalFrame = new AltaActividadDeportiva(ICAD, ICID);
        altaActividadDeportivaInternalFrame.setVisible(false);
        
        consultaActividadDeportivaInternalFrame = new ConsultaActividadDeportiva(ICID, ICAD, ICC);
        consultaActividadDeportivaInternalFrame.setVisible(false);
        
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
        
        
        entrenamosUy.getContentPane().setLayout(null);
        
        entrenamosUy.getContentPane().add(altaInstDeportivaInternalFrame);
        entrenamosUy.getContentPane().add(altaActividadDeportivaInternalFrame);
        entrenamosUy.getContentPane().add(consultaActividadDeportivaInternalFrame);
        entrenamosUy.getContentPane().add(CrearCuponeraInternalFrame);
        entrenamosUy.getContentPane().add(altaDictadoDeClasesInternalFrame);
        entrenamosUy.getContentPane().add(consultaDictadoDeClasesFrame);
        entrenamosUy.getContentPane().add(AltaUsuarioInternalFrame);
        entrenamosUy.getContentPane().add(AgregarActividadaCuponeraInternalFrame);
        entrenamosUy.getContentPane().add(ConsultarCuponeraInternalFrame);        
        entrenamosUy.getContentPane().add(RegistroDictadoDeClasesFrame);
        entrenamosUy.getContentPane().add(ConsultaUsuarioInternalFrame);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        
        // Se crea el Frame con las dimensiones indicadas.
    	entrenamosUy = new JFrame();
    	entrenamosUy.setTitle("entrenamos.uy - backend administrador");
    	entrenamosUy.setBounds(100, 100, 852, 641);
        entrenamosUy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
                ICAD.cargarDatosADeportivas();
                ICC.cargarDatosCuponeras();
                // cargar profesores y socios antes de las clases
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
            public void actionPerformed(ActionEvent e) {
                // Muestro el InternalFrame para registrar un usuario
            	AltaUsuarioInternalFrame.setVisible(true);
            }
        });
        menuUsuarios.add(menuItemRegistrar);

        JMenuItem menuItemVerInfo = new JMenuItem("Consulta de Usuario");
        menuItemVerInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muestro el InternalFrame para ver información de un usuario
            	ConsultaUsuarioInternalFrame.CargarDatos();
            	ConsultaUsuarioInternalFrame.setVisible(true);
            	
            	
            }
        });
        menuUsuarios.add(menuItemVerInfo);

        JMenuItem menuItemModificaUsuario = new JMenuItem("Modificar Datos de Usuario");
        menuItemModificaUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muestro el InternalFrame para ver la lista de todos los usuarios,
                // cargando previamente la lista

            }
        });
        menuUsuarios.add(menuItemModificaUsuario);
        
        JMenu menuInstDeportivas = new JMenu("Instituciones Deportivas");
        menuBar.add(menuInstDeportivas);

        JMenuItem menuItemRegistrarID = new JMenuItem("Alta de Institución Deportiva");
        menuItemRegistrarID.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muestro el InternalFrame para registrar una Institucion Deportiva
            	altaInstDeportivaInternalFrame.setVisible(true);
            }
        });
        menuInstDeportivas.add(menuItemRegistrarID);

        
        JMenu menuActDeportivas = new JMenu("Actividades Deportivas");
        menuBar.add(menuActDeportivas);

        JMenuItem menuItemRegistrarAD = new JMenuItem("Alta de Actividad Deportiva");
        menuItemRegistrarAD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muestro el InternalFrame para registrar una Actividad Deportiva
            	altaActividadDeportivaInternalFrame.setVisible(true);
            	altaActividadDeportivaInternalFrame.cargarInstituciones();
            }
        });
        menuActDeportivas.add(menuItemRegistrarAD);

        JMenuItem menuItemVerInfoAD = new JMenuItem("Consulta de Actividad Deportiva");
        menuItemVerInfoAD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muestro el InternalFrame para ver información de una Actividad Deportiva
            	consultaActividadDeportivaInternalFrame.setVisible(true);
            	consultaActividadDeportivaInternalFrame.cargarInstituciones();
            }
        });
        menuActDeportivas.add(menuItemVerInfoAD);
        
        JMenu menuClases = new JMenu("Clases");
        menuBar.add(menuClases);

        JMenuItem menuItemAltaClase = new JMenuItem("Alta de dictado de Clase");
        menuItemAltaClase.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muestro el InternalFrame para registrar una clase
            	altaDictadoDeClasesInternalFrame.cargarFormulario();
            	altaDictadoDeClasesInternalFrame.setVisible(true);


            }
        });
        menuClases.add(menuItemAltaClase);

        JMenuItem menuItemVerInfoClase = new JMenuItem("Consulta de dictado de Clase");
        menuItemVerInfoClase.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muestro el InternalFrame para ver información de una clase
            	consultaDictadoDeClasesFrame.cargarFormulario();
            	consultaDictadoDeClasesFrame.setVisible(true);
            	

            }
        });
        menuClases.add(menuItemVerInfoClase);

        JMenuItem menuItemRegistrarClase = new JMenuItem("Registro a dictado de Clase");
        menuItemRegistrarClase.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	RegistroDictadoDeClasesFrame.cargarFormulario();
            	RegistroDictadoDeClasesFrame.setVisible(true);

            }
        });
        menuClases.add(menuItemRegistrarClase);
        
        JMenu menuCuponeras = new JMenu("Cuponeras");
        menuBar.add(menuCuponeras);

        JMenuItem menuItemRegistrarCuponera = new JMenuItem("Crear Cuponera de Actividades Deportivas");
        menuItemRegistrarCuponera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muestro el InternalFrame para registrar un usuario
            	CrearCuponeraInternalFrame.setVisible(true);
            }
        });
        menuCuponeras.add(menuItemRegistrarCuponera);
       
        JMenuItem menuAgregaADCuponera = new JMenuItem("Agregar Actividad Deportiva a Cuponera");
        menuAgregaADCuponera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
            public void actionPerformed(ActionEvent e) {
                // Muestro el InternalFrame para ver información de un usuario
            	ConsultarCuponeraInternalFrame.cargarCuponeras();
            	ConsultarCuponeraInternalFrame.setVisible(true);
            }
        });
        menuCuponeras.add(menuItemVerInfoCuponera);
    }
}
