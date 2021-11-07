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
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.ScrollPaneConstants;


@SuppressWarnings({ "serial", "unused" })
public class ConsultaUsuario extends JInternalFrame{
		
    // Controlador de Deportivas que se utilizará para las acciones del JFrame
    private IctrlUsuarios controlUsuario;
    
    
    private JTextField txtInstitucion;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtCorreo;
    private JComboBox<String> comboBoxNicks;
    private JTextArea txtDescripcion;
    private JTextArea txtBibliografia;
    private JTextArea txtWeb;
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
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nickname");
		lblNombre.setBounds(48, 53, 68, 15);
		getContentPane().add(lblNombre);
		
		
		
		
		comboBoxNicks = new JComboBox<String>();
		comboBoxNicks.setBounds(213, 49, 215, 24);
		comboBoxNicks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("se activo el combobox");

				//antes de cargarle datos me aseguro que este en condiciones 
				limpiarFormulario();
				LimpiarListas();
		    	
				String nick = comboBoxNicks.getSelectedItem().toString();
			
				InfoBasicaUser i;
				i = controlUsuario.informacionBasicaUsuario(nick);
				
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
					txtBibliografia.setText( ee.getBibliografia());
					txtDescripcion.setText( ee.getDesc() );
					txtWeb.setText( ee.getUrl() );
				}
				
				
				
				
				
				
				
				InformacionActividad infoActividad = controlUsuario.informacionActividad(nick);
				
				if( infoActividad.getClass() == InfoActividadSocio.class ) {
					
					InfoActividadSocio oo = (InfoActividadSocio) infoActividad;
					List<DtClase> vec = oo.getClases();
					

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
					List<DtActividadesDeportivas> vec = oo.getActividadesDep();
					
					DefaultListModel<DtActividadesDeportivas> modell = new DefaultListModel<DtActividadesDeportivas>();
					Iterator<DtActividadesDeportivas> iterat2 = vec.iterator();
					while( iterat2.hasNext() ) {
						modell.addElement(iterat2.next());
					}
					list.setModel(modell);
					
				}
					
			}
		});
		getContentPane().add(comboBoxNicks);
		
		JLabel lblActividadesDeportivas = new JLabel("Actividades Deportivas (Nombre)");
		lblActividadesDeportivas.setBounds(542, 53, 231, 15);
		getContentPane().add(lblActividadesDeportivas);
		

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(490, 78, 335, 157);
		getContentPane().add(scrollPane);
		
		
		
		list = new JList<DtActividadesDeportivas>();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				DtActividadesDeportivas selected = list.getSelectedValue();
				if (selected != null) {
					List<DtClase> vec = selected.getClases();
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
		lblNewLabel.setBounds(48, 110, 55, 15);
		getContentPane().add(lblNewLabel);
		
		
		txtNombre = new JTextField();
		txtNombre.setBounds(213, 108, 215, 19);
		txtNombre.setEditable(false);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(48, 164, 57, 15);
		getContentPane().add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(213, 162, 215, 19);
		txtApellido.setEditable(false);
		getContentPane().add(txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(48, 218, 48, 15);
		getContentPane().add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(213, 216, 215, 19);
		txtCorreo.setEditable(false);
		getContentPane().add(txtCorreo);
		txtCorreo.setColumns(10);
		
		btnConsultarActividad = new JButton("Consulta  de  Actividad  Deportiva");
		btnConsultarActividad.setBounds(553, 240, 272, 25);
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
		getContentPane().add(btnConsultarActividad);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblFechaNacimiento.setBounds(48, 272, 125, 15);
		getContentPane().add(lblFechaNacimiento);
		
		dateChooserInicio = new JDateChooser();
		dateChooserInicio.setBounds(213, 270, 214, 19);
		getContentPane().add(dateChooserInicio);
		
		JLabel lblClases = new JLabel("Clases (Nombre)");
		lblClases.setBounds(599, 299, 116, 15);
		getContentPane().add(lblClases);
		
		JLabel lblInstitucion = new JLabel("Institucion");
		lblInstitucion.setBounds(48, 326, 75, 15);
		getContentPane().add(lblInstitucion);
		
		txtInstitucion = new JTextField();
		txtInstitucion.setBounds(213, 324, 215, 19);
		txtInstitucion.setEditable(false);
		getContentPane().add(txtInstitucion);
		txtInstitucion.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(490, 324, 335, 157);
		getContentPane().add(scrollPane_1);
		
		list_1 = new JList<DtClase>();
		scrollPane_1.setViewportView(list_1);
		
		//DefaultListModel<String> modell = new DefaultListModel<String>();
		//modell.addElement("one");
		//list_1.setModel(modell);
		
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(48, 380, 82, 15);
		getContentPane().add(lblDescripcion);
		
		
		
		JLabel lblBiografia = new JLabel("Biografia");
		lblBiografia.setBounds(48, 434, 64, 15);
		getContentPane().add(lblBiografia);
		
		JLabel lblWeburl = new JLabel("Web (url)");
		lblWeburl.setBounds(48, 491, 65, 15);
		getContentPane().add(lblWeburl);
		
		JButton btnCancelar = new JButton("Cerrar");
		btnCancelar.setBounds(213, 606, 215, 25);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
				setVisible(false);
				LimpiarListas();
				
			}
		});
		
		JButton btnConsultarClases = new JButton("Consulta \nde Dictado de Clases");
		btnConsultarClases.setBounds(575, 486, 250, 25);
		btnConsultarClases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				llamarCasoUsoConsultaDictadoClase(); 
			}
		});
		getContentPane().add(btnConsultarClases);
		getContentPane().add(btnCancelar);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setBounds(213, 380, 215, 49);
		getContentPane().add(scrollPane_2);
		
		txtDescripcion = new JTextArea();
		scrollPane_2.setViewportView(txtDescripcion);
		txtDescripcion.setEditable(false);
		txtDescripcion.setColumns(10);
		txtDescripcion.setWrapStyleWord(true);
		txtDescripcion.setLineWrap(true);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_3.setBounds(213, 434, 215, 49);
		getContentPane().add(scrollPane_3);
		
		txtBibliografia = new JTextArea();
		scrollPane_3.setViewportView(txtBibliografia);
		txtBibliografia.setEditable(false);
		txtBibliografia.setColumns(10);
		txtBibliografia.setWrapStyleWord(true);
		txtBibliografia.setLineWrap(true);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_4.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_4.setBounds(213, 491, 215, 49);
		getContentPane().add(scrollPane_4);
		
		txtWeb = new JTextArea();
		scrollPane_4.setViewportView(txtWeb);
		txtWeb.setEditable(false);
		txtWeb.setColumns(10);
		

		
	}// Permite validar la información introducida en los campos e indicar
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
    	
		List<String> vector;
		vector = controlUsuario.usuariosEnSistemaNickName();
		DefaultComboBoxModel<String> model;
		Vector<String> casteoVector = (Vector<String>) vector;
		model = new DefaultComboBoxModel<String>(casteoVector);
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