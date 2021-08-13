package presentacion;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Button;
import java.awt.TextArea;

import excepciones.InstitucionDeportivaRepetidaException;
//import logica.IctrlUsuarios;

@SuppressWarnings("serial")
public class AltaInstitucionDeportiva extends JInternalFrame {
	public AltaInstitucionDeportiva() {
		setTitle("Alta de Institución Deportiva");
		setClosable(true);
		getContentPane().setLayout(null);
		setBounds(10, 40, 446, 291);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(31, 30, 70, 19);
		getContentPane().add(lblNombre);
		
		TextField textNombre = new TextField();
		textNombre.setBounds(130, 30, 280, 19);
		getContentPane().add(textNombre);
		
		JLabel lblDescripcin = new JLabel("Descripción:");
		lblDescripcin.setBounds(31, 60, 95, 19);
		getContentPane().add(lblDescripcin);
		
		JLabel lblUrl = new JLabel("URL:");
		lblUrl.setBounds(31, 156, 70, 19);
		getContentPane().add(lblUrl);
		
		TextField textURL = new TextField();
		textURL.setBounds(130, 156, 280, 19);
		getContentPane().add(textURL);
		
		Button buttonAceptar = new Button("Aceptar");
		buttonAceptar.setBounds(159, 205, 100, 32);
		getContentPane().add(buttonAceptar);
		
		Button buttonCancelar = new Button("Cancelar");
		buttonCancelar.setBounds(277, 205, 100, 32);
		buttonCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //limpiarFormulario();
                setVisible(false);
            }
        });
		getContentPane().add(buttonCancelar);
		
		TextArea textDescripcion = new TextArea();
		textDescripcion.setBounds(130, 61, 280, 89);
		getContentPane().add(textDescripcion);
	}
}
