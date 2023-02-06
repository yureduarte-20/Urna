package dominio;

import java.awt.Point;
import java.util.Collections;
import java.util.Comparator;

public class Session {

	private int sessionNumber;
	private Point address = new Point();
	
	public Session(int sessionNumber, Point address) {
		super();
		this.sessionNumber = sessionNumber;
		this.address = address;

	}

	public int getSessionNumber() {
		return sessionNumber;
	}

	public void setSessionNumber(int sessionNumber) {
		this.sessionNumber = sessionNumber;
	}

	public Point getAddress() {
		return address;
	}

	public void setAddress(Point address) {
		this.address = address;
	}

	private static int euclidianDistance(Point p, Point q) {
		int x1 = p.x;
		int y1 = p.y;

		int x2 = q.x;
		int y2 = q.y;

		return (int)Math.sqrt( Math.pow( x2 - x1 ,2) + Math.pow( y2 - y1 ,2) );
	}

	@Override
	public boolean equals(Object obj) {
		return sessionNumber == ((Session) obj).sessionNumber;
	}

	public static Session selectBestSession(Zone zone, Point point)  {
		var sessions = zone.getSessions();
		return Collections.min(sessions, new Comparator<Session>() {
			@Override
			public int compare(Session s1, Session s2){
				int euclidianS1 = euclidianDistance(s1.getAddress(), point);
				int euclidianS2 = euclidianDistance(s2.getAddress(), point);
				return euclidianS1 <  euclidianS2 ? -1 : 1;
			}
		});
	}

}
