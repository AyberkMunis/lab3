package diet;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Represents a complete menu.
 * 
 * It can be made up of both packaged products and servings of given recipes.
 *
 */
public class Menu implements NutritionalElement {

	/**
	 * Adds a given serving size of a recipe.
	 * The recipe is a name of a recipe defined in the {@code food}
	 * argument of the constructor.
	 * 
	 * @param recipe the name of the recipe to be used as ingredient
	 * @param quantity the amount in grams of the recipe to be used
	 * @return the same Menu to allow method chaining
	 */
	public Food food;
	public String name;
	public ArrayList<String> products=new ArrayList();
	public HashMap<String,Double> recipies=new HashMap<>();
    public Menu addRecipe(String recipe, double quantity) {
		recipies.put(recipe, quantity);
		return this;
	}

	public Menu(Food food, String name) {
		this.food = food;
		this.name = name;
	}

	/**
	 * Adds a unit of a packaged product.
	 * The product is a name of a product defined in the {@code food}
	 * argument of the constructor.
	 * 
	 * @param product the name of the product to be used as ingredient
	 * @return the same Menu to allow method chaining
	 */
    public Menu addProduct(String product) {
		products.add(product);
		return this;
	}

	@Override
	public String getName() {
		return this.name;
	}

	/**
	 * Total KCal in the menu
	 */
	@Override
	public double getCalories() {
		double sum=0;
		for(String key:recipies.keySet()){
			NutritionalElement x=food.getRecipe(key);
			sum+=x.getCalories()*(recipies.get(key)/100);


		}
		for(String key:products){
			NutritionalElement x=food.getProduct(key);
			sum+=x.getCalories();


		}
		return sum;
	}

	/**
	 * Total proteins in the menu
	 */
	@Override
	public double getProteins() {
		double sum=0;
		for(String key:recipies.keySet()){
			NutritionalElement x=food.getRecipe(key);
			sum+=x.getProteins()*(recipies.get(key)/100);


		}
		for(String key:products){
			NutritionalElement x=food.getProduct(key);
			sum+=x.getProteins();


		}
		return sum;
	}

	/**
	 * Total carbs in the menu
	 */
	@Override
	public double getCarbs() {
		double sum=0;
		for(String key:recipies.keySet()){
			NutritionalElement x=food.getRecipe(key);
			sum+=x.getCarbs()*(recipies.get(key)/100);


		}
		for(String key:products){
			NutritionalElement x=food.getProduct(key);
			sum+=x.getCarbs();


		}
		return sum;
	}

	/**
	 * Total fats in the menu
	 */
	@Override
	public double getFat() {
		double sum=0;
		for(String key:recipies.keySet()){
			NutritionalElement x=food.getRecipe(key);
			sum+=x.getFat()*(recipies.get(key)/100);


		}
		for(String key:products){
			NutritionalElement x=food.getProduct(key);
			sum+=x.getFat();


		}
		return sum;
	}

	/**
	 * Indicates whether the nutritional values returned by the other methods
	 * refer to a conventional 100g quantity of nutritional element,
	 * or to a unit of element.
	 * 
	 * For the {@link Menu} class it must always return {@code false}:
	 * nutritional values are provided for the whole menu.
	 * 
	 * @return boolean indicator
	 */
	@Override
	public boolean per100g() {
		return false;
	}
}