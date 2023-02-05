package controllers;

import java.awt.Point;
import java.util.Random;

import dominio.BoardMember;
import dominio.Candidate;
import dominio.Party;
import dominio.Session;
import dominio.Technician;
import dominio.Voter;
import dominio.Zone;
import exceptions.NotEligible;
import exceptions.PartyAlreadyExists;
import exceptions.PartyNotFound;
import exceptions.SessionAlreadyExists;
import exceptions.SessionNotFound;
import exceptions.UserAlreadyExists;
import exceptions.UserNotFound;
import exceptions.ZoneAlreadyExists;
import exceptions.ZoneNotFound;


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

	private static Voter registerVoterInBestZoneAndSection(Voter voter) {
		var zone = Zone.selectBestZone(voter.getPoint());
		var session = Session.selectBestSession(zone, voter.getPoint());
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

	public static Technician saveTechnician(Technician tech) throws UserAlreadyExists {
		for( var _tech : Technician.technical) {
			if(_tech.getId() == tech.getId()) {
				throw new UserAlreadyExists();
			}
		}
		Technician.technical.add(tech);
		return tech;
	}
	
	public static Session saveSession(int zoneNumber, Session session) throws ZoneNotFound, SessionAlreadyExists {
		Zone target = null;
		for(var zone : Zone.zones) {
			if(zone.getZoneNumber() == zoneNumber) {
				target = zone;
				break;
			}	
		}
		if(target == null)
			throw new ZoneNotFound();
		target.addSession(session);
		return session;
	}
	
	
	public static Zone saveZone(Zone zone) throws ZoneAlreadyExists {
		for(var _zone : Zone.zones) {
			if(_zone.getZoneNumber() == zone.getZoneNumber()) {
				throw new ZoneAlreadyExists();
			}
		}
		Zone.zones.add(zone);
		return zone;
	}
	
}
