import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class BMI {
	static String InputTxt = null;
	static double InputNumber = 0;
	static String sex;
	static String jn;
	static String[] sexTST;
	static String[] jnTST;
	static Double[] weightTST;
	static Double[] heightTST;
	static Double[] waistTST;
	static double weight;
	static double height;
	static double waist;
	static double bmi;
	static double Min;
	static double Max;
	private static Scanner scanner;

	public static void main(String[] args) {

		BMI tst = new BMI();
		tst.ValidateSex(sexTST, jnTST);
		tst.ValidateWeight(weightTST);
		tst.ValidateHeight(heightTST);
		tst.ValidateWaist(waistTST);
		tst.samenvatting(sex,weight,height,waist);
		tst.bmicalc(weight, height);
		tst.bmiadvies(bmi);
		tst.tailleadvies(sex,waist);
		tst.disclaimer();
	}

	// Input
	public String InvoerText() {
		scanner = new Scanner(System.in);
		InputTxt = scanner.next().toUpperCase();

		return InputTxt;
	}

	// Input
	public double InvoerGetal() {
		scanner = new Scanner(System.in);
		InputNumber = scanner.nextDouble();

		return InputNumber;
	}

	// Validate Geslacht
	public String ValidateSex(String[] sexTST, String[] jnTST) {
		System.out.println("Uw geslacht in (M/V): ");
		int i = 0;
		int j = 0;
		while (true) {
			if (sexTST == null) {
				this.InvoerText();
			} else {
				InputTxt = sexTST[i].toUpperCase();
			}
			sex = InputTxt;

			if (InputTxt.equals("F")) {
				System.out.println("Bedoelt u met uw invoer (" + sex + ") 'V' (Vrouw)?");
				System.out.println("Toets 'J' om de waarde 'V' (Vrouw) te gebruiken");
				System.out.println("Toets 'N' om nogmaals uw geslacht in te voeren");

				if (jnTST == null) {
					this.InvoerText();
				} else {
					InputTxt = jnTST[j].toUpperCase();
					j++;
				}
				jn = InputTxt;

				if (jn.equals("J")) {
					sex = "V";
				}
			}
			if (sex.equals("M") || sex.equals("V")) {
				break;
			}
			System.out.println("Ongeldig geslacht");
			i++;
			System.out.print("Uw geslacht (M/V): ");
		}
		return sex.toString();
	}

	// Validate Gewicht
	public double ValidateWeight(Double[] weightTST) {
		this.MinMax("Weight");
		System.out.println("Uw gewicht in KG: ");
		int i = 0;
		while (true) {
			if (weightTST == null) {
				this.InvoerGetal();
			} else {
				InputNumber = weightTST[i];
			}
			if (InputNumber > Min && InputNumber < Max) {
				weight = InputNumber;
				break;
			}
			System.out.println("Ongeldig gewicht");
			i++;
			System.out.print("Uw gewicht in KG: ");
		}
		return weight;
	}

	// Validate Hoogte
	public double ValidateHeight(Double[] heightTST) {
		this.MinMax("Height");
		System.out.print("Uw lengte in CM: ");
		int i = 0;
		while (true) {
			if (heightTST == null) {
				this.InvoerGetal();
			} else {
				InputNumber = heightTST[i];
			}
			if (InputNumber > Min && InputNumber < Max) {
				height = InputNumber;
				break;
			}
			System.out.println("Ongeldige lengte");
			i++;
			System.out.print("Uw lengte in CM: ");
		}
		return height;
	}

	// Validate Taille
	public double ValidateWaist(Double[] waistTST) {
		this.MinMax("Waist");
		System.out.print("Uw taille in CM: ");
		int i = 0;
		while (true) {
			if (waistTST == null) {
				this.InvoerGetal();
			} else {
				InputNumber = waistTST[i];
			}
			if (InputNumber > Min && InputNumber < Max) {
				waist = InputNumber;
				break;
			}
			System.out.println("Ongeldige taillelengte");
			i++;
			System.out.print("Uw taille in CM: ");
		}
		return waist;
	}

	// Get Min Max
	public double[] MinMax(String type) {
		File MinMax = new File("Config/MinMax.csv");

		try {
			Scanner sc = new Scanner(MinMax);
			while (sc.hasNextLine()) {
				String[] line = sc.nextLine().split(";");

				String InputClass = line[0];
				Min = Double.parseDouble(line[1]);
				Max = Double.parseDouble(line[2]);

				if (InputClass.equals(type)) {
					break;

				}
			}
			sc.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new double[] { Min, Max };

	}

	// Samenvatting
	public String[] samenvatting(String sex, double weight, double height, double waist) {
		System.out.println(" ");
		System.out.println("U heeft opgegeven:");
		String SamenvattingSex = null;
		if (sex.equals("M")) {
			SamenvattingSex = "U bent een Man";
			System.out.println("U bent een Man");
		} else if (sex.equals("V")) {
			SamenvattingSex = "U bent een Vrouw";
			System.out.println("U bent een Vrouw");
		}
		String SamenvattingGewicht = "Uw gewicht is: " + weight + " kg";
		String SamenvattingLengte = "Uw lengte is: " + (Math.round(height)) + " cm";
		String SamenvattingTaille = "Uw taillelengte is: " + Math.round(waist) + " cm";
		System.out.println("Uw gewicht is: " + weight + " kg");
		System.out.println("Uw lengte is: " + (Math.round(height)) + " cm");
		System.out.println("Uw taillelengte is: " + Math.round(waist) + " cm");
		System.out.println(" ");
		return new String[] { SamenvattingSex, SamenvattingGewicht, SamenvattingLengte, SamenvattingTaille };
	}

	// Berekening BMI
	public double bmicalc(double weight, double height) {
		bmi = weight / ((height / 100) * (height / 100));
		System.out.println("Uw BMI is " + Math.round(bmi));
		return bmi;
	}

	// BMI Advies
	public String bmiadvies(double bmi) {
		File BMIAdvies = new File("Config/BMIAdvies.csv");
		String adviceTXT = null;
		try {

			Scanner sc = new Scanner(BMIAdvies);

			while (sc.hasNextLine()) {
				String[] line = sc.nextLine().split(";");

				double BMIminTXT = Double.parseDouble(line[0]);
				double BMImaxTXT = Double.parseDouble(line[1]);
				adviceTXT = line[2];

				if ((bmi >= BMIminTXT) && (bmi < BMImaxTXT)) {
					System.out.print("Uw BMI gezondheid is : " +adviceTXT.toString());
					break;
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(" ");
		return adviceTXT;
	}
	
	// Taille advies
	public String tailleadvies(String sex, double waist) {
		File TaileAdvies = new File("Config/TailleAdvies.csv");
		String adviceTXT = null;
		try {

			Scanner sc = new Scanner(TaileAdvies);

			while (sc.hasNextLine()) {
				String[] line = sc.nextLine().split(";");

				String sexTXT = line[0];
				int tailleminTXT = Integer.parseInt(line[1]);
				int taillemaxTXT = Integer.parseInt(line[2]);
				adviceTXT = line[3];

				if (sexTXT.equals(sex) && (waist >= tailleminTXT) && (waist < taillemaxTXT)) {
					System.out.println("Uw taille gezondheid is : " +adviceTXT.toString());
					break;
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(" ");
		return adviceTXT;
	}

	// Disclaimer
	public String disclaimer() {
		String text = null;
		try {
			text = new String(Files.readAllBytes(Paths.get("Config/Disclaimer.txt")), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("");
		System.out.println(text);
		return text;
	}
}