import java.awt.EventQueue;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BMI_GUI {

	private JFrame frame;
	private JTextField textFieldWeight;
	private JLabel lblHeight;
	private JTextField textFieldHeight;
	private JButton btnCalculateBMI;
	private JLabel lblBmiAdvice;
	private JTextArea textFieldBMI;
    private final static String newline = "\n";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BMI_GUI window = new BMI_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BMI_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWeight = new JLabel("Vul hier uw gewicht in KG");
		lblWeight.setBounds(23, 22, 160, 26);
		frame.getContentPane().add(lblWeight);
		
		textFieldWeight = new JTextField();
		textFieldWeight.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE )){

					arg0.consume();
				}
			}
		});
		textFieldWeight.setBounds(176, 25, 86, 20);
		frame.getContentPane().add(textFieldWeight);
		textFieldWeight.setColumns(10);
		
		lblHeight = new JLabel("Vul hier uw lengte in CM");
		lblHeight.setBounds(23, 64, 160, 26);
		frame.getContentPane().add(lblHeight);
		
		textFieldHeight = new JTextField();
		textFieldHeight.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE )){

					e.consume();
				}
			}
		});
		textFieldHeight.setColumns(10);
		textFieldHeight.setBounds(176, 67, 86, 20);
		frame.getContentPane().add(textFieldHeight);
		
		btnCalculateBMI = new JButton("Bereken uw BMI!");
		btnCalculateBMI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				Variables which are used after pressing button
				String weightStr = textFieldWeight.getText();
				weightStr = weightStr.trim();
				double weight = Double.parseDouble(weightStr);
				
//		        TO DO! Add to the input fields
//		        while(true) {
//		        	weight = Integer.parseInt(textFieldWeight.getText());
//		            if(weight > 0 && weight <= 999)
//		               break;
//		            JOptionPane.showMessageDialog(null, "Vul een gewicht in tussen de 0 en 1000 KG");  
//		        }
				
				String heightStr = textFieldHeight.getText();
				weightStr = weightStr.trim();
				double height = Double.parseDouble(heightStr);
				
//		        TO DO! Add to the input fields
//		        while(true) {
//		        	weight = Integer.parseInt(textFieldWeight.getText());
//		            if(weight > 0 && weight <= 999)
//		               break;
//		            JOptionPane.showMessageDialog(null, "Vul een gewicht in tussen de 0 en 1000 KG");  
//		        }
				
		        double bmi;
		        double Minstreefgewicht;
		        double Maxstreefgewicht;
		        
				bmi = weight/(height*height/10000);
				
//		        Advies
		        Minstreefgewicht = (18.5*(height * height/10000));
		        Maxstreefgewicht = (25*(height * height/10000));
				

//		        Output for BMI and advice text field
		        if(bmi<18.5){
		        	textFieldBMI.setText("Uw BMI is: " + Math.round(bmi) + "."
		        			+ newline
		        			+ "U heeft onder gewicht, uw BMI is lager dan 18.5." 
		        			+ newline 
		        			+ "Uw streefgewicht is " + Math.round(Minstreefgewicht) + " KG." 
		        			+ newline 
		        			+ "Om een BMI van 18,5 te halen moet u " + Math.round(Minstreefgewicht-weight) + " Kilo aankomen.");
		        }
		        else if(bmi<25){
		        	textFieldBMI.setText("Uw BMI is: " + Math.round(bmi) + "."
		    		        + newline
		    		        + "U heeft een normaal gewicht, uw BMI is tussen de 18.5-24.9.");
		        }
		        else if(bmi<30){
		        	textFieldBMI.setText("Uw BMI is: " + Math.round(bmi) + "."
		        			+ newline
		        			+ "U heeft overgewicht, uw BMI is hoger 25-29.9."
		    		        + newline
		    		        + "Uw streefgewicht is " + Math.round(Maxstreefgewicht) + " KG."
		    		        + newline
		    		        + "Om een BMI van onder de 25 te halen moet u " + Math.round(weight-Maxstreefgewicht)  + " Kilo afvallen.");
		        }
		        else{
		        	textFieldBMI.setText("Uw BMI is: " + Math.round(bmi) + "."
		    		        + newline
		    		        + "U bent obese, uw BMI is hoger dan 30."
		    		        + newline 
		    		        + "Uw streefgewicht is " + Math.round(Maxstreefgewicht) + " KG."
		    		        + newline
		    		        + "Om een BMI van onder de 25 te halen moet u " + Math.round(weight-Maxstreefgewicht)  + " Kilo afvallen.");
		        }	        
			}
		});
		
		btnCalculateBMI.setBounds(176, 112, 140, 23);
		frame.getContentPane().add(btnCalculateBMI);
		
		lblBmiAdvice = new JLabel("Uw BMI en advies:");
		lblBmiAdvice.setBounds(128, 154, 134, 26);
		frame.getContentPane().add(lblBmiAdvice);
		
		textFieldBMI = new JTextArea();
		textFieldBMI.setEditable(false);
		textFieldBMI.setText("");
		textFieldBMI.setBounds(23, 180, 401, 71);
		frame.getContentPane().add(textFieldBMI);
		textFieldBMI.setColumns(10);
	}

}
