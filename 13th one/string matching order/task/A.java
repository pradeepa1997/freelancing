import java.util.Arrays;


public class A
{
	public static void main(String [] args)
	{	StringMatch StringMatch= new StringMatch();
		// Expected Output: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18]
		int [] a = StringMatch.CheckStringMatch("aaaaaaaaaaaaaaaaaaaaa".toCharArray(), "aaa".toCharArray());
		if (a != null) Arrays.sort(a);
		System.out.println(Arrays.toString(a));

		// Expected Output: [0, 1]
		a = StringMatch.CheckStringMatch("aaaaaaaaaaaaaaaaaaaaa".toCharArray(), "aaaaaaaaaaaaaaaaaaaa".toCharArray());
		if (a != null) Arrays.sort(a);
		System.out.println(Arrays.toString(a));
	}
}

