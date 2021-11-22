package src.presentacion;

import java.awt.EventQueue;
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

import src.logica.*;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import src.excepciones.ClaseRepetidaException;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.JFrame;

public class AltaDictadoDeClases extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField NombreClase;
	private JTextField Smin;
	private JTextField Smax;
	private JTextField url;
	private JTextField urlvid;
	private JComboBox<String> comboBoxInstituciones;
	private JComboBox<String> comboBoxProfesor;
	JComboBox<String> comboBoxActividadDeportiva;
	JDateChooser dateChooserInicio;
	JDateChooser dateChooserAlta;
	
	private IctrlADeportivas IAD;
	private IctrlIDeportivas IID;
	private IctrlUsuarios IU;
	private JComboBox<String> textFieldHora;
	private JComboBox<String> textFieldMinuto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaDictadoDeClases frame = new AltaDictadoDeClases();
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
	
	
	
	public AltaDictadoDeClases() {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				setVisible(false);
				limpiarFormulario();
			}
		});
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		
		
		setClosable(true);
		
		setTitle("Alta dictado de clases");
		setBounds(100, 100, 499, 546);
		
		Fabrica fab = Fabrica.getInstance();
		IAD = fab.getIctrlADeportivas();
		IID = fab.getIctrlIDeportivas();
		IU = fab.getIctrlUsuarios();
		
		dateChooserInicio = new JDateChooser();
		dateChooserAlta = new JDateChooser();
		dateChooserInicio.setEnabled(true);
		dateChooserAlta.setEnabled(true);
		
		
		
		
		comboBoxInstituciones = new JComboBox<String>();	
		comboBoxProfesor = new JComboBox<String>();	
		comboBoxActividadDeportiva = new JComboBox<String>();
		
		JLabel lblHora = new JLabel("Hora");
		
		JLabel lblMinuto = new JLabel("Minuto");
		
		textFieldHora =  new JComboBox<String>();
		
		textFieldMinuto =  new JComboBox<String>();
		
		for (Integer i = 0; i<= 23; i++) {
			textFieldHora.addItem(i.toString());
		}
		
		for (Integer i = 0; i<= 59; i++) {
			textFieldMinuto.addItem(i.toString());
		}
		
		
		//cuando se selecciona una institucion se cargan las actividades deportivas y los profesores
		
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
					
					comboBoxProfesor.removeAllItems();
					Set<String> profes = IU.mostrarNombreProfesoresDeInstitucion(insti);
					for( Iterator<String> itt = profes.iterator(); itt.hasNext();) { 
					    String x = (String)itt.next();
					    comboBoxProfesor.addItem(x);

					}
					
					comboBoxActividadDeportiva.setEnabled(true);
					comboBoxProfesor.setEnabled(true);
					comboBoxActividadDeportiva.setSelectedItem(null);
					comboBoxProfesor.setSelectedItem(null);
				}
				
			}
		});
		
		
		
		JLabel lblActividadDeportiva = new JLabel("Actividad deportiva");
		
		JLabel lblInstitucion = new JLabel("Institucion deportiva");
		
		JLabel lblProfesor = new JLabel("Profesor");
		
		JLabel lblNombreDeLa = new JLabel("Nombre de la clase");
		
		
		JLabel lblSociosMinimos = new JLabel("Socios minimos");
		
		JLabel lblSociosMaximos = new JLabel("Socios maximos");
		
		JLabel lblUrl = new JLabel("url");
		
		JLabel lblUrlVid = new JLabel("url video");
		
		JLabel lblFechaDeInicio = new JLabel("Fecha de inicio");
		
		JLabel lblFechaDeAlta = new JLabel("Fecha de alta");
		
		NombreClase = new JTextField();
		NombreClase.setColumns(10);
		
		Smin = new JTextField();
		Smin.setColumns(10);
		
		Smax = new JTextField();
		Smax.setColumns(10);
		
		url = new JTextField();
		url.setColumns(10);
		
		urlvid = new JTextField();
		urlvid.setColumns(10);
		
		
		
		
		
		
		
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
				try {
					String nom = NombreClase.getText();
					Date Finicio = dateChooserInicio.getDate();
					String prof = (String) comboBoxProfesor.getSelectedItem();
					String ur = url.getText();
					String urv = urlvid.getText();
					Date Falta = dateChooserAlta.getDate();
					String nomAct = (String) comboBoxActividadDeportiva.getSelectedItem();
					
					Integer min = Integer.parseInt(Smin.getText());
					Integer max = Integer.parseInt(Smax.getText());
					Integer ho = Integer.parseInt((String) textFieldHora.getSelectedItem());
					Integer mi = Integer.parseInt((String) textFieldMinuto.getSelectedItem());
					
					//comprobar que todos los campos tengan algo
				
					if ((nom.isEmpty()) || (Finicio == null) || (prof == null) || (ur.isEmpty()) || (Falta == null) || (nomAct == null) || (min == null) || (max == null) || (ho == null) || (mi == null)){
						JOptionPane.showMessageDialog(null, "Error, ningun campo puede quedar vacio");
					} else {
						
						if ((ho < 0) || (ho >= 24) || (mi < 0) || (mi >= 60)) {
							JOptionPane.showMessageDialog(null, "Error, ponga bien la hora");
						
						} else if(min > max) {
							JOptionPane.showMessageDialog(null, "Error, socios minimos mayor que socios maximos");
						}else if (Finicio.before(Falta)) {
							JOptionPane.showMessageDialog(null, "Error, fecha de inicio anterior a fecha de alta");
						} else {
							Fabrica fab = Fabrica.getInstance();
							IctrlClases ic = fab.getIctrlClases();
								
							ic.crearClase(nom, Finicio, prof, min, max, ur, urv, Falta, nomAct, ho, mi, "","",0);
							
							limpiarFormulario();
							setVisible(false);
							JOptionPane.showMessageDialog(null, "Clase creada con éxito");
							
						}
					}
						
					
				} catch (ClaseRepetidaException ee) {
					JOptionPane.showMessageDialog(null, "Error, nombre de la clase existente");
				} catch(Exception ee) {
					JOptionPane.showMessageDialog(null, "Error, ingrese numeros donde corresponde ");
				}
			}
		});
		
		
		
		
		
		
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
								.addComponent(lblNombreDeLa)
								.addComponent(lblProfesor)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblSociosMinimos)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblUrl)
										.addComponent(lblSociosMaximos)
										.addComponent(lblFechaDeInicio)
										.addComponent(lblFechaDeAlta))))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(comboBoxProfesor, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(comboBoxActividadDeportiva, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(comboBoxInstituciones, 0, 262, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(dateChooserInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAceptar)
								.addComponent(dateChooserAlta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(Smin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(NombreClase, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
										.addComponent(Smax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(url)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(43)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnCancelar)
										.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblMinuto)
												.addComponent(lblHora))
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(textFieldHora, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
												.addComponent(textFieldMinuto, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
											.addGap(40)))))
							.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
						.addComponent(comboBoxProfesor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblProfesor))
					.addGap(57)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreDeLa)
						.addComponent(NombreClase, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSociosMinimos)
						.addComponent(Smin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSociosMaximos)
						.addComponent(Smax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUrl)
						.addComponent(url, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblFechaDeInicio)
							.addGap(18)
							.addComponent(lblFechaDeAlta))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblHora)
									.addComponent(textFieldHora, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(dateChooserInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(dateChooserAlta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblMinuto)
									.addComponent(textFieldMinuto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAceptar)
						.addComponent(btnCancelar))
					.addGap(38))
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
		comboBoxProfesor.removeAllItems();
		comboBoxActividadDeportiva.removeAllItems();
		comboBoxInstituciones.removeAllItems();
		
		comboBoxProfesor.setEnabled(false);
		comboBoxActividadDeportiva.setEnabled(false);
						
		NombreClase.setText("");
		Smin.setText("");
		Smax.setText("");
		url.setText("");
		urlvid.setText("");
		
		textFieldHora.setSelectedItem(null);
		textFieldMinuto.setSelectedItem(null);
		
		dateChooserInicio.setCalendar(null);
		dateChooserAlta.setCalendar(null);
		
	}
	
}
