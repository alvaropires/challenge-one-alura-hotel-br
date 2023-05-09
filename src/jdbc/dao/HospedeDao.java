package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.models.Hospede;
import jdbc.models.Reserva;

public class HospedeDao {
	
	private Connection connection;
	
	public HospedeDao(Connection connection) {
		this.connection = connection;
	}
	
	public List<Hospede> listar(){
		
		try {
			String sql = "SELECT id, nome, sobrenome, data_nascimento, nacionalidade, telefone, reserva_id FROM hospedes";
			
			List<Hospede> hospedes = new ArrayList<>();
			
			try(PreparedStatement pstm = connection.prepareStatement(sql)){
				pstm.execute();
				
				try(ResultSet rst = pstm.getResultSet()){
					Hospede hospede = new Hospede(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getDate(4), rst.getString(5),
							rst.getString(6), (Reserva) rst.getObject(7));
					hospedes.add(hospede);
				}
				
			}
			return hospedes;
			
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
		
	}

}
