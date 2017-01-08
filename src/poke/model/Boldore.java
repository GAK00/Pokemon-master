package poke.model;
public class Boldore extends Pokemon implements Rock
{
	
	public Boldore()
	{
		super(10, 3, 4.5, "Boldore", 1);
	}

	public int Smash()
	{
		
		return super.getHitPoints()+2;
	}

	public int Drip()
	{
		
		return super.getHitPoints()+1;
	}

}
