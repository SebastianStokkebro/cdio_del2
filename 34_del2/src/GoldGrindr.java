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

	public static void main(String[] args) {

		Scanner keyb = new Scanner(System.in);
		/**
		 * annonym objektoprettelse af klassen Felt.
		 */
		new Felt();

		/**
		 * Spillerne oprettes med navn og konto samt tilhørende biler.
		 */
		System.out.println("Indtast navn på spiller 1");
		Spiller spiller1 = new Spiller(1000, keyb.next());
		Car c1 = new Car.Builder().typeRacecar().patternHorizontalDualColor().primaryColor(Color.red)
				.secondaryColor(Color.blue).build();

		System.out.println("Indtast navn på spiller 2");
		Spiller spiller2 = new Spiller(1000, keyb.next());
		Car c2 = new Car.Builder().typeRacecar().patternHorizontalDualColor().primaryColor(Color.black)
				.secondaryColor(Color.yellow).build();

		keyb.close();

		GUI.addPlayer(spiller1.getNavn(), spiller1.getPenge(), c1);
		GUI.addPlayer(spiller2.getNavn(), spiller2.getPenge(), c2);
		GUI.setCar(1, spiller1.getNavn());
		GUI.setCar(1, spiller2.getNavn());

		boolean done = false;
		boolean s1tur = true;
		Spiller nuvSpiller = spiller1;

		while (!done) {

			/**
			 * Ternary betingelse der afgør hvis tur det er.
			 */
			nuvSpiller = s1tur ? spiller1 : spiller2;
			
			System.out.println("Det er din tur " + nuvSpiller.getNavn() + " kast terning på OK");

			Terning t1 = new Terning();
			Terning t2 = new Terning();
			GUI.setDice(t1.kast(), t2.kast());

			int feltnummer = t1.getVærdi() + t2.getVærdi();
			GUI.removeCar(1, nuvSpiller.getNavn());
			GUI.setCar(feltnummer, nuvSpiller.getNavn());

			/**
			 * switch-case der afgør hvad der skal ske med spilleren på det givne felt.
			 */
			switch (feltnummer) {
			case 2:
				GUI.showMessage(Læs.laes("towerBesked:"));
				nuvSpiller.tilføjPenge(250);
				s1tur = !s1tur;
				break;
			case 3:
				GUI.showMessage(Læs.laes("craterBesked:"));
				nuvSpiller.fratrækPenge(100);
				s1tur = !s1tur;
				break;
			case 4:
				GUI.showMessage(Læs.laes("placeGatesBesked:"));
				nuvSpiller.tilføjPenge(100);
				s1tur = !s1tur;
				break;
			case 5:
				GUI.showMessage(Læs.laes("coldDesertBesked:"));
				nuvSpiller.fratrækPenge(20);
				s1tur = !s1tur;
				break;
			case 6:
				GUI.showMessage(Læs.laes("walledCityBesked:"));
				nuvSpiller.tilføjPenge(180);
				s1tur = !s1tur;
				break;
			case 7:
				GUI.showMessage(Læs.laes("monasteryBesked:"));
				s1tur = !s1tur;
				break;
			case 8:
				GUI.showMessage(Læs.laes("blackCaveBesked:"));
				nuvSpiller.fratrækPenge(70);
				s1tur = !s1tur;
				break;
			case 9:
				GUI.showMessage(Læs.laes("hutsBesked:"));
				nuvSpiller.tilføjPenge(60);
				s1tur = !s1tur;
				break;
			case 10:
				GUI.showMessage(Læs.laes("wereBesked:"));
				nuvSpiller.fratrækPenge(80);
				break;
			case 11:
				GUI.showMessage(Læs.laes("pitBesked:"));
				nuvSpiller.fratrækPenge(50);
				s1tur = !s1tur;
				break;
			case 12:
				GUI.showMessage(Læs.laes("goldmineBesked:"));
				nuvSpiller.tilføjPenge(650);
				s1tur = !s1tur;
				break;
			}
			GUI.setBalance(nuvSpiller.getNavn(), nuvSpiller.getPenge());
			GUI.removeCar(feltnummer, nuvSpiller.getNavn());
			GUI.setCar(1, nuvSpiller.getNavn());

			/**
			 * if-betingelse der bryder løkken når spilleren opnår 3000 penge eller derover.
			 */
			if (nuvSpiller.getPenge() >= 3000) {
				done = true;
				GUI.showMessage(Læs.laes("vundetBesked:") + " " + nuvSpiller.getNavn().toUpperCase() + "!!!!!");
			}
		}
	}

}

