package exceptions;

public class NotEligible extends Exception{

	private static final long serialVersionUID = 1L;

	public NotEligible() {
		super("O eleitor não está elegível!");
	}

}
