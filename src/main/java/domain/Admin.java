package domain;

import javax.persistence.Entity;

@Entity
public class Admin extends Erabiltzaile {
	
	public Admin(String izena, String abizena, int adina, String posta, String pasahitza) {
		super(izena, abizena, adina,posta, pasahitza);
	}
	
}
