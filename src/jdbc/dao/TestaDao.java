package jdbc.dao;

import java.sql.Connection;
import java.sql.SQLException;

import jdb.factory.ConnectionFactory;

public class TestaDao {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection con = new ConnectionFactory().recuperarConexao();
		
		ReservaDao reservasDao = new ReservaDao(con);
		
//		List<Reservas> reservasAntes = reservasDao.listar();
//		
//		Reservas novaReserva = new Reservas(new Date(2023,05,01), new Date(2023,05,03), new BigDecimal("180"), "cartão de crédito");
//		reservasDao.salvar(novaReserva);
//		
//		List<Reservas> reservasDepois = reservasDao.listar();
//		
//		reservasAntes.forEach(reserva-> System.out.println(reserva));
//		reservasDepois.forEach(reserva-> System.out.println(reserva));
		
		reservasDao.deletaPorId(5);
		reservasDao.listar().forEach(reserva->System.out.println(reserva));
		

	}

}
