package entities;

import java.util.List;

public class ClienteOleo extends Cliente {
	
	//atributo
	private double mlsOleo;

	//contrutor
	public ClienteOleo(double mlsOleo) {
		super();
		this.mlsOleo = mlsOleo;
	}

	//getters e setters
	public double getMlsOleo() {
		return mlsOleo;
	}
	
	public void addMlsOleo(double mlsOleo) {
		this.mlsOleo += mlsOleo;
	}
	
	
	
}
