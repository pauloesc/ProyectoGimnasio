
package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import logica.IctrlCuponeras;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;

import java.awt.Color;
import java.util.Date;
import com.toedter.calendar.JDateChooser;
import excepciones.CuponeraRepetidaException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.JFrame;
@SuppressWarnings({ "serial" })
public class CrearCuponera extends JInternalFrame {
	
	private IctrlCuponeras controlCuponeras;
	private JTextField textNombre;
	private JTextArea textdescrip;
	private JDateChooser dateChooserini;
	private JDateChooser dateChooserfin;
	private JDateChooser dateChooseralta;
	private JTextField txtDes;
	
	public CrearCuponera(IctrlCuponeras icc) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		addInternalFrameListener(new InternalFrameAdapter() {
			public void internalFrameClosing(InternalFrameEvent e) {
				limpiarFormulario();
				 setVisible(false);
			}
		});
		
		controlCuponeras=icc;
		setTitle("Crear Cuponera de Actividades Deportivas");
		setClosable(true);
		getContentPane().setLayout(null);
		setBounds(10, 5, 459, 454);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(23, 25, 70, 19);
		getContentPane().add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(125, 25, 280, 19);
		textNombre.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(textNombre);
		
		JLabel lblDescripcion = new JLabel("Descripción:");
		lblDescripcion.setBounds(23, 56, 95, 19);
		getContentPane().add(lblDescripcion);
		
		textdescrip = new JTextArea();
		textdescrip.setWrapStyleWord(true);
		textdescrip.setLineWrap(true);
		textdescrip.setBounds(125, 56, 280, 85);
		textdescrip.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(textdescrip);
		
		JLabel lblPeriodoDeVigencia = new JLabel("Periodo de vigencia");
		lblPeriodoDeVigencia.setBounds(23, 155, 179, 15);
		getContentPane().add(lblPeriodoDeVigencia);
		
		JLabel lblFechaDeInicio = new JLabel("Fecha inicio:");
		lblFechaDeInicio.setBounds(23, 187, 126, 15);
		getContentPane().add(lblFechaDeInicio);
		
		JLabel lblFechaDeI = new JLabel("Fecha fin:");
		lblFechaDeI.setBounds(23, 221, 76, 15);
		getContentPane().add(lblFechaDeI);
		
		JLabel lblFechaAlta = new JLabel("Fecha alta:");
		lblFechaAlta.setBounds(23, 315, 95, 15);
		getContentPane().add(lblFechaAlta);
		
		
		dateChooserini = new JDateChooser();
		dateChooserini.setBounds(125, 186, 128, 19);
		dateChooserini.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(dateChooserini);
		
		dateChooserfin = new JDateChooser();
		dateChooserfin.setBounds(125, 221, 128, 19);
		dateChooserfin.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(dateChooserfin);
		
		dateChooseralta = new JDateChooser();
		dateChooseralta.setBounds(125, 315, 128, 19);
		dateChooseralta.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(dateChooseralta);
		
		
		
		JLabel lblDescuento = new JLabel("Descuento:");
		lblDescuento.setBounds(23, 265, 110, 19);
		getContentPane().add(lblDescuento);
		
		txtDes = new JTextField();
		txtDes.setBounds(125, 265, 93, 19);
		txtDes.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(txtDes);
		
		JButton buttonAceptar = new JButton("Aceptar");
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cmdRegistroADActionPerformed(arg0);
			}
		});
		buttonAceptar.setBounds(187, 365, 100, 32);
		getContentPane().add(buttonAceptar);
		
		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 limpiarFormulario();
				 setVisible(false);
			}
		});
		buttonCancelar.setBounds(305, 365, 100, 32);
		getContentPane().add(buttonCancelar);	
		
			
	}
	
	protected void cmdRegistroADActionPerformed(ActionEvent arg0) {

        String nombre = textNombre.getText();
        String des = textdescrip.getText();
        Date ini = dateChooserini.getDate();
        Date fin = dateChooserfin.getDate();
        Date alta= dateChooseralta.getDate();
        String desc = txtDes.getText();
        
        if (checkFormulario()) {
            try {
                controlCuponeras.registrarCuponera(nombre, des, ini, fin, Float.parseFloat(desc), alta, "");

                // Muestro éxito de la operación
                JOptionPane.showMessageDialog(this, "La cuponera se ha registrado con éxito", "Crear Cuponera de Actividades Deportivas",
                        JOptionPane.INFORMATION_MESSAGE);
                
                setVisible(false);
                limpiarFormulario();

            } catch (CuponeraRepetidaException e) {
                // Muestro error de registro
                JOptionPane.showMessageDialog(this, e.getMessage(), "Crear Cuponera de Actividades Deportivas", JOptionPane.ERROR_MESSAGE);
                
            }
        }
    }
	
	private boolean checkFormulario() {
    	
        String nombre = textNombre.getText();
        String des = textdescrip.getText();
        String desc = txtDes.getText();
        Date ini = dateChooserini.getDate();
        Date fin = dateChooserfin.getDate();
        Date alta= dateChooseralta.getDate();
        
        boolean ret = true;

        if (nombre.isEmpty() || des.isEmpty() || desc.isEmpty()|| ini==null || fin==null || alta==null) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Crear Cuponera de Actividades Deportivas",
                    JOptionPane.ERROR_MESSAGE);
            ret = false;
        }
        
	    if (ini.after(fin)) {
	         JOptionPane.showMessageDialog(this, "Error en la fechas, fecha de inicio superior a fecha fin", "Crear Cuponera de Actividades Deportivas",
	    	    		JOptionPane.ERROR_MESSAGE);
	            ret = false;	
	        }
	    
	    if (alta.after(ini)) {
	         JOptionPane.showMessageDialog(this, "Error en la fechas, fecha de alta superior a fecha inicio", "Crear Cuponera de Actividades Deportivas",
	    	    		JOptionPane.ERROR_MESSAGE);
	            ret = false;	
	        }
	        
        if (ret){
	        try {
	            Float.parseFloat(desc);
	        }
	        catch (NumberFormatException e) {
	    	    JOptionPane.showMessageDialog(this, "El descuento debe ser un número", "Crear Cuponera de Actividades Deportivas",
	    	    		JOptionPane.ERROR_MESSAGE);
	            ret = false;
	        }
	        
	        }   
          
        
        return ret;
    }
    
    private void limpiarFormulario() {
        textNombre.setText("");
        textdescrip.setText("");
        txtDes.setText("");
        dateChooserini.setCalendar(null);
        dateChooserfin.setCalendar(null);
        dateChooseralta.setCalendar(null);
    }
}


