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
	
	public Candidate(int id, String password, String name, String fictitiousName) {
		super(id, password, name);
		this.fictitiousName = fictitiousName;
	}
	
	public Candidate(Voter voter, String fictitiousName) {
		super(voter.getId(), voter.getPassword(), voter.getName());
		this.fictitiousName = fictitiousName;
	}

	public static Candidate createCandidate(int id, Technician tech, String fictitiousName) throws UserNotFound, NotEligible  {
		Voter voter = null;
		
		for(Voter _voter: Voter.voters) {
			if(_voter.getId() == id)
				voter = _voter;
		}

		if(voter == null)
			throw new UserNotFound();
		if(!voter.isEligible())
			throw new NotEligible();
		
		Candidate candidate = new Candidate(voter, fictitiousName);
		candidates.add(candidate);
		
		return candidate;
	}
	
	@Override
	public String toString() {
		return String.format("{id: %d, password: %s, name: %s, fictitious_name: %s}", getId(), getPassword(), getName(), fictitiousName); 
	}
	
}
