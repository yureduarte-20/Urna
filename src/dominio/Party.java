package dominio;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Party implements Comparable<Party>{

	public static List<Party> parties = new ArrayList<>();
	
	private String name;
	private String acronym;
	private int number;
	
	public Party(String name, String sigla, int number) {
		this.name = name;
		this.acronym = sigla;
		this.number = number;
	}
	
	public static List<Party> getParties() {
		return parties;
	}

	public static void setParties(List<Party> parties) {
		Party.parties = parties;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAcronym() {
		return acronym;
	}

	public void setAcronym(String sigla) {
		this.acronym = sigla;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public int compareTo(Party o) {
		return o.number - this.number;
	}
	
	@Override
	public boolean equals(Object o) {
		Party party = (Party) o;
		return party.number == this.number;
	}
	
	@Override
	public String toString() {
		return String.format("name: %s, sigla: %s, number: %d", name, acronym, number);
	}
	
}
