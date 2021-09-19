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
import logica.IctrlCategorias;

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

import excepciones.CategoriaExistenteException;
import excepciones.ClaseRepetidaException;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.JFrame;
import java.awt.GridBagLayout;

public class AltaCategoria extends JInternalFrame {
	
	private IctrlCategorias IC;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaCategoria frame = new AltaCategoria();
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
	
	
	
	public AltaCategoria() {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				setVisible(false);
				limpiarFormulario();
			}
		});
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		Fabrica fab = Fabrica.getInstance();
		IC = fab.getIctrlCategorias();
		
		setClosable(true);
		
		setTitle("Alta dictado de clases");
		setBounds(100, 100, 498, 330);
		
		JLabel lblNombreDeLa = new JLabel("Nombre de la categoria:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					IC.altaCategoria(textField.getText());
					JOptionPane.showMessageDialog(null, "Categoría registrada exitosamente");
				} catch (CategoriaExistenteException ex) {
					JOptionPane.showMessageDialog(null, "Error, nombre de la clase existente");
				}
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				limpiarFormulario();
				setVisible(false);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAceptar)
							.addGap(18)
							.addComponent(btnCancelar))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNombreDeLa)
							.addGap(27)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(95)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombreDeLa))
					.addGap(64)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAceptar)
						.addComponent(btnCancelar))
					.addContainerGap(311, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		

		
		
		
		
	}
	
	public void limpiarFormulario() {
		textField.setText("");
		
	}
}
