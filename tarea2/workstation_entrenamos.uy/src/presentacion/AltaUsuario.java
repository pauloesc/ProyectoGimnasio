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
import logica.InfoBasicaProfesor;
import logica.InfoBasicaSocio;
import logica.InfoBasicaUser;
import excepciones.UsuarioDisponibilidadException;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import java.awt.event.*;
import java.awt.*;

import javax.swing.DefaultComboBoxModel;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;


@SuppressWarnings({ "serial", "unused" })
public class AltaUsuario extends JInternalFrame{
	
    // Controlador de Deportivas que se utilizará para las acciones del JFrame
    private IctrlUsuarios controlUsuario;
    private JTextField txtNickName;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtCorreo;
    private JCheckBox chckbxProfesor;
    private JComboBox<String> comboBox;
    private JTextArea txtDescripcion;
    private JTextArea txtBibliografia;
    private JTextField txtWeb;
    private JButton btnAltaUsuario;
    private JDateChooser dateChooserInicio;
    private JLabel lblContrasenia;
    private JLabel lblConfirmarContrasea;
    private JTextField pass;
    private JTextField passConf;
    private JScrollPane scrollPane;
    private JScrollPane scrollPane_1;

    
	public AltaUsuario(IctrlUsuarios icu)  {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				limpiarFormulario();
			}
		});
		
		//esto es:
		//cuando se llama al a la ventana el programa principal le pasa el controlador
		controlUsuario = icu;
		
		setTitle("Alta Usuario");
		setClosable(true);
		setBounds(20, 50, 479, 661);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nickname");
		lblNombre.setBounds(30, 32, 68, 15);
		getContentPane().add(lblNombre);
		
		txtNickName = new JTextField();
		txtNickName.setBounds(195, 30, 189, 19);
		getContentPane().add(txtNickName);
		txtNickName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(30, 59, 55, 15);
		getContentPane().add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(195, 57, 189, 19);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(30, 86, 57, 15);
		getContentPane().add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(195, 84, 189, 19);
		getContentPane().add(txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(30, 113, 48, 15);
		getContentPane().add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(195, 111, 189, 19);
		getContentPane().add(txtCorreo);
		txtCorreo.setColumns(10);
		
		chckbxProfesor = new JCheckBox("Profesor");
		chckbxProfesor.setBounds(30, 276, 86, 23);
		
		
		chckbxProfesor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				boolean estado  = chckbxProfesor.isSelected();
				txtBibliografia.setEditable(estado);
				txtBibliografia.setEnabled(estado);
				txtDescripcion.setEnabled(estado);
				txtDescripcion.setEditable(estado);
				txtWeb.setEditable(estado);
				txtWeb.setEnabled(estado);
				comboBox.setEditable(estado);
				comboBox.setEnabled(estado);

				List<String> vector2;
				vector2 = icu.institucionesEnSistema();
				DefaultComboBoxModel<String> model;
				Vector<String> casteoVector2 = (Vector<String>) vector2;
				model = new DefaultComboBoxModel<String>(casteoVector2);
				model.setSelectedItem(null);
				comboBox.setModel(model);
				
			}
		});
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblFechaNacimiento.setBounds(30, 140, 125, 15);
		getContentPane().add(lblFechaNacimiento);
		
		dateChooserInicio = new JDateChooser();
		dateChooserInicio.setBounds(195, 138, 188, 19);
		getContentPane().add(dateChooserInicio);
		
		lblContrasenia = new JLabel("Contraseña");
		lblContrasenia.setBounds(30, 194, 83, 15);
		getContentPane().add(lblContrasenia);
		
		pass = new JTextField();
		pass.setBounds(195, 192, 189, 19);
		getContentPane().add(pass);
		pass.setColumns(10);
		
		lblConfirmarContrasea = new JLabel("Confirmar contraseña");
		lblConfirmarContrasea.setBounds(30, 221, 154, 15);
		getContentPane().add(lblConfirmarContrasea);
		
		passConf = new JTextField();
		passConf.setBounds(195, 219, 189, 19);
		getContentPane().add(passConf);
		passConf.setColumns(10);
		getContentPane().add(chckbxProfesor);
		
		JLabel lblInstitucion = new JLabel("Institucion");
		lblInstitucion.setBounds(30, 309, 75, 15);
		getContentPane().add(lblInstitucion);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(195, 304, 189, 24);
		getContentPane().add(comboBox);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(30, 359, 82, 15);
		getContentPane().add(lblDescripcion);
		
		
		
		JLabel lblBiografia = new JLabel("Biografia");
		lblBiografia.setBounds(30, 449, 64, 15);
		getContentPane().add(lblBiografia);
		
		JLabel lblWeburl = new JLabel("Web (url)");
		lblWeburl.setBounds(30, 527, 65, 15);
		getContentPane().add(lblWeburl);
		
		txtWeb = new JTextField();
		txtWeb.setBounds(195, 525, 229, 19);
		txtWeb.setEditable(false);
		txtWeb.setEnabled(false);
		getContentPane().add(txtWeb);
		txtWeb.setColumns(10);
		
		btnAltaUsuario = new JButton("Alta Usuario");		
		btnAltaUsuario.setBounds(63, 596, 121, 25);
		btnAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ProcesoCargaUsuario(e);	
			}
		});
		getContentPane().add(btnAltaUsuario);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(288, 596, 96, 25);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
				setVisible(false);
				
			}
		});
		getContentPane().add(btnCancelar);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(195, 358, 189, 57);
		getContentPane().add(scrollPane);
		
		txtDescripcion = new JTextArea();
		txtDescripcion.setEditable(false);
		txtDescripcion.setEnabled(false);
		scrollPane.setViewportView(txtDescripcion);
		txtDescripcion.setColumns(10);
		txtDescripcion.setWrapStyleWord(true);
		txtDescripcion.setLineWrap(true);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(195, 448, 189, 49);
		getContentPane().add(scrollPane_1);
		
		txtBibliografia = new JTextArea();
		txtBibliografia.setEditable(false);
		txtBibliografia.setEnabled(false);
		txtBibliografia.setLineWrap(true);
		scrollPane_1.setViewportView(txtBibliografia);
		txtBibliografia.setColumns(10);
		txtBibliografia.setWrapStyleWord(true);
	}
	
	// Permite validar la información introducida en los campos e indicar
    // a través de un mensaje de error (JOptionPane) cuando algo sucede.
    // Este tipo de chequeos se puede realizar de otras formas y con otras librerías de Java, 
    // por ejemplo impidiendo que se escriban caracteres no numéricos al momento de escribir en
    // en el campo de la cédula, o mostrando un mensaje de error apenas el foco pasa a otro campo.
    private boolean checkFormulario() {
    	
        String nombre = txtNombre.getText();
        String nickname = txtNickName.getText();
        String apellido = txtApellido.getText();
        String correo = txtCorreo.getText();
        
        boolean verificacion = true;

        if (nombre.isEmpty() || nickname.isEmpty() || apellido.isEmpty() || correo.isEmpty() ) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Alta De Usuario",
                    JOptionPane.ERROR_MESSAGE);
            verificacion = false;
        }
        
        if( chckbxProfesor.isSelected() ) {
        	String vacio = "";
        	if( comboBox.getSelectedItem().toString().equals(vacio) ) {
                JOptionPane.showMessageDialog(this, "Seleccione una institucion", "Alta De Usuario",
                        JOptionPane.ERROR_MESSAGE);
                verificacion = false;
        	}
        }
        
        String StringPass = pass.getText();
        String StringPassConfirmacion = passConf.getText();
        if( !( StringPass.equals(StringPassConfirmacion) ) ) {
	        JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden", "Alta De Usuario",
	                JOptionPane.ERROR_MESSAGE);
	        verificacion = false;
        }
        
        return verificacion;
    }
    
    
    private void limpiarFormulario() {
    	txtNickName.setText("");
    	txtNombre.setText("");
    	txtApellido.setText("");
    	txtCorreo.setText("");
    	dateChooserInicio.setCalendar(null);
    	chckbxProfesor.setSelected(false);
    	comboBox.removeAllItems();
    	txtDescripcion.setText("");
    	txtBibliografia.setText("");
    	txtWeb.setText("");
    	
    	pass.setText("");
    	passConf.setText("");
    	
    	comboBox.setEditable(false);
    	comboBox.setEnabled(false);
		txtBibliografia.setEditable(false);
		txtBibliografia.setEnabled(false);
		txtDescripcion.setEnabled(false);
		txtDescripcion.setEditable(false);
		txtWeb.setEditable(false);
		txtWeb.setEnabled(false);
		comboBox.setEditable(false);
		comboBox.setEnabled(false);
    	
    	
    }
    
    protected void ProcesoCargaUsuario(ActionEvent arg0) {
    	
        if (checkFormulario()) {
        	
			InfoBasicaUser i;
			
			if( chckbxProfesor.isSelected() ) {
				
				i = new InfoBasicaProfesor(
						txtNickName.getText(),
						txtNombre.getText(),
						txtApellido.getText(),
						txtCorreo.getText(),
						dateChooserInicio.getDate(),
						pass.getText(),
						"",
						comboBox.getSelectedItem().toString(),
						txtDescripcion.getText(),
						txtBibliografia.getText(),
						txtWeb.getText());
				
			}else {
				i = new InfoBasicaSocio(
						txtNickName.getText(),
						txtNombre.getText(),
						txtApellido.getText(),
						txtCorreo.getText(),
						dateChooserInicio.getDate(),
						pass.getText(),"");
			}
        	
            try {
            	controlUsuario.altaUsuario(i);
                JOptionPane.showMessageDialog(this, "El Usuario se ha creado con éxito", "Registrar Usuario",
                        JOptionPane.INFORMATION_MESSAGE);
                limpiarFormulario();
                setVisible(false);

            } catch (UsuarioDisponibilidadException ee) {
                JOptionPane.showMessageDialog(this, ee.getMessage(), "Registrar Usuario", JOptionPane.ERROR_MESSAGE);
            }
        }	
    }
}