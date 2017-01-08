package poke.controller;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JFrame;

import poke.model.*;
import poke.view.PokemonFrame;

public class PokemonController
{
	private ArrayList<Pokemon> pokeDex;
	private PokemonFrame baseFrame;
	public PokemonController()
	{
		pokeDex = new ArrayList<Pokemon>();
		buildPokeDex();
		baseFrame = new PokemonFrame(this);
	}
	public void start()
	{

		
		
	}
	private void buildPokeDex()
	{
		pokeDex.add(new PikaChu());
		pokeDex.add(new GeoDude());
		pokeDex.add(new Pidgey());
		pokeDex.add(new Boldore());
		pokeDex.add(new Zapdos());
		pokeDex.add(new Zapdos());
	}
	
	public Pokemon getCurrentPokemon(int index)
	{
		return pokeDex.get(index);
	}
	public void updateSelected(int index, String name, int health, int attack, double speed)
	{
		Pokemon currentPokemon = pokeDex.get(index);
		currentPokemon.setName(name);
		currentPokemon.setHealth(health);
		currentPokemon.setAttack(attack);
		currentPokemon.setSpeed(speed);
	}
	public ArrayList<Pokemon> getPokedex()
	{
		return pokeDex;
	}
	public JFrame getBaseFrame()
	{
		// TODO Auto-generated method stub
		return baseFrame;
	}
	public String[] pokeToName(ArrayList<Pokemon> currentPokeDex)
	{
		String [] names = new String[currentPokeDex.size()];
		for(int index = 0;index<currentPokeDex.size(); index++)
		{
			names[index] = currentPokeDex.get(index).getName();
		}
		return names;
	}
	{
		
	}
	
}
