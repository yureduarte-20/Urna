package exceptions;

public class PartyNotFound extends Exception{

	private static final long serialVersionUID = 1L;

	public PartyNotFound() {
		super("O Partido não foi encontrado");
	}

}
