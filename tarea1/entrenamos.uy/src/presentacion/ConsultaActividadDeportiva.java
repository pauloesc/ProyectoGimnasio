package presentacion;

/**
 * JInternalFrame del caso de uso Consulta Actividad Deportiva.
 * @author mbarrera
 */

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Button;
import java.awt.TextArea;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import datatypes.DataInstitucion;
import datatypes.DataActividad;
import excepciones.ActividadDeportivaNoExisteException;
import excepciones.InstitucionDeportivaNoExisteException;
import logica.IctrlDeportivas;

import javax.swing.JSpinner;
import javax.swing.JComponent;
import java.awt.Choice;
import java.awt.Color;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import logica.IctrlDeportivas;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ItemEvent;

@SuppressWarnings({ "serial", "unused" })
public class ConsultaActividadDeportiva extends JInternalFrame {
	
	// Controlador de Deportivas que se utilizará para las acciones del JFrame
    private IctrlDeportivas controlDeportivas;
	
	private JComboBox<DataInstitucion> comboBoxInstDeportivas;
	private JComboBox<DataActividad> comboBoxActDeportivas;
	private JTextField txtNombre;
    private JTextArea txtDescripcion;
    private JTextField txtDuracion;
    private JTextField txtCosto;
    private JTextField txtFechaAlta;
    
	public ConsultaActividadDeportiva(IctrlDeportivas icd) {
		
		controlDeportivas = icd;
		
		setTitle("Consulta de Actividad Deportiva");
		setClosable(true);
		getContentPane().setLayout(null);
		setBounds(10, 5, 459, 542);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JLabel lblInstDeportiva = new JLabel("Institución Deportiva:");
		lblInstDeportiva.setVerticalAlignment(SwingConstants.TOP);
		lblInstDeportiva.setHorizontalAlignment(SwingConstants.LEFT);
		lblInstDeportiva.setBounds(34, 17, 158, 19);
		getContentPane().add(lblInstDeportiva);
		
		comboBoxInstDeportivas = new JComboBox<DataInstitucion>();
		lblInstDeportiva.setLabelFor(comboBoxInstDeportivas);
		comboBoxInstDeportivas.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cargarActividades(comboBoxInstDeportivas.getSelectedItem().toString());
			}
		});
		comboBoxInstDeportivas.setBounds(195, 12, 218, 24);
		getContentPane().add(comboBoxInstDeportivas);
		lblInstDeportiva.setLabelFor(comboBoxInstDeportivas);
		
		JLabel lblActDeportiva = new JLabel("Actividad Deportiva:");
		lblActDeportiva.setVerticalAlignment(SwingConstants.TOP);
		lblActDeportiva.setHorizontalAlignment(SwingConstants.LEFT);
		lblActDeportiva.setBounds(34, 49, 158, 19);
		getContentPane().add(lblActDeportiva);
		
		comboBoxActDeportivas = new JComboBox<DataActividad>();
		lblActDeportiva.setLabelFor(comboBoxActDeportivas);
		comboBoxActDeportivas.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cargarDatosActividad(comboBoxActDeportivas.getSelectedItem().toString());
			}
		});
		comboBoxActDeportivas.setBounds(195, 44, 218, 24);
		getContentPane().add(comboBoxActDeportivas);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(34, 80, 70, 19);
		getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(133, 80, 280, 19);
		txtNombre.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(txtNombre);
		
		JLabel lblDescripcin = new JLabel("Descripción:");
		lblDescripcin.setBounds(34, 110, 95, 19);
		getContentPane().add(lblDescripcin);
		
		txtDescripcion = new JTextArea();
		txtDescripcion.setEditable(false);
		txtDescripcion.setBounds(133, 110, 280, 89);
		txtDescripcion.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(txtDescripcion);
		
		JLabel lblDuracion = new JLabel("Duración:");
		lblDuracion.setBounds(34, 205, 70, 19);
		getContentPane().add(lblDuracion);
				
		txtDuracion = new JTextField();
		txtDuracion.setEditable(false);
		txtDuracion.setBounds(133, 205, 93, 19);
		txtDuracion.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(txtDuracion);
		
		JLabel lblCosto = new JLabel("Costo:");
		lblCosto.setBounds(34, 232, 70, 19);
		getContentPane().add(lblCosto);
		
		txtCosto = new JTextField();
		txtCosto.setEditable(false);
		txtCosto.setBounds(133, 232, 93, 19);
		txtCosto.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(txtCosto);
		
		JLabel lblFechaDeAlta = new JLabel("Fecha Alta:");
		lblFechaDeAlta.setBounds(34, 263, 95, 19);
		getContentPane().add(lblFechaDeAlta);
		
		txtFechaAlta = new JTextField();
		txtFechaAlta.setEditable(false);
		txtFechaAlta.setBounds(133, 263, 93, 19);
		txtFechaAlta.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(txtFechaAlta);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(34, 294, 384, 205);
		getContentPane().add(tabbedPane);
		
		JList listClases = new JList();
		tabbedPane.addTab("Clases", null, listClases, null);
		
		JList listCuponeras = new JList();
		tabbedPane.addTab("Cuponeras", null, listCuponeras, null);
		
	}
	
	// Método que permite cargar un nuevo modelo para el combo con las Instituciones Deportivas
    // provistas por la operación del sistema getInstituciones(). 
    // Se invoca el método antes de hacer visible el JInternalFrame
    public void cargarInstituciones() {
        DefaultComboBoxModel<DataInstitucion> modelo;
        try {
            modelo = new DefaultComboBoxModel<DataInstitucion>(controlDeportivas.getInstituciones());
            modelo.setSelectedItem(null);
            comboBoxInstDeportivas.setModel(modelo);
        } catch (InstitucionDeportivaNoExisteException e) {
        	JOptionPane.showMessageDialog(this, e.getMessage(), "Consulta Actividad Deportiva", JOptionPane.ERROR_MESSAGE);
        	setVisible(false);
        }

    }
    
    // Método que permite cargar un nuevo modelo para el combo con las Actividades Deportivas
    // provistas por la operación del sistema getActividades(). 
    // Se invoca el método luego de haber seleccionado la Institución Deportiva
    public void cargarActividades(String nid) {
        DefaultComboBoxModel<DataActividad> modelo;
        try {
            modelo = new DefaultComboBoxModel<DataActividad>(controlDeportivas.getActividades(nid));
            modelo.setSelectedItem(null);
            comboBoxActDeportivas.setModel(modelo);
        } catch (ActividadDeportivaNoExisteException e) {
        	JOptionPane.showMessageDialog(this, e.getMessage(), "Consulta Actividad Deportiva", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    // Método que permite cargar los datos de la Actividad Deportiva seleccionada
    // provistos por la operación del sistema getDataActividad().
    // Se invoca el método luego de haber seleccionado la Institución Deportiva y la Actividad Deportiva
    public void cargarDatosActividad(String n) {
    	
        Date date = null;  
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");  
    
        try {
            DataActividad act = controlDeportivas.getDataActividad(n);
            txtNombre.setText(act.getNombre());
            txtDescripcion.setText(act.getDescripcion());
            txtDuracion.setText(act.getDuracion().toString());
            txtCosto.setText(act.getCosto().toString());
            
            date = act.getFechaAlta();
            String strDate = dateFormat.format(date);
            
            txtFechaAlta.setText(strDate);            
        } catch (ActividadDeportivaNoExisteException e) {
        	JOptionPane.showMessageDialog(this, "No existen datos en el sistema para la Actividad Deportiva seleccionada.", "Consulta Actividad Deportiva",
    	    		JOptionPane.ERROR_MESSAGE);
        	setVisible(false);
        }

    }
}
