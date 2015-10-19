import java.util.Scanner;

public class BMI {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        double weight = 0;
        double height = 0;
        double bmi;
        double Minstreefgewicht;
        double Maxstreefgewicht;
        
        //Input weight
        System.out.print("Uw gewicht in KG: ");  
        while(true) {
        	weight = input.nextDouble();
            if(weight > 0 && weight <= 999)
               break;
            System.out.println("Ongeldig gewicht");
            System.out.print("Uw gewicht in KG: ");  
        }
        
        //Input Height
        System.out.print("Uw lengte in CM: ");
        while(true) {
            height = (input.nextDouble()/100);
            if(height > 0 && height <= 3)
               break;
            System.out.println("Ongeldige lengte");
            System.out.print("Uw lengte in CM: ");
        }
        
        // Closing inut variable
        input.close();
        
        //Berekening BMI
        bmi = weight/(height * height);      		
        System.out.println("Uw BMI is " + Math.round(bmi));
        
        // Beoordeling
        if(bmi<18.5){
        	System.out.println("Ondergewicht: Lager dan 18.5");
        }
        else if(bmi<25){
        	System.out.println("Normaal: 18.5-24.9 ");
        }
        else if(bmi<30){
        	 System.out.println("Overgewicht: 25-29.9");
        }
        else{
        	System.out.println("Obese: 30 of hoger");
        }
        
        //Advies
        Minstreefgewicht = (18.5*(height * height));
        Maxstreefgewicht = (25*(height * height));
        
        if(bmi<18.5){
        	System.out.println("Uw streefgewicht is " + Math.round(Minstreefgewicht) + " KG");
        	System.out.println("Om een BMI van 18,5 te halen moet u " + Math.round(Minstreefgewicht-weight) + " Kilo aankomen");
        }
        else if(bmi>=25){
            System.out.println("Uw streefgewicht is " + Math.round(Maxstreefgewicht) + " KG");
            System.out.println("Om een BMI van onder de 25 te halen moet u " + Math.round(weight-Maxstreefgewicht) + " Kilo afvallen");
        }	
    }
}