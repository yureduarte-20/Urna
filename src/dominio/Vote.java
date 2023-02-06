package dominio;

import controllers.ElectoralPlateController;

public class Vote {
    private ElectoralPlate electoralPlate;
    private Voter voter;

    public Vote(String number, Voter voter) {
    	if(number == null)
    		this.electoralPlate = ElectoralPlate.blankPlate;
    	else
	    	this.electoralPlate = ElectoralPlateController.getPlateByNumber(Integer.parseInt(number));

    	if(this.electoralPlate == null)
    		this.electoralPlate = ElectoralPlate.nullPlate;

        this.voter = voter;
    }

    public ElectoralPlate getPlate() {
        return electoralPlate;
    }

    public void setPlate(ElectoralPlate Plate) {
        this.electoralPlate = Plate;
    }

	public Voter getVoter() {
		return voter;
	}

	public void setVoter(Voter voter) {
		this.voter = voter;
	}

	@Override
	public String toString() {
		return "{" + voter + ", chapa: " + electoralPlate + "}";
	}

}
