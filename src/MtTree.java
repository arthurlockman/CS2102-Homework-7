import java.util.LinkedList;

public class MtTree implements IAttractionTree
{
	MtTree() { }

	@Override
	public IAttraction getData()
	{
		return null;
	}

	@Override
	public IAttractionTree getLeft()
	{
		return null;
	}

	@Override
	public IAttractionTree getRight()
	{
		return null;
	}

	@Override
	public IAttractionTree addElt(IAttraction elt)
	{
		return null;
	}

	@Override
	public boolean lessThan(IAttraction other)
	{
		return false;
	}

	@Override
	public boolean containsAny(ISelect s)
	{
		return false;
	}

	@Override
	public boolean allAre(ISelect s)
	{
		return true;
	}

	@Override
	public LinkedList<AbsAttraction> filter(ISelect s)
	{
		return new LinkedList<AbsAttraction>();
	}
}
