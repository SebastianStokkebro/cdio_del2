import java.awt.Color;
import java.util.Scanner;

import desktop_codebehind.Car;
import desktop_resources.GUI;

/**
 * 
 * @author Andreas
 * @author Asef
 * @author David
 * @author Alan
 * @author Peter
 * @author Burhan
 * @author Sebastian
 *
 */

public class GoldGrindr {

	public static void main (String[] args) {
		
		Scanner keyb = new Scanner(System.in);
		
		new Felt();
		
		/**
		 * Spillerne oprettes med navn og konto samt tilhørende biler.
		 */
		System.out.println("Indtast navn på spiller 1");
		Spiller spiller1 = new Spiller(keyb.next());
		Konto konto1 = new Konto(1000);
		Car c1 = new Car.Builder()
				.typeRacecar()
				.patternHorizontalDualColor()
				.primaryColor(Color.red)
				.secondaryColor(Color.blue)
				.build();
		
		System.out.println("Indtast navn på spiller 2");
		Spiller spiller2 = new Spiller(keyb.next());
		Konto konto2 = new Konto(1000);
		Car c2 = new Car.Builder()
				.typeRacecar()
				.patternHorizontalDualColor()
				.primaryColor(Color.black)
				.secondaryColor(Color.yellow)
				.build();
		
		keyb.close();
		
		GUI.addPlayer(spiller1.getNavn(), konto1.getPenge(), c1);
		GUI.addPlayer(spiller2.getNavn(), konto2.getPenge(), c2);
		GUI.setCar(1, spiller1.getNavn());
		GUI.setCar(1, spiller2.getNavn());
		
		boolean done = false;
		boolean s1tur = true;
		boolean k1 = true;
		Spiller nuvSpiller = spiller1;
		Konto nuvKonto = konto1;
		
		while (!done) {
			
			/**
			 * Ternary betingelse der afgør hvis tur det er,
			 * samt hvis konto der skal bruges.
			 */
			nuvSpiller = s1tur ? spiller1: spiller2;
			nuvKonto = k1 ? konto1: konto2;
			
			System.out.println("Det er din tur " + nuvSpiller.getNavn() + " kast terning på OK");
			
			Terning t1 = new Terning();
			Terning t2 = new Terning ();
			GUI.setDice(t1.kast(), t2.kast());
			
			int feltnummer = t1.getVærdi()+t2.getVærdi();
			GUI.removeCar(1, nuvSpiller.getNavn());
			GUI.setCar(feltnummer, nuvSpiller.getNavn());
			
			/**
			 * switch-case der afgør hvad der skal ske med spilleren
			 * på det givne felt.
			 */
			switch(feltnummer) {
			case 2:
				GUI.showMessage("Du modtager 250");
				nuvKonto.tilføjPenge(250);
				s1tur = !s1tur;
				k1 = !k1;
				break;
			case 3:
				GUI.showMessage("Du mister 100");
				nuvKonto.fratrækPenge(100);
				s1tur = !s1tur;
				k1 = !k1;
				break;
			case 4:
				GUI.showMessage("Du modtager 100");
				nuvKonto.tilføjPenge(100);
				s1tur = !s1tur;
				k1 = !k1;
				break;
			case 5:
				GUI.showMessage("Du mister 20");
				nuvKonto.fratrækPenge(20);
				s1tur = !s1tur;
				k1 = !k1;
				break;
			case 6:
				GUI.showMessage("Du modtager 180");
				nuvKonto.tilføjPenge(180);
				s1tur = !s1tur;
				k1 = !k1;
				break; 
			case 7:
				GUI.showMessage("Der sker ikke noget");
				s1tur = !s1tur;
				k1 = !k1;
				break;
			case 8:
				GUI.showMessage("Du mister 70");
				nuvKonto.fratrækPenge(70);
				s1tur = !s1tur;
				k1 = !k1;
				break;
			case 9:
				GUI.showMessage("Du modtager 60");
				nuvKonto.tilføjPenge(60);
				s1tur = !s1tur;
				k1 = !k1;
				break;
			case 10:
				GUI.showMessage("Du mister 80 og får et ekstra kast");
				nuvKonto.fratrækPenge(80);
				break;
			case 11:
				GUI.showMessage("Du mister 50");
				nuvKonto.fratrækPenge(50);
				s1tur = !s1tur;
				k1 = !k1;
				break;
			case 12:
				GUI.showMessage("Du har ramt jackpot! Du modtager 650");
				nuvKonto.tilføjPenge(650);
				s1tur = !s1tur;
				k1 = !k1;
				break;
			}
			GUI.setBalance(nuvSpiller.getNavn(), nuvKonto.getPenge());
			GUI.removeCar(feltnummer, nuvSpiller.getNavn());
			GUI.setCar(1, nuvSpiller.getNavn());
			
			/**
			 * if-betingelse der bryder løkken når spilleren opnår 3000 penge eller derover.
			 */
			if(nuvKonto.getPenge() >= 3000) {
				done = true;
				GUI.showMessage("Tillykke, " + nuvSpiller.getNavn() + " du har vundet spillet!");
			}
		}
	}
	
}
