package exceptions;

public class ElectionNotFound extends Exception{

	private static final long serialVersionUID = 1L;

	public ElectionNotFound() {
		super("Eleição não encontrado");
	}
	
}
