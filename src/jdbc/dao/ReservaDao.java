package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import jdbc.models.Reserva;

public class ReservaDao {
	private Connection connection;

	
	public ReservaDao(Connection connection) {
		this.connection = connection;
	}
	
	public List<Reserva> listar() {
		List<Reserva> reservas = new ArrayList<>();
		
		try {
			String sql = "SELECT id, data_entrada, data_saida, valor, forma_pagamento FROM reservas";
			
			try(PreparedStatement pstm = connection.prepareStatement(sql)){
				pstm.execute();
				
				transformaResultSetEmReserva(reservas, pstm);
				
			}
			
			return reservas;			
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void salvar(Reserva reserva){
		try{
			String sql = "INSERT INTO reservas(data_entrada, data_saida, valor, forma_pagamento) VALUES (?,?,?,?)";
			
			try(PreparedStatement pstm = connection.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS )){
				pstm.setDate(1, reserva.getDataEntrada());
				pstm.setDate(2, reserva.getDataSaida());
				pstm.setBigDecimal(3, reserva.getValor());
				pstm.setString(4, reserva.getFormaPagamento());
				
				pstm.execute();
				
				try(ResultSet rst = pstm.getGeneratedKeys()){
					while(rst.next()) {
						reserva.setId(rst.getInt(1));
					}
				}
			}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public Reserva buscarPorId(Integer id) {
		
		try {
			String sql = "SELECT id, data_entrada, data_saida, valor, forma_pagamento FROM reservas WHERE id=?";
			
			Reserva reserva = null;
			
			try(PreparedStatement pstm = connection.prepareStatement(sql)){
				pstm.setInt(1, id);
				pstm.execute();
				
				try(ResultSet rst = pstm.getResultSet()){
					while(rst.next()) {
						reserva = new Reserva(rst.getInt(1), rst.getDate(2), rst.getDate(3), rst.getBigDecimal(4), rst.getString(5));
					}
				}
			}
			return reserva;			
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void editaPorId(Integer id, Reserva reserva) {
		try {
			String sql = "UPDATE reservas SET data_entrada = ?, data_saida = ?, valor = ?, forma_pagamento = ? WHERE id = ?";
			
			try(PreparedStatement pstm = connection.prepareStatement(sql)){
				pstm.setDate(1, reserva.getDataEntrada());
				pstm.setDate(2, reserva.getDataSaida());
				pstm.setBigDecimal(3, reserva.getValor());
				pstm.setString(4, reserva.getFormaPagamento());
				pstm.setInt(5, id);
				pstm.execute();
			}
			
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void deletaPorId(Integer id){
		try {
			String sql = "DELETE FROM reservas WHERE id=?";
			
			try(PreparedStatement pstm = connection.prepareStatement(sql)){
				pstm.setInt(1, id);
				pstm.execute();
			}
			
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void transformaResultSetEmReserva(List<Reserva> reservas, PreparedStatement pstm) throws SQLException {
		try(ResultSet rst = pstm.getResultSet()){
			while(rst.next()) {
				Reserva reserva = new Reserva(rst.getInt(1), rst.getDate(2), rst.getDate(3), rst.getBigDecimal(4), rst.getString(5));
				reservas.add(reserva);
			}
		}
	}
}
