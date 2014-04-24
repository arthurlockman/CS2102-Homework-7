/**
 * @author Arthur Lockman | ajlockman | CS 2102 D14 | Section D02
 * @author Erin Ferguson | eeferguson | CS 2102 D14 | Section D02
 */

import tester.Tester;

import java.util.LinkedList;

public class Examples
{
	private Museum m_met = new Museum("Met", 33, 5, 0);
	private Museum m_moma = new Museum("MoMa", 15, 6, 10);
	private Museum m_natHist = new Museum("Natural History", 4, 7, 20);
	private Restaurant r_olive = new Restaurant("Olive Garden", 30, 6, 5);
	private Restaurant r_bertucci = new Restaurant("Bertuccis", 30, 7, 3);
	private Restaurant r_dominos = new Restaurant("Domino's", 5, 5, 4);
	private Hotel h_marriott = new Hotel("Marriott", 30, 32, 5);
	private Hotel h_hilton = new Hotel("Hilton", 3, 2, 3);
	private Hotel h_doubleTree = new Hotel("DoubleTree", 4, 7, 2);

	private AttractionTree fullTree = new AttractionTree(m_met, new AttractionTree(m_moma,
			new AttractionTree(r_olive), new AttractionTree(r_bertucci,
			new AttractionTree(h_hilton), new AttractionTree(h_doubleTree))),
			new AttractionTree(m_natHist, new AttractionTree(r_dominos), new AttractionTree(h_marriott)));

	private AttractionTree thirtyTree = new AttractionTree(r_olive, new AttractionTree(h_marriott),
			new AttractionTree(r_bertucci));

	private AttractionTree highRatedTree = new AttractionTree(r_olive, new AttractionTree(r_dominos),
			new AttractionTree(h_marriott));

	private AttractionTree lowRatedtree = new AttractionTree(r_bertucci, new AttractionTree(h_hilton),
			new AttractionTree(h_doubleTree));

	Examples()
	{

	}

	/**
	 * Tests if the containsAny method works properly.
	 * @param t The tester.
	 * @return Whether or not the test passed.
	 */
	boolean testContainsAny(Tester t)
	{
		return t.checkExpect(fullTree.containsAny(new LocatedAbove(30)), true) &&
				t.checkExpect(fullTree.containsAny(new LocatedAbove(100)), false) &&
				t.checkExpect(thirtyTree.containsAny(new LocatedAbove(31)), false) &&
				t.checkExpect(thirtyTree.containsAny(new LocatedAbove(30)), true) &&
				t.checkExpect(highRatedTree.containsAny(new TopRated()), true) &&
				t.checkExpect(fullTree.containsAny(new TopRated()), true) &&
				t.checkExpect(thirtyTree.containsAny(new TopRated()), true) &&
				t.checkExpect(lowRatedtree.containsAny(new TopRated()), false);
	}

	/**
	 * Tests if the allAre method works properly.
	 * @param t The tester.
	 * @return Whether or not the test passed.
	 */
	boolean testAllAre(Tester t)
	{
		return t.checkExpect(fullTree.allAre(new LocatedAbove(30)), false) &&
				t.checkExpect(fullTree.allAre(new LocatedAbove(100)), false) &&
				t.checkExpect(thirtyTree.allAre(new LocatedAbove(30)), true) &&
				t.checkExpect(fullTree.allAre(new TopRated()), false) &&
				t.checkExpect(highRatedTree.allAre(new TopRated()), true) &&
				t.checkExpect(lowRatedtree.allAre(new TopRated()), false);
	}

	/**
	 * Tests if the filter method works properly.
	 * @param t The tester.
	 * @return Whether or not the test passed.
	 */
	boolean testFilter(Tester t)
	{
		boolean resultBool = true;

		LinkedList<AbsAttraction> fullFilter = fullTree.filter(new TopRated());
		LinkedList<AbsAttraction> highFilter = highRatedTree.filter(new TopRated());
		LinkedList<AbsAttraction> lowFilter = lowRatedtree.filter(new TopRated());
		LinkedList<AbsAttraction> thirtyFilter = thirtyTree.filter(new LocatedAbove(30));
		LinkedList<AbsAttraction> thirtyMtFilter = thirtyTree.filter(new LocatedAbove(31));

		for(AbsAttraction a : fullFilter)
		{
			t.checkExpect(a.accept(new TopRated()), true);
			resultBool = resultBool && a.accept(new TopRated());
		}

		for(AbsAttraction a : highFilter)
		{
			t.checkExpect(a.accept(new TopRated()), true);
			resultBool = resultBool && a.accept(new TopRated());
		}

		for(AbsAttraction a : thirtyFilter)
		{
			t.checkExpect(a.accept(new LocatedAbove(30)), true);
			resultBool = resultBool && a.accept(new LocatedAbove(30));
		}

		t.checkExpect(lowFilter.isEmpty(), true);
		t.checkExpect(thirtyMtFilter.isEmpty(), true);
		t.checkExpect(fullFilter.isEmpty(), false);
		t.checkExpect(highFilter.isEmpty(), false);
		t.checkExpect(thirtyFilter.isEmpty(), false);

		return resultBool;
	}
}
