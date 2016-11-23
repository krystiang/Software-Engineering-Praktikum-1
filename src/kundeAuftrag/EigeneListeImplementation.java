//Krystian Graczyk
//Nick Diedrich
package kundeAuftrag;

public class EigeneListeImplementation<T> implements EigeneListeInterface<T> {

	 private Knoten<T> kopf;

	EigeneListeImplementation(T elem) {
		kopf = new Knoten<T>(elem);
	}

	@Override
	public boolean add(T elem) {
		return kopf.add(elem);
	}

	@Override
	public boolean remove(T elem) {
		if (kopf.naechsterEnthalten()) {
			return kopf.remove(elem);
		} else {
			return false;
		}
	}

	@Override
	public boolean contains(T elem) {
		// TODO Auto-generated method stub
		return false;
	}

	public String toString() {
		Knoten<T> temp = kopf;
		StringBuilder auftraege = new StringBuilder();
		while (temp != null) {
			auftraege.append(" " + temp.toString());
			temp = temp.naechster;
		}
		return auftraege.toString();
	}

	// Knoten zum Aufbewahren der Elemente, die miteinander verkettet �ber eine
	// Referenz auf das jeweilig N�chste die interne Datenstruktur der "Liste"
	// ergeben
	private class Knoten<T> {

		T inhalt;
		Knoten<T> naechster;

		public Knoten(T wert) {
			this.inhalt = wert;
		}

		public boolean naechsterEnthalten() {
			return (this.naechster != null);
		}

		public boolean add(T elem) {
			if (this.inhalt.equals(elem))
				return false;
			if (naechsterEnthalten()) {
				return naechster.add(elem);
			} else {
				naechster = new Knoten<T>(elem);
				return true;
			}

		}

		public boolean remove(T elem) {
			Knoten<T> temp = kopf;
			  Knoten<T> vortemp;
			  if (temp.inhalt.equals(elem) && temp.naechsterEnthalten()) kopf = temp.naechster;
			  while (naechsterEnthalten()) {
			   vortemp = temp;
			   temp = temp.naechster;
			   if (temp.inhalt.equals(elem)) {
			    vortemp.naechster = temp.naechster;
			    return true;
			   }
			  }
			  return false;
		}

		public String toString() {
			return inhalt.toString();
		}

	}
}