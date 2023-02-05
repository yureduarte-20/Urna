package dominio;

import java.util.ArrayList;
import java.util.List;

public class ElectoralPlate {
	private Candidate principal;
	private Candidate vice;
	private String number;

	private static List<ElectoralPlate> electoralPlate = new ArrayList<>();

	public ElectoralPlate(Candidate principal, Candidate vice, String number) {
		super();
		this.principal = principal;
		this.vice = vice;
		this.number = number;
	}
	public Candidate getPrincipal() {
		return principal;
	}
	public void setPrincipal(Candidate principal) {
		this.principal = principal;
	}
	public Candidate getVice() {
		return vice;
	}
	public void setVice(Candidate vice) {
		this.vice = vice;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public static List<ElectoralPlate> getElectoralPlate() {
		return electoralPlate;
	}
	public static void setElectoralPlate(List<ElectoralPlate> electoralPlate) {
		ElectoralPlate.electoralPlate = electoralPlate;
	}
}
