import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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

