package controllers;

import java.util.HashMap;
import java.util.Map.Entry;

import dominio.Election;
import dominio.ElectoralPlate;
import dominio.Session;
import dominio.Shift;
import dominio.Vote;
import exceptions.ElectionNotFound;
import exceptions.ShiftNotFound;

public class VoteController {

	public static String getBallotPaper() throws ElectionNotFound, ShiftNotFound {
		HashMap<ElectoralPlate, Integer> results = getResult();
		StringBuilder response = new StringBuilder();

		for (Entry<ElectoralPlate, Integer> pair : results.entrySet()) {
			if(pair.getKey() == ElectoralPlate.nullPlate)
				response.append(String.format("A quantidade de votos em branco foi %d\n", pair.getValue()));
			else if(pair.getKey() == ElectoralPlate.blankPlate)
				response.append(String.format("A quantidade de votos nulos foi %d\n", pair.getValue()));
			else
				response.append(String.format("A chapa %s teve %d votos\n", pair.getKey().getNumber(), pair.getValue()));

			response.append("===========================\n");
		}

		return response.toString();
	}

	public static HashMap<ElectoralPlate, Integer> getResult() throws ShiftNotFound, ElectionNotFound{
		Session session = Autenticator.authenticatedBoardMember.getSession();

		Shift shift = Election.getActiveElection().getActiveShift();
		HashMap<ElectoralPlate, Integer> votes = new HashMap<>();

		for(Vote vote: shift.getVotesCopy()) {
			if(vote.getVoter().getSession().equals(session)) {
				Integer quantVotes = votes.get(vote.getPlate());
				quantVotes = quantVotes == null? 1 : quantVotes + 1;
				votes.put(vote.getPlate(), quantVotes);
			}
		}

		return votes;
	}


}
