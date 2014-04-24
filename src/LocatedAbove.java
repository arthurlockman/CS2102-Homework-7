public class LocatedAbove implements ISelect
{
	private int street;

	LocatedAbove(int street)
	{
		this.street = street;
	}

	@Override
	public boolean choose(AbsRatedAttraction ratedAttraction)
	{
		return ratedAttraction.getStreet() == street;
	}

	@Override
	public boolean choose(AbsAttraction attraction)
	{
		return attraction.getStreet() == street;
	}
}
