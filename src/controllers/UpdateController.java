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


public class UpdateController {
	static Random generator = new Random();
	
	public static Zone getZone(int zoneId) throws ZoneNotFound{
		return Zone.getZone(zoneId);
	}
	
	public static Session updateSession(int newZoneNumber, int oldZoneNumber, int sessionId ,Point point) throws ZoneNotFound, SessionNotFound {
		Zone target = Zone.getZone(newZoneNumber);
		Zone oldZone = Zone.getZone(oldZoneNumber);
		Session session = null;
		for(var _session : oldZone.getSessions()) {
			if(_session.getSessionNumber() == sessionId) {
				session = _session;
			}
		}
		if(session == null)
			throw new SessionNotFound();
		if(newZoneNumber != oldZoneNumber) {
			oldZone.getSessions().remove(session);
			target.getSessions().add(session);
		}
		session.setAddress(point);
		return session;
	}
	
	public static boolean existsZone(int zoneId) throws ZoneNotFound {
		var zone = Zone.getZone(zoneId);
		return zone != null;
	}
	
	public static Session getSessionInZone(int zoneId, int sessionId ) throws ZoneNotFound, SessionNotFound {
		var zone = Zone.getZone(zoneId);
		for(var session : zone.getSessions() ) {
			if(sessionId == session.getSessionNumber())
				return session;
		}
		throw new SessionNotFound();
	}
	
	
	public static Voter getVoter(int id) throws UserNotFound {
		for(var voter : Voter.voters) {
			if(voter.getId() == id)
				return voter;
		}
		throw new UserNotFound();
	}
	public static Voter updateVoter(int id, String name, String password, Point point) throws UserNotFound {
		var voter = Voter.getVoter(id);
		voter.setPoint(point);
		voter.setPassword(password);
		voter.setName(name);
		var zone = Zone.selectBestZone(point);
		voter.setSession(Session.selectBestSession(zone, point));
		return voter;
	}
	
 }

