import static org.junit.Assert.*;

import org.junit.Test;

public class BMI_Unit_Test {
	
	@Test
	public void testValidateSexQM() {
		BMI tst = new BMI();
		String expected0 = "M";
		String output = tst.ValidateSex(new String[] {"q","m"}, null);
		assertEquals(expected0,  output);
	}
	
	@Test
	public void testValidateSexKV() {
		BMI tst = new BMI();
		String expected0 = "V";
		String output = tst.ValidateSex(new String[] {"k","v"}, null);
		assertEquals(expected0,  output);
	}
	
	@Test
	public void testValidateSexFJ() {
		BMI tst = new BMI();
		String expected0 = "V";
		String output = tst.ValidateSex(new String[] {"f"}, new String[] {"j"});
		assertEquals(expected0,  output);
	}
	
	@Test
	public void testValidateSexFNM() {
		BMI tst = new BMI();
		String expected0 = "M";
		String output = tst.ValidateSex(new String[] {"f","M"}, new String[] {"n"});
		assertEquals(expected0,  output);
	}
	
	@Test
	public void testValidateSexQWEFF() {
		BMI tst = new BMI();
		String expected0 = "V";
		String output = tst.ValidateSex(new String[] {"q","W","E","f","F"}, new String[] {"n","j"});
		assertEquals(expected0,  output);
	}
	
	@Test
	public void testValidateWeight() {
		BMI tst = new BMI();
		double expected0 = 90.0;
		double output = tst.ValidateWeight(new Double[] {1000.0,90.0});
		assertEquals(expected0,  output,  0);
	}
	
	@Test
	public void testInputValidateHeight() {
		BMI tst = new BMI();
		double expected0 = 185.0;
		double output = tst.ValidateHeight(new Double[] {400.0,185.0});
		assertEquals(expected0,  output,  0);
	}

	@Test
	public void testValidateWaist() {
		BMI tst = new BMI();
		double expected0 = 105.0;
		double output = tst.ValidateWaist(new Double[] {0.0,200.0,105.0});
		assertEquals(expected0,  output,  0);
	}
	
	
	@Test
	public void testMinMaxHeight() {
		BMI tst = new BMI();
		double expected0 = 0;
		double expected1 = 300;
		double[] output = tst.MinMax("Height");
		assertEquals(expected0,  output[0],  0);
		assertEquals(expected1,  output[1],  0);
	}
	
	@Test
	public void testMinMaxWaist() {
		BMI tst = new BMI();
		double expected0 = 50;
		double expected1 = 170;
		double[] output = tst.MinMax("Waist");
		assertEquals(expected0,  output[0],  0);
		assertEquals(expected1,  output[1],  0);
	}
	
	@Test
	public void testMinmaxWeight() {
		BMI tst = new BMI();
		double expected0 = 0;
		double expected1 = 1000;
		double[] output = tst.MinMax("Weight");
		assertEquals(expected0,  output[0],  0);
		assertEquals(expected1,  output[1],  0);
	}
	
	@Test
	public void testSamenvattingMan() {
		BMI tst = new BMI();
		String expected0 = "U bent een Man";
		String expected1 = "Uw gewicht is: 80.0 kg";
		String expected2 = "Uw lengte is: 185 cm";
		String expected3 = "Uw taillelengte is: 100 cm";
		String[] output = tst.samenvatting("M",80,185,100);
		assertEquals(expected0,  output[0]);
		assertEquals(expected1,  output[1]);
		assertEquals(expected2,  output[2]);
		assertEquals(expected3,  output[3]);
	}
	
	@Test
	public void testSamenvattingVrouw() {
		BMI tst = new BMI();
		String expected0 = "U bent een Vrouw";
		String expected1 = "Uw gewicht is: 60.0 kg";
		String expected2 = "Uw lengte is: 170 cm";
		String expected3 = "Uw taillelengte is: 80 cm";
		String[] output = tst.samenvatting("V",60,170,80);
		assertEquals(expected0,  output[0]);
		assertEquals(expected1,  output[1]);
		assertEquals(expected2,  output[2]);
		assertEquals(expected3,  output[3]);
	}
	
	@Test
	public void testBmicalc() {
		BMI tst = new BMI();
		double expected0 = 26;
		double output = tst.bmicalc(90, 185);
		assertEquals(expected0,  Math.round(output),  0);
	}

	@Test
	public void testTailleadviesMan70() {
		BMI tst = new BMI();
		String expected0 = "Gezond";
		String output = tst.tailleadvies("M",70);
		assertEquals(expected0,output);
	}
	
	@Test
	public void testTailleadviesMan96() {
		BMI tst = new BMI();
		String expected0 = "Verhoogd risico";
		String output = tst.tailleadvies("M",96);
		assertEquals(expected0,output);
	}
	
	@Test
	public void testTailleadviesMan117() {
		BMI tst = new BMI();
		String expected0 = "Sterk verhoogd risico";
		String output = tst.tailleadvies("M",117);
		assertEquals(expected0,output);
	}
	
	@Test
	public void testTailleadviesvrouw76() {
		BMI tst = new BMI();
		String expected0 = "Gezond";
		String output = tst.tailleadvies("V",76);
		assertEquals(expected0,output);
	}
	
	@Test
	public void testTailleadviesVrouw84() {
		BMI tst = new BMI();
		String expected0 = "Verhoogd risico";
		String output = tst.tailleadvies("V",84);
		assertEquals(expected0,output);
	}
	
	@Test
	public void testTailleadviesVrouw92() {
		BMI tst = new BMI();
		String expected0 = "Sterk verhoogd risico";
		String output = tst.tailleadvies("V",92);
		assertEquals(expected0,output);
	}
	
	@Test
	public void testBMIadvies15() {
		BMI tst = new BMI();
		String expected0 = "Onderwicht betekent dat je lichter bent dan goed is voor je gezondheid, oftewel ondervoed.";
		String output = tst.bmiadvies(15);
		assertEquals(expected0,output);
	}
	
	@Test
	public void testBMIadvies22() {
		BMI tst = new BMI();
		String expected0 = "Gefeliciteerd, je hebt een gezond gewicht. Houden zo!";
		String output = tst.bmiadvies(22);
		assertEquals(expected0,output);
	}
	
	@Test
	public void testBMIadvies29() {
		BMI tst = new BMI();
		String expected0 = "Overgewicht betekent dat je zwaarder bent dan goed is voor je gezondheid.";
		String output = tst.bmiadvies(29);
		assertEquals(expected0,output);
	}
	
	@Test
	public void testBMIadvies35() {
		BMI tst = new BMI();
		String expected0 = "Obesitas betekent dat je veel zwaarder bent dan goed is voor je gezondheid.";
		String output = tst.bmiadvies(35);
		assertEquals(expected0,output);
	}
	
	@Test
	public void testDisclaimer() {
		BMI tst = new BMI();
		String expected0 = "********************************************* Disclaimer *********************************************\r\n" 
			+ "Bovengenoemde berekening is gebasseerd op mannen en vrouwen met een leeftijd tussen de 18 en 50 jaar.\r\n" 
			+ "Aan deze adviezen kunnen geen rechten worden ontleend. Bovengenoemd berekening en adviezen zijn slechts een richtlijn.\r\n"
			+ "Wij adviseren u altijd een arts te raadplegen.";
		String output = tst.disclaimer();
		assertEquals(expected0,output);
	}
}