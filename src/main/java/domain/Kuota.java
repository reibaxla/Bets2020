package domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Kuota implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@XmlID @Id
	@XmlJavaTypeAdapter(IntegerAdapter.class)
	@GeneratedValue
	private Integer kuotaID;
	private double pronostikoa;
	private String deskripzioa;
	@XmlIDREF
	private Question question;
	
	public Kuota() {
		super();
	}
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
	
	public Integer getkuotaID() {
		return this.kuotaID;
	}
	public void setkuotaID(Integer kuotaID) {
		this.kuotaID=kuotaID;
	}
	
	public String getDeskripzioa() {
		return this.deskripzioa;
	}
	public void setDeskripzioa(String deskripzioa) {
		this.deskripzioa=deskripzioa;
	}
	
	public double getPronostikoa() {
		return this.pronostikoa;
	}
	public void setPronostikoa(double pronostikoa) {
		this.pronostikoa=pronostikoa;
	}
	
	public Question getQuestion() {
		return this.question;
	}
	public void setQuestion(Question question) {
		this.question=question;
	}

}
