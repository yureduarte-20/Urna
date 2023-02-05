package exceptions;

public class ElectionStillActive extends Exception{

	private static final long serialVersionUID = 1L;

	public ElectionStillActive() {
		super("Você não pode abrir uma eleição enquanto uma está em aberto");
	}
	
}
