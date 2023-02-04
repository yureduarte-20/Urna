package controllers;

import java.awt.Point;
import java.util.Random;

import dominio.Session;
import dominio.Voter;
import dominio.Zone;
import exceptions.SessionNotFound;
import exceptions.UserAlreadyExists;
import exceptions.ZoneNotFound;

public class RegisterController {
	static Random generator = new Random();
	public static Voter registerVoter(int id, String password, String name, Point point) throws UserAlreadyExists {
		Voter newVoter = new Voter(id, password, name, point);
		for(var voter : Voter.voters) {
			if(voter.getId() == newVoter.getId()) {
				throw new UserAlreadyExists();							
			}
		}
		registerVoterInBestZoneAndSection(newVoter);
		Voter.voters.add(newVoter);
		
		return newVoter;
	}

	private static Zone getZone(int zoneNumber) {
		var zones = Zone.getZones();
		Zone z = null;
		for (Zone zone : zones) {
			if (zone.getZoneNumber() == zoneNumber) {
				return zone;
			}
		}
		return null;
	}
	
	
	private static Zone selectBestZone(Point point) {
		var zones = Zone.getZones();
		int length = zones.size() - 1;
		
		return zones.get( generator.nextInt(length <= 0 ? 1 : length)   );
	}
	
	private static Session selectBestSession(Zone zone, Point point) {
		var sessions = zone.getSessions();
		int length = sessions.size() - 1;
		return sessions.get( generator.nextInt(length <= 0 ? 1 : length)  );
	}

	private static Voter registerVoterInBestZoneAndSection(Voter voter) {
		var zone = selectBestZone(voter.getPoint());
		var session = selectBestSession(zone, voter.getPoint());
		voter.setSession(session);
		//voter.voters.add(voter);
		return voter;
	}

}
