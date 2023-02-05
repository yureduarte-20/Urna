package dominio;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import exceptions.SessionAlreadyExists;
import exceptions.ZoneAlreadyExists;
import exceptions.ZoneNotFound;

public class Zone {
	private static int count = 0;
	private int zoneNumber;
	private Point address = new Point();
	private List<Session> sessions = new ArrayList<>();

	public Zone(int zoneNumber,Point address) {
		super();
		this.zoneNumber = zoneNumber;
		this.address = address;
	}

	public static List<Zone> zones = new ArrayList<>();

	public static void addZone(Zone zone) throws ZoneAlreadyExists {
		for(var _zone : Zone.zones) {
			if(zone.getZoneNumber() == _zone.getZoneNumber())
				throw new ZoneAlreadyExists();
			
		}
		zones.add(zone);
	}
	public static Zone getZone(int zoneId) throws ZoneNotFound{
		for(var zone : Zone.zones) {
			if(zone.getZoneNumber() == zoneId) {
				return zone;
			}
		}
		throw new ZoneNotFound();
	}
	
	
	
	public void addSession(Session session) throws SessionAlreadyExists {
		for (Session _session : this.sessions) {
			if (_session.getSessionNumber() == session.getSessionNumber())
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

	private static int euclidianDistance(Point p, Point q) {
		int x1 = p.x;
		int y1 = p.y;

		int x2 = q.x;
		int y2 = q.y;

		return (int)Math.sqrt( Math.pow( x2 - x1 ,2) + Math.pow( y2 - y1 ,2) );
	}

	public static Zone selectBestZone(Point point) {
		var sessions = Zone.zones;
		return Collections.min(sessions, new Comparator<Zone>() {
			@Override
			public int compare(Zone s1, Zone s2) {
				int euclidianS1 = euclidianDistance(s1.getAddress(), point);
				int euclidianS2 = euclidianDistance(s2.getAddress(), point);
				return euclidianS1 < euclidianS2 ? -1 : 1;
			}
		});
	}
}
