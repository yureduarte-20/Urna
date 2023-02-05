package controllers;

import dominio.BoardMember;
import dominio.Technician;
import dominio.Voter;
import exceptions.UserInvalid;
import exceptions.UserNotFound;

public class Autenticator {
	
	//Singleton
	public static Autenticator auth = new Autenticator();
	
	public static Technician authenticatedTechnician = null;
	public static BoardMember authenticatedBoardMember = null;
	public static Voter authenticatedVoter = null;
	public Technician validateTechnician(int id, String password) throws UserNotFound {
		int index = Technician.technical.indexOf( new Technician(id, password) );
		
		if(index == -1)
			throw new UserNotFound();
		
		return Technician.technical.get(index);
	}
	public Voter validateVoter(int id, String password) throws UserNotFound, UserInvalid {
		Voter  v = null;
		for(var voter : Voter.voters) {
			if(voter.getId() == id)
				v = voter;
		}
		System.out.println(v);
		System.out.println(Voter.voters);
		if(v == null)
			throw new UserNotFound();
		if(!v.getPassword().equals(password) )
			throw new UserInvalid();
		return v;
		
	}
	public BoardMember validateBoardMember(int id, String password) throws UserNotFound, UserInvalid {
		BoardMember b = null;
		for(var voter : BoardMember.getMembers()) {
			if(voter.getId() == id)
				b = voter;
		}
		if(b == null)
			throw new UserNotFound();
		if(!b.getPassword().equals(password)) {
			throw new UserInvalid();
		}
		return b;
	}
	
}
