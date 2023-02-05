package exceptions;

public class ShiftExceededLimit extends Exception{

	private static final long serialVersionUID = 1L;

	public ShiftExceededLimit() {
		super("Estorou limite de dois turnos por eleição.");
	}
	
}
