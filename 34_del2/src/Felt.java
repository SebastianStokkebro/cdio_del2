/**[
 * laver pladen 12 felter
 * @author Alan
 * @author David
 */
import java.awt.Color;
import desktop_fields.Field;
import desktop_fields.Street;
import desktop_resources.GUI;

public class Felt{
	
	public Felt() {
	 Field[] field = new Field[12];
	field[0] =new Street.Builder()
		.setTitle("Start")
		.setSubText("")
		.setDescription("Spillerstart")
		.setBgColor(new Color(255, 255, 255))
		.build();
	field[1] = new Street.Builder()
			.setTitle("Tower")
			.setSubText("+250")
			.setDescription("Tower") 
			.setBgColor(new Color(215, 216, 208))
			.build();
	field[2] = new Street.Builder()
			.setTitle("Crater")
			.setDescription("Crater")
			.setSubText("-100")
			.setBgColor(new Color(21, 76, 100))
			.build();
	field[3] = new Street.Builder()
			.setTitle("Place Gates")
			.setDescription("Place Gates")
			.setSubText("+100")
			.setBgColor(new Color(55, 153, 107))
			.build();
	field[4] = new Street.Builder()
			.setTitle("Cold Desert")
			.setDescription("Cold Desert")
			.setSubText("-20")
			.setBgColor(new Color(100, 80, 50))
			.build();
	field[5] = new Street.Builder()
			.setTitle("Walled City")
			.setDescription("Walled City")
			.setSubText("+180")
			.setBgColor(new Color(156, 107, 211))
			.build();
	field[6] = new Street.Builder()
			.setTitle("Monastery")
			.setDescription("Monastery")
			.setSubText("0")
			.setBgColor(new Color(108, 183, 154))
			.build();
	field[7] = new Street.Builder()
			.setTitle("Black Cave")
			.setDescription("Black Cave")
			.setSubText("-70")
			.setBgColor(new Color(63, 68, 62))
			.build();
	field[8] = new Street.Builder()
			.setTitle("Huts in The Mountain")
			.setDescription("Huts in The Mountain")
			.setSubText("+60")
			.setBgColor(new Color(23, 124, 35))
			.build();
	field[9] = new Street.Builder()
			.setTitle("The Werewall (Werewolf-wall)")
			.setDescription("The Werewall (Werewolf-wall)")
			.setSubText("-80")
			.setBgColor(new Color(124, 28, 28))
			.build();
	field[10] = new Street.Builder()
			.setTitle("The Pit")
			.setDescription("The Pit")
			.setSubText("-50")
			.setBgColor(new Color(119, 103, 65))
			.build();
	field[11] = new Street.Builder()
			.setTitle("Gold Mine")
			.setDescription("Gold Mine")
			.setSubText("+650")
			.setBgColor(new Color(226, 159, 26))
			.build();

	GUI.create(field);
	}		
}
