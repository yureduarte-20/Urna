package exceptions;

public class ZoneNotFound extends Exception{

	private static final long serialVersionUID = 1L;

	public ZoneNotFound() {
		super("Zona não encontrada.");
	}

}
