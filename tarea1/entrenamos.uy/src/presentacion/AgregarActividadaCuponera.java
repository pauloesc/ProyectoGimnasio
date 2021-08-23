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
import excepciones.CuponeraRepetidaException;
import excepciones.InstitucionDeportivaNoExisteException;

import java.awt.Button;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;

@SuppressWarnings({ "serial" })
public class AgregarActividadaCuponera extends JInternalFrame {

	private IctrlCuponeras controlCuponeras;
	private IctrlDeportivas controlDeportivas;
	private JComboBox<String> comboBoxCuponeras;
	private JComboBox<DataInstitucion> comboBoxInstituciones;
	private JComboBox<String> comboBoxDeportivas;
	private JTextField txtnumClases;
	
	public AgregarActividadaCuponera(IctrlCuponeras ICC, IctrlDeportivas IDD) {
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				limpiarFormulario();
				 setVisible(false);
			}
		});
	
		controlCuponeras=ICC;
		controlDeportivas=IDD;
		
		setTitle("Agregar Actividad Deportiva a Cuponera");
		setClosable(true);
		setBounds(10, 5, 516, 309);
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
		txtnumClases.setBounds(252, 163, 90, 26);
		txtnumClases.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(txtnumClases);
		txtnumClases.setColumns(10);
		
		Button buttonAceptar = new Button("Aceptar");
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cmdAgregarActionPerformed(arg0);
			}
		});
		buttonAceptar.setBounds(252, 223, 100, 32);
		getContentPane().add(buttonAceptar);
		
		Button buttonCancelar = new Button("Cancelar");
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 limpiarFormulario();
				 setVisible(false);
			}
		});
		buttonCancelar.setBounds(369, 223, 100, 32);
		getContentPane().add(buttonCancelar);	
		
	}
	
	
	protected void cmdAgregarActionPerformed(ActionEvent arg0) {

		String nomins=comboBoxInstituciones.getSelectedItem().toString();
		String nomcups=comboBoxCuponeras.getSelectedItem().toString();
        String nomact=comoboBoxActividades.get
        String desc = txtDes.getText();
        
        if (checkFormulario()) {
            try {
                controlCuponeras.registrarCuponera(nombre, des, ini, fin, Float.parseFloat(desc), alta);

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
        	comboBoxDeportivas.setSelectedItem(null);
        	JOptionPane.showMessageDialog(this, "No hay actividades deportivas disponibles para agregar", "Agregar Actividad Deportiva a Cuponera",
    	    		JOptionPane.ERROR_MESSAGE);
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
	 private void limpiarFormulario() {
	        
	    }
    
}
