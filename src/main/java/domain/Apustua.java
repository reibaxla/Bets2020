package domain;

import java.io.Serializable;
import java.util.Vector;

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
public class Apustua implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@XmlID @Id
	@XmlJavaTypeAdapter(IntegerAdapter.class)
	@GeneratedValue
	private Integer apustuId;
	private double zenbatekoa;
	private boolean irabazi;
	@XmlIDREF
	private Vector<Kuota> kuota= new Vector<Kuota>();
	@XmlIDREF
	private Erabiltzaile user;
	
	public Apustua() {
		super();
	}
	
	public Apustua(double zenbatekoa, Vector<Kuota> kuota, Erabiltzaile user) {
		super();
		this.zenbatekoa=zenbatekoa;
		this.kuota=kuota;
	}
	
	public Apustua(Integer apustuId, double zenbatekoa, Vector<Kuota> kuota, Erabiltzaile user) {
		super();
		this.apustuId=apustuId;
		this.zenbatekoa=zenbatekoa;
		this.kuota=kuota;
	}
	
	public Apustua(Integer apustuId, double zenbatekoa, Vector<Kuota> kuota, Erabiltzaile user, boolean Irabazi) {
		super();
		this.apustuId=apustuId;
		this.zenbatekoa=zenbatekoa;
		this.irabazi=Irabazi;
	}
	
	public Integer getApustuId() {
		return this.apustuId;
	}
	public void setApustuId(Integer apustuId) {
		this.apustuId=apustuId;
	}
	
	public double getZenbatekoa() {
		return this.zenbatekoa;
	}
	public void setZenbatekoa(double zenbatekoa) {
		this.zenbatekoa=zenbatekoa;
	}
	
	public Vector<Kuota> getKuota() {
		return this.kuota;
	}
	public void setKuota(Vector<Kuota> kuota) {
		this.kuota=kuota;
	}
	
	public Erabiltzaile getUser() {
		return this.user;
	}
	public void setUser(Erabiltzaile user) {
		this.user=user;
	}
	
	public boolean getIrabazi() {
		return this.irabazi;
	}
	public void setIrabazi(boolean irabazi) {
		this.irabazi=irabazi;
	}
	
}
