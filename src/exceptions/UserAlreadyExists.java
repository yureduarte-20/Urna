package exceptions;

public class UserAlreadyExists extends Exception{

	private static final long serialVersionUID = 1L;

	public UserAlreadyExists() {
		super("Usuário e/ou senha inválido(s)");
	}
	
}
