package jdbc.models;

import java.math.BigDecimal;
import java.sql.Date;

public class Reserva {
	
	private Integer id;
	private Date dataEntrada;
	private Date dataSaida;
	private BigDecimal valor;
	private String formaPagamento;
	
	public Reserva(Integer id, Date dataEntrada, Date dataSaida, BigDecimal valor, String formaPagamento) {
		this.id = id;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.valor = valor;
		this.formaPagamento = formaPagamento;
	}

	public Reserva(Date dataEntrada, Date dataSaida, BigDecimal valor, String formaPagamento) {
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.valor = valor;
		this.formaPagamento = formaPagamento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "reserva: id: " + id +
				" data de entrada: " + getDataEntrada().toString() +
				" data de saida: " + getDataSaida().toString() +
				" valor: " + getValor().toString() +
				" forma de pagamento: " + getFormaPagamento();
	}
	
	


	
	
	
	
	

}
