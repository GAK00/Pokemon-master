package poke.view;

import javax.swing.JFrame;

import poke.controller.PokemonController;

public class PokemonFrame extends JFrame
{
private PokemonController baseController;
private PokemonPanel panel;
	public PokemonFrame(PokemonController pokemonController)
	{
		baseController = pokemonController;
		this.panel = new PokemonPanel(baseController);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setup();
	}
	private void setup()
	{
		this.setTitle("Pokemon");
		this.setSize(this.getMaximumSize());
		this.setContentPane(panel);
		this.setVisible(true);
	}	
}
