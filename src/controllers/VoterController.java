package controllers;

import dominio.Voter;
import exceptions.UserNotFound;

public class VoterController {


	public static Voter getById(int id) throws UserNotFound {

		for(Voter _voter: Voter.voters) {
			if(_voter.getId() == id)
				return _voter;
		}

		throw new UserNotFound();
	}

}
