package dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import exceptions.NotEligible;
import exceptions.UserAlreadyExists;
import exceptions.UserNotFound;

public class Candidate extends Voter{
	
	private static List<Candidate> candidates = new ArrayList<>(); 
	
	private String fictitiousName;
	private Party party;
	
	public Candidate(int id, String password, String name, String fictitiousName, Party party) {
		super(id, password, name);
		this.fictitiousName = fictitiousName;
		this.party = party;
	}
	
	public Candidate(Voter voter, String fictitiousName, Party party) {
		super(voter.getId(), voter.getPassword(), voter.getName());
		this.fictitiousName = fictitiousName;
		this.party = party;
	}

	public static Candidate createCandidate(int id, Technician tech, String fictitiousName, Party party) throws UserNotFound, NotEligible  {
		Voter voter = null;
		
		for(Voter _voter: Voter.voters) {
			if(_voter.getId() == id)
				voter = _voter;
		}

		if(voter == null)
			throw new UserNotFound();
		if(!voter.isEligible())
			throw new NotEligible();
		
		Candidate candidate = new Candidate(voter, fictitiousName, party);
		candidates.add(candidate);
		
		return candidate;
	}
	
	@Override
	public String toString() {
		return String.format("{id: %d, password: %s, name: %s, fictitious_name: %s, party: %s}", getId(), getPassword(), getName(), fictitiousName, party); 
	}
	
}
