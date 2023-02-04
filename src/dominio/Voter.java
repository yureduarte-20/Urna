package dominio;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Voter implements Comparable<Voter>{

	public static final List<Voter> voters = new ArrayList<>();
	public static int count = 0;
	private int id;
	private String password;
	private String name;
	private Session session;
	private Point point;
	
	public Voter(int id, String password, String name, Point point) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.point = point;
	}
	
	@Override
	public int compareTo(Voter other) {
		if(this.id == other.id && this.password.equals(other.password))
			return 0;
		
		return this.id - other.id;
	}
	
	@Override
	public boolean equals(Object obj) {
		Voter other = (Voter) obj;
		
		return this.id == other.id && this.password.equals(other.password);
	}
	
	@Override
	public String toString() {
		return String.format("{id: %d, password: %s, name: %s}", id, password, name); 
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Point getPoint() {
		return point;
	}
	
	public int getId() {
		return this.id;
	}

	public void setPoint(Point point) {
		this.point = point;
	}
}
