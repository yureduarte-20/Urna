package dominio;

import java.util.ArrayList;
import java.util.List;

import exceptions.NotEligible;
import exceptions.UserNotFound;

public class Candidate extends Voter{

	private static List<Candidate> candidates = new ArrayList<>();

	private String fictitiousName;
	private Party party;

	public Candidate(Voter voter, String fictitiousName, Party party) {
		super(voter.getId(), voter.getPassword(), voter.getName(), voter.getSession());
		this.fictitiousName = fictitiousName;
		this.party = party;
	}

	public static Candidate createCandidate(int id, String fictitiousName, Party party) throws UserNotFound, NotEligible  {
		Voter voter = null;

		for(Voter _voter: Voter.voters) {
			if(_voter.getId() == id)
				voter = _voter;
		}

		if(voter == null)
			throw new UserNotFound();

		Candidate candidate = new Candidate(voter, fictitiousName, party);
		candidates.add(candidate);

		return candidate;
	}

	public static List<Candidate> getCandidates() {
		return candidates;
	}

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	public String getFictitiousName() {
		return fictitiousName;
	}

	public void setFictitiousName(String fictitiousName) {
		this.fictitiousName = fictitiousName;
	}

	@Override
	public String toString() {
		return String.format("{id: %d, password: %s, name: %s, fictitious_name: %s, party: %s}", getId(), getPassword(), getName(), fictitiousName, party);
	}

	public static Candidate getCandidate(int id) throws UserNotFound {
		for( var candidate : Candidate.candidates) {
			if(candidate.getId() == id) {
				return candidate;
			}
		}
		throw new UserNotFound();
	}

}
