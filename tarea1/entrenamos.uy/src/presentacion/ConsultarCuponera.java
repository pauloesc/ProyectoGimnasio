
package presentacion;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import datatypes.DataCuponera;
import datatypes.ParActividad;
import excepciones.ActividadDeportivaNoExisteException;
import excepciones.CuponeraNoExisteException;
import logica.IctrlADeportivas;
import logica.IctrlCuponeras;
import logica.IctrlIDeportivas;
import logica.InfoClases;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import javax.swing.JTextPane;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JFrame;


/**
 * @author vagrant
 *
 */
@SuppressWarnings({ "serial" })

public class ConsultarCuponera extends JInternalFrame {
	
	private IctrlCuponeras controlCuponeras;
	private IctrlIDeportivas controlIDeportivas;
	private IctrlADeportivas controlADeportivas;
	private JComboBox<String> comboBoxCuponeras;
	private JTextField txtNombre;
    private JTextArea txtDescripcion;
    private JTextField txtFechaIni;
    private JTextField txtDescuento;
    private JTextField txtFechaAlta;
    private JLabel lblPeriodoDeVigencia;
    private JLabel lblFin;
    private JTextField textFechafin;
    private JScrollPane scrollPane_2;
    private JTable table;
    private ConsultaActividadDeportiva framedeportivas;

	
	public ConsultarCuponera(IctrlCuponeras ICC, IctrlIDeportivas IID, IctrlADeportivas IAD ) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				limpiarFormulario();
				setVisible(false);
			}
		});
	
		controlCuponeras=ICC;
		controlIDeportivas=IID;
		controlADeportivas=IAD;
		
		setTitle("Consultar Cuponera");
		setBounds(100, 5, 487, 545);

		
		JLabel lblCuponeras = new JLabel("Cuponeras:");
		lblCuponeras.setBounds(30, 33, 99, 15);
		
		comboBoxCuponeras = new JComboBox<String>();
		comboBoxCuponeras.setBounds(133, 27, 298, 26);
		comboBoxCuponeras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargardatoscuponeras(comboBoxCuponeras.getSelectedItem().toString());
			}
		});
		comboBoxCuponeras.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(30, 63, 70, 19);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(133, 60, 298, 26);
		txtNombre.setEditable(false);
		txtNombre.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel lblDescripcin = new JLabel("Descripción:");
		lblDescripcin.setBounds(30, 94, 95, 19);
		
		txtDescripcion = new JTextArea();
		txtDescripcion.setBounds(133, 98, 298, 89);
		txtDescripcion.setEditable(false);
		txtDescripcion.setBorder(BorderFactory.createLineBorder(Color.black));
		
		txtFechaIni = new JTextField();
		txtFechaIni.setBounds(202, 199, 93, 23);
		txtFechaIni.setEditable(false);
		txtFechaIni.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel lblDescuento = new JLabel("Descuento:");
		lblDescuento.setBounds(30, 234, 99, 22);
				
		txtDescuento = new JTextField();
		txtDescuento.setBounds(133, 234, 93, 23);
		txtDescuento.setEditable(false);
		txtDescuento.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel lblFechaDeAlta = new JLabel("Fecha Alta:");
		lblFechaDeAlta.setBounds(30, 271, 95, 19);
		
		txtFechaAlta = new JTextField();
		txtFechaAlta.setBounds(133, 269, 93, 23);
		txtFechaAlta.setEditable(false);
		txtFechaAlta.setBorder(BorderFactory.createLineBorder(Color.black));
		
		lblPeriodoDeVigencia = new JLabel("Periodo de vigencia: ");
		lblPeriodoDeVigencia.setBounds(30, 199, 154, 19);
		
		lblFin = new JLabel("al");
		lblFin.setBounds(307, 199, 23, 21);
		
		textFechafin = new JTextField();
		textFechafin.setBounds(338, 199, 93, 23);
		textFechafin.setEditable(false);
		textFechafin.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		JLabel lblActividadesDeportivas = new JLabel("Actividades deportivas incluidas: ");
		lblActividadesDeportivas.setBounds(30, 310, 265, 19);
		getContentPane().setLayout(null);
		
		getContentPane().add(lblCuponeras);
		getContentPane().add(comboBoxCuponeras);
		getContentPane().add(lblNombre);
		getContentPane().add(txtNombre);
		getContentPane().add(lblDescripcin);
		getContentPane().add(txtDescripcion);
		getContentPane().add(lblPeriodoDeVigencia);
		getContentPane().add(txtFechaIni);
		getContentPane().add(lblFin);
		getContentPane().add(textFechafin);
		getContentPane().add(lblDescuento);
		getContentPane().add(txtDescuento);
		getContentPane().add(lblFechaDeAlta);
		getContentPane().add(txtFechaAlta);
		getContentPane().add(lblActividadesDeportivas);
		
		/*scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(30, 341, 241, 41);
		getContentPane().add(scrollPane);
		
		list = new JList<String>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		
		JLabel lblNmeroDeClases = new JLabel("Número de clases:");
		lblNmeroDeClases.setBounds(271, 306, 147, 26);
		getContentPane().add(lblNmeroDeClases);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(271, 341, 147, 41);
		getContentPane().add(scrollPane_1);
		
		list_1 = new JList<Integer>();
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(list_1); */
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setBounds(30, 343, 386, 115);
		getContentPane().add(scrollPane_2);
		
		table = new JTable();
		scrollPane_2.setViewportView(table);
		
		JButton btnBsqueda = new JButton("Búsqueda");
		btnBsqueda.setBounds(30, 470, 117, 25);
		getContentPane().add(btnBsqueda);
		btnBsqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean es=activar();
				if (es) {
					String val=String.valueOf(table.getValueAt(table.getSelectedRow(), 0));	
					Principal instancia = Principal.getInstance();
					instancia.consultaActividadDeportivaInternalFrame.cargarDatosActividad(val);
					instancia.consultaActividadDeportivaInternalFrame.setVisible(true);
					
				}
			}
		});
		
		
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(299, 470, 117, 25);
		getContentPane().add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 limpiarFormulario();
				 setVisible(false);
			}
		});		
		
	} 

	
	
	
	protected boolean activar() {
		
		boolean resu=false;
		int num=table.getSelectedRow();
		if (num==-1) { JOptionPane.showMessageDialog(this, "Debe seleccionar una actividad deportiva", "Consultar cuponera",
                JOptionPane.ERROR_MESSAGE);
		}
		else {
		/*String val=String.valueOf(table.getValueAt(num, 0));
		System.out.println(val);		
		ac=val;*/
		resu=true;
		}
		return resu;
	}
	
	
	protected void cargardatoscuponeras(String nomb) {
		
		Date date = null;  
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");  
		
		try {	
		DataCuponera dat= controlCuponeras.mostrarCuponera(nomb);
		txtNombre.setText(dat.getNombre());
		txtDescripcion.setText(dat.getDescripcion());
		txtDescuento.setText(dat.getDescuento().toString());
		date = dat.getFecha_ini();
        String strDateini = dateFormat.format(date);
        txtFechaIni.setText(strDateini);   
        date = dat.getFecha_fin();
        String strDatefin = dateFormat.format(date);
        textFechafin.setText(strDatefin);   
        date = dat.getFecha_alta(); 
        String strDatealta = dateFormat.format(date);
        txtFechaAlta.setText(strDatealta); 
        
        
        DefaultTableModel modelo;
        modelo= new DefaultTableModel();
        String[] columnName= {"Actividad Deportiva","Número de clases"};
        modelo.setColumnIdentifiers(columnName);
        
        Set<ParActividad> res=dat.getClases();
        if (!res.isEmpty()) {
    		for (Iterator<ParActividad> iter=res.iterator();iter.hasNext();) {
    			ParActividad it=iter.next();
    			Object[] sen= {it.getNombre(), it.getNumclase()};
    		    modelo.addRow(sen);
    			
    		}
	    } 
        table.setModel(modelo);
        /*DefaultListModel<String> modelo;
        DefaultListModel<Integer> modelo2;
        modelo= new DefaultListModel<String>();
        modelo2= new DefaultListModel<Integer>();
        Set<ParActividad> res=dat.getClases();
        if (!res.isEmpty()) {
    		for (Iterator<ParActividad> iter=res.iterator();iter.hasNext();) {
    			ParActividad it=iter.next();
    			modelo.addElement(it.getNombre());
    			modelo2.addElement(it.getNumclase());
    		}
	    } 
        list.setModel(modelo);
        list_1.setModel(modelo2);*/
		}catch (CuponeraNoExisteException e) {
    	JOptionPane.showMessageDialog(this, "No existen datos en el sistema para la Cuponera seleccionada.", "Consulta Cuponera",
	    		JOptionPane.ERROR_MESSAGE);
    	setVisible(false);
	    }
	}
	
	
	public void cargarCuponeras() {
        DefaultComboBoxModel<String> modelo;
        try {
        	int n=controlCuponeras.listarCuponeras().size();
        	String list[]= new String[n];
        	list=controlCuponeras.listarCuponeras().toArray(list);
            modelo = new DefaultComboBoxModel<String>(list);
            modelo.setSelectedItem(null);
            comboBoxCuponeras.setModel(modelo);
        } catch (CuponeraNoExisteException e) {
        	JOptionPane.showMessageDialog(this, "No existen Cuponeras en el sistema.", "Consultar Cuponera",
    	    		JOptionPane.ERROR_MESSAGE);
        	setVisible(false);
        }
	}
	
 private void limpiarFormulario() {
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtDescuento.setText("");
        txtFechaIni.setText("");
        textFechafin.setText("");
        txtFechaAlta.setText("");
        DefaultTableModel modelo1= new DefaultTableModel();
        table.setModel(modelo1);
        
    }
}
	
	
	