/**
 * 
 */
package slicnikorisnici.importer;

import java.io.FileNotFoundException;
import java.io.IOException;

import slicnikorisnici.model.SpisakOcena;

/**
 * @author astojmenovic
 *
 */
public interface SpisakOcenaEXCELImporter {

	public SpisakOcena importFromEXCELFile(String fajl, Boolean preskociPrvuLiniju) throws FileNotFoundException, IOException;
	
}
