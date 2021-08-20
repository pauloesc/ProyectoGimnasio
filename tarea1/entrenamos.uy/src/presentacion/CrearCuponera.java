
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
	private JDateChooser dateChooseralta;
	private JTextField txtDes;
	
	public CrearCuponera(IctrlCuponeras icc) {
		controlCuponeras=icc;
		setTitle("Crear Cuponera de Actividades Deportivas");
		setClosable(true);
		getContentPane().setLayout(null);
		setBounds(10, 5, 459, 454);
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
		
		Button buttonAceptar = new Button("Aceptar");
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*cmdRegistroADActionPerformed(arg0)*/
			}
		});
		buttonAceptar.setBounds(125, 365, 100, 32);
		getContentPane().add(buttonAceptar);
		
		Button buttonCancelar = new Button("Cancelar");
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 limpiarFormulario();
			}
		});
		buttonCancelar.setBounds(240, 365, 100, 32);
		getContentPane().add(buttonCancelar);	
	}
	
	protected void cmdRegistroADActionPerformed(ActionEvent arg0) {

        String nombre = textNombre.getText();
        String des = textdescrip.getText();
        Date ini = dateChooserini.getDate();
        Date fin = dateChooserfin.getDate();
        Date alta= dateChooseralta.getDate();
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
