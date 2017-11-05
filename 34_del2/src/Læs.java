import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Læs {

	public static String laes(String str) {
		String file = "feltRegler.txt";
		BufferedReader reader;
		String string = "";
		try {
			reader = new BufferedReader(new FileReader(file));
			String currentLine;
			while ((currentLine = reader.readLine()) != null) {
				if (currentLine.equals(str)) {
					string = reader.readLine();
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return string;
	}
}
