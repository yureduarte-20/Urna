package dominio;

import java.awt.Point;

public class Session {

	public Session(int sessionNumber, Point address) {
		super();
		this.sessionNumber = sessionNumber;
		this.address = address;
	
	}
	private int sessionNumber;
	private Point address = new Point();	
	private boolean hasVacancy;
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
	public boolean isHasVacancy() {
		return hasVacancy;
	}
	public void setHasVacancy(boolean hasVacancy) {
		this.hasVacancy = hasVacancy;
	}

	
}
