package dominio;

import java.awt.Point;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import exceptions.UserAlreadyExists;
import exceptions.UserNotFound;

public class BoardMember extends Voter{
	
	private static List<BoardMember> members = new ArrayList<>(); 
	
	
	public BoardMember(int id, String password, String name, Point loc) {
		super(id, password, name, loc);
	}
	
	public BoardMember(Voter voter) {
		super(voter.getId(), voter.getPassword(), voter.getName(), voter.getPoint());
	}

	public static BoardMember createMember(int id, Technician tech) throws UserNotFound  {
		Voter voter = null;
		
		for(Voter _voter: Voter.voters) {
			if(_voter.getId() == id)
				voter = _voter;
		}

		if(voter == null)
			throw new UserNotFound();
		
		BoardMember member = new BoardMember(voter);
		members.add(member);
		CadastroMesario.addLog(tech, LocalDate.now());
		
		return member;
	}
	
	
}
