package exceptions;

public class SessionNotFound extends Exception{

	private static final long serialVersionUID = 1L;

	public SessionNotFound() {
		super("Sessão não encontrada.");
	}
	public SessionNotFound(String msg) {
		super(msg);
	}

}
