package presentacion;

/**
 * JInternalFrame del caso de uso Alta Institución Deportiva.
 * @author mbarrera
 *
 */

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import excepciones.InstitucionDeportivaRepetidaException;
import logica.IctrlIDeportivas;


@SuppressWarnings({ "serial" })
public class AltaInstitucionDeportiva extends JInternalFrame {
	
    // Controlador de Deportivas que se utilizará para las acciones del JFrame
    private IctrlIDeportivas controlDeportivas;
    
    private JTextField txtNombre;
    private JTextArea txtDescripcion;
    private JTextField txtURL;
    private JLabel lblNombre;
    private JLabel lblDescripcion;
    private JLabel lblURL;
    private JButton btnAceptar;
    private JButton btnCancelar;
    
	public AltaInstitucionDeportiva(IctrlIDeportivas icd) {
		
		controlDeportivas = icd;
		
		setTitle("Alta de Institución Deportiva");
		setClosable(true);
		getContentPane().setLayout(null);
		setBounds(10, 40, 446, 291);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent eve) {
				limpiarFormulario();
				setVisible(false);
			}
		});
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(31, 30, 70, 19);
		getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(130, 30, 280, 19);
		txtNombre.setColumns(10);
		txtNombre.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(txtNombre);
		
		lblDescripcion = new JLabel("Descripción:");
		lblDescripcion.setBounds(31, 60, 95, 19);
		getContentPane().add(lblDescripcion);
		
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
		txtDescripcion.setBounds(130, 61, 280, 89);
		txtDescripcion.setColumns(10);
		txtDescripcion.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(txtDescripcion);
		
		lblURL = new JLabel("URL:");
		lblURL.setBounds(31, 156, 70, 19);
		getContentPane().add(lblURL);
		
		txtURL = new JTextField();
		txtURL.setBounds(130, 156, 280, 19);
		txtURL.setColumns(10);
		txtURL.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(txtURL);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	cmdRegistroIDActionPerformed(arg0);
            }
        });
		btnAceptar.setBounds(159, 205, 100, 32);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(277, 205, 100, 32);
		btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eve) {
                limpiarFormulario();
                setVisible(false);
            }
        });
		getContentPane().add(btnCancelar);
	}
	
	// Este método es invocado al querer registrar una Institucion Deportiva, funcionalidad
    // provista por la operación del sistem altaInstitucion().
    // Previamente se hace una verificación de los campos, particularmente que no sean vacíos 
    // Tanto en caso de que haya un error (de verificación o de registro) o no, se despliega
    // un mensaje utilizando un panel de mensaje (JOptionPane).
    protected void cmdRegistroIDActionPerformed(ActionEvent arg0) {

        // Obtengo datos de los controles Swing
        String nombreID = this.txtNombre.getText();
        String desID = this.txtDescripcion.getText();
        String urlID = this.txtURL.getText();

        if (checkFormulario()) {
            try {
                controlDeportivas.altaInstitucion(nombreID, desID, urlID);

                // Muestro éxito de la operación
                JOptionPane.showMessageDialog(this, "La Institución Deportiva se ha registrado con éxito", "Alta Institución Deportiva",
                        JOptionPane.INFORMATION_MESSAGE);
                
                setVisible(false);
                limpiarFormulario();

            } catch (InstitucionDeportivaRepetidaException e) {
                // Muestro error de registro
                JOptionPane.showMessageDialog(this, e.getMessage(), "Alta Institución Deportiva", JOptionPane.ERROR_MESSAGE);
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
        String nombreID = this.txtNombre.getText();
        String desID = this.txtDescripcion.getText();
        String urlID = this.txtURL.getText();

        if (nombreID.isEmpty() || desID.isEmpty() || urlID.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Alta Institución Deportiva",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }
	
    // Permite borrar el contenido de un formulario antes de cerrarlo.
    // Recordar que las ventanas no se destruyen, sino que simplemente 
    // se ocultan, por lo que conviene borrar la información para que 
    // no aparezca al mostrarlas nuevamente.
    private void limpiarFormulario() {
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtURL.setText("");
    }
}
