public abstract class AbsAttraction implements IAttraction
{
	private int street, ave;
	private String name;

	AbsAttraction(String name, int street, int ave)
	{
		this.street = street;
		this.ave = ave;
		this.name = name;
	}

	@Override
	public String getName()
	{
		return name;
	}

	@Override
	public int getStreet()
	{
		return street;
	}

	@Override
	public int getAve()
	{
		return ave;
	}

	@Override
	public void setAddress(int street, int ave)
	{
		this.ave = ave;
		this.street = street;
	}

	@Override
	public void setName(String name)
	{
		this.name = name;
	}

	public boolean equals(Object other)
	{
		return this.hashCode() == other.hashCode();
	}

	@Override
	public boolean accept(ISelect selecter)
	{
		return selecter.choose(this);
	}

	@Override
	public int hashCode()
	{
		int result = 43;
		int c = 0;

		c += (int)ave + (int)street;
		c += name.hashCode();

		result = 37 * result + c;

		return result;
	}

	public boolean lessThan(IAttraction other)
	{
		return this.getName().compareToIgnoreCase(other.getName()) < 0;
	}
}
