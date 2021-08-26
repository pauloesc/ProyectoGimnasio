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
import java.awt.Button;
import java.awt.TextArea;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
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

import logica.IctrlUsuarios;
import datatypes.InfoBasicaUser;
import datatypes.InfoActividadProfe;
import datatypes.InfoActividadSocio;
import datatypes.InfoBasicaProfesor;
import datatypes.InfoBasicaSocio;
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

import datatypes.InformacionActividad;


@SuppressWarnings({ "serial", "unused" })
public class ConsultaUsuario extends JInternalFrame{
	
    // Controlador de Deportivas que se utilizará para las acciones del JFrame
    private IctrlUsuarios controlUsuario;
    
    
    private JTextField txtInstitucion;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtCorreo;
    private JComboBox<String> comboBoxNicks;
    private JTextField txtDescripcion;
    private JTextField txtBibliografia;
    private JTextField txtWeb;
    private JDateChooser dateChooserInicio;
    
    private JList<String> list;
    private JList<String> list_1;

    
	public ConsultaUsuario(IctrlUsuarios icu)  {
		
		//esto es:
		//cuando se llama al a la ventana el programa principal le pasa el controlador
		controlUsuario = icu;
		
		setTitle("Consulta de usuario");
		setClosable(true);
		setBounds(20, 50, 764, 663);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 165, 160, 57, 246, 0};
		gridBagLayout.rowHeights = new int[] {25, 0, 30, 0, 30, 0, 30, 0, 30, 0, 30, 0, 30, 0, 30, 0, 30, 0, 30, 0, 30, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNombre = new JLabel("Nickname");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 1;
		getContentPane().add(lblNombre, gbc_lblNombre);
		
		
		
		
		comboBoxNicks = new JComboBox<String>();
		comboBoxNicks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("se activo el combobox");

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
				}
				//si es profe
				else {
					//casteo
					InfoBasicaProfesor ee = (InfoBasicaProfesor) i ;
					
					//caro en la presentacion datos especificos del profesor
					txtInstitucion.setText( ee.getInstitucion() );
					txtBibliografia.setText( ee.getDesc() );
					txtDescripcion.setText( ee.getDesc() );
					txtWeb.setText( ee.getUrl() );
				}
				
				InformacionActividad infoActividad = null; 
				infoActividad = controlUsuario.InformacionActividad(nick);
				
				if( infoActividad.getClass() == InfoActividadSocio.class ) {
					
					
					
				}
				//si es InfoActividadProfesor
				else {
				
				}
				
			}
		});
		GridBagConstraints gbc_comboBoxNicks = new GridBagConstraints();
		gbc_comboBoxNicks.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxNicks.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxNicks.gridx = 2;
		gbc_comboBoxNicks.gridy = 1;
		getContentPane().add(comboBoxNicks, gbc_comboBoxNicks);
		
		JLabel lblActividadesDeportivas = new JLabel("Actividades Deportivas");
		GridBagConstraints gbc_lblActividadesDeportivas = new GridBagConstraints();
		gbc_lblActividadesDeportivas.insets = new Insets(0, 0, 5, 5);
		gbc_lblActividadesDeportivas.gridx = 4;
		gbc_lblActividadesDeportivas.gridy = 1;
		getContentPane().add(lblActividadesDeportivas, gbc_lblActividadesDeportivas);
		

		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 4;
		gbc_scrollPane.gridy = 2;
		gbc_scrollPane.gridheight=6;
		getContentPane().add(scrollPane, gbc_scrollPane);
		
		
		
		list = new JList<String>();
		scrollPane.setViewportView(list);
		
		DefaultListModel<String> model = new DefaultListModel<String>();
		model.addElement("one");
		model.addElement("two");
		model.addElement("three");
		model.addElement("one");
		model.addElement("two");
		model.addElement("three");
		model.addElement("one");
		model.addElement("two");
		model.addElement("three");
		model.addElement("one");
		model.addElement("two");
		model.addElement("three");
		model.addElement("one");
		model.addElement("two");
		model.addElement("three");
		model.addElement("one");
		model.addElement("two");
		model.addElement("three");
		model.addElement("one");
		model.addElement("two");
		model.addElement("three");
		
		list.setModel(model);
			
		JLabel lblNewLabel = new JLabel("Nombre");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 3;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 3;
		getContentPane().add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.anchor = GridBagConstraints.WEST;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 1;
		gbc_lblApellido.gridy = 5;
		getContentPane().add(lblApellido, gbc_lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setEditable(false);
		GridBagConstraints gbc_txtApellido = new GridBagConstraints();
		gbc_txtApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellido.insets = new Insets(0, 0, 5, 5);
		gbc_txtApellido.gridx = 2;
		gbc_txtApellido.gridy = 5;
		getContentPane().add(txtApellido, gbc_txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblCorreo = new JLabel("Correo");
		GridBagConstraints gbc_lblCorreo = new GridBagConstraints();
		gbc_lblCorreo.anchor = GridBagConstraints.WEST;
		gbc_lblCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreo.gridx = 1;
		gbc_lblCorreo.gridy = 7;
		getContentPane().add(lblCorreo, gbc_lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setEditable(false);
		GridBagConstraints gbc_txtCorreo = new GridBagConstraints();
		gbc_txtCorreo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_txtCorreo.gridx = 2;
		gbc_txtCorreo.gridy = 7;
		getContentPane().add(txtCorreo, gbc_txtCorreo);
		txtCorreo.setColumns(10);
		
		JButton btnConsultarActividad = new JButton("Consultar");
		btnConsultarActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String selected = list.getSelectedValue();
				System.out.println(selected);
				
			}
		});
		GridBagConstraints gbc_btnConsultarActividad = new GridBagConstraints();
		gbc_btnConsultarActividad.anchor = GridBagConstraints.EAST;
		gbc_btnConsultarActividad.insets = new Insets(0, 0, 5, 5);
		gbc_btnConsultarActividad.gridx = 4;
		gbc_btnConsultarActividad.gridy = 8;
		getContentPane().add(btnConsultarActividad, gbc_btnConsultarActividad);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		GridBagConstraints gbc_lblFechaNacimiento = new GridBagConstraints();
		gbc_lblFechaNacimiento.anchor = GridBagConstraints.WEST;
		gbc_lblFechaNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaNacimiento.gridx = 1;
		gbc_lblFechaNacimiento.gridy = 9;
		getContentPane().add(lblFechaNacimiento, gbc_lblFechaNacimiento);
		
		dateChooserInicio = new JDateChooser();
		GridBagConstraints gbc_dateChooserInicio = new GridBagConstraints();
		gbc_dateChooserInicio.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateChooserInicio.insets = new Insets(0, 0, 5, 6);
		gbc_dateChooserInicio.gridx = 2;
		gbc_dateChooserInicio.gridy = 9;
		getContentPane().add(dateChooserInicio, gbc_dateChooserInicio);
		
		JLabel lblClases = new JLabel("Clases");
		GridBagConstraints gbc_lblClases = new GridBagConstraints();
		gbc_lblClases.insets = new Insets(0, 0, 5, 5);
		gbc_lblClases.gridx = 4;
		gbc_lblClases.gridy = 10;
		getContentPane().add(lblClases, gbc_lblClases);
		
		JLabel lblInstitucion = new JLabel("Institucion");
		GridBagConstraints gbc_lblInstitucion = new GridBagConstraints();
		gbc_lblInstitucion.anchor = GridBagConstraints.WEST;
		gbc_lblInstitucion.insets = new Insets(0, 0, 5, 5);
		gbc_lblInstitucion.gridx = 1;
		gbc_lblInstitucion.gridy = 11;
		getContentPane().add(lblInstitucion, gbc_lblInstitucion);
		
		txtInstitucion = new JTextField();
		txtInstitucion.setEditable(false);
		GridBagConstraints gbc_txtInstitucion = new GridBagConstraints();
		gbc_txtInstitucion.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtInstitucion.insets = new Insets(0, 0, 5, 5);
		gbc_txtInstitucion.gridx = 2;
		gbc_txtInstitucion.gridy = 11;
		getContentPane().add(txtInstitucion, gbc_txtInstitucion);
		txtInstitucion.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 4;
		gbc_scrollPane_1.gridy = 11;
		gbc_scrollPane_1.gridheight = 6;
		getContentPane().add(scrollPane_1, gbc_scrollPane_1);
		
		list_1 = new JList<String>();
		scrollPane_1.setViewportView(list_1);
		
		DefaultListModel<String> modell = new DefaultListModel<String>();
		modell.addElement("one");
		modell.addElement("two");
		modell.addElement("three");
		modell.addElement("one");
		modell.addElement("two");
		modell.addElement("three");
		modell.addElement("one");
		modell.addElement("two");
		modell.addElement("three");
		modell.addElement("one");
		modell.addElement("two");
		modell.addElement("three");
		modell.addElement("one");
		modell.addElement("two");
		modell.addElement("three");
		modell.addElement("one");
		modell.addElement("two");
		modell.addElement("three");
		modell.addElement("one");
		modell.addElement("two");
		modell.addElement("three");
		
		list_1.setModel(modell);
		
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.anchor = GridBagConstraints.WEST;
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 1;
		gbc_lblDescripcion.gridy = 13;
		getContentPane().add(lblDescripcion, gbc_lblDescripcion);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setEditable(false);
		GridBagConstraints gbc_txtDescripcion = new GridBagConstraints();
		gbc_txtDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_txtDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDescripcion.gridx = 2;
		gbc_txtDescripcion.gridy = 13;
		getContentPane().add(txtDescripcion, gbc_txtDescripcion);
		txtDescripcion.setColumns(10);
		
		
		
		JLabel lblBiografia = new JLabel("Biografia");
		GridBagConstraints gbc_lblBiografia = new GridBagConstraints();
		gbc_lblBiografia.anchor = GridBagConstraints.WEST;
		gbc_lblBiografia.insets = new Insets(0, 0, 5, 5);
		gbc_lblBiografia.gridx = 1;
		gbc_lblBiografia.gridy = 15;
		getContentPane().add(lblBiografia, gbc_lblBiografia);
		
		txtBibliografia = new JTextField();
		txtBibliografia.setEditable(false);
		GridBagConstraints gbc_txtBibliografia = new GridBagConstraints();
		gbc_txtBibliografia.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBibliografia.insets = new Insets(0, 0, 5, 5);
		gbc_txtBibliografia.gridx = 2;
		gbc_txtBibliografia.gridy = 15;
		getContentPane().add(txtBibliografia, gbc_txtBibliografia);
		txtBibliografia.setColumns(10);
		
		JLabel lblWeburl = new JLabel("Web (url)");
		GridBagConstraints gbc_lblWeburl = new GridBagConstraints();
		gbc_lblWeburl.anchor = GridBagConstraints.WEST;
		gbc_lblWeburl.insets = new Insets(0, 0, 5, 5);
		gbc_lblWeburl.gridx = 1;
		gbc_lblWeburl.gridy = 17;
		getContentPane().add(lblWeburl, gbc_lblWeburl);
		
		txtWeb = new JTextField();
		txtWeb.setEditable(false);
		GridBagConstraints gbc_txtWeb = new GridBagConstraints();
		gbc_txtWeb.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtWeb.insets = new Insets(0, 0, 5, 5);
		gbc_txtWeb.gridx = 2;
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
		
		JButton btnConsultarClases = new JButton("Consultar");
		GridBagConstraints gbc_btnConsultarClases = new GridBagConstraints();
		gbc_btnConsultarClases.anchor = GridBagConstraints.EAST;
		gbc_btnConsultarClases.insets = new Insets(0, 0, 5, 5);
		gbc_btnConsultarClases.gridx = 4;
		gbc_btnConsultarClases.gridy = 17;
		getContentPane().add(btnConsultarClases, gbc_btnConsultarClases);
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 2;
		gbc_btnCancelar.gridy = 21;
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
    	txtInstitucion.setText("");
    	txtDescripcion.setText("");
    	txtBibliografia.setText("");
    	txtWeb.setText("");
    }

    
    
    public void CargarDatos() {
    	
		Vector<String> vector;
		vector = controlUsuario.UsuariosEnSistemaNickName();
		DefaultComboBoxModel<String> model;
		model = new DefaultComboBoxModel<String>(vector);
		comboBoxNicks.setModel(model);
		
		//comboBoxNicks.setSelectedIndex(-1);
    }
}