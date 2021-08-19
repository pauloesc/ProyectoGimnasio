package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import logica.Fabrica;
import logica.IctrlDeportivas;

import javax.swing.JMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase principal (Frame) con el método Main.
 * @author mbarrera
 *
 */
public class Principal {

    private JFrame entrenamosUy;
    private AltaInstitucionDeportiva altaInstDeportivaInternalFrame;
    private AltaActividadDeportiva altaActividadDeportivaInternalFrame;
    private ConsultaActividadDeportiva consultaActividadDeportivaInternalFrame;
    private AltaDictadoDeClases altaDictadoDeClasesInternalFrame;
    
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
        IctrlDeportivas ICD = fabrica.getIctrlDeportivas();
        
        // Se crean los tres InternalFrame y se incluyen al Frame principal ocultos.
        // De esta forma, no es necesario crear y destruir objetos lo que enlentece la ejecución.
        // Cada InternalFrame usa un layout diferente, simplemente para mostrar distintas opciones.
        altaInstDeportivaInternalFrame = new AltaInstitucionDeportiva(ICD);
        altaInstDeportivaInternalFrame.setVisible(false);
        
        altaActividadDeportivaInternalFrame = new AltaActividadDeportiva();
        altaActividadDeportivaInternalFrame.setVisible(false);
        
        consultaActividadDeportivaInternalFrame = new ConsultaActividadDeportiva();
        consultaActividadDeportivaInternalFrame.setVisible(false);
        
        altaDictadoDeClasesInternalFrame = new AltaDictadoDeClases();
        altaDictadoDeClasesInternalFrame.setVisible(false);
        
        
        entrenamosUy.getContentPane().setLayout(null);
        
        entrenamosUy.getContentPane().add(altaInstDeportivaInternalFrame);
        entrenamosUy.getContentPane().add(altaActividadDeportivaInternalFrame);
        entrenamosUy.getContentPane().add(consultaActividadDeportivaInternalFrame);
        entrenamosUy.getContentPane().add(altaDictadoDeClasesInternalFrame);
        
        
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        
        // Se crea el Frame con las dimensiones indicadas.
    	entrenamosUy = new JFrame();
    	entrenamosUy.setTitle("entrenamos.uy - backend administrador");
    	entrenamosUy.setBounds(100, 100, 850, 600);
        entrenamosUy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Se crea una barra de menú (JMenuBar) con dos menú (JMenu) desplegables.
        // Cada menú contiene diferentes opciones (JMenuItem), los cuales tienen un 
        // evento asociado que permite realizar una acción una vez se seleccionan. 
        JMenuBar menuBar = new JMenuBar();
        entrenamosUy.setJMenuBar(menuBar);

        JMenu menuSistema = new JMenu("Sistema");
        menuBar.add(menuSistema);

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

            }
        });
        menuUsuarios.add(menuItemRegistrar);

        JMenuItem menuItemVerInfo = new JMenuItem("Consulta de Usuario");
        menuItemVerInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muestro el InternalFrame para ver información de un usuario

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
                // Muestro el InternalFrame para registrar un usuario
            	altaInstDeportivaInternalFrame.setVisible(true);
            }
        });
        menuInstDeportivas.add(menuItemRegistrarID);

        
        JMenu menuActDeportivas = new JMenu("Actividades Deportivas");
        menuBar.add(menuActDeportivas);

        JMenuItem menuItemRegistrarAD = new JMenuItem("Alta de Actividad Deportiva");
        menuItemRegistrarAD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muestro el InternalFrame para registrar un usuario
            	altaActividadDeportivaInternalFrame.setVisible(true);
            }
        });
        menuActDeportivas.add(menuItemRegistrarAD);

        JMenuItem menuItemVerInfoAD = new JMenuItem("Consulta de Actividad Deportiva");
        menuItemVerInfoAD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muestro el InternalFrame para ver información de un usuario
            	consultaActividadDeportivaInternalFrame.setVisible(true);
            }
        });
        menuActDeportivas.add(menuItemVerInfoAD);
        
        JMenu menuClases = new JMenu("Clases");
        menuBar.add(menuClases);

        JMenuItem menuItemAltaClase = new JMenuItem("Alta de dictado de Clase");
        menuItemAltaClase.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muestro el InternalFrame para registrar una clase
            	altaDictadoDeClasesInternalFrame.setVisible(true);

            }
        });
        menuClases.add(menuItemAltaClase);

        JMenuItem menuItemVerInfoClase = new JMenuItem("Consulta de dictado de Clase");
        menuItemVerInfoClase.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muestro el InternalFrame para ver información de una clase

            }
        });
        menuClases.add(menuItemVerInfoClase);

        JMenuItem menuItemRegistrarClase = new JMenuItem("Registro a dictado de Clase");
        menuItemRegistrarClase.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muestro el InternalFrame para ver la lista de todos los usuarios,
                // cargando previamente la lista

            }
        });
        menuClases.add(menuItemRegistrarClase);
        
        JMenu menuCuponeras = new JMenu("Cuponeras");
        menuBar.add(menuCuponeras);

        JMenuItem menuItemRegistrarCuponera = new JMenuItem("Crear Cuponera de Actividades Deportivas");
        menuItemRegistrarCuponera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muestro el InternalFrame para registrar un usuario

            }
        });
        menuCuponeras.add(menuItemRegistrarCuponera);
       
        JMenuItem menuAgregaADCuponera = new JMenuItem("Agregar Actividad Deportiva a Cuponera");
        menuAgregaADCuponera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muestro el InternalFrame para ver la lista de todos los usuarios,
                // cargando previamente la lista

            }
        });
        menuCuponeras.add(menuAgregaADCuponera);
        
        JMenuItem menuItemVerInfoCuponera = new JMenuItem("Consulta de Cuponeras de Actividades Deportivas");
        menuItemVerInfoCuponera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muestro el InternalFrame para ver información de un usuario

            }
        });
        menuCuponeras.add(menuItemVerInfoCuponera);
    }
}
