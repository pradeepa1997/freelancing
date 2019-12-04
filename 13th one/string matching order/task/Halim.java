// Devon Gadarowski 2019

import java.util.Arrays;

public class Halim
{
	public static void main(String [] args)
	{
		StringMatch StringMatch= new StringMatch();
		// Expected Output: [1, 11]
		int [] a = StringMatch.CheckStringMatch("Halim gets alignment".toCharArray(), "ali".toCharArray());
		if (a != null) Arrays.sort(a);
		System.out.println(Arrays.toString(a));
	}
}
