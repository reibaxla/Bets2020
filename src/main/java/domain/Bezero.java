package domain;

import javax.persistence.Entity;

@Entity
public class Bezero extends Erabiltzaile {
	
	public Bezero() {
		
	}
	public Bezero(String izena, String abizena, int adina, String posta, String pasahitza) {
		super(izena, abizena, adina, posta, pasahitza);
	}
	
}
