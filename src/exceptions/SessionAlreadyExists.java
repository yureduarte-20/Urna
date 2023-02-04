package exceptions;

public class SessionAlreadyExists extends Exception{

	private static final long serialVersionUID = 1L;
	
	public SessionAlreadyExists() {
		super("Sessão já cadastrada.");
	}
	
}
