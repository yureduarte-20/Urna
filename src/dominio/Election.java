package dominio;

import java.util.ArrayList;
import java.util.List;

public class Election {
    private List<Shift> shifts;

    public Election() {
        this.shifts  = new ArrayList<>(2);
    }

    public List<Shift> getShifts() {
        return shifts;
    }

    public void setShifts(List<Shift> shifts) {
        this.shifts = shifts;
    }

    
}
