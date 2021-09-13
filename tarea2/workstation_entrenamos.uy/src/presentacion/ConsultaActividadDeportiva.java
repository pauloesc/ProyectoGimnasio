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
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import excepciones.ActividadDeportivaNoExisteException;
import excepciones.ClaseLlenaException;
import excepciones.ClaseNoExisteException;
import excepciones.CuponeraNoExisteException;
import excepciones.InstitucionDeportivaNoExisteException;
import logica.Cuponera;
import logica.DataActividad;
import logica.DataCuponera;
import logica.DataInstitucion;
import logica.DtClase;
import logica.IctrlADeportivas;
import logica.IctrlClases;
import logica.IctrlIDeportivas;
import logica.IctrlCuponeras;

import javax.swing.JSpinner;
import javax.swing.JComponent;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.awt.event.ItemEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings({ "serial", "unused" })
public class ConsultaActividadDeportiva extends JInternalFrame {
	
	// Controlador de Deportivas que se utilizará para las acciones del JFrame
    private IctrlIDeportivas controlIDeportivas;
    private IctrlADeportivas controlADeportivas;
    private IctrlCuponeras controlCuponeras;
    private IctrlClases controlClases;
    private ConsultarCuponera frameCuponeras;
    private ConsultaDictadoDeClases frameClases;
	private JComboBox<DataInstitucion> comboBoxInstDeportivas;
	private JComboBox<DataActividad> comboBoxActDeportivas;
	private JList<String> listCuponeras;
	private JList<String> listClases;
	private JTextField txtNombre;
    private JTextArea txtDescripcion;
    private JTextField txtDuracion;
    private JTextField txtCosto;
    private JTextField txtFechaAlta;
    private DefaultListModel<String> modeloCuponeras;
    private DefaultListModel<String> modeloClases;
    private Boolean nolimpio;
    
    
    
	public ConsultaActividadDeportiva(IctrlIDeportivas icid, IctrlADeportivas icad, IctrlCuponeras icup, IctrlClases icla, ConsultaDictadoDeClases consultaClase, ConsultarCuponera consultaCuponera) {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				limpiarFormulario();
				setVisible(false);
			}
		});
		nolimpio = true;
		
		controlIDeportivas = icid;
		controlADeportivas = icad;
		controlCuponeras = icup;
		controlClases = icla;
		frameCuponeras = consultaCuponera;
		frameClases = consultaClase;
		
		setTitle("Consulta de Actividad Deportiva");
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);;
		getContentPane().setLayout(null);
		setBounds(10, 5, 459, 589);
		
		

		
		JLabel lblInstDeportiva = new JLabel("Institución Deportiva:");
		lblInstDeportiva.setVerticalAlignment(SwingConstants.TOP);
		lblInstDeportiva.setHorizontalAlignment(SwingConstants.LEFT);
		lblInstDeportiva.setBounds(34, 17, 158, 19);
		getContentPane().add(lblInstDeportiva);
		
		comboBoxInstDeportivas = new JComboBox<DataInstitucion>();
		comboBoxInstDeportivas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nolimpio) {
					cargarActividades(comboBoxInstDeportivas.getSelectedItem().toString());
					comboBoxActDeportivas.setEnabled(true);
				}
			}
		});
		lblInstDeportiva.setLabelFor(comboBoxInstDeportivas);
		comboBoxInstDeportivas.setBounds(195, 12, 218, 24);
		getContentPane().add(comboBoxInstDeportivas);
		lblInstDeportiva.setLabelFor(comboBoxInstDeportivas);
		
		JLabel lblActDeportiva = new JLabel("Actividad Deportiva:");
		lblActDeportiva.setVerticalAlignment(SwingConstants.TOP);
		lblActDeportiva.setHorizontalAlignment(SwingConstants.LEFT);
		lblActDeportiva.setBounds(34, 49, 158, 19);
		getContentPane().add(lblActDeportiva);
		
		comboBoxActDeportivas = new JComboBox<DataActividad>();
		comboBoxActDeportivas.setEnabled(false);
		comboBoxActDeportivas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nolimpio)
					cargarDatosActividad(comboBoxActDeportivas.getSelectedItem().toString());
			}
		});
		lblActDeportiva.setLabelFor(comboBoxActDeportivas);
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
		
		listClases = new JList<String>();
		listClases.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (nolimpio) {
					frameClases.cargarDatosClase(listClases.getSelectedValue());
					frameClases.cargarCombo(listClases.getSelectedValue(), ((DataActividad)comboBoxActDeportivas.getSelectedItem()).getNombre()
							, ((DataInstitucion)comboBoxInstDeportivas.getSelectedItem()).getNombre());
					frameClases.setVisible(true);
					frameClases.toFront();
					toBack();
				}
			}
		});
		tabbedPane.addTab("Clases", null, listClases, null);
		
		listCuponeras = new JList<String>();
		listCuponeras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (nolimpio) {
					frameCuponeras.cargarboxcupo(listCuponeras.getSelectedValue());
					frameCuponeras.cargardatoscuponeras(listCuponeras.getSelectedValue());
					frameCuponeras.setVisible(true);
					frameCuponeras.toFront();
					toBack();
				}
			}
		});
		tabbedPane.addTab("Cuponeras", null, listCuponeras, null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarFormulario();
				setVisible(false);
			}
		});
		btnSalir.setBounds(296, 520, 117, 25);
		getContentPane().add(btnSalir);
		
	}
	
	// Método que permite cargar un nuevo modelo para el combo con las Instituciones Deportivas
    // provistas por la operación del sistema getInstituciones(). 
    // Se invoca el método antes de hacer visible el JInternalFrame
    public void cargarInstituciones() {
        DefaultComboBoxModel<DataInstitucion> modelo;
        try {
            modelo = new DefaultComboBoxModel<DataInstitucion>(controlIDeportivas.getInstituciones());
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
            modelo = new DefaultComboBoxModel<DataActividad>(controlADeportivas.getActividades(nid));
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
            DataActividad act = controlADeportivas.getDataActividad(n);
            txtNombre.setText(act.getNombre());
            txtDescripcion.setText(act.getDescripcion());
            txtDuracion.setText(act.getDuracion().toString());
            txtCosto.setText(act.getCosto().toString());
            
            date = act.getFechaAlta();
            String strDate = dateFormat.format(date);
            
            txtFechaAlta.setText(strDate);            
        } catch (ActividadDeportivaNoExisteException e) {
        	JOptionPane.showMessageDialog(this, e.getMessage(), "Consulta Actividad Deportiva",	JOptionPane.ERROR_MESSAGE);
        	setVisible(false);
        }
        
        Set<String> dcu;
        modeloCuponeras = new DefaultListModel<String>();
		try {
			dcu = controlCuponeras.getCuponerasActividad(n);
			Iterator<String> it = dcu.iterator();
			while(it.hasNext()){            	
	               modeloCuponeras.addElement(it.next());
	            }
		} catch (CuponeraNoExisteException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Consulta Actividad Deportiva",	JOptionPane.ERROR_MESSAGE);
		}
        
        listCuponeras.setModel(modeloCuponeras);
        
        Set<String> dcla;
        modeloClases = new DefaultListModel<String>();
        try {
			dcla = controlClases.mostrarClasesDeActividadDeportiva(n);
	        Iterator<String> it = dcla.iterator();
	        while(it.hasNext()){            	
	        	modeloClases.addElement(it.next());
			}
		} catch (ClaseNoExisteException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Consulta Actividad Deportiva",	JOptionPane.ERROR_MESSAGE);
		}

        
        listClases.setModel(modeloClases);
        
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
        listClases.removeAll();
        listCuponeras.removeAll();
        if (modeloClases != null) {
            modeloClases.clear();
            modeloCuponeras.clear();
        }
        comboBoxActDeportivas.removeActionListener(comboBoxActDeportivas);
        comboBoxInstDeportivas.removeActionListener(comboBoxActDeportivas);
        comboBoxActDeportivas.setSelectedItem(null);
        comboBoxInstDeportivas.setSelectedItem(null);
        comboBoxActDeportivas.setModel(new DefaultComboBoxModel<DataActividad>());
        comboBoxInstDeportivas.setModel(new DefaultComboBoxModel<DataInstitucion>());
        nolimpio = true;
    }
    
    //Permite cargar los combobox con string
    public void cargarComboboxes(String ninst, String nact) throws ActividadDeportivaNoExisteException, InstitucionDeportivaNoExisteException {
    	DataInstitucion d1 = controlIDeportivas.getInstitucion(ninst);
    	DataActividad a1 = controlADeportivas.getDataActividad(nact);
    	comboBoxInstDeportivas.addItem(d1);
    	comboBoxInstDeportivas.setSelectedItem(d1);
    	comboBoxInstDeportivas.setEnabled(false);
    	comboBoxActDeportivas.addItem(a1);
    	comboBoxActDeportivas.setSelectedItem(a1);
    	comboBoxActDeportivas.setEnabled(false);
  	
    }
    
    /*
	 * Obtiene nombre institucion a partir del nombre de la activdad pasado por parametro. Retorna null si no existe insitucion
	 * con esa actividad.
	 */
    public String obtenerInstitucion(String nombreAct)
    {
    	try
    	{
    		DataInstitucion[] instituciones = controlIDeportivas.getInstituciones();
    		
    		if ((instituciones != null) && (instituciones.length != 0)) {
    			for (DataInstitucion institucion : instituciones)
        		{
        			Set<String> nombresActividades = controlADeportivas.darNombresActividadesDeportivas(institucion.getNombre());
        			if (nombresActividades != null) {
        				for (String nombre : nombresActividades)
            			{
            				if (nombre == nombreAct)
            					return institucion.getNombre();
            			}
        			}
        			
        			
        		}
    		}
    		
    	
    	}
    	catch (InstitucionDeportivaNoExisteException e)
    	{
    		JOptionPane.showMessageDialog(this, e.getMessage(), "Consulta Actividad Deportiva",	JOptionPane.ERROR_MESSAGE);
    		return null;
    	}
    	return null;
    }

    public void cargarCombo(String act) {
    	
    	 String inst = obtenerInstitucion(act);
    	 DefaultComboBoxModel<DataInstitucion> modelo2;
         try {
             modelo2 = new DefaultComboBoxModel<DataInstitucion>();
             modelo2.setSelectedItem(controlIDeportivas.getInstitucion(inst));
             comboBoxInstDeportivas.setModel(modelo2);
         } catch (InstitucionDeportivaNoExisteException e) {
         	JOptionPane.showMessageDialog(this, e.getMessage(), "Consulta Actividad Deportiva", JOptionPane.ERROR_MESSAGE);
         	setVisible(false);
         }

         DefaultComboBoxModel<DataActividad> modelo3;
         try {
             modelo3 = new DefaultComboBoxModel<DataActividad>();
             modelo3.setSelectedItem(controlADeportivas.getDataActividad(act));
             comboBoxActDeportivas.setModel(modelo3);
         } catch (ActividadDeportivaNoExisteException e) {
         	JOptionPane.showMessageDialog(this, e.getMessage(), "Consulta Actividad Deportiva", JOptionPane.ERROR_MESSAGE);
         }
    	
    }

}
