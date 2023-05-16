package jdbc.exceptions;

public class HospedeNaoSelecionadoException extends RuntimeException {
	public HospedeNaoSelecionadoException() {
		super("Nenhum hospede foi selecionado.");
	}

}
