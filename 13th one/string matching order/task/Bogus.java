import java.util.Arrays;


public class Bogus
{
	public static void main(String [] args)
	{
		// Expected Output: []
		StringMatch StringMatch= new StringMatch();
		int [] a = StringMatch.CheckStringMatch("".toCharArray(), "".toCharArray());
		if (a != null) Arrays.sort(a);
		System.out.println(Arrays.toString(a));

		// Expected Output: []
		a = StringMatch.CheckStringMatch("".toCharArray(), "Have a great turkey day.".toCharArray());
		if (a != null) Arrays.sort(a);
		System.out.println(Arrays.toString(a));

		// Expected Output: []
		a = StringMatch.CheckStringMatch("Have a great turkey day.".toCharArray(), "".toCharArray());
		if (a != null) Arrays.sort(a);
		System.out.println(Arrays.toString(a));

		// Expected Output: null
		a = StringMatch.CheckStringMatch(null, "".toCharArray());
		if (a != null) Arrays.sort(a);
		System.out.println(Arrays.toString(a));

		// Expected Output: null
		a = StringMatch.CheckStringMatch("Have a great turkey day.".toCharArray(), null);
		if (a != null) Arrays.sort(a);
		System.out.println(Arrays.toString(a));

		// Expected Output: null
		a = StringMatch.CheckStringMatch(null, null);
		if (a != null) Arrays.sort(a);
		System.out.println(Arrays.toString(a));

		// Expected Output: []
		a = StringMatch.CheckStringMatch("Have a great".toCharArray(), "Have a great turkey day.".toCharArray());
		if (a != null) Arrays.sort(a);
		System.out.println(Arrays.toString(a));
	}
}