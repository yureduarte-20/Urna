package seeders;

import java.awt.Point;

import controllers.RegisterController;
import dominio.Session;
import dominio.Technician;
import dominio.Zone;
import exceptions.PartyAlreadyExists;
import exceptions.SessionAlreadyExists;
import exceptions.UserAlreadyExists;
import exceptions.ZoneAlreadyExists;

public class Seeders {

	public static void insertValues() {
		insertZone();
		insertSession();
		insertTechnical();
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


	private static void insertZone() {
		try {
			Zone.addZone( new Zone( 1, new Point(1, 1) ) );
		} catch (ZoneAlreadyExists e) {
			e.printStackTrace();
		}
	}

	private static void insertSession() {
		try {
			Zone.zones.get(0).addSession( new Session(1, new Point(2, 2)) );
		} catch (SessionAlreadyExists e) {
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

}
