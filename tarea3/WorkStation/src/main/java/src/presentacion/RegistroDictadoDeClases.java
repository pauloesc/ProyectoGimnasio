package src.presentacion;

import java.awt.EventQueue;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;


import src.logica.DtClase;
import src.logica.Fabrica;
import src.logica.IctrlADeportivas;
import src.logica.IctrlClases;
import src.logica.IctrlIDeportivas;
import src.logica.IctrlUsuarios;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import src.excepciones.ClaseLlenaException;
import src.excepciones.ClaseYaCompradaException;
import javax.swing.JCheckBox;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import com.toedter.calendar.JDateChooser;

import javax.swing.JFrame;

public class RegistroDictadoDeClases extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> comboBoxInstituciones;
	private JComboBox<String> comboBoxClase;
	private JComboBox<String> comboBoxActividadDeportiva;
	private JComboBox<String> comboBoxSocio;
	private JCheckBox chckbxCuponera;
	private JComboBox<String> comboBoxCuponera;
	private JDateChooser dateChooserRegistro;
	
	private IctrlADeportivas IAD;
	private IctrlIDeportivas IID;
	private IctrlUsuarios IU;
	private IctrlClases IC;
	private JTextField textFieldProfesor;
	private JTextField textFieldFecha;
	private JTextField textFieldUrl;
	private JTextField textFieldMinimos;
	private JTextField textFieldMaximos;

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
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				setVisible(false);
				limpiarFormulario();
			}
		});
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		
		
	
		setClosable(true);
		
		Fabrica fab = Fabrica.getInstance();
		IAD = fab.getIctrlADeportivas();
		IID = fab.getIctrlIDeportivas();
		IU = fab.getIctrlUsuarios();
		IC = fab.getIctrlClases();
		
		
		setTitle("Registro a dictado de clase");
		setBounds(100, 100, 551, 570);
		
		comboBoxInstituciones = new JComboBox<String>();	
		comboBoxClase = new JComboBox<String>();	
		comboBoxActividadDeportiva = new JComboBox<String>();
		comboBoxSocio = new JComboBox<String>();
		chckbxCuponera = new JCheckBox("Cuponera");
		comboBoxCuponera = new JComboBox<String>();
		dateChooserRegistro = new JDateChooser();
		
		
		comboBoxCuponera.setEnabled(false);
		
		
		JLabel lblInformacinDeLa = new JLabel("Información de la clase:");
		JLabel lblProfesor_1 = new JLabel("Profesor");
		JLabel lblNewLabel = new JLabel("Fecha y hora de inicio");
		JLabel lblUrl = new JLabel("Url");
		JLabel lblSociosMinimos = new JLabel("Socios minimos");
		JLabel lblSociosMaximos = new JLabel("Socios maximos");
		
		textFieldProfesor = new JTextField();
		textFieldProfesor.setEditable(false);
		textFieldProfesor.setColumns(10);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setEditable(false);
		textFieldFecha.setColumns(10);
		
		textFieldUrl = new JTextField();
		textFieldUrl.setEditable(false);
		textFieldUrl.setColumns(10);
		
		textFieldMinimos = new JTextField();
		textFieldMinimos.setEditable(false);
		textFieldMinimos.setColumns(10);
		
		textFieldMaximos = new JTextField();
		textFieldMaximos.setEditable(false);
		textFieldMaximos.setColumns(10);
		
		
		
		
		//cuando se selecciona una institucion se cargan las actividades deportivas
		
		comboBoxInstituciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String insti = (String) comboBoxInstituciones.getSelectedItem();
				
				if (insti != null) {
					
					comboBoxActividadDeportiva.removeAllItems();
					Set<String> act = IAD.darNombresActividadesDeportivas(insti);
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
					Set<String> clases = IAD.mostrarClasesVigentesDeActividadDeportiva(act);
					
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
						chckbxCuponera.setSelected(false);
					} else {
						Set<String> cup = IU.mostrarCuponerasDisponibles((String)comboBoxSocio.getSelectedItem(),(String)comboBoxActividadDeportiva.getSelectedItem());
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
		
		// cuando se selecciona una clase, se muestra la info
		comboBoxClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Cnom = (String) comboBoxClase.getSelectedItem();
				if (Cnom == null) {
					
					textFieldProfesor.setText("");
					textFieldFecha.setText("");
					textFieldUrl.setText("");
					textFieldMinimos.setText("");
					textFieldMaximos.setText("");
					
				} else {
					
					DtClase res = IC.darDtClase(Cnom);
					textFieldProfesor.setText(res.getNomProfesor());
					textFieldUrl.setText(res.getUrl());
					textFieldMinimos.setText(Integer.toString(res.getMinSocios()));
					textFieldMaximos.setText(Integer.toString(res.getMaxSocios()));
					
					Calendar r = Calendar.getInstance();
					r.setTime(res.getFecha());
					
					String Fini = Integer.toString(r.get(Calendar.DATE)) + "/" + Integer.toString(r.get(Calendar.MONTH)+1) + "/" + Integer.toString(r.get(Calendar.YEAR)) + "  " +Integer.toString(res.getHora()) + ":" + Integer.toString(res.getMinuto());
					textFieldFecha.setText(Fini);
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
								
				limpiarFormulario();
				setVisible(false);
				
			}
		});
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean cup = chckbxCuponera.isSelected();
				String nick = (String)comboBoxSocio.getSelectedItem();
				String act = (String)comboBoxActividadDeportiva.getSelectedItem();
				String clas = (String)comboBoxClase.getSelectedItem();
				String nomCup = (String)comboBoxCuponera.getSelectedItem();
				Date fechaRg = dateChooserRegistro.getDate();
				
				if ((nick == null) || (act == null) || (clas == null) || (fechaRg == null) || ((cup) && (nomCup == null))) {
					JOptionPane.showMessageDialog(null, "Error, ningun campo puede quedar vacio");
				} else {
			
					try {
						IC.registrarSocioAClase(nick, act, clas, cup, nomCup, fechaRg);
						limpiarFormulario();
						setVisible(false);
						JOptionPane.showMessageDialog(null, "Registro exitoso");
					} catch (ClaseYaCompradaException e2) {
						JOptionPane.showMessageDialog(null, "Error, el socio ya posee esta clase");
					} catch (ClaseLlenaException e1) {
						JOptionPane.showMessageDialog(null, "Error, la calse está llena");
					}
				}
			}
		});
		
		
		
		
		
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblInstitucion)
								.addComponent(lblActividadDeportiva)
								.addComponent(lblProfesor))
							.addGap(21)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBoxClase, 0, 278, Short.MAX_VALUE)
								.addComponent(comboBoxActividadDeportiva, 0, 278, Short.MAX_VALUE)
								.addComponent(comboBoxInstituciones, 0, 278, Short.MAX_VALUE)
								.addComponent(dateChooserRegistro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxCuponera, 0, 278, Short.MAX_VALUE)
								.addComponent(comboBoxSocio, 0, 278, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textFieldProfesor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(29)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblSociosMinimos)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(3)
											.addComponent(lblSociosMaximos)))
									.addGap(6)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textFieldMaximos, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldMinimos, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(btnAceptar)
									.addGap(18)
									.addComponent(btnCancelar)))
							.addContainerGap(39, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblFechaDeRegistro)
							.addContainerGap(404, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(chckbxCuponera)
							.addContainerGap(435, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblSocioARegistrar)
							.addContainerGap(411, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblInformacinDeLa)
							.addContainerGap(361, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblProfesor_1)
							.addContainerGap(468, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblUrl))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldUrl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(249, Short.MAX_VALUE))))
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
					.addGap(33)
					.addComponent(lblInformacinDeLa)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProfesor_1)
						.addComponent(textFieldProfesor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSociosMinimos)
						.addComponent(textFieldMinimos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(textFieldFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUrl)
								.addComponent(textFieldUrl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSociosMaximos)
								.addComponent(textFieldMaximos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(64)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblSocioARegistrar)
						.addComponent(comboBoxSocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxCuponera)
						.addComponent(comboBoxCuponera, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblFechaDeRegistro)
						.addComponent(dateChooserRegistro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
						.addComponent(btnAceptar, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
					.addGap(30))
		);
		getContentPane().setLayout(groupLayout);

		
		
		
		
	}

	public void cargarFormulario() {
		
		//INSTITUCIONES
		Set<String> nombInst = IID.darNombreInstituciones();
		comboBoxInstituciones.removeAllItems();
		
		for( Iterator<String> it = nombInst.iterator(); it.hasNext();) { 
			    String x = (String)it.next();
			    comboBoxInstituciones.addItem(x);
		}
		comboBoxInstituciones.setSelectedItem(null);
		
		//SOCIOS
		Set<String> nomSoc = IU.mostrarNicknameSocios();
		comboBoxSocio.removeAllItems();
		
		for( Iterator<String> it = nomSoc.iterator(); it.hasNext();) { 
		    String x = (String)it.next();
		    comboBoxSocio.addItem(x);
		}
		comboBoxSocio.setSelectedItem(null);
		
	}

	public void limpiarFormulario() {
		comboBoxClase.removeAllItems();
		comboBoxActividadDeportiva.removeAllItems();
		comboBoxInstituciones.removeAllItems();
		
		comboBoxClase.setEnabled(false);
		comboBoxActividadDeportiva.setEnabled(false);
		
		dateChooserRegistro.setCalendar(null);
	}

}
