package seeders;

import java.awt.Point;

import controllers.RegisterController;
import dominio.Election;
import dominio.Session;
import dominio.Shift;
import dominio.Technician;
import dominio.Zone;
import exceptions.PartyAlreadyExists;
import exceptions.SessionAlreadyExists;
import exceptions.UserAlreadyExists;
import exceptions.ZoneAlreadyExists;
import exceptions.*;

public class Seeders {

	public static void insertValues() {
		insertTechnical();
		insertElection();
		insertZonesAndSessions();
		insertVoters();
		insertParty();
		insertCandidates();
		insertMember();
	}


	private static void insertMember() {
		Technician tec = Technician.technical.get(0);

		try {
			RegisterController.createMember(2, tec);
			RegisterController.createMember(3, tec);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private static void insertParty() {
		try {
			RegisterController.saveParty("Brasil", 100, "BR");
		} catch (PartyAlreadyExists e) {
			e.printStackTrace();
		}
	}


	private static void insertCandidates() {
		Technician tec = Technician.technical.get(0);

		try {
			RegisterController.saveCandidate(1, tec, "Ramon Fictício", 100);
			RegisterController.saveCandidate(6, tec, "Ramon Fictício2", 100);
			RegisterController.saveCandidate(5, tec, "Ramon Fictício3", 100);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private static void insertTechnical() {
		if(!Technician.technical.isEmpty()) return;
		Technician.technical.add( new Technician(123, "ramon") );
		Technician.technical.add( new Technician(12, "yure") );
	}

	private static void insertVoters() {
		try {
			RegisterController.registerVoter(1, "asdadsfa", "Ramon"  , new Point(1, 324));
			RegisterController.registerVoter(2, "senha", "Yure"   , new Point(2, 124));
			RegisterController.registerVoter(3, "fasaddds", "Savio"  , new Point(5, 43));
			RegisterController.registerVoter(4, "faadasds", "Jhoni"  , new Point(5, 23));
			RegisterController.registerVoter(5, "dqwhsdaf", "Lincoln", new Point(63, 41));
			RegisterController.registerVoter(6, "422asdd4", "Lucas"  , new Point(3, 56));
		} catch (UserAlreadyExists e) {
			e.printStackTrace();
		}
	}

	private static void insertZonesAndSessions() {
		if(!Zone.zones.isEmpty())return;
		try {
			var z1 = new Zone(1, new Point(1 ,127));
			z1.addSession(new Session(1, new Point(1, 123)));
			var z2 = new Zone(2, new Point(85 ,225)); 
			z2.addSession(new Session(1, new Point(84,220)));
			var z3 = new Zone(3, new Point(15 ,135));
			z3.addSession(new Session(2, new Point(14,130)));
			Zone.addZone(z1);
			Zone.addZone(z2);
			Zone.addZone(z3);
			
		}catch(ZoneAlreadyExists | SessionAlreadyExists e) {
			
		}
	}
	
	private static void insertElection() {
		try {
			var s = new Shift("2021.1");
			var e = new Election("2021");
			e.addShift(s);
			Election.addElection(e );
			System.out.println("Seed de eleção Criada com sucesso");
		} catch(Exception e) {
			System.out.println("Falha ao criar o seed de eleição");
		}
	}
}
