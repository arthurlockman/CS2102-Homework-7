public class Museum extends AbsAttraction
{
	private int admissionFee;

	Museum(String name, int street, int ave, int admissionFee)
	{
		super(name, street, ave);
		this.admissionFee = admissionFee;
	}

	public void setAdmissionFee(int admissionFee)
	{
		this.admissionFee = admissionFee;
	}

	public int getAdmissionFee()
	{
		return admissionFee;
	}
}
