
package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import logica.IctrlCuponeras;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.TextField;
import java.util.Date;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearCuponera extends JInternalFrame {
	
	private IctrlCuponeras controlCuponeras;
	private JTextField textNombre;
	private JTextField textdescrip;
	private JDateChooser dateChooserini;
	private JDateChooser dateChooserfin;
	private JTextField txtDes;
	
	public CrearCuponera(IctrlCuponeras icc) {
		controlCuponeras=icc;
		setTitle("Crear Cuponera de Actividades Deportivas");
		setClosable(true);
		getContentPane().setLayout(null);
		setBounds(10, 5, 459, 432);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(23, 25, 70, 19);
		getContentPane().add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(125, 25, 280, 19);
		getContentPane().add(textNombre);
		
		JLabel lblDescripcion = new JLabel("Descripción:");
		lblDescripcion.setBounds(23, 56, 95, 19);
		getContentPane().add(lblDescripcion);
		
		textdescrip = new JTextField();
		textdescrip.setBounds(125, 56, 280, 85);
		getContentPane().add(textdescrip);
		
		JLabel lblPeriodoDeVigencia = new JLabel("Periodo de vigencia");
		lblPeriodoDeVigencia.setBounds(23, 155, 179, 15);
		getContentPane().add(lblPeriodoDeVigencia);
		
		JLabel lblFechaDeInicio = new JLabel("Fecha inicio:");
		lblFechaDeInicio.setBounds(23, 191, 126, 15);
		getContentPane().add(lblFechaDeInicio);
		
		JLabel lblFechaDeI = new JLabel("Fecha fin:");
		lblFechaDeI.setBounds(23, 222, 76, 15);
		getContentPane().add(lblFechaDeI);
		
		dateChooserini = new JDateChooser();
		dateChooserini.setBounds(125, 218, 128, 19);
		dateChooserini.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(dateChooserini);
		
		dateChooserfin = new JDateChooser();
		dateChooserfin.setBounds(125, 187, 128, 19);
		dateChooserfin.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(dateChooserfin);
		
		JLabel lblDescuento = new JLabel("Descuento:");
		lblDescuento.setBounds(23, 273, 110, 19);
		getContentPane().add(lblDescuento);
		
		txtDes = new JTextField();
		txtDes.setBounds(125, 273, 93, 19);
		txtDes.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(txtDes);
		
		Button buttonAceptar = new Button("Aceptar");
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*cmdRegistroADActionPerformed(arg0)*/
			}
		});
		buttonAceptar.setBounds(125, 337, 100, 32);
		getContentPane().add(buttonAceptar);
		
		Button buttonCancelar = new Button("Cancelar");
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 limpiarFormulario();
			}
		});
		buttonCancelar.setBounds(237, 337, 100, 32);
		getContentPane().add(buttonCancelar);	
	}
	
	protected void cmdRegistroADActionPerformed(ActionEvent arg0) {

        String nombre = textNombre.getText();
        String des = textdescrip.getText();
        Date ini = dateChooserini.getDate();
        Date fin = dateChooserfin.getDate();
        Float desc = Float.parseFloat(txtDes.getText());
        
        if (checkFormulario()) {
            try {
                controlCuponeras.altaActividadDeportiva(nombreID, nombre, des, dur, cost, fal);

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
	
	
	
}

//** package presentacion;

/**
 * JInternalFrame del caso de uso Alta Actividad Deportiva.
 * @author mbarrera
 *
 

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.Button;
import java.awt.TextArea;

import excepciones.ActividadDeportivaRepetidaException;
import excepciones.InstitucionDeportivaRepetidaException;
import excepciones.InstitucionDeportivaNoExisteException;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Choice;
import java.awt.Color;

import com.toedter.calendar.JDateChooser;

import datatypes.DataInstitucion;
import logica.IctrlDeportivas;

@SuppressWarnings({ "serial", "unused" })
public class AltaActividadDeportiva extends JInternalFrame {
	
    // Controlador de Deportivas que se utilizará para las acciones del JFrame
    private IctrlDeportivas controlDeportivas;
    
    private JTextField txtNombre;
    private JTextArea txtDescripcion;
	private JComboBox<DataInstitucion> comboBoxInstDeportivas;
    private JTextField txtDuracion;
    private JTextField txtCosto;
    private JDateChooser dateChooser;
	
	public AltaActividadDeportiva(IctrlDeportivas icd) {
		
		controlDeportivas = icd;
		
		setTitle("Alta de Actividad Deportiva");
		setClosable(true);
		getContentPane().setLayout(null);
		setBounds(20, 50, 462, 411);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
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
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(133, 263, 128, 19);
		dateChooser.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(dateChooser);
		
		Button buttonAceptar = new Button("Aceptar");
		buttonAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	cmdRegistroADActionPerformed(arg0);
            }
        });
		buttonAceptar.setBounds(133, 308, 100, 32);
		getContentPane().add(buttonAceptar);
		
		Button buttonCancelar = new Button("Cancelar");
		buttonCancelar.setBounds(251, 308, 100, 32);
		buttonCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarFormulario();
                //setVisible(false);
            }
        });
		getContentPane().add(buttonCancelar);
	}
	
	// Este método es invocado al querer registrar una Actividad Deportiva, funcionalidad
    // provista por la operación del sistem altaActividadDeportiva().
    // Previamente se hace una verificación de los campos, particularmente que no sean vacíos 
    // Tanto en caso de que haya un error (de verificación o de registro) o no, se despliega
    // un mensaje utilizando un panel de mensaje (JOptionPane).
    protected void cmdRegistroADActionPerformed(ActionEvent arg0) {

        // Obtengo datos de los controles Swing
        String nombreID = String.valueOf(comboBoxInstDeportivas.getSelectedIndex());
        String nombre = txtNombre.getText();
        String des = txtDescripcion.getText();
        Float dur = Float.parseFloat(txtDuracion.getText());
        Float cost = Float.parseFloat(txtCosto.getText());
        Date fal = dateChooser.getDate();
        
        if (checkFormulario()) {
            try {
                controlDeportivas.altaActividadDeportiva(nombreID, nombre, des, dur, cost, fal);

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
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Alta Institución Deportiva",
                    JOptionPane.ERROR_MESSAGE);
            ret = false;
        }
        
        try {
            Float.parseFloat(dur);
        }
        catch (NumberFormatException e) {
    	    JOptionPane.showMessageDialog(this, "La duración debe ser un número", "Alta Institución Deportiva",
    	    		JOptionPane.ERROR_MESSAGE);
            ret = false;
        }
        
        try {
            Float.parseFloat(cost);
        }
        catch (NumberFormatException e) {
    	    JOptionPane.showMessageDialog(this, "El costo debe ser un número", "Alta Institución Deportiva",
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
            modelo = new DefaultComboBoxModel<DataInstitucion>(controlDeportivas.getInstituciones());
            comboBoxInstDeportivas.setModel(modelo);
        } catch (InstitucionDeportivaNoExisteException e) {
        	JOptionPane.showMessageDialog(this, "No existen Instituciones Deportivas en el sistema.", "Alta Institución Deportiva",
    	    		JOptionPane.ERROR_MESSAGE);
        }

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
        dateChooser.cleanup();
        comboBoxInstDeportivas.setSelectedIndex(0);
    }
}
*/
//