package presentacion;

/**
 * JInternalFrame del caso de uso Alta Actividad Deportiva.
 * @author mbarrera
 *
 */

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Iterator;
import java.awt.Button;
import java.awt.TextArea;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Choice;
import java.awt.Color;

import com.toedter.calendar.JDateChooser;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Insets;
import javax.swing.JScrollBar;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

import logica.DtActividadesDeportivas;
import logica.DtClase;
import logica.Fabrica;
import logica.IctrlADeportivas;
import logica.IctrlClases;
import logica.IctrlCuponeras;
import logica.IctrlIDeportivas;
import logica.IctrlUsuarios;
import logica.InfoActividadProfe;
import logica.InfoActividadSocio;
import logica.InfoBasicaProfesor;
import logica.InfoBasicaSocio;
import logica.InfoBasicaUser;
import logica.InformacionActividad;
import excepciones.UsuarioDisponibilidadException;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import java.awt.event.*;
import java.awt.*;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;


@SuppressWarnings({ "serial", "unused" })
public class ModificarUsuario extends JInternalFrame{
		
    // Controlador de Deportivas que se utilizará para las acciones del JFrame
    private IctrlUsuarios controlUsuario;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtCorreo;
    private JComboBox<String> comboBoxNicks;
    private JTextField txtDescripcion;
    private JTextField txtBibliografia;
    private JTextField txtWeb;
    private JDateChooser dateChooserInicio;
    private JButton btnModificar;
    
    private boolean esProfesor=false;

    
	public ModificarUsuario(IctrlUsuarios icu)  {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				
				limpiarFormulario();
				setVisible(false);
				
				
			}
		});
		
		
		//esto es:
		//cuando se llama al a la ventana el programa principal le pasa el controlador
		controlUsuario = icu;
		
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setClosable(true);
		setTitle("Modificar usuario");
		setBounds(20, 50, 918, 663);
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {165, 220, 57, 0};
		gridBagLayout.rowHeights = new int[] {25, 0, 30, 0, 30, 0, 30, 0, 30, 0, 30, 0, 30, 0, 30, 0, 30, 0, 30, 0, 30, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNombre = new JLabel("Nickname");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		getContentPane().add(lblNombre, gbc_lblNombre);
		
		
		
		
		comboBoxNicks = new JComboBox<String>();
		comboBoxNicks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//antes de cargarle datos me aseguro que este en condiciones 
				limpiarFormulario();
		    	
				String nick = comboBoxNicks.getSelectedItem().toString();
			
				InfoBasicaUser i;
				i = controlUsuario.InformacionBasicaUsuario(nick);
				
				//cargo en la presentacion la info basica 
				txtNombre.setText( i.getNombre() )  ;
				txtApellido.setText( i.getApellido() );
				txtCorreo.setText( i.getCorreo() );
				dateChooserInicio.setDate( i.getFechaNac() );
						
				//si es socio
				if ( i.getClass()  == InfoBasicaSocio.class ) {
					
					esProfesor=false;
					
					txtBibliografia.setEnabled(false);
					txtBibliografia.setEditable(false);
					txtDescripcion.setEnabled(false);
					txtDescripcion.setEditable(false);
					txtWeb.setEnabled(false);
					txtWeb.setEditable(false);
					
				}
				//si es profe
				else {
					esProfesor=true;

					txtBibliografia.setEnabled(true);
					txtBibliografia.setEditable(true);
					txtDescripcion.setEnabled(true);
					txtDescripcion.setEditable(true);
					txtWeb.setEnabled(true);
					txtWeb.setEditable(true);
					
					InfoBasicaProfesor ee = (InfoBasicaProfesor) i ;
					//caro en la presentacion datos especificos del profesor
					txtBibliografia.setText( ee.getDesc() );
					txtDescripcion.setText( ee.getDesc() );
					txtWeb.setText( ee.getUrl() );
				}
					
			}
		});
		GridBagConstraints gbc_comboBoxNicks = new GridBagConstraints();
		gbc_comboBoxNicks.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxNicks.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxNicks.gridx = 1;
		gbc_comboBoxNicks.gridy = 1;
		getContentPane().add(comboBoxNicks, gbc_comboBoxNicks);
		
			
		JLabel lblNewLabel = new JLabel("Nombre");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.gridx = 1;
		gbc_txtNombre.gridy = 3;
		getContentPane().add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 0;
		gbc_lblApellido.gridy = 5;
		getContentPane().add(lblApellido, gbc_lblApellido);
		
		txtApellido = new JTextField();
		GridBagConstraints gbc_txtApellido = new GridBagConstraints();
		gbc_txtApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellido.insets = new Insets(0, 0, 5, 5);
		gbc_txtApellido.gridx = 1;
		gbc_txtApellido.gridy = 5;
		getContentPane().add(txtApellido, gbc_txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblCorreo = new JLabel("Correo");
		GridBagConstraints gbc_lblCorreo = new GridBagConstraints();
		gbc_lblCorreo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreo.gridx = 0;
		gbc_lblCorreo.gridy = 7;
		getContentPane().add(lblCorreo, gbc_lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setEditable(false);
		GridBagConstraints gbc_txtCorreo = new GridBagConstraints();
		gbc_txtCorreo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_txtCorreo.gridx = 1;
		gbc_txtCorreo.gridy = 7;
		getContentPane().add(txtCorreo, gbc_txtCorreo);
		txtCorreo.setColumns(10);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		GridBagConstraints gbc_lblFechaNacimiento = new GridBagConstraints();
		gbc_lblFechaNacimiento.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFechaNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaNacimiento.gridx = 0;
		gbc_lblFechaNacimiento.gridy = 9;
		getContentPane().add(lblFechaNacimiento, gbc_lblFechaNacimiento);
		
		dateChooserInicio = new JDateChooser();
		GridBagConstraints gbc_dateChooserInicio = new GridBagConstraints();
		gbc_dateChooserInicio.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateChooserInicio.insets = new Insets(0, 0, 5, 6);
		gbc_dateChooserInicio.gridx = 1;
		gbc_dateChooserInicio.gridy = 9;
		getContentPane().add(dateChooserInicio, gbc_dateChooserInicio);
		
		//DefaultListModel<String> modell = new DefaultListModel<String>();
		//modell.addElement("one");
		//list_1.setModel(modell);
		
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 0;
		gbc_lblDescripcion.gridy = 13;
		getContentPane().add(lblDescripcion, gbc_lblDescripcion);
		
		txtDescripcion = new JTextField();
		GridBagConstraints gbc_txtDescripcion = new GridBagConstraints();
		gbc_txtDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_txtDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDescripcion.gridx = 1;
		gbc_txtDescripcion.gridy = 13;
		getContentPane().add(txtDescripcion, gbc_txtDescripcion);
		txtDescripcion.setColumns(10);
		
		
		
		JLabel lblBiografia = new JLabel("Biografia");
		GridBagConstraints gbc_lblBiografia = new GridBagConstraints();
		gbc_lblBiografia.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblBiografia.insets = new Insets(0, 0, 5, 5);
		gbc_lblBiografia.gridx = 0;
		gbc_lblBiografia.gridy = 15;
		getContentPane().add(lblBiografia, gbc_lblBiografia);
		
		txtBibliografia = new JTextField();
		GridBagConstraints gbc_txtBibliografia = new GridBagConstraints();
		gbc_txtBibliografia.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBibliografia.insets = new Insets(0, 0, 5, 5);
		gbc_txtBibliografia.gridx = 1;
		gbc_txtBibliografia.gridy = 15;
		getContentPane().add(txtBibliografia, gbc_txtBibliografia);
		txtBibliografia.setColumns(10);
		
		JLabel lblWeburl = new JLabel("Web (url)");
		GridBagConstraints gbc_lblWeburl = new GridBagConstraints();
		gbc_lblWeburl.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblWeburl.insets = new Insets(0, 0, 5, 5);
		gbc_lblWeburl.gridx = 0;
		gbc_lblWeburl.gridy = 17;
		getContentPane().add(lblWeburl, gbc_lblWeburl);
		
		txtWeb = new JTextField();
		GridBagConstraints gbc_txtWeb = new GridBagConstraints();
		gbc_txtWeb.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtWeb.insets = new Insets(0, 0, 5, 5);
		gbc_txtWeb.gridx = 1;
		gbc_txtWeb.gridy = 17;
		getContentPane().add(txtWeb, gbc_txtWeb);
		txtWeb.setColumns(10);
		
		JButton btnCancelar = new JButton("Cerrar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
				setVisible(false);				
			}
		});
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InfoBasicaUser i;
				
				if (esProfesor) {
					i = new InfoBasicaProfesor(
							comboBoxNicks.getSelectedItem().toString(),
							txtNombre.getText(),
							txtApellido.getText(),
							txtCorreo.getText(),
							dateChooserInicio.getDate(),
							"",
							txtDescripcion.getText(),
							txtBibliografia.getText(),
							txtWeb.getText());
				}
				else {
					i = new InfoBasicaSocio(
							comboBoxNicks.getSelectedItem().toString(),
							txtNombre.getText(),
							txtApellido.getText(),
							txtCorreo.getText(),
							dateChooserInicio.getDate());
				}
				
				controlUsuario.ActualizarInformacionUsuario(i);
				
			}
		});
		GridBagConstraints gbc_btnModificar = new GridBagConstraints();
		gbc_btnModificar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnModificar.insets = new Insets(0, 0, 5, 5);
		gbc_btnModificar.gridx = 0;
		gbc_btnModificar.gridy = 20;
		getContentPane().add(btnModificar, gbc_btnModificar);
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 1;
		gbc_btnCancelar.gridy = 20;
		getContentPane().add(btnCancelar, gbc_btnCancelar);
		

		
	}
	
	// Permite validar la información introducida en los campos e indicar
    // a través de un mensaje de error (JOptionPane) cuando algo sucede.
    // Este tipo de chequeos se puede realizar de otras formas y con otras librerías de Java, 
    // por ejemplo impidiendo que se escriban caracteres no numéricos al momento de escribir en
    // en el campo de la cédula, o mostrando un mensaje de error apenas el foco pasa a otro campo.
    
    private void limpiarFormulario() {
    	txtNombre.setText("");
    	txtApellido.setText("");
    	txtCorreo.setText("");
    	dateChooserInicio.setCalendar(null);
    	txtDescripcion.setText("");
    	txtBibliografia.setText("");
    	txtWeb.setText("");
    }

    
    
    public void CargarDatos() {
    	
		Vector<String> vector;
		vector = controlUsuario.UsuariosEnSistemaNickName();
		DefaultComboBoxModel<String> model;
		model = new DefaultComboBoxModel<String>(vector);
		model.setSelectedItem(null);
		comboBoxNicks.setModel(model);
		
    }
    
}