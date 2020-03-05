// Devon Gadarowski 2019

import java.util.HashSet;
import java.util.Collections;
import java.util.Arrays;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList; 

// TestCase01: Basic test of FindIndex()
// TestCase02: Longer test of FindIndex()
// TestCase03: Search for element not in the array using FindIndex()
// TestCase04: Test of FindIndex() with array of length 1
// TestCase05: Test of FindIndex() with almost-sorted array of length 2
// TestCase06: Test of FindIndex() with sorted array of length 2
// TestCase07: Test of FindIndex() with empty array
// TestCase08: Test of FindIndex() with a sorted array
// TestCase09: Test of FindIndex() with almost-sorted array containing int min/max values
// TestCase10: Test of FindIndex() with sorted array containing many duplicate values
// TestCase11: Test of FindIndex() with many large almost-sorted arrays. Checks for O(logn) runtime
// TestCase12: Basic test of GeneratePowerSet() using Integers
// TestCase13: Basic test of GeneratePowerSet() using Strings
// TestCase14: Basic test of GeneratePowerSet() using custom object Bauble
// TestCase15: Test of GeneratePowerSet() with an array containing duplicate objects
// TestCase16: Test of GeneratePowerSet() with an array containing null objects
// TestCase17: Test of GeneratePowerSet() with an empty array
// TestCase18: Test of GeneratePowerSet() with an array containing a single object
// TestCase19: Test of GeneratePowerSet() with an array containing two objects
// TestCase20: Test of GeneratePowerSet() with an arrays containing the same objects in different orders

public class HW1Test
{
	// ===========
	// =Problem 1=
	// ===========

	// Basic example
	private static boolean testCase01()
	{
		int array[] = {30, 67, 89, -73, -5, 0};

		for (int i = 0; i < array.length; i++)
		{
			if (HW1.FindIndex(array, array[i]) != i)
			{
				return false;
			}
		}

		for (int i = array.length - 1; i >= 0; i--)
		{
			if (HW1.FindIndex(array, array[i]) != i)
			{
				return false;
			}
		}

		return true;
	}

	// Longer example
	private static boolean testCase02()
	{
		int array[] = {-43, -35, -34, -32, -15, 0, 13, 25, 26, 45, -100, -99, -98};

		for (int i = 0; i < array.length; i++)
		{
			if (HW1.FindIndex(array, array[i]) != i)
			{
				return false;
			}
		}

		for (int i = array.length - 1; i >= 0; i--)
		{
			if (HW1.FindIndex(array, array[i]) != i)
			{
				return false;
			}
		}

		return true;
	}

	// Search for an element that is not in the array
	private static boolean testCase03()
	{
		int array[] = {1, 2, 4, 6, 8, -9, -8, -1};

		return HW1.FindIndex(array, 11) == -1;
	}

	// Short example (1 element)
	private static boolean testCase04()
	{
		int array[] = {47};

		if (HW1.FindIndex(array, 47) != 0)
		{
			return false;
		}

		if (HW1.FindIndex(array, -17) != -1)
		{
			return false;
		}

		return true;
	}

	// Short example (2 elements)
	private static boolean testCase05()
	{
		int array[] = {3768, -9007};

		for (int i = 0; i < array.length; i++)
		{
			if (HW1.FindIndex(array, array[i]) != i)
			{
				return false;
			}
		}

		for (int i = array.length - 1; i >= 0; i--)
		{
			if (HW1.FindIndex(array, array[i]) != i)
			{
				return false;
			}
		}

		return true;
	}

	// Short example sorted (2 elements)
	private static boolean testCase06()
	{
		int array[] = {3768, 9007};

		for (int i = 0; i < array.length; i++)
		{
			if (HW1.FindIndex(array, array[i]) != i)
			{
				return false;
			}
		}

		for (int i = array.length - 1; i >= 0; i--)
		{
			if (HW1.FindIndex(array, array[i]) != i)
			{
				return false;
			}
		}

		return true;
	}

	// Empty Array example
	private static boolean testCase07()
	{
		int array[] = new int[0];

		return HW1.FindIndex(array, -1) == -1;
	}

	// Already sorted example
	private static boolean testCase08()
	{
		int array[] = {-56, 17, 689, 1990, 4334, 5007};

		for (int i = 0; i < array.length; i++)
		{
			if (HW1.FindIndex(array, array[i]) != i)
			{
				return false;
			}
		}

		for (int i = array.length - 1; i >= 0; i--)
		{
			if (HW1.FindIndex(array, array[i]) != i)
			{
				return false;
			}
		}

		return true;
	}

	// Almost sorted array with Integer.MAX/MIN_VALUE example
	private static boolean testCase09()
	{
		int array[] = {10, 11, 13, 17, Integer.MAX_VALUE, Integer.MIN_VALUE, 2, 3, 5};

		if (!(HW1.FindIndex(array, 11) == 1))
		{
			return false;
		}

		if (!(HW1.FindIndex(array, 2) == 6))
		{
			return false;
		}

		if (!(HW1.FindIndex(array, Integer.MAX_VALUE) == 4))
		{
			return false;
		}

		if (!(HW1.FindIndex(array, Integer.MIN_VALUE) == 5))
		{
			return false;
		}

		return true;
	}

	// Sorted array with duplicate values
	private static boolean testCase10()
	{
		int array[] = {-7, -7, -7, -7, -7, -7, -7, 7, 7, 7, 7, 7, 7, 7};

		if (!(HW1.FindIndex(array, -7) >= 0 && HW1.FindIndex(array, -7) <= 6))
		{
			return false;
		}

		if (!(HW1.FindIndex(array, 7) >= 7 && HW1.FindIndex(array, 7) <= 13))
		{
			return false;
		}

		return true;
	}

	// Really long example to test if search is logarithmic (1,000,000 elements)
	private static boolean testCase11()
	{
		int numTests = 100000;

		long bigTime = 0;
		long smallTime = 0;

		int smallArray[] = new int[250000];
		int bigArray[] = new int[1000000];

		for (int i = 0; i < bigArray.length - (bigArray.length / 7); i++)
		{
			bigArray[i] = i;
		}

		for (int i = 0; i < (bigArray.length / 7); i++)
		{
			bigArray[bigArray.length - (bigArray.length / 7) + i] = i - (bigArray.length / 7) * 10;
		}

		for (int i = 0; i < smallArray.length - (smallArray.length / 7); i++)
		{
			smallArray[i] = i;
		}

		for (int i = 0; i < (smallArray.length / 7); i++)
		{
			smallArray[smallArray.length - (smallArray.length / 7) + i] = i - (smallArray.length / 7) * 10;
		}

		for (int tests = 0; tests < numTests; tests++)
		{
			int index = (int) (Math.random() * bigArray.length);

			long before = System.currentTimeMillis();
			if(HW1.FindIndex(bigArray, bigArray[index]) != index)
			{
				return false;
			}
			long after = System.currentTimeMillis();

			bigTime += (after - before);
		}

		for (int tests = 0; tests < numTests; tests++)
		{
			int index = (int) (Math.random() * smallArray.length);

			long before = System.currentTimeMillis();
			if(HW1.FindIndex(smallArray, smallArray[index]) != index)
			{
				return false;
			}
			long after = System.currentTimeMillis();

			smallTime += (after - before);
		}

		// This will fail if FindIndex() is linear
		if (bigTime > 3 * smallTime)
		{
			return false;
		}

		return true;
	}

	// ===========
	// =Problem 3=
	// ===========

	private static boolean compareSets(Object[][] arr1, Object[][] arr2)
	{
		HashSet<HashSet<Object>> set1 = new HashSet<>();
		HashSet<HashSet<Object>> set2 = new HashSet<>();

		for (int i = 0; i < arr1.length; i++)
		{
			HashSet<Object> s = new HashSet<>();
			for (int j = 0; j < arr1[i].length; j++)
			{
				s.add(arr1[i][j]);
			}
			set1.add(s);
		}

		for (int i = 0; i < arr2.length; i++)
		{
			HashSet<Object> s = new HashSet<>();
			for (int j = 0; j < arr2[i].length; j++)
			{
				s.add(arr2[i][j]);
			}
			set2.add(s);
		}

		return set1.equals(set2);
	}

	// Basic test with Integers
	private static boolean testCase12()
	{
		Integer array[] = {1, 2, 5, 6, 7};

		Object powerset[][] = HW1.GeneratePowerSet(array);

		Object expectedResult[][] = {
			{1}, {2}, {5}, {6}, {7}, {1, 2}, {1, 5}, {1, 6}, {1, 7}, {2, 5}, {2, 6}, {2, 7},
			{5, 6}, {5, 7}, {6, 7}, {1, 2, 5}, {1, 2, 6}, {1, 2, 7}, {1, 5, 6}, {1, 5, 7},
			{2, 5, 6}, {2, 5, 7}, {1, 2, 5, 6}, {1, 2, 5, 7}, {1, 2, 6, 7}, {1, 5, 6, 7}, {5, 6, 7},
			{2, 6, 7}, {1, 6, 7}, {2, 5, 6, 7}, {1, 2, 5, 6, 7}, {}
		};

		return compareSets(powerset, expectedResult);		
	}

	// Basic test with Strings
	private static boolean testCase13()
	{
		String array[] = {"batman", "porschecayenne", "hotel", "india", "banana", "", "VWGTI"};

		Object powerset[][] = HW1.GeneratePowerSet(array);

		Object expectedResult[][] = {
			{"batman"}, {"porschecayenne"}, {"hotel"}, {"india"}, {"banana"}, {"batman", "porschecayenne"},
			{"batman", "hotel"}, {"batman", "india"}, {"batman", "banana"}, {"porschecayenne", "hotel"},
			{"porschecayenne", "india"}, {"porschecayenne", "banana"}, {"hotel", "india"},
			{"hotel", "banana"}, {"india", "banana"}, {"batman", "porschecayenne", "hotel"},
			{"batman", "porschecayenne", "india"}, {"batman", "porschecayenne", "banana"},
			{"batman", "hotel", "india"}, {"batman", "hotel", "banana"},
			{"porschecayenne", "hotel", "india"}, {"porschecayenne", "hotel", "banana"},
			{"batman", "porschecayenne", "hotel", "india"}, {"batman", "porschecayenne", "hotel", "banana"},
			{"batman", "porschecayenne", "india", "banana"}, {"batman", "hotel", "india", "banana"},
			{"hotel", "india", "banana"}, {"porschecayenne", "india", "banana"},
			{"batman", "india", "banana"}, {"porschecayenne", "hotel", "india", "banana"},
			{"batman", "porschecayenne", "hotel", "india", "banana"}, {}, {"batman", ""},
			{"porschecayenne", ""}, {"hotel", ""}, {"india", ""}, {"banana", ""}, {"batman", "porschecayenne", ""},
			{"batman", "hotel", ""}, {"batman", "india", ""}, {"batman", "banana", ""}, {"porschecayenne", "hotel", ""},
			{"porschecayenne", "india", ""}, {"porschecayenne", "banana", ""}, {"hotel", "india", ""},
			{"hotel", "banana", ""}, {"india", "banana", ""}, {"batman", "porschecayenne", "hotel", ""},
			{"batman", "porschecayenne", "india", ""}, {"batman", "porschecayenne", "banana", ""},
			{"batman", "hotel", "india", ""}, {"batman", "hotel", "banana", ""},
			{"porschecayenne", "hotel", "india", ""}, {"porschecayenne", "hotel", "banana", ""},
			{"batman", "porschecayenne", "hotel", "india", ""}, {"batman", "porschecayenne", "hotel", "banana", ""},
			{"batman", "porschecayenne", "india", "banana", ""}, {"batman", "hotel", "india", "banana", ""},
			{"hotel", "india", "banana", ""}, {"porschecayenne", "india", "banana", ""},
			{"batman", "india", "banana", ""}, {"porschecayenne", "hotel", "india", "banana", ""},
			{"batman", "porschecayenne", "hotel", "india", "banana", ""}, {""}, {"batman", "VWGTI"},
			{"porschecayenne", "VWGTI"}, {"hotel", "VWGTI"}, {"india", "VWGTI"}, {"banana", "VWGTI"},
			{"batman", "porschecayenne", "VWGTI"}, {"batman", "hotel", "VWGTI"}, {"batman", "india", "VWGTI"},
			{"batman", "banana", "VWGTI"}, {"porschecayenne", "hotel", "VWGTI"}, {"porschecayenne", "india", "VWGTI"},
			{"porschecayenne", "banana", "VWGTI"}, {"hotel", "india", "VWGTI"}, {"hotel", "banana", "VWGTI"},
			{"india", "banana", "VWGTI"}, {"batman", "porschecayenne", "hotel", "VWGTI"},
			{"batman", "porschecayenne", "india", "VWGTI"}, {"batman", "porschecayenne", "banana", "VWGTI"},
			{"batman", "hotel", "india", "VWGTI"}, {"batman", "hotel", "banana", "VWGTI"},
			{"porschecayenne", "hotel", "india", "VWGTI"}, {"porschecayenne", "hotel", "banana", "VWGTI"},
			{"batman", "porschecayenne", "hotel", "india", "VWGTI"}, {"batman", "porschecayenne", "hotel", "banana", "VWGTI"},
			{"batman", "porschecayenne", "india", "banana", "VWGTI"}, {"batman", "hotel", "india", "banana", "VWGTI"},
			{"hotel", "india", "banana", "VWGTI"}, {"porschecayenne", "india", "banana", "VWGTI"},
			{"batman", "india", "banana", "VWGTI"}, {"porschecayenne", "hotel", "india", "banana", "VWGTI"},
			{"batman", "porschecayenne", "hotel", "india", "banana", "VWGTI"}, {"VWGTI"},
			{"batman", "", "VWGTI"}, {"porschecayenne", "", "VWGTI"}, {"hotel", "", "VWGTI"},
			{"india", "", "VWGTI"}, {"banana", "", "VWGTI"}, {"batman", "porschecayenne", "", "VWGTI"},
			{"batman", "hotel", "", "VWGTI"}, {"batman", "india", "", "VWGTI"},
			{"batman", "banana", "", "VWGTI"}, {"porschecayenne", "hotel", "", "VWGTI"},
			{"porschecayenne", "india", "", "VWGTI"}, {"porschecayenne", "banana", "", "VWGTI"},
			{"hotel", "india", "", "VWGTI"}, {"hotel", "banana", "", "VWGTI"},
			{"india", "banana", "", "VWGTI"}, {"batman", "porschecayenne", "hotel", "", "VWGTI"},
			{"batman", "porschecayenne", "india", "", "VWGTI"}, {"batman", "porschecayenne", "banana", "", "VWGTI"},
			{"batman", "hotel", "india", "", "VWGTI"}, {"batman", "hotel", "banana", "", "VWGTI"},
			{"porschecayenne", "hotel", "india", "", "VWGTI"}, {"porschecayenne", "hotel", "banana", "", "VWGTI"},
			{"batman", "porschecayenne", "hotel", "india", "", "VWGTI"},
			{"batman", "porschecayenne", "hotel", "banana", "", "VWGTI"},
			{"batman", "porschecayenne", "india", "banana", "", "VWGTI"},
			{"batman", "hotel", "india", "banana", "", "VWGTI"},
			{"hotel", "india", "banana", "", "VWGTI"},
			{"porschecayenne", "india", "banana", "", "VWGTI"},
			{"batman", "india", "banana", "", "VWGTI"},
			{"porschecayenne", "hotel", "india", "banana", "", "VWGTI"},
			{"batman", "porschecayenne", "hotel", "india", "banana", "", "VWGTI"}, {"", "VWGTI"}
		};

		return compareSets(powerset, expectedResult);		
	}

	// Basic test with custom object Baubles
	private static boolean testCase14()
	{
		Bauble array[] = {new Bauble(0, 0), new Bauble(1, 50), new Bauble(25, 99), new Bauble(-1, -20)};

		Object powerset[][] = HW1.GeneratePowerSet(array);

		Object expectedResult[][] = {
			{},
			{new Bauble(0, 0)},
			{new Bauble(1, 50)},
			{new Bauble(0, 0), new Bauble(1, 50)},
			{new Bauble(25, 99)},
			{new Bauble(0, 0), new Bauble(25, 99)},
			{new Bauble(1, 50), new Bauble(25, 99)},
			{new Bauble(0, 0), new Bauble(1, 50), new Bauble(25, 99)},
			{new Bauble(-1, -20)},
			{new Bauble(0, 0), new Bauble(-1, -20)},
			{new Bauble(1, 50), new Bauble(-1, -20)},
			{new Bauble(0, 0), new Bauble(1, 50), new Bauble(-1, -20)},
			{new Bauble(25, 99), new Bauble(-1, -20)},
			{new Bauble(0, 0), new Bauble(25, 99), new Bauble(-1, -20)},
			{new Bauble(1, 50), new Bauble(25, 99), new Bauble(-1, -20)},
			{new Bauble(0, 0), new Bauble(1, 50), new Bauble(25, 99), new Bauble(-1, -20)},
		};

		return compareSets(powerset, expectedResult);		
	}

	// Duplicate element example
	private static boolean testCase15()
	{
		String array[] = {"batman", "porschecayenne", "VWGTI", "hotel", "india", "banana", "", "VWGTI"};

		Object powerset[][] = HW1.GeneratePowerSet(array);

		return powerset == null;		
	}

	// null element example
	private static boolean testCase16()
	{
		Integer array[] = {26, 99, null, 34, 70, 98, 22, 7};

		Object powerset[][] = HW1.GeneratePowerSet(array);

		return powerset == null;		
	}

	// Empty set example
	private static boolean testCase17()
	{
		Object array[] = {};

		Object powerset[][] = HW1.GeneratePowerSet(array);

		return compareSets(powerset, new Object[1][0]);		
	}

	// Single element examaple
	private static boolean testCase18()
	{
		Byte array[] = {(byte) 100};

		Object powerset[][] = HW1.GeneratePowerSet(array);

		Byte expectedResult[][] = {{}, {(byte) 100}};

		return compareSets(powerset, expectedResult);		
	}

	// Two element example
	private static boolean testCase19()
	{
		String array[] = {"a", "b"};

		Object powerset[][] = HW1.GeneratePowerSet(array);

		String expectedResult[][] = {{}, {"a"}, {"b"}, {"a", "b"}};

		return compareSets(powerset, expectedResult);		
	}

	// Sorted/Unsorted Example
	private static boolean testCase20()
	{
		Integer array[] = {1, 2, 3, 4, 5, 6};

		Object powerset[][] = HW1.GeneratePowerSet(array);

		Integer expectedResult[][] = {
			{}, {1}, {2}, {3},
			{4}, {5}, {6}, {1, 2},
			{1, 3}, {1, 4}, {1, 5}, {1, 6},
			{2, 3}, {2, 4}, {2, 5}, {2, 6},
			{3, 4}, {3, 5}, {3, 6}, {4, 5},
			{4, 6}, {5, 6}, {1, 2, 3}, {1, 2, 4},
			{1, 2, 5}, {1, 2, 6}, {1, 3, 4}, {1, 3, 5},
			{1, 3, 6}, {1, 4, 5}, {1, 4, 6}, {1, 5, 6},
			{2, 3, 4}, {2, 3, 5}, {2, 3, 6}, {2, 4, 5},
			{2, 4, 6}, {3, 4, 5}, {3, 4, 6}, {4, 5, 6},
			{1, 2, 3, 4}, {1, 2, 3, 5}, {1, 2, 3, 6}, {1, 2, 4, 5},
			{1, 2, 4, 6}, {1, 3, 4, 5}, {1, 3, 4, 6}, {2, 3, 4, 5},
			{2, 3, 4, 6}, {2, 4, 5, 6}, {3, 4, 5, 6}, {1, 2, 3, 4, 5},
			{1, 2, 3, 4, 6}, {1, 3, 4, 5, 6}, {1, 2, 4, 5, 6}, {2, 3, 4, 5, 6},
			{1, 2, 3, 5, 6}, {2, 5, 6}, {2, 3, 5, 6}, {1, 3, 5, 6},
			{1, 4, 5, 6}, {1, 2, 5, 6}, {3, 5, 6}, {1, 2, 3, 4, 5, 6},
		};

		if (!compareSets(powerset, expectedResult))
		{
			return false;
		}

		// shuffle the array and generate a new powerset
		Collections.shuffle(Arrays.asList(array));
		powerset = HW1.GeneratePowerSet(array);

		if (!compareSets(powerset, expectedResult))
		{
			return false;
		}

		return true;
	}

	private static final boolean CREATE_REPORT_FILE = false; // Creates a txt file containing output
	private static final boolean INFO = true; // Includes test cases descriptions in output

	// Run all test cases and generate a report
	public static void main(String [] args) throws IOException
	{
		StringBuilder s = new StringBuilder();

		s.append("====================\n");
		s.append("     Homework 1     \n");
		s.append("====================\n");
		s.append("-----PROBLEM 1-----\n");
		s.append(" Test Case 01: " + ((testCase01()) ? "PASS" : "FAIL") + ((INFO) ? " <- (Basic Test)\n" : "\n"));
		s.append(" Test Case 02: " + ((testCase02()) ? "PASS" : "FAIL") + ((INFO) ? " <- (Longer Basic Test)\n" : "\n"));
		s.append(" Test Case 03: " + ((testCase03()) ? "PASS" : "FAIL") + ((INFO) ? " <- (Search for missing element)\n" : "\n"));
		s.append(" Test Case 04: " + ((testCase04()) ? "PASS" : "FAIL") + ((INFO) ? " <- (Search an array of length 1)\n" : "\n"));
		s.append(" Test Case 05: " + ((testCase05()) ? "PASS" : "FAIL") + ((INFO) ? " <- (Search an array of length 2)\n" : "\n"));
		s.append(" Test Case 06: " + ((testCase06()) ? "PASS" : "FAIL") + ((INFO) ? " <- (Search an array of length 2 (sorted))\n" : "\n"));
		s.append(" Test Case 07: " + ((testCase07()) ? "PASS" : "FAIL") + ((INFO) ? " <- (Search an empty array)\n" : "\n"));
		s.append(" Test Case 08: " + ((testCase08()) ? "PASS" : "FAIL") + ((INFO) ? " <- (Search a sorted array)\n" : "\n"));
		s.append(" Test Case 09: " + ((testCase09()) ? "PASS" : "FAIL") + ((INFO) ? " <- (Search an array with Int MIN/MAX)\n" : "\n"));
		s.append(" Test Case 10: " + ((testCase10()) ? "PASS" : "FAIL") + ((INFO) ? " <- (Search an array with duplicate values) (BONUS)\n" : "\n"));
		s.append(" Test Case 11: " + ((testCase11()) ? "PASS" : "FAIL") + ((INFO) ? " <- (Tests for O(log(n)) runtime)\n" : "\n"));
		s.append("-----PROBLEM 3-----\n");
		s.append(" Test Case 12: " + ((testCase12()) ? "PASS" : "FAIL") + ((INFO) ? " <- (Basic Test with Integers)\n" : "\n"));
		s.append(" Test Case 13: " + ((testCase13()) ? "PASS" : "FAIL") + ((INFO) ? " <- (Basic Test with Strings)\n" : "\n"));
		s.append(" Test Case 14: " + ((testCase14()) ? "PASS" : "FAIL") + ((INFO) ? " <- (Basic Test with custom objects)\n" : "\n"));
		s.append(" Test Case 15: " + ((testCase15()) ? "PASS" : "FAIL") + ((INFO) ? " <- (Test with duplicate objects)\n" : "\n"));
		s.append(" Test Case 16: " + ((testCase16()) ? "PASS" : "FAIL") + ((INFO) ? " <- (Test with null objects)\n" : "\n"));
		s.append(" Test Case 17: " + ((testCase17()) ? "PASS" : "FAIL") + ((INFO) ? " <- (Test with empty array)\n" : "\n"));
		s.append(" Test Case 18: " + ((testCase18()) ? "PASS" : "FAIL") + ((INFO) ? " <- (Test with array of length 1)\n" : "\n"));
		s.append(" Test Case 19: " + ((testCase19()) ? "PASS" : "FAIL") + ((INFO) ? " <- (Test with array of length 2)\n" : "\n"));
		s.append(" Test Case 20: " + ((testCase20()) ? "PASS" : "FAIL") + ((INFO) ? " <- (Test with shuffled arrays)\n" : "\n"));
		s.append("====================");


		if (CREATE_REPORT_FILE)
		{
			Files.write(Paths.get("./HW1Report.txt"), s.toString().getBytes());
		}

		System.out.println(s);
	}
	
}



class Bauble
{
	int a;
	int b;

	Bauble()
	{
		a = (int) (Math.random() * Integer.MAX_VALUE);
		b = (int) (Math.random() * Integer.MAX_VALUE);
	}

	Bauble(int a, int b)
	{
		this.a = a;
		this.b = b;
	}

	@Override
	public int hashCode()
	{
		return ((Integer) a).hashCode() * 31 + ((Integer) b).hashCode();
	}

	@Override
	public boolean equals(Object o)
	{
		if (o instanceof Bauble)
			return (this.a == ((Bauble) o).a && this.b == ((Bauble) o).b);
		else
			return false;
	}
}
