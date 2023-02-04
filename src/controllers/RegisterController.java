package controllers;

import java.awt.Point;

import dominio.BoardMember;
import dominio.Candidate;
import dominio.Party;
import dominio.Technician;
import dominio.Voter;
import exceptions.NotEligible;
import exceptions.PartyNotFound;
import exceptions.UserAlreadyExists;
import exceptions.UserNotFound;

public class RegisterController {
	
	
	
	public static Voter registerVoter(int id, String password, String name, Point local) throws UserAlreadyExists {
		Voter newVoter = new Voter(id, password, name);
		
		if(Voter.voters.contains(newVoter))
			throw new UserAlreadyExists();
		
		Voter.voters.add(newVoter);
		
		return newVoter;
	}
	
	public static BoardMember createMember(int id, Technician tech) throws UserNotFound {
		return BoardMember.createMember(id, tech);
	}
	
	
	public static Candidate saveCandidate(int id, Technician tech, String fictitiousName, int partyNumber) throws NotEligible, UserNotFound, PartyNotFound {
		Party party = PartyController.getByNumber(partyNumber);
		
		return Candidate.createCandidate(id, tech, fictitiousName, party);
	}
	
	
}
