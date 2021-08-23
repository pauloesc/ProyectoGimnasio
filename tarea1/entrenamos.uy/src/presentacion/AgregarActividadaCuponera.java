package presentacion;

import javax.swing.JInternalFrame;
import logica.IctrlCuponeras;
import logica.IctrlDeportivas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import datatypes.DataInstitucion;
import excepciones.ActividadDeportivaNoExisteException;
import excepciones.CuponeraNoExisteException;
import excepciones.InstitucionDeportivaNoExisteException;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings({ "serial" })
public class AgregarActividadaCuponera extends JInternalFrame {

	private IctrlCuponeras controlCuponeras;
	private IctrlDeportivas controlDeportivas;
	private JComboBox<String> comboBoxCuponeras;
	private JComboBox<DataInstitucion> comboBoxInstituciones;
	private JComboBox<String> comboBoxDeportivas;
	private JTextField txtnumClases;
	
	public AgregarActividadaCuponera(IctrlCuponeras ICC, IctrlDeportivas IDD) {
	
		controlCuponeras=ICC;
		controlDeportivas=IDD;
		
		setTitle("Agregar Actividad Deportiva a Cuponera");
		setClosable(true);
		setBounds(10, 5, 516, 335);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblCuponeras = new JLabel("Cuponeras:");
		lblCuponeras.setBounds(28, 29, 99, 15);
		getContentPane().add(lblCuponeras);
		
		comboBoxCuponeras = new JComboBox<String>();
		comboBoxCuponeras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxInstituciones.setEnabled(true);
			}
		});
		comboBoxCuponeras.setBounds(167, 26, 237, 26);
		comboBoxCuponeras.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(comboBoxCuponeras);
		
		
		JLabel lblInstituciones = new JLabel("Instituciones:");
		lblInstituciones.setBounds(28, 69, 99, 15);
		getContentPane().add(lblInstituciones);
		
		comboBoxInstituciones = new JComboBox<DataInstitucion>();
		comboBoxInstituciones.setEnabled(false);
		comboBoxInstituciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ele) {
				cargarDerportivas (ele);
				comboBoxDeportivas.setEnabled(true);
			}
		});
		comboBoxInstituciones.setBorder(BorderFactory.createLineBorder(Color.black));
		comboBoxInstituciones.setBounds(167, 66, 237, 26);
		getContentPane().add(comboBoxInstituciones);
		
		JLabel lblActividades = new JLabel("Actividades Deportivas :");
		lblActividades.setBounds(28, 113, 189, 20);
		getContentPane().add(lblActividades);
		
		comboBoxDeportivas = new JComboBox<String>();
		comboBoxDeportivas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtnumClases.setEditable(true);
				txtnumClases.setEnabled(true);
			}
		});
		comboBoxDeportivas.setEnabled(false);
		comboBoxDeportivas.setBorder(BorderFactory.createLineBorder(Color.black));
		comboBoxDeportivas.setBounds(221, 113, 237, 26);
		getContentPane().add(comboBoxDeportivas);
		
		JLabel lblNmeroDeClases = new JLabel("Número de clases disponibles:");
		lblNmeroDeClases.setBounds(28, 165, 230, 20);
		getContentPane().add(lblNmeroDeClases);
		
		txtnumClases = new JTextField();
		txtnumClases.setEditable(false);
		txtnumClases.setEnabled(false);
		txtnumClases.setBounds(264, 165, 85, 20);
		txtnumClases.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(txtnumClases);
		txtnumClases.setColumns(10);
		
	}
	
	
	
	
	
	
	protected void cargarDerportivas(ActionEvent ele) {
		String nomins=comboBoxInstituciones.getSelectedItem().toString();
		String nomcups=comboBoxCuponeras.getSelectedItem().toString();
		DefaultComboBoxModel<String> modelo3;
        try {
        	int n=controlCuponeras.listarActividadesfaltantes(nomcups,nomins).size();
        	String list[]= new String[n];
        	list=controlCuponeras.listarActividadesfaltantes(nomcups,nomins).toArray(list);
            modelo3 = new DefaultComboBoxModel<String>(list);
            modelo3.setSelectedItem(null);
            comboBoxDeportivas.setModel(modelo3);
        } catch (ActividadDeportivaNoExisteException e) {
        	JOptionPane.showMessageDialog(this, e.getMessage(), "Agregar Actividad Deportiva a Cuponera",
    	    		JOptionPane.ERROR_MESSAGE);
        	setVisible(false);
        }

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
	
	public void cargarInstituciones() {
        DefaultComboBoxModel<DataInstitucion> modelo2;
        try {
            modelo2 = new DefaultComboBoxModel<DataInstitucion>(controlDeportivas.getInstituciones());
            modelo2.setSelectedItem(null);
            comboBoxInstituciones.setModel(modelo2);
        } catch (InstitucionDeportivaNoExisteException e) {
        	JOptionPane.showMessageDialog(this, "No existen Instituciones Deportivas en el sistema.", "Alta Actividad Deportiva",
    	    		JOptionPane.ERROR_MESSAGE);
        	setVisible(false);
        }

    }

    
}
