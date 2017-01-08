package poke.model;
public class Pidgey extends Pokemon implements Flying
{
	public Pidgey()
	{
		super(5, 6, 6.7, "Pidgey", 3);
	}

	public int Flap()
	{
		
		return super.getAttackPoints()-1;
	}

	public int Glide()
	{
		return super.getAttackPoints()+1;
	}
}
