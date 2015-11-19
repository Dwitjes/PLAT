import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BMI {
    public static void main(String[] args){
    	       
        //Declaraties
        String sex;
        String jn;
        double weight = 0;
        double height = 0;
        double waist = 0;
        double bmi;
        
        Scanner input = new Scanner(System.in);
        
      //Input Geslacht
        System.out.print("Uw geslacht (M/V): ");  
        while(true) {
        	sex = input.next().toUpperCase();
        	
        	if(sex.equals("F")){
        		System.out.println("Bedoeld u met uw invoer (" + sex + ") 'V' (Vrouw)?");
        		System.out.println("Toets 'J' om de waarde 'V' (Vrouw) te gebruiken");
        		System.out.println("Toets 'N' om nogmaals uw geslacht in te voeren");
        		jn = input.next().toUpperCase();
        		if(jn.equals("J")){
        			sex = "V";
        		}
        	}
            if(sex.equals("M")||sex.equals("V"))
               break;
            System.out.println("Ongeldig geslacht");
            System.out.print("Uw geslacht (M/V): ");
        }
        
        //Input Gewicht
        System.out.print("Uw gewicht in KG: ");  
        while(true) {
        	weight = input.nextDouble();
            if(weight > 0 && weight <= 999)
               break;
            System.out.println("Ongeldig gewicht");
            System.out.print("Uw gewicht in KG: ");  
        }
        
        //Input Hoogte
        System.out.print("Uw lengte in CM: ");
        while(true) {
            height = (input.nextDouble()/100);
            if(height > 0 && height <= 3)
               break;
            System.out.println("Ongeldige lengte");
            System.out.print("Uw lengte in CM: ");
        }
        
        //Input Taille
        System.out.print("Uw taille in CM: ");
        while(true) {
            waist = input.nextDouble();
            if(waist >=50 && waist < 170)
               break;
            System.out.println("Ongeldige taillelengte");
            System.out.print("Uw taille in CM: ");
        }
        
        // Closing input variable
        input.close();
        
        //Samenvatting
        System.out.println(" ");
        System.out.println("U heeft opgegeven:");
        if(sex.equals("M")){
        	System.out.println("U bent een Man");
        }
        else if(sex.equals("V"))
        {
        	System.out.println("U bent een Vrouw");
        }
        System.out.println("Uw gewicht is: " + weight + " kg");
        System.out.println("Uw lengte is: " + (Math.round(height*100)) + " cm");
        System.out.println("Uw taillelengte is: " + Math.round(waist) + " cm");
        System.out.println(" ");
        
        //Berekening BMI
        bmi = weight/(height * height);      		
        System.out.println("Uw BMI is " + Math.round(bmi));
        
        // Beoordeling
        File BMIAdvies = new File("Config/BMIAdvies.txt");
		
	    try {

	        Scanner sc = new Scanner(BMIAdvies); 
	        
	        while (sc.hasNextLine()) {
	        	String[] line = sc.nextLine().split(" - ");

	        	double BMIminTXT = Double.parseDouble(line[0]);
	        	double BMImaxTXT = Double.parseDouble(line[1]);
	        	String adviceTXT = line[2];
	        	
	        	if((bmi>=BMIminTXT)&&(bmi<BMImaxTXT))
                {
		        	System.out.println(adviceTXT.toString());
                }
            }
            sc.close();       
	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
        System.out.println(" ");
        
        //Taille advies
        File TaileAdvies = new File("Config/TailleAdvies.txt");
		
	    try {

	        Scanner sc = new Scanner(TaileAdvies); 
	        
	        while (sc.hasNextLine()) {
	        	String[] line = sc.nextLine().split(" - ");

	        	String sexTXT = line[0];
	        	int tailleminTXT = Integer.parseInt(line[1]);
	        	int taillemaxTXT = Integer.parseInt(line[2]);
	        	String adviceTXT = line[3];
	        	
	        	if(sexTXT.equals(sex)&&(waist>=tailleminTXT)&&(waist<taillemaxTXT))
                {
		        	System.out.println(adviceTXT.toString());
                }
            }
            sc.close();       
	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
  
        //Disclaimer
        File disclaimer = new File("Config/Disclaimer.txt");
	    try {

	        Scanner sc = new Scanner(disclaimer); 
	        while (sc.hasNextLine()) {
	        	System.out.println(sc.nextLine());
            }
            sc.close();      
	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
    }
}