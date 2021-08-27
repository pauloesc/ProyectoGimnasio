package presentacion;

import java.awt.EventQueue;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

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
import logica.IctrlADeportivas;
import logica.IctrlClases;
import logica.IctrlIDeportivas;
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
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class ConsultaDictadoDeClases extends JInternalFrame {
	private JTextField NombreClase;
	private JTextField Smin;
	private JTextField Smax;
	private JTextField url;
	private JComboBox<String> comboBoxInstituciones;
	private JComboBox<String> comboBoxClase;
	JComboBox<String> comboBoxActividadDeportiva;
	
	private IctrlADeportivas IAD;
	private IctrlIDeportivas IID;
	private IctrlUsuarios IU;
	private IctrlClases IC;
	private JTextField Sactuales;
	private JTextField nomProfesor;
	private JTextField Finicio;
	private JTextField Falta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaDictadoDeClases frame = new ConsultaDictadoDeClases();
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
	
	
	
	public ConsultaDictadoDeClases() {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosed(InternalFrameEvent e) {
				limpiarFormulario();
				setVisible(false);
			}
		});
		setClosable(true);
		Fabrica fab = Fabrica.getInstance();
		IAD = fab.getIctrlADeportivas();
		IID = fab.getIctrlIDeportivas();
		IU = fab.getIctrlUsuarios();
		IC = fab.getIctrlClases();
		
		
		setTitle("Consulta de dictado de clases");
		setBounds(120, 50, 518, 563);
		
		comboBoxInstituciones = new JComboBox();	
		comboBoxClase = new JComboBox();	
		comboBoxActividadDeportiva = new JComboBox();
		
		
		
		
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
		
		
		// cuando se carga la actividad deportiva se cargan las clases
		comboBoxActividadDeportiva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String act = (String)comboBoxActividadDeportiva.getSelectedItem();
				if (act != null) {
					
					comboBoxClase.removeAllItems();
					Set<String> clases = IC.mostrarClasesDeActividadDeportiva(act);
					
					for( Iterator<String> itt = clases.iterator(); itt.hasNext();) { 
					    String x = (String)itt.next();
					    comboBoxClase.addItem(x);
	
					}
					
					comboBoxClase.setEnabled(true);
					comboBoxClase.setSelectedItem(null);
				}
			}
		});
		
		
		
		
		JLabel lblActividadDeportiva = new JLabel("Actividad deportiva");
		
		JLabel lblInstitucion = new JLabel("Institucion deportiva");
		
		JLabel lblProfesor = new JLabel("Clase");
		
		JLabel lblNombreDeLa = new JLabel("Nombre de la clase");
		
		
		JLabel lblSociosMinimos = new JLabel("Socios minimos");
		
		JLabel lblSociosMaximos = new JLabel("Socios maximos");
		
		JLabel lblUrl = new JLabel("url");
		
		JLabel lblFechaDeInicio = new JLabel("Fecha de inicio");
		
		JLabel lblFechaDeAlta = new JLabel("Fecha de alta");
		
		NombreClase = new JTextField();
		NombreClase.setEditable(false);
		NombreClase.setColumns(10);
		
		Smin = new JTextField();
		Smin.setEditable(false);
		Smin.setColumns(10);
		
		Smax = new JTextField();
		Smax.setEditable(false);
		Smax.setColumns(10);
		
		url = new JTextField();
		url.setEditable(false);
		url.setColumns(10);
		
		
		
		
		
		
		
		//botones aceptar y cancelar
		
		
		JButton btnCancelar = new JButton("Salir");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				limpiarFormulario();
				setVisible(false);
				
			}
		});
		
		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					String clas = (String) comboBoxClase.getSelectedItem();
					String nomAct = (String) comboBoxActividadDeportiva.getSelectedItem();
					String inst = (String) comboBoxInstituciones.getSelectedItem();
					
					//comprobar que todos los campos tengan algo
				
					if ((clas == null) || (nomAct == null) || (inst == null)){
						JOptionPane.showMessageDialog(null, "Error, ningun campo puede quedar vacio");
					} else {
					
						DtClase res = IC.darDtClase(clas);
						
						NombreClase.setText(res.getNombre());
						nomProfesor.setText(res.getNomProfesor());
						Smin.setText(Integer.toString(res.getMinSocios()));
						Sactuales.setText(Integer.toString(res.getActualSocios()));
						Smax.setText(Integer.toString(res.getMaxSocios()));
						url.setText(res.getUrl());
						
						// mostrar las fechas, por alguna razon andan mal las operaciones de Date
						//String ini = Integer.toString(res.getFecha().getDay()) + "/" + Integer.toString(res.getFecha().getMonth()) + "/" + Integer.toString(res.getFecha().getYear());
						//String reg = Integer.toString(res.getFechaReg().getDay()) + "/" + Integer.toString(res.getFechaReg().getMonth()) + "/" + Integer.toString(res.getFechaReg().getYear());
						
						Calendar c = Calendar.getInstance();
						c.setTime(res.getFecha());
						
						Calendar r = Calendar.getInstance();
						r.setTime(res.getFechaReg());
						
						String ini = Integer.toString(c.get(Calendar.DATE)) + "/" + Integer.toString(c.get(Calendar.MONTH)+1) + "/" + Integer.toString(c.get(Calendar.YEAR)) + "  " +Integer.toString(res.getHora()) + ":" + Integer.toString(res.getMinuto());
						String reg = Integer.toString(r.get(Calendar.DATE)) + "/" + Integer.toString(r.get(Calendar.MONTH)+1) + "/" + Integer.toString(r.get(Calendar.YEAR));
						
					
						
						Finicio.setText(ini);
						Falta.setText(reg);
					}
						
		
				} catch(Exception ee) {
					// no puede caer nunca aca, por ahora
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		
		JLabel lblSociosActuales = new JLabel("Socios actuales");
		
		Sactuales = new JTextField();
		Sactuales.setEditable(false);
		Sactuales.setColumns(10);
		
		JLabel lblNombreDelProfesor = new JLabel("Nombre del profesor");
		
		nomProfesor = new JTextField();
		nomProfesor.setEditable(false);
		nomProfesor.setColumns(10);
		
		Finicio = new JTextField();
		Finicio.setEditable(false);
		Finicio.setColumns(10);
		
		Falta = new JTextField();
		Falta.setEditable(false);
		Falta.setColumns(10);
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblInstitucion))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addComponent(lblActividadDeportiva))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblProfesor)
								.addComponent(lblFechaDeInicio)
								.addComponent(lblUrl)
								.addComponent(lblSociosMaximos)
								.addComponent(lblSociosActuales)
								.addComponent(lblSociosMinimos)
								.addComponent(lblNombreDelProfesor)
								.addComponent(lblNombreDeLa)
								.addComponent(lblFechaDeAlta))))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(Falta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(comboBoxClase, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(comboBoxActividadDeportiva, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(comboBoxInstituciones, 0, 262, Short.MAX_VALUE)
									.addComponent(btnBuscar))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(url, Alignment.LEADING)
									.addComponent(Smax, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(Sactuales, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(Smin, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(NombreClase, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
									.addComponent(nomProfesor, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
										.addGap(17)))))
						.addComponent(Finicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(54, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblInstitucion)
						.addComponent(comboBoxInstituciones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(comboBoxActividadDeportiva, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblActividadDeportiva))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(comboBoxClase, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblProfesor))
					.addGap(18)
					.addComponent(btnBuscar)
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNombreDeLa)
						.addComponent(NombreClase, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreDelProfesor)
						.addComponent(nomProfesor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblSociosMinimos)
						.addComponent(Smin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblSociosActuales)
						.addComponent(Sactuales, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblSociosMaximos)
						.addComponent(Smax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblUrl)
						.addComponent(url, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblFechaDeInicio)
						.addComponent(Finicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(16)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFechaDeAlta)
								.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(Falta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(14))
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
		
		
	}

	public void limpiarFormulario() {
		comboBoxClase.removeAllItems();
		comboBoxActividadDeportiva.removeAllItems();
		comboBoxInstituciones.removeAllItems();
		
		comboBoxClase.setEnabled(false);
		comboBoxActividadDeportiva.setEnabled(false);
						
		NombreClase.setText("");
		nomProfesor.setText("");
		Smin.setText("");
		Sactuales.setText("");
		Smax.setText("");
		url.setText("");
		Finicio.setText("");
		Falta.setText("");
	}
	
}
