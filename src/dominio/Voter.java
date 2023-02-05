package dominio;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import exceptions.UserNotFound;

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

	public int getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
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

	public boolean isEligible() {
		return true;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}
	public static Voter getVoter(int id) throws UserNotFound {
		for(var voter : Voter.voters) {
			if(voter.getId() == id) {
				return voter;
			}
		}
		throw new UserNotFound();
	}
	public void setId(int id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}


}
