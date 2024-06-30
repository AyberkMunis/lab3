package diet;

import java.lang.invoke.VarHandle.AccessMode;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a recipe of the diet.
 * 
 * A recipe consists of a a set of ingredients that are given amounts of raw materials.
 * The overall nutritional values of a recipe can be computed
 * on the basis of the ingredients' values and are expressed per 100g
 * 
 *
 */
public class Recipe implements NutritionalElement  {
	
	/**
	 * Adds the given quantity of an ingredient to the recipe.
	 * The ingredient is a raw material.
	 * 
	 * @param material the name of the raw material to be used as ingredient
	 * @param quantity the amount in grams of the raw material to be used
	 * @return the same Recipe object, it allows method chaining.
	 */

	public String name;
	public Food food;
	public HashMap<String,Double> ingredients=new HashMap<>();
	public Recipe(String name, Food food) {
		this.name = name;
		this.food = food;
	}

	
	public Recipe addIngredient(String material, double quantity) {
		ingredients.put(material, quantity);
		return this;
	}

	@Override
	public String getName() {
		return this.name;
	}

	
	@Override
	public double getCalories() {
		double sum=0;
		for(String key:ingredients.keySet()){
			NutritionalElement x=food.getRawMaterial(key);
			sum+=x.getCalories()*(ingredients.get(key)/100);


		}
		return sum;
	}
	

	@Override
	public double getProteins() {
		double sum=0;
		for(String key:ingredients.keySet()){
			NutritionalElement x=food.getRawMaterial(key);
			sum+=x.getProteins()*(ingredients.get(key)/100);


		}
		return sum;
	}

	@Override
	public double getCarbs() {
		double sum=0;
		for(String key:ingredients.keySet()){
			NutritionalElement x=food.getRawMaterial(key);
			sum+=x.getCarbs()*(ingredients.get(key)/100);


		}
		return sum;
	}

	@Override
	public double getFat() {
		double sum=0;
		for(String key:ingredients.keySet()){
			NutritionalElement x=food.getRawMaterial(key);
			sum+=x.getFat()*(ingredients.get(key)/100);


		}
		return sum;
	}

	/**
	 * Indicates whether the nutritional values returned by the other methods
	 * refer to a conventional 100g quantity of nutritional element,
	 * or to a unit of element.
	 * 
	 * For the {@link Recipe} class it must always return {@code true}:
	 * a recipe expresses nutritional values per 100g
	 * 
	 * @return boolean indicator
	 */
	@Override
	public boolean per100g() {
		return true;
	}
	
}
