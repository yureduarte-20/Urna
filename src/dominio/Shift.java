package dominio;

import java.util.ArrayList;
import java.util.List;

public class Shift {
    private String shiftIdentification;
    private List<Vote> votes = new ArrayList<>();
    private boolean active = true;

    public boolean isActive() {
		return active;
	}

    public void setActive(boolean active) {
		this.active = active;
	}

    public Shift(String shiftIdentification) {
        this.shiftIdentification = shiftIdentification;
    }

    public boolean addVote(Vote vote){
        return votes.add(vote);
    }

    public String getShiftIdentification() {
        return shiftIdentification;
    }

    public void setShiftIdentification(String shiftIdentification) {
        this.shiftIdentification = shiftIdentification;
    }

    public List<Vote> getVotesCopy (){
        return new ArrayList<>(votes);
    }
}
