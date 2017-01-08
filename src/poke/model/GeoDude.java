package poke.model;
public class GeoDude extends Pokemon implements Rock
{
	public GeoDude()
	{
		super(10, 5, 1.2, "GeoDude", 2);
	}

	public int Smash()
	{
		return super.getAttackPoints()+2;
	}

	public int Drip()
	{
		return super.getAttackPoints()+1;
	}

}
