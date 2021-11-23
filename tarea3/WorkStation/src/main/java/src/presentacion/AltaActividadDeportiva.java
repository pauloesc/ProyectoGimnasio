package src.presentacion;

/**
 * JInternalFrame del caso de uso Alta Actividad Deportiva.
 * @author mbarrera
 *
 */

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.awt.Button;
import java.awt.TextArea;

import src.excepciones.*;


import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Choice;
import java.awt.Color;

import com.toedter.calendar.JDateChooser;

import src.logica.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JList;

@SuppressWarnings({ "serial", "unused" })
public class AltaActividadDeportiva extends JInternalFrame {
	
    // Controlador de Actividades Deportivas que se utilizará para las acciones del JFrame
    private IctrlADeportivas controlADeportivas;
    private IctrlIDeportivas controlIDeportivas;
    private IctrlCategorias controlCategorias;
    
    private JTextField txtNombre;
    private JTextArea txtDescripcion;
	private JComboBox<DataInstitucion> comboBoxInstDeportivas;
    private JTextField txtDuracion;
    private JTextField txtCosto;
    private JDateChooser dateChooser;
    private DefaultListModel<String> modeloCategorias;
    private JList<String> listCategorias; 
	
	public AltaActividadDeportiva(IctrlADeportivas icad, IctrlIDeportivas icid, IctrlCategorias icat) {
		
		controlADeportivas = icad;
		controlIDeportivas = icid;
		controlCategorias = icat;
		
		setTitle("Alta de Actividad Deportiva");
		setClosable(true);
		getContentPane().setLayout(null);
		setBounds(20, 50, 462, 493);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent eve) {
				limpiarFormulario();
				setVisible(false);
			}
		});
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(34, 80, 70, 19);
		getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(133, 80, 280, 19);
		txtNombre.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(txtNombre);
		
		JLabel lblDescripcion = new JLabel("Descripción:");
		lblDescripcion.setBounds(34, 110, 95, 19);
		getContentPane().add(lblDescripcion);
		
		JLabel lblDuracion = new JLabel("Duración:");
		lblDuracion.setBounds(34, 205, 70, 19);
		getContentPane().add(lblDuracion);
		
		txtDuracion = new JTextField();
		txtDuracion.setBounds(133, 205, 93, 19);
		txtDuracion.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(txtDuracion);
		
		txtDescripcion = new JTextArea();
		txtDescripcion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent eve) {
				if (eve.getKeyCode() == KeyEvent.VK_TAB) {
                    if (eve.getModifiersEx() > 0) {
                    	txtDescripcion.transferFocusBackward();
                    } else {
                    	txtDescripcion.transferFocus();
                    }
                    eve.consume();
                }
			}
		});
		txtDescripcion.setBounds(133, 110, 280, 89);
		txtDescripcion.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(txtDescripcion);
		
		comboBoxInstDeportivas = new JComboBox<DataInstitucion>();
		comboBoxInstDeportivas.setBounds(195, 40, 218, 24);
		comboBoxInstDeportivas.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(comboBoxInstDeportivas);
		
		JLabel lblInstDeportiva = new JLabel("Institución Deportiva:");
		lblInstDeportiva.setLabelFor(comboBoxInstDeportivas);
		lblInstDeportiva.setVerticalAlignment(SwingConstants.TOP);
		lblInstDeportiva.setHorizontalAlignment(SwingConstants.LEFT);
		lblInstDeportiva.setBounds(34, 45, 158, 19);
		getContentPane().add(lblInstDeportiva);
		
		JLabel lblCosto = new JLabel("Costo:");
		lblCosto.setBounds(34, 232, 70, 19);
		getContentPane().add(lblCosto);
		
		txtCosto = new JTextField();
		txtCosto.setBounds(133, 232, 93, 19);
		txtCosto.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(txtCosto);
		
		JLabel lblFechaDeAlta = new JLabel("Fecha Alta:");
		lblFechaDeAlta.setBounds(34, 263, 95, 19);
		getContentPane().add(lblFechaDeAlta);
		
		JButton buttonAceptar = new JButton("Aceptar");
		buttonAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	cmdRegistroADActionPerformed(arg0);
            }
        });
		buttonAceptar.setBounds(133, 401, 100, 32);
		getContentPane().add(buttonAceptar);
		
		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setBounds(251, 401, 100, 32);
		buttonCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eve) {
                limpiarFormulario();
                setVisible(false);
            }
        });
		getContentPane().add(buttonCancelar);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(133, 263, 128, 19);
		dateChooser.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(dateChooser);
		
		JLabel lbl_listCategorias = new JLabel("Categorias:");
		lbl_listCategorias.setBounds(34, 296, 95, 19);
		getContentPane().add(lbl_listCategorias);
		
		listCategorias = new JList<String>();
		listCategorias.setBounds(133, 294, 280, 95);
		listCategorias.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(listCategorias);

	}
	
	// Este método es invocado al querer registrar una Actividad Deportiva, funcionalidad
    // provista por la operación del sistem altaActividadDeportiva().
    // Previamente se hace una verificación de los campos, particularmente que no sean vacíos 
    // Tanto en caso de que haya un error (de verificación o de registro) o no, se despliega
    // un mensaje utilizando un panel de mensaje (JOptionPane).
    protected void cmdRegistroADActionPerformed(ActionEvent arg0) {

        // Obtengo datos de los controles Swing
        String nombreID = comboBoxInstDeportivas.getSelectedItem().toString();
        String nombre = txtNombre.getText();
        String des = txtDescripcion.getText();
        String dur = txtDuracion.getText();
        String cost = txtCosto.getText();
        Date fal = dateChooser.getDate();
        
        Set<String> categorias = new HashSet<String>(listCategorias.getSelectedValuesList());
        
        if (checkFormulario()) {
            try {
                controlADeportivas.altaActividadDeportiva(nombreID, null, nombre, des, Float.parseFloat(dur), Float.parseFloat(cost), fal, categorias, null);

                // Muestro éxito de la operación
                JOptionPane.showMessageDialog(this, "La Actividad Deportiva se ha registrado con éxito", "Alta Actividad Deportiva",
                        JOptionPane.INFORMATION_MESSAGE);
                
                setVisible(false);
                limpiarFormulario();

            } catch (ActividadDeportivaRepetidaException e) {
                // Muestro error de registro
                JOptionPane.showMessageDialog(this, e.getMessage(), "Alta Actividad Deportiva", JOptionPane.ERROR_MESSAGE);
                limpiarFormulario();
            }
        }
    }
	
	// Permite validar la información introducida en los campos e indicar
    // a través de un mensaje de error (JOptionPane) cuando algo sucede.
    // Este tipo de chequeos se puede realizar de otras formas y con otras librerías de Java, 
    // por ejemplo impidiendo que se escriban caracteres no numéricos al momento de escribir en
    // en el campo de la cédula, o mostrando un mensaje de error apenas el foco pasa a otro campo.
    private boolean checkFormulario() {
    	String nombreID = String.valueOf(comboBoxInstDeportivas.getSelectedIndex());
        String nombre = txtNombre.getText();
        String des = txtDescripcion.getText();
        String dur = txtDuracion.getText();
        String cost = txtCosto.getText();
        Date fal = dateChooser.getDate();
        
        boolean ret = true;

        if (nombreID.isEmpty() || nombre.isEmpty() || des.isEmpty() || dur.isEmpty() || cost.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Alta Actividad Deportiva",
                    JOptionPane.ERROR_MESSAGE);
            ret = false;
        }
        
        if (ret){
	        try {
	            Float.parseFloat(dur);
	        }
	        catch (NumberFormatException e) {
	    	    JOptionPane.showMessageDialog(this, "La duración debe ser un número", "Alta Actividad Deportiva",
	    	    		JOptionPane.ERROR_MESSAGE);
	            ret = false;
	        }
	        
	        try {
	            Float.parseFloat(cost);
	        }
	        catch (NumberFormatException e) {
	    	    JOptionPane.showMessageDialog(this, "El costo debe ser un número", "Alta Actividad Deportiva",
	    	    		JOptionPane.ERROR_MESSAGE);
	            ret = false;
	        }
        }
        
        if(listCategorias.isSelectionEmpty()) {
        	JOptionPane.showMessageDialog(this, "Debe seleccionar al menos una categoria", "Alta Actividad Deportiva",
                    JOptionPane.ERROR_MESSAGE);
        	ret = false;
        }
        
        return ret;
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
        	JOptionPane.showMessageDialog(this, e.getMessage(), "Alta Actividad Deportiva",
    	    		JOptionPane.ERROR_MESSAGE);
        	setVisible(false);
        }
        
        Set<String> dcat;
        modeloCategorias = new DefaultListModel<String>();
        dcat = controlCategorias.getCategorias();
        Iterator<String> iter = dcat.iterator();
		while(iter.hasNext()){            	
			modeloCategorias.addElement(iter.next());
		}
        listCategorias.setModel(modeloCategorias);

    }
    
    // Permite borrar el contenido de un formulario antes de cerrarlo.
    // Recordar que las ventanas no se destruyen, sino que simplemente 
    // se ocultan, por lo que conviene borrar la información para que 
    // no aparezca al mostrarlas nuevamente.
    private void limpiarFormulario() {
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtDuracion.setText("");
        txtCosto.setText("");
        dateChooser.setCalendar(null);
    }
}
