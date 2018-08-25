/**
 * 
 */
package slicnikorisnici.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author astojmenovic
 *
 */
public class SpisakOcena {

	private List<KorisnickaOcena> ocene;

	/**
	 * @param ocene
	 */
	public SpisakOcena(List<KorisnickaOcena> ocene) {
		super();
		this.ocene = ocene;
	}

	/**
	 * @return the ocene
	 */
	public List<KorisnickaOcena> getOcene() {
		return ocene;
	}

	/**
	 * @param ocene the ocene to set
	 */
	public void setOcene(List<KorisnickaOcena> ocene) {
		this.ocene = ocene;
	}

	/**
	 * @param arg0
	 * @return
	 * @see java.util.List#add(java.lang.Object)
	 */
	public boolean add(KorisnickaOcena arg0) {
		if(ocene == null){
			ocene = new ArrayList<KorisnickaOcena>();
		}
		return ocene.add(arg0);
	}
	
	
	
}
