package controllers;

import java.util.Random;

import dominio.Session;
import dominio.Zone;
import exceptions.SessionNotFound;
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

