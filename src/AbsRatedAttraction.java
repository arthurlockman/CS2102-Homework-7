public abstract class AbsRatedAttraction extends AbsAttraction implements IRatedAttraction
{
	private int rating;

	AbsRatedAttraction(String name, int street, int ave, int rating)
	{
		super(name, street, ave);
		this.rating = rating;
	}

	@Override
	public boolean highlyRated()
	{
		return (rating == 4 || rating == 5);
	}

	@Override
	public void setRating(int rating)
	{
		this.rating = rating;
	}

	@Override
	public int hashCode()
	{
		int result = 31;
		int c = 0;

		c += (int)this.getAve() + (int)this.getStreet();
		c += this.getName().hashCode();
		c += (int)rating;

		result = 37 * result + c;

		return result;
	}
}
