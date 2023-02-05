package exceptions;

public class ZoneAlreadyExists extends Exception{

	private static final long serialVersionUID = 1L;

	public ZoneAlreadyExists() {
		super("Zona já cadastrada.");
	}

}
