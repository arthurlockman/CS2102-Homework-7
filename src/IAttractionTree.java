import java.util.LinkedList;

public interface IAttractionTree
{
	public IAttraction getData();
	public IAttractionTree getLeft();
	public IAttractionTree getRight();
	public IAttractionTree addElt(IAttraction elt);
	public boolean lessThan(IAttraction other);
	boolean containsAny(ISelect s);
	boolean allAre(ISelect s);
	LinkedList<AbsAttraction> filter(ISelect s);
}
