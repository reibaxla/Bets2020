package domain;

import java.io.Serializable;
import java.util.Date;

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
public class Mugimendu implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@XmlID @Id
	@XmlJavaTypeAdapter(IntegerAdapter.class)
	@GeneratedValue
	private Integer mugId;
	private double diruMug;
	private Date data;
	private Object mota;
	private Date firstEventDate;
	@XmlIDREF
	private Erabiltzaile user;
	
	public Mugimendu() {
		super();
	}
	public Mugimendu(Object mota, double diruMug, Date data,Date firstEventDate, Erabiltzaile user) {
		super();
		this.diruMug=diruMug;
		this.data=data;
		this.mota=mota;
		this.firstEventDate=firstEventDate;
	}
	public Mugimendu(Integer mugId, Object mota, double diruMug, Date data, Date firstEventDate, Erabiltzaile user) {
		super();
		this.diruMug=diruMug;
		this.data=data;
		this.mota=mota;
		this.mugId=mugId;
		this.firstEventDate=firstEventDate;
	}
	
	public Integer getMugId(){
		return this.mugId;
	}
	public void setMugId(Integer mugId){
		this.mugId=mugId;
	}
	
	public double getDiruMug(){
		return this.diruMug;
	}
	public void setDiruMug(double diruMug){
		this.diruMug=diruMug;
	}
	
	public Date getData(){
		return this.data;
	}
	public void setData(Date data){
		this.data=data;
	}
	
	public Date getFirstEventDate(){
		return this.firstEventDate;
	}
	public void setFirstEventDate(Date data){
		this.firstEventDate=data;
	}
	
	public Object getMota(){
		return this.mota;
	}
	public void getMota(String mota){
		this.mota=mota;
	}
	
	public Erabiltzaile getUser(){
		return this.user;
	}
	public void getUser(Erabiltzaile user){
		this.user=user;
	}
}
