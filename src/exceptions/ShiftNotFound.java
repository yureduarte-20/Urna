package exceptions;

public class ShiftNotFound extends Exception{

	private static final long serialVersionUID = 1L;

	public ShiftNotFound() {
		super("Turno não encontrado");
	}
	
}
