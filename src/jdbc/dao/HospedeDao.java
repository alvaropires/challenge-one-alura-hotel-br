package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import jdbc.models.Hospede;

public class HospedeDao {
	
	private Connection connection;
	private ReservaDao reservaDao;
	
	
	public HospedeDao(Connection connection) {
		this.connection = connection;
		this.reservaDao = new ReservaDao(connection);
	}
	
	public List<Hospede> listar(){
		
		try {
			String sql = "SELECT h.id, h.nome, h.sobrenome, h.data_nascimento, h.nacionalidade, h.telefone, h.reserva_id FROM hospedes h";		
			List<Hospede> hospedes = new ArrayList<>();
			
			try(PreparedStatement pstm = connection.prepareStatement(sql)){
				pstm.execute();
				
				try(ResultSet rst = pstm.getResultSet()){
					
					while(rst.next()) {
						Hospede hospede = new Hospede(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getDate(4), rst.getString(5),
								rst.getString(6), reservaDao.buscarPorId(rst.getInt(7)));
						hospedes.add(hospede);						
					}
				}
			}
			return hospedes;
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void salvar(Hospede hospede) {
		try {
			String sql = "INSERT INTO hospedes(nome, sobrenome, data_nascimento, nacionalidade, telefone, reserva_id) VALUES (?,?,?,?,?,?)";
			
			try(PreparedStatement pstm = connection.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS)){
				pstm.setString(1, hospede.getNome());
				pstm.setString(2, hospede.getSobrenome());
				pstm.setDate(3, hospede.getDataNascimento());
				pstm.setString(4, hospede.getNacionalidade());
				pstm.setString(5, hospede.getTelefone());
				pstm.setInt(6, hospede.getReserva().getId());
				pstm.execute();
				
				try(ResultSet rst = pstm.getGeneratedKeys()){
					while(rst.next()) {
						hospede.setId(rst.getInt(1));
					}
				}
			}
			
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Hospede buscarPorId(Integer id) {
		try {
			String sql = "SELECT h.id, h.nome, h.sobrenome, h.data_nascimento, h.nacionalidade, h.telefone, h.reserva_id FROM hospedes h WHERE id=?";
			
			Hospede hospede = null;
			
			try(PreparedStatement pstm = connection.prepareStatement(sql)){
				pstm.setInt(1, id);
				pstm.execute();
				
				try(ResultSet rst = pstm.getResultSet()){
					while(rst.next()) {
						hospede = new Hospede(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getDate(4), rst.getString(5), rst.getString(6),
								reservaDao.buscarPorId(rst.getInt(7)));
					}
				}
			}
			return hospede;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void deletaPorId(Integer id) {
		try {
			String sql = "DELETE FROM hospedes WHERE id=?";
			
			try(PreparedStatement pstm = connection.prepareStatement(sql)){
				pstm.setInt(1, id);
				pstm.execute();
			}
			
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}




















