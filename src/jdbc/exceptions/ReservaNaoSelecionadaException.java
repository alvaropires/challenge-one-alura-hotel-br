package jdbc.exceptions;

public class ReservaNaoSelecionadaException extends RuntimeException {
	public ReservaNaoSelecionadaException() {
		super("Nenhuma reserva foi selecionada.");
	}

}
