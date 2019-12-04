// Devon Gadarowski 2019

import java.util.Arrays;

public class Lateralus
{
	public static void main(String [] args)
	{
		String lateralus = "Black\nThen\nWhite are\nAll I see\nIn my infancy\nRed and yellow then came to be\nReaching out to me\nLets me see\n\nAs below so above and beyond I imagine\nDrawn beyond the lines of reason\nPush the envelope\nWatch it bend\n\nOver thinking, over analyzing, separates the body from the mind\nWithering my intuition, missing opportunities and I must\n\nFeed my will to feel my moment\nDrawing way outside the lines\n\nBlack\nThen\nWhite are\nAll I see\nIn my infancy\nRed and yellow then came to be\nReaching out to me\nLets me see\n\nThere is\nSo\nMuch\nMore and\nBeckons me\nTo look through to these\nInfinite possibilities\n\nAs below so above and beyond I imagine\nDrawn outside the lines of reason\nPush the envelope\nWatch it bend\n\nOver thinking, over analyzing, separates the body from the mind\nWithering my intuition, leaving opportunities behind\n\nFeed my will to feel this moment\nUrging me to cross the line\nReaching out to embrace the random\nReaching out to embrace whatever may come\n\nI embrace my desire to\nI embrace my desire to\nFeel the rhythm\nTo feel connected\nEnough to step aside and\nWeep like a widow\nTo feel inspired\nTo fathom the power\nTo witness the beauty\nTo bathe in the fountain\nTo swing on the spiral\nTo swing on the spiral\nTo swing on the spiral\nOf our divinity and\nStill be a human\n\nWith my feet upon the ground\nI lose myself between the sounds\nAnd open wide to suck it in\nI feel it move across my skin\nI'm reaching up and reaching out\nI'm reaching for the random or\nWhatever will bewilder me\nWhatever will bewilder me\nAnd following our will and wind\nWe may just go where no one's been\nWe'll ride the spiral to the end\nAnd may just go where no one's been\nSpiral out, keep going\nSpiral out, keep going\nSpiral out, keep going\nSpiral out, keep going";

		System.out.println(lateralus);
		System.out.println();

		// Expected Output: [1640, 1663, 1686, 1709]
		int [] a = StringMatch.CheckStringMatch(lateralus.toCharArray(), "Spiral out".toCharArray());
		if (a != null) Arrays.sort(a);
		System.out.println(Arrays.toString(a));

		// Expected Output: []
		a = StringMatch.CheckStringMatch(lateralus.toCharArray(), "ed and yellow then came to be\nReaching out to me\nLets me see\n\nThere is\nSo\nMuch\nMore and\nBeckons me\nTo look through to these\nInfinite possibilities\n\nAs below so above and beyond I imagine\nDrawn outside the lines of reason\nPush the envelope\nWatch it bend\n\nOver thinking, over analyzing, separates the body from the mind\nWithering my intuition, leaving opportuni sike".toCharArray());
		if (a != null) Arrays.sort(a);
		System.out.println(Arrays.toString(a));
	}
}
