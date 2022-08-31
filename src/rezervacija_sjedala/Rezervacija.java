package rezervacija_sjedala;


public class Rezervacija  {
	private String sjedalo;
	private int korisnik_id;
	private int id;
	private int dogadaj_id;
	
	public Rezervacija() {
		super();
	}
	
	public String getSjedalo() {
		return sjedalo;
	}

	public void setSjedalo(String sjedalo) {
		this.sjedalo = sjedalo;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDogadaj_id() {
		return dogadaj_id;
	}

	public void setDogadaj_id(int dogadaj_id) {
		this.dogadaj_id = dogadaj_id;
	}

	

	public int getKorisnik_id() {
		return korisnik_id;
	}

	public void setKorisnik_id(int korisnik_id) {
		this.korisnik_id = korisnik_id;
	}

	@Override
	public String toString() {
		return "rezervacija [sjedalo=" + sjedalo + ", korisnik_id=" + korisnik_id + ", id=" + id + ", dogadaj_id="
				+ dogadaj_id + "]";
	}

	
	
	


}
