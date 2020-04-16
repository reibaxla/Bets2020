package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Vector;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public abstract class Erabiltzaile implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String izena;
	private String abizena;
	private int adina;
	
	@XmlID @Id
	private String posta;
	private String pasahitza;
	private double diruZorroa;
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Vector<Apustua> apustuak = new Vector<Apustua>();
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Vector<Mugimendu> mugimenduak = new Vector<Mugimendu>();
	
	public Erabiltzaile() {
		super();
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
	public void setIzena(String izena) {
		this.izena=izena;
	}
	
	public String getAbizena() {
		return this.abizena;
	}
	public void setAbizena(String abizena) {
		this.abizena=abizena;
	}
	
	public int getAdina() {
		return this.adina;
	}
	public void setAdina(int adina) {
		this.adina=adina;
	}
	
	public String getPosta() {
		return this.posta;
	}
	public void setPosta(String posta) {
		this.posta=posta;
	}
	
	public String getPasahitza() {
		return this.pasahitza;
	}
	public void setPasahitza(String pasahitza) {
		this.pasahitza=pasahitza;
	}
	
	public double getDiruZorroa() {
		return this.diruZorroa;
	}
	public void setDiruZorroa(double dirua) {
		this.diruZorroa=dirua;
	}
	
	public Vector<Apustua> getApustua() {
		return this.apustuak;
	}

	public void setApustua(Vector<Apustua> apustuak) {
		this.apustuak = apustuak;
	}
	
	public Apustua addApustu(double zenbatekoa, Vector<Kuota> kuota)  {
        Apustua ap=new Apustua(zenbatekoa, kuota, this);
        this.apustuak.add(ap);
        return ap;
	}

	
/*	public boolean DoesApustuaExists(Question q)  {	
		for (Kuota k: q.getKuota()){
			for (Apustua ap:this.getApustua()){
				for (Kuota kn:ap.getKuota()){
					if (kn.getkuotaID()==k.getkuotaID())
						return true;
				}
			}
		}
		return false;
	}
	*/
	public Vector<Mugimendu> getMugimeduak() {
		return this.mugimenduak;
	}

	public void setMugimenduak(Vector<Mugimendu> mugimenduak) {
		this.mugimenduak = mugimenduak;
	}
	
	public Mugimendu addMugimendu(Object mota, double diruMug, Date data, Date firstEventDate)  {
        Mugimendu mu=new Mugimendu(mota, diruMug, data, firstEventDate, this);
        this.mugimenduak.add(mu);
        return mu;
	}
	
	public boolean remApustu(Apustua ap) {
		return this.apustuak.remove(ap);
	}
	public boolean remMug(Mugimendu mug) {
		return this.mugimenduak.remove(mug);
	}
	
}
