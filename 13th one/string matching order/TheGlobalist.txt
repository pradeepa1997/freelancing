// Devon Gadarowski 2019

import java.util.Arrays;

public class TheGlobalist
{
	public static void main(String [] args)
	{
		String theGlobalist = "You were never truly loved\nYou've only been betrayed\nYou were never truly nurtured\nBy churches or the state\nYou left unprotected\nTo these wild and fragile lands\nThat you could rise up like a god\nArm yourself, you can be strong\nYou can build a nuclear power\nTransform the earth to your desire\nFree your mind from false beliefs\nYou can be the commander in chief\nYou can hide your true motives\nTo dismantle and destroy\nNow you finally have have the codes\nI have given you the code\n\nThere's no country left\nTo love and cherish it's gone\nIt's gone for good\nIt's you and me babe\nSurvivors\nTo hunt and gather memories\nOf the great nation we were\nThere's no countries left\nTo fight and conquer\nI think I destroyed them all\nIt's human nature\nThe greatest hunter will survive alone\nWith no one left to love\nThere's no country left\nTo love and cherish, it's gone\nYou know it's gone for good\nA trillion memories lost in\nSpace and time forever more\nI just wanted, I just needed to be loved";

		System.out.println(theGlobalist);
		System.out.println();

		// Expected Output: [490, 808]
		int [] a = StringMatch.CheckStringMatch(theGlobalist.toCharArray(), "country".toCharArray());
		if (a != null) Arrays.sort(a);
		System.out.println(Arrays.toString(a));

		// Expected Output: [0, 27, 53, 108, 227, 326, 360, 852]
		a = StringMatch.CheckStringMatch(theGlobalist.toCharArray(), "You".toCharArray());
		if (a != null) Arrays.sort(a);
		System.out.println(Arrays.toString(a));

		// Expected Output: [21, 971]
		a = StringMatch.CheckStringMatch(theGlobalist.toCharArray(), "loved".toCharArray());
		if (a != null) Arrays.sort(a);
		System.out.println(Arrays.toString(a));

		// Expected Output: [0]
		a = StringMatch.CheckStringMatch(theGlobalist.toCharArray(), theGlobalist.toCharArray());
		if (a != null) Arrays.sort(a);
		System.out.println(Arrays.toString(a));
	}
}
