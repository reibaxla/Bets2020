package domain;

import java.io.Serializable;
import java.util.Vector;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public abstract class Erabiltzaile implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String izena;
	private String abizena;
	private int adina;
	
	@XmlID @Id
	private String posta;
	private String pasahitza;
	private double diruZorroa;
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	private Vector<Apustua> apustuak = new Vector<Apustua>();
	
	public Erabiltzaile() {
		
	}
	
	public Erabiltzaile(String izena, String abizena, int adina, String posta, String pasahitza) {
		this.izena=izena;
		this.abizena=abizena;
		this.adina=adina;
		this.posta=posta;
		this.pasahitza=pasahitza;
		this.diruZorroa=0.0;
	}
	
	public String getIzena() {
		return this.izena;
	}
	public String getAbizena() {
		return this.abizena;
	}
	
	public int getAdina() {
		return this.adina;
	}
	public String getPosta() {
		return this.posta;
	}
	
	public String getPasahitza() {
		return this.pasahitza;
	}
	public double getDiruZorroa() {
		return this.diruZorroa;
	}
	
	public void setDiruZorroa(double dirua) {
		this.diruZorroa=dirua;
	}
	
	public Vector<Apustua> getApustu() {
		return apustuak;
	}

	public void setKuotak(Vector<Apustua> apustuak) {
		this.apustuak = apustuak;
	}
	
	public Apustua addApustu(double zenbatekoa, Kuota kuota)  {
        Apustua ap=new Apustua(zenbatekoa, kuota, this);
        apustuak.add(ap);
        return ap;
	}

	
	public boolean DoesApustuaExists(Question q)  {	
		for (Kuota k:q.getKuota()){
			for (Apustua ap:this.getApustu()){
				if (ap.getKuota().getkuotaID()==k.getkuotaID())
					return true;
			}
		}
		return false;
	}
		
}
