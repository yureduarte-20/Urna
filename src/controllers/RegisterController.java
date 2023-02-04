package controllers;

import java.awt.Point;

import dominio.Voter;
import exceptions.UserAlreadyExists;

public class RegisterController {
	
	
	
	public static Voter registerVoter(int id, String password, String name, Point local) throws UserAlreadyExists {
		Voter newVoter = new Voter(id, password, name);
		
		if(Voter.voters.contains(newVoter))
			throw new UserAlreadyExists();
		
		
		
		
		
		Voter.voters.add(newVoter);
		
		return newVoter;
	}
	
	
}
