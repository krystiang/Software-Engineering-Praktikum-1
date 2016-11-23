//Krystian Graczyk
//Nick Diedrich
package kundeAuftrag;

public class Auftrag {

	private int nummer;

	Auftrag(int nummer) {
		this.nummer = nummer;
	}

	public int getNummer() {
		return nummer;
	}

	@Override
	public boolean equals(Object other) {
		return this.getNummer() == ((Auftrag) other).getNummer();
	}

	public String toString() {
		return String.valueOf(nummer);
	}

}
