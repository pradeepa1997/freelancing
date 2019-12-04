// Devon Gadarowski 2019

import java.util.Arrays;

public class DreamersBall
{
	public static void main(String [] args)
	{
		String dreamersBall = "Oh, I used to be your baby\nUsed to be your pride and joy, mmh\nYou used to take me dancing\nJust like any other boy\nBut now you've found another partner\nAnd left me like a broken toy\n\nOh it's someone else you're taking\nSomeone else you're playin' to\nHoney, though I'm aching\nKnow just what I have to do\nIf I can't have you when I'm wakin'\nI'll go to sleep and dream I'm with you\n\nOh, take me, take me, take me\nTo the dreamer's ball\nMmm, I'll be right on time and I'll dress so fine\nYou're gonna love me when you see me, I won't have to worry\nTake me, take me\nPromise not to wake me till it's morning\n(Ooh, it's all been true)\n\nWhat do you say about that, hey honey?\nAre you gonna take me to that dreamer's ball?\nI'd like that\nRight on that forty second street\nWay down down town we must go\n\nOh, take me, take me, take me\nI'm your plaything now (oooh)\n\nYou make my life worthwhile with the slightest smile\nOr destroy me with a barely perceptible whisper\n\nGently take me, remember I'll be dreamin' of my baby\nAt the dreamer's ball\nOh, take me, hold me\nRemember what you told me\nYou'd meet me at the dreamer's ball\nI'll meet you at the dreamer's ball (oooh)";

		System.out.println(dreamersBall);
		System.out.println();

		// Expected Output: [903]
		int [] a = StringMatch.CheckStringMatch(dreamersBall.toCharArray(), "Or destroy me with a barely perceptible whisper".toCharArray());
		if (a != null) Arrays.sort(a);
		System.out.println(Arrays.toString(a));

		// Expected Output: []
		a = StringMatch.CheckStringMatch(dreamersBall.toCharArray(), "asdjke".toCharArray());
		if (a != null) Arrays.sort(a);
		System.out.println(Arrays.toString(a));

		// Expected Output: [358, 415, 694, 985, 1012, 1095, 1131]
		a = StringMatch.CheckStringMatch(dreamersBall.toCharArray(), "dream".toCharArray());
		if (a != null) Arrays.sort(a);
		System.out.println(Arrays.toString(a));
	}
}
