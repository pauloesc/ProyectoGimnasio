package presentacion;

import javax.swing.JInternalFrame;
import logica.IctrlCuponeras;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import datatypes.DataInstitucion;
import excepciones.CuponeraNoExisteException;
import excepciones.InstitucionDeportivaNoExisteException;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

@SuppressWarnings({ "serial" })
public class AgregarActividadaCuponera extends JInternalFrame {

	private IctrlCuponeras controlCuponeras;
	private JComboBox<String> comboBoxCuponeras;
	
	
	public AgregarActividadaCuponera(IctrlCuponeras ICC) {
	
		controlCuponeras=ICC;
		
		setTitle("Agregar Actividad Deportiva a Cuponera");
		setClosable(true);
		setBounds(10, 5, 459, 335);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblCuponeras = new JLabel("Cuponeras:");
		lblCuponeras.setBounds(34, 29, 99, 15);
		getContentPane().add(lblCuponeras);
		
		comboBoxCuponeras = new JComboBox<String>();
		comboBoxCuponeras.setBounds(154, 26, 237, 20);
		comboBoxCuponeras.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(comboBoxCuponeras);
		

		
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
