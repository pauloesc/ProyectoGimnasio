
package presentacion;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import excepciones.CuponeraNoExisteException;
import logica.IctrlADeportivas;
import logica.IctrlCuponeras;
import logica.IctrlIDeportivas;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;


/**
 * @author vagrant
 *
 */
@SuppressWarnings({ "serial" })
public class ConsultarCuponera extends JInternalFrame {
	
	private IctrlCuponeras controlCuponeras;
	private IctrlIDeportivas controlIDeportivas;
	private IctrlADeportivas controlADeportivas;
	private JComboBox<String> comboBoxCuponeras;
	private JTextField txtNombre;
    private JTextArea txtDescripcion;
    private JTextField txtFechaIni;
    private JTextField txtDescuento;
    private JTextField txtFechaAlta;
    private JLabel lblPeriodoDeVigencia;
    private JLabel lblFin;
    private JTextField textField;
	
	public ConsultarCuponera(IctrlCuponeras ICC, IctrlIDeportivas IID, IctrlADeportivas IAD) {
	
		controlCuponeras=ICC;
		controlIDeportivas=IID;
		controlADeportivas=IAD;
		
		setTitle("Consultar Cuponera");
		setBounds(10, 5, 502, 526);
		setClosable(true);
		getContentPane().setLayout(null);
		
		JLabel lblCuponeras = new JLabel("Cuponeras:");
		lblCuponeras.setBounds(33, 38, 99, 15);
		getContentPane().add(lblCuponeras);
		
		comboBoxCuponeras = new JComboBox<String>();
		/*comboBoxCuponeras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});*/
		comboBoxCuponeras.setBounds(133, 32, 298, 26);
		comboBoxCuponeras.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(comboBoxCuponeras);
		
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(34, 76, 70, 19);
		getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(133, 73, 298, 26);
		txtNombre.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(txtNombre);
		
		JLabel lblDescripcin = new JLabel("Descripción:");
		lblDescripcin.setBounds(34, 109, 95, 19);
		getContentPane().add(lblDescripcin);
		
		txtDescripcion = new JTextArea();
		txtDescripcion.setEditable(false);
		txtDescripcion.setBounds(133, 110, 298, 89);
		txtDescripcion.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(txtDescripcion);
		
		txtFechaIni = new JTextField();
		txtFechaIni.setEditable(false);
		txtFechaIni.setBounds(195, 209, 93, 23);
		txtFechaIni.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(txtFechaIni);
		
		JLabel lblDescuento = new JLabel("Descuento:");
		lblDescuento.setBounds(33, 248, 99, 22);
		getContentPane().add(lblDescuento);
				
		txtDescuento = new JTextField();
		txtDescuento.setEditable(false);
		txtDescuento.setBounds(133, 249, 93, 23);
		txtDescuento.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(txtDescuento);
		
		JLabel lblFechaDeAlta = new JLabel("Fecha Alta:");
		lblFechaDeAlta.setBounds(33, 282, 95, 19);
		getContentPane().add(lblFechaDeAlta);
		
		txtFechaAlta = new JTextField();
		txtFechaAlta.setEditable(false);
		txtFechaAlta.setBounds(133, 282, 93, 23);
		txtFechaAlta.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(txtFechaAlta);
		
		lblPeriodoDeVigencia = new JLabel("Periodo de vigencia: ");
		lblPeriodoDeVigencia.setBounds(33, 211, 154, 19);
		getContentPane().add(lblPeriodoDeVigencia);
		
		lblFin = new JLabel("al");
		lblFin.setBounds(307, 210, 23, 21);
		getContentPane().add(lblFin);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBorder(BorderFactory.createLineBorder(Color.black));
		textField.setBounds(338, 209, 93, 23);
		getContentPane().add(textField);
		
		
		
		
		
		
	} 

	
	
	public void cargarCuponeras() {
        DefaultComboBoxModel<String> modelo;
        try {
        	int n=controlCuponeras.listarCuponeras().size();
        	String list[]= new String[n];
        	list=controlCuponeras.listarCuponeras().toArray(list);
            modelo = new DefaultComboBoxModel<String>(list);
            modelo.setSelectedItem(null);
            comboBoxCuponeras.setModel(modelo);
        } catch (CuponeraNoExisteException e) {
        	JOptionPane.showMessageDialog(this, "No existen Cuponeras en el sistema.", "Agregar Actividad Deportiva a Cuponera",
    	    		JOptionPane.ERROR_MESSAGE);
        	setVisible(false);
        }

    
	}
}
	
	