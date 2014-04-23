import java.util.LinkedList;

public class AttractionTree implements IAttractionTree
{
	private IAttraction data;
	private IAttractionTree left, right;

	AttractionTree(IAttraction data, IAttractionTree left, IAttractionTree right)
	{
		this.data = data;
		this.left = left;
		this.right = right;
	}

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
		if (this.data.equals(elt))
			return this;
		else if (elt.lessThan(this.data))
			return new AttractionTree(this.data, this.left.addElt(elt), this.right);
		else
			return new AttractionTree(this.data, this.left, this.right.addElt(elt));
	}

	@Override
	public boolean lessThan(IAttraction other)
	{
		return data.lessThan(other);
	}

	@Override
	public boolean containsAny(ISelect s)
	{
		return false;
	}

	@Override
	public boolean allAre(ISelect s)
	{
		return false;
	}

	@Override
	public LinkedList<AbsAttraction> filter(ISelect s)
	{
		return null;
	}
}
