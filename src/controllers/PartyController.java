package controllers;

import dominio.Party;
import exceptions.PartyNotFound;

public class PartyController {


	public static Party getByNumber(int number) throws PartyNotFound {

		for(Party _party: Party.parties) {
			if(_party.getNumber() == number)
				return _party;
		}

		throw new PartyNotFound();
	}

}
