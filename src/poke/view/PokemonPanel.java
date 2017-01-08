package poke.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

import poke.controller.PokemonController;
import poke.model.Pokemon;

import java.util.Random;

public class PokemonPanel extends JPanel
{
	private PokemonController baseController;
	private SpringLayout baseLayout;
	private JButton updateButton;
	private JComboBox pokedexSelector;
	private JLabel healthLabel;
	private JLabel combatLabel;
	private JLabel speedLabel;
	private JLabel nameLabel;
	private JLabel numberLabel;
	private JLabel advancedLabel;
	private JLabel pokemonLabel;
	private JTextField healthField;
	private JTextField combatField;
	private JTextField speedField;
	private JTextField nameField;
	private JTextField numberField;
	private JTextArea advancedArea;

	public PokemonPanel(PokemonController baseController)
	{
		// String[] names = new String[pokemons.length];
		// for(int pos = 0; pos<pokemons.length; pos++)
		// {
		// names[pos] = pokemons[pos].getName();
		// }
		this.baseController = baseController;
		this.baseLayout = new SpringLayout();
		this.updateButton = new JButton();
		for (int index = 0; index < baseController.getPokedex().size(); index++)
		{

		}
		this.pokedexSelector = new JComboBox(baseController.pokeToName(baseController.getPokedex()));
		this.healthLabel = new JLabel("Health:");
		this.combatLabel = new JLabel("Attack:");
		this.speedLabel = new JLabel("Speed:");
		this.nameLabel = new JLabel("Name:");
		this.numberLabel = new JLabel("Number:");
		this.advancedLabel = new JLabel("Types:");
		this.pokemonLabel = new JLabel("picture");
		this.healthField = new JTextField(5);
		this.combatField = new JTextField(5);
		this.speedField = new JTextField(5);
		this.nameField = new JTextField(25);
		this.numberField = new JTextField(5);
		this.advancedArea = new JTextArea(10, 25);
		this.updateButton = new JButton("Set");
		setupPanel();
		setupLayout();
		setupListeners();
		viewChanged();

	}

	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setPreferredSize(new Dimension(900, 600));
		this.add(updateButton);
		this.add(pokedexSelector);
		this.add(healthLabel);
		this.add(combatLabel);
		this.add(speedLabel);
		this.add(nameLabel);
		this.add(numberLabel);
		this.add(advancedLabel);
		this.add(pokemonLabel);
		this.add(healthField);
		this.add(combatField);
		this.add(speedField);
		this.add(nameField);
		numberField.setEditable(false);
		this.add(numberField);
		advancedArea.setEditable(false);
		this.add(advancedArea);
	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.SOUTH, updateButton, -24, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, updateButton, -31, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, pokedexSelector, 45, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, pokedexSelector, 50, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, healthLabel, 0, SpringLayout.WEST, combatLabel);
		baseLayout.putConstraint(SpringLayout.SOUTH, healthLabel, -34, SpringLayout.NORTH, combatLabel);
		baseLayout.putConstraint(SpringLayout.EAST, speedLabel, -370, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, combatLabel, 0, SpringLayout.WEST, speedLabel);
		baseLayout.putConstraint(SpringLayout.SOUTH, combatLabel, -34, SpringLayout.NORTH, speedLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, nameLabel, 85, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, nameLabel, 0, SpringLayout.EAST, healthLabel);
		baseLayout.putConstraint(SpringLayout.SOUTH, numberLabel, -34, SpringLayout.NORTH, healthLabel);
		baseLayout.putConstraint(SpringLayout.EAST, numberLabel, 0, SpringLayout.EAST, healthLabel);
		baseLayout.putConstraint(SpringLayout.SOUTH, speedLabel, -37, SpringLayout.NORTH, advancedLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, pokemonLabel, 0, SpringLayout.NORTH, speedLabel);
		baseLayout.putConstraint(SpringLayout.WEST, pokemonLabel, 170, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, healthField, -6, SpringLayout.NORTH, healthLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, combatField, -6, SpringLayout.NORTH, combatLabel);
		baseLayout.putConstraint(SpringLayout.EAST, combatField, 0, SpringLayout.EAST, healthField);
		baseLayout.putConstraint(SpringLayout.NORTH, speedField, -6, SpringLayout.NORTH, speedLabel);
		baseLayout.putConstraint(SpringLayout.EAST, speedField, 0, SpringLayout.EAST, healthField);
		baseLayout.putConstraint(SpringLayout.WEST, healthField, 0, SpringLayout.WEST, nameField);
		baseLayout.putConstraint(SpringLayout.NORTH, nameField, -6, SpringLayout.NORTH, nameLabel);
		baseLayout.putConstraint(SpringLayout.EAST, nameField, 0, SpringLayout.EAST, updateButton);
		baseLayout.putConstraint(SpringLayout.NORTH, numberField, -6, SpringLayout.NORTH, numberLabel);
		baseLayout.putConstraint(SpringLayout.EAST, numberField, 0, SpringLayout.EAST, healthField);
		baseLayout.putConstraint(SpringLayout.NORTH, advancedLabel, 0, SpringLayout.NORTH, advancedArea);
		baseLayout.putConstraint(SpringLayout.EAST, advancedLabel, -39, SpringLayout.WEST, advancedArea);
		baseLayout.putConstraint(SpringLayout.SOUTH, advancedArea, -49, SpringLayout.NORTH, updateButton);
		baseLayout.putConstraint(SpringLayout.EAST, advancedArea, 0, SpringLayout.EAST, updateButton);
	}

	private void setupListeners()
	{
		pokedexSelector.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				viewChanged();
			}

		});
		updateButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				int health = baseController.getCurrentPokemon(pokedexSelector.getSelectedIndex()).getHitPoints();
				int attack = baseController.getCurrentPokemon(pokedexSelector.getSelectedIndex()).getAttackPoints();
				double speed = baseController.getCurrentPokemon(pokedexSelector.getSelectedIndex()).getSpeed();
				if (toInteger(healthField.getText()) != null)
				{
					health = toInteger(healthField.getText()).intValue();
				}
				if (toInteger(combatField.getText()) != null)
				{
					attack = toInteger(combatField.getText()).intValue();
				}
				if (toDouble(speedField.getText()) != null)
				{
					speed = toDouble(speedField.getText()).doubleValue();
				}
				baseController.updateSelected(pokedexSelector.getSelectedIndex(), nameField.getText(), health, attack, speed);

				remove(pokedexSelector);
				pokedexSelector = new JComboBox(baseController.pokeToName(baseController.getPokedex()));
				pokedexSelector.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0)
					{
						viewChanged();
					}
				});
				add(pokedexSelector);
				setupLayout();
				repaint();
				validate();

			}

		});

	}

	private void viewChanged()
	{
		healthField.setText(Integer.toString(baseController.getCurrentPokemon(pokedexSelector.getSelectedIndex()).getHitPoints()));
		combatField.setText(Integer.toString(baseController.getCurrentPokemon(pokedexSelector.getSelectedIndex()).getAttackPoints()));
		speedField.setText(Double.toString(baseController.getCurrentPokemon(pokedexSelector.getSelectedIndex()).getSpeed()));
		nameField.setText(baseController.getCurrentPokemon(pokedexSelector.getSelectedIndex()).getName());
		numberField.setText(Integer.toString(baseController.getCurrentPokemon(pokedexSelector.getSelectedIndex()).getNumber()));
		advancedArea.setText(baseController.getCurrentPokemon(pokedexSelector.getSelectedIndex()).getTypes());
		System.out.println("hi");
		System.out.println(baseController.getCurrentPokemon(pokedexSelector.getSelectedIndex()).getName());
		System.out.println("resources/"+baseController.getCurrentPokemon(pokedexSelector.getSelectedIndex()).getName()+".png");
		this.remove(pokemonLabel);
		pokemonLabel = new JLabel(new ImageIcon(getClass().getResource(baseController.getCurrentPokemon(pokedexSelector.getSelectedIndex()).getPictureAdress())));
		this.add(pokemonLabel);
		setupLayout();
		repaint();
		validate();


	}

	private void setRandomColor()
	{
		Random rand = new Random();
		this.setBackground(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
	}

	private Integer toInteger(String input)
	{
		Integer output;
		try
		{
			output = Integer.parseInt(input);
		} catch (NumberFormatException exceptioin)
		{
			output = null;
		}
		return output;
	}

	private Double toDouble(String input)
	{
		Double output;
		try
		{
			output = Double.parseDouble(input);
		} catch (NumberFormatException exceptioin)
		{
			output = null;
		}
		return output;
	}
}
