/**
 * 
 */
package slicnikorisnici.importer;

/**
 * @author astojmenovic
 *
 */
public class SpisakOcenaImporterFactory {

	public SpisakOcenaEXCELImporter napraviEXCELImporter(){
		return new SpisakOcenaEXCELImplementation();
	}
	
}
