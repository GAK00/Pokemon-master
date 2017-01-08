package poke.model;
public class PikaChu extends Pokemon implements Electric
{

	public PikaChu()
	{
		super(3, 22, 10.9, "PikaChu", 4);
	}

	public int Shock()
	{
		return super.getAttackPoints();
	}

	public int Zap()
	{
		return super.getAttackPoints()*2;
	}

}
