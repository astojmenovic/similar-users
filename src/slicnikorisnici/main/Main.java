/**
 * 
 */
package slicnikorisnici.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import slicnikorisnici.importer.SpisakOcenaEXCELImporter;
import slicnikorisnici.importer.SpisakOcenaImporterFactory;
import slicnikorisnici.model.SpisakOcena;
import slicnikorisnici.queries.SpisakOcenaQueries;

/**
 * @author astojmenovic
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SpisakOcenaImporterFactory factory = new SpisakOcenaImporterFactory();
		int k1 = 3;
		int k2 = 9;
		
		try {
			SpisakOcenaEXCELImporter importer = factory.napraviEXCELImporter();
			SpisakOcena sk = importer.importFromEXCELFile("ratings1.xlsx", true);
			SpisakOcenaQueries skq = new SpisakOcenaQueries(sk);
			
			System.out.println("K1: " + k1 + " - K2: " + k2 + " - Slicnost: " + skq.slicniKorisnici(sk, k1, k2));
			skq.ispisOcenaZajednickihFilmova(sk, k1, k2);
			
			//skq.ispisSlicnosti(sk, 10);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
