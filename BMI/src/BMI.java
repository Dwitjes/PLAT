import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BMI {

                static Scanner input = new Scanner(System.in); 
                static String sex;
                static String jn;
                static double weight = 0;
                static double height = 0;
                static double waist = 0;
                static double bmi;
                static double WeightMin = 0;
                static double WeightMax = 0;
                static double HeightMin = 0;
                static double HeightMax = 0;
                static double WaistMin = 0;
                static double WaistMax = 0;
    
    public static void main(String[] args){
                inputgeslacht();
                minmax();
                inputgewicht();
                inputhoogte();
                inputtaille();
                closeinput();
                samenvatting();
                bmicalc();
                beoordeling();
                tailleadvies();
                disclaimer();
    }
   
   
        //Input Geslacht
        public static void inputgeslacht(){
                
                 
                System.out.print("Uw geslacht (M/V): ");  
                while(true) {
                               sex = input.next().toUpperCase();
                
                               if(sex.equals("F")){
                                               System.out.println("Bedoelt u met uw invoer (" + sex + ") 'V' (Vrouw)?");
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
        }
        
        
        // Get Min Max
        public static void minmax(){
        File MinMax = new File("Config/MinMax.csv");
                               
                    try {

                        Scanner sc = new Scanner(MinMax); 
                        
                        while (sc.hasNextLine()) {
                                String[] line = sc.nextLine().split(";");
                                
                                String InputClass = line[0];
                                double Min = Double.parseDouble(line[1]);
                                double Max = Double.parseDouble(line[2]);
                                
                                if(InputClass.equals("Weight")){
                                               WeightMin = Min;
                                               WeightMax = Max;
                                }
                                else if(InputClass.equals("Height")){
                                               HeightMin = Min;
                                               HeightMax = (Max/100);
                                }
                                else if(InputClass.equals("Waist")){
                                               WaistMin = Min;
                                               WaistMax = Max;
                                }
            }
            sc.close();       
                    } 
                    catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
        }
        
        //Input Gewicht
        public static void inputgewicht(){
                System.out.print("Uw gewicht in KG: ");  
                while(true) {
                               weight = input.nextDouble();
                               if(weight > WeightMin  && weight < WeightMax)
                                               break;
                               System.out.println("Ongeldig gewicht");
                               System.out.print("Uw gewicht in KG: ");  
                }
        }
        
        
        //Input Hoogte
        public static void inputhoogte(){
                System.out.print("Uw lengte in CM: ");
                while(true) {
                               height = (input.nextDouble()/100);
                               if(height > HeightMin && height < HeightMax)
                                               break;
                               System.out.println("Ongeldige lengte");
                               System.out.print("Uw lengte in CM: ");
                }
        }
        
        
        //Input Taille
        public static void inputtaille(){
                System.out.print("Uw taille in CM: ");
                while(true) {
                               waist = input.nextDouble();
                               if(waist > WaistMin && waist < WaistMax)
                                               break;
                               System.out.println("Ongeldige taillelengte");
                               System.out.print("Uw taille in CM: ");
                }
        }
        
        // Closing input variable
        public static void closeinput(){
                input.close();
        }
        
        //Samenvatting
        public static void samenvatting(){
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
        }
        
        //Berekening BMI
        public static void bmicalc(){
                bmi = weight/(height * height);                              
                System.out.println("Uw BMI is " + Math.round(bmi));
        }
        
        // Beoordeling
        public static void beoordeling(){
                File BMIAdvies = new File("Config/BMIAdvies.csv");
                               
                try {

                               Scanner sc = new Scanner(BMIAdvies); 
                        
                               while (sc.hasNextLine()) {
                                               String[] line = sc.nextLine().split(";");

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
        }
        
        //Taille advies
        public static void tailleadvies(){
        File TaileAdvies = new File("Config/TailleAdvies.csv");
                               
                    try {

                        Scanner sc = new Scanner(TaileAdvies); 
                        
                        while (sc.hasNextLine()) {
                                String[] line = sc.nextLine().split(";");

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
                    System.out.println(" ");
        }
                    
        //Disclaimer
        public static void disclaimer(){
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
