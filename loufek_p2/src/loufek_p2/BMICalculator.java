package loufek_p2;
import java.util.Scanner;

public class BMICalculator {

	Scanner input = new Scanner(System.in);
	
	//Global variable declarations
	public int unitType;
	public float userData[];
	public float userBMI;
	public String userBMICategory;
	public int weight;
	
	public BMICalculator() { //Constructor
		unitType = 0;
		userData = new float[2];
		userBMI = 0;
		userBMICategory = "Empty";
	}
	

	public static void main(String[] args) { 
	    BMICalculator app = new BMICalculator();
	    app.readUserData();
	    app.calculateBmi();
	    app.displayBmi();
	}
	
	
	public void readUserData() {
		//Ask user for their preferred measurement system
		unitType = readUnitType();
		//Get the user's data
		readMeasurementData(unitType);
	}
	
	private int readUnitType () {
		int unitType = 0;
		//Get user choice and repeat until user chooses a measurement system
		while (true) { 
			System.out.println("Please choose which measurement system you would like to use.");
			System.out.print("1. Metric\n2. Imperial\nUser Choice: ");
			unitType = input.nextInt();
			//IF statement to check for each of two valid inputs
			if (unitType == 1 || unitType==2 ) {
				//break when one is met
				break;
			}
			//Display invalid entry and go again
			System.out.println("Invalid entry.");
		}
		return unitType;
	}
	
	private void readMeasurementData (int unitType) {
		//Switch statement for each choice
		switch (unitType) { 
		case 1: //Metric System
			readMetricData();
			break;
		case 2: //Imperial System
			readImperialData();
			break;
		default: 
		}
	}
		
	private void readMetricData() {
		//Get both data points from user and check each time for negative numbers
		System.out.print("\nPlease enter your height in meters: ");
		setHeight();
		checkForNegative();
		System.out.print("Please enter your weight kilograms: ");
		setWeight();
		checkForNegative();
	}
	
	private void readImperialData() {
		//Get both data points from user and check each time for negative numbers
		System.out.print("\nPlease enter your height in inches: ");
		setHeight();
		checkForNegative();
		System.out.print("Please enter your weight in pounds: ");
		setWeight();
		checkForNegative();
	}
	
	public void checkForNegative() {
		if (userData[0] < 0 || userData[1] < 0) {
			System.out.println("You cannot enter a negative number");
			System.exit(0); //Exits program if height or weight is negative
		}
	}
	
	public void calculateBmi() {		
		switch (unitType) {
			case 1: 
				//Metric System calculations
				userBMI = (userData[1])/(userData[0]*userData[0]);
				//Get user bmi category
				userBMICategory = calculateBMICategory(userBMI);
				break;
			case 2: 
				//Imperial System calculations
				userBMI = (703*userData[1])/(userData[0]*userData[0]);
				//get user bmi category
				userBMICategory = calculateBMICategory(userBMI);
				break;
			default:  
		}
	}
	
	private String calculateBMICategory (float userBMI) {
		//If statements depending on which range user BMI fits within
		if (userBMI < 18.5) return "Underweight";
		if (userBMI >= 18.5 && userBMI < 25) return "Normal Weight";
		if (userBMI >= 25 && userBMI < 30) return "Overweight";
		return "Obese";
		//always will return one of these
	}
	
	public void displayBmi() {
		//Display BMI chart
		displayBMIChart();
		//Switch statement depending on user's metric of choice
		//Display user inputs and Display user BMI
		switch (unitType) {
			case 1: //Metric System
				System.out.printf("\nHeight: " + getHeight() + " meters\nWeight: " + getWeight() + " kilograms\nBMI: " + getBMI() + "\nWeight Category: " + getBMICategory() );
				break;
			case 2: //Imperial System
				System.out.printf("\nHeight: " + getHeight() + " inches\nWeight: " + getWeight() + " pounds\nBMI: " + getBMI() + "\nWeight Category: " + getBMICategory() );
				break;
			default:  
		}

	}
	
	public void displayBMIChart() {
		System.out.println("\nBMI Categories: ");
		System.out.println("Underweight = <18.5");
		System.out.println("Normal weight = 18.5–24.9");
		System.out.println("Overweight = 25–29.9");
		System.out.println("Obesity = BMI of 30 or greater");
	}
	
	
	public void setWeight() {
		userData[1] = input.nextFloat();
	}
	
	public float getWeight() {
		return userData[1];
	}
	
	public void setHeight() {
		userData[0] = input.nextFloat();
	}
	
	public float getHeight() {
		return userData[0];
	}
	
	public float getBMI() {
		return userBMI;
	}
	
	public String getBMICategory() {
		return userBMICategory;
	}
	
}
