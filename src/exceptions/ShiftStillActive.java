package exceptions;

public class ShiftStillActive extends Exception{

	private static final long serialVersionUID = 1L;

	public ShiftStillActive() {
		super("Você não pode abrir um turno enquanto outro está em aberto");
	}
	
}
