package exceptions;

public class PartyAlreadyExists extends Exception{

	private static final long serialVersionUID = 1L;

	public PartyAlreadyExists() {
		super("O Partido já foi cadastrado");
	}
	
}
