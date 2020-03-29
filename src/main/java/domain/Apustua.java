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
public class Apustua {
	
	@Id
	@XmlJavaTypeAdapter(IntegerAdapter.class)
	@GeneratedValue
	private Integer apustuID;
	private double zenbatekoa;
	private boolean Irabazi;
	@XmlIDREF
	private Kuota kuota;
	@XmlIDREF
	private Erabiltzaile user;
	
	public Apustua() {
		
	}
	
	public Apustua(double zenbatekoa, Kuota kuota, Erabiltzaile user) {
		super();
		this.zenbatekoa=zenbatekoa;
		this.kuota=kuota;
	}
	
	public Apustua(Integer apustuID, double zenbatekoa, Kuota kuota, Erabiltzaile user) {
		super();
		this.apustuID=apustuID;
		this.zenbatekoa=zenbatekoa;
		this.kuota=kuota;
	}
	
	public Apustua(Integer apustuID, double zenbatekoa, Kuota kuota, Erabiltzaile user, boolean Irabazi) {
		super();
		this.apustuID=apustuID;
		this.zenbatekoa=zenbatekoa;
		this.Irabazi=Irabazi;
	}
	
	public int getApustuID() {
		return this.getApustuID();
	}
	public double getZenbatekoa() {
		return this.zenbatekoa;
	}
	
	public Kuota getKuota() {
		return this.kuota;
	}
	public Erabiltzaile getUser() {
		return this.user;
	}
	
	public boolean getIrabazi() {
		return this.Irabazi;
	}
	public void setIrabazle(boolean irabazi) {
		this.Irabazi=irabazi;
	}
	
}
