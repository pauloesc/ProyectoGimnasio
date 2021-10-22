package presentacion;

/**
 * JInternalFrame del caso de uso Consulta Actividad Deportiva.
 * @author mbarrera
 */

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;


import excepciones.ActividadDeportivaNoExisteException;

import excepciones.ClaseNoExisteException;
import excepciones.CuponeraNoExisteException;
import excepciones.InstitucionDeportivaNoExisteException;

import logica.DataActividad;

import logica.DataInstitucion;

import logica.IctrlADeportivas;
import logica.IctrlClases;
import logica.IctrlIDeportivas;
import logica.IctrlCuponeras;


import java.awt.Color;


import javax.swing.JList;
import javax.swing.JOptionPane;

import javax.swing.JTabbedPane;
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

public class ConsultaActividadDeportiva extends JInternalFrame {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private JList<String> listCategorias;
	private JTextField txtNombre;
    private JTextArea txtDescripcion;
    private JTextField txtDuracion;
    private JTextField txtCosto;
    private JTextField txtFechaAlta;
    private DefaultListModel<String> modeloCuponeras;
    private DefaultListModel<String> modeloClases;
    private DefaultListModel<String> modeloCategorias;
    private Boolean nolimpio;
    private JTextField txtEstado;
    
    
    
	public ConsultaActividadDeportiva(IctrlIDeportivas icid, IctrlADeportivas icad, IctrlCuponeras icup, IctrlClases icla, ConsultaDictadoDeClases consultaClase, ConsultarCuponera consultaCuponera) {
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
		frameCuponeras = consultaCuponera;
		frameClases = consultaClase;
		
		setTitle("Consulta de Actividad Deportiva");
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);;
		getContentPane().setLayout(null);
		setBounds(10, 5, 459, 628);
		
		

		
		JLabel lblInstDeportiva = new JLabel("Institución Deportiva:");
		lblInstDeportiva.setVerticalAlignment(SwingConstants.TOP);
		lblInstDeportiva.setHorizontalAlignment(SwingConstants.LEFT);
		lblInstDeportiva.setBounds(34, 17, 158, 19);
		getContentPane().add(lblInstDeportiva);
		
		comboBoxInstDeportivas = new JComboBox<DataInstitucion>();
		comboBoxInstDeportivas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eve) {
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
			public void actionPerformed(ActionEvent eve) {
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
		txtDescripcion.setWrapStyleWord(true);
		txtDescripcion.setLineWrap(true);
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
		tabbedPane.setBounds(29, 325, 384, 222);
		getContentPane().add(tabbedPane);
		
		listCategorias = new JList<String>();
		tabbedPane.addTab("Categorias", null, listCategorias, null);
		
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
		btnSalir.setBounds(296, 559, 117, 25);
		getContentPane().add(btnSalir);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(34, 294, 95, 19);
		getContentPane().add(lblEstado);
		
		txtEstado = new JTextField();
		txtEstado.setEditable(false);
		txtEstado.setBorder(BorderFactory.createLineBorder(Color.black));
		txtEstado.setBounds(133, 294, 93, 19);
		getContentPane().add(txtEstado);
		
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
        } catch (ActividadDeportivaNoExisteException exe) {
        	JOptionPane.showMessageDialog(this, exe.getMessage(), "Consulta Actividad Deportiva", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    // Método que permite cargar los datos de la Actividad Deportiva seleccionada
    // provistos por la operación del sistema getDataActividad().
    // Se invoca el método luego de haber seleccionado la Institución Deportiva y la Actividad Deportiva
    public void cargarDatosActividad(String nom) {
    	
        Date date = null;  
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");  
    
        try {
            DataActividad act = controlADeportivas.getDataActividad(nom);
            txtNombre.setText(act.getNombre());
            txtDescripcion.setText(act.getDescripcion());
            txtDuracion.setText(act.getDuracion().toString());
            txtCosto.setText(act.getCosto().toString());
            txtEstado.setText(act.getEstado().toString());
            date = act.getFechaAlta();
            String strDate = dateFormat.format(date);
            
            txtFechaAlta.setText(strDate);            
        } catch (ActividadDeportivaNoExisteException exe) {
        	JOptionPane.showMessageDialog(this, exe.getMessage(), "Consulta Actividad Deportiva",	JOptionPane.ERROR_MESSAGE);
        	setVisible(false);
        }
        
        Set<String> dcu;
        modeloCuponeras = new DefaultListModel<String>();
		try {
			dcu = controlCuponeras.getCuponerasActividad(nom);
			Iterator<String> iter = dcu.iterator();
			while(iter.hasNext()){            	
	               modeloCuponeras.addElement(iter.next());
	            }
		} catch (CuponeraNoExisteException exe) {
			JOptionPane.showMessageDialog(this, exe.getMessage(), "Consulta Actividad Deportiva",	JOptionPane.ERROR_MESSAGE);
		}
        
        listCuponeras.setModel(modeloCuponeras);
        
        Set<String> dcla;
        modeloClases = new DefaultListModel<String>();
        try {
			dcla = controlClases.mostrarClasesDeActividadDeportiva(nom);
	        Iterator<String> iter = dcla.iterator();
	        while(iter.hasNext()){            	
	        	modeloClases.addElement(iter.next());
			}
		} catch (ClaseNoExisteException exe) {
			JOptionPane.showMessageDialog(this, exe.getMessage(), "Consulta Actividad Deportiva",	JOptionPane.ERROR_MESSAGE);
		}

        
        listClases.setModel(modeloClases);
        
        Set<String> dcat;
        modeloCategorias = new DefaultListModel<String>();
        try {
			dcat = controlADeportivas.getDataActividad(nom).getCategorias();
			Iterator<String> iter = dcat.iterator();
			while(iter.hasNext()){            	
				modeloCategorias.addElement(iter.next());
			}  
		} catch (ActividadDeportivaNoExisteException exe) {
			JOptionPane.showMessageDialog(this, exe.getMessage(), "Consulta Actividad Deportiva",	JOptionPane.ERROR_MESSAGE);
		}
		     
        listCategorias.setModel(modeloCategorias);
        
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
        txtEstado.setText("");
        listClases.removeAll();
        listCuponeras.removeAll();
        listCategorias.removeAll();
        if (modeloClases != null) {
            modeloClases.clear();
            modeloCuponeras.clear();
            modeloCategorias.clear();
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
    public void cargarComboboxes(String ninst, String nact)  {
	
   	 DefaultComboBoxModel<DataInstitucion> modelo22;
        try {
            modelo22 = new DefaultComboBoxModel<DataInstitucion>();
            modelo22.setSelectedItem(controlIDeportivas.getInstitucion(ninst));
            comboBoxInstDeportivas.setModel(modelo22);
        } catch (InstitucionDeportivaNoExisteException e) {
        	JOptionPane.showMessageDialog(this, e.getMessage(), "Consulta Actividad Deportiva", JOptionPane.ERROR_MESSAGE);
        	setVisible(false);
        }
    	
        DefaultComboBoxModel<DataActividad> modelo33;
        try {
            modelo33 = new DefaultComboBoxModel<DataActividad>();
            modelo33.setSelectedItem(controlADeportivas.getDataActividad(nact));
            comboBoxActDeportivas.setModel(modelo33);
        } catch (ActividadDeportivaNoExisteException e) {
        	JOptionPane.showMessageDialog(this, e.getMessage(), "Consulta Actividad Deportiva", JOptionPane.ERROR_MESSAGE);
        }
    	
    	
  	
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
