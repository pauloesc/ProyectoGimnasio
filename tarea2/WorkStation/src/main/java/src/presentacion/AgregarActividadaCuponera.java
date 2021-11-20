package src.presentacion;

import javax.swing.JInternalFrame;

import src.excepciones.*;
import src.logica.*;


import javax.swing.JLabel;
import javax.swing.JOptionPane;


import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JSpinner;



@SuppressWarnings({ "serial" })
public class AgregarActividadaCuponera extends JInternalFrame {

	private IctrlCuponeras controlCuponeras;
	private IctrlIDeportivas controlIDeportivas;
	private JComboBox<String> comboBoxCuponeras;
	private JComboBox<DataInstitucion> comboBoxInstituciones;
	private JComboBox<String> comboBoxDeportivas;
	private JSpinner txtnumClases;
	
	public AgregarActividadaCuponera(IctrlCuponeras ICC, IctrlIDeportivas IID, IctrlADeportivas IAD) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		addInternalFrameListener(new InternalFrameAdapter() {
			public void internalFrameClosing(InternalFrameEvent e) {
				limpiarFormulario();
				 setVisible(false);
			}
		});
	
		controlCuponeras=ICC;
		controlIDeportivas=IID;
		
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
		
		txtnumClases = new JSpinner();
		txtnumClases.setEnabled(false);
		txtnumClases.setBounds(252, 163, 90, 26);
		txtnumClases.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(txtnumClases);
		
		
		JButton buttonAceptar = new JButton("Aceptar");
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cmdAgregarActionPerformed(arg0);
			}
		});
		buttonAceptar.setBounds(252, 223, 100, 32);
		getContentPane().add(buttonAceptar);
		
		JButton buttonCancelar = new JButton("Cancelar");
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

		String nomcups=comboBoxCuponeras.getSelectedItem().toString();
        String nomact=comboBoxDeportivas.getSelectedItem().toString();
        Integer numClases = (Integer) txtnumClases.getValue();
        
        if (checkFormulario()) {
        	try {
                controlCuponeras.agregarActividad(nomcups, nomact, numClases);
                // Muestro éxito de la operación
                JOptionPane.showMessageDialog(this, "La actividad deportiva se ha agregado con éxito", "Agregar actividad deportiva a cuponera",
                        JOptionPane.INFORMATION_MESSAGE);
                
                setVisible(false);
                limpiarFormulario();
        	   }catch (ActividadDeportivaRepetidaException e) {
                   // Muestro error de registro
                   JOptionPane.showMessageDialog(this,"La actividad deportiva ya existe en la cuponera", "Agregar actividades deportivas a cuponera", JOptionPane.ERROR_MESSAGE);
                   
               }
            } 
        }
    
	private boolean checkFormulario() {
    
        boolean ret = true;
        Integer numClases = (Integer) txtnumClases.getValue();
        
        if (numClases<=0) {
	         JOptionPane.showMessageDialog(this, "La cantidad de clases debe ser un numero mayor a cero",title, JOptionPane.ERROR_MESSAGE);
	            ret = false;	
	        }
        return ret;
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
        	int n=controlCuponeras.listarcuponeraslibres().size();
        	String list[]= new String[n];
        	list=controlCuponeras.listarcuponeraslibres().toArray(list);
            modelo = new DefaultComboBoxModel<String>(list);
            modelo.setSelectedItem(null);
            comboBoxCuponeras.setModel(modelo);
        } catch (CuponeraNoExisteException e) {
        	JOptionPane.showMessageDialog(this, "No existen Cuponeras disponibles en el sistema.", "Agregar Actividad Deportiva a Cuponera",
    	    		JOptionPane.ERROR_MESSAGE);
        	setVisible(false);
        }

    }
	
	public void cargarInstituciones() {
        DefaultComboBoxModel<DataInstitucion> modelo2;
        try {
            modelo2 = new DefaultComboBoxModel<DataInstitucion>(controlIDeportivas.getInstituciones());
            modelo2.setSelectedItem(null);
            comboBoxInstituciones.setModel(modelo2);
        } catch (InstitucionDeportivaNoExisteException e) {
        	JOptionPane.showMessageDialog(this, "No existen Instituciones Deportivas en el sistema.", "Alta Actividad Deportiva",
    	    		JOptionPane.ERROR_MESSAGE);
        	setVisible(false);
        }

    }
	 private void limpiarFormulario() {
		 comboBoxInstituciones.setEnabled(false);
		 comboBoxDeportivas.setSelectedItem(null);
		 comboBoxDeportivas.setEnabled(false);
		 txtnumClases.setEnabled(false);
		 txtnumClases.setValue(0);
	    }
}
