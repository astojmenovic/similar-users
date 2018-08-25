/**
 * 
 */
package slicnikorisnici.importer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.Format;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import slicnikorisnici.model.FilmID;
import slicnikorisnici.model.KorisnickaOcena;
import slicnikorisnici.model.KorisnikID;
import slicnikorisnici.model.Ocena;
import slicnikorisnici.model.SpisakOcena;

/**
 * @author astojmenovic
 *
 */
public class SpisakOcenaEXCELImplementation implements SpisakOcenaEXCELImporter {

	@Override
	public SpisakOcena importFromEXCELFile(String fajl, Boolean preskociPrvuLiniju) throws IOException {
		FileInputStream file = new FileInputStream(new File(fajl));

		// Pravi workbook instance .xlsx fajla
		XSSFWorkbook wb = new XSSFWorkbook(file);

		// Pravi sheet object
		XSSFSheet sheet = wb.getSheetAt(0);

		Iterator<Row> rowIterator = sheet.iterator();

		if (preskociPrvuLiniju == true) {
			rowIterator.next();
		}

		List<KorisnickaOcena> korisnickeOcene = new ArrayList<>();

		// Traversing over each row of XLSX file
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			// For each row, iterate through each columns
			KorisnickaOcena korisnickaOcena = konvertujemoRedIzEXCELFajla(row);

			korisnickeOcene.add(korisnickaOcena);

		}

		return new SpisakOcena(korisnickeOcene);
	}

	private KorisnickaOcena konvertujemoRedIzEXCELFajla(Row row) {
		Iterator<Cell> cellIterator = row.cellIterator();
		int i = 1;
		KorisnikID korisnikID = null;
		FilmID filmID = null;
		Ocena ocena = null;
		
		while (cellIterator.hasNext()) {
			Cell cell = cellIterator.next();

			if (i == 1) {
				korisnikID = new KorisnikID((int) cell.getNumericCellValue());
			} else if (i == 2) {
				filmID = new FilmID((int)cell.getNumericCellValue());
			} else if (i == 3) {
				ocena = new Ocena((double)cell.getNumericCellValue());
			} 
			
			i++;
		}

		return new KorisnickaOcena(korisnikID, filmID, ocena);
	}

}
