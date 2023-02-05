package dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CadastroMesario {

	private static List<CadastroMesario> cd = new ArrayList<>();

	private Technician technician = null;
	private LocalDate datetime = null;

	private CadastroMesario(Technician technician, LocalDate datetime) {
		this.technician = technician;
		this.datetime = datetime;
	}

	public Technician getTechnician() {
		return technician;
	}

	public LocalDate getDatetime() {
		return datetime;
	}

	public static void addLog(Technician technician, LocalDate datetime) {
		cd.add( new CadastroMesario(technician, datetime) );
	}

}
