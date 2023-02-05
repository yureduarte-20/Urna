package exceptions;

public class UserInvalid extends Exception{

	private static final long serialVersionUID = 1L;

	public UserInvalid() {
		super("Usuário e/ou senha inválido(s)");
	}

}
