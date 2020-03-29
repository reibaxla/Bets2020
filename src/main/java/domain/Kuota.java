package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Kuota {
	
	@Id 
	@XmlJavaTypeAdapter(IntegerAdapter.class)
	@GeneratedValue
	private Integer kuotaID;
	private double pronostikoa;
	private String deskripzioa;
	@XmlIDREF
	private Question question;
	
	public Kuota(String deskripzioa, double pronostikoa2, Question question) {
		super();
		this.pronostikoa=pronostikoa2;
		this.deskripzioa=deskripzioa;
	}
	
	public Kuota(Integer kuotaID, String deskripzioa, double pronostikoa, Question question) {
		super();
		this.kuotaID=kuotaID;
		this.pronostikoa=pronostikoa;
		this.deskripzioa=deskripzioa;
		
	}
	
	public int getkuotaID() {
		return this.kuotaID;
	}
	public String getdeskripzioa() {
		return this.deskripzioa;
	}
	
	public double getpronostikoa() {
		return this.pronostikoa;
	}
	

}
