package jdbc.controller;

import java.sql.Connection;
import java.util.List;

import jdb.factory.ConnectionFactory;
import jdbc.dao.ReservaDao;
import jdbc.models.Reserva;

public class ReservaController {
	
	private ReservaDao reservaDao;
	
	public ReservaController() {
		Connection connection = new ConnectionFactory().recuperarConexao();
		this.reservaDao = new ReservaDao(connection);
	}
	
	public void salvar(Reserva reserva) {
		this.reservaDao.salvar(reserva);
	}
	
	public Reserva buscarPorId(Integer id) {
		return this.reservaDao.buscarPorId(id);
	}
	
	public List<Reserva> listar(){
		return this.reservaDao.listar();
	}
	
	public void deletar(Integer id) {
		this.reservaDao.deletaPorId(id);
	}

}
