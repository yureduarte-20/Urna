package dominio;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Zone {

	private int sessionNumber;
	private Point address = new Point();
	private List<Session> sessions = new ArrayList<>();
	
	public static Zone bestZoneAvailable(Point point) {
		return null;
	}
	
	public boolean addSession(Session session) {
		for( Session _session : this.sessions) {
			if( _session.getSessionNumber() == session.getSessionNumber())
				return false;
		}
		return this.sessions.add(session);
	}}
