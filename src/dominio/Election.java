package dominio;

import java.util.ArrayList;
import java.util.List;

import exceptions.ElectionAlreadyExists;
import exceptions.ElectionNotFound;
import exceptions.ShiftExceededLimit;
import exceptions.ShiftNotFound;
import exceptions.ShiftStillActive;

public class Election {
	private String identification;
	private List<Shift> shifts;
	private boolean active = true;
	public static void setEletions(List<Election> eletions) {
		Election.eletions = eletions;
	}
	private static List<Election> eletions = new ArrayList();
    public static List<Election> getEletions() {
		return eletions;
	}
    
    public static void addElection(Election el) throws ElectionAlreadyExists{
    	for(var ele : Election.getEletions()) {
    		if(ele.getIdentification() == el.getIdentification()) {
    			throw new ElectionAlreadyExists();
    		}
    	}
    	Election.getEletions().add(el);
    }
	public static Election getActiveElection() throws ElectionNotFound {
		for(var e : Election.getEletions()) {
			if(e.isActive()) {
				return e;
			}
		}
		throw new ElectionNotFound();
	}

    public static Election getElection(String eletionId) throws ElectionNotFound {
    	for(var el : Election.getEletions()) {
    		if(el.getIdentification().equals( eletionId )) {
    			return el;
    		}
    	}
    	throw new ElectionNotFound();
    }
    public Election(String identification) {
		super();
		this.identification = identification;
		this.shifts  = new ArrayList<>(2);
	}

	public String getIdentification() {
		return identification;
	}
	public void addShift(Shift s) throws ShiftExceededLimit, ShiftStillActive{
		if(this.shifts.size() >= 2) throw new ShiftExceededLimit();
		for(var _s : this.shifts) {
			if(_s.isActive())
				throw new ShiftStillActive();
		}
		this.shifts.add(s);
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public List<Shift> getShifts() {
        return shifts;
    }

    public void setShifts(List<Shift> shifts) {
        this.shifts = shifts;
    }


	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	public Shift getActiveShift() throws ShiftNotFound{
		for(var shift : this.shifts) {
			if(shift.isActive())
				return shift;
		}
		throw new ShiftNotFound();
	}
    
}
