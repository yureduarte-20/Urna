package controllers;

import java.awt.Point;
import java.util.Random;

import dominio.BoardMember;
import dominio.Candidate;
import dominio.Election;
import dominio.ElectoralPlate;
import dominio.Party;
import dominio.Session;
import dominio.Shift;
import dominio.Technician;
import dominio.Vote;
import dominio.Voter;
import dominio.Zone;
import exceptions.ElectionAlreadyExists;
import exceptions.ElectionNotFound;
import exceptions.ElectionStillActive;
import exceptions.NotEligible;
import exceptions.PartyAlreadyExists;
import exceptions.PartyNotFound;
import exceptions.SessionAlreadyExists;
import exceptions.ShiftExceededLimit;
import exceptions.ShiftNotFound;
import exceptions.ShiftStillActive;
import exceptions.UserAlreadyExists;
import exceptions.UserNotFound;
import exceptions.ZoneAlreadyExists;
import exceptions.ZoneNotFound;


public class RegisterController {
	static Random generator = new Random();

	public static Voter registerVoter(int id, String password, String name, Point point) throws UserAlreadyExists{
		
		if( Voter.voters.contains( new Voter(id, password, name, null) ) )
			throw new UserAlreadyExists();

		var zone = Zone.selectBestZone(point);
		Session session = Session.selectBestSession(zone, point);
		Voter newVoter = new Voter(id, password, name, session);
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

	public static ElectoralPlate saveEletroralPlate( int principalId, int viceId, String number ) throws UserNotFound {
		System.out.println(Candidate.getCandidate(viceId).toString());
		System.out.println(Candidate.getCandidate(principalId).toString());
		var principal = Candidate.getCandidate(principalId);
		var vice = Candidate.getCandidate(viceId);
		var el = new ElectoralPlate(principal, vice, number);
		ElectoralPlate.getElectoralPlate().add(el);
		return el;
	}

	public static void saveElection(String identification ) throws ElectionAlreadyExists, ElectionStillActive{
		if(Election.getEletions().isEmpty()) {
			Election e = new Election(identification);
			Election.addElection(e);
			return;
		}

		for(var ele : Election.getEletions()) {
			if(ele.isActive()) {
				throw new ElectionStillActive();
			}
		}
		Election e = new Election(identification);
		Election.addElection(e);
	}

	public static void saveShift(String electionId, Shift s) throws ElectionNotFound, ShiftExceededLimit, ShiftStillActive {
		var el = Election.getElection(electionId);
		el.addShift(s);
	}

	public static void saveVote(Vote v) throws ElectionNotFound, ShiftNotFound {
		var el = Election.getActiveElection();
		var shift = el.getActiveShift();
		shift.addVote(v);
	}

}
