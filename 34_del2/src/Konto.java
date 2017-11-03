/**
 * Pengebeholder
 * 
 * @author Burhan
 * 
 */
public class Konto {

	private int penge;

	public Konto(int penge) {
		this.penge = penge;
	}

	public int getPenge() {
		return penge;
	}
	
	public void setPenge(int penge) {
		this.penge = penge;
	}

	public void tilføjPenge(int beløb) {
		penge += beløb;
	}

	public void fratrækPenge(int beløb) {
		int sum = penge -= beløb;
		if(sum <= 0) {
			setPenge(0);
		}
	}
}
