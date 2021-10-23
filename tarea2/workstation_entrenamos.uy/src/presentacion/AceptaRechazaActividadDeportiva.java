package presentacion;

/**
 * JInternalFrame del caso de uso Aceptar/Rechazar Actividad Deportiva.
 * @author mbarrera
 */

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import excepciones.ActividadDeportivaNoExisteException;
import logica.DataActividad;
import logica.EstadoActi;
import logica.IctrlADeportivas;
import logica.IctrlClases;
import logica.IctrlIDeportivas;
import logica.IctrlCuponeras;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings({ "unused" })
public class AceptaRechazaActividadDeportiva extends JInternalFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Controlador de Deportivas que se utilizará para las acciones del JFrame
    private IctrlIDeportivas controlIDeportivas;
    private IctrlADeportivas controlADeportivas;
    private IctrlCuponeras controlCuponeras;
    private IctrlClases controlClases;
    private Boolean nolimpio;
    private JList<String> listIngresadas;
    private JTextField txtNombre;
    private JTextField txtDuracion;
    private JTextField txtCosto;
    private JTextField txtFechaAlta;
    private JTextField txtInstitucion;
    private JTextArea txtDescripcion;
    private JComboBox<String> comboBoxEstado;
    private DefaultListModel<String> modeloIngresadas;
    private JButton btnGuardar;
    
    
    
	public AceptaRechazaActividadDeportiva(IctrlIDeportivas icid, IctrlADeportivas icad, IctrlCuponeras icup, IctrlClases icla, ConsultaDictadoDeClases consultaClase, ConsultarCuponera consultaCuponera) {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent eve) {
				limpiarFormulario();
				setVisible(false);
			}
		});
		nolimpio = true;
		
		controlIDeportivas = icid;
		controlADeportivas = icad;
		controlCuponeras = icup;
		controlClases = icla;

		
		setTitle("Aceptar/Rechazar Actividad Deportiva");
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(null);
		setBounds(10, 5, 459, 591);
		
		

		
		JLabel lblActIngre = new JLabel("Actividades Deportivas para revisar:");
		lblActIngre.setVerticalAlignment(SwingConstants.TOP);
		lblActIngre.setHorizontalAlignment(SwingConstants.LEFT);
		lblActIngre.setBounds(34, 17, 257, 19);
		getContentPane().add(lblActIngre);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarFormulario();
				setVisible(false);
			}
		});
		btnSalir.setBounds(297, 521, 117, 25);
		getContentPane().add(btnSalir);
		
		listIngresadas = new JList<String>();
		listIngresadas.setBounds(34, 48, 380, 188);
		listIngresadas.setBorder(BorderFactory.createLineBorder(Color.black));
		listIngresadas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (nolimpio) 
					cargarDatosActividad(listIngresadas.getSelectedValue());
				
			}
		});
		getContentPane().add(listIngresadas);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(34, 248, 70, 19);
		getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBorder(BorderFactory.createLineBorder(Color.black));
		txtNombre.setBounds(133, 248, 280, 19);
		getContentPane().add(txtNombre);
		
		JLabel lblDescripcin = new JLabel("Descripción:");
		lblDescripcin.setBounds(34, 306, 95, 19);
		getContentPane().add(lblDescripcin);
		
		txtDescripcion = new JTextArea();
		txtDescripcion.setEditable(false);
		txtDescripcion.setWrapStyleWord(true);
		txtDescripcion.setLineWrap(true);
		txtDescripcion.setBorder(BorderFactory.createLineBorder(Color.black));
		txtDescripcion.setBounds(133, 306, 280, 89);
		getContentPane().add(txtDescripcion);
		
		JLabel lblDuracion = new JLabel("Duración:");
		lblDuracion.setBounds(34, 401, 70, 19);
		getContentPane().add(lblDuracion);
		
		txtDuracion = new JTextField();
		txtDuracion.setEditable(false);
		txtDuracion.setBorder(BorderFactory.createLineBorder(Color.black));
		txtDuracion.setBounds(133, 401, 93, 19);
		getContentPane().add(txtDuracion);
		
		JLabel lblCosto = new JLabel("Costo:");
		lblCosto.setBounds(34, 428, 70, 19);
		getContentPane().add(lblCosto);
		
		txtCosto = new JTextField();
		txtCosto.setEditable(false);
		txtCosto.setBorder(BorderFactory.createLineBorder(Color.black));
		txtCosto.setBounds(133, 428, 93, 19);
		getContentPane().add(txtCosto);
		
		JLabel lblFechaDeAlta = new JLabel("Fecha Alta:");
		lblFechaDeAlta.setBounds(34, 459, 95, 19);
		getContentPane().add(lblFechaDeAlta);
		
		txtFechaAlta = new JTextField();
		txtFechaAlta.setEditable(false);
		txtFechaAlta.setBorder(BorderFactory.createLineBorder(Color.black));
		txtFechaAlta.setBounds(133, 459, 93, 19);
		getContentPane().add(txtFechaAlta);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(34, 490, 95, 19);
		getContentPane().add(lblEstado);
		
	//	JLabel lblInstitucion = new JLabel("Institución:");
	//	lblInstitucion.setBounds(34, 275, 95, 19);
	//	getContentPane().add(lblInstitucion);
		
	//	txtInstitucion = new JTextField();
		//txtInstitucion.setEditable(false);
		//txtInstitucion.setBorder(BorderFactory.createLineBorder(Color.black));
		//txtInstitucion.setBounds(133, 275, 280, 19);
	//	getContentPane().add(txtInstitucion);
		
		comboBoxEstado = new JComboBox<String>();
		comboBoxEstado.setBounds(133, 490, 141, 19);
		comboBoxEstado.addItem("Ingresada");
		comboBoxEstado.addItem("Aceptada");
		comboBoxEstado.addItem("Rechazada");
		comboBoxEstado.setSelectedItem(null);
		comboBoxEstado.setEnabled(false);
		getContentPane().add(comboBoxEstado);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eve) {
				if (comboBoxEstado.getSelectedIndex() == 1)
					controlADeportivas.cambiarEstado(listIngresadas.getSelectedValue(), EstadoActi.ACEPTADA);
				if (comboBoxEstado.getSelectedIndex() == 2)
					controlADeportivas.cambiarEstado(listIngresadas.getSelectedValue(), EstadoActi.RECHAZADA);
				limpiarFormulario();
				try {
					cargarIngresadas();
				} catch (ActividadDeportivaNoExisteException ex1) {
					ex1.printStackTrace();
				}
			}
		});
		btnGuardar.setBounds(164, 521, 117, 25);
		getContentPane().add(btnGuardar);
		
	}
	
    // Método que permite cargar los datos de la Actividad Deportiva seleccionada
    // provistos por la operación del sistema getDataActividad().
    // Se invoca el método luego de haber seleccionado la Institución Deportiva y la Actividad Deportiva
    public void cargarDatosActividad(String nact) {
    	
        Date date = null;  
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");  
    
        try {
            DataActividad act = controlADeportivas.getDataActividad(nact);
            txtNombre.setText(act.getNombre());
            //txtInstitucion.setText(act.get)
            txtDescripcion.setText(act.getDescripcion());
            txtDuracion.setText(act.getDuracion().toString());
            txtCosto.setText(act.getCosto().toString());
            if ( act.getEstado() == EstadoActi.ACEPTADA )
            		comboBoxEstado.setSelectedIndex(1);
            if ( act.getEstado() == EstadoActi.RECHAZADA )
        		comboBoxEstado.setSelectedIndex(2);
            if ( act.getEstado() == EstadoActi.INGRESADA )
        		comboBoxEstado.setSelectedIndex(0);
            comboBoxEstado.setEnabled(true);
            
            
            date = act.getFechaAlta();
            String strDate = dateFormat.format(date);
            
            txtFechaAlta.setText(strDate);            
        } catch (ActividadDeportivaNoExisteException e) {
        	JOptionPane.showMessageDialog(this, e.getMessage(), "Consulta Actividad Deportiva",	JOptionPane.ERROR_MESSAGE);
        	setVisible(false);
        }    
        
    }
    
    public void cargarIngresadas() throws ActividadDeportivaNoExisteException {
    	Set<String> ing;
    	modeloIngresadas = new DefaultListModel<String>();
    	ing = controlADeportivas.getActividadesIngresadas();
    	Iterator<String> iter = ing.iterator();
		while (iter.hasNext()) {            	
			modeloIngresadas.addElement(iter.next());
        }
		listIngresadas.setModel(modeloIngresadas);
    }
    
    // Permite borrar el contenido de un formulario antes de cerrarlo.
    // Recordar que las ventanas no se destruyen, sino que simplemente 
    // se ocultan, por lo que conviene borrar la información para que 
    // no aparezca al mostrarlas nuevamente.
    private void limpiarFormulario() {
    	nolimpio = false;
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtDuracion.setText("");
        txtCosto.setText("");
        txtFechaAlta.setText("");
        comboBoxEstado.setSelectedItem(null);
        comboBoxEstado.setEnabled(false);
        listIngresadas.removeAll();
        nolimpio = true;
    }
    	

}
