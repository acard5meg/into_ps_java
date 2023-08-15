/**
 * Implements a Caesar Cipher encoding and decoding method.
 * The cipher shifts the letters the number entered to produce an encrypted message
 * Improvement would be to wrap this within one method
 * Improvement would be to wrap private methods into one method.
 * Programming Project 9 Chapter 8
 */

public class Cipher implements MessageEncoder, MessageDecoder {

	private int shift;
	
	public Cipher(int mov)
	{
		shift = mov % 26;
	}
	
	public String encode(String secretMessage)
	{
		String newWord = "";
		for (int i = 0; i < secretMessage.length(); i++)
		{	
			int numLetter = (int) secretMessage.charAt(i);
			if ((numLetter >= 97) && (numLetter <= 122))
				newWord += shifterLow(secretMessage.charAt(i), true);
			else if ((numLetter >= 65) && (numLetter <= 90))
			{
				newWord += shifterHigh(secretMessage.charAt(i), true);
			}
			else
				newWord += secretMessage.charAt(i);
			
		}
		return newWord;
	}

	
	public String decode(String cipherText)
	{
		String newWord = "";
		for (int i = 0; i < cipherText.length(); i++)
		{	
			int numLetter = (int) cipherText.charAt(i);
			if ((numLetter >= 97) && (numLetter <= 122))
				newWord += shifterLow(cipherText.charAt(i), false);
			else if ((numLetter >= 65) && (numLetter <= 90))
			{
				newWord += shifterHigh(cipherText.charAt(i), false);
			}
			else
				newWord += cipherText.charAt(i);
			
		}
		return newWord;
	}
	
	
	
	
	private char shifterLow(char oneChar, boolean encode)
	{
		int charNum = (int) oneChar;
		if (encode)
		{
			charNum += shift;
			if (charNum > 122)
				charNum -= 26;
		}
		else
		{
			charNum -= shift;
			if (charNum < 97)
				charNum += 26;
		}
		return (char) charNum;

			
	}
	private char shifterHigh(char oneChar, boolean encode)
	{
		
		int charNum = (int) oneChar;
		if (encode)
		{
			charNum += shift;
			if (charNum > 90)
				charNum -= 26;
		}
		else 
		{
			charNum -= shift;
			if (charNum < 65)
				charNum += 26;
		}
		return (char) charNum;
	}

	public static void main(String[] args)
	{
		Cipher test = new Cipher(25);
		String ciphered = test.encode("middle-Outz");
		System.out.println(ciphered);
		String normal = test.decode(ciphered);
		System.out.println(normal);
	}
	


}
