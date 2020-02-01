package loufek_p1;
import java.util.Scanner;

public class Decrypter {

	Scanner input = new Scanner(System.in);
	
	public int userArray[];
	public int decryptedValue;
	
	public Decrypter () {
		userArray = new int[4];
		decryptedValue = 0;
	}
	
	public int decrypt (int userInput) {
		//Convert integer to array
        for ( int i = 3 ; i >= 0 ; i--) { //Takes numbers and fills array backwards
        	userArray[i] = userInput % 10; //Convert integer to array with remainders and division
        	userInput /= 10;
        }
        
		System.out.println("");
		
		//Swap second digit with fourth
		int placeholder = userArray[1];
		userArray[1] = userArray[3];
		userArray[3] = placeholder;
		
		//Swap first digit with third digit
		placeholder = userArray[0];
		userArray[0] = userArray[2];
		userArray[2] = placeholder;
		
		//Add 3 to each digit and subtract 10 if >= to 10
		for ( int i = 0 ; i < 4 ; i++) {
        	userArray[i] += 3;
        	if (userArray[i] >= 10)
        		userArray[i] -= 10; 
        }

		//Convert array back into integer form
		int j=0;
		for (int i = 3 ; i >=0 ; i--) {
			decryptedValue += (userArray[i])*(Math.pow(10,j));
			j++;
		}
		//return decryption
		return decryptedValue;
	}	
}