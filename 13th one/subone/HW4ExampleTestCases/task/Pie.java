// Devon Gadarowski 2019


public class Pie
{
	public static void main (String [] args)
	{
		EgyptianFraction EgyptianFraction = new EgyptianFraction();
		int [] result = EgyptianFraction.egyptianFraction(22, 7);

		printEgyptianSum(result);
	}

	public static void printEgyptianSum(int [] result)
	{
		double decimal = 0;
		for (int i = 0; i < result.length; i++)
		{
			decimal += 1.0 / result[i];
		}

		System.out.printf("%.5f\n", decimal);
	}
}
