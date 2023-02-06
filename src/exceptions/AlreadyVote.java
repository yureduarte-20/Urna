package exceptions;

public class AlreadyVote extends Exception{

	private static final long serialVersionUID = 1L;

	public AlreadyVote() {
		super("O usuário já votou!");
	}

}
