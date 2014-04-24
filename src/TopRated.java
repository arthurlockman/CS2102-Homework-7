public class TopRated implements ISelect
{
	TopRated() {}

	@Override
	public boolean choose(AbsRatedAttraction ratedAttraction)
	{
		return ratedAttraction.highlyRated();
	}

	@Override
	public boolean choose(AbsAttraction attraction)
	{
		return false;
	}
}
