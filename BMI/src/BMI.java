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
        System.out.print("Enter your weight in KG: ");  
        while(true) {
        	weight = input.nextDouble();
            if(weight > 0 && weight <= 999)
               break;
            System.out.println("Invalid weight");
            System.out.print("Enter your weight in KG: ");  
        }

        //Input Height
        System.out.print("Enter your height in CM: ");
        while(true) {
            height = (input.nextDouble()/100);
            if(height > 0 && height <= 3)
               break;
            System.out.println("Invalid weight");
            System.out.print("Enter your height in CM: ");
        }
        
        //Berekening BMI
        bmi = weight/(height * height);      		
        System.out.println("Your BMI is " + Math.round(bmi));
        
        // Beoordeling
        if(bmi<18.5){
        	System.out.println("Underweight: Under 18.5");
        }
        else if(bmi<25){
        	System.out.println("Normal: 18.5-24.9 ");
        }
        else if(bmi<30){
        	 System.out.println("Overweight: 25-29.9");
        }
        else{
        	System.out.println("Obese: 30 or over");
        }
        
        //Advies
        Minstreefgewicht = (18.5*(height * height));
        Maxstreefgewicht = (25*(height * height));
        
        if(bmi<18.5){
        	System.out.println("Uw streefgewicht is " + Math.round(Minstreefgewicht) + " KG");
        	System.out.println("Om een BMI van 18,5 te halen moet u " + (Minstreefgewicht-weight) + " Kilo aankomen");
        }
        else if(bmi>=25){
            System.out.println("Uw streefgewicht is " + Math.round(Maxstreefgewicht) + " KG");
            System.out.println("Om een BMI van 25 te halen moet u " + (weight-Maxstreefgewicht) + " Kilo afvallen");
        }	
    }
}