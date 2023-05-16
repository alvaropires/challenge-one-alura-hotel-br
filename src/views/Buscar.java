package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import jdbc.controller.HospedeController;
import jdbc.controller.ReservaController;
import jdbc.models.Hospede;
import jdbc.models.Reserva;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Buscar extends JFrame {

	private HospedeController hospedeController;
	private ReservaController reservaController;
	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tbHospedes;
	private JTable tbReservas;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloHospedes;
	private JLabel labelAtras;
	private JLabel labelExit;
	int xMouse, yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Buscar frame = new Buscar();
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
	public Buscar() {
		this.hospedeController = new HospedeController();
		this.reservaController = new ReservaController();
		setIconImage(Toolkit.getDefaultToolkit().getImage(Buscar.class.getResource("/imagenes/lOGO-50PX.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(536, 127, 193, 31);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		
		JLabel lblTitulo = new JLabel("SISTEMA DE BUSCA");
		lblTitulo.setForeground(new Color(12, 138, 199));
		lblTitulo.setFont(new Font("Roboto Black", Font.BOLD, 24));
		lblTitulo.setBounds(331, 62, 280, 42);
		contentPane.add(lblTitulo);
		
		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.setBounds(20, 169, 865, 328);
		contentPane.add(panel);
				
		tbReservas = new JTable();
		tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
		modelo = (DefaultTableModel) tbReservas.getModel();
		modelo.addColumn("Numero de Reserva");
		modelo.addColumn("Data Check In");
		modelo.addColumn("Data Check Out");
		modelo.addColumn("Valor");
		modelo.addColumn("Forma de Pago");
		JScrollPane scroll_table = new JScrollPane(tbReservas);
		panel.addTab("Reservas", new ImageIcon(Buscar.class.getResource("/imagenes/reservado.png")), scroll_table, null);
		scroll_table.setVisible(true);
		
		
		tbHospedes = new JTable();
		tbHospedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbHospedes.setFont(new Font("Roboto", Font.PLAIN, 16));
		modeloHospedes = (DefaultTableModel) tbHospedes.getModel();
		modeloHospedes.addColumn("Numero de Hóspede");
		modeloHospedes.addColumn("Nome");
		modeloHospedes.addColumn("Sobrenome");
		modeloHospedes.addColumn("Data de Nascimento");
		modeloHospedes.addColumn("Nacionalidade");
		modeloHospedes.addColumn("Telefone");
		modeloHospedes.addColumn("Numero de Reserva");
		JScrollPane scroll_tableHuespedes = new JScrollPane(tbHospedes);
		panel.addTab("Huéspedes", new ImageIcon(Buscar.class.getResource("/imagenes/pessoas.png")), scroll_tableHuespedes, null);
		scroll_tableHuespedes.setVisible(true);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Buscar.class.getResource("/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(56, 51, 104, 107);
		contentPane.add(lblNewLabel_2);
		
		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			     
			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);
		
		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnAtras.setBackground(Color.white);
			     labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);
		
		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		
		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) { // Quando o usuário passa o mouse sobre o botão, ele muda de cor
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) { //Quando o usuário remove o mouse do botão, ele retornará ao estado original
				 btnexit.setBackground(Color.white);
			     labelExit.setForeground(Color.black);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);
		
		labelExit = new JLabel("X");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		separator_1_2.setBounds(539, 159, 193, 2);
		contentPane.add(separator_1_2);
		
		JPanel btnbuscar = new JPanel();
		btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				limpaModeloTabelas(modelo);
				limpaModeloTabelas(modeloHospedes);
				String conteudoBuscar = txtBuscar.getText();
				
				if(conteudoBuscar.isEmpty()) {
					populaTabelaReservas();
					populaTabelaHospedes();	
				}else if(conteudoBuscar.matches("[0-9]+")) {
					populaTabelaReservasPorId(conteudoBuscar);
					panel.setSelectedIndex(0);;
				}else {
					populaTabelaHospedes(conteudoBuscar);
					panel.setSelectedIndex(1);
				}
				

			}
		});
		btnbuscar.setLayout(null);
		btnbuscar.setBackground(new Color(12, 138, 199));
		btnbuscar.setBounds(748, 125, 122, 35);
		btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnbuscar);
		
		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setBounds(0, 0, 122, 35);
		btnbuscar.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		JPanel btnEditar = new JPanel();
		btnEditar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO implementar o codigo que edita reserva e hospede.
				if(panel.getSelectedIndex() == 0) {

					Reserva reserva = instanciaReservaSelecionada();					
					EditaReservasView editaReserva = new EditaReservasView(reserva);
					editaReserva.setVisible(true);
					dispose();
					
				} else if(panel.getSelectedIndex() == 1) {
					Hospede hospede = instanciaHospedeSelecionado();
					if(JOptionPane.showConfirmDialog(contentPane, "Deseja editar hospede " + hospede.getNome() + "?", "Edita Hospede", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						hospedeController.editaPorId(hospede.getId(), hospede);
						limpaModeloTabelas(modeloHospedes);
						populaTabelaHospedes();
					}
				}
				
			}
			
		});
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(12, 138, 199));
		btnEditar.setBounds(635, 508, 122, 35);
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEditar);
		
		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);
		
		JPanel btnDeletar = new JPanel();
		btnDeletar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(panel.getSelectedIndex() == 0) {
					int id = idDaLinhaSelecionada(tbReservas);
					if(JOptionPane.showConfirmDialog(contentPane, "Deseja excluir a reserva nº " + id + "?", "Excluir Reserva", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						deletaRegistroReserva(id);
						JOptionPane.showInternalMessageDialog(contentPane, "Reserva nº " + id + " excluída com sucesso!");
						limpaModeloTabelas(modelo);
						populaTabelaReservas();
					}
				} else if(panel.getSelectedIndex() == 1) {
					int linha = tbHospedes.getSelectedRow();
					String nome = (String) tbHospedes.getValueAt(linha, 1);
					int id = idDaLinhaSelecionada(tbHospedes);
					if(JOptionPane.showConfirmDialog(contentPane, "Deseja excluir o hospede " + nome + "?", "Excluir Hospede", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						deletaRegistroHospede(id);
						JOptionPane.showInternalMessageDialog(contentPane, "Hospede " + nome + " excluido com sucesso!");
						limpaModeloTabelas(modeloHospedes);
						populaTabelaHospedes();
					}
				}
			}
			
		
		});
		btnDeletar.setLayout(null);
		btnDeletar.setBackground(new Color(12, 138, 199));
		btnDeletar.setBounds(767, 508, 122, 35);
		btnDeletar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnDeletar);
		
		JLabel lblExcluir = new JLabel("DELETAR");
		lblExcluir.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcluir.setForeground(Color.WHITE);
		lblExcluir.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblExcluir.setBounds(0, 0, 122, 35);
		btnDeletar.add(lblExcluir);
		setResizable(false);
		
	}
	
	//Código que permite movimentar a janela pela tela seguindo a posição de "x" e "y"	
	 private void headerMousePressed(java.awt.event.MouseEvent evt) {
	        xMouse = evt.getX();
	        yMouse = evt.getY();
	    }

	    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
	        int x = evt.getXOnScreen();
	        int y = evt.getYOnScreen();
	        this.setLocation(x - xMouse, y - yMouse);
}
	    private Integer idDaLinhaSelecionada(JTable tabela) {
	    	int linha = tabela.getSelectedRow();
	    	int id = (int) tabela.getValueAt(linha, 0);
	    	return id;
	    }
	    
	    private List<Reserva> listarReservas(){
	    	return this.reservaController.listar();
	    }
	    
	    private List<Hospede> listarHospedes(){
	    	return this.hospedeController.listar();
	    }
	    
	    public void populaTabelaReservas() {
	    	List<Reserva> reservas = listarReservas();
	    	
	    	try {
	    		for(Reserva reserva: reservas) {
	    			adicionaModeloReserva(modelo, reserva);
	    		}
	    	}catch(Exception e) {
	    		throw new RuntimeException(e);
	    	}
	    	
	    }
	    
	    private void populaTabelaReservasPorId(String numeroReserva) {
	    	Integer id = Integer.parseInt(numeroReserva);
	    	try {
	    		Reserva reserva = this.reservaController.buscarPorId(id);
	    		adicionaModeloReserva(modelo, reserva);
	    	}catch(NullPointerException e) {
	    		JOptionPane.showInternalMessageDialog(null, "Número de reserva " + id + " não existe. Digite um número de reserva válido!");
	    	}catch(Exception e) {
	    		throw new RuntimeException(e);
	    	}
	    }
	    
	    private void editaTabelaReservasPorId(String numeroReserva, Reserva novaReserva) {
	    	Integer id = Integer.parseInt(numeroReserva);
	    	try {
	    		this.reservaController.editaPorId(id, novaReserva);
	    	}catch(Exception e) {
	    		throw new RuntimeException(e);
	    	}
	    }
	    
	    
	    public void populaTabelaHospedes() {
	    	try {
	    		List<Hospede> hospedes = new ArrayList<>();
	    		hospedes = this.listarHospedes();
	    		for(Hospede hospede: hospedes) {
	    			adicionaModeloHospede(modeloHospedes, hospede);
	    		}
	    		
	    	}catch(Exception e) {
	    		throw new RuntimeException(e);
	    	}
	    	
	    	
	    }
	    
	    public void populaTabelaHospedes(String sobrenome) {
	    	try {
	    		List<Hospede> hospedes = new ArrayList<>();
	    		hospedes = this.hospedeController.listarPorSobrenome(sobrenome);
	    		for(Hospede hospede : hospedes) {
	    			adicionaModeloHospede(modeloHospedes, hospede);			
	    		}
	    		
	    	}catch(Exception e) {
	    		throw new RuntimeException(e);
	    	}
	    }
	    
	    private void deletaRegistroReserva(Integer id) {
	    	this.reservaController.deletar(id);
	    }
	    
	    private void deletaRegistroHospede(Integer id) {
	    	this.hospedeController.deletarPorId(id);
	    }
	    
	    
	    private void limpaModeloTabelas(DefaultTableModel modelo) {
	    	while(modelo.getRowCount()>0) {
	    		modelo.removeRow(0);
	    	}
	    }
	    
	    private void adicionaModeloReserva(DefaultTableModel modelo, Reserva reserva) {
	    	modelo.addRow(new Object[] {
					reserva.getId(),
					reserva.getDataEntrada(),
					reserva.getDataSaida(),
					reserva.getValor(),
					reserva.getFormaPagamento()	
			});
	    }
	    
	    private void adicionaModeloHospede(DefaultTableModel modelo, Hospede hospede) {
	    	modeloHospedes.addRow(new Object[] {
					hospede.getId(),
					hospede.getNome(),
					hospede.getSobrenome(),
					hospede.getDataNascimento(),
					hospede.getNacionalidade(),
					hospede.getTelefone(),
					hospede.getReserva().getId()
			});	 
	    }
	    
	    private Reserva instanciaReservaSelecionada() {
	    	try {
	    		Integer linha = tbReservas.getSelectedRow();
	    		Reserva reserva = new Reserva(
	    				Integer.parseInt(tbReservas.getValueAt(linha, 0).toString()),
	    				transformaStringEmDateSql(tbReservas.getValueAt(linha, 1).toString()),
	    				transformaStringEmDateSql(tbReservas.getValueAt(linha,2).toString()), 
	    				new BigDecimal(tbReservas.getValueAt(linha, 3).toString()), 
	    				tbReservas.getValueAt(linha, 4).toString());
	    		return reserva;	    		
	    	}catch(Exception e) {
	    		throw new RuntimeException(e);
	    	}
	    	
	    }
	    
	    private Hospede instanciaHospedeSelecionado() {
	    	try {
	    		Integer linha = tbHospedes.getSelectedRow();
	    		Hospede hospede = new Hospede(
	    				Integer.parseInt(tbHospedes.getValueAt(linha, 0).toString()),
	    				tbHospedes.getValueAt(linha, 1).toString(),
	    				tbHospedes.getValueAt(linha, 2).toString(),
	    				transformaStringEmDateSql(tbHospedes.getValueAt(linha, 3).toString()),
	    				tbHospedes.getValueAt(linha, 4).toString(),
	    				tbHospedes.getValueAt(linha, 5).toString(),
	    				reservaController.buscarPorId(Integer.parseInt(tbHospedes.getValueAt(linha, 6).toString())));
	    		return hospede;
	    	}catch(Exception e) {
	    		throw new RuntimeException(e);
	    	}
	    }
	    
	    private Date transformaStringEmDateSql(String dataString) {
	    	try{
	    		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
	    		Date data = new Date(fmt.parse(dataString).getTime());
	    		return data;
	    	}catch(Exception e) {
	    		throw new RuntimeException(e);
	    	}
	    }
	    
}
