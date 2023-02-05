package controllers;

import java.awt.Point;

import dominio.BoardMember;
import dominio.Technician;
import exceptions.UserNotFound;

public class Autenticator {
	
	//Singleton
	public static Autenticator auth = new Autenticator();
	
	public static Technician authenticatedTechnician = null;
	public static BoardMember authenticatedMember = null;
	
	public Technician validateTechnician(int id, String password) throws UserNotFound {
		int index = Technician.technical.indexOf( new Technician(id, password) );
		
		if(index == -1)
			throw new UserNotFound();
		
		return Technician.technical.get(index);
	}
	
	public BoardMember validateMember(int id, String password) throws UserNotFound {
		int index = BoardMember.members.indexOf( new BoardMember(id, password, "", new Point(0, 0)) );
		
		if(index == -1)
			throw new UserNotFound();
		
		return BoardMember.members.get(index);
	}
	
	
	public Object validate(int id, String password) throws UserNotFound {
		
		try {
			return validateTechnician(id, password);
		} catch (Exception e) { }
		
		try {
			return validateMember(id, password);
		} catch (Exception e) { }
		
		throw new UserNotFound();
	}
	
	
	
}
