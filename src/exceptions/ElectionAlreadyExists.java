package exceptions;

public class ElectionAlreadyExists extends Exception{

	private static final long serialVersionUID = 1L;

	public ElectionAlreadyExists() {
		super("Eleição já cadastrada.");
	}

}
