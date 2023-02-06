package controllers;

import dominio.ElectoralPlate;

public class ElectoralPlateController {


	public static ElectoralPlate getPlateByNumber(int number) {

		for(ElectoralPlate ep : ElectoralPlate.getElectoralPlate()) {
			if(Integer.parseInt(ep.getNumber()) == number)
				return ep;
		}

		return null;
	}




}
