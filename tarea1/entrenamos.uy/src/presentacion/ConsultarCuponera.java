/**
 * 
 */
package presentacion;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import excepciones.CuponeraNoExisteException;
import logica.IctrlCuponeras;
import logica.IctrlDeportivas;

/**
 * @author vagrant
 *
 */
@SuppressWarnings({ "serial" })
public class ConsultarCuponera extends JInternalFrame {
	
	private IctrlCuponeras controlCuponeras;
	private IctrlDeportivas controlDeportivas;
	
	public ConsultarCuponera(IctrlCuponeras icc, IctrlDeportivas icd) {
		setClosable(true);
		
	
	
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
	
	