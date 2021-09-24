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
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;


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
    private JTextField txtDescripcion;
    private JTextField txtBibliografia;
    private JTextField txtWeb;
    private JButton btnAltaUsuario;
    private JDateChooser dateChooserInicio;

    
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
		setBounds(20, 50, 479, 663);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 165, 160, 50, 0};
		gridBagLayout.rowHeights = new int[] {25, 0, 30, 0, 30, 0, 30, 0, 30, 0, 30, 0, 30, 0, 30, 0, 30, 0, 30, 0, 30, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNombre = new JLabel("Nickname");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 1;
		getContentPane().add(lblNombre, gbc_lblNombre);
		
		txtNickName = new JTextField();
		GridBagConstraints gbc_txtNickName = new GridBagConstraints();
		gbc_txtNickName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNickName.insets = new Insets(0, 0, 5, 5);
		gbc_txtNickName.gridx = 2;
		gbc_txtNickName.gridy = 1;
		getContentPane().add(txtNickName, gbc_txtNickName);
		txtNickName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 3;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		txtNombre = new JTextField();
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
		GridBagConstraints gbc_txtCorreo = new GridBagConstraints();
		gbc_txtCorreo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_txtCorreo.gridx = 2;
		gbc_txtCorreo.gridy = 7;
		getContentPane().add(txtCorreo, gbc_txtCorreo);
		txtCorreo.setColumns(10);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		GridBagConstraints gbc_lblFechaNacimiento = new GridBagConstraints();
		gbc_lblFechaNacimiento.anchor = GridBagConstraints.WEST;
		gbc_lblFechaNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaNacimiento.gridx = 1;
		gbc_lblFechaNacimiento.gridy = 9;
		getContentPane().add(lblFechaNacimiento, gbc_lblFechaNacimiento);
		
		chckbxProfesor = new JCheckBox("Profesor");
		
		
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
							
				Vector<String> vector2;
				vector2 = icu.InstitucionesEnSistema();
				DefaultComboBoxModel<String> model;
				model = new DefaultComboBoxModel<String>(vector2);
				model.setSelectedItem(null);
				comboBox.setModel(model);
				
			}
		});
		
		dateChooserInicio = new JDateChooser();
		GridBagConstraints gbc_dateChooserInicio = new GridBagConstraints();
		gbc_dateChooserInicio.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateChooserInicio.insets = new Insets(0, 0, 5, 6);
		gbc_dateChooserInicio.gridx = 2;
		gbc_dateChooserInicio.gridy = 9;
		getContentPane().add(dateChooserInicio, gbc_dateChooserInicio);

		
		GridBagConstraints gbc_chckbxProfesor = new GridBagConstraints();
		gbc_chckbxProfesor.anchor = GridBagConstraints.WEST;
		gbc_chckbxProfesor.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxProfesor.gridx = 1;
		gbc_chckbxProfesor.gridy = 11;
		getContentPane().add(chckbxProfesor, gbc_chckbxProfesor);
		
		JLabel lblInstitucion = new JLabel("Institucion");
		GridBagConstraints gbc_lblInstitucion = new GridBagConstraints();
		gbc_lblInstitucion.anchor = GridBagConstraints.WEST;
		gbc_lblInstitucion.insets = new Insets(0, 0, 5, 5);
		gbc_lblInstitucion.gridx = 1;
		gbc_lblInstitucion.gridy = 13;
		getContentPane().add(lblInstitucion, gbc_lblInstitucion);
		
		comboBox = new JComboBox<String>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 13;
		getContentPane().add(comboBox, gbc_comboBox);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.anchor = GridBagConstraints.WEST;
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 1;
		gbc_lblDescripcion.gridy = 15;
		getContentPane().add(lblDescripcion, gbc_lblDescripcion);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setEnabled(false);
		txtDescripcion.setEditable(false);
		GridBagConstraints gbc_txtDescripcion = new GridBagConstraints();
		gbc_txtDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_txtDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDescripcion.gridx = 2;
		gbc_txtDescripcion.gridy = 15;
		getContentPane().add(txtDescripcion, gbc_txtDescripcion);
		txtDescripcion.setColumns(10);
		
		
		
		JLabel lblBiografia = new JLabel("Biografia");
		GridBagConstraints gbc_lblBiografia = new GridBagConstraints();
		gbc_lblBiografia.anchor = GridBagConstraints.WEST;
		gbc_lblBiografia.insets = new Insets(0, 0, 5, 5);
		gbc_lblBiografia.gridx = 1;
		gbc_lblBiografia.gridy = 17;
		getContentPane().add(lblBiografia, gbc_lblBiografia);
		
		txtBibliografia = new JTextField();
		txtBibliografia.setEditable(false);
		txtBibliografia.setEnabled(false);
		GridBagConstraints gbc_txtBibliografia = new GridBagConstraints();
		gbc_txtBibliografia.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBibliografia.insets = new Insets(0, 0, 5, 5);
		gbc_txtBibliografia.gridx = 2;
		gbc_txtBibliografia.gridy = 17;
		getContentPane().add(txtBibliografia, gbc_txtBibliografia);
		txtBibliografia.setColumns(10);
		
		JLabel lblWeburl = new JLabel("Web (url)");
		GridBagConstraints gbc_lblWeburl = new GridBagConstraints();
		gbc_lblWeburl.anchor = GridBagConstraints.WEST;
		gbc_lblWeburl.insets = new Insets(0, 0, 5, 5);
		gbc_lblWeburl.gridx = 1;
		gbc_lblWeburl.gridy = 19;
		getContentPane().add(lblWeburl, gbc_lblWeburl);
		
		txtWeb = new JTextField();
		txtWeb.setEditable(false);
		txtWeb.setEnabled(false);
		GridBagConstraints gbc_txtWeb = new GridBagConstraints();
		gbc_txtWeb.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtWeb.insets = new Insets(0, 0, 5, 5);
		gbc_txtWeb.gridx = 2;
		gbc_txtWeb.gridy = 19;
		getContentPane().add(txtWeb, gbc_txtWeb);
		txtWeb.setColumns(10);
		
		btnAltaUsuario = new JButton("Alta Usuario");		
		btnAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ProcesoCargaUsuario(e);	
			}
		});

		GridBagConstraints gbc_btnAltaUsuario = new GridBagConstraints();
		gbc_btnAltaUsuario.anchor = GridBagConstraints.WEST;
		gbc_btnAltaUsuario.insets = new Insets(0, 0, 0, 5);
		gbc_btnAltaUsuario.gridx = 1;
		gbc_btnAltaUsuario.gridy = 21;
		getContentPane().add(btnAltaUsuario, gbc_btnAltaUsuario);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
				setVisible(false);
				
			}
		});
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
						dateChooserInicio.getDate());
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