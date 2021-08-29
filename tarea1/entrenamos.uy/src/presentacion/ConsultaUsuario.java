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
import excepciones.ActividadDeportivaNoExisteException;
import excepciones.InstitucionDeportivaNoExisteException;
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
    private JButton btnConsultarActividad;
    
    private JList<DtActividadesDeportivas> list;
    private JList<DtClase> list_1;

    
	public ConsultaUsuario(IctrlUsuarios icu)  {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				
				limpiarFormulario();
				LimpiarListas();
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
		setTitle("Consulta de usuario");
		setBounds(20, 50, 918, 663);
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {165, 220, 57, 340, 0};
		gridBagLayout.rowHeights = new int[] {25, 0, 30, 0, 30, 0, 30, 0, 30, 0, 30, 0, 30, 0, 30, 0, 30, 0, 30, 0, 30, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNombre = new JLabel("Nickname");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		getContentPane().add(lblNombre, gbc_lblNombre);
		
		
		
		
		comboBoxNicks = new JComboBox<String>();
		comboBoxNicks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("se activo el combobox");

				//antes de cargarle datos me aseguro que este en condiciones 
				limpiarFormulario();
				LimpiarListas();
		    	
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
					
					list.setEnabled(false);
					btnConsultarActividad.setEnabled(false);

					
				}
				//si es profe
				else {
					
					//habilita los campos
					list.setEnabled(true);
					btnConsultarActividad.setEnabled(true);
					
					InfoBasicaProfesor ee = (InfoBasicaProfesor) i ;
					//caro en la presentacion datos especificos del profesor
					txtInstitucion.setText( ee.getInstitucion() );
					txtBibliografia.setText( ee.getDesc() );
					txtDescripcion.setText( ee.getDesc() );
					txtWeb.setText( ee.getUrl() );
				}
				
				
				
				
				
				
				
				InformacionActividad infoActividad = controlUsuario.InformacionActividad(nick);
				
				if( infoActividad.getClass() == InfoActividadSocio.class ) {
					
					InfoActividadSocio oo = (InfoActividadSocio) infoActividad;
					Vector<DtClase> vec = new Vector<DtClase>();
					Vector<Object> vecGenerico = oo.obtenerVector();
					
					
					Iterator<Object> iterat = vecGenerico.iterator();
					while( iterat.hasNext() ) {
						Object aux =  iterat.next( );
						vec.add( (DtClase) aux );
						
					}
					

					DefaultListModel<DtClase> modell = new DefaultListModel<DtClase>();
					Iterator<DtClase> iterat2 = vec.iterator();
					while( iterat2.hasNext() ) {
						modell.addElement(iterat2.next());
					}
					list_1.setModel(modell);
					
					}
				
					
				
				//si es InfoActividadProfesor
				else {
					InfoActividadProfe oo = (InfoActividadProfe) infoActividad;
					Vector<DtActividadesDeportivas> vec = new Vector<DtActividadesDeportivas>();
					Vector<Object> vecGenerico = oo.obtenerVector();
					
					
					Iterator<Object> iterat = vecGenerico.iterator();
					while( iterat.hasNext() ) {
						Object aux =  iterat.next( );
						vec.add( (DtActividadesDeportivas) aux );
					}
					
					
					DefaultListModel<DtActividadesDeportivas> modell = new DefaultListModel<DtActividadesDeportivas>();
					Iterator<DtActividadesDeportivas> iterat2 = vec.iterator();
					while( iterat2.hasNext() ) {
						modell.addElement(iterat2.next());
					}
					list.setModel(modell);
					
				}
					
			}
		});
		GridBagConstraints gbc_comboBoxNicks = new GridBagConstraints();
		gbc_comboBoxNicks.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxNicks.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxNicks.gridx = 1;
		gbc_comboBoxNicks.gridy = 1;
		getContentPane().add(comboBoxNicks, gbc_comboBoxNicks);
		
		JLabel lblActividadesDeportivas = new JLabel("Actividades Deportivas (Nombre)");
		GridBagConstraints gbc_lblActividadesDeportivas = new GridBagConstraints();
		gbc_lblActividadesDeportivas.insets = new Insets(0, 0, 5, 5);
		gbc_lblActividadesDeportivas.gridx = 3;
		gbc_lblActividadesDeportivas.gridy = 1;
		getContentPane().add(lblActividadesDeportivas, gbc_lblActividadesDeportivas);
		

		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 3;
		gbc_scrollPane.gridy = 2;
		gbc_scrollPane.gridheight=6;
		getContentPane().add(scrollPane, gbc_scrollPane);
		
		
		
		list = new JList<DtActividadesDeportivas>();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				DtActividadesDeportivas selected = list.getSelectedValue();
				if (selected != null) {
					Vector<DtClase> vec = selected.getClases();
					DefaultListModel<DtClase> modell = new DefaultListModel<DtClase>();
					Iterator<DtClase> i = vec.iterator();
					while( i.hasNext() ) {
						modell.addElement(i.next());
					}
					list_1.setModel(modell);
				}
			}
		});

		scrollPane.setViewportView(list);
		
			
		JLabel lblNewLabel = new JLabel("Nombre");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.gridx = 1;
		gbc_txtNombre.gridy = 3;
		getContentPane().add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.anchor = GridBagConstraints.WEST;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 0;
		gbc_lblApellido.gridy = 5;
		getContentPane().add(lblApellido, gbc_lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setEditable(false);
		GridBagConstraints gbc_txtApellido = new GridBagConstraints();
		gbc_txtApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellido.insets = new Insets(0, 0, 5, 5);
		gbc_txtApellido.gridx = 1;
		gbc_txtApellido.gridy = 5;
		getContentPane().add(txtApellido, gbc_txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblCorreo = new JLabel("Correo");
		GridBagConstraints gbc_lblCorreo = new GridBagConstraints();
		gbc_lblCorreo.anchor = GridBagConstraints.WEST;
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
		
		btnConsultarActividad = new JButton("Consulta  de  Actividad  Deportiva");
		btnConsultarActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					llamarCasoUsoConsultaAcDeportiva();
				} catch (ActividadDeportivaNoExisteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InstitucionDeportivaNoExisteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		GridBagConstraints gbc_btnConsultarActividad = new GridBagConstraints();
		gbc_btnConsultarActividad.anchor = GridBagConstraints.EAST;
		gbc_btnConsultarActividad.insets = new Insets(0, 0, 5, 5);
		gbc_btnConsultarActividad.gridx = 3;
		gbc_btnConsultarActividad.gridy = 8;
		getContentPane().add(btnConsultarActividad, gbc_btnConsultarActividad);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		GridBagConstraints gbc_lblFechaNacimiento = new GridBagConstraints();
		gbc_lblFechaNacimiento.anchor = GridBagConstraints.WEST;
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
		
		JLabel lblClases = new JLabel("Clases (Nombre)");
		GridBagConstraints gbc_lblClases = new GridBagConstraints();
		gbc_lblClases.insets = new Insets(0, 0, 5, 5);
		gbc_lblClases.gridx = 3;
		gbc_lblClases.gridy = 10;
		getContentPane().add(lblClases, gbc_lblClases);
		
		JLabel lblInstitucion = new JLabel("Institucion");
		GridBagConstraints gbc_lblInstitucion = new GridBagConstraints();
		gbc_lblInstitucion.anchor = GridBagConstraints.WEST;
		gbc_lblInstitucion.insets = new Insets(0, 0, 5, 5);
		gbc_lblInstitucion.gridx = 0;
		gbc_lblInstitucion.gridy = 11;
		getContentPane().add(lblInstitucion, gbc_lblInstitucion);
		
		txtInstitucion = new JTextField();
		txtInstitucion.setEditable(false);
		GridBagConstraints gbc_txtInstitucion = new GridBagConstraints();
		gbc_txtInstitucion.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtInstitucion.insets = new Insets(0, 0, 5, 5);
		gbc_txtInstitucion.gridx = 1;
		gbc_txtInstitucion.gridy = 11;
		getContentPane().add(txtInstitucion, gbc_txtInstitucion);
		txtInstitucion.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 3;
		gbc_scrollPane_1.gridy = 11;
		gbc_scrollPane_1.gridheight = 6;
		getContentPane().add(scrollPane_1, gbc_scrollPane_1);
		
		list_1 = new JList<DtClase>();
		scrollPane_1.setViewportView(list_1);
		
		//DefaultListModel<String> modell = new DefaultListModel<String>();
		//modell.addElement("one");
		//list_1.setModel(modell);
		
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.anchor = GridBagConstraints.WEST;
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 0;
		gbc_lblDescripcion.gridy = 13;
		getContentPane().add(lblDescripcion, gbc_lblDescripcion);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setEditable(false);
		GridBagConstraints gbc_txtDescripcion = new GridBagConstraints();
		gbc_txtDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_txtDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDescripcion.gridx = 1;
		gbc_txtDescripcion.gridy = 13;
		getContentPane().add(txtDescripcion, gbc_txtDescripcion);
		txtDescripcion.setColumns(10);
		
		
		
		JLabel lblBiografia = new JLabel("Biografia");
		GridBagConstraints gbc_lblBiografia = new GridBagConstraints();
		gbc_lblBiografia.anchor = GridBagConstraints.WEST;
		gbc_lblBiografia.insets = new Insets(0, 0, 5, 5);
		gbc_lblBiografia.gridx = 0;
		gbc_lblBiografia.gridy = 15;
		getContentPane().add(lblBiografia, gbc_lblBiografia);
		
		txtBibliografia = new JTextField();
		txtBibliografia.setEditable(false);
		GridBagConstraints gbc_txtBibliografia = new GridBagConstraints();
		gbc_txtBibliografia.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBibliografia.insets = new Insets(0, 0, 5, 5);
		gbc_txtBibliografia.gridx = 1;
		gbc_txtBibliografia.gridy = 15;
		getContentPane().add(txtBibliografia, gbc_txtBibliografia);
		txtBibliografia.setColumns(10);
		
		JLabel lblWeburl = new JLabel("Web (url)");
		GridBagConstraints gbc_lblWeburl = new GridBagConstraints();
		gbc_lblWeburl.anchor = GridBagConstraints.WEST;
		gbc_lblWeburl.insets = new Insets(0, 0, 5, 5);
		gbc_lblWeburl.gridx = 0;
		gbc_lblWeburl.gridy = 17;
		getContentPane().add(lblWeburl, gbc_lblWeburl);
		
		txtWeb = new JTextField();
		txtWeb.setEditable(false);
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
				LimpiarListas();
				
			}
		});
		
		JButton btnConsultarClases = new JButton("Consulta \nde Dictado de Clases");
		btnConsultarClases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				llamarCasoUsoConsultaDictadoClase(); 
			}
		});
		GridBagConstraints gbc_btnConsultarClases = new GridBagConstraints();
		gbc_btnConsultarClases.anchor = GridBagConstraints.EAST;
		gbc_btnConsultarClases.insets = new Insets(0, 0, 5, 5);
		gbc_btnConsultarClases.gridx = 3;
		gbc_btnConsultarClases.gridy = 17;
		getContentPane().add(btnConsultarClases, gbc_btnConsultarClases);
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 1;
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
		model.setSelectedItem(null);
		comboBoxNicks.setModel(model);
		
		//comboBoxNicks.setSelectedIndex(-1);
    }
    
    private void llamarCasoUsoConsultaAcDeportiva() throws ActividadDeportivaNoExisteException, InstitucionDeportivaNoExisteException {
		DtActividadesDeportivas selected = list.getSelectedValue();
		if( selected != null) {
			Principal instancia = Principal.getInstance();
			String actDep = selected.getNombre();
			String inst = txtInstitucion.getText().toString();
			instancia.consultaActividadDeportivaInternalFrame.cargarDatosActividad(actDep);
			instancia.consultaActividadDeportivaInternalFrame.cargarComboboxes(inst, actDep);
			instancia.consultaActividadDeportivaInternalFrame.setVisible(true);
		}
    }
    
	private void llamarCasoUsoConsultaDictadoClase() {
		
		DtClase selected = list_1.getSelectedValue();
		if( selected != null ) {
			String nomClase = selected.getNombre();
			Principal instancia = Principal.getInstance();
			instancia.consultaDictadoDeClasesFrame.cargarDatosClase(nomClase);
			instancia.consultaDictadoDeClasesFrame.setVisible(true);
			
			String claseNombre = nomClase;			
			String InstNombre = instancia.consultaDictadoDeClasesFrame.ClaseAsociadaAInstitucion(claseNombre);
			String nomAct = instancia.consultaDictadoDeClasesFrame.buscaractividad(InstNombre, claseNombre);
			
			instancia.consultaDictadoDeClasesFrame.cargarCombo(claseNombre,nomAct,InstNombre);
		}
	}
    
	private void LimpiarListas() {
		DefaultListModel<DtActividadesDeportivas> m1 = new DefaultListModel<DtActividadesDeportivas>();
		DefaultListModel<DtClase> m2 = new DefaultListModel<DtClase>();
		this.list.setModel(m1);
		this.list_1.setModel(m2);
	}

	
}