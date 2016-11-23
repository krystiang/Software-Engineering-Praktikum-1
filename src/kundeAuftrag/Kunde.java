//Krystian Graczyk
//Nick Diedrich
package kundeAuftrag;

public class Kunde {

	private String name;
	private EigeneListeImplementation<Auftrag> auftragliste;

	Kunde(String name, EigeneListeImplementation<Auftrag> auftragliste) {
		this.name = name;
		this.auftragliste = auftragliste;
	}

	public boolean add(Auftrag auftrag) {
		return auftragliste.add(auftrag);
	}
	
	public boolean remove(Auftrag auftrag){
	return auftragliste.remove(auftrag);
}

	public String toString() {
		return name + auftragliste.toString();
	}
}
