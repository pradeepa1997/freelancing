// Devon Gadarowski 2019

import java.util.HashMap;
import java.util.Arrays;

// This file contains some basic testcases for the methods outlined in Homework 1. To use this
// file, create another file called "HW1.java" in the same directory as this file (or if you are
// using Eclipse then put "HW1.java" and this file in the same project default package). Cut and
// paste all of your assignment code into the "HW1.java" file and then compile and run this file.
// This file will automatically find your homework methods (assuming they are named correctly) and
// test them. Make sure to make some other test cases. These test cases are not comprehensive, so
// try to think of creative ways to wreck your algorithms. - Devon

public class HW1ExampleTestCases
{

	// ===========
	// =Problem 1=
	// ===========

	// Basic example
	private static boolean testCase01()
	{
		int array[] = {300, 604, 893, -732, -599, 0};

		// Search for all elments in the array
		for (int i = 0; i < array.length; i++)
		{
			if (HW1.FindIndex(array, array[i]) != i)
			{
				return false;
			}
		}

		// Search for all elements in the array in a different order
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
	private static boolean testCase02()
	{
		int array[] = {11, 23, 45, 67, 88, -91, -83, -1};

		return (HW1.FindIndex(array, 11000) == -1);
	}

	// ===========
	// =Problem 3=
	// ===========

	// Helper to make output array comparisons easy
	private static boolean compareSets(Object[][] arr1, Object[][] arr2)
	{
		HashMap<HashMap<Object, Integer>, Integer> set1 = new HashMap<>();
		HashMap<HashMap<Object, Integer>, Integer> set2 = new HashMap<>();

		for (int i = 0; i < arr1.length; i++)
		{
			HashMap<Object, Integer> s = new HashMap<>();
			for (int j = 0; j < arr1[i].length; j++)
			{
				s.put(arr1[i][j], s.getOrDefault(arr1[i][j], 0) + 1);
			}
			set1.put(s, set1.getOrDefault(s, 0) + 1);
		}

		for (int i = 0; i < arr2.length; i++)
		{
			HashMap<Object, Integer> s = new HashMap<>();
			for (int j = 0; j < arr2[i].length; j++)
			{
				s.put(arr2[i][j], s.getOrDefault(arr2[i][j], 0) + 1);
			}
			set2.put(s, set2.getOrDefault(s, 0) + 1);
		}

		return set1.equals(set2);
	}

	// A little function to help you debug array output errors :)
	public static void print2DArray(Object[][] arr)
	{
		for (int i = 0; i < arr.length; i++)
		{
			System.out.println(Arrays.toString(arr[i]));
		}
	}

	// Basic test with Integers
	private static boolean testCase03()
	{
		Integer array[] = {1, 2, 5, 6, 7};

		Object powerset[][] = HW1.GeneratePowerSet(array);

		Integer expectedResult[][] = {
			{1}, {2}, {5}, {6}, {7}, {1, 2}, {1, 5}, {1, 6}, {1, 7}, {2, 5}, {2, 6}, {2, 7},
			{5, 6}, {5, 7}, {6, 7}, {1, 2, 5}, {1, 2, 6}, {1, 2, 7}, {1, 5, 6}, {1, 5, 7},
			{2, 5, 6}, {2, 5, 7}, {1, 2, 5, 6}, {1, 2, 5, 7}, {1, 2, 6, 7}, {1, 5, 6, 7}, {5, 6, 7},
			{2, 6, 7}, {1, 6, 7}, {2, 5, 6, 7}, {1, 2, 5, 6, 7}, {}
		};

		return compareSets(powerset, expectedResult);		
	}

	// Duplicate element example (input array is not a set) (GeneratePowerSet should return null)
	private static boolean testCase04()
	{
		String array[] = {"batman", "porschecayenne", "VWGTI", "hotel", "india", "banana", "", "VWGTI"};

		Object powerset[][] = HW1.GeneratePowerSet(array);

		return powerset == null;		
	}

	// null element example (input array is not a set) (GeneratePowerSet should return null)
	private static boolean testCase05()
	{
		Integer array[] = {26, 99, null, 34, 70, 98, 22, 7};

		Object powerset[][] = HW1.GeneratePowerSet(array);

		return powerset == null;		
	}

	public static void main(String [] args)
	{
		StringBuilder s = new StringBuilder();

		s.append("====================\n");
		s.append("     Homework 1     \n");
		s.append("====================\n");
		s.append("-----PROBLEM 1-----\n");
		s.append(" Test Case 01: " + ((testCase01()) ? "PASS\n" : "FAIL\n"));
		s.append(" Test Case 02: " + ((testCase02()) ? "PASS\n" : "FAIL\n"));
		s.append("-----PROBLEM 3-----\n");
		s.append(" Test Case 03: " + ((testCase03()) ? "PASS\n" : "FAIL\n"));
		s.append(" Test Case 04: " + ((testCase04()) ? "PASS\n" : "FAIL\n"));
		s.append(" Test Case 05: " + ((testCase05()) ? "PASS\n" : "FAIL\n"));
		s.append("====================");

		System.out.println(s);
	}
}
