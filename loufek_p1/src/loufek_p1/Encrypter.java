package loufek_p1;
import java.util.Scanner;

public class Encrypter {
	
	public int userArray[];
	public int encryptedValue;
	
	public Encrypter () {
		userArray = new int[4];
		encryptedValue = 0;
	}
	
	Scanner input = new Scanner(System.in);
	
	public int encrypt (int userInput) {
		
		//Convert integer to array
        for ( int i = 3 ; i >= 0 ; i--) { //Takes numbers and fills array backwards
        	userArray[i] = userInput % 10; //Convert integer to array with remainders and division
        	userInput /= 10;
        }
        
		System.out.println("");
		
		//add 7 to EACH digit then divide by 10 and use the remainder for each digit
		for ( int i = 0 ; i < 4 ; i++) {
        	userArray[i] += 7;
        	userArray[i] = userArray[i] % 10;
        }		
		
		//Swap first digit with the third
		int placeholder;
		placeholder = userArray[0];
		userArray[0] = userArray[2];
		userArray[2] = placeholder;
		
		//Swap second digit with fourth
		placeholder = userArray[1];
		userArray[1] = userArray[3];
		userArray[3] = placeholder;
		
		//Convert array back into integer form
		int j=0;
		for (int i = 3 ; i >=0 ; i--) {
			encryptedValue += (userArray[i])*(Math.pow(10,j));
			j++;
		}
		//return encryption
		return encryptedValue;
	}	
}