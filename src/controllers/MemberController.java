package controllers;

import java.util.List;

import dominio.BoardMember;
import dominio.Candidate;

public class MemberController {
	
	public static String printCandidates() {
		List<Candidate> candidates = Candidate.getCandidates();
		
		StringBuilder result = new StringBuilder();
		
		int counter = 0;
		for(Candidate candidate: candidates) {
			counter++;
			result.append( "Candidato " +  counter);
			result.append( "\n\tNúmero de Identificação: " + candidate.getId());
			result.append( "\n\tNome: " + candidate.getName());
			result.append( "\n\tNome Fictício: " + candidate.getFictitiousName());
			result.append( "\n\tPartido: " + candidate.getParty().getAcronym() + "\n");
			result.append("===================================\n");
		}
		
		return result.toString();
	}
	
	
	
}
