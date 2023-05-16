package jdbc.models;

import java.sql.Date;

public class Hospede {
	
	private Integer id;
	private String nome;
	private String sobrenome;
	private Date dataNascimento;
	private String nacionalidade;
	private String telefone;
	private Reserva reserva;
	
	public Hospede(Integer id, String nome, String sobrenome, Date dataNascimento, String nacionalidade,
			String telefone, Reserva reserva) {
		
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
		this.nacionalidade = nacionalidade;
		this.telefone = telefone;
		this.reserva = reserva;
	}

	public Hospede(String nome, String sobrenome, Date dataNascimento, String nacionalidade, String telefone,
			Reserva reserva) {
		
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
		this.nacionalidade = nacionalidade;
		this.telefone = telefone;
		this.reserva = reserva;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public Reserva getReserva() {
		return reserva;
	}

	@Override
	public String toString() {
		return "Hospede [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", dataNascimento="
				+ dataNascimento + ", nacionalidade=" + nacionalidade + ", telefone=" + telefone + ", reserva="
				+ reserva + "]";
	}
	
	
	
	
	
	
	
	

}
