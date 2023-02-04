package controllers;

import dominio.Technician;
import exceptions.UserNotFound;

public class Autenticator {
	
	//Singleton
	public static Autenticator auth = new Autenticator();
	
	public static Technician authenticatedTechnician = null;
	
	public Technician validate(int id, String password) throws UserNotFound {
		int index = Technician.technical.indexOf( new Technician(id, password) );
		
		if(index == -1)
			throw new UserNotFound();
		
		return Technician.technical.get(index);
	}
	
	
}
