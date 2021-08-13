package presentacion;

/**
 * JInternalFrame del caso de uso Alta Actividad Deportiva.
 * @author mbarrera
 *
 */

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Button;
import java.awt.TextArea;

import excepciones.ActividadDeportivaRepetidaException;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import java.awt.Choice;
//import logica.IctrlDeportivas;

@SuppressWarnings({ "serial", "unused" })
public class AltaActividadDeportiva extends JInternalFrame {
	public AltaActividadDeportiva() {
		setTitle("Alta de Actividad Deportiva");
		setClosable(true);
		getContentPane().setLayout(null);
		setBounds(20, 50, 462, 411);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(34, 80, 70, 19);
		getContentPane().add(lblNombre);
		
		TextField textNombre = new TextField();
		textNombre.setBounds(133, 80, 280, 19);
		getContentPane().add(textNombre);
		
		JLabel lblDescripcin = new JLabel("Descripción:");
		lblDescripcin.setBounds(34, 110, 95, 19);
		getContentPane().add(lblDescripcin);
		
		JLabel lblDuracion = new JLabel("Duración:");
		lblDuracion.setBounds(34, 205, 70, 19);
		getContentPane().add(lblDuracion);
		
		TextField textDuracion = new TextField();
		textDuracion.setBounds(133, 205, 93, 19);
		getContentPane().add(textDuracion);
		
		Button buttonAceptar = new Button("Aceptar");
		buttonAceptar.setBounds(133, 308, 100, 32);
		getContentPane().add(buttonAceptar);
		
		Button buttonCancelar = new Button("Cancelar");
		buttonCancelar.setBounds(251, 308, 100, 32);
		buttonCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //limpiarFormulario();
                setVisible(false);
            }
        });
		getContentPane().add(buttonCancelar);
		
		TextArea textDescripcion = new TextArea();
		textDescripcion.setBounds(133, 110, 280, 89);
		getContentPane().add(textDescripcion);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBoxInstDeportivas = new JComboBox();
		comboBoxInstDeportivas.setBounds(195, 40, 218, 24);
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
		
		TextField textCosto = new TextField();
		textCosto.setBounds(133, 232, 93, 19);
		getContentPane().add(textCosto);
		
		JLabel lblFechaDeAlta = new JLabel("Fecha Alta:");
		lblFechaDeAlta.setBounds(34, 263, 95, 19);
		getContentPane().add(lblFechaDeAlta);
		
		JSpinner dia = new JSpinner();
		dia.setBounds(133, 263, 46, 20);
		getContentPane().add(dia);
		
		JSpinner mes = new JSpinner();
		mes.setBounds(180, 263, 46, 20);
		getContentPane().add(mes);
		
		JSpinner ano = new JSpinner();
		ano.setBounds(227, 263, 62, 20);
		getContentPane().add(ano);
	}
}
