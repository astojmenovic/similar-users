/**
 * 
 */
package slicnikorisnici.queries;

import java.util.ArrayList;
import java.util.List;

import slicnikorisnici.model.KorisnickaOcena;
import slicnikorisnici.model.SpisakOcena;

/**
 * @author astojmenovic
 *
 */
public class SpisakOcenaQueries {

	private SpisakOcena spisakOcena;

	/**
	 * @param spisakOcena
	 */
	public SpisakOcenaQueries(SpisakOcena spisakOcena) {
		super();
		this.spisakOcena = spisakOcena;
	}

	public void ispisSpiskaOcena(SpisakOcena spisakOcena, int idKorisnika, int idFilma) {

		for (KorisnickaOcena korisnickaOcena : spisakOcena.getOcene()) {
			if ((korisnickaOcena.getKorisnickiID().getIdKorisnika() == idKorisnika)
					&& (korisnickaOcena.getFilmskiID().getIdFilma() == idFilma)) {
				System.out.print(korisnickaOcena.getKorisnickiID().getIdKorisnika() + "\t");
				System.out.print(korisnickaOcena.getFilmskiID().getIdFilma() + "\t");
				System.out.print(korisnickaOcena.getOcena().getOcena() + "\t");

				System.out.println();
				break;
			}

		}
	}

	public double vratiOcenu(SpisakOcena spisakOcena, int idKorisnika, int idFilma) {

		for (KorisnickaOcena korisnickaOcena : spisakOcena.getOcene()) {
			if ((korisnickaOcena.getKorisnickiID().getIdKorisnika() == idKorisnika)
					&& (korisnickaOcena.getFilmskiID().getIdFilma() == idFilma)) {
				return korisnickaOcena.getOcena().getOcena();

			}

		}
		return 0.0;
	}

	public List<Integer> zajednickiFilmovi(SpisakOcena spisakOcena, int k1, int k2) {

		List<Integer> zajednickiFilmovi = new ArrayList<Integer>();

		for (KorisnickaOcena korisnickaOcena : spisakOcena.getOcene()) {
			int film;
			if (korisnickaOcena.getKorisnickiID().getIdKorisnika() == k1) {
				film = korisnickaOcena.getFilmskiID().getIdFilma();
				for (KorisnickaOcena korisnickaOcena2 : spisakOcena.getOcene()) {
					if (korisnickaOcena2.getKorisnickiID().getIdKorisnika() == k2) {
						if (film == korisnickaOcena2.getFilmskiID().getIdFilma()) {

							zajednickiFilmovi.add(film);

						}
					}
				}

			}

		}
		
		return zajednickiFilmovi;

	}

	
	public double slicniKorisnici(SpisakOcena spisakOcena, int k1, int k2) {

		double sumaSquares = 0.0;

		List<Integer> zajednickiFilmovi = zajednickiFilmovi(spisakOcena, k1, k2);
		
		if(zajednickiFilmovi.isEmpty()){
			return 0.0;
		}
		
		for(Integer filmovi: zajednickiFilmovi){
			sumaSquares+=Math.pow((vratiOcenu(spisakOcena, k1, filmovi))-(vratiOcenu(spisakOcena, k2, filmovi)), 2);
		}
		

		return 1/(1 + Math.sqrt(sumaSquares));
	}
	
	public void ispisSlicnosti(SpisakOcena spisakOcena, int n){
		
		for (int i = 1; i < n; i++) {

			for (int j = 1; j < n; j++) {
				if (i != j) {

					System.out.println("K1: " + i + " - K2: " + j + " - Slicnost: " + slicniKorisnici(spisakOcena, i, j));
					
					
				}
			}
		}
		
	}
	
	public void ispisZajednickihFilmova(SpisakOcena spisakOcena, int k1, int k2){
		List<Integer> listaFilmova = new ArrayList<Integer>();
		listaFilmova = zajednickiFilmovi(spisakOcena, k1, k2);
		if (listaFilmova.isEmpty()) {
			System.out.println("Nema zajednickih filmova.");
		} else {
			for (Integer f : listaFilmova) {

				System.out.println(f.intValue());
			}
		}
	}
	
	public void ispisOcenaZajednickihFilmova(SpisakOcena sk, int k1, int k2){
		
		for (KorisnickaOcena korisnickaOcena : sk.getOcene()) {
			int film;
			double ocena1;
			if (korisnickaOcena.getKorisnickiID().getIdKorisnika() == k1) {
				film = korisnickaOcena.getFilmskiID().getIdFilma();
				ocena1 = korisnickaOcena.getOcena().getOcena();
				
				for (KorisnickaOcena korisnickaOcena2 : sk.getOcene()) {
					if (korisnickaOcena2.getKorisnickiID().getIdKorisnika() == k2) {
						int film2 = korisnickaOcena2.getFilmskiID().getIdFilma();
						double ocena2 = korisnickaOcena2.getOcena().getOcena();
						if (film == film2) {
							System.out.println("Film: " + film);
							System.out.println("K1: " + k1 + " - Ocena: " + ocena1 + "  |  " + "K2: " + k2 + " - Ocena: " + ocena2 + "\n");
						}
					}
				}

			}

		}
	}
}

		
