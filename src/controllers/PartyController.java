package controllers;

import dominio.Party;
import dominio.Voter;
import exceptions.PartyNotFound;
import exceptions.UserNotFound;

public class PartyController {

	
	public static Party getByNumber(int number) throws PartyNotFound {
		
		for(Party _party: Party.parties) {
			System.out.println(_party.getNumber() + " e outro e " + number + " bool: " + (_party.getNumber() == number));
			if(_party.getNumber() == number)
				return _party;
		}
		
		throw new PartyNotFound();
	}
	
}
