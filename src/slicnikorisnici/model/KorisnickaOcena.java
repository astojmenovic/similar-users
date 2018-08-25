/**
 * 
 */
package slicnikorisnici.model;

/**
 * @author astojmenovic
 *
 */
public class KorisnickaOcena {

	private KorisnikID korisnickiID;
	private FilmID filmskiID;
	private Ocena ocena;
	/**
	 * @param korisnickiID
	 * @param filmskiID
	 * @param ocena
	 */
	
	public KorisnickaOcena() {
		
	}
	
	public KorisnickaOcena(KorisnikID korisnickiID, FilmID filmskiID, Ocena ocena) {
		super();
		this.korisnickiID = korisnickiID;
		this.filmskiID = filmskiID;
		this.ocena = ocena;
	}

	/**
	 * @return the korisnickiID
	 */
	public KorisnikID getKorisnickiID() {
		return korisnickiID;
	}

	/**
	 * @param korisnickiID the korisnickiID to set
	 */
	public void setKorisnickiID(KorisnikID korisnickiID) {
		this.korisnickiID = korisnickiID;
	}

	/**
	 * @return the filmskiID
	 */
	public FilmID getFilmskiID() {
		return filmskiID;
	}

	/**
	 * @param filmskiID the filmskiID to set
	 */
	public void setFilmskiID(FilmID filmskiID) {
		this.filmskiID = filmskiID;
	}

	/**
	 * @return the ocena
	 */
	public Ocena getOcena() {
		return ocena;
	}

	/**
	 * @param ocena the ocena to set
	 */
	public void setOcena(Ocena ocena) {
		this.ocena = ocena;
	}
	
	/**
	 * @param korisnickiID
	 * @param filmskiID
	 * @param ocena
	 */
	
	
	
	
}
