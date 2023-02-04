package dominio;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import exceptions.SessionAlreadyExists;

public class Zone {
	private static int count = 0;	
	private int zoneNumber;
	private Point address = new Point();
	private List<Session> sessions = new ArrayList<>();
	
	
	public Zone(Point address) {
		super();
		this.address = address;
	}

	static List<Zone> zones = new ArrayList<>();
	public static Zone bestZoneAvailable(Point point) {
		return null;
	}
	
	public static void addZone(Zone zone) {
		zone.setZoneNumber(count++);
		zones.add(zone);
	}
	
	public void addSession(Session session) throws SessionAlreadyExists {
		for( Session _session : this.sessions) {
			if( _session.getSessionNumber() == session.getSessionNumber())
				throw new SessionAlreadyExists();
		}
		this.sessions.add(session);
	}

	public int getZoneNumber() {
		return zoneNumber;
	}

	public void setZoneNumber(int zoneNumber) {
		this.zoneNumber = zoneNumber;
	}

	public Point getAddress() {
		return address;
	}

	public void setAddress(Point address) {
		this.address = address;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	public static List<Zone> getZones() {
		return zones;
	}

	public static void setZones(List<Zone> zones) {
		Zone.zones = zones;
	}
	
	
		 
}
