package poke.model;
public class Zapdos extends Pokemon implements Electric, Flying 
{

	public Zapdos()
	{
		super(30, 1, 1, "Zapdos", 5);
	}

	public int Flap()
	{
		return super.getAttackPoints();
	}

	public int Glide()
	{
		return super.getAttackPoints();
	}

	public int Shock()
	{
		return super.getAttackPoints();
	}

	public int Zap()
	{
		return super.getAttackPoints();
	}

}
