/**
 * Pengebeholder
 * 
 * @author Burhan
 * @author Sebastian
 * 
 */
public class Konto extends Spiller{
	private int penge;
	
	public Konto(String navn, int penge) {
		super(navn);
		this.penge = penge;
	}

	public int getPenge() {
		return penge;
	}
	
	public void setPenge(int penge) {
		this.penge = penge;
	}
	
	public void tilføjPenge(int beløb) {
		int sum = penge += beløb;
		if(sum <= 0) {
			setPenge(0);
	}

	public void fratrækPenge(int beløb) {
		int sum = penge -= beløb;
		if(sum <= 0) {
			setPenge(0);
		}
	}
	
}
