//Krystian Graczyk
//Nick Diedrich
package kundeAuftrag;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JUnitKundeAuftrag {

	Auftrag auf1;
	Auftrag auf2;
	Auftrag auf3;
	Auftrag auf4;
	EigeneListeImplementation<Auftrag> auftragliste1;
	Kunde kunde1;

	@Before
	public void fixture() {
		auf1 = new Auftrag(1);
		auf2 = new Auftrag(2);
		auf3 = new Auftrag(2);
		auf4 = new Auftrag(3);
		auftragliste1 = new EigeneListeImplementation<Auftrag>(auf1);
		kunde1 = new Kunde("kunde1", auftragliste1);
	}

	@Test
	public void test_add() {
		assertTrue(kunde1.add(auf2));
		// Zweimal Aufträge mit der selben Auftragsnummer werden nicht
		// hinzugefügt
		assertFalse(kunde1.add(auf3));
		// Wir versuchen zwei identische Aufträge hinzuzufügen
		assertFalse(kunde1.add(auf2));
	}
	
	@Test
	public void test_remove() {
		kunde1.add(auf2);
		assertTrue(kunde1.remove(auf2));
		// der einzige Auftrag den ein Kunde noch hat wird nicht gel�scht
		assertFalse(kunde1.remove(auf1));
	}

	@Test
	public void test_toString() {
		kunde1.add(auf2);
		kunde1.add(auf4);
		assertTrue(kunde1.toString().equals("kunde1 1 2 3"));
		kunde1.remove(auf2);
		assertTrue(kunde1.toString().equals("kunde1 1 3"));
	}
}
