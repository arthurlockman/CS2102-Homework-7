public interface IAttraction
{
	String getName();
	int getStreet();
	int getAve();
	void setAddress(int street, int ave);
	void setName(String name);
	boolean lessThan(IAttraction other);
	boolean accept(ISelect selecter);
}
