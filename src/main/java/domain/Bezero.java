package domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Bezero extends Erabiltzaile implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Bezero() {
		
	}
	public Bezero(String izena, String abizena, int adina, String posta, String pasahitza) {
		super(izena, abizena, adina, posta, pasahitza);
	}
	
}
