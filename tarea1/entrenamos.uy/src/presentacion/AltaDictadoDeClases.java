package presentacion;

import java.awt.EventQueue;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import logica.Fabrica;
import logica.IctrlDeportivas;

import javax.swing.JTextField;

public class AltaDictadoDeClases extends JInternalFrame {
	private JTextField NombreClase;
	private JTextField Smin;
	private JTextField Smax;
	private JTextField url;

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
		setTitle("Alta dictado de clases");
		setBounds(100, 100, 498, 501);
		
		JComboBox<String> comboBoxInstituciones = new JComboBox();
		
		JLabel lblInstitucion = new JLabel("Institucion deportiva");
		
		JComboBox<String> comboBoxActividadDeportiva = new JComboBox();
		comboBoxActividadDeportiva.setEnabled(false);
		
		JLabel lblActividadDeportiva = new JLabel("Actividad deportiva");
		
		JComboBox<String> comboBoxProfesor = new JComboBox();
		comboBoxProfesor.setEnabled(false);
		
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
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(comboBoxProfesor, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(comboBoxActividadDeportiva, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(comboBoxInstituciones, 0, 262, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(57)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(Smin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(NombreClase, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
								.addComponent(Smax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(url))))
					.addContainerGap(45, Short.MAX_VALUE))
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
					.addComponent(lblFechaDeInicio)
					.addGap(18)
					.addComponent(lblFechaDeAlta)
					.addContainerGap(86, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

		Fabrica fab = Fabrica.getInstance();
		IctrlDeportivas ID = fab.getIctrlDeportivas();
		
		Set<String> nombInst = ID.darNombreInstituciones();
		
		 for( Iterator<String> it = nombInst.iterator(); it.hasNext();) { 
			    String x = (String)it.next();
			    comboBoxInstituciones.addItem(x);

			}
		
	}
}
