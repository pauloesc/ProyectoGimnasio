package presentacion;

import java.awt.EventQueue;
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

import excepciones.ClaseRepetidaException;

public class AltaDictadoDeClases extends JInternalFrame {
	private JTextField NombreClase;
	private JTextField Smin;
	private JTextField Smax;
	private JTextField url;
	private JComboBox<String> comboBoxInstituciones;
	private JComboBox<String> comboBoxProfesor;
	JComboBox<String> comboBoxActividadDeportiva;
	
	private IctrlADeportivas IAD;
	private IctrlIDeportivas IID;
	private IctrlUsuarios IU;

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
		Fabrica fab = Fabrica.getInstance();
		IAD = fab.getIctrlADeportivas();
		IID = fab.getIctrlIDeportivas();
		IU = fab.getIctrlUsuarios();
		
		JDateChooser dateChooserInicio = new JDateChooser();
		JDateChooser dateChooserAlta = new JDateChooser();
		dateChooserInicio.setEnabled(true);
		dateChooserAlta.setEnabled(true);
		
		
		setTitle("Alta dictado de clases");
		setBounds(100, 100, 499, 546);
		
		comboBoxInstituciones = new JComboBox();	
		comboBoxProfesor = new JComboBox();	
		comboBoxActividadDeportiva = new JComboBox();
		
		
		
		
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
		
		
		
		
		
		
		
		//botones aceptar y cancelar
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboBoxProfesor.removeAllItems();
				comboBoxActividadDeportiva.removeAllItems();
				comboBoxInstituciones.removeAllItems();
				
				comboBoxProfesor.setEnabled(false);
				comboBoxActividadDeportiva.setEnabled(false);
								
				NombreClase.setText("");
				Smin.setText("");
				Smax.setText("");
				url.setText("");
				
				dateChooserInicio.setCalendar(null);
				dateChooserAlta.setCalendar(null);
				
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
					Date Falta = dateChooserAlta.getDate();
					String nomAct = (String) comboBoxActividadDeportiva.getSelectedItem();
					
					//comprobar que todos los campos tengan algo
				
					if ((nom.isEmpty()) || (Finicio == null) || (prof == null) || (ur.isEmpty()) || (Falta == null) || (nomAct == null)){
						JOptionPane.showMessageDialog(null, "Error, ningun campo puede quedar vacio");
					} else {
						int min = Integer.parseInt(Smin.getText());
						int max = Integer.parseInt(Smax.getText());
						
						Fabrica fab = Fabrica.getInstance();
						IctrlClases ic = fab.getIctrlClases();
						
						ic.crearClase(nom, Finicio, prof, min, max, ur, Falta, nomAct);
						
						JOptionPane.showMessageDialog(null, "Clase creada con éxito");
					}
						
					
				} catch (ClaseRepetidaException ee) {
					JOptionPane.showMessageDialog(null, "Error, nombre de la clase existente");
				} catch(Exception ee) {
					JOptionPane.showMessageDialog(null, "Error, debe ingresar numeros en los campos 'socios maximos' y 'socios minimos' ");
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
									.addComponent(btnCancelar)))))
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
							.addComponent(dateChooserInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(dateChooserAlta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
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
		
		
	}
	
}
