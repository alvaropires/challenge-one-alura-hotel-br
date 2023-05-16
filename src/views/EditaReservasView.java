package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import jdbc.controller.ReservaController;
import jdbc.models.Reserva;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.text.Format;
import java.util.Calendar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Toolkit;
import java.beans.PropertyChangeListener;
import java.math.BigDecimal;
import java.sql.Date;
import java.beans.PropertyChangeEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


@SuppressWarnings("serial")
public class EditaReservasView extends JFrame {

	private JPanel contentPane;
	public static JTextField txtNumeroReserva;
	public static JTextField txtValor;
	public static JDateChooser txtDataE;
	public static JDateChooser txtDataS;
	public static JComboBox<String> txtFormaPagamento;
	int xMouse, yMouse;
	private JLabel lblValorSimbolo; 
	
	private ReservaController reservaController;
	private static Reserva reserva;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditaReservasView frame = new EditaReservasView(reserva);
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
	public EditaReservasView(Reserva reserva) {
		super("Reserva");
		reservaController = new ReservaController();
		EditaReservasView.reserva  = reserva;
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditaReservasView.class.getResource("/imagenes/aH-40px.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 560);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		

		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 910, 560);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(SystemColor.textHighlight);
		separator_1_2.setBounds(68, 195, 289, 2);
		separator_1_2.setBackground(SystemColor.textHighlight);
		panel.add(separator_1_2);
		
		JSeparator separator_1_3 = new JSeparator();
		separator_1_3.setForeground(SystemColor.textHighlight);
		separator_1_3.setBackground(SystemColor.textHighlight);
		separator_1_3.setBounds(68, 453, 289, 2);
		panel.add(separator_1_3);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(SystemColor.textHighlight);
		separator_1_1.setBounds(68, 281, 289, 11);
		separator_1_1.setBackground(SystemColor.textHighlight);
		panel.add(separator_1_1);
		
		txtDataE = new JDateChooser();
		txtDataE.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtDataE.getCalendarButton().setIcon(new ImageIcon(EditaReservasView.class.getResource("/imagenes/icon-reservas.png")));
		txtDataE.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 12));
		txtDataE.setBounds(68, 161, 289, 35);
		txtDataE.getCalendarButton().setBounds(268, 0, 21, 33);
		txtDataE.setBackground(Color.WHITE);
		txtDataE.setBorder(new LineBorder(SystemColor.window));
		txtDataE.setDateFormatString("yyyy-MM-dd");
		txtDataE.setFont(new Font("Roboto", Font.PLAIN, 18));
		txtDataE.setDate(reserva.getDataEntrada());
		panel.add(txtDataE);
		
		lblValorSimbolo = new JLabel("$");
		lblValorSimbolo.setVisible(false);
		lblValorSimbolo.setBounds(169, 332, 17, 25);
		lblValorSimbolo.setForeground(SystemColor.textHighlight);
		lblValorSimbolo.setFont(new Font("Roboto", Font.BOLD, 17));
		
		panel.add(lblValorSimbolo);
		
		JLabel lblNumeroReserva = new JLabel("Nº DE RESERVA");
		lblNumeroReserva.setForeground(Color.GRAY);
		lblNumeroReserva.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNumeroReserva.setBounds(68, 67, 169, 14);
		panel.add(lblNumeroReserva);
		
		JLabel lblCheckIn = new JLabel("DATA DE CHECK IN");
		lblCheckIn.setForeground(SystemColor.textInactiveText);
		lblCheckIn.setBounds(68, 136, 169, 14);
		lblCheckIn.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblCheckIn);
		
		JLabel lblCheckOut = new JLabel("DATA DE CHECK OUT");
		lblCheckOut.setForeground(SystemColor.textInactiveText);
		lblCheckOut.setBounds(68, 221, 187, 14);
		lblCheckOut.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblCheckOut);
		
		txtNumeroReserva = new JTextField();
		txtNumeroReserva.setBackground(SystemColor.text);
		txtNumeroReserva.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumeroReserva.setForeground(Color.BLACK);
		txtNumeroReserva.setEditable(false);
		txtNumeroReserva.setBounds(68, 93, 70, 14);
		txtNumeroReserva.setFont(new Font("Roboto Black", Font.BOLD, 17));
		txtNumeroReserva.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtNumeroReserva.setText(reserva.getId().toString());
		panel.add(txtNumeroReserva);
		txtNumeroReserva.setColumns(10);
		
		txtValor = new JTextField();
		txtValor.setBackground(SystemColor.text);
		txtValor.setHorizontalAlignment(SwingConstants.CENTER);
		txtValor.setForeground(Color.BLACK);
		txtValor.setBounds(68, 328, 84, 33);
		txtValor.setEditable(false);
		txtValor.setFont(new Font("Roboto Black", Font.BOLD, 17));
		txtValor.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtValor.setText(reserva.getValor().toString());
		panel.add(txtValor);
		txtValor.setColumns(10);
		
		txtDataS = new JDateChooser();
		txtDataS.getCalendarButton().setIcon(new ImageIcon(EditaReservasView.class.getResource("/imagenes/icon-reservas.png")));
		txtDataS.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 11));
		txtDataS.setBounds(68, 246, 289, 35);
		txtDataS.getCalendarButton().setBounds(267, 1, 21, 31);
		txtDataS.setBackground(Color.WHITE);
		txtDataS.setFont(new Font("Roboto", Font.PLAIN, 18));
		txtDataS.setDate(reserva.getDataSaida());
		txtDataS.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				//Ativa o evento, após o usuário selecionar as datas, o valor da reserva deve ser calculado
				calcularValor(txtDataE, txtDataS);
			}
		});
		
		txtDataS.setDateFormatString("yyyy-MM-dd");
		txtDataS.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtDataS.setBorder(new LineBorder(new Color(255, 255, 255), 0));
		panel.add(txtDataS);
		
		JLabel lblValor = new JLabel("VALOR DA RESERVA");
		lblValor.setForeground(SystemColor.textInactiveText);
		lblValor.setBounds(72, 303, 196, 14);
		lblValor.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblValor);
		
		txtFormaPagamento = new JComboBox();
		txtFormaPagamento.setBounds(68, 417, 289, 38);
		txtFormaPagamento.setBackground(SystemColor.text);
		txtFormaPagamento.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		txtFormaPagamento.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtFormaPagamento.setModel(new DefaultComboBoxModel(new String[] {"Cartão de Crédito", "Cartão de Débito", "Dinheiro"}));
		txtFormaPagamento.getModel().setSelectedItem(reserva.getFormaPagamento());
		panel.add(txtFormaPagamento);
		
		JLabel lblFormaPago = new JLabel("FORMA DE PAGAMENTO");
		lblFormaPago.setForeground(SystemColor.textInactiveText);
		lblFormaPago.setBounds(68, 382, 213, 24);
		lblFormaPago.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblFormaPago);
		
		JLabel lblTitulo = new JLabel("EDITAR RESERVA");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(78, 25, 289, 42);
		lblTitulo.setForeground(new Color(12, 138, 199));
		lblTitulo.setFont(new Font("Roboto", Font.BOLD, 20));
		panel.add(lblTitulo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(428, 0, 482, 560);
		panel_1.setBackground(new Color(12, 138, 199));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setBounds(197, 68, 104, 107);
		panel_1.add(logo);
		logo.setIcon(new ImageIcon(EditaReservasView.class.getResource("/imagenes/Ha-100px.png")));
		
		JLabel imagenFondo = new JLabel("");
		imagenFondo.setBounds(0, 140, 500, 409);
		panel_1.add(imagenFondo);
		imagenFondo.setBackground(Color.WHITE);
		imagenFondo.setIcon(new ImageIcon(EditaReservasView.class.getResource("/imagenes/reservas-img-3.png")));
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(SystemColor.textHighlight);
		separator_1.setBounds(68, 362, 289, 2);
		separator_1.setBackground(SystemColor.textHighlight);
		panel.add(separator_1);
		
		JPanel btnCancelar = new JPanel();
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Buscar buscar = new Buscar();
				buscar.setVisible(true);
				dispose();
			}						
		});
		btnCancelar.setLayout(null);
		btnCancelar.setBackground(SystemColor.RED);
		btnCancelar.setBounds(238, 493, 122, 35);
		panel.add(btnCancelar);
		btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		JLabel lblCancelar = new JLabel("CANCELAR");
		lblCancelar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancelar.setForeground(Color.WHITE);
		lblCancelar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblCancelar.setBounds(0, 0, 122, 35);
		btnCancelar.add(lblCancelar);
		
		JPanel btnSalvar = new JPanel();
		btnSalvar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (EditaReservasView.txtDataE.getDate() != null && EditaReservasView.txtDataS.getDate() != null) {		
					if(Integer.parseInt(EditaReservasView.txtValor.getText()) > 0) {
						editarReserva();
					}else {
						JOptionPane.showMessageDialog(null, "Data de Check out deve ser posterior a Data de Check in.");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Deve preencher todos os campos.");
				}
			}
		});
		btnSalvar.setLayout(null);
		btnSalvar.setBackground(new Color(12, 138, 199));
		btnSalvar.setBounds(68, 493, 122, 35);
		panel.add(btnSalvar);
		btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		JLabel lblSalvar = new JLabel("SALVAR");
		lblSalvar.setBounds(0, 0, 122, 35);
		btnSalvar.add(lblSalvar);
		lblSalvar.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalvar.setForeground(Color.WHITE);
		lblSalvar.setFont(new Font("Dialog", Font.PLAIN, 18));
		
		JSeparator separator_1_4 = new JSeparator();
		separator_1_4.setForeground(Color.BLACK);
		separator_1_4.setBackground(Color.BLACK);
		separator_1_4.setBounds(68, 119, 289, 2);
		panel.add(separator_1_4);
	}
	    
	    private void editarReserva() {
	    	String dataEntrada = ((JTextField)txtDataE.getDateEditor().getUiComponent()).getText();
	    	String dataSaida = ((JTextField)txtDataS.getDateEditor().getUiComponent()).getText();
	    	Reserva novaReserva = new Reserva(Date.valueOf(dataEntrada),
	    			Date.valueOf(dataSaida),
	    			new BigDecimal(txtValor.getText()),
	    			txtFormaPagamento.getSelectedItem().toString());

	    	reservaController.editaPorId(reserva.getId(), novaReserva);
	    	
	    	JOptionPane.showMessageDialog(contentPane, "Reserva nº " + reserva.getId().toString() + " editada com sucesso!");
	    	
	    	
	    	Buscar buscar = new Buscar();
	    	buscar.populaTabelaReservas();
	    	buscar.populaTabelaHospedes();
	    	buscar.setVisible(true);
	    	dispose();
	    	
	    }
	    
	    private void calcularValor(JDateChooser dataEntrada, JDateChooser dataSaida) {
	    	if(dataEntrada.getDate() != null && dataSaida.getDate() != null) {
	    		Calendar inicio = dataEntrada.getCalendar();
	    		Calendar fim = dataSaida.getCalendar();
	    		int diaria = 180;
	    		int dias = -1;
	    		int valor;
	    		
	    		while(inicio.before(fim)||inicio.equals(fim)) {
	    			dias++;
	    			inicio.add(Calendar.DATE, 1);
	    		}
	    		valor = dias * diaria;
	    		txtValor.setText("" + valor);
	    	}
	    	
	    }
}
