// Devon Gadarowski 2019

import java.util.Arrays;


public class Explorers
{
	public static void main(String [] args)
	{
		StringMatch StringMatch= new StringMatch();
		String explorers = "Once I hoped\nTo seek the new and unknown\nThis planet's overrun\nThere's nothing left for you or for me\nDon't give in, we can\nWalk through the fields\nAnd feeling nature's glow\nBut all the land is owned\nThere's none left for you or for me\nWho will win?\n'Cause I concede\n\nFree me\nFree me\nFree me from this world\nI don't belong here\nIt was a mistake imprisoning my soul\nCan you free me\nFree me from this world\n\nA world lush and blue\nWith rivers running wild\nThey'll be re-routed South\nWith none left for you or for me\nDon't give in\nHear the engines roar\nAnd save our crops from drought\nBut when the black gold's in doubt\nThere's none left for you or for me\nFusing helium-3, our last hope\n\nAnd free me\nAnd free me\nFree me from this world\nWe don't belong here\nIt was a mistake imprisoning our souls\nCan you free me\nFree me from this world\n\nFree me\nI'll free you\nFree us from this world\nWe don't belong here\nIt was a mistake imprisoning our souls\nCan you free me\nFree me from this world\n\nRunning around in circles feeling caged by endless rules\nCan you free me, free me from this world\nGo to sleep";

		System.out.println(explorers);
		System.out.println();

		// Expected Output: [659]
		int [] a = StringMatch.CheckStringMatch(explorers.toCharArray(), "helium-3".toCharArray());
		if (a != null) Arrays.sort(a);
		System.out.println(Arrays.toString(a));

		// Expected Output: [268, 276, 284, 381, 708, 808, 833, 955]
		a = StringMatch.CheckStringMatch(explorers.toCharArray(), "Free me".toCharArray());
		if (a != null) Arrays.sort(a);
		System.out.println(Arrays.toString(a));
	}
}
