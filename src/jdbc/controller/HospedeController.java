package jdbc.controller;

import java.sql.Connection;
import java.util.List;

import jdb.factory.ConnectionFactory;
import jdbc.dao.HospedeDao;
import jdbc.models.Hospede;

public class HospedeController {
	
	private HospedeDao hospedeDao;
	
	public HospedeController() {
		Connection connection = new ConnectionFactory().recuperarConexao();
		this.hospedeDao = new HospedeDao(connection);
	}
	
	public void salvar(Hospede hospede) {
		this.hospedeDao.salvar(hospede);
	}

	public List<Hospede> listar(){
		return this.hospedeDao.listar();
	}
	
	public List<Hospede> listarPorSobrenome(String sobrenome){
		return this.hospedeDao.listarPorSobrenome(sobrenome);
	}
	
	public Hospede buscarPorId(Integer id) {
		return this.hospedeDao.buscarPorId(id);
	}
	
	public void deletarPorId(Integer id) {
		this.hospedeDao.deletaPorId(id);
	}
}
