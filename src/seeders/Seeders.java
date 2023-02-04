package seeders;

import java.awt.Point;

import dominio.Technician;
import dominio.Voter;

public class Seeders {

	public static void insertValues() {
		insertTechnical();
		insertVoters();
		
	}
	
	
	private static void insertTechnical() {
		Technician.technical.add( new Technician(123, "ramon") );
		Technician.technical.add( new Technician(12, "yure") );
	}

	private static void insertVoters() {
		Voter.voters.add( new Voter(1, "asdadsfa", "Ramon"  , new Point(1, 324)) );
		Voter.voters.add( new Voter(2, "faasfasf", "Yure"   , new Point(2, 124)) );
		Voter.voters.add( new Voter(3, "fasaddds", "Savio"  , new Point(5, 43))  );
		Voter.voters.add( new Voter(4, "faadasds", "Jhoni"  , new Point(5, 234)) );
		Voter.voters.add( new Voter(5, "dqwhsdaf", "Lincoln", new Point(63, 41)) );
		Voter.voters.add( new Voter(6, "422asdd4", "Lucas"  , new Point(3, 56))  );
	}
	
}
