package dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import exceptions.UserNotFound;

public class BoardMember extends Voter{

	public static List<BoardMember> members = new ArrayList<>();


	public BoardMember(Voter voter) {
		super(voter.getId(), voter.getPassword(), voter.getName(), voter.getSession());
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

	public static List<BoardMember>  getMembers(){
		return members;
	}

}
