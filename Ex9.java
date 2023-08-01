/**
 * From Chapter 7, p. 558
 * Removes duplicate characters from a string of lowercase letters
 */

import java.util.Arrays;
public class Ex9 {

	private static Character[] removeDuplicates(Character[] inpArray)
	{
		int[] seenCharacter = new int[26];
		Character[] temp = new Character[inpArray.length];
		int tempLength = 0;
		for (int i = 0; i < inpArray.length; i++)
		{
			if (seenCharacter[((int) inpArray[i]) - 97] == 0)
			{
				seenCharacter[((int) inpArray[i]) - 97] = 1;
				temp[tempLength] = inpArray[i];
				tempLength += 1;
			}
		}
		Character[] finalArray = new Character[tempLength];
		for (int i = 0; i < tempLength; i++)
		{
			finalArray[i] = temp[i];
		}
		
		return finalArray;
	}
	
	public static void main(String[] args)
	{
		Character[] test = {'b','d','a','b','f','a','g','a','a','f'};
		System.out.println(Arrays.toString(Ex9.removeDuplicates(test)));
		Character[] test2 = {'b','b','b','b'};
		System.out.println(Arrays.toString(Ex9.removeDuplicates(test2)));
	}
}
