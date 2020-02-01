package loufek_p1;
import java.util.Scanner;

public class Application {
	
	static Scanner input = new Scanner(System.in);
	
	//Global Variables
	public int userInput;
	public String formattedUserInput;
	public int encryptedValue;
	public int decryptedValue;
	public int choice;
	
	public Application() {
		userInput = 0;
		formattedUserInput = "null";
		encryptedValue = 0;
		decryptedValue = 0;
		choice = 0;
	}
	
	public static void main(String[] args) {
		Application app = new Application(); 
		//prompt user if they wish to encrypt or decrypt
		app.EncryptOrDecrypt(); 
		
		//Get user input and dont return until its a proper number
		app.getProperUserInput();
		
		//Properly formats user input with zeroes on the end if less than 1000
		app.formattedUserInput = String.format("%04d", app.userInput);
		
		//run encrypter or decrypter and print to the screen
		switch (app.choice) {
			case 1: //Run encrypter
				Encrypter Encrypter = new Encrypter(); 
				app.encryptedValue = Encrypter.encrypt(app.userInput); //Calls encrypter
				String formattedEncryptValue = String.format("%04d", app.encryptedValue); //Reformats the returned value
				System.out.printf("%s encrypts to %s", app.formattedUserInput, formattedEncryptValue); //Prints returned value
				break; 
			case 2: //Run decrypter
				Decrypter Decrypter = new Decrypter();
				app.decryptedValue = Decrypter.decrypt(app.userInput); //calls decrypter
				String formattedDecryptValue = String.format("%04d", app.decryptedValue); //Reformats the returned value
				System.out.printf("%s decrypts to %s", app.formattedUserInput, formattedDecryptValue); //Prints returned value
				break;
			default:
		}
		
	} //End of main method
	
	
	public void EncryptOrDecrypt() {
		System.out.println("Welcome to Joshua Loufek's Java encryption method");
		//while loop to get a proper input decision for encryption or decryption
		while (true){
			System.out.print("If you would like to encrypt a number please enter 1. Otherwise enter 2 to decrypt a number: ");
			choice = input.nextInt();
			if (choice == 1 || choice == 2 )
				break;
			System.out.println("\nInvalid entry. Please choose to either encrypt or decrypt.");
		} 
	}


	public void getProperUserInput() {
		//Loop to get 4 digit input from user. Repeats until proper number received
		while(true) { 
			System.out.print("Please input the 4 digit number you want to encrypt or decrypt: ");
			userInput = input.nextInt(); //scan user input
			if (userInput <= 9999 && userInput >= 0) { //checks user input for size. if good while loop breaks.
				break;
			}
			System.out.println("Input must be 4 digits (between 0 and 9999).");
			} //End while loop
	}
}
