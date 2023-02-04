package dominio;

import java.util.ArrayList;
import java.util.List;

import exceptions.UserAlreadyExists;

public class Technician implements Comparable<Technician>{

	public static final List<Technician> technical = new ArrayList<>();
	
	private int id;
	private String password;
	
	public Technician(int id, String password) {
		this.id = id;
		this.password = password;
	}

	@Override
	public int compareTo(Technician other) {
		if(this.id == other.id && this.password.equals(other.password))
			return 0;
		
		return this.id - other.id;
	}
	
	@Override
	public boolean equals(Object obj) {
		Technician other = (Technician) obj;
		
		return this.id == other.id && this.password.equals(other.password);
	}
	
	@Override
	public String toString() {
		return String.format("{id: %d, password: %s}", id, password); 
	}
	
}
