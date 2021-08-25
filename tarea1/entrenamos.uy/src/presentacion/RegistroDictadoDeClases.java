package presentacion;

import java.awt.EventQueue;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import logica.Fabrica;
import logica.IctrlClases;
import logica.IctrlCuponeras;
import logica.IctrlDeportivas;
import logica.IctrlUsuarios;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import datatypes.DtClase;
import excepciones.ClaseRepetidaException;
import excepciones.CuponeraNoExisteException;

import javax.swing.JCheckBox;

public class RegistroDictadoDeClases extends JInternalFrame {
	private JComboBox<String> comboBoxInstituciones;
	private JComboBox<String> comboBoxClase;
	private JComboBox<String> comboBoxActividadDeportiva;
	private JComboBox<String> comboBoxSocio;
	private JCheckBox chckbxCuponera;
	private JComboBox<String> comboBoxCuponera;
	private JDateChooser dateChooserRegistro;
	
	private IctrlDeportivas ID;
	private IctrlUsuarios IU;
	private IctrlClases IC;
	private IctrlCuponeras ICUP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroDictadoDeClases frame = new RegistroDictadoDeClases();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	
	public RegistroDictadoDeClases() {
		Fabrica fab = Fabrica.getInstance();
		ID = fab.getIctrlDeportivas();
		IU = fab.getIctrlUsuarios();
		IC = fab.getIctrlClases();
		ICUP = fab.getIctrlCuponeras();
		
		
		setTitle("Registro a dictado de clase");
		setBounds(100, 100, 518, 484);
		
		comboBoxInstituciones = new JComboBox();	
		comboBoxClase = new JComboBox();	
		comboBoxActividadDeportiva = new JComboBox();
		comboBoxSocio = new JComboBox();
		chckbxCuponera = new JCheckBox("Cuponera");
		comboBoxCuponera = new JComboBox();
		dateChooserRegistro = new JDateChooser();
		
		
		comboBoxCuponera.setEnabled(false);
		
		//cuando se selecciona una institucion se cargan las actividades deportivas
		
		comboBoxInstituciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String insti = (String) comboBoxInstituciones.getSelectedItem();
				
				if (insti != null) {
					
					comboBoxActividadDeportiva.removeAllItems();
					Set<String> act = ID.darNombresActividadesDeportivas(insti);
					for( Iterator<String> it = act.iterator(); it.hasNext();) { 
					    String x = (String)it.next();
					    comboBoxActividadDeportiva.addItem(x);

					}
					
					
					
					comboBoxActividadDeportiva.setEnabled(true);
					comboBoxActividadDeportiva.setSelectedItem(null);
					
				}
				
			}
		});
		
		
		// cuando se carga la actividad deportiva se cargan las clases vigentes
		comboBoxActividadDeportiva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String act = (String)comboBoxActividadDeportiva.getSelectedItem();
				if (act != null) {
					
					comboBoxClase.removeAllItems();
					Set<String> clases = ID.mostrarClasesVigentesDeActividadDeportiva(act);
					
					for( Iterator<String> itt = clases.iterator(); itt.hasNext();) { 
					    String x = (String)itt.next();
					    comboBoxClase.addItem(x);
	
					}
					
					comboBoxClase.setEnabled(true);
					comboBoxClase.setSelectedItem(null);
				}
			}
		});
		
		
		// seleccion si es con cuponera
		chckbxCuponera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxCuponera.isSelected()) {
					
					if ((comboBoxSocio.getSelectedItem() == null) || (comboBoxActividadDeportiva.getSelectedItem() == null)) {
						JOptionPane.showMessageDialog(null, "Primero se debe seleccionar el socio y la actividad deportiva");
					} else {
						Set<String> cup = IU.MostrarCuponerasDisponibles((String)comboBoxSocio.getSelectedItem(),(String)comboBoxActividadDeportiva.getSelectedItem());
						if (cup.size() == 0) {
							JOptionPane.showMessageDialog(null, "El socio no tiene cuponeras disponibles para esta actividad");
							chckbxCuponera.setSelected(false);
						} else {
							for( Iterator<String> itt = cup.iterator(); itt.hasNext();) { 
							    String x = (String)itt.next();
							    comboBoxCuponera.addItem(x);
							}
							comboBoxCuponera.setEnabled(true);
						}
					}
					
				} else {
					comboBoxCuponera.removeAllItems();
					comboBoxCuponera.setEnabled(false);
				}
			}
		});
		
		
		
		JLabel lblActividadDeportiva = new JLabel("Actividad deportiva");
		JLabel lblInstitucion = new JLabel("Institucion deportiva");
		JLabel lblProfesor = new JLabel("Clase vigente");
		JLabel lblSocioARegistrar = new JLabel("Socio a registrar");
		JLabel lblFechaDeRegistro = new JLabel("Fecha de registro");
		
		
		
		
		
		
		
		//botones aceptar y cancelar
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboBoxClase.removeAllItems();
				comboBoxActividadDeportiva.removeAllItems();
				comboBoxInstituciones.removeAllItems();
				
				comboBoxClase.setEnabled(false);
				comboBoxActividadDeportiva.setEnabled(false);
								
				
				
				setVisible(false);
				
			}
		});
		
		JButton btnAceptar = new JButton("Aceptar");
		
		
		
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(215)
							.addComponent(btnAceptar)
							.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
							.addComponent(btnCancelar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblInstitucion)
								.addComponent(lblActividadDeportiva)
								.addComponent(lblProfesor)
								.addComponent(chckbxCuponera)
								.addComponent(lblSocioARegistrar)
								.addComponent(lblFechaDeRegistro))
							.addGap(21)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(dateChooserRegistro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(comboBoxCuponera, 0, 262, Short.MAX_VALUE)
									.addComponent(comboBoxSocio, 0, 262, Short.MAX_VALUE)
									.addComponent(comboBoxClase, 0, 262, Short.MAX_VALUE)
									.addComponent(comboBoxActividadDeportiva, 0, 262, Short.MAX_VALUE)
									.addComponent(comboBoxInstituciones, 0, 262, Short.MAX_VALUE)))))
					.addContainerGap(66, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblInstitucion)
						.addComponent(comboBoxInstituciones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxActividadDeportiva, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblActividadDeportiva))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxClase, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblProfesor))
					.addGap(63)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblSocioARegistrar)
						.addComponent(comboBoxSocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxCuponera)
						.addComponent(comboBoxCuponera, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblFechaDeRegistro)
						.addComponent(dateChooserRegistro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(51)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnAceptar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
					.addGap(97))
		);
		getContentPane().setLayout(groupLayout);

		
		
		
		
	}

	public void cargarFormulario() {
		
		//INSTITUCIONES
		Set<String> nombInst = ID.darNombreInstituciones();
		comboBoxInstituciones.removeAllItems();
		
		for( Iterator<String> it = nombInst.iterator(); it.hasNext();) { 
			    String x = (String)it.next();
			    comboBoxInstituciones.addItem(x);
		}
		comboBoxInstituciones.setSelectedItem(null);
		
		//SOCIOS
		Vector<String> nomSoc = IU.UsuariosEnSistemaNickName();
		comboBoxSocio.removeAllItems();
		
		for(int i = 0; i < nomSoc.size(); i++) { 
			  
			    comboBoxSocio.addItem(nomSoc.get(i));
		}
		comboBoxSocio.setSelectedItem(null);
		
	}
}
