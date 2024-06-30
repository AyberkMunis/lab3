package diet;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.ArrayList;
import diet.rawmat;
import diet.product;
/**
 * Facade class for the diet management.
 * It allows defining and retrieving raw materials and products.
 *
 */

public class Food {

	/**
	 * Define a new raw material.
	 * The nutritional values are specified for a conventional 100g quantity
	 * @param name unique name of the raw material
	 * @param calories calories per 100g
	 * @param proteins proteins per 100g
	 * @param carbs carbs per 100g
	 * @param fat fats per 100g
	 */
	public Collection<NutritionalElement> rawmats=new ArrayList<>();
	public Collection<NutritionalElement> pro=new ArrayList<>();
	public Collection<NutritionalElement> recipeelist=new ArrayList<>();
	public void defineRawMaterial(String name, double calories, double proteins, double carbs, double fat) {
		List<NutritionalElement> names=rawmats.stream().filter(x -> x.equals(name)).collect(Collectors.toList());
		if(names.contains(name)){
			return;
		}
		rawmat newob= new rawmat(name, calories, proteins, carbs, fat);
		rawmats.add(newob);






	}

	/**
	 * Retrieves the collection of all defined raw materials
	 * @return collection of raw materials though the {@link NutritionalElement} interface
	 */
	public Collection<NutritionalElement> rawMaterials() {

		return rawmats;
	}

	/**
	 * Retrieves a specific raw material, given its name
	 * @param name  name of the raw material
	 * @return  a raw material though the {@link NutritionalElement} interface
	 */
	public NutritionalElement getRawMaterial(String name) {
		NutritionalElement x=rawmats.stream().filter(a->a.getName().equals(name)).findFirst().orElse(null);
		return x;
	}

	/**
	 * Define a new packaged product.
	 * The nutritional values are specified for a unit of the product
	 * @param name unique name of the product
	 * @param calories calories for a product unit
	 * @param proteins proteins for a product unit
	 * @param carbs carbs for a product unit
	 * @param fat fats for a product unit
	 */
	public void defineProduct(String name, double calories, double proteins, double carbs, double fat) {
		List<NutritionalElement> names=pro.stream().filter(x -> x.equals(name)).collect(Collectors.toList());
		if(names.contains(name)){
			return;
		}
		product newob= new product(name, calories, proteins, carbs, fat);
		pro.add(newob);
	}

	/**
	 * Retrieves the collection of all defined products
	 * @return collection of products though the {@link NutritionalElement} interface
	 */
	public Collection<NutritionalElement> products() {
		return pro;
	}

	/**
	 * Retrieves a specific product, given its name
	 * @param name  name of the product
	 * @return  a product though the {@link NutritionalElement} interface
	 */
	public NutritionalElement getProduct(String name) {
		NutritionalElement x=pro.stream().filter(a->a.getName().equals(name)).findAny().orElse(null);
		return x;
	}

	/**
	 * Creates a new recipe stored in this Food container.
	 *  
	 * @param name name of the recipe
	 * @return the newly created Recipe object
	 */
	public Recipe createRecipe(String name) {
		Recipe r=new Recipe(name, this);
		recipeelist.add(r);

		return r;
	}
	
	/**
	 * Retrieves the collection of all defined recipes
	 * @return collection of recipes though the {@link NutritionalElement} interface
	 */
	public Collection<NutritionalElement> recipes() {
		return recipeelist;
	}

	/**
	 * Retrieves a specific recipe, given its name
	 * @param name  name of the recipe
	 * @return  a recipe though the {@link NutritionalElement} interface
	 */
	public NutritionalElement getRecipe(String name) {
		NutritionalElement r=recipeelist.stream().filter(x->x.getName().equals(name)).findAny().orElse(null);
		return r;
	}

	/**
	 * Creates a new menu
	 * 
	 * @param name name of the menu
	 * @return the newly created menu
	 */
	public Menu createMenu(String name) {
		Menu mnew=new Menu(this,name);
		return mnew;
	}
}