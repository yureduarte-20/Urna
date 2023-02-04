package controllers;

import java.awt.Point;
import java.util.Random;
import dominio.BoardMember;
import dominio.Candidate;
import dominio.Party;
import dominio.Technician;
import dominio.Voter;
import exceptions.NotEligible;
import exceptions.PartyAlreadyExists;
import exceptions.PartyNotFound;
import exceptions.UserAlreadyExists;
import exceptions.UserNotFound;
import dominio.Session;
import dominio.Zone;


public class RegisterController {
	static Random generator = new Random();

	public static Voter registerVoter(int id, String password, String name, Point point) throws UserAlreadyExists {
		Voter newVoter = new Voter(id, password, name, point);
		for (var voter : Voter.voters) {
			if (voter.getId() == newVoter.getId()) {
				throw new UserAlreadyExists();
			}
		}
		registerVoterInBestZoneAndSection(newVoter);

		Voter.voters.add(newVoter);

		return newVoter;
	}
	
	private static Zone selectBestZone(Point point) {
		var zones = Zone.getZones();
		int length = zones.size() - 1;

		return zones.get(generator.nextInt(length <= 0 ? 1 : length));
	}

	private static Session selectBestSession(Zone zone, Point point) {
		var sessions = zone.getSessions();
		int length = sessions.size() - 1;
		return sessions.get(generator.nextInt(length <= 0 ? 1 : length));
	}

	private static Voter registerVoterInBestZoneAndSection(Voter voter) {
		var zone = selectBestZone(voter.getPoint());
		var session = selectBestSession(zone, voter.getPoint());
		voter.setSession(session);
		return voter;
	}
	
	
	
	
	
	

	public static BoardMember createMember(int id, Technician tech) throws UserNotFound {
		return BoardMember.createMember(id, tech);
	}

	public static Candidate saveCandidate(int id, Technician tech, String fictitiousName, int partyNumber) throws NotEligible, UserNotFound, PartyNotFound {
		Party party = PartyController.getByNumber(partyNumber);

		return Candidate.createCandidate(id, tech, fictitiousName, party);
	}
	
	public static Party saveParty(String name, int number, String acronym) throws PartyAlreadyExists {
		Party party = new Party(name, acronym, number);
		
		if(!Party.parties.contains(party)) {
			Party.parties.add(party);
			return party;
		}
		
		throw new PartyAlreadyExists();
	}

	
}
