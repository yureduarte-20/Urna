package controllers;

import java.awt.Point;

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

	public BoardMember validateMember(int id, String password) throws UserNotFound {
		int index = BoardMember.members.indexOf( new BoardMember(id, password, "", new Point(0, 0)) );

		if(index == -1)
			throw new UserNotFound();

		return BoardMember.members.get(index);
	}

	public Object validate(int id, String password) throws UserNotFound {

		try {
			return validateTechnician(id, password);
		} catch (Exception e) { }

		try {
			return validateMember(id, password);
		} catch (Exception e) { }

		throw new UserNotFound();
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

}
