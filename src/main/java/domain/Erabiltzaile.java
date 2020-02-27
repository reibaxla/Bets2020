package domain;

public abstract class Erabiltzaile {
	private String izena;
	private String abizena;
	private int adina;
	private String posta;
	private String pasahitza;
	
	public Erabiltzaile() {
		
	}
	
	public Erabiltzaile(String izena, String abizena, int adina, String posta, String pasahitza) {
		this.izena=izena;
		this.abizena=abizena;
		this.adina=adina;
		this.posta=posta;
		this.pasahitza=pasahitza;
	}
	
	public void isNewErabiltzaile() {
		//Datu basera sartu
	}
	
}
