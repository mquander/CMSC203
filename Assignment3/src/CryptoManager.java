
/**
 * Class to encrypt and decrypt a string using
 * the Caesar and Bellaso techniques
 * @author Mquan
 *
 */
public class CryptoManager {
	
	private static final char LOWER_BOUND = ' '; //95
	private static final char UPPER_BOUND = '_'; //32
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1; //64

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		int charOutOfRange = 0;
		boolean outOfRandge;
		
		for(int i = 0; i < plainText.length(); i++) {
			if(plainText.charAt(i) < LOWER_BOUND || plainText.charAt(i) > UPPER_BOUND) {
				charOutOfRange++;
			}
		}
		if(charOutOfRange > 0) 
			outOfRandge = false;
		else
			outOfRandge = true;
		
		return outOfRandge;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		
		String encryptedText = "";
		if(stringInBounds(plainText)) {
			
			while(key > UPPER_BOUND) {
				key -= RANGE;
			}
			while(key < 0) {
				key += LOWER_BOUND;
			}
			int start;
			for(int i = 0; i < plainText.length(); i++) {
				start = ((int) plainText.charAt(i) + key);
				while(start > UPPER_BOUND) {
					start = start - RANGE;
				} 
				encryptedText += (char)start;
			}
			
		}
		else {
			encryptedText = "String not in bounds";
		}
		return encryptedText;
		//throw new RuntimeException("method not implemented");
	}
	
	/**
	 * Encrypts a string according to the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		
		String encryptedText = "";
		if(stringInBounds(plainText)) {
			
			int start, encryptedCharASCIInum;
			for (int i = 0; i < plainText.length(); i++){
				start = (int)plainText.charAt(i);
				encryptedCharASCIInum = (start + (int)bellasoStr.charAt(i % bellasoStr.length()));
				
				while (encryptedCharASCIInum > UPPER_BOUND){			
					encryptedCharASCIInum -= RANGE;
				}
				encryptedText += (char)encryptedCharASCIInum;
			}
			
		}
		else {
			encryptedText = "String out of bounds";
		}
		return encryptedText;
		//throw new RuntimeException("method not implemented");
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		String decryptedText = "";
		while(key > UPPER_BOUND) {
			key -= RANGE;
		}
		while(key < 0) {
			key += LOWER_BOUND;
		}
		int start;
		for(int i = 0; i < encryptedText.length(); i++) {
			start = (int)encryptedText.charAt(i) - key;
			while(start < LOWER_BOUND) {
				start += RANGE;
			}
			decryptedText += (char)start;
		}
		return decryptedText;
		//throw new RuntimeException("method not implemented");
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		String decryptedText = "";
		int start, decryptedCharASCIInum;
		
		for(int i = 0; i < encryptedText.length(); i++) {
			start = (int)encryptedText.charAt(i);
			decryptedCharASCIInum = start - (int)bellasoStr.charAt(i % bellasoStr.length());
			while (decryptedCharASCIInum < LOWER_BOUND) {
				decryptedCharASCIInum += RANGE;
			}
			decryptedText += (char)decryptedCharASCIInum;
		}
		return decryptedText;
		
		//throw new RuntimeException("method not implemented");
	}
}
