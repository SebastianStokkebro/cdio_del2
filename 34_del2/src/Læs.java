import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Klassen læser den vedhæftede fil i hovedmappen,
 * og returnerer en specifik linje afhængigt af dens titel som streng.
 * @author Sebastian
 *
 */
public class Læs {

	public static String laes(String str) {
		String fil = "feltRegler.txt";
		BufferedReader reader;
		String besked = "";
		try {
			reader = new BufferedReader(new FileReader(fil));
			String nuværendeLinje;
			while ((nuværendeLinje = reader.readLine()) != null) {
				if (nuværendeLinje.equals(str)) {
					besked = reader.readLine();
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return besked;
	}
}

