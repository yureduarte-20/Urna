package exceptions;

public class UserNotFound extends Exception{

	private static final long serialVersionUID = 1L;

	public UserNotFound() {
		super("Usuário não encontrado");
	}

}
