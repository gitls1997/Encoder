import java.util.Scanner;

public class EncoderClass {
	public static char offset;
	private static char [] table = { 'A', 'B', 'C', 'D', 'E',
							'F', 'G', 'H', 'I', 'J', 'K',
							'L', 'M', 'N', 'O', 'P', 'Q',
							'R', 'S', 'T', 'U', 'V', 'W',
							'X', 'Y', 'Z', '0', '1', '2',
							'3', '4', '5', '6', '7', '8',
							'9', '(', ')', '*', '+', ',',
							'-', '.', '/'};
	
	private static int findChar(char letter) {
		for(int i=0; i<table.length; i++) {
			if(table[i] == letter) return i;
		}
		return 0;
	}
	
	private static String Encoder(String sentence) {
		int offsetInt = findChar(offset);
		char encode [] = new char [sentence.length()];
		for(int i = 0; i< sentence.length(); i++) {
			if(sentence.charAt(i) == ' ') {
				encode[i] = ' ';
			}else {
				int encodedInt = findChar(sentence.charAt(i))-offsetInt;
				if(encodedInt <0) {
					encodedInt += table.length;
				}
				encode[i] = table[encodedInt];	
			}
		}
		String encoded = String.valueOf(encode);
		return (offset + encoded);
		
	}
	
	private static String Decoder(String sentence) {
		char offset = sentence.charAt(0);
		int offsetInt = findChar(offset);
		sentence = sentence.substring(1);
		char decode [] = new char [sentence.length()];
		for(int i = 0; i< sentence.length(); i++) {
			if(sentence.charAt(i) == ' ') {
				decode[i] = ' ';
			}else {
				int decodedInt = findChar(sentence.charAt(i))+offsetInt;
				if(decodedInt >43) {
					decodedInt -= table.length;
				}
				decode[i] = table[decodedInt];	
			}
		}
		return String.valueOf(decode);
		
	}
		
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char cont= ' ';
		do{
			System.out.print("Enter the plaintext: ");
			String text = sc.nextLine();
			System.out.print("Do you want to Encode or Decode? (E/D): ");
			String choice = sc.nextLine();
			if (choice.charAt(0) == 'E') {
				System.out.print("How many letters do you want to offset? ");
				offset = sc.nextLine().charAt(0);
				System.out.println(Encoder(text));
			}else if (choice.charAt(0) == 'D') {
				System.out.println(Decoder(text));
			}
			System.out.print("Do you want to continue? (Y/N): ");
			cont = sc.nextLine().charAt(0);
		}while(cont == 'Y');
		

	}

}
