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


public class DeleteController {
	static Random generator = new Random();
	
	public static void deleteSessionInZone(int zoneId, int sessaoId) throws ZoneNotFound, SessionNotFound {
		var zone = Zone.getZone(zoneId);
		Session session = null;
		for(var _session : zone.getSessions()) {
			if(sessaoId == _session.getSessionNumber()) {
				session = _session;
			}
		}
		if(session == null)
			throw new SessionNotFound();
		zone.getSessions().remove(session);
	}
	
 }

