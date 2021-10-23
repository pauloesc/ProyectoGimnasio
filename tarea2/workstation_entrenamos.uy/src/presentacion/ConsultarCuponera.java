
package presentacion;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import excepciones.CuponeraNoExisteException;
import logica.DataCuponera;
import logica.IctrlADeportivas;
import logica.IctrlCuponeras;
import logica.IctrlIDeportivas;
import logica.ParActividad;

import java.awt.Color;
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
import javax.swing.JTable;
import javax.swing.JScrollPane;

import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JList;


/**
 * @author vagrant
 *
 */
@SuppressWarnings({ "serial" })

public class ConsultarCuponera extends JInternalFrame {
	
	private IctrlCuponeras controlCuponeras;
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
    private JLabel lblCostoTotal;
    private JTextField textCosto;
    private JLabel lblCategorias;
    private JList<String> list;

	
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
		
		setTitle("Consultar Cuponera");
		setBounds(100, 5, 487, 662);
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
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
		txtDescripcion.setBounds(133, 98, 298, 80);
		txtDescripcion.setEditable(false);
		txtDescripcion.setBorder(BorderFactory.createLineBorder(Color.black));
		
		txtFechaIni = new JTextField();
		txtFechaIni.setBounds(196, 190, 93, 23);
		txtFechaIni.setEditable(false);
		txtFechaIni.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel lblDescuento = new JLabel("Descuento aplicado (%) :");
		lblDescuento.setBounds(30, 252, 191, 22);
				
		txtDescuento = new JTextField();
		txtDescuento.setBounds(217, 252, 93, 23);
		txtDescuento.setEditable(false);
		txtDescuento.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel lblFechaDeAlta = new JLabel("Fecha Alta:");
		lblFechaDeAlta.setBounds(30, 221, 95, 19);
		
		txtFechaAlta = new JTextField();
		txtFechaAlta.setBounds(134, 219, 93, 23);
		txtFechaAlta.setEditable(false);
		txtFechaAlta.setBorder(BorderFactory.createLineBorder(Color.black));
		
		lblPeriodoDeVigencia = new JLabel("Periodo de vigencia: ");
		lblPeriodoDeVigencia.setBounds(30, 190, 154, 19);
		
		lblFin = new JLabel("al");
		lblFin.setBounds(309, 189, 23, 21);
		
		textFechafin = new JTextField();
		textFechafin.setBounds(338, 190, 93, 23);
		textFechafin.setEditable(false);
		textFechafin.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		JLabel lblActividadesDeportivas = new JLabel("Actividades deportivas incluidas: ");
		lblActividadesDeportivas.setBounds(30, 433, 265, 19);
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
		
		lblCostoTotal = new JLabel("Costo Total:");
		lblCostoTotal.setBounds(30, 284, 99, 22);
		getContentPane().add(lblCostoTotal);
		
		textCosto = new JTextField();
		textCosto.setEditable(false);
		textCosto.setBorder(BorderFactory.createLineBorder(Color.black));
		textCosto.setBounds(134, 284, 93, 23);
		getContentPane().add(textCosto);
		getContentPane().add(lblActividadesDeportivas);
		
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setBounds(30, 458, 401, 108);
		getContentPane().add(scrollPane_2);
		
		table = new JTable();
		scrollPane_2.setViewportView(table);
		
		lblCategorias = new JLabel("Categorias: ");
		lblCategorias.setBounds(30, 318, 265, 19);
		getContentPane().add(lblCategorias);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(29, 349, 369, 74);
		getContentPane().add(scrollPane);
		
		list = new JList<String>();
		scrollPane.setViewportView(list);
		
		
		JButton btnBsqueda = new JButton("Búsqueda");
		btnBsqueda.setBounds(30, 578, 117, 25);
		getContentPane().add(btnBsqueda);
		btnBsqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean es=activar();
				if (es) {
					String val=String.valueOf(table.getValueAt(table.getSelectedRow(), 0));	
					Principal instancia = Principal.getInstance();
					instancia.consultaActividadDeportivaInternalFrame.cargarCombo(val);
					instancia.consultaActividadDeportivaInternalFrame.cargarDatosActividad(val);
					instancia.consultaActividadDeportivaInternalFrame.setVisible(true);
					
				}
			}
		});
		
		
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(314, 578, 117, 25);
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
		date = dat.getFechaIni();
        String strDateini = dateFormat.format(date);
        txtFechaIni.setText(strDateini);   
        date = dat.getFechaFin();
        String strDatefin = dateFormat.format(date);
        textFechafin.setText(strDatefin);   
        date = dat.getFechaAlta(); 
        String strDatealta = dateFormat.format(date);
        txtFechaAlta.setText(strDatealta); 
        textCosto.setText(dat.getCosto().toString());
        
        DefaultTableModel modelo;
        modelo= new DefaultTableModel() {
        	@Override 
        	public boolean isCellEditable (int row, int colunm) {
        		return false;
        	}
        }
        ;
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
        
        DefaultListModel<String> modelolist;
        modelolist= new DefaultListModel<String>();
    	Set<String> li=dat.getCategorias();
    	for (Iterator<String> iter=li.iterator(); iter.hasNext(); ) {
    		modelolist.addElement(iter.next());
    	}

    	list.setModel(modelolist);
        
        
        
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
	public void cargarboxcupo(String cupo) {
		DefaultComboBoxModel<String> modelo2;
	    modelo2= new DefaultComboBoxModel<String>();
       modelo2.setSelectedItem(cupo);
       comboBoxCuponeras.setModel(modelo2);
	}
	
	
	
	
	
	
	
 private void limpiarFormulario() {
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtDescuento.setText("");
        txtFechaIni.setText("");
        textFechafin.setText("");
        txtFechaAlta.setText("");
        textCosto.setText("");
        DefaultComboBoxModel<String> modelo2=new DefaultComboBoxModel<String>();
        comboBoxCuponeras.setModel(modelo2);
        DefaultTableModel modelo1= new DefaultTableModel();
        table.setModel(modelo1);
        DefaultListModel<String> modelolist2= new DefaultListModel<String>();
        list.setModel(modelolist2);
    }
}
	
	
	