package presentacion;

import java.awt.EventQueue;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import logica.Fabrica;
import logica.IctrlClases;
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

import excepciones.ClaseRepetidaException;

public class AltaDictadoDeClases extends JInternalFrame {
	private JTextField NombreClase;
	private JTextField Smin;
	private JTextField Smax;
	private JTextField url;
	private IctrlDeportivas ID;
	private IctrlUsuarios IU;
	private boolean buscado; //para no repetir la busqueda de instituciones muchas veces

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
		ID = fab.getIctrlDeportivas();
		IU = fab.getIctrlUsuarios();
		
		
		this.buscado = false; 
		
		setTitle("Alta dictado de clases");
		setBounds(100, 100, 499, 546);
		
		JComboBox<String> comboBoxInstituciones = new JComboBox();	
		comboBoxInstituciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (!buscado) {
					Set<String> nombInst = ID.darNombreInstituciones();
					
					comboBoxInstituciones.removeAllItems();
					
					for( Iterator<String> it = nombInst.iterator(); it.hasNext();) { 
						    String x = (String)it.next();
						    comboBoxInstituciones.addItem(x);
					}
					
						    
				}
				buscado = true;
			}
			
			
		});
		
		JComboBox<String> comboBoxProfesor = new JComboBox();	
		JComboBox<String> comboBoxActividadDeportiva = new JComboBox();
		comboBoxProfesor.setEnabled(false);
		comboBoxActividadDeportiva.setEnabled(false);
		
		

		
		
		 
		comboBoxActividadDeportiva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String act = (String) comboBoxActividadDeportiva.getSelectedItem();
				
				if (act != null) {
					
						Set<String> profes = IU.mostrarNombreProfesoresDeInstitucion((String)comboBoxInstituciones.getSelectedItem());
						for( Iterator<String> it = profes.iterator(); it.hasNext();) { 
						    String x = (String)it.next();
						    comboBoxProfesor.addItem(x);
	
						}
						
						comboBoxProfesor.setEnabled(true);
					
				}
			}
		});
		
		
		
		
		comboBoxInstituciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String insti = (String) comboBoxInstituciones.getSelectedItem();
				
				if (insti != null) {
					
					Set<String> act = ID.darNombresActividadesDeportivas(insti);
					for( Iterator<String> it = act.iterator(); it.hasNext();) { 
					    String x = (String)it.next();
					    comboBoxActividadDeportiva.addItem(x);

					}
					
					comboBoxActividadDeportiva.setEnabled(true);
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
		NombreClase.setEditable(false);
		
		Smin = new JTextField();
		Smin.setColumns(10);
		Smin.setEditable(false);
		
		Smax = new JTextField();
		Smax.setColumns(10);
		Smax.setEditable(false);
		
		url = new JTextField();
		url.setColumns(10);
		url.setEditable(false);
		
		
		
		comboBoxProfesor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxProfesor.getSelectedItem() != null) {
					NombreClase.setEditable(true);
					Smin.setEditable(true);
					Smax.setEditable(true);
					url.setEditable(true);
				}
			}
		});
		
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboBoxProfesor.removeAllItems();
				comboBoxActividadDeportiva.removeAllItems();
				comboBoxInstituciones.removeAllItems();
				
				comboBoxProfesor.setEnabled(false);
				comboBoxActividadDeportiva.setEnabled(false);
				
				buscado = false;
				
				NombreClase.setEditable(false);
				Smin.setEditable(false);
				Smax.setEditable(false);
				url.setEditable(false);
				
				setVisible(false);
				
			}
		});
		
		JDateChooser dateChooserInicio = new JDateChooser();
		
		JDateChooser dateChooserAlta = new JDateChooser();
		
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
					if (nom.isEmpty() || (Finicio == null) || prof.isEmpty() || ur.isEmpty() || (Falta == null) || nomAct.isEmpty()){
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
		
		
		
		dateChooserInicio.setEnabled(false);
		dateChooserAlta.setEnabled(false);
		
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
}
