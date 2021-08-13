package presentacion;

/**
 * JInternalFrame del caso de uso Consulta Actividad Deportiva.
 * @author mbarrera
 */

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Button;
import java.awt.TextArea;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JComponent;
import java.awt.Choice;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.JTabbedPane;
//import logica.IctrlDeportivas;

@SuppressWarnings({ "serial", "unused" })
public class ConsultaActividadDeportiva extends JInternalFrame {
	public ConsultaActividadDeportiva() {
		setTitle("Consulta de Actividad Deportiva");
		setClosable(true);
		getContentPane().setLayout(null);
		setBounds(10, 5, 459, 542);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(34, 80, 70, 19);
		getContentPane().add(lblNombre);
		
		TextField textNombre = new TextField();
		textNombre.setEditable(false);
		textNombre.setBounds(133, 80, 280, 19);
		getContentPane().add(textNombre);
		
		JLabel lblDescripcin = new JLabel("Descripción:");
		lblDescripcin.setBounds(34, 110, 95, 19);
		getContentPane().add(lblDescripcin);
		
		JLabel lblDuracion = new JLabel("Duración:");
		lblDuracion.setBounds(34, 205, 70, 19);
		getContentPane().add(lblDuracion);
		
		TextField textDuracion = new TextField();
		textDuracion.setEditable(false);
		textDuracion.setBounds(133, 205, 93, 19);
		getContentPane().add(textDuracion);
		
		TextArea textDescripcion = new TextArea();
		textDescripcion.setEditable(false);
		textDescripcion.setBounds(133, 110, 280, 89);
		getContentPane().add(textDescripcion);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBoxInstDeportivas = new JComboBox();
		comboBoxInstDeportivas.setBounds(195, 12, 218, 24);
		getContentPane().add(comboBoxInstDeportivas);
		
		JLabel lblInstDeportiva = new JLabel("Institución Deportiva:");
		lblInstDeportiva.setLabelFor(comboBoxInstDeportivas);
		lblInstDeportiva.setVerticalAlignment(SwingConstants.TOP);
		lblInstDeportiva.setHorizontalAlignment(SwingConstants.LEFT);
		lblInstDeportiva.setBounds(34, 17, 158, 19);
		getContentPane().add(lblInstDeportiva);
		
		JLabel lblCosto = new JLabel("Costo:");
		lblCosto.setBounds(34, 232, 70, 19);
		getContentPane().add(lblCosto);
		
		TextField textCosto = new TextField();
		textCosto.setEditable(false);
		textCosto.setBounds(133, 232, 93, 19);
		getContentPane().add(textCosto);
		
		JLabel lblFechaDeAlta = new JLabel("Fecha Alta:");
		lblFechaDeAlta.setBounds(34, 263, 95, 19);
		getContentPane().add(lblFechaDeAlta);
		
		JSpinner dia = new JSpinner();
		dia.setEnabled(false);
		dia.setBounds(133, 263, 46, 20);
		getContentPane().add(dia);
		
		JSpinner mes = new JSpinner();
		mes.setEnabled(false);
		mes.setBounds(180, 263, 46, 20);
		getContentPane().add(mes);
		
		JSpinner ano = new JSpinner();
		ano.setEnabled(false);
		ano.setBounds(227, 263, 62, 20);
		getContentPane().add(ano);
		
		JLabel lblActDeportiva = new JLabel("Actividad Deportiva:");
		lblActDeportiva.setVerticalAlignment(SwingConstants.TOP);
		lblActDeportiva.setHorizontalAlignment(SwingConstants.LEFT);
		lblActDeportiva.setBounds(34, 49, 158, 19);
		getContentPane().add(lblActDeportiva);
		
		JComboBox comboBoxActDeportivas = new JComboBox();
		lblActDeportiva.setLabelFor(comboBoxActDeportivas);
		comboBoxActDeportivas.setBounds(195, 44, 218, 24);
		getContentPane().add(comboBoxActDeportivas);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(34, 294, 384, 205);
		getContentPane().add(tabbedPane);
		
		JList listClases = new JList();
		tabbedPane.addTab("Clases", null, listClases, null);
		
		JList listCuponeras = new JList();
		tabbedPane.addTab("Cuponeras", null, listCuponeras, null);
	}
}
